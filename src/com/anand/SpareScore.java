package com.anand;

public class SpareScore implements SetScore {

	
	Score setScore;
	
	public SpareScore(Score setScore) {
		super();
		this.setScore=setScore;;
	}
	@Override
	public
	int getTotalPins(){
		return setScore.gameSet.getNumPins();
	}
	@Override
	public String getScoreStr(){
		String result="";
		for(int i=0;i<setScore.throwsRequired-1;i++)
			result=result+setScore.pins[i];
		result =result+"/";
		return result;
	}
	@Override
	public boolean isComplete() {
		return true;
	}
}
