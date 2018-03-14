package com.javacodegeeks.enterprise.rest.resteasy;


import java.io.Serializable;


public class CallRequest  implements Serializable{
	
	private Call data;

	public Call getData() {
		return data;
	}

	public void setData(Call data) {
		this.data = data;
	} 
	
	
	

}
