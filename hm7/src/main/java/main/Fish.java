package main;

import java.util.Set;

public class Fish extends Pet {

    Species species = Species.FISH;

    public Fish(String nickname, int age, byte trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
        this.setSpecies(species);
    }

    void respond() {
        System.out.printf("Привет, хозяин. Я - %s. Я соскучился!\n", this.getNickname());
    }

    public void foul() {
        System.out.println("Нужно хорошо замести следы...");
    }
}
