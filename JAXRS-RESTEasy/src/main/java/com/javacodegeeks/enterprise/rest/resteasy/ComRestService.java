package com.javacodegeeks.enterprise.rest.resteasy;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javacodegeeks.enterprise.rest.constants.MessageType;

@Path("/com")
public class ComRestService {

	private static ComOperations operations = new ComOperations();
	
	private static MessageReport messageReport = new MessageReport(); 

	@GET
	public Response responseMsgBasic() {

		String response = "Hello from: Basic ";

		return Response.status(200).entity(response).build();
	}

	@GET
	@Path("/{pathParameter}")
	public Response responseMsg(@PathParam("pathParameter") String pathParameter,
			@DefaultValue("Nothing to say") @QueryParam("queryParameter") String queryParameter) {

		String response = "Hello from: " + pathParameter + " : " + queryParameter;

		return Response.status(200).entity(response).build();
	}

	@POST
	@Consumes({ "application/json" })
	@Path("/{pathParameter}")
	public Response response(@PathParam("pathParameter") String pathParameter,
			@DefaultValue("Nothing to say") @QueryParam("queryParameter") String queryParameter) {

		String response = "Hello from: " + pathParameter + " : " + queryParameter;

		return Response.status(200).entity(response).build();
	}

	@POST
	@Consumes({ "application/json" })
	@Path("/order")
	public Response responseJson(CallRequest queryRequest) {

		System.out.println("Inicia metodo Order");
		// String response = "Hello from: " + queryRequest.getMethod() ;
		String response = "Hello from: " + queryRequest.getData().getOrigin();

		return Response.status(200).entity(response).build();
	}

	@POST
	@Consumes({ "application/json" })
	@Path("/orderw")
	public Response responseJsonw(@Context UriInfo uriInfo, String queryRequest) {

		// String TEXT = queryRequest;
		// JsonObject body = Json.createReader(new StringReader(TEXT)).readObject();
		// System.out.println("Inicia metodo Orderw" + uriInfo.getPath());
		// String response = "Hello from: " + queryRequest.getMethod() ;
		String response = "Hello from: " + queryRequest.toString();
		System.out.println("Inicia metodo Orderw" + uriInfo.getPath());
		System.out.println("------------------------------------------");
		System.out.println("Validación json : " + operations.validate_jsonString(queryRequest));
		System.out.println("Validación numero parámetros : " + operations.validate_num(queryRequest, null));

		operations.validate_jsonString(queryRequest);

		// validate_json(queryRequest);

		return Response.status(200).entity(response).build();
	}

	@POST
	@Consumes({ "application/json" })
	@Path("/orderwx")
	public Response responseJsonwx(@Context UriInfo uriInfo, String queryRequest) {

		String TEXT = queryRequest;
		JsonObject body = Json.createReader(new StringReader(TEXT)).readObject();

		System.out.println("Inicia metodo Orderw" + uriInfo.getPath());
		// String response = "Hello from: " + queryRequest.getMethod() ;
		String response = "Hello from: " + queryRequest.toString();

		return Response.status(200).entity(response).build();
	}

	// ------------------------------------------------------------------------------------
	@POST
	@Consumes({"application/json"})
	@Path("/orderList")
	public Response responseJsonList(  @Context UriInfo uriInfo, String queryRequest) {
		
		long startTime = System.nanoTime();

		int nCalls = 0; 
		int nMsgs = 0; 
		List<Record> recordList = new ArrayList<Record>(); 
		JsonArray jsonList = Json.createReader(new StringReader(queryRequest)).readArray(); 
		String response = "Hello from: " +jsonList; 
		messageReport.incrNumLines(jsonList.size());
		messageReport.incrNumFiles();
		
		System.out.println("Inicia metodo Orderw" + jsonList.size());
		//Valida número de campos por cada registro del fichero de entrada
		for (Object j1   :jsonList) {
			Boolean validJson = true; 
			JsonObject jsonObject =   (JsonObject)j1; 
			//  Optimizar comparando tipos MessageType
			if (			jsonObject.get("message_type").toString().equals("\""+ MessageType.CALL + "\"")) {
				validJson = operations.validateJCall(jsonObject); 	
				
			}else 
				if (			jsonObject.get("message_type").toString().equals("\""+  MessageType.MSG  +  "\"")) {
					validJson = operations.validateJMsg(jsonObject);
				}	
			System.out.println("Validando  json : " +  jsonObject+ " - " + validJson );
			
		    ObjectMapper objectMapper = new ObjectMapper();
			
			try {
				Record record = new Record ();
				record = objectMapper.readValue(jsonObject.toString(), Record.class);
				recordList.add(record); 
				System.out.println("Validado call en lista  : " +  jsonObject+ " - " );

				
			} catch (JsonParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				e.getCause(); 
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 

			
		}
		
		
		try {
	    ObjectMapper objectMapper = new ObjectMapper();
		List<Record> callList = objectMapper.readValue(queryRequest, new TypeReference<List<Record>>(){});
		
		
		System.out.println("Tamaño : " + callList.size());	
		for (Record record: recordList)  {
		//     VALIDATE   RECORD
			if (record.getMessage_type().equals(MessageType.CALL))  			{
				// Valida 
				//					campos vacios
				Call call = operations.getCall(record);
				Boolean validateCall; 
				validateCall  = operations.validateCallValues(call); 
				System.out.println("Validando call contenidos: " +  validateCall  + " - " );
				if (validateCall  ) {
					nCalls ++; 
					messageReport.addOriginCountryList(call.getOrigin());
					messageReport.addDestinationCountryList(call.getDestination());
				}
				
				System.out.println("Validando elemento Call : " );			
				
				}
			else 		if (record.getMessage_type().equals(MessageType.MSG))  			{
				Msg msg = operations.getMsg(record);
				
	
				Boolean validateMsg; 
				validateMsg  = operations.validateMsgValues(msg); 
				System.out.println("Validando msg contenidos: " +  validateMsg  + " - " );
				if (validateMsg  ) {
					nMsgs ++; 
					messageReport.addOriginCountryList(msg.getOrigin());
					messageReport.addDestinationCountryList(msg.getDestination());
					
				}
				System.out.println("Validando elemento Msg : " + record );	
				
				}
			}
		messageReport.setNum_call(nCalls);
		messageReport.setNum_msg(nMsgs);
		
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		long endTime = System.nanoTime();
		long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
		return Response.status(200).entity(response).build();
	}
}
