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
	
	protected ArrayList<int[]> organizePredifinedValues(String predefinedValues){
		ArrayList<int[]> returnList = new ArrayList<int[]>();
		
		String[] initialCells = predefinedValues.split(",");
		for(String value : initialCells){
			String[] actualValues = value.split("\\|");
			int[] myNewArray = new int[actualValues.length];
			
			for(int i = 0; i<actualValues.length; i++){
				myNewArray[i]=Integer.valueOf(actualValues[i]);
			}
			returnList.add(myNewArray);
				
		}
		return returnList;
			
		
	}

	public Map<String, int[]> initializeBoard(String predefinedvalues) {
		
		List<int[]> initialInput = organizePredifinedValues(predefinedvalues);
		
		
		
		Map<String, int[]> boardToReturn = new Hashtable<String, int[]>();
		
		for(int i=0; i<alphaCoordinates.length; i++){
			int[] myIntArray = initialInput.get(i);
			for(int j =0; j<myIntArray.length; j++){
				if(myIntArray[j]==0)
					boardToReturn.put(alphaCoordinates[i]+(j+1), numericCoordinates);
				else{
					int[] updatedIntArray = {myIntArray[j]};
					boardToReturn.put(alphaCoordinates[i]+(j+1), updatedIntArray);
				}
			}
		}
		return boardToReturn;
	}
	
	public void displayBoard(Map<String, int[]> boardToBeDisplayed){
		StringBuffer stringBuffer = new StringBuffer();
		
		for(String alphaCoordinate : alphaCoordinates){
			for(int numericCoordinate : numericCoordinates){
				int[] myIntArray = boardToBeDisplayed.get(alphaCoordinate+numericCoordinate);
				
				if(myIntArray.length==1){
					if(numericCoordinate==1)
						stringBuffer.append("|"+myIntArray[0]+"|");
					else
						stringBuffer.append(myIntArray[0]+"|");
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

	public void optimizeBoardWithValidPossibilities(Map<String, int[]> actualBoard) {
		
		List<Integer> givenValues = new ArrayList<Integer>();

		
		Map<String, List<Integer>> tempTable = new Hashtable<String, List<Integer>>();
		for(String[] cellValues: cells){  //cell1= {"A1","A2","A3","B1","B2","B3","C1","C2","C3"};
			for(String cellValue: cellValues){
				if(actualBoard.get(cellValue).length==1)
					givenValues.addAll(convertIntArrayToList(actualBoard.get(cellValue)));
				else
					tempTable.put(cellValue, convertMethod(actualBoard.get(cellValue)));
			}
			
			for (Map.Entry<String, List<Integer>> entry : tempTable.entrySet()){
				for(int value : givenValues){
					List<Integer> setToBeOptimizedSet = entry.getValue();
					if (setToBeOptimizedSet.contains(value)){
						setToBeOptimizedSet.remove(setToBeOptimizedSet.indexOf(value));
						actualBoard.put(entry.getKey(), convertToArray(setToBeOptimizedSet));
					}
				}
			}
			tempTable.clear();
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

	private List<Integer> convertMethod(int[] is) {
		//TODO REFACTOR OPPORTUNITY
		
		List<Integer> values = new ArrayList<Integer>();
		List<List<Integer>> returnList = new ArrayList<List<Integer>>();
		
		for(int i : is){
			values.add(i);
		}
		returnList.add(values);
		return values;
	}

	private List<Integer> convertIntArrayToList(int[] is) {
		List<Integer> returnList = new ArrayList<Integer>();
		for(int i:is){
			returnList.add(i);
		}
		return returnList;
	}
	

	
}