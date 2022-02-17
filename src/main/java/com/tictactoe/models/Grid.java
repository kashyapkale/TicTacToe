package com.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


public class Grid {
    private @Getter @Setter int dimension;
    private @Getter @Setter Boolean isComplete;
    private @Getter int FilledSize = 0;
    private int MaxGridSize;
    private char[][] grid;

    public Grid(int dimension){
        this.dimension = dimension;
        this.isComplete = false;
        this.MaxGridSize = dimension*dimension;
        this.grid = new char[dimension][dimension];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = '-';
                System.out.print(grid[i][j]+" ");
            }
            System.out.println("");
        }
    }



    public void incFilledSize(){
            FilledSize++;
            if(FilledSize == MaxGridSize){
                isComplete = true;
            }
    }

    public void setGrid(char ch,int row,int col){
            grid[row][col] = ch;
    }

    public char[][] getGrid(){
        return grid;
    }

    public void printGrid(){
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
