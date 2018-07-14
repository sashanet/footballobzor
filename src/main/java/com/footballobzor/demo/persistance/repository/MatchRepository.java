package com.footballobzor.demo.persistance.repository;

import com.footballobzor.demo.persistance.entity.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, String> {
}
