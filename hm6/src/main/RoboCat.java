package main;

public class RoboCat extends Pet implements Foul {
    Species species = Species.ROBOCAT;

    public RoboCat(String nickname, int age, byte trickLevel, String[] habits) {
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
