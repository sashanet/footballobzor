package com.footballobzor.demo.persistance.repository;

import com.footballobzor.demo.persistance.entity.BroadcastEntity;
import com.footballobzor.demo.persistance.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BroadCastRepository extends JpaRepository<BroadcastEntity, String> {
}
