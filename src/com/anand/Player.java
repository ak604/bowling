package com.anand;

public class Player {

	String name;
	SetScore[] setScores;
	
	public Player(String name,int numSets) {
		this.name = name;
		setScores= new SetScore[numSets];
	}
	
	String getScoreStr(){
		
		String result="";
		for(SetScore setScore : setScores){
			if(setScore==null)
				result+="";
			else
				result = result + setScore.getScoreStr();
		}
		return result;
	}
	void printCurrentScore(){
		System.out.println(name+":"+getScoreStr());
	}
	
	public void addScore(int setNum, SetScore setScore){
		setScores[setNum]=setScore;
	}

	public boolean chanceComplete(int currentSet) {
		if(setScores[currentSet]!=null){
			return setScores[currentSet].isComplete();
		}
		return false;
	}
	
}
