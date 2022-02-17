package com.tictactoe;

import com.tictactoe.models.Grid;
import com.tictactoe.models.User;

import java.util.Scanner;

public class Main {

    public static char AssignChar(){
        if(Math.random()%2==0){
            return 'X';
        }

        return '0';
    }


    public static Boolean checkVerticle(int row,int col,char ch,Grid grid){
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

    public static void PerformGridOperations(User user,Grid grid,int row,int col){
        grid.setGrid(user.getRoleAssigned(),row,col);
        grid.incFilledSize();
        grid.printGrid();
    }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Details for Player 1 : ");
        String PlayerA = sc.nextLine();

        System.out.println("Enter Details for Player 2 : ");
        String PlayerB = sc.nextLine();

        System.out.println("Assigning Roles to Users : ");
        char roleA = AssignChar();
        char roleB = (roleA=='X')?'0':'X';
        System.out.println(PlayerA+" got : "+roleA);
        System.out.println(PlayerB+" got : "+roleB);
        System.out.println("Creating Grid........");

        User userA = new User(PlayerA,1,roleA);
        User userB = new User(PlayerB,2,roleB);
        Grid grid = new Grid(3);

        while(true){
            System.out.println(userA.getName()+" Enter Position : ");
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            while(!isValidPosition(row,col,grid)){
                System.out.println(userA.getName()+"Please Enter Valid Position : ");
                row = sc.nextInt() - 1;
                col = sc.nextInt() - 1;
            }
            PerformGridOperations(userA,grid,row,col);

            if(isWinningCondition(grid,userA.getRoleAssigned(),row,col) == true){
                System.out.println(userA.getName()+" wins the game !!");
                break;
            }
            else if(grid.getIsComplete()){
                System.out.println("Its a Draw !!");
                break;
            }
            else{
                System.out.println(userB.getName()+" Enter Position : ");
                row = sc.nextInt() - 1;
                col = sc.nextInt() - 1;
                while(!isValidPosition(row,col,grid)){
                    System.out.println(userB.getName()+"Please Enter Valid Position : ");
                    row = sc.nextInt() - 1;
                    col = sc.nextInt() - 1;
                }
                PerformGridOperations(userB,grid,row,col);


                if(isWinningCondition(grid,userB.getRoleAssigned(),row,col) == true){
                    System.out.println(userB.getName()+" wins the game !!");
                    break;
                }
                else if(grid.getIsComplete()){
                    System.out.println("Its a Draw !!");
                    break;
                }
            }
        }
    }
}