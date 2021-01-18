package P4;

import java.util.Random;

/* This file includes:
 * 	1. Solution to P3
 *  2. Questions for P4. Comments starting with REQ represent the questions.
 *  
 * Features:
 * 	- We have from 1 to 3 players
 *  - We have many questions. Each player may be asked more than one question.
 *  - User can play many rounds of the game. 
 * 
 * Focus: 
 * 	- Arrays and Methods
 * 
 * Aim:
 * 	- Organize code and avoid code redundancy by the use of methods
 */

public class Main {				
	static Game game;			
	
	//Two arrays for questions and answers (both are global, i.e., accessible by all code in the class).
	//REQ1:	Replace array values with real questions/answers
	static String[] questions = {" What fluid is stored in the gallbladder?", "Who was the Greek god of fire?", "Where is headquarters of WorldBank? ", "Who discovered America?", "Which is the most densely populated country in the world?", "Dodoma is the capital of which African country", "What is the highest court in America?", "What is the difference between 5 and 2?", "What is the result of 10*1?"};

	static String[] answers =     {"Bile",   "Hephaestus",   "New York",   "Columbus",   "Monaco",   "Tanzania",   "The supreme court",   "3",   "10"};
	public static void main(String[] args) {
		String ans;
		do{								
			//Reset the game
			game = new Game();			
			
			//Get number of players (from 1 to 3)
			int numPlayers = game.askForInt("How many players", 1, 3);

			//Add up to 3 players to the game
			for (int i = 0; i < numPlayers; i++) {
				String name = game.askForText("What is player " + i + " name?");
				game.addPlayer(name);				
			}
			
			//REQ2:	Call a method to shuffle questions and answers. For that, you need to create a method with the header: void shuffleQuestions();
			shuffleQuestions();
			 int MaxQuestion=questions.length/numPlayers;
			//REQ3:	- Calculate the maximum number of rounds (each player is asked one question per round). The maximum number of rounds should be equal to the number of available questions divided by numPlayers. Store this value in a variable maxRounds
			//	- Ask the user about the number of rounds. The value read from the user should not exceed maxRounds. Store this value in a variable numRounds.
			//		- Ask each player the next unanswered question (e.g., player 0 gets the first question. If it is answered correctly, then player1 gets the next question in the array, otherwise player1 gets the same question again, and so on). 
			// 		  Assume that an incorrectly answered question will keep popping up until it is correctly answered or we finish all the rounds.
			//		  Hint: you need to create a for loop that repeats the below code block numRounds times.
			//		  Hint: you need to have a variable that keeps track of the next question to be offered. 
			
			int numQuestions=game.askForInt("How many questions should be given to each player?", 1, MaxQuestion);

			
			              if(numQuestions>MaxQuestion)

			                   numQuestions=MaxQuestion;			           			           
			              int temp=0;			              			
			for (int i = 0; i < numPlayers; i++) {
				game.setCurrentPlayer(i);//draw rectangle around player 0, and currentPlayer = player0
				 for(int kk=0;kk<numQuestions;kk++)

                 {

                     
                           if(temp==questions.length)

                                temp=0;
                           		String answer = game.askForText(questions[temp]);
                          

                           if(answers[temp].equals(answer))
                           {
                        	   game.correct();                                      
                                temp++;
       
                                break;
                           }
                           else
                        	   game.incorrect();    
                      }

          }   
			
			
			ans = game.askForText("Play again? (Y/N)"); 
			while(ans != null && !ans.toUpperCase().equals("Y") && !ans.toUpperCase().equals("N"))
				ans = game.askForText("Invalid input. Play again? (Y/N)");
		}while(ans.toUpperCase().equals("Y"));	//play again if the user answers "Y" or "y"

			System.exit(1); 	
		
	}
		public static void shuffleQuestions ()

	     {

	      

	          Random rk=new Random();

	        

	          int nlen=questions.length;

	        

	          for(int kk=0;kk<nlen;kk++)

	          {

	             

	              int tt=kk+rk.nextInt(nlen-kk);

	            

	              String temp=questions[kk];

	              questions[kk]=questions[tt];

	              questions[tt]=temp;

	            

	              temp=answers[kk];

	              answers[kk]=answers[tt];

	              answers[tt]=temp;

	          }

	     }

	}