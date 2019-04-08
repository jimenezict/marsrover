package aba.marsrover.app;

import aba.marsrover.app.pojo.Position;

public final class MarsRover {
	
	private Position position;	
	private int battery;
	private MarsRoverContext stateContext;
	private static MarsRover marsrovers_instance = null;
	
	public MarsRover() {
		battery = 100;
		position = new Position(0f, 0f);
		stateContext = new MarsRoverContext();
	}
	
	public static MarsRover getInstance() {
		if(marsrovers_instance == null) {
			marsrovers_instance = new MarsRover();
		}
		return marsrovers_instance;
	}
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}
	
	public MarsRoverContext getStateContext() {
		return stateContext;
	}

}
