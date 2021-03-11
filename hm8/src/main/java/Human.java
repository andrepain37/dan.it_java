import java.util.Map;
import java.util.Objects;

abstract public class Human {

    private String name;
    private String surname;
    private int year;
    private byte iq;
    private Map<DayOfWeek, String> schedule;
    private Family family;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (year != human.year) return false;
        if (!name.equals(human.name)) return false;
        return surname.equals(human.surname);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + year;
        return result;
    }

    @Override
    protected void finalize() {
        System.out.println(toString());
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
                schedule);

        return classInfo;
    }

    public Human(String name, String surname, int year, byte iq, Map<DayOfWeek, String> schedule, Family family) {
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

    public Human() {
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

    public Map<DayOfWeek, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<DayOfWeek, String> schedule) {
        this.schedule = schedule;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

    public void describePet() {
        System.out.printf("У меня есть %s, ему %s лет, он %s\n",
                this.family.getPet().getSpecies(), this.family.getPet().getAge(), (this.family.getPet().getTrickLevel() > 50 ? "очень хитрый" : "почти не хитрый"));
    }

    abstract void greetPet();


}
