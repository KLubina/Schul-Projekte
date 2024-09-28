package com.example.jwt.domain.orders;

import com.example.jwt.domain.orders.dto.OrderDTO;
import com.example.jwt.domain.orders.dto.UserOrderDTO;
import com.example.jwt.domain.rank.Rank;
import com.example.jwt.domain.rank.RankRepository;
import com.example.jwt.domain.tea.Tea;
import com.example.jwt.domain.tea.TeaService;
import com.example.jwt.domain.user.User;
import com.example.jwt.domain.user.UserDetailsImpl;
import com.example.jwt.domain.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final TeaService teaService;
    private final UserService userService;
    private final RankRepository rankRepository;

    @Autowired
    public OrderController(OrderService orderService, TeaService teaService, UserService userService, RankRepository rankRepository) {
        this.orderService = orderService;
        this.teaService = teaService;
        this.userService = userService;
        this.rankRepository = rankRepository;
    }

    @PreAuthorize("hasAuthority('CAN_PLACE_ORDER')")
    @PostMapping
    public ResponseEntity<String> createOrder(@Valid @RequestBody OrderDTO orderDTO) {
        // GET USER
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.user();

        // GET THE TEA BY NAME IF NOT THEN INVALIDE TEA
        Optional<Tea> teaOptional = teaService.findByName(orderDTO.getTeaName());
        if (teaOptional.isEmpty()) {
            return ResponseEntity.badRequest().body("Invalid tea name");
        }

        Tea tea = teaOptional.get();

        // IF MEDICAL HERBS THEN USER HAS TO BE ABOVE 18
        if (tea.getTeaType().getName().equalsIgnoreCase("Medical Herbs") && user.getAge() < 18) {
            return ResponseEntity.badRequest().body("You must be at least 18 years old to order Medical Herbs.");
        }

        //CALCULATE PRICE
        int price = (orderDTO.getAmount() * tea.getSellPrice()) / 100;

        // GIVE RANK DISCOUNT
        if (user.getRank() != null) {
            int reduction = user.getRank().getReduction();
            price = price - (price * reduction / 100);
        }

        // GIVE SEEDS FOR EACH 2$ SPENT
        int seedsEarned = price / 2;
        user.setSeeds(user.getSeeds() + seedsEarned);

        // CHECK IF USER HAS THE SEEDS FOR A UPGRADE
        Optional<Rank> nextRank = rankRepository.findFirstBySeedsNeededLessThanEqualOrderBySeedsNeededDesc(user.getSeeds());

        if (nextRank.isPresent() && (user.getRank() == null || user.getRank().getSeedsNeeded() < nextRank.get().getSeedsNeeded())) {
            // UPGRADE RANK
            user.setRank(nextRank.get());
        }

        // SAVE USER WITH UPDATED SEEDS AND MAYBE RANK
        userService.save(user);

        // CREATE THEN SAVE ORDER
        Order order = new Order();
        order.setpId(user.getId());
        order.setTea(tea);
        order.setAmount(orderDTO.getAmount());
        order.setPricePayed(price);
        order.setOrderDate(Date.valueOf(LocalDate.now()));

        orderService.save(order);

        return ResponseEntity.ok("Order created successfully");
    }

    // RETURN USER ORDERS
    @GetMapping("/my-orders")
    @PreAuthorize("hasAuthority('CAN_RETRIEVE_PURCHASE_HISTORY')")
    public List<UserOrderDTO> getUserOrders() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        User user = userDetails.user();

        return orderService.getOrdersForUser(user);
    }
}

