package aba.marsrover.app.state;

import aba.marsrover.app.MarsRover;
import aba.marsrover.app.MarsRoverContext;
import aba.marsrover.app.pojo.Position;

public class ChargingState implements RoverState{
	
	@Override
	public boolean chargeBattery(MarsRoverContext state) {
		MarsRover mr = MarsRover.getInstance();
		mr.setBattery(mr.getBattery() + 20);
		if(mr.getBattery()>=100) {
			mr.setBattery(100);
			state.setState(new AvailableState());
		}else {
			state.setState(new ChargingState());
		}
		return true;
	}
	
	@Override
	public boolean stopChargeBattery(MarsRoverContext state) {
		state.setState(new AvailableState());
		return true;
	}	

	@Override
	public String statusName() {	
		return "charging";
	}

}
