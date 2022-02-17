package com.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class User {
    private @Getter @Setter String Name;
    private @Getter @Setter Integer id;
    private @Getter @Setter char RoleAssigned;
}
