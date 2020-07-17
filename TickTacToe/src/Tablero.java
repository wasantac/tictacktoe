/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Date;

/**
 *
 * @author walte
 */
public class Tablero {

    public int turn = 1;
    protected Date date;
    protected Player player1;
    protected Player player2;
    protected char[][] tablero;

    public Tablero(Player player1, Player player2) {
        date = new Date();
        this.player1 = player1;
        this.player2 = player2;
        tablero = new char[3][3];
        this.player1.setFicha('X');
        this.player2.setFicha('O');
        System.out.println(date);
    }

    public int getTurn() {
        return turn;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public char[][] getTablero() {
        return tablero;
    }

    public void actualizarTablero(int move, Player p) {
        int posX = pos1(move);
        int posY = pos2(move);
        if (tablero[posX][posY] == 'X' || tablero[posX][posY] == 'O') {
            System.out.println("Ya existe una ficha en esa posicion.");

        } else {
            tablero[posX][posY] = p.getFicha();
            turn++;
        }

    }

    private int pos1(int move) {
        if (move > 0 && move <= 3) {
            return 0;
        } else if (move > 3 && move <= 6) {
            return 1;
        } else {
            return 2;
        }
    }

    private int pos2(int move) {
        int pos = move%3 - 1;
        if(pos < 0) return 2;
        else return pos;
    }

    public void imprimirTablero() {
        int cont = 1;
        for (char[] tablero1 : tablero) {
            for (int col = 0; col < tablero.length; col++) {
                if (tablero1[col] == 'X' || tablero1[col] == 'O') {
                    System.out.printf("|_%c_|", tablero1[col]);
                    cont++;
                } else {
                    System.out.printf("|_%d_|", cont++);
                }
            }
            System.out.println("");
        }
    }

    public boolean win(Player p) {
        //check rows for win
        if (turn < 5) {
            return false;
        } else {
            //check rows
            for (char[] tablero1 : tablero) {
                if (tablero1[0] == tablero1[1] && tablero1[0] == tablero1[2] && tablero1[0] == p.getFicha()) {
                    return true;
                }
            }

            //Check columns for wins
            for (int col = 0; col < tablero.length; col++) {
                if (tablero[0][col] == tablero[1][col] && tablero[1][col] == tablero[2][col] && tablero[0][col] == p.getFicha()) {
                    return true;
                }
            }
            // check diagonals for wins

            if (tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2] && tablero[1][1] == p.getFicha()) {
                return true;
            } else if (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0] && tablero[1][1] == p.getFicha()) {
                return true;
            }

            // if no wins return 0
            return false;
        }
    }

}
