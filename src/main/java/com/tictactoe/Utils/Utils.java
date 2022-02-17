package com.tictactoe.Utils;

import com.tictactoe.models.Grid;
import com.tictactoe.models.User;

public class Utils {
    public static char AssignChar(){
        if(Math.random()%2==0){
            return 'X';
        }

        return '0';
    }


    public static Boolean checkVerticle(int row, int col, char ch, Grid grid){
        boolean isVerticle = true;
        for(int i = col;i>=0;i--){
            if(grid.getGrid()[row][i] != ch){
                isVerticle = false;
                return isVerticle;
            }
        }

        for(int i = col;i<grid.getDimension();i++){
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
        Boolean isDiagonal = true;
        int dim = grid.getDimension();
        for(int i = row, j = col;i<dim && j<dim;i++,j++){
            if(grid.getGrid()[i][col] != ch){
                isDiagonal = false;
                return isDiagonal;
            }
        }

        for(int i = row, j = col;i>=0 && j>=0;i--,j--){
            if(grid.getGrid()[i][col] != ch){
                isDiagonal = false;
                return isDiagonal;
            }
        }

        return isDiagonal;
    }


    public static Boolean isWinningCondition(Grid grid,char ch,int row,int col){
        Boolean isDiagonal = (row==col);

        //Verticle Axis
        if(checkVerticle(row,col,ch,grid)){
            return true;
        }

        //Horizontal Axis
        if(checkHorizontal(row,col,ch,grid)){
            return true;
        }

        //Diagonal Axis
        if(isDiagonal && checkHorizontal(row,col,ch,grid)){
            return true;
        }

        return false;
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
}
