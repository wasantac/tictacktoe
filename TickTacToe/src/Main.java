import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;
public class Main {

static int numTurns = 1;
	
	public static void main(String[] args) {
		// 
		Date date = new Date();
		System.out.println(date.toString());
		String player1 = getInput("Please enter first player's name: ");
		String player2 = getInput("Please enter second player's name: ");

		char x = 'X';
		char o = 'O';
		Scanner scanner = new Scanner(System.in);
		
		char[] pos = {'1','2','3','4','5','6','7','8','9'};
		printPlayingField(pos);
		
		//Make sure game is not over.  Game ends when there have been 9 turns or someone gets three in a row
		while(numTurns <= 9 && win(pos) == 0)
		{	
		int move = 0;
		//Player one's turn on odd turns
		if (numTurns % 2 != 0){
			while(9 < move || move < 1){
			System.out.print(player1 + ", where would you like to claim? [1-9] ");
			if (!scanner.hasNextInt()){
				System.out.println("Try a number from 1-9.");
			scanner.nextLine();
			}else
	      move = scanner.nextInt();
		}
			pos = makeMove(pos, move, x);	
		//Player two's turn
		}else{
			while(9 < move || move < 1){
				System.out.print(player2 + ", where would you like to claim? [1-9] ");
				if (!scanner.hasNextInt()){
					System.out.println("Try a number from 1-9.");
					scanner.nextLine();
				}else
					move = scanner.nextInt();
			}
			pos = makeMove(pos, move, o);
		}
	}
		//Check for winner
		char winner = win(pos);
		if( winner != 0){
			scanner.close();
			System.out.println("We have a winner!");
			if((numTurns-1) % 2 != 0 ){
				System.out.println(player1 +" WINS!");
			}else 
				System.out.println(player2 +" WINS!");
		} else 
			System.out.println("No Winner. Game Over.");
		}
	
	private static void printPlayingField(char[] pos){
		
		StringBuilder[] playingField={new StringBuilder( "__1__|__2__|__3__ "), new StringBuilder("__4__|__5__|__6__ "),new StringBuilder("  7  |  8  |  9  ")};

		
		for (int row = 0; row < 3; row++){
			playingField[row].delete(0,playingField[row].length()-1);
			for (int col = 1; col < 4; col++)
			{

				if (row < 2){
					if(col <3){
						playingField[row].append("__"+ pos[row*3 + col -1] + "__|");
					} else playingField[row].append("__" + pos[row*3 + col -1] + "__");
				} else{
					if(col <3){
						playingField[row].append("  "+ pos[row*3 + col -1] + "  |");
					} else playingField[row].append("  " + pos[row*3 + col -1] + "  ");
				}
			
			}
		
		}
		System.out.println (playingField[0]);
		System.out.println (playingField[1]);
		System.out.println (playingField[2]);

	}
	private static char[] makeMove(char[] pos, int move, char player){

			//check to make sure move is available
			if(pos[move-1] != 'X' && pos[move-1]!='O')
   		{
   			pos[move-1] = player;
   			printPlayingField(pos);
   			numTurns++;
   		} else {
   			System.out.println("That spot is taken!");
   		}

		return pos;
	}
	private static char win(char[] pos){
		//check rows for win
		if (numTurns < 5)
			return 0;
		else{
   		for(int i =0; i<9;i+=3){
   			if(pos[i] == pos[i+1] && pos[i+1] == pos[i+2])
   				return pos[i];
   		}
   		//Check columns for wins
   		for (int i = 0; i<3; i++){
   			if (pos[i] == pos[i+3] && pos[i+3] == pos[i+6])
   				return pos[i];
   		}
   		// check diagonals for wins
   			if(pos[0] == pos[4] && pos[4] == pos[8])
   				return pos[0];
   			else if (pos[2] == pos[4] && pos[4] == pos[6])
   				return pos[2];
   		// if no wins return 0
   		return 0;
		}
	}
	private static String getInput(String prompt){
		BufferedReader stdin = new BufferedReader(
				new InputStreamReader(System.in));
		System.out.print(prompt);
		System.out.flush();
		
		try{
			return stdin.readLine();
		}catch(Exception e){
			return "Error: " + e.getMessage();
		}
	}
}
