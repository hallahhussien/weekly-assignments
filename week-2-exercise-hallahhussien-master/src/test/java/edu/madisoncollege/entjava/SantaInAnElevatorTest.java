package edu.madisoncollege.entjava;

import org.junit.Test;

import static org.junit.Assert.*;


public class SantaInAnElevatorTest {

    @Test
    public void determineFloorNumber() throws Exception {
        SantaInAnElevator test1 = new SantaInAnElevator();
        String instructions = test1.getInstructions();
        Integer floorNumber = test1.determineFloorNumber(instructions);
        assertFalse(floorNumber == 5);
    }
}