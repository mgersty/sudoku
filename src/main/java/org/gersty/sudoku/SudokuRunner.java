package org.gersty.sudoku;

import java.util.Iterator;
import java.util.Map;

import org.gersty.sudoku.domain.SudokuBoard;
import org.gersty.sudoku.service.SudokuService;


public class  SudokuRunner {
	private static final String  predefinedValues = "0|0|0|2|6|0|7|0|1,6|8|0|0|7|0|0|9|0,1|9|0|0|0|4|5|0|0,8|2|0|1|0|0|0|4|0,0|0|4|6|0|2|9|0|0,0|5|0|0|0|3|0|2|8,0|0|9|3|0|0|0|7|4,0|4|0|0|5|0|0|3|6,7|0|3|0|1|8|0|0|0";
    public static void main(String[] args) {
    	//SudokuBoard sodukuBoard = new SudokuBoard();
    	SudokuService sudokuService = new SudokuService();
    	//String solvedString = "435269781,682571493,197834562,826195347,374682915,951743628,519326874,248957136,763418259";
    	sudokuService.displayBoard(sudokuService.initializeBoard(predefinedValues));
    	
    	
    }

	public static void displayBoard(SudokuBoard sodukuBoard){
		Iterator it = sodukuBoard.getBoard().entrySet().iterator();
    	while(it.hasNext()){
    		Map.Entry pairs = (Map.Entry)it.next();
        	System.out.println(pairs.getKey() + " = " + pairs.getValue()+"\n");
    	}
	}
}