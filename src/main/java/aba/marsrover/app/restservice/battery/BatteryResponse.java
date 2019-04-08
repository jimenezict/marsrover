package aba.marsrover.app.restservice.battery;

import aba.marsrover.app.restservice.BaseResponse;

public class BatteryResponse extends BaseResponse{
	
	private int battery;
	
	public BatteryResponse(int battery) {
		super("OK");
		this.battery = battery;
	}
	
	public int getBattery() {
		return battery;
	}
	
}
