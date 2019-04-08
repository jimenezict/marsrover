package aba.marsrover.app.state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import aba.marsrover.app.MarsRover;
import aba.marsrover.app.pojo.Position;

public class AvailableStateTest 
{
	@Test
    public void AvailableState()
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
    public void AvailableStateMaxValue()
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
    public void AvailableStateMove()
    {
        //Given
    	MarsRover mr = MarsRover.getInstance();
    	Position pos = new Position(45f,45f);
    	mr.setBattery(50);
    	mr.getStateContext().setState(new AvailableState());
    	
    	//When
    	boolean valid = mr.getStateContext().move(pos);
    	
    	//Then
    	assertTrue(valid);
    	assertEquals(40, mr.getBattery());
    	assertEquals((int) mr.getPosition().getX(),45);
    	assertEquals((int)mr.getPosition().getY(),45);
    	assertEquals("move",mr.getStateContext().getState().statusName());
    }
	
	@Test
	public void InvalidStates()
	{
		//Given
    	MarsRover mr = MarsRover.getInstance();
    	mr.setBattery(50);
    	mr.getStateContext().setState(new AvailableState());
    	
    	//When
    	boolean valid1 = mr.getStateContext().stopChargeBattery();
    	
    	//Then
    	assertFalse(valid1);
	}
}
