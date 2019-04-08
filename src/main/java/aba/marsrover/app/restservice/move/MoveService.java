package aba.marsrover.app.restservice.move;

import org.springframework.stereotype.Service;

import aba.marsrover.app.MarsRover;
import aba.marsrover.app.pojo.Position;
import aba.marsrover.app.restservice.BaseResponse;

@Service
public interface MoveService {

	public BaseResponse move(Position pos);
	
	public BaseResponse stopMove();
	
}
