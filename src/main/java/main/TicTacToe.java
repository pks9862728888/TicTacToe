package main;

import java.util.*;

public class TicTacToe{
public static int[][] ticbox;
	public static int win(int [][]tic) 
	{
		// winner = 0 means there are no winner
		// winner = 1 means first player is winner
		// winner = 2 means second player is winner
		int winner = 0;
		
		//check all rows
		//loop through rows from 0 to 3 and check if all the 3 places have same marks
		for(int col = 0; col < 3; col++)
		{
			int tempWinner = tic[0][col];
			for(int row = 1; row < 3; row++)
			{
				if(tic[row][col] != tempWinner || tic[row][col] == 0)
				{
					tempWinner = 0;
					break;
				}
			}
			if(tempWinner != 0)
			{
				winner = tempWinner;
				break;
			}
		}
 		
		
		//check all cols
		//loop through columns from 0 to 3 and check if all the 3 places have same marks
 		if(winner == 0)
 		{
 			for(int row = 0; row < 3; row++)
 			{
 				int tempWinner = tic[row][0];
 				for(int col = 1; col < 3; col++)
 				{
 					if(tic[row][col] != tempWinner || tic[row][col] == 0)
 					{
 						tempWinner = 0;
 						break;
 					}
 				}
 				if(tempWinner != 0)
 				{
 					winner = tempWinner;
 					break;
 				}
 			}
 		}
 		
		//check both diagonals 
 		if(winner == 0)
 		{
 			//Checking for first diagonal
 			int tempWinner = tic[0][0];
 			for(int idx = 1; idx < 3; idx++)
 			{
 				if(tic[idx][idx] != tempWinner || tic[idx][idx] == 0)
 				{
 					tempWinner = 0;
 					break;
 				}
 			}
 			
 			// If there is no winner then checking for next diagonal
 			if(tempWinner == 0)
 			{
 				tempWinner = tic[0][2];
 				for(int idx = 0; idx < 3; idx++)
 				{
 					if(tic[idx][2 - idx] != tempWinner || tic[idx][2-idx] == 0)
 					{
 						tempWinner = 0;
 						break;
 					}
 				}
 			}
 			
 			// Updating winner if diagonals are same
 			if(tempWinner != 0)
 				winner = tempWinner;
 		}
		
		
		return winner;
		
	}
	
	public static void printBox(int [][]tic) {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(tic[i][j]);
			}
			System.out.println("");
		}
	}
	public static boolean validate(int a1,int a2,int [][] tic) {
		//check if a1 is between 0 & 3
		//check if a2 is between 0 & 3
		//check if the selected box is empty ie, already not marked by other player
		//if all checks passed return true.
		//Write your code here !!!
		Boolean returnValue = false;
		if(a1 >= 0 && a1 < 3 && a2 >= 0 && a2 < 3)
		{
			if(tic[a1][a2] == 0)
				returnValue = true;
		}
		return returnValue;
	}
	public static void main(String args[]) 
	{
		ticbox = new int[3][3];
		for(int i=0;i<3;i++) 
		{
			for(int j=0;j<3;j++) 
			{
				ticbox[i][j] = 0;
			}
		}
		
		int chk = win(ticbox);

		boolean turn= true;
		int limit = 9;
		while(chk==0 && limit > 0) 
		{
			//if true player 1	
			if(turn) {
				System.out.println("Player 1 Enter the box number");
				printBox(ticbox);
				Scanner sc = new Scanner(System.in);
				int a1 = sc.nextInt();
				int a2 = sc.nextInt();
				boolean valid = validate(a1,a2,ticbox);
				if(valid) {
					ticbox[a1][a2] = 1;
					chk = win(ticbox);
					turn = false;
					limit --;
				}
				else {
					System.out.println("Please enter a valid position!!");
				}
			}else {
				System.out.println("Player 2 Enter the box number");
				printBox(ticbox);
				Scanner sc = new Scanner(System.in);
				int a1 = sc.nextInt();
				int a2 = sc.nextInt();
				boolean valid = validate(a1,a2,ticbox);
				if(valid) {
				ticbox[a1][a2] = 2;
				chk = win(ticbox);
				turn = true;
				limit --;
				}
				else {
					System.out.println("Please enter a valid position!!");
				}
			}
			
			
			//if false player 2 
		}
		
		if(chk!=0) {
			System.out.println("The winner is Player "+chk);
		}else {
			System.out.println("Its a draw match!!");
		}
		
	}
}