package com.anand;

public class GameSet {

	int numPins;
	int numThrows;
	int[] bouns;
	
	public int getNumPins() {
		return numPins;
	}

	public void setNumPins(int numPins) {
		this.numPins = numPins;
	}

	public int getNumThrows() {
		return numThrows;
	}

	public void setNumThrows(int numThrows) {
		this.numThrows = numThrows;
	}

	public int[] getBouns() {
		return bouns;
	}

	public void setBouns(int[] bouns) {
		this.bouns = bouns;
	}

	public GameSet(int numPins, int numThrows, int[] bouns) {
	
		this.numThrows = numThrows;
		this.bouns = bouns;
		this.numPins=numPins;
	}
	
	public int getBonus(int throwNum){
		if(throwNum > bouns.length){
			throw new RuntimeException("wrong strke number");
		}
		return bouns[throwNum-1];
	} 
}
