package org.gersty.sudoku.domain;
import java.util.Map;
import java.util.HashMap;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class SudokuBoard {


	private Map<String, int[]> board;
	private static final String[] alphaCoordinates = {"A","B","C","D","E","F","G","H","I"};
	private static final int[] numericCoordinates = {1,2,3,4,5,6,7,8,9};
	

	public SudokuBoard(){

		this.board=new HashMap<String, int[]>();
		for(String alphaCoordinate : alphaCoordinates){
			for(int numericCoordinate : numericCoordinates){
				this.board.put(alphaCoordinate+numericCoordinate, numericCoordinates);
			}
		}

	}

	public Map<String, int[]> getBoard(){
		return this.board;
	}

	public void setBoard(Map<String, int[]> board){
		this.board = board;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
	
	public String doNothing(){
		return "Do Nothing";
	}

}