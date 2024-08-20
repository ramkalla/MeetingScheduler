package com.employees.test.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employees.test.entities.Meeting;
import com.employees.test.entities.Participant;
import com.employees.test.repo.MeetingRepository;
import com.employees.test.repo.ParticipantsRepository;

@Service("meetingService")
public class MeetingService {

	private static Logger log = LoggerFactory.getLogger(MeetingService.class);

	@Autowired
	public MeetingRepository meetingRepo;
	
	@Autowired
	public ParticipantsRepository participantsRepository;
	
	
	public List<Meeting> getConflictMeeting(Long meeting,Long participantId) {
		Optional<Meeting>  newmeeting = meetingRepo.findById(meeting);
	    Participant particpantwithMeetings = participantsRepository.findById(participantId).get();
	    return  particpantwithMeetings.getMeetings().stream()
	    			.filter(k-> (newmeeting.get().getStartTime().after(k.getStartTime()) && newmeeting.get().getStartTime().before(k.getEndTime())
	    					)
	    					||
	    					(newmeeting.get().getEndTime().after(k.getStartTime()) && newmeeting.get().getEndTime().before(k.getEndTime())
	    	    			)
	    					)
	    		.collect(Collectors.toList());
	  }
	

	public Meeting saveMeeting(Meeting meeting) {
		meeting.setCreate_date(new Timestamp(new Date().getTime()));
		return meetingRepo.save(meeting);

	}

	public boolean meetingExists(Long meetingid) {
//		meeting.setCreate_date(new Date());
		return meetingRepo.existsById(meetingid);

	}
	
	public Meeting getMeeting(Long meetingid) {
//		meeting.setCreate_date(new Date());
		return meetingRepo.getById(meetingid);
	}
	
	public Meeting addParticipant(Long meetingId, Long participantId) {
	    Meeting meeting = meetingRepo.findById(meetingId).get();
	    Participant participant = participantsRepository.findById(participantId).get();
	    meeting.getParticipants().add(participant);
	    return meetingRepo.save(meeting);
	  }
	}
	