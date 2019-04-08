package aba.marsrover.app.restservice.battery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import aba.marsrover.app.MarsRover;
import aba.marsrover.app.state.AvailableState;
import aba.marsrover.app.state.ChargingState;

public class BatteryServiceTest 
{
	@Test
    public void BatteryServiceCharge()
    {
        //Given
    	BatteryService bs = new BatteryServiceImpl();
    	MarsRover mr = MarsRover.getInstance();
    	mr.setBattery(50);
    	mr.getStateContext().setState(new AvailableState());
    	
    	//When
    	BatteryResponse response = (BatteryResponse) bs.charge();
    	
    	//Then
    	assertEquals(70, mr.getBattery());
    	assertEquals("charging",response.getStatus());
    	assertEquals("OK",response.getMessage());    	
    }
	
	@Test
    public void BatteryServiceStop()
    {
        //Given
    	BatteryService bs = new BatteryServiceImpl();
    	MarsRover mr = MarsRover.getInstance();
    	mr.setBattery(50);
    	mr.getStateContext().setState(new ChargingState());
    	
    	//When
    	BatteryResponse response = (BatteryResponse) bs.stop();
    	
    	//Then
    	assertEquals(50, mr.getBattery());
    	assertEquals("available",response.getStatus());
    	assertEquals("OK",response.getMessage());    	
    }
	
}
