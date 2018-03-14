package com.javacodegeeks.enterprise.rest.resteasy;


import java.io.Serializable;
import java.util.Date;

import com.javacodegeeks.enterprise.rest.constants.MessageType;
import com.javacodegeeks.enterprise.rest.constants.StatusCode;

public class Call  implements Serializable{

	private MessageType message_type ; 
	private Date	  timestamp;  
    private Long origin  ; 
    private Long   destination   ; 
    private int   duration     ;  
    private StatusCode   status_code   ; 
    private String   status_description  ;
    
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
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public StatusCode getStatus_code() {
		return status_code;
	}
	public void setStatus_code(StatusCode status_code) {
		this.status_code = status_code;
	}
	public String getStatus_description() {
		return status_description;
	}
	public void setStatus_description(String status_description) {
		this.status_description = status_description;
	}
 

    
	   //Introducing the dummy constructor
 public Call() {
 }
    
	@Override
	public String toString() {
		return "Call [message_type=" + message_type + ", timestamp=" + timestamp + ", origin=" + origin
				+ ", destination=" + destination + ", duration=" + duration + ", status_code=" + status_code
				+ ", status_description=" + status_description + "]";
	}
    

}
