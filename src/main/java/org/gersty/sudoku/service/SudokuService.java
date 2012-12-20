package org.gersty.sudoku.service;




import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;


public class SudokuService{
	
	private static final String[] alphaCoordinates = {"A","B","C","D","E","F","G","H","I"};
	private static final int[] numericCoordinates = {1,2,3,4,5,6,7,8,9};
	
	protected ArrayList<int[]> organizePredifinedValues(String predefinedValues){
		ArrayList<int[]> returnList = new ArrayList<int[]>();
		
		String[] initialValuesFromcommas = predefinedValues.split(",");
		for(String value : initialValuesFromcommas){
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

	public Map<String, int[]> optimizeBoardWithValidPossibilities(
			Map<String, int[]> actualBoard) {
		

//		String[] alphaCoordinates = {"A","B","C","D","E","F","G","H","I"};
//		int[] numericCoordinates = {1,2,3,4,5,6,7,8,9};
//		for(String alphaCoordinate : alphaCoordinates){
//			
//			for(int firstColumn = 0; firstColumn<3; firstColumn++){
//				
//			}
//		
//		}
//		
		
		return new Hashtable<String, int[]>();

	}
	

	
}