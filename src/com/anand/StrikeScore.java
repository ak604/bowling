package com.anand;

public class StrikeScore implements SetScore{

	GameSet gameSet;
	public StrikeScore(GameSet gameSet) {
		this.gameSet=gameSet;
		
	}
	
	@Override
	public
	int getTotalPins(){
		return gameSet.getNumPins();
	}
	
	@Override
	public String getScoreStr(){
		return "X";
	}

	@Override
	public boolean isComplete() {
		return true;
	}
}
