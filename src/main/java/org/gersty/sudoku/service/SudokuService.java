package org.gersty.sudoku.service;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;


public class SudokuService{
	
	private static final String[] alphaCoordinates = {"A","B","C","D","E","F","G","H","I"};
	private static final String[] cell1= {"A1","A2","A3","B1","B2","B3","C1","C2","C3"};
	private static final String[] cell2= {"A4","A5","A6","B4","B5","B6","C4","C5","C6"};
	private static final String[] cell3= {"A7","A8","A9","B7","B8","B9","C7","C8","C9"};
	private static final String[] cell4= {"D1","D2","D3","E1","E2","E3","F1","F2","F3"};
	private static final String[] cell5= {"D4","D5","D6","E4","E5","E6","F4","F5","F6"};
	private static final String[] cell6= {"D7","D8","D9","E7","E8","E9","F7","F8","F9"};
	private static final String[] cell7= {"G1","G2","G3","H1","H2","H3","I1","I2","I3"};
	private static final String[] cell8= {"G4","G5","G6","H4","H5","H6","I4","I5","I6"};
	private static final String[] cell9= {"G7","G8","G9","H7","H8","H9","I7","I8","I9"};
	private static List<String[]> cells;
	private static final int[] numericCoordinates = {1,2,3,4,5,6,7,8,9};
	
	
	public SudokuService(){
		cells=new ArrayList<String[]>();
		cells.add(cell1);
		cells.add(cell2);
		cells.add(cell3);
		cells.add(cell4);
		cells.add(cell5);
		cells.add(cell6);
		cells.add(cell7);
		cells.add(cell8);
		cells.add(cell9);
		
	}
	
	protected ArrayList<int[]> convertInitialInputToArrayOfValues(String predefinedValues){
		ArrayList<int[]> returnList = new ArrayList<int[]>();
		
		String[] rowsFromPredefinedString = predefinedValues.split(",");
		for(String row : rowsFromPredefinedString){
			String[] actualValuesFromRow = row.split("\\|");
			int[] actualValues = new int[actualValuesFromRow.length];
			
			for(int i = 0; i<actualValuesFromRow.length; i++){
				actualValues[i]=Integer.valueOf(actualValuesFromRow[i]);
			}
			returnList.add(actualValues);
				
		}
		return returnList;
			
		
	}

	public Map<String, int[]> initializeBoard(String predefinedvalues) {
		
		List<int[]> rowsFromInitialInput = convertInitialInputToArrayOfValues(predefinedvalues);
		
		Map<String, int[]> boardToReturn = new Hashtable<String, int[]>();
		
		for(int i=0; i<alphaCoordinates.length; i++){
			int[] rowFromInitialInput = rowsFromInitialInput.get(i);
			for(int j =0; j<rowFromInitialInput.length; j++){
				
				if(rowFromInitialInput[j]==0)
					boardToReturn.put(alphaCoordinates[i]+(j+1), numericCoordinates);
				else
					boardToReturn.put(alphaCoordinates[i]+(j+1), new int[]{rowFromInitialInput[j]});
			}
		}
		return boardToReturn;
	}
	
	public void displayBoard(Map<String, int[]> boardToBeDisplayed){
		StringBuffer stringBuffer = new StringBuffer();
		
		for(String alphaCoordinate : alphaCoordinates){
			for(int numericCoordinate : numericCoordinates){
				int[] possibilitiesForGivenValueInCell = boardToBeDisplayed.get(alphaCoordinate+numericCoordinate);
				
				if(possibilitiesForGivenValueInCell.length==1){
					if(numericCoordinate==1)
						stringBuffer.append("|"+possibilitiesForGivenValueInCell[0]+"|");
					else
						stringBuffer.append(possibilitiesForGivenValueInCell[0]+"|");
				}
				else{
					if(numericCoordinate==1)
						stringBuffer.append("| |");
					else
						stringBuffer.append(" |");
				}
				if(numericCoordinate==9)
					stringBuffer.append("\n");
			}
		}
		
		System.out.println(stringBuffer);
		
	}

	public void reducePossibilitiesByCell(Map<String, int[]> actualBoard) {
		
		List<Integer> givenValues = new ArrayList<Integer>();

		Map<String, List<Integer>> possibilitySet = new Hashtable<String, List<Integer>>();
		for(String[] cellValues: cells){ 
			for(String cellValue: cellValues){
				if(actualBoard.get(cellValue).length==1)
					givenValues.addAll(convertIntArrayToList(actualBoard.get(cellValue)));
				else
					possibilitySet.put(cellValue, convertIntArrayToList(actualBoard.get(cellValue)));
			}
			
			for (Map.Entry<String, List<Integer>> entry : possibilitySet.entrySet()){
				for(int value : givenValues){
					List<Integer> reducedPossibilitySet = entry.getValue();
					if (reducedPossibilitySet.contains(value)){
						reducedPossibilitySet.remove(reducedPossibilitySet.indexOf(value));
						actualBoard.put(entry.getKey(), convertToArray(reducedPossibilitySet));
					}
				}
			}
			possibilitySet.clear();
			givenValues.clear();
		}
	}

	private int[] convertToArray(List<Integer> arrayToBeConverted){
		int[] returnIntArray =  new int[arrayToBeConverted.size()];
		for(int i=0; i<arrayToBeConverted.size(); i++){
			returnIntArray[i] = arrayToBeConverted.get(i);
		}
		return returnIntArray;
	}
	
	private List<Integer> convertIntArrayToList(int[] is) {
		List<Integer> returnList = new ArrayList<Integer>();
		for(int i:is){
			returnList.add(i);
		}
		return returnList;
	}

	public void reducePossibilitiesByColumn(Map<String, int[]> actualBoard) {
		
		List<Integer> givenValues = new ArrayList<Integer>();
		Map<String, List<Integer>> possibilitySet = new Hashtable<String, List<Integer>>();
		for(int numericCoordinate : numericCoordinates){
			for(String alphaCoordinate : alphaCoordinates){
				int[] listOfValues = actualBoard.get(alphaCoordinate+numericCoordinate);
				
				if(listOfValues.length==1){
					givenValues.add(listOfValues[0]);
				}
				else{
					possibilitySet.put(alphaCoordinate+numericCoordinate, convertIntArrayToList(listOfValues));
				}
					
			}
			for (Map.Entry<String, List<Integer>> entry : possibilitySet.entrySet()){
				for(int value : givenValues){
					List<Integer> reducedPossibilitySet = entry.getValue();
					if (reducedPossibilitySet.contains(value)){
						reducedPossibilitySet.remove(reducedPossibilitySet.indexOf(value));
						actualBoard.put(entry.getKey(), convertToArray(reducedPossibilitySet));
					}
				}
			}
			possibilitySet.clear();
			givenValues.clear();
		}
	}

	public void reducePossibilitiesByRow(Map<String, int[]> actualBoard) {
		List<Integer> givenValues = new ArrayList<Integer>();
		Map<String, List<Integer>> possibilitySet = new Hashtable<String, List<Integer>>();
		for(String alphaCoordinate : alphaCoordinates){
			for(int numericCoordinate : numericCoordinates){
				int[] listOfValues = actualBoard.get(alphaCoordinate+numericCoordinate);
				
				if(listOfValues.length==1){
					givenValues.add(listOfValues[0]);
				}
				else{
					possibilitySet.put(alphaCoordinate+numericCoordinate, convertIntArrayToList(listOfValues));
				}
					
			}
			for (Map.Entry<String, List<Integer>> entry : possibilitySet.entrySet()){
				for(int value : givenValues){
					List<Integer> reducedPossibilitySet = entry.getValue();
					if (reducedPossibilitySet.contains(value)){
						reducedPossibilitySet.remove(reducedPossibilitySet.indexOf(value));
						actualBoard.put(entry.getKey(), convertToArray(reducedPossibilitySet));
					}
				}
			}
			possibilitySet.clear();
			givenValues.clear();
		}
	}

	public boolean isBoardComplete(Map<String, int[]> expectedBoard) {
		
		for (Map.Entry<String, int[]> entry : expectedBoard.entrySet()){
			if(entry.getValue().length!=1)
				return false;
		}
		return true;
	}

	public boolean isBoardSolved(Map<String, int[]> solvedBoard) {
		return false;
//		for (Map.Entry<String, int[]> entry : solvedBoard.entrySet()){
//			
//			for(String alphaCoordinate : alphaCoordinates){
//				for(int numericCoordinate : numericCoordinates){
//					int[] listOfValues = solvedBoard.get(alphaCoordinate+numericCoordinate);
//					if(listOfValues.length==1 && entry.getValue().length)
//						if(listOfValues[0] == entry.getValue()[0])
//				}
//			
//			
//		}
	}
}
