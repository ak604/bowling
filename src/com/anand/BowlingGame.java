package com.anand;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class BowlingGame {

	GameSet gameSets[];
	public BowlingGame(GameSet[] gameSets, Player[] players) {
		super();
		this.gameSets = gameSets;
		this.players = players;
		this.currentSet=0;
	}
	Player[] players;
	int currentSet;
	int currentThrow;
	Score setScore;

	public static void main(String[] args) {


		int numSets =2;
		int numThrows=2;
		int numPins=10;
		GameSet[] gameSets = new GameSet[numSets];
		int[] bouns=new int[numThrows];
		bouns[0]=5;
		bouns[1]=10;

		for(int i=0;i<numSets;i++){
			gameSets[i]=new GameSet(numPins,numThrows,bouns);
		}
		File file = new File("input");
		InputStream inputStream=null ;
		try {
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner scanner = new Scanner(inputStream);
		int numPlayers=scanner.nextInt();

		Player[] players = new Player[numPlayers];
		for(int i=0;i<numPlayers;i++){
			players[i]= new Player("Player "+i,numSets);
		}
		BowlingGame game = new BowlingGame(gameSets, players);

		while(scanner.hasNext()){

			String val = scanner.nextLine();
			if(val.length()>0)
				game.onThrow(val.charAt(0));
		}
		scanner.close();
	}

	public int getPins(int numSet){
		return gameSets[numSet].getNumPins();
	}

	void onStrike(int currentPlayer){
		StrikeScore strikeScore = new StrikeScore(gameSets[currentSet]);
		players[currentPlayer].addScore(currentSet, strikeScore);
		setNextPlayer(currentPlayer);
	}

	public int getCurrentPlayer(){
		int currentPlayer=0;
		for(Player player : players){
			if(player.chanceComplete(currentSet))
				currentPlayer++;
			else
				break;
		}
		return currentPlayer%players.length;
		
	}
	void onSpare(int currentPlayer){
		setScore.setPins(gameSets[currentSet].getNumPins()-setScore.getTotalPins(),currentThrow);
		SpareScore spareScore=new SpareScore(setScore);
		players[currentPlayer].addScore(currentSet, spareScore);
		setNextPlayer(currentPlayer);
	}

	void onThrow(char input){

		int currentPlayer =getCurrentPlayer();
		if(input=='X'){
			onStrike(currentPlayer);
		}else if(input=='/'){
			onSpare(currentPlayer);
		}else{
			int val = input-'0';
			if(currentThrow==0){
				setScore= new Score(gameSets[currentSet]);
				setScore.setPins(val,currentThrow);
				players[currentPlayer].addScore(currentSet, setScore);
				currentThrow++;
			}
			else{
				setScore.setPins(val,currentThrow);
				players[currentPlayer].addScore(currentSet, setScore);
				setNextPlayer(currentPlayer);
			}

		}
		System.out.println("Scoreboard:");
		for(Player player: players){
			player.printCurrentScore();
		}
	}

	void setNextPlayer(int currentPlayer){
		if(currentPlayer==players.length-1){
			currentSet++;
			if(currentSet==gameSets.length){
				endGame();
			}
			
		}
		currentThrow=0;
	}
	void endGame(){
		
	}
}

