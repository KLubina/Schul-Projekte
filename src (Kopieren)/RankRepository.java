package com.example.jwt.domain.rank;

import com.example.jwt.core.generic.ExtendedRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RankRepository extends ExtendedRepository<Rank> {
    Optional<Rank> findByTitle(String title);
    Optional<Rank> findFirstBySeedsNeededLessThanEqualOrderBySeedsNeededDesc(int seeds);
}