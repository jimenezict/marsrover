package aba.marsrover.app.restservice.move;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import aba.marsrover.app.pojo.Position;
import aba.marsrover.app.restservice.BaseResponse;

@RestController
public class MoveController {

	@Autowired
	MoveService moveService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/move/start")
	@ResponseBody
	public BaseResponse move(@RequestParam(name = "X") float X,@RequestParam(name = "Y") float Y) {
		return moveService.move(new Position(X,Y));		
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/move/stop")
	@ResponseBody
	public BaseResponse moveStop() {
		return moveService.stopMove();		
    }
}
