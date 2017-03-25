package eg.edu.alexu.csd.datastructure.hangman.cs61;

import java.util.*;

public class Test {

	public static void main(String[] args){
		
		String[] words = { "Roloi" };
		Hangman game = new Hangman();
		Scanner scn = new Scanner(System.in);
		
		
//		game.readFromFile();
		game.setDictionary(words);
		System.out.print("Set the number of wrong guesses:");
		game.setMaxWrongGuesses(scn.nextInt());
		
		System.out.println(game.getHidden());

		while(game.getMaxWrongGuesses()> 1 && !game.isWin())
		{
			System.out.println("Max guesses:" + game.getMaxWrongGuesses());
			System.out.println("Enter a character:");
			System.out.println(game.guess(scn.next().charAt(0)));
			System.out.println();
			System.out.println();
			System.out.println();
		}
		
		if(game.getMaxWrongGuesses() <= 1)
			game.loser();
		else
			game.winner();
		
		scn.close();
	}

}
