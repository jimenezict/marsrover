package aba.marsrover.app.state;

import aba.marsrover.app.MarsRover;
import aba.marsrover.app.MarsRoverContext;
import aba.marsrover.app.pojo.Position;

public class AvailableState implements RoverState{

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
	public boolean move(MarsRoverContext state, Position pos) {
		MarsRover mr = MarsRover.getInstance();
		mr.setPosition(pos);
		mr.setBattery(mr.getBattery() - 10);
		if(mr.getBattery()<=0) {
			mr.setBattery(0);
			state.setState(new ChargingState());
		}else {
			state.setState(new MoveState());
		}
		return true;
	}

	@Override
	public String statusName() {
		return "available";
	}

}
