import java.util.Arrays;
import java.util.Objects;

public class Human {

    private String name;
    private String surname;
    private int year;
    private byte iq;
    private String[][] schedule;
    private Family family;

    @Override
    protected void finalize() {
        System.out.println(toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return iq == human.iq && Arrays.equals(schedule, human.schedule);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(iq);
        result = 31 * result + Arrays.hashCode(schedule);
        return result;
    }

    @Override
    public String toString() {
        String classInfo = String.format("Human{" +
                        " name='%s'" +
                        ", surname=%s" +
                        ", year=%s" +
                        ", iq=%s" +
                        ", schedule=%s" +
                        '}',
                name,
                surname,
                year,
                iq,
                Arrays.deepToString(schedule));

        return classInfo;
    }

    public Human(String name, String surname, int year, byte iq, String[][] schedule, Family family){
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
        this.family = family;
    }

    public Human(String name, String surname, int year) {
        this.name = name;
        this.surname = surname;
        this.year = year;
    }

    public Human(Family family) {
        this.family = family;
    }

    public Human(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    public byte getIq() {
        return iq;
    }

    public void setIq(byte iq) {
        this.iq = iq;
    }

    public String[][] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[][] schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public void describePet(){
        System.out.printf("У меня есть %s, ему %s лет, он %s\n",
                this.family.getPet().getSpecies(), this.family.getPet().getAge(), (this.family.getPet().getTrickLevel() > 50 ? "очень хитрый" : "почти не хитрый"));
    }

    public void greetPet(){
        System.out.printf("Привет, %s\n", this.family.getPet().getNickname());
    }



}
