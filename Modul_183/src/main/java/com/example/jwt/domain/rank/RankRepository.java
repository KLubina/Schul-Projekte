package com.example.jwt.domain.rank;

import com.example.jwt.core.generic.ExtendedRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for managing {@link Rank} entities.
 */
@Repository
public interface RankRepository extends ExtendedRepository<Rank> {

    /**
     * Retrieves a Rank entity based on its title.
     *
     * @param title the title of the Rank to retrieve
     * @return an {@link Optional} containing the found Rank, or empty if not found
     */
    Optional<Rank> findByTitle(String title);

    /**
     * Finds the highest Rank that can be achieved with the given number of seeds.
     *
     * @param seeds the number of seeds accumulated by the user
     * @return an {@link Optional} containing the appropriate Rank if available, otherwise empty
     */
    Optional<Rank> findFirstBySeedsNeededLessThanEqualOrderBySeedsNeededDesc(int seeds);
}
