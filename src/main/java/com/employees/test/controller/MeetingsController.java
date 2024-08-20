package com.employees.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employees.test.entities.Meeting;
import com.employees.test.entities.Participant;
import com.employees.test.model.ResponsedataModel;
import com.employees.test.service.MeetingService;
import com.employees.test.service.ParticipantsService;
import com.employees.test.util.ResponseUtility;

@RestController
@RequestMapping("/api")
public class MeetingsController {
  
  @Autowired
  private MeetingService meetingService;
  
  @Autowired
  private ParticipantsService participantsService;
  
  @PostMapping("/meetings")
  public Meeting saveMeeting(@RequestBody Meeting meeting) {
    return meetingService.saveMeeting(meeting);
  }
  
  @PutMapping("/meetings/{meetingId}/participants/{participantId}")
  public ResponseEntity<ResponsedataModel> addParticipant(@PathVariable Long meetingId, @PathVariable Long participantId) {
    if(!meetingService.meetingExists(meetingId)) {
    	return new ResponseUtility().dataNotFound("No Meeting found with the id "+meetingId);
    }
    if(!participantsService.participantExists(participantId)) {
    	return new ResponseUtility().dataNotFound("No Participant found with the id "+participantId);
    }
     List<Meeting>  ConflictMeetings=meetingService.getConflictMeeting(meetingId, participantId);
     ConflictMeetings.forEach(k-> System.out.println("Conflict Meeting with id "+k.getId()));
     if(ConflictMeetings.size()>0) 
           return new ResponseUtility().buildExceptionwithResponseData("Participant is having conflict with the Meeting "+ConflictMeetings.getFirst().getId(),ConflictMeetings);	 
     Meeting  addedMeeting= meetingService.addParticipant(meetingId, participantId);
     return new ResponseUtility().buildSuccessResponse(addedMeeting);
  }
  
  @PostMapping("/participants")
  public ResponseEntity<ResponsedataModel> saveParticipants(@RequestBody Participant participant) {
	  if(!participantsService.findParticipantwithEmail(participant.getEmail()).isEmpty()) {
	    	return new ResponseUtility().dataNotFound("Participant is already registered with the given email address");
	    }
	  	  return new ResponseUtility().buildSuccessResponse(participantsService.saveParticipant(participant));
  }
}
