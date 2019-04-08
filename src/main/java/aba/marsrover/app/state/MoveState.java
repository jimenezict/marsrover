package aba.marsrover.app.state;

import aba.marsrover.app.MarsRover;
import aba.marsrover.app.MarsRoverContext;
import aba.marsrover.app.pojo.Position;

public class MoveState implements RoverState{


	@Override
	public boolean move(MarsRoverContext state,Position pos) {
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
	public boolean stopMove(MarsRoverContext state) {
		state.setState(new AvailableState());
		return true;
	}


	@Override
	public String statusName() {
		return "move";
	}

}
