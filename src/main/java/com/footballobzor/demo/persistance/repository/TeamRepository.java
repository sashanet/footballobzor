package com.footballobzor.demo.persistance.repository;

import com.footballobzor.demo.persistance.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team, String> {
}
