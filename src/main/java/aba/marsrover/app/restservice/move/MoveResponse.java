package aba.marsrover.app.restservice.move;

import aba.marsrover.app.pojo.Position;
import aba.marsrover.app.restservice.BaseResponse;

public class MoveResponse extends BaseResponse {
	
	private int battery;
	private Position pos;
	
	public MoveResponse(int battery, Position pos) {
		super("OK");
		this.battery = battery;
		this.pos = pos;
	}
	
	public int getBattery() {
		return battery;
	}
	
	public String getPosition() {
		return "X: " + pos.getX() + "Y: " + pos.getY(); 
	}

}
