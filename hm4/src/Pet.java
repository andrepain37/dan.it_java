import java.util.Arrays;
import java.util.Objects;

public class Pet {

    private String species;
    private String nickname;
    private int age;
    private byte trickLevel;
    private String[] habits;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && trickLevel == pet.trickLevel && Arrays.equals(habits, pet.habits);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(age, trickLevel);
        result = 31 * result + Arrays.hashCode(habits);
        return result;
    }

    @Override
    public String toString() {
        String classInfo = String.format("%s{" +
                        " nickname='%s'" +
                        ", age=%s" +
                        ", trickLevel=%s" +
                        ", habits=%s" +
                        '}',
                species, nickname, age, trickLevel, Arrays.toString(habits));

        return classInfo;
    }

    public Pet(String species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(String species, String nickname, int age, byte trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet() {
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public byte getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(byte trickLevel) {
        this.trickLevel = trickLevel;
    }

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    public static void eat(){
        System.out.println("Я кушаю!");
    }

    public static void foul(){
        System.out.println("Нужно хорошо замести следы...");
    }

    public void respond(){
        System.out.printf("Привет, хозяин. Я - %s. Я соскучился!\n", this.nickname);
    }

}
