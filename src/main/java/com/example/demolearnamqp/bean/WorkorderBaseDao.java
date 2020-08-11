package com.example.demolearnamqp.bean;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkorderBaseDao extends JpaRepository<WorkOrder, Long> {
}
