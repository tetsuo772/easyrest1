package com.javacodegeeks.enterprise.rest.constants;

import java.util.Arrays;
import java.util.List;

public class Constants2 {

	
	public enum Level {
	    HIGH,
	    MEDIUM,
	    LOW
	}
	
	List<String> MESSAGE_TYPE1 = Arrays.asList("CALL", "MSG", "Three");
	
	
	public enum Message_Type2 {
	    CALL,
	    MSG
	}
	
	public enum Origin {
		MSISDN
	}
	
	public enum Statuscode1 {
	    CALL,
	    MSG
	}
	
	public enum Statuscode2 {
	    CALL,
	    MSG
	}
	
	public enum MessageStatus {
	    CALL,
	    MSG
	}
}
