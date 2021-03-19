import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

abstract public class Pet implements Serializable {

    private Species species = Species.UNKNOWN;
    private String nickname;
    private int age;
    private byte trickLevel;
    private Set<String> habits;



    @Override
    protected void finalize() {
        System.out.println(toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && trickLevel == pet.trickLevel && Objects.equals(habits, pet.habits);
    }

    @Override
    public String toString() {
        String classInfo = String.format("%s{" +
                        " nickname='%s'" +
                        ", age=%s" +
                        ", trickLevel=%s" +
                        ", habits=%s" +
                        '}',
                species, nickname, age, trickLevel, habits);

        return classInfo;
    }

    public String prettyFormat(){
        String classInfo = String.format("{" +
                        " species='%s'" +
                        ", nickname='%s'" +
                        ", age=%s" +
                        ", trickLevel=%s" +
                        ", habits=%s" +
                        '}',
                species, nickname, age, trickLevel, habits);

        return classInfo;
    }

    public Pet(String nickname, int age, byte trickLevel, Set<String> habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet() {
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
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

    public Set<String> getHabits() {
        return habits;
    }

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }

    public static void eat(){
        System.out.println("Я кушаю!");
    }

    abstract void respond();

}
