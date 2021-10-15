package kr.ac.kopo.day12.homework;

public interface Game {

	final static int SCISSOR = 1;
	final static int ROCK = 2;
	final static int PAPER = 3;

	int startGame(int you);
}

