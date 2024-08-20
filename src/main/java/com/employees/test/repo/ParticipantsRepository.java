package com.employees.test.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employees.test.entities.Employee;
import com.employees.test.entities.Meeting;
import com.employees.test.entities.Participant;

@Repository("participantsRepository")
public interface ParticipantsRepository extends JpaRepository<Participant, Long> {

}