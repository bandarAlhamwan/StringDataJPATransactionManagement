package com.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.transaction.entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, String>{

}
