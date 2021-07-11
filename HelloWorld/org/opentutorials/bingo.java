

import java.util.*;
import org.junit.jupiter.api.*;

public class bingo {
	
	
	public static void main(String[] args) {
			

			 final int SIZE = 5;
			 int x = 0;
			 int y = 0;
			 int  num = 0;
			 int countOfPlay = 0;
			 String [][] resultTable = {
					 {"[0,0]", "[0,1]","[0,2]","[0,3]","[0,4]"}, 
					 {"[1,0]", "[1,1]","[1,2]","[1,3]","[1,4]"},
					 {"[2,0]", "[2,1]","[2,2]","[2,3]","[2,4]"},
					 {"[3,0]", "[3,1]","[3,2]","[3,3]","[3,4]"},
					 {"[4,0]", "[4,1]","[4,2]","[4,3]","[4,4]"},
			 };
			 
			 // new number create 
			 int[][] table = new int [SIZE][SIZE];
			 for (int i = 0; i < SIZE; ++i)
			 {
				 for (int j = 0; j< SIZE; ++j)
				 {
					 table[i][j] = i * SIZE + j +1;
				 }
			 }
			 
			 // number shuffle
			 for (int i = 0; i < SIZE; ++i)
			 {
				 for (int j = 0; j< SIZE; ++j)
				 {
					 x = (int)(Math.random() * SIZE);
					 y = (int)(Math.random() * SIZE);
					 int temp = table [i][j];
					 table [i][j] = table [x][y];
					 table [x][y] = temp;
				 }
			 }
			 
			  
			 while (true)
			 {
				 
				// bingo table output
				 for (int i = 0; i < SIZE; ++i)
				 {
					 for (int j = 0; j< SIZE; ++j)
					 {
						System.out.print(String.format("%1$6s", resultTable[i][j]));
					 }
					 System.out.println();
				 }
			 
				 Scanner sc = new Scanner(System.in);
				 String consoleInput = sc.nextLine();
				 num = Integer.parseInt(consoleInput);
				 
				 System.out.println("1부터 25까지의 수를 입력하세요");
			 	 System.out.println("종료하려면 0을 입력하세요");

			 	 int countOfBingo = 0;
			 	 
			 	 going:
			 	 for (int i = 0; i < SIZE; ++i)
				 {
					 for (int j = 0; j< SIZE; ++j)
					 {
						 if(table[i][j] == num)
						 {
							 table[i][j] = 0;
							 resultTable[i][j] = consoleInput;
							 countOfPlay++;
							 break going;
						 }
					 }
				 }
				
			 	 //consider bingo in the table
			 	for (int i = 0; i < SIZE; ++i)
			 	{
			 			if (table [0][i] == 0 && table [1][i] == 0 && table [2][i] == 0 && table [3][i] == 0 && table [4][i] == 0)
			 			{
			 				countOfBingo++;
			 			}
			 			
			 			if (table [i][0] == 0 && table [i][1] == 0 && table [i][2] == 0 && table [i][3] == 0 && table [i][4] == 0)
			 			{
			 				countOfBingo++;
			 			}	
			 	}
			 	

				if(table[4][4] == 0 && table[3][3] == 0 && table[2][2] == 0 && table[1][1] == 0 && table[0][0] == 0)
				{
					System.out.println("왼쪽 대각선 빙고");
					countOfBingo++;
				}
				else if(table[4][0] == 0 && table[3][1] == 0 && table[2][2] == 0 && table[1][3] == 0 && table[0][4] == 0)
				{
					System.out.println("오른쪽 대각선 빙고");
					countOfBingo++;
				}
				
			 	System.out.printf("%d빙고%n", countOfBingo);
			 	 
				if(num == 0 || countOfPlay > 25)
				{
					System.out.println("종료되었습니다");
					break;
				}
				
			}
	
		
	}
}
