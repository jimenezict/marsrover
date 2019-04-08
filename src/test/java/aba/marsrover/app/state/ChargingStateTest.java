package aba.marsrover.app.state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import aba.marsrover.app.MarsRover;
import aba.marsrover.app.pojo.Position;

public class ChargingStateTest 
{
	@Test
    public void ChargingState()
    {
        //Given
    	MarsRover mr = MarsRover.getInstance();
    	mr.setBattery(50);
    	mr.getStateContext().setState(new AvailableState());
    	
    	//When
    	boolean valid = mr.getStateContext().chargeBattery();
    	
    	//Then
    	assertTrue(valid);
    	assertEquals(70, mr.getBattery());
    	assertEquals("charging",mr.getStateContext().getState().statusName());
    }
	
	@Test
    public void ChargingStateMaxValue()
    {
        //Given
    	MarsRover mr = MarsRover.getInstance();
    	mr.setBattery(90);
    	mr.getStateContext().setState(new AvailableState());
    	
    	//When
    	boolean valid = mr.getStateContext().chargeBattery();
    	
    	//Then
    	assertTrue(valid);
    	assertEquals(100, mr.getBattery());
    	assertEquals("available",mr.getStateContext().getState().statusName());
    }
	
	@Test
	public void InvalidStates()
	{
		//Given
    	MarsRover mr = MarsRover.getInstance();
    	mr.setBattery(50);
    	mr.getStateContext().setState(new ChargingState());
    	Position pos = new Position(45f,45f);
    	
    	//When
    	boolean valid1 = mr.getStateContext().move(pos);
    	boolean valid2 = mr.getStateContext().receive();
    	
    	//Then
    	assertFalse(valid1);
    	assertFalse(valid2);
	}
}
