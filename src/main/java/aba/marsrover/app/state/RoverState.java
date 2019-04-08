package aba.marsrover.app.state;

import aba.marsrover.app.MarsRoverContext;
import aba.marsrover.app.pojo.Position;

public interface RoverState {
	
	default boolean chargeBattery(MarsRoverContext state) {
		return false;
	}
	
	default boolean stopChargeBattery(MarsRoverContext state) {
		return false;
	}
	
	default boolean move(MarsRoverContext state,Position pos) {
		return false;
	}
	
	default boolean stopMove(MarsRoverContext marsRoverContext) {
		return false;
	}
	
	default boolean receive(MarsRoverContext state) {
		return false;
	}
	
	String statusName();
	
}
