package aba.marsrover.app.restservice.move;

import org.springframework.stereotype.Service;

import aba.marsrover.app.MarsRover;
import aba.marsrover.app.pojo.Position;
import aba.marsrover.app.restservice.BaseResponse;

@Service
public class MoveServiceImpl implements MoveService {

	public BaseResponse move(Position pos) {
		MarsRover mr = MarsRover.getInstance();
		
		if(mr.getStateContext().move(pos)) {
			return new MoveResponse(mr.getBattery(), mr.getPosition());
		}
		return new BaseResponse("Not Valid Action");
	}
	
	public BaseResponse stopMove() {
		MarsRover mr = MarsRover.getInstance();

		if(mr.getStateContext().stopMove()) {
			return new MoveResponse(mr.getBattery(), mr.getPosition());
		}
		return new BaseResponse("Not Valid Action");
	}
}
