package org.rtroncoso.testnisum.repository;

import org.rtroncoso.testnisum.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PhoneRepo extends JpaRepository<Phone, UUID> {
}
