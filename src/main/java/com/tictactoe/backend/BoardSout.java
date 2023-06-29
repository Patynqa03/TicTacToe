package com.tictactoe.backend;

import java.util.Arrays;

public class BoardSout {





    public void boardPrev() {

        System.out.println("7|8|9");
        System.out.println("-+-+-");
        System.out.println("4|5|6");
        System.out.println("-+-+-");
        System.out.println("1|2|3");

    }


    public void beforeGame() {

        System.out.println();
        System.out.println("Gracze stawiają na przemian kółko i krzyżyk dążąc do zajęcia trzech pól w jednej linii.");
        System.out.println("Wygrywa ten z graczy, któremu jako pierwszemu uda ułożyć się trzy znaki w jednej linii.");
        System.out.println("Ruchy wykonywane są na podstawie planszy umieszczonej powyzej");
        System.out.println();
        System.out.println("Wybierz proszę czy chcesz grać z kimś (1) lub  z komputerem (2) ");
    }
}
