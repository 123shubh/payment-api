package com.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.payment.entity.UPI;

@Repository
public interface UPIRepository extends JpaRepository<UPI, String> {

	public UPI findByUpiId(String upiId);

}
