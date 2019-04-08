package aba.marsrover.app.state;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import aba.marsrover.app.MarsRover;
import aba.marsrover.app.pojo.Position;

public class MoveStateTest 
{
	@Test
    public void MoveStateFromAvailable()
    {
        //Given
    	MarsRover mr = MarsRover.getInstance();
    	mr.setBattery(50);
    	mr.getStateContext().setState(new AvailableState());
    	Position pos = new Position(45f,45f);
    	
    	//When
    	boolean valid = mr.getStateContext().move(pos);
    	
    	//Then
    	assertTrue(valid);
    	assertEquals(40, mr.getBattery());
    	assertEquals("move",mr.getStateContext().getState().statusName());
    }
	
	@Test
    public void MoveStateFromMoving()
    {
        //Given
    	MarsRover mr = MarsRover.getInstance();
    	mr.setBattery(50);
    	mr.getStateContext().setState(new MoveState());
    	Position pos = new Position(45f,45f);
    	
    	//When
    	boolean valid = mr.getStateContext().move(pos);
    	
    	//Then
    	assertTrue(valid);
    	assertEquals(40, mr.getBattery());
    	assertEquals("move",mr.getStateContext().getState().statusName());
    }
	
	@Test
    public void MoveStateMinValue()
    {
        //Given
    	MarsRover mr = MarsRover.getInstance();
    	mr.setBattery(10);
    	mr.getStateContext().setState(new AvailableState());
    	Position pos = new Position(45f,45f);
    	
    	//When
    	boolean valid = mr.getStateContext().move(pos);
    	
    	//Then
    	assertTrue(valid);
    	assertEquals(0, mr.getBattery());
    	assertEquals("charging",mr.getStateContext().getState().statusName());
    }
	
	@Test
	public void InvalidStates()
	{
		//Given
    	MarsRover mr = MarsRover.getInstance();
    	mr.setBattery(50);
    	mr.getStateContext().setState(new MoveState());
    	
    	//When
    	boolean valid1 = mr.getStateContext().chargeBattery();
    	boolean valid2 = mr.getStateContext().receive();
    	boolean valid3 = mr.getStateContext().stopChargeBattery();
    	
    	//Then
    	assertFalse(valid1);
    	assertFalse(valid2);
    	assertFalse(valid3);
	}
}
