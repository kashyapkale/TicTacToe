package com.tictactoe;

import com.tictactoe.Utils.Utils;
import com.tictactoe.models.Grid;
import com.tictactoe.models.Position;
import com.tictactoe.models.User;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of Player 1 : ");
        String PlayerA = sc.nextLine();

        System.out.println("Enter name of Player 2 : ");
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

        Position playerAPosition = new Position(-1,-1);
        Position playerBPosition = new Position(-1,-1);
        while(true){
            Utils.InputPosition(playerAPosition, userA.getName(), false, sc);
            while(!Utils.isValidPosition(playerAPosition.getRow(), playerAPosition.getColumn(), grid)){
                Utils.InputPosition(playerAPosition, userA.getName(), true, sc);
            }
            Utils.PerformGridOperations(userA, grid, playerAPosition.getRow(), playerAPosition.getColumn());

            if(Utils.isWinningCondition(
                    grid,
                    userA.getRoleAssigned(),
                    playerAPosition.getRow(),
                    playerAPosition.getColumn())){
                System.out.println(userA.getName()+" wins the game !!");
                break;
            }
            else if(grid.getIsComplete()){
                System.out.println("Its a Draw !!");
                break;
            }
            else{
                Utils.InputPosition(playerBPosition, userB.getName(), false, sc);
                while(!Utils.isValidPosition(playerBPosition.getRow(), playerBPosition.getColumn(), grid)){
                    Utils.InputPosition(playerBPosition, userB.getName(), true, sc);
                }
                Utils.PerformGridOperations(userB, grid, playerBPosition.getRow(), playerBPosition.getColumn());


                if(Utils.isWinningCondition(
                        grid,
                        userB.getRoleAssigned(),
                        playerBPosition.getRow(),
                        playerBPosition.getColumn())){
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