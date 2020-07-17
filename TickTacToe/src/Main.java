/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author walte
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Player player1 = new Player(getInput("Ingrese el nombre del Jugador 1 (X) : "));
        Player player2 = new Player(getInput("Ingrese el nombre del Jugador 2 (O) : "));
        Tablero tablero = new Tablero(player1,player2);
        tablero.imprimirTablero();

        while(tablero.getTurn() <= 9){
            if(tablero.getTurn() %2 != 0){
                player1.jugar(tablero);
                player1.setWinState(tablero.win(player1));
                if(player1.winState == true){
                    break;
                }
            }else{
                player2.jugar(tablero);
                player2.setWinState(tablero.win(player2));
                if(player2.winState == true){
                    break;
                }

            }
            tablero.imprimirTablero();
        }
        tablero.imprimirTablero();
        if(player1.winState == true){
            System.out.printf("Gano el jugador: %s\n",player1.getName());
        }
        else if(player2.winState == true){
            System.out.printf("Gano el jugador: %s\n",player2.getName());
        }
        else{
            System.out.println("Empate.");
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
