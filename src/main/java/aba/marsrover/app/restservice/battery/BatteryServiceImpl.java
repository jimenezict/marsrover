package aba.marsrover.app.restservice.battery;

import org.springframework.stereotype.Service;

import aba.marsrover.app.MarsRover;
import aba.marsrover.app.restservice.BaseResponse;

@Service
public class BatteryServiceImpl implements BatteryService{

	public BaseResponse charge() {
		MarsRover mr = MarsRover.getInstance();
		
		if(mr.getStateContext().chargeBattery()) {
			return new BatteryResponse(mr.getBattery());
		}
		return new BaseResponse("Not Valid Action");
	}
	
	public BaseResponse stop() {
		MarsRover mr = MarsRover.getInstance();
		
		if(mr.getStateContext().stopChargeBattery()) {
			return new BatteryResponse(mr.getBattery());
		}
		return new BaseResponse("Not Valid Action");
	}
}
