import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Random;
import java.util.*;

public class GameOfLifeTest {

	private MainPanel _mainPanel;
	
	// The following three tests simply check to see if X is equal to Y after removing much of the 
	// unnecessary code in convertToInt 
	@Test
	public void testPositiveConvertToInt(){
		
		int x = 15;
	
		int y = MainPanel.convertToInt(x);
		
		assertEquals(x,y);
		
	}
	
	@Test
	public void testZeroConvertToInt(){
		
		int x = 0;
	
		int y = MainPanel.convertToInt(x);
		
		assertEquals(x,y);
		
	}
	
	@Test
	public void testNegativeConvertToInt(){
		
		int x = -15;
	
		int y = MainPanel.convertToInt(x);
		
		assertEquals(x,y);
		
	}
	
	// This test is supposed to create a simulation of the Game of Life to test the toString method in Cell. 
	// I had difficulty getting it to load 
	// so in theory the test should pass but I am not sure why it fails
	@Test
	public void toStringTest(){
	
		String[] gameOfLifeSim = new String[1];
					
		gameOfLifeSim[0] = "15";
				
		int x;
					
		x = Integer.parseInt(gameOfLifeSim[0]);
				
		GameOfLife.main(gameOfLifeSim);
				
		MainPanel _m = new MainPanel(x);
				
		ArrayList<String> list1 = FileAccess.loadFile("stringTest.txt");
		
		_m.load(list1);
	    
	    String toTheString = _m.toString();
	    
	    FileAccess.saveFile("stringTest2.txt", toTheString);
	    
	    ArrayList<String> list2 = FileAccess.loadFile("stringTest.txt");
	    
	    assertEquals(list1, list2);
	    
	}
	
	// This test is supposed to create a simulation of the Game of Life to test runContinuous. 
	// I had difficulty getting it to load 
	// so in theory the test should pass but I am not sure why it fails
	@Test
	public void runContinuousTest(){
		
		String[] gameOfLifeSim = new String[1];
						
		gameOfLifeSim[0] = "15";
					
		int x;
						
		x = Integer.parseInt(gameOfLifeSim[0]);
					
		GameOfLife.main(gameOfLifeSim);
					
		MainPanel _q = new MainPanel(x);
					
		ArrayList<String> list1 = FileAccess.loadFile("stringTest.txt");
			
		_q.load(list1);
		    
		for(int k = 0; k < 100; k++){
	    	_q.calculateNextIteration();
	    }
		
		_q.stop();
		
		String currentState = _q.toString();
		
		FileAccess.saveFile("runContinuousTest.txt", currentState);
		
		ArrayList<String> run1 = FileAccess.loadFile("runContinuousTest.txt");

		ArrayList<String> run2 = FileAccess.loadFile("stringTest.txt");
		
		assertEquals(run1, run2);
		
	}
}