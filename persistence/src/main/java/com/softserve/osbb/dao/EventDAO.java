package com.softserve.osbb.dao;

import com.softserve.osbb.model.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EventDAO extends JpaRepository<EventEntity, Integer> {
}