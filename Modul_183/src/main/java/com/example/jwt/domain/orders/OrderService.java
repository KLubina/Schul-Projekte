package com.example.jwt.domain.orders;

import com.example.jwt.domain.orders.dto.UserOrderDTO;
import com.example.jwt.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public List<UserOrderDTO> getOrdersForUser(User user) {
        List<Order> orders = orderRepository.findBypId(user.getId());

        return orders.stream()
                .map(order -> new UserOrderDTO(
                        order.getId(),
                        order.getTea().getName(),  // Now you can access the Tea name
                        order.getAmount(),
                        order.getPricePayed(),
                        order.getOrderDate()
                ))
                .collect(Collectors.toList());
    }
}
