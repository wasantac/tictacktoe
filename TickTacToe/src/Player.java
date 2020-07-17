/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

/**
 *
 * @author walte
 */
public class Player {

    protected String name;
    char ficha;
    protected boolean winState = false;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getFicha() {
        return ficha;
    }

    public void setFicha(char ficha) {
        this.ficha = ficha;
    }

    public int jugar(Tablero t) {
        int move = 0;
        Scanner scanner = new Scanner(System.in);
        while (9 < move || move < 1) {
            System.out.print(name + ", where would you like to claim? [1-9] ");
            if (!scanner.hasNextInt()) {
                System.out.println("Try a number from 1-9.");
                scanner.nextLine();
            } else {
                move = scanner.nextInt();
            }
        }
        t.actualizarTablero(move, this);
        return move;
    }

    public boolean isWinState() {
        return winState;
    }

    public void setWinState(boolean winState) {
        this.winState = winState;
    }
    
    
}
