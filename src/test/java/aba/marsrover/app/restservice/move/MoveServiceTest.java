package aba.marsrover.app.restservice.move;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import aba.marsrover.app.MarsRover;
import aba.marsrover.app.pojo.Position;
import aba.marsrover.app.state.AvailableState;
import aba.marsrover.app.state.MoveState;

public class MoveServiceTest 
{
	@Test
    public void MoveService()
    {
        //Given
    	MoveService bs = new MoveServiceImpl();
    	MarsRover mr = MarsRover.getInstance();
    	mr.setBattery(50);
    	mr.getStateContext().setState(new AvailableState());
    	
    	//When
    	MoveResponse response = (MoveResponse) bs.move(new Position(45f,45f));
    	
    	//Then
    	assertEquals(40, mr.getBattery());
    	assertEquals("move",response.getStatus());
    	assertEquals("OK",response.getMessage());    	
    }
	
	@Test
    public void MoveServiceStop()
    {
        //Given
		MoveService bs = new MoveServiceImpl();
    	MarsRover mr = MarsRover.getInstance();
    	mr.setBattery(50);
    	mr.getStateContext().setState(new MoveState());
    	
    	//When
    	MoveResponse response = (MoveResponse) bs.stopMove();
    	
    	//Then
    	assertEquals(50, mr.getBattery());
    	assertEquals("available",response.getStatus());
    	assertEquals("OK",response.getMessage());    	
    }
	
}
