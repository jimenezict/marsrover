package aba.marsrover.app.restservice;

import java.sql.Timestamp;

import aba.marsrover.app.MarsRover;

public class BaseResponse {
	
	protected Timestamp timestamp;
	protected String status;
	protected String message;
	
	public BaseResponse(String message) {
	   timestamp = new Timestamp(System.currentTimeMillis());
	   status = MarsRover.getInstance().getStateContext().getState().statusName();
	   this.message = message;
	}

	public Timestamp getTimestamp() {
	   return timestamp;
	}
	
	public String getMessage() {
		return message;
	}
	
	public String getStatus() {
		return status;
	}
	 
}
