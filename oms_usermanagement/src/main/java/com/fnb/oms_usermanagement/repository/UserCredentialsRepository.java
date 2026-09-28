package com.fnb.oms_usermanagement.repository;

import com.fnb.oms_usermanagement.entity.UserCredential;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCredentialsRepository extends JpaRepository<UserCredential, Long> {

    UserCredential findByUser_CustomerId(Long customerId);
}