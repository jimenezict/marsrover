package aba.marsrover.app.restservice.battery;

import aba.marsrover.app.restservice.BaseResponse;

public interface BatteryService {
	
	public BaseResponse charge();
	
	public BaseResponse stop();

}
