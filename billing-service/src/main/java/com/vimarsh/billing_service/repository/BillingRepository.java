package com.vimarsh.billing_service.repository;

import com.vimarsh.billing_service.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BillingRepository extends JpaRepository<Bill, UUID> {
}