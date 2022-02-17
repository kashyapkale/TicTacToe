package com.tictactoe;

import com.tictactoe.Utils.Utils;
import com.tictactoe.models.Grid;
import com.tictactoe.models.User;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Details for Player 1 : ");
        String PlayerA = sc.nextLine();

        System.out.println("Enter Details for Player 2 : ");
        String PlayerB = sc.nextLine();

        System.out.println("Assigning Roles to Users : ");
        char roleA = Utils.AssignChar();
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
            while(!Utils.isValidPosition(row,col,grid)){
                System.out.println(userA.getName()+"Please Enter Valid Position : ");
                row = sc.nextInt() - 1;
                col = sc.nextInt() - 1;
            }
            Utils.PerformGridOperations(userA,grid,row,col);

            if(Utils.isWinningCondition(grid,userA.getRoleAssigned(),row,col) == true){
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
                while(!Utils.isValidPosition(row,col,grid)){
                    System.out.println(userB.getName()+"Please Enter Valid Position : ");
                    row = sc.nextInt() - 1;
                    col = sc.nextInt() - 1;
                }
                Utils.PerformGridOperations(userB,grid,row,col);


                if(Utils.isWinningCondition(grid,userB.getRoleAssigned(),row,col) == true){
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