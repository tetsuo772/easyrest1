package com.javacodegeeks.enterprise.rest.resteasy;

import java.util.Date;

import com.javacodegeeks.enterprise.rest.constants.MessageType;


public class Msg {
	
	

	private MessageType message_type ; 
	private Date	  timestamp;  
    private Long origin  ; 
    private Long   destination   ; 
    
    private String   message_content ;
    private String   message_status;
    
    
	
	public MessageType getMessage_type() {
		return message_type;
	}



	public void setMessage_type(MessageType message_type) {
		this.message_type = message_type;
	}



	public Date getTimestamp() {
		return timestamp;
	}



	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}



	public Long getOrigin() {
		return origin;
	}



	public void setOrigin(Long origin) {
		this.origin = origin;
	}



	public Long getDestination() {
		return destination;
	}



	public void setDestination(Long destination) {
		this.destination = destination;
	}



	public String getMessage_content() {
		return message_content;
	}



	public void setMessage_content(String message_content) {
		this.message_content = message_content;
	}



	public String getMessage_status() {
		return message_status;
	}



	public void setMessage_status(String message_status) {
		this.message_status = message_status;
	}



	public Msg() {

	}
    
}
