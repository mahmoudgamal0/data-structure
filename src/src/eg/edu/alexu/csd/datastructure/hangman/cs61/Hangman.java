package eg.edu.alexu.csd.datastructure.hangman.cs61;
import java.io.*;
import java.util.*;

import eg.edu.alexu.csd.datastructure.hangman.IHangman;

public class Hangman implements IHangman{

	
	private String randomWord;
	private String hiddenWord;
	private int wordsArrayLength = 0;
	private int maxWrong;
	private String[] words;
	private boolean start = false;
	
	
	public void readFromFile()
	{
		try {
			BufferedReader br = new BufferedReader(new FileReader("Dictionary.txt"));
			this.linesCounter("Dictionary.txt");
			this.words  = new String[this.wordsArrayLength];
			for(int i = 0; i<this.words.length;i++)
			{
				this.words[i] = br.readLine();
			}
			
			br.close();
		} 
		catch (Exception e) {
			System.out.println("File Not Found!!");
		}
	}
	
	public void linesCounter(String fileName)
	{
		try{
			BufferedReader fileTraverser = new BufferedReader(new FileReader(fileName));
			while(fileTraverser.readLine() != null)
				this.wordsArrayLength++;
			fileTraverser.close();
		}
		catch (Exception e){
			System.out.println("File not found!!");
		}
	}
	
	@Override
	public void setDictionary(String[] words) {
		this.start = false;
		this.words = new String[100];
		this.words = words;
		this.wordsArrayLength = this.words.length;
	}

	@Override
	public String selectRandomSecretWord() {
		if(start)
			return null;
		if(this.wordsArrayLength == 0)
			return null;
		else
		{
			int randomLineNumber;
			Random randomNumberGenerator = new Random();
			randomLineNumber = randomNumberGenerator.nextInt(this.wordsArrayLength);	
			this.randomWord = this.words[randomLineNumber];
			return this.randomWord;
		}
		
		
	}

	@Override
	public String guess(Character c) {
		boolean flag = false;
		if(!start)
			this.hiddenWord = getHidden();
		if(c==null)
			return null;
		else if(this.maxWrong > 0)
		{
			String temp = "";
			for(int i = 0 ; i< this.randomWord.length() ; i++)
			{
				if(Character.toLowerCase(this.randomWord.charAt(i)) == Character.toLowerCase(c) )
				{
					temp += this.randomWord.charAt(i) ;
					flag = true;
				}
				else if(this.hiddenWord.charAt(i) != '-')
				{
					temp += this.hiddenWord.charAt(i);
				}
				else
					temp += "-";
				
			}
			this.hiddenWord = temp;
			if(!flag)
				this.maxWrong--;
			if(this.maxWrong == 0)
				return null;
			else
				return this.hiddenWord;
		}
		else
			return null;
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
		if(max == null)
			this.maxWrong = 0;
		else
			this.maxWrong = max;
	}
	
	public String setHidden(int lettersNumber)
	{
		String hiddenWord = "";
		for(int i = 0; i<lettersNumber; i++)
		{
			hiddenWord += "-";
		}
		return hiddenWord;
	}
	
	public int getMaxWrongGuesses()
	{
		return this.maxWrong;
	}
	
	public boolean isWin()
	{
		if(this.hiddenWord.equalsIgnoreCase(this.randomWord))
			return true;
		return false;
	}
	
	public void loser()
	{
		System.out.println("looooooooser!!");
	}
	
	public void winner()
	{
		System.out.println("winnnnneeeeerrrr!!");
	}
	
	public String getHidden()
	{
		this.selectRandomSecretWord();
		this.hiddenWord = setHidden(this.randomWord.length());
		start = true;
		return this.hiddenWord;
	}
}
