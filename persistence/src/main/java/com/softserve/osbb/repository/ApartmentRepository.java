package com.softserve.osbb.repository;


import com.softserve.osbb.model.ApartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApartmentRepository extends JpaRepository<ApartmentEntity, Integer> {
}