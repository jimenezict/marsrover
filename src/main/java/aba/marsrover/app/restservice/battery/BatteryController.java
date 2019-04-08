package aba.marsrover.app.restservice.battery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import aba.marsrover.app.restservice.BaseResponse;

@RestController
public class BatteryController {

	@Autowired
	BatteryService batteryService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/battery/charge")
	public BaseResponse charge() {
		return batteryService.charge();		
    }
	
	@RequestMapping(method = RequestMethod.GET, value = "/battery/stop")
	public BaseResponse stop() {
		return batteryService.stop();
    }
	
}
