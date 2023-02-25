package com.tictactoe.Utils;

import com.tictactoe.models.Grid;
import com.tictactoe.models.Position;
import com.tictactoe.models.User;

import java.util.Scanner;

public class Utils {
    public static char AssignChar(){
        if(Math.random()%2==0){
            return 'X';
        }

        return '0';
    }


    public static Boolean checkVerticle(int row, int col, char ch, Grid grid){
        boolean isVerticle = true;
        for(int i = col; i>=0; i--){
            if(grid.getGrid()[row][i] != ch){
                isVerticle = false;
                return isVerticle;
            }
        }

        for(int i = col; i<grid.getDimension(); i++){
            if(grid.getGrid()[row][i] != ch){
                isVerticle = false;
                return isVerticle;
            }
        }

        return isVerticle;
    }

    public static Boolean checkHorizontal(int row,int col,char ch,Grid grid){
        boolean isHorizontal = true;
        for(int i = row;i>=0;i--){
            if(grid.getGrid()[i][col] != ch){
                isHorizontal = false;
                return isHorizontal;
            }
        }

        for(int i = row;i<grid.getDimension();i++){
            if(grid.getGrid()[i][col] != ch){
                isHorizontal = false;
                return isHorizontal;
            }
        }

        return isHorizontal;
    }

    public static Boolean checkDiagonal(int row,int col,char ch,Grid grid){
        Boolean isDiagonalRight = true;
        Boolean isDiagonalLeft = true;

        int dim = grid.getDimension();
        for(int i = 0, j = 0; i<dim && j<dim; i++,j++){
            if(grid.getGrid()[i][j] != ch){
                isDiagonalLeft = false;
                break;
            }
        }

        for(int i = dim-1, j = 0; i>=0 && j<dim; i--,j++){
            if(grid.getGrid()[i][j] != ch){
                isDiagonalRight = false;
                break;
            }
        }

        return isDiagonalRight || isDiagonalLeft;
    }


    public static Boolean isWinningCondition(Grid grid, char ch, int row, int col){
        Boolean isDiagonal = (row==col) || (row == 0 && col == 2) || (row == 2 && col == 0);

        //Verticle Axis
        if(checkVerticle(row,col,ch,grid)){
            return true;
        }

        //Horizontal Axis
        if(checkHorizontal(row,col,ch,grid)){
            return true;
        }

        //Diagonal Axis
        return isDiagonal && checkDiagonal(row, col, ch, grid);
    }

    public static Boolean isValidPosition(int row,int col,Grid grid){
        int dim = grid.getDimension();

        if(row<0 || row>=dim)
            return false;

        if(col<0 || col>=dim)
            return false;

        if(grid.getGrid()[row][col] != '-')
            return false;

        return true;
    }

    public static void PerformGridOperations(User user, Grid grid, int row, int col){
        grid.setGrid(user.getRoleAssigned(),row,col);
        grid.incFilledSize();
        grid.printGrid();
    }

    public static void InputPosition(Position userPosition, String userName, Boolean validPositionMessage, Scanner sc){
        if(!validPositionMessage){
            System.out.println(userName+" Enter Position : ");
        }
        else{
            System.out.println(userName+" please enter valid position : ");
        }

        userPosition.setRow(sc.nextInt() - 1);
        userPosition.setColumn(sc.nextInt() - 1);
    }
}
