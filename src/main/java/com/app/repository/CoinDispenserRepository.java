package com.app.repository;

import com.app.entity.CoinDispenserAudit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinDispenserRepository extends JpaRepository<CoinDispenserAudit, String> {}