package org.gersty.sudoku.domain;
import org.junit.*;
import static org.junit.Assert.*;

import java.util.Map;
import java.util.HashMap;

public class SudokuBoardTest {

	@Test
	public void whenWeInitializeSudokuBoardInstanceWeGetBackABoard(){
		
		Map<String, int[]> expectedBoard = new HashMap<String, int[]>();

		expectedBoard.put("A1", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("A2", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("A3", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("A4", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("A5", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("A6", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("A7", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("A8", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("A9", new int[]{1,2,3,4,5,6,7,8,9});
		

		expectedBoard.put("B1", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("B2", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("B3", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("B4", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("B5", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("B6", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("B7", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("B8", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("B9", new int[]{1,2,3,4,5,6,7,8,9});

		expectedBoard.put("C1", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("C2", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("C3", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("C4", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("C5", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("C6", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("C7", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("C8", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("C9", new int[]{1,2,3,4,5,6,7,8,9});


		expectedBoard.put("D1", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("D2", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("D3", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("D4", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("D5", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("D6", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("D7", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("D8", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("D9", new int[]{1,2,3,4,5,6,7,8,9});

		expectedBoard.put("E1", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("E2", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("E3", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("E4", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("E5", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("E6", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("E7", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("E8", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("E9", new int[]{1,2,3,4,5,6,7,8,9});

		expectedBoard.put("F1", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("F2", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("F3", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("F4", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("F5", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("F6", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("F7", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("F8", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("F9", new int[]{1,2,3,4,5,6,7,8,9});

		expectedBoard.put("G1", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("G2", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("G3", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("G4", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("G5", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("G6", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("G7", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("G8", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("G9", new int[]{1,2,3,4,5,6,7,8,9});

		expectedBoard.put("H1", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("H2", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("H3", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("H4", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("H5", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("H6", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("H7", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("H8", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("H9", new int[]{1,2,3,4,5,6,7,8,9});

		expectedBoard.put("I1", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("I2", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("I3", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("I4", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("I5", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("I6", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("I7", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("I8", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("I9", new int[]{1,2,3,4,5,6,7,8,9});

		

		SudokuBoard actualBoard = new SudokuBoard();
		assertTrue(hasAllKeys(actualBoard.getBoard()));

	}

	public boolean hasAllKeys(Map<String, int[]> actualBoard){

		String[] alphaCoordinates = {"A","B","C","D","E","F","G","H","I"};
		int[] numericCoordinates = {1,2,3,4,5,6,7,8,9};
		for(String alphaCoordinate : alphaCoordinates){
			for(int numericCoordinate : numericCoordinates){
				if(!actualBoard.containsKey(alphaCoordinate+numericCoordinate))
					return false;
			}
		}
		return true;
	}
}