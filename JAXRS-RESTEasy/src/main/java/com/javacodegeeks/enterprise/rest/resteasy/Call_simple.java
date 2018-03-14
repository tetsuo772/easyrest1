package com.javacodegeeks.enterprise.rest.resteasy;


import java.io.Serializable;
import java.util.Date;

import com.javacodegeeks.enterprise.rest.constants.MessageType;
import com.javacodegeeks.enterprise.rest.constants.StatusCode;

public class Call_simple  implements Serializable{

	private String message_type ; 
    private long origin  ; 
    private long   destination   ; 
    private String   status_description  ;
	public String getMessage_type() {
		return message_type;
	}
	public void setMessage_type(String message_type) {
		this.message_type = message_type;
	}
	public long getOrigin() {
		return origin;
	}
	public void setOrigin(long origin) {
		this.origin = origin;
	}
	public long getDestination() {
		return destination;
	}
	public void setDestination(long destination) {
		this.destination = destination;
	}
	public String getStatus_description() {
		return status_description;
	}
	public void setStatus_description(String status_description) {
		this.status_description = status_description;
	}
	
	   //Introducing the dummy constructor
    public Call_simple() {
    }
    
    
    
	@Override
	public String toString() {
		return "Call [message_type=" + message_type + ", origin=" + origin + ", destination=" + destination
				+ ", status_description=" + status_description + "]";
	}

}
