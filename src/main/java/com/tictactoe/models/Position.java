package com.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

public class Position {
    private @Getter @Setter Integer row;
    private @Getter @Setter Integer column;

    public Position(Integer row, Integer column) {
        this.row = row;
        this.column = column;
    }
}
