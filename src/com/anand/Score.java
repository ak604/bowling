package com.anand;

public class Score implements SetScore{
	
	public Score( GameSet gameSet) {
		this.throwsRequired = 0;
		this.gameSet = gameSet;
		this.pins = new int[gameSet.getNumThrows()];
	}

	int[] pins;
	int throwsRequired;
	GameSet gameSet;
	
	@Override
	public
	int getTotalPins(){
		int total=0;
		for(int i=0;i<throwsRequired;i++)
			total+=pins[i];
		return total;
	}
	
	@Override
	public String getScoreStr(){
		String result= "";
		for(int i=0;i<throwsRequired;i++)
			result=result+pins[i];
		return result;
	}
	
	public void incremetThrows(){
		throwsRequired++;
	}
	public void setPins(int pins,int currentThrow){
		this.pins[currentThrow]= pins;
		incremetThrows();
	}
	
	int getTotalScore(){
		return getTotalPins() + gameSet.getBonus(throwsRequired);
	}

	@Override
	public boolean isComplete() {
		if(this.throwsRequired==gameSet.numThrows)
			return true;
		return false;
	}
}

