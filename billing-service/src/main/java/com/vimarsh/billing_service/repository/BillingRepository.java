package com.vimarsh.billing_service.repository;

import com.vimarsh.billing_service.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BillingRepository extends JpaRepository<Bill, UUID> {
}