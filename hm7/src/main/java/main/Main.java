package main;

import java.util.HashSet;
import java.util.Set;

public class Main {



    public static void main(String[] args) {

        Set<String> habits = new HashSet<String>();
        habits.add("прыгать");
        RoboCat rc1 = new RoboCat("RoboCat1", 2, (byte) 54, habits);

        rc1.respond();
        rc1.foul();



    }
}
