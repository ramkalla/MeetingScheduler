package com.employees.test.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employees.test.entities.Participant;
import com.employees.test.repo.ParticipantsRepository;

@Service("participantsService")
public class ParticipantsService {

	private static Logger log = LoggerFactory.getLogger(ParticipantsService.class);

	
	
	@Autowired
	public ParticipantsRepository participantsRepository;
	
	public Participant saveParticipant(Participant participant) {
		participant.setCreate_date(new Timestamp(new Date().getTime()));
		return participantsRepository.save(participant);
	}
	public boolean participantExists(Long  participantId) {
		return participantsRepository.existsById(participantId);
	}
	
	public Participant getParticipant(Long  participantId) {
		return participantsRepository.getById(participantId);
	}
	
	public List<Participant> findParticipantwithEmail(String  email) {
		return participantsRepository.findParticipantwithEmail(email);
	}
	
	
	
	
	}
	