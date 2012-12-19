package org.gersty.sudoku;

import java.util.Iterator;
import java.util.Map;

import org.gersty.sudoku.domain.SudokuBoard;


public class  SudokuRunner {

    public static void main(String[] args) {
    	SudokuBoard sodukuBoard = new SudokuBoard();
    	Iterator it = sodukuBoard.getBoard().entrySet().iterator();
    	while(it.hasNext()){
    		Map.Entry pairs = (Map.Entry)it.next();
        	System.out.println(pairs.getKey() + " = " + pairs.getValue()+"\n");
    	}
    	
    }
}