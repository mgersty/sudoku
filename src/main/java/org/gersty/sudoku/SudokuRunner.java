package org.gersty.sudoku;

import java.util.Iterator;
import java.util.Map;

import org.gersty.sudoku.domain.SudokuBoard;
import org.gersty.sudoku.service.SudokuService;


public class  SudokuRunner {
	//private static final String  predefinedValues = "0|0|0|2|6|0|7|0|1,6|8|0|0|7|0|0|9|0,1|9|0|0|0|4|5|0|0,8|2|0|1|0|0|0|4|0,0|0|4|6|0|2|9|0|0,0|5|0|0|0|3|0|2|8,0|0|9|3|0|0|0|7|4,0|4|0|0|5|0|0|3|6,7|0|3|0|1|8|0|0|0";
	private static final String  predefinedValues = "1|0|0|4|8|9|0|0|6,7|3|0|0|0|0|0|4|0,0|0|0|0|0|1|2|9|5,0|0|7|1|2|0|6|0|0,5|0|0|7|0|3|0|0|8,0|0|6|0|9|5|7|0|0,9|1|4|6|0|0|0|0|0,0|2|0|0|0|0|0|3|7,8|0|0|5|1|2|0|0|4";
	//private static final String    predefinedValues = "0|2|0|6|0|8|0|0|0,5|8|0|0|0|9|7|0|0,0|0|0|0|4|0|0|0|0,3|7|0|0|0|0|5|0|0,6|0|0|0|0|0|0|0|4,0|0|8|0|0|0|0|1|3,0|0|0|0|2|0|0|0|0,0|0|9|8|0|0|0|3|6,0|0|0|3|0|6|0|9|0";
    public static void main(String[] args) {
    	//SudokuBoard sodukuBoard = new SudokuBoard();
    	SudokuService sudokuService = new SudokuService();
    	
    	
		Map<String, int[]> actualBoard = sudokuService.initializeBoard(predefinedValues);
		
		while(!sudokuService.isBoardComplete(actualBoard)){
			sudokuService.reducePossibilitiesByCell(actualBoard);
			sudokuService.reducePossibilitiesByColumn(actualBoard);
			sudokuService.reducePossibilitiesByRow(actualBoard);
			sudokuService.displayBoard(actualBoard);
		}
    	
    	
    }

	public static void displayBoard(SudokuBoard sodukuBoard){
		Iterator it = sodukuBoard.getBoard().entrySet().iterator();
    	while(it.hasNext()){
    		Map.Entry pairs = (Map.Entry)it.next();
        	System.out.println(pairs.getKey() + " = " + pairs.getValue()+"\n");
    	}
	}
}