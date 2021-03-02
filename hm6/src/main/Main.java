package main;

public class Main {



    public static void main(String[] args) {

        String[] habits = new String[2];
        RoboCat rc1 = new RoboCat("RoboCat1", 2, (byte) 54, habits);

        rc1.respond();
        rc1.foul();



    }
}
