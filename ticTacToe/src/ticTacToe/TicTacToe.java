package ticTacToe;
import java.util.*;

public class TicTacToe {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		char[][] grid = new char[3][3];
		
		createGrid(grid);
		char playersMove = 'X';
		while (true) {
			callCoordinates(playersMove, grid);
			if(checkWinner(grid)) {
				break;
			}
			if(playersMove == 'X') {
				playersMove = 'O';
			} else {
				playersMove = 'X';
			}
		}




	}
	
	public static void callCoordinates(char playersMove, char[][] grid) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
            System.out.println("Enter the coordinates: ");
            int x1, x2;
            try {
                x1 = scanner.nextInt();
                x2 = scanner.nextInt();
                if (x1 < 1 || x1 > 3 || x2 < 1 || x2 > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else {
                    if (grid[x1 - 1][x2 - 1] != ' ') {
                        System.out.println("This cell is occupied! Choose another one!");
                    } else {
                    	if(playersMove == 'X') {
                    		grid[x1 - 1][x2 - 1] = 'X';
                    		break;
                    	} else {
                    		grid[x1 - 1][x2 - 1] = 'O';
                    		break;
                    	}
                        
                    }
                }
            } catch(Exception NumberFormatException) {
                System.out.println("You should enter numbers!");
                scanner.nextLine();
            }
        }
		printGrid(grid);
	}
	
	//creating and printing empty grid
	public static void createGrid(char[][] grid) {
		System.out.println("---------");
		for(int i = 0; i < 3; i++) {
			System.out.print("| ");
			for(int j = 0; j < 3; j++) {
				grid[i][j] = ' ';
				System.out.print(grid[i][j] + " ");
			}
			System.out.print("|\n");
		}
		System.out.println("---------");
	}
	
	public static void printGrid(char[][] grid) {
		System.out.println("---------");
		for(int i = 0; i < 3; i++) {
			System.out.print("| ");
			for(int j = 0; j < 3; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.print("|\n");
		}
		System.out.println("---------");
	}
	
	public static boolean checkWinner (char[][] grid){
		char answer = 'P';
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(i == 1 && grid[i][j] != ' ' && grid[i][j] == grid[i+1][j] && grid[i+1][j] == grid[i-1][j]) {
					answer = grid[i][j];
				} else if(j == 1 && grid[i][j] != ' ' && grid[i][j] == grid[i][j-1] && grid[i][j-1] == grid[i][j+1]) {
					answer = grid[i][j];
				} else if (i == 1 && j == 1 && grid[i][j] == grid[i-1][j-1] && grid[i][j] == grid[i+1][j+1]) {
					answer = grid[i][j];
				} else if (i == 1 && j == 1 && grid[i][j] == grid[i-1][j+1] && grid[i][j] == grid[i+1][j-1]) {
					answer = grid[i][j];
				}
			} 
		}
		
		int nonEmpty = 0;
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(grid[i][j] != ' ') {
					nonEmpty++;
				}
			}
		}
		if (answer == 'O') {
			System.out.println("O wins");
			return true;
		} else if (answer == 'X') {
			System.out.println("X wins");
			return true;
		} else if (nonEmpty == 9) {
			System.out.println("Draw");
			return true;
		} else {
			return false;
		}
			
	}
}
