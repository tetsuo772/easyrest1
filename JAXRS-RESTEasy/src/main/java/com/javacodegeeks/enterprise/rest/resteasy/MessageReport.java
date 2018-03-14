package com.javacodegeeks.enterprise.rest.resteasy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.javacodegeeks.enterprise.rest.constants.MessageType;
import com.javacodegeeks.enterprise.rest.constants.StatusCode;

public class MessageReport implements Serializable {

	private int num_call;
	private int num_msg;
	private int num_lines;  
	private int num_files;  
	
	
	public int getNum_files() {
		return num_files;
	}

	public void setNum_files(int num_files) {
		this.num_files = num_files;
	}

	public int getNum_lines() {
		return num_lines;
	}

	public void setNum_lines(int num_lines) {
		this.num_lines = num_lines;
	}

	private int missingFields;
	private int blankContent;
	private int errorFields;
	private List<Long> originCountryList; 
	private List<Long> destinationCountryList; 
	private List<Long> durationList; 
	


	public List<Long> getDurationList() {
		return durationList;
	}

	public void setDurationList(List<Long> durationList) {
		this.durationList = durationList;
	}

	public List<Long> getDestinationCountryList() {
		return destinationCountryList;
	}

	private int callCountry1;
	private int callCountry2;

	private float ok_ko_call;
	private float averageCallDuration;
	private String wordRanking;

	// Introducing the dummy constructor
	public MessageReport() {
		num_call = 0;
		num_msg = 0;

		missingFields = 0;
		blankContent = 0;

		errorFields = 0;
		originCountryList = new ArrayList<Long> ();
		destinationCountryList = new ArrayList<Long> ();
		durationList
		 = new ArrayList<Long> ();
	}

	public int getNum_call() {
		return num_call;
	}

	public void setNum_call(int num_call) {
		this.num_call = num_call;
	}

	public int getNum_msg() {
		return num_msg;
	}

	public void setNum_msg(int num_msg) {
		this.num_msg = num_msg;
	}

	public int getMissingFields() {
		return missingFields;
	}

	public void setMissingFields(int missingFields) {
		this.missingFields = missingFields;
	}

	public int getBlankContent() {
		return blankContent;
	}

	public void setBlankContent(int blankContent) {
		this.blankContent = blankContent;
	}

	public int getErrorFields() {
		return errorFields;
	}

	public void setErrorFields(int errorFields) {
		this.errorFields = errorFields;
	}

	public int getCallCountry1() {
		return callCountry1;
	}

	public void setCallCountry1(int callCountry1) {
		this.callCountry1 = callCountry1;
	}

	public int getCallCountry2() {
		return callCountry2;
	}

	public void setCallCountry2(int callCountry2) {
		this.callCountry2 = callCountry2;
	}

	public float getOk_ko_call() {
		return ok_ko_call;
	}

	public void setOk_ko_call(float ok_ko_call) {
		this.ok_ko_call = ok_ko_call;
	}

	public float getAverageCallDuration() {
		return averageCallDuration;
	}

	public void setAverageCallDuration(float averageCallDuration) {
		this.averageCallDuration = averageCallDuration;
	}

	public String getWordRanking() {
		return wordRanking;
	}

	public void setWordRanking(String wordRanking) {
		this.wordRanking = wordRanking;
	}

	public void incrMissingFields() {
		this.missingFields = this.missingFields + 1;
	}

	public void incrBlankContent() {
		this.blankContent = this.blankContent + 1;
	}
	
	public void incrNumFiles() {
		this.num_files = this.num_files+ 1;
	}
	

	public void incrNumLines(int sum) {
		this.num_lines = this.num_lines  + sum;
	}
	
	public void addOriginCountryList(long countryItem) {
		this.originCountryList.add(new Long (countryItem));
	}
	
	public List<Long> getOriginCountryList() {
		return originCountryList;
	}
	
	public List<Long> getOriginCountryListFinal() {
		Set<Long> hs = new HashSet<Long>();
		hs.addAll(originCountryList);
		originCountryList.clear();
		originCountryList.addAll(hs);
		return originCountryList;
	}

	public void setOriginCountryList(List<Long> countryList) {
		this.originCountryList = countryList;
	}
	
	
	
	public void addDestinationCountryList(long countryItem) {
		this.destinationCountryList.add(new Long (countryItem));
	}
	
	public List<Long> getDestinationsCountryList() {
		return destinationCountryList;
	}
	
	public List<Long> getDestinationCountryListFinal() {
		Set<Long> hs = new HashSet<Long>();
		hs.addAll(destinationCountryList);
		destinationCountryList.clear();
		destinationCountryList.addAll(hs);
		return destinationCountryList;
	}

	public void setDestinationCountryList(List<Long> countryList) {
		this.destinationCountryList = countryList;
	}
	
	public void addDuration(long duration) {
		this.durationList.add(new Long (duration));
	}
	
}
