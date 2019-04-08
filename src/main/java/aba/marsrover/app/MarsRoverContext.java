package aba.marsrover.app;

import aba.marsrover.app.pojo.Position;
import aba.marsrover.app.state.AvailableState;
import aba.marsrover.app.state.RoverState;

public class MarsRoverContext {
	
	private RoverState state = new AvailableState();
	
	public RoverState getState() {
		return state;
	}

	public void setState(RoverState state) {
		this.state = state;
	}

	public boolean chargeBattery() {
		return state.chargeBattery(this);
	}
	
	public boolean stopChargeBattery() {
		return state.stopChargeBattery(this);
	}
	
	public boolean move(Position pos) {
		return state.move(this, pos);
	}
	
	public boolean stopMove() {
		return state.stopMove(this);
	}
	
	public boolean receive() {
		return state.receive(this);
	}
}
