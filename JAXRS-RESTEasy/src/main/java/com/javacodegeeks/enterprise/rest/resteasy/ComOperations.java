package com.javacodegeeks.enterprise.rest.resteasy;

import java.io.StringReader;
import java.lang.reflect.Field;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javacodegeeks.enterprise.rest.constants.MessageType;

public class ComOperations {
	private static MessageReport messageReport = new MessageReport(); 

	
	// Valida número de parametros. 
	// Entrada : cadena. 
	public boolean validate_num(String callParam, MessageType message_type) {
		boolean result;
		result = Boolean.TRUE;
		String fieldList[] = callParam.split(":");
		if (message_type.equals(MessageType.CALL)) {
			if (fieldList.length != 8) {
				result = Boolean.FALSE;
			}
		} else if (message_type.equals(MessageType.MSG)) {
			if (fieldList.length != 7) {
				result = Boolean.FALSE;
			}
		}

		System.out.println(fieldList[0] + fieldList.length);

		return result;
	}
	
	
	
	

	//------------------------------------------------------------------------------------------------
	
	// Valida número y nombre de parametros. 
	// Entrada : JSon Call. 
	
	public boolean validateJCall (JsonObject param) {
		boolean result;
		result = true;
		Field[] jj = Call.class.getDeclaredFields(); 
		
		for (Field field : jj) {
			if (!param.containsKey(field.getName())) {
				result = false; 
			}
	
		}
		
		
		return result;
	}
	
	//------------------------------------------------------------------------------------------------
	

	
	//------------------------------------------------------------------------------------------------
	
	// Valida número y nombre de parametros. 
	// Entrada : JSon Msg. 
	
	public boolean validateJMsg (JsonObject param) {
		boolean result;
		result = true;
		Field[] jj = Msg.class.getFields(); 
		
		for (Field field : jj) {
			if (!param.containsKey(field.getName())) {
				result = false; 
			}
		}
		
		
		return result;
	}
	
	
	
	
//------------------------------------------------------------------------------------------------
	public boolean validate_jsonExtend(String callParam) {
		boolean result;
		result = Boolean.TRUE;

		try {
			JsonObject body = Json.createReader(new StringReader(callParam)).readObject();

			if (body.containsKey("message_type")) {

				if (body.get("message_type").equals(MessageType.CALL)) {
					// validacion call
					ObjectMapper objectMapper = new ObjectMapper();
					Call call = objectMapper.readValue(callParam, Call.class);
					if (!validate_num(callParam, MessageType.CALL))  {
						messageReport.incrMissingFields(); 
					}

				} else if (body.get("message_type").equals(MessageType.MSG)) {
					// VALIDAcion msg
					

				} else {
					result = Boolean.FALSE;
				}
			} else {
				result = Boolean.FALSE;
			}

			// create ObjectMapper instance

		} catch (Exception e) {
			// Does nothing
			return Boolean.FALSE;
		}
		return result;
	}

	public boolean validate_jsonString(String callParam) {
		boolean result;
		result = Boolean.TRUE;

		try {
			JsonObject body = Json.createReader(new StringReader(callParam)).readObject();

			if (body.containsKey("message_type")) {
				if (body.get("message_type").equals(MessageType.CALL)) {
					// validacion call
					try {
						ObjectMapper objectMapper = new ObjectMapper();
						Call call = objectMapper.readValue(callParam, Call.class);
					} catch (JsonParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				} else if (body.get("message_type").equals(MessageType.MSG)) {
					// VALIDAcion msg

				} else {
					result = Boolean.FALSE;
				}
			} else {
				result = Boolean.FALSE;
			}

			// create ObjectMapper instance

		} catch (Exception e) {
			// Does nothing
			return Boolean.FALSE;
		}
		return result;
	}

	
	
	public boolean validateCallValues (Call param) {
		boolean result;
		result = Boolean.TRUE;

		try {

			if ((param.getMessage_type()==null    )  ||
					(param.getDestination()==null    )  ||
					(param.getDuration()== 0 )  ||
					(param.getOrigin()==null    )  ||
					(param.getStatus_code()==null    )  ||
					(param.getStatus_description()==null    )  ||
					(param.getTimestamp()==null    ) 
					) {
				result = false; 
				
			}


		} catch (Exception e) {
			// Does nothing
			return Boolean.FALSE;
		}
		return result;
	}
	
	public boolean validateMsgValues (Msg param) {
		boolean result;
		result = Boolean.TRUE;

		try {

			if ((param.getMessage_type()==null    )  ||
					(param.getDestination()==null    )  ||
					(param.getOrigin()==null    )  ||
					(param.getMessage_content() ==null    )  ||
					(param.getMessage_status()==null    )  ||
					(param.getTimestamp()==null    ) 

					) {
				result = false; 
				
			}
		} catch (Exception e) {

			return false;
		}
		return result;
	}
	

	public Call getCall(Record record) {

		Call result = new Call (); 
		
		result.setMessage_type(MessageType.CALL);
		
		result.setDestination(record.getDestination());
		result.setDuration(record.getDuration());
		result.setOrigin(record.getOrigin());
		result.setStatus_code(record.getStatus_code());
		result.setStatus_description(record.getStatus_description());
		result.setTimestamp(record.getTimestamp());
		return result; 
	}
	
	
	public Msg getMsg(Record record) {

		Msg result = new Msg(); 
		
		result.setMessage_type(MessageType.MSG);
		
		result.setDestination(record.getDestination());
		result.setOrigin(record.getOrigin());
		result.setTimestamp(record.getTimestamp());
		
		result.setMessage_content(record.getMessage_content());
		result.setMessage_status(record.getMessage_status());
		return result; 
	}
	
	public boolean isCall(Record record) {

		if (record.getMessage_type().equals(MessageType.CALL))
		{
			return Boolean.TRUE; 
		}
		else {
			return Boolean.FALSE; 
		}
	}

}
