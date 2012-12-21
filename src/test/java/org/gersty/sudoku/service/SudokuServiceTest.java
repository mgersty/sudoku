package org.gersty.sudoku.service;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;


public class SudokuServiceTest{
	private SudokuService sudokuService;
	private static final String  predefinedValues = "0|0|0|2|6|0|7|0|1,6|8|0|0|7|0|0|9|0,1|9|0|0|0|4|5|0|0,8|2|0|1|0|0|0|4|0,0|0|4|6|0|2|9|0|0,0|5|0|0|0|3|0|2|8,0|0|9|3|0|0|0|7|4,0|4|0|0|5|0|0|3|6,7|0|3|0|1|8|0|0|0";
	@Before
	public void setup()
	{
		sudokuService = new SudokuService();
	}
	
	
	@Test
	public void isBoardSolvedRetrunsTrueIfPuzzleIsSolved(){
		Map<String, int[]> solvedBoard = new Hashtable<String, int[]>();
		
		
		solvedBoard.put("A1", new int[]{4});
		solvedBoard.put("A2", new int[]{3});
		solvedBoard.put("A3", new int[]{5});
		solvedBoard.put("A4", new int[]{2});
		solvedBoard.put("A5", new int[]{6});
		solvedBoard.put("A6", new int[]{9});
		solvedBoard.put("A7", new int[]{7});
		solvedBoard.put("A8", new int[]{8});
		solvedBoard.put("A9", new int[]{1});
		

		solvedBoard.put("B1", new int[]{6});
		solvedBoard.put("B2", new int[]{8});
		solvedBoard.put("B3", new int[]{2});
		solvedBoard.put("B4", new int[]{5});
		solvedBoard.put("B5", new int[]{7});
		solvedBoard.put("B6", new int[]{1});
		solvedBoard.put("B7", new int[]{4});
		solvedBoard.put("B8", new int[]{9});
		solvedBoard.put("B9", new int[]{3});
		
		solvedBoard.put("C1", new int[]{1});
		solvedBoard.put("C2", new int[]{9});
		solvedBoard.put("C3", new int[]{7});
		solvedBoard.put("C4", new int[]{8});
		solvedBoard.put("C5", new int[]{3});
		solvedBoard.put("C6", new int[]{4});
		solvedBoard.put("C7", new int[]{5});
		solvedBoard.put("C8", new int[]{6});
		solvedBoard.put("C9", new int[]{2});

		solvedBoard.put("D1", new int[]{8});
		solvedBoard.put("D2", new int[]{2});
		solvedBoard.put("D3", new int[]{6});
		solvedBoard.put("D4", new int[]{1});
		solvedBoard.put("D5", new int[]{9});
		solvedBoard.put("D6", new int[]{5});
		solvedBoard.put("D7", new int[]{3});
		solvedBoard.put("D8", new int[]{4});
		solvedBoard.put("D9", new int[]{7});
		
		solvedBoard.put("E1", new int[]{3});
		solvedBoard.put("E2", new int[]{7});
		solvedBoard.put("E3", new int[]{4});
		solvedBoard.put("E4", new int[]{6});
		solvedBoard.put("E5", new int[]{8});
		solvedBoard.put("E6", new int[]{2});
		solvedBoard.put("E7", new int[]{9});
		solvedBoard.put("E8", new int[]{1});
		solvedBoard.put("E9", new int[]{5});
		
		solvedBoard.put("F1", new int[]{9});
		solvedBoard.put("F2", new int[]{5});
		solvedBoard.put("F3", new int[]{1});
		solvedBoard.put("F4", new int[]{7});
		solvedBoard.put("F5", new int[]{4});
		solvedBoard.put("F6", new int[]{3});
		solvedBoard.put("F7", new int[]{6});
		solvedBoard.put("F8", new int[]{2});
		solvedBoard.put("F9", new int[]{8});
		
		solvedBoard.put("G1", new int[]{5});
		solvedBoard.put("G2", new int[]{1});
		solvedBoard.put("G3", new int[]{9});
		solvedBoard.put("G4", new int[]{3});
		solvedBoard.put("G5", new int[]{2});
		solvedBoard.put("G6", new int[]{6});
		solvedBoard.put("G7", new int[]{8});
		solvedBoard.put("G8", new int[]{7});
		solvedBoard.put("G9", new int[]{4});
		
		solvedBoard.put("H1", new int[]{2});
		solvedBoard.put("H2", new int[]{4});
		solvedBoard.put("H3", new int[]{8});
		solvedBoard.put("H4", new int[]{9});
		solvedBoard.put("H5", new int[]{5});
		solvedBoard.put("H6", new int[]{7});
		solvedBoard.put("H7", new int[]{1});
		solvedBoard.put("H8", new int[]{3});
		solvedBoard.put("H9", new int[]{6});
		
		solvedBoard.put("I1", new int[]{7});
		solvedBoard.put("I2", new int[]{6});
		solvedBoard.put("I3", new int[]{3});
		solvedBoard.put("I4", new int[]{4});
		solvedBoard.put("I5", new int[]{1});
		solvedBoard.put("I6", new int[]{8});
		solvedBoard.put("I7", new int[]{2});
		solvedBoard.put("I8", new int[]{5});
		solvedBoard.put("I9", new int[]{9});
		
		assertTrue(sudokuService.isBoardSolved(solvedBoard));
	}
	@Test
	public void isBoardCompleteReturnsTrueIfEachPossibilityForEachCellIsOne(){
		Map<String, int[]> expectedBoard = new Hashtable<String, int[]>();
		
		expectedBoard.put("A1", new int[]{1});
		expectedBoard.put("A2", new int[]{1});
		expectedBoard.put("A3", new int[]{1});
		
		
		assertTrue(sudokuService.isBoardComplete(expectedBoard));

	
	}
	
	
	@Test
	public void isBoardCompleteReturnsFalseIfEachPossibilityForEachCellIsNotOne(){
		Map<String, int[]> expectedBoard = new Hashtable<String, int[]>();
		
		expectedBoard.put("A1", new int[]{1});
		expectedBoard.put("A2", new int[]{1,2});
		expectedBoard.put("A3", new int[]{1});
		
		
		assertFalse(sudokuService.isBoardComplete(expectedBoard));

	
	}
	
	
	@Test
	public void checkIfPuzzleIsComplete(){
		Map<String, int[]> expectedBoard = new Hashtable<String, int[]>();
		
		expectedBoard.put("A1", new int[]{1});
		expectedBoard.put("A2", new int[]{1});
		expectedBoard.put("A3", new int[]{1});
		
		
		assertTrue(sudokuService.isBoardComplete(expectedBoard));

	
	}

	@Test
	public void reducePossibilitiesByRowWillRemovePossibilitiesBasedOnDuplicateValuesInTheSameRow(){
		Map<String, int[]> expectedBoard = new Hashtable<String, int[]>();
		
		expectedBoard.put("A1", new int[]{3,4,5});
		expectedBoard.put("A2", new int[]{3});
		expectedBoard.put("A3", new int[]{5});
		
		expectedBoard.put("B1", new int[]{6});
		expectedBoard.put("B2", new int[]{8});
		expectedBoard.put("B3", new int[]{2,5});

		expectedBoard.put("C1", new int[]{1});
		expectedBoard.put("C2", new int[]{9});
		expectedBoard.put("C3", new int[]{2,7});

		expectedBoard.put("A4", new int[]{2});
		expectedBoard.put("A5", new int[]{6});
		expectedBoard.put("A6", new int[]{5,9});

		expectedBoard.put("B4", new int[]{5});
		expectedBoard.put("B5", new int[]{7});
		expectedBoard.put("B6", new int[]{1,5});
		
		expectedBoard.put("C4", new int[]{8});
		expectedBoard.put("C5", new int[]{3,8});
		expectedBoard.put("C6", new int[]{4});
		
		expectedBoard.put("A7", new int[]{7});
		expectedBoard.put("A8", new int[]{8});
		expectedBoard.put("A9", new int[]{1});
		
		expectedBoard.put("B7", new int[]{2,3,4});
		expectedBoard.put("B8", new int[]{9});
		expectedBoard.put("B9", new int[]{2,3});
		
		expectedBoard.put("C7", new int[]{5});
		expectedBoard.put("C8", new int[]{6,8});
		expectedBoard.put("C9", new int[]{2,3});

		
		expectedBoard.put("D1", new int[]{8});
		expectedBoard.put("D2", new int[]{2});
		expectedBoard.put("D3", new int[]{6,7});
		
		expectedBoard.put("E1", new int[]{3});
		expectedBoard.put("E2", new int[]{1,3,7});
		expectedBoard.put("E3", new int[]{4});
		
		expectedBoard.put("F1", new int[]{9});
		expectedBoard.put("F2", new int[]{5});
		expectedBoard.put("F3", new int[]{1,6,7});
		
		
		
		expectedBoard.put("D4", new int[]{1});
		expectedBoard.put("D5", new int[]{9});
		expectedBoard.put("D6", new int[]{5,7,9});
		
		expectedBoard.put("E4", new int[]{6});
		expectedBoard.put("E5", new int[]{8});
		expectedBoard.put("E6", new int[]{2});
		
		expectedBoard.put("F4", new int[]{4,7,9});
		expectedBoard.put("F5", new int[]{4,9});
		expectedBoard.put("F6", new int[]{3});
		
		
		expectedBoard.put("D7", new int[]{3,6});
		expectedBoard.put("D8", new int[]{4});
		expectedBoard.put("D9", new int[]{3,5,7});
		
		expectedBoard.put("E7", new int[]{9});
		expectedBoard.put("E8", new int[]{1,5});
		expectedBoard.put("E9", new int[]{3,5,7});
		
		expectedBoard.put("F7", new int[]{1,6});
		expectedBoard.put("F8", new int[]{2});
		expectedBoard.put("F9", new int[]{8});
		
		
		
		expectedBoard.put("G1", new int[]{2,5});
		expectedBoard.put("G2", new int[]{1,6});
		expectedBoard.put("G3", new int[]{9});
		
		expectedBoard.put("H1", new int[]{2});
		expectedBoard.put("H2", new int[]{4});
		expectedBoard.put("H3", new int[]{1,2,8});

		expectedBoard.put("I1", new int[]{7});
		expectedBoard.put("I2", new int[]{6});
		expectedBoard.put("I3", new int[]{3});
		
		
		
		expectedBoard.put("G4", new int[]{3});
		expectedBoard.put("G5", new int[]{2});
		expectedBoard.put("G6", new int[]{6});
		
		expectedBoard.put("H4", new int[]{7,9});
		expectedBoard.put("H5", new int[]{5});
		expectedBoard.put("H6", new int[]{7,9});
		
		expectedBoard.put("I4", new int[]{4,9});
		expectedBoard.put("I5", new int[]{1});
		expectedBoard.put("I6", new int[]{8});
		
		
		expectedBoard.put("G7", new int[]{1,2,8});
		expectedBoard.put("G8", new int[]{7});
		expectedBoard.put("G9", new int[]{4});
		
		expectedBoard.put("H7", new int[]{1,2,8});
		expectedBoard.put("H8", new int[]{3});
		expectedBoard.put("H9", new int[]{6});
		
		expectedBoard.put("I7", new int[]{2});
		expectedBoard.put("I8", new int[]{5});
		expectedBoard.put("I9", new int[]{2,5,9});

		
		
		Map<String, int[]> actualBoard = sudokuService.initializeBoard(predefinedValues);
		sudokuService.reducePossibilitiesByCell(actualBoard);
		sudokuService.reducePossibilitiesByColumn(actualBoard);
		sudokuService.reducePossibilitiesByRow(actualBoard);
		
		sudokuService.displayBoard(actualBoard);
		
		assertBoardsAreEqual(expectedBoard, actualBoard);
	
	}

	
	@Test
	public void reducePossibilitiesByColumnWillRemovePossibilitiesBasedOnDuplicateValuesInTheSameColumn(){
		Map<String, int[]> expectedBoard = new Hashtable<String, int[]>();
		
		
		expectedBoard.put("A1", new int[]{2,3,4,5});
		expectedBoard.put("A2", new int[]{3,7});
		expectedBoard.put("A3", new int[]{2,5,7});
		
		expectedBoard.put("B1", new int[]{6});
		expectedBoard.put("B2", new int[]{8});
		expectedBoard.put("B3", new int[]{2,5,7});

		expectedBoard.put("C1", new int[]{1});
		expectedBoard.put("C2", new int[]{9});
		expectedBoard.put("C3", new int[]{2,5,7});

		expectedBoard.put("A4", new int[]{2});
		expectedBoard.put("A5", new int[]{6});
		expectedBoard.put("A6", new int[]{1,5,9});

		expectedBoard.put("B4", new int[]{5,8,9});
		expectedBoard.put("B5", new int[]{7});
		expectedBoard.put("B6", new int[]{1,5,9});
		
		expectedBoard.put("C4", new int[]{5,8,9});
		expectedBoard.put("C5", new int[]{3,8,9});
		expectedBoard.put("C6", new int[]{4});
		
		expectedBoard.put("A7", new int[]{7});
		expectedBoard.put("A8", new int[]{6,8});
		expectedBoard.put("A9", new int[]{1});
		
		expectedBoard.put("B7", new int[]{2,3,4,6,8});
		expectedBoard.put("B8", new int[]{9});
		expectedBoard.put("B9", new int[]{2,3});
		
		expectedBoard.put("C7", new int[]{5});
		expectedBoard.put("C8", new int[]{6,8});
		expectedBoard.put("C9", new int[]{2,3});

		
		expectedBoard.put("D1", new int[]{8});
		expectedBoard.put("D2", new int[]{2});
		expectedBoard.put("D3", new int[]{1,6,7});
		
		expectedBoard.put("E1", new int[]{3,9});
		expectedBoard.put("E2", new int[]{1,3,6,7});
		expectedBoard.put("E3", new int[]{4});
		
		expectedBoard.put("F1", new int[]{3,9});
		expectedBoard.put("F2", new int[]{5});
		expectedBoard.put("F3", new int[]{1,6,7});
		
		
		
		expectedBoard.put("D4", new int[]{1});
		expectedBoard.put("D5", new int[]{4,8,9});
		expectedBoard.put("D6", new int[]{5,7,9});
		
		expectedBoard.put("E4", new int[]{6});
		expectedBoard.put("E5", new int[]{4,8,9});
		expectedBoard.put("E6", new int[]{2});
		
		expectedBoard.put("F4", new int[]{4,5,7,8,9});
		expectedBoard.put("F5", new int[]{4,8,9});
		expectedBoard.put("F6", new int[]{3});
		
		
		expectedBoard.put("D7", new int[]{1,3,6});
		expectedBoard.put("D8", new int[]{4});
		expectedBoard.put("D9", new int[]{3,5,7});
		
		expectedBoard.put("E7", new int[]{9});
		expectedBoard.put("E8", new int[]{1,5,6});
		expectedBoard.put("E9", new int[]{3,5,7});
		
		expectedBoard.put("F7", new int[]{1,3,6});
		expectedBoard.put("F8", new int[]{2});
		expectedBoard.put("F9", new int[]{8});
		
		
		
		expectedBoard.put("G1", new int[]{2,5});
		expectedBoard.put("G2", new int[]{1,6});
		expectedBoard.put("G3", new int[]{9});
		
		expectedBoard.put("H1", new int[]{2,5});
		expectedBoard.put("H2", new int[]{4});
		expectedBoard.put("H3", new int[]{1,2,5,6,8});

		expectedBoard.put("I1", new int[]{7});
		expectedBoard.put("I2", new int[]{1,6});
		expectedBoard.put("I3", new int[]{3});
		
		
		
		expectedBoard.put("G4", new int[]{3});
		expectedBoard.put("G5", new int[]{2,4,9});
		expectedBoard.put("G6", new int[]{6,7,9});
		
		expectedBoard.put("H4", new int[]{4,7,9});
		expectedBoard.put("H5", new int[]{5});
		expectedBoard.put("H6", new int[]{6,7,9});
		
		expectedBoard.put("I4", new int[]{4,7,9});
		expectedBoard.put("I5", new int[]{1});
		expectedBoard.put("I6", new int[]{8});
		
		
		expectedBoard.put("G7", new int[]{1,2,8});
		expectedBoard.put("G8", new int[]{7});
		expectedBoard.put("G9", new int[]{4});
		
		expectedBoard.put("H7", new int[]{1,2,8});
		expectedBoard.put("H8", new int[]{3});
		expectedBoard.put("H9", new int[]{6});
		
		expectedBoard.put("I7", new int[]{1,2,8});
		expectedBoard.put("I8", new int[]{1,5,8});
		expectedBoard.put("I9", new int[]{2,5,9});

		
		
		Map<String, int[]> actualBoard = sudokuService.initializeBoard(predefinedValues);
		sudokuService.reducePossibilitiesByCell(actualBoard);
		sudokuService.reducePossibilitiesByColumn(actualBoard);
		
		assertBoardsAreEqual(expectedBoard, actualBoard);
		

	
	}
	
	
	@Test
	public void optimizeBoardWithValidPossibilitiesWillReturnBoardWithValidPossibilitiesOnly(){
		Map<String, int[]> expectedBoard = new Hashtable<String, int[]>();
		
		
		expectedBoard.put("A1", new int[]{2,3,4,5,7});
		expectedBoard.put("A2", new int[]{2,3,4,5,7});
		expectedBoard.put("A3", new int[]{2,3,4,5,7});
		
		expectedBoard.put("B1", new int[]{6});
		expectedBoard.put("B2", new int[]{8});
		expectedBoard.put("B3", new int[]{2,3,4,5,7});

		expectedBoard.put("C1", new int[]{1});
		expectedBoard.put("C2", new int[]{9});
		expectedBoard.put("C3", new int[]{2,3,4,5,7});

		
		
		expectedBoard.put("A4", new int[]{2});
		expectedBoard.put("A5", new int[]{6});
		expectedBoard.put("A6", new int[]{1,3,5,8,9});

		expectedBoard.put("B4", new int[]{1,3,5,8,9});
		expectedBoard.put("B5", new int[]{7});
		expectedBoard.put("B6", new int[]{1,3,5,8,9});
		
		expectedBoard.put("C4", new int[]{1,3,5,8,9});
		expectedBoard.put("C5", new int[]{1,3,5,8,9});
		expectedBoard.put("C6", new int[]{4});
		
		expectedBoard.put("A7", new int[]{7});
		expectedBoard.put("A8", new int[]{2,3,4,6,8});
		expectedBoard.put("A9", new int[]{1});
		
		expectedBoard.put("B7", new int[]{2,3,4,6,8});
		expectedBoard.put("B8", new int[]{9});
		expectedBoard.put("B9", new int[]{2,3,4,6,8});
		
		expectedBoard.put("C7", new int[]{5});
		expectedBoard.put("C8", new int[]{2,3,4,6,8});
		expectedBoard.put("C9", new int[]{2,3,4,6,8});

		
		expectedBoard.put("D1", new int[]{8});
		expectedBoard.put("D2", new int[]{2});
		expectedBoard.put("D3", new int[]{1,3,6,7,9});
		
		expectedBoard.put("E1", new int[]{1,3,6,7,9});
		expectedBoard.put("E2", new int[]{1,3,6,7,9});
		expectedBoard.put("E3", new int[]{4});
		
		expectedBoard.put("F1", new int[]{1,3,6,7,9});
		expectedBoard.put("F2", new int[]{5});
		expectedBoard.put("F3", new int[]{1,3,6,7,9});
		
		
		
		expectedBoard.put("D4", new int[]{1});
		expectedBoard.put("D5", new int[]{4,5,7,8,9});
		expectedBoard.put("D6", new int[]{4,5,7,8,9});
		
		expectedBoard.put("E4", new int[]{6});
		expectedBoard.put("E5", new int[]{4,5,7,8,9});
		expectedBoard.put("E6", new int[]{2});
		
		expectedBoard.put("F4", new int[]{4,5,7,8,9});
		expectedBoard.put("F5", new int[]{4,5,7,8,9});
		expectedBoard.put("F6", new int[]{3});
		
		
		expectedBoard.put("D7", new int[]{1,3,5,6,7});
		expectedBoard.put("D8", new int[]{4});
		expectedBoard.put("D9", new int[]{1,3,5,6,7});
		
		expectedBoard.put("E7", new int[]{9});
		expectedBoard.put("E8", new int[]{1,3,5,6,7});
		expectedBoard.put("E9", new int[]{1,3,5,6,7});
		
		expectedBoard.put("F7", new int[]{1,3,5,6,7});
		expectedBoard.put("F8", new int[]{2});
		expectedBoard.put("F9", new int[]{8});
		
		
		
		expectedBoard.put("G1", new int[]{1,2,5,6,8});
		expectedBoard.put("G2", new int[]{1,2,5,6,8});
		expectedBoard.put("G3", new int[]{9});
		
		expectedBoard.put("H1", new int[]{1,2,5,6,8});
		expectedBoard.put("H2", new int[]{4});
		expectedBoard.put("H3", new int[]{1,2,5,6,8});

		expectedBoard.put("I1", new int[]{7});
		expectedBoard.put("I2", new int[]{1,2,5,6,8});
		expectedBoard.put("I3", new int[]{3});
		
		
		
		expectedBoard.put("G4", new int[]{3});
		expectedBoard.put("G5", new int[]{2,4,6,7,9});
		expectedBoard.put("G6", new int[]{2,4,6,7,9});
		
		expectedBoard.put("H4", new int[]{2,4,6,7,9});
		expectedBoard.put("H5", new int[]{5});
		expectedBoard.put("H6", new int[]{2,4,6,7,9});
		
		expectedBoard.put("I4", new int[]{2,4,6,7,9});
		expectedBoard.put("I5", new int[]{1});
		expectedBoard.put("I6", new int[]{8});
		
		
		expectedBoard.put("G7", new int[]{1,2,5,8,9});
		expectedBoard.put("G8", new int[]{7});
		expectedBoard.put("G9", new int[]{4});
		
		expectedBoard.put("H7", new int[]{1,2,5,8,9});
		expectedBoard.put("H8", new int[]{3});
		expectedBoard.put("H9", new int[]{6});
		
		expectedBoard.put("I7", new int[]{1,2,5,8,9});
		expectedBoard.put("I8", new int[]{1,2,5,8,9});
		expectedBoard.put("I9", new int[]{1,2,5,8,9});

		
		
		Map<String, int[]> actualBoard = sudokuService.initializeBoard(predefinedValues);
		sudokuService.reducePossibilitiesByCell(actualBoard);
		assertBoardsAreEqual(expectedBoard, actualBoard);
		

	}
	
	@Test
	public void initializeBoardValuesWillInsertPredefinedValues()
	{
		Map<String, int[]> expectedBoard = new Hashtable<String, int[]>();
		
		
		expectedBoard.put("A1", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("A2", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("A3", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("A4", new int[]{2});
		expectedBoard.put("A5", new int[]{6});
		expectedBoard.put("A6", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("A7", new int[]{7});
		expectedBoard.put("A8", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("A9", new int[]{1});
		

		expectedBoard.put("B1", new int[]{6});
		expectedBoard.put("B2", new int[]{8});
		expectedBoard.put("B3", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("B4", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("B5", new int[]{7});
		expectedBoard.put("B6", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("B7", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("B8", new int[]{9});
		expectedBoard.put("B9", new int[]{1,2,3,4,5,6,7,8,9});
		
		expectedBoard.put("C1", new int[]{1});
		expectedBoard.put("C2", new int[]{9});
		expectedBoard.put("C3", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("C4", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("C5", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("C6", new int[]{4});
		expectedBoard.put("C7", new int[]{5});
		expectedBoard.put("C8", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("C9", new int[]{1,2,3,4,5,6,7,8,9});

		expectedBoard.put("D1", new int[]{8});
		expectedBoard.put("D2", new int[]{2});
		expectedBoard.put("D3", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("D4", new int[]{1});
		expectedBoard.put("D5", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("D6", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("D7", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("D8", new int[]{4});
		expectedBoard.put("D9", new int[]{1,2,3,4,5,6,7,8,9});
		
		expectedBoard.put("E1", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("E2", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("E3", new int[]{4});
		expectedBoard.put("E4", new int[]{6});
		expectedBoard.put("E5", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("E6", new int[]{2});
		expectedBoard.put("E7", new int[]{9});
		expectedBoard.put("E8", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("E9", new int[]{1,2,3,4,5,6,7,8,9});
		
		expectedBoard.put("F1", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("F2", new int[]{5});
		expectedBoard.put("F3", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("F4", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("F5", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("F6", new int[]{3});
		expectedBoard.put("F7", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("F8", new int[]{2});
		expectedBoard.put("F9", new int[]{8});
		
		expectedBoard.put("G1", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("G2", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("G3", new int[]{9});
		expectedBoard.put("G4", new int[]{3});
		expectedBoard.put("G5", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("G6", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("G7", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("G8", new int[]{7});
		expectedBoard.put("G9", new int[]{4});
		
		expectedBoard.put("H1", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("H2", new int[]{4});
		expectedBoard.put("H3", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("H4", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("H5", new int[]{5});
		expectedBoard.put("H6", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("H7", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("H8", new int[]{3});
		expectedBoard.put("H9", new int[]{6});
		
		expectedBoard.put("I1", new int[]{7});
		expectedBoard.put("I2", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("I3", new int[]{3});
		expectedBoard.put("I4", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("I5", new int[]{1});
		expectedBoard.put("I6", new int[]{8});
		expectedBoard.put("I7", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("I8", new int[]{1,2,3,4,5,6,7,8,9});
		expectedBoard.put("I9", new int[]{1,2,3,4,5,6,7,8,9});
		
		
		Map<String, int[]> actualBoard = sudokuService.initializeBoard(predefinedValues);
		assertBoardsAreEqual(expectedBoard, actualBoard);
		
	}
	
	public void assertBoardsAreEqual(Map<String, int[]> expectedBoard, Map<String, int[]> actualBoard){

		String[] alphaCoordinates = {"A","B","C","D","E","F","G","H","I"};
		int[] numericCoordinates = {1,2,3,4,5,6,7,8,9};
		for(String alphaCoordinate : alphaCoordinates){
			for(int numericCoordinate : numericCoordinates){
				assertArrayEquals("Asserting "+alphaCoordinate+numericCoordinate, expectedBoard.get(alphaCoordinate+numericCoordinate),actualBoard.get(alphaCoordinate+numericCoordinate));
			}
		}
	}
	
	
	
	
	
	@Test
	public void returnArrayListOfPredefinedValue(){
		
		
		List<int[]> expectedPredefinedValues = new ArrayList<int[]>();
		
		int[] intarray1 = {0,0,0,2,6,0,7,0,1};
		int[] intarray2 = {6,8,0,0,7,0,0,9,0};
		int[] intarray3 = {1,9,0,0,0,4,5,0,0};
		int[] intarray4 = {8,2,0,1,0,0,0,4,0};
		int[] intarray5 = {0,0,4,6,0,2,9,0,0};
		int[] intarray6 = {0,5,0,0,0,3,0,2,8};
		int[] intarray7 = {0,0,9,3,0,0,0,7,4};
		int[] intarray8 = {0,4,0,0,5,0,0,3,6};
		int[] intarray9 = {7,0,3,0,1,8,0,0,0};
		
		
		expectedPredefinedValues.add(intarray1);
		expectedPredefinedValues.add(intarray2);
		expectedPredefinedValues.add(intarray3);
		expectedPredefinedValues.add(intarray4);
		expectedPredefinedValues.add(intarray5);
		expectedPredefinedValues.add(intarray6);
		expectedPredefinedValues.add(intarray7);
		expectedPredefinedValues.add(intarray8);
		expectedPredefinedValues.add(intarray9);
		
		List<int[]> actualArray=sudokuService.convertInitialInputToArrayOfValues(predefinedValues);
		
		for(int i = 0; i<expectedPredefinedValues.size(); i++){
			assertArrayEquals(expectedPredefinedValues.get(i), actualArray.get(i));
		}
			
	}	
}