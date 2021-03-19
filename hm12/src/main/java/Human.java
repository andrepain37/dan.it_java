import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Map;

abstract public class Human implements Serializable {

    private String name;
    private String surname;
    private long birthDate;
    private byte iq;
    private Map<DayOfWeek, String> schedule;
    private Family family;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Human human = (Human) o;

        if (birthDate != human.birthDate) return false;
        if (!name.equals(human.name)) return false;
        return surname.equals(human.surname);
    }

    @Override
    public int hashCode() {
        long result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + birthDate;
        return (int) result;
    }

    @Override
    protected void finalize() {
        System.out.println(toString());
    }

    public String prettyFormat() {
        StringBuilder sb = new StringBuilder();

        for (Field field : this.getClass().getDeclaredFields()) {
            field.setAccessible(true);

            try {
                sb.append(field.getName()).append(": ").append(field.get(this)).append('\n');
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

    @Override
    public String toString() {

        LocalDate dateBirthLD =
                Instant.ofEpochMilli(birthDate).atZone(ZoneId.systemDefault()).toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDateBirth = dateBirthLD.format(formatter);

        String classInfo = String.format("%s: {" +
                        " name='%s'" +
                        ", surname=%s" +
                        ", birthDate=%s" +
                        ", iq=%s" +
                        ", schedule=%s" +
                        '}',
                this.getClass().toString(),
                name,
                surname,
                formattedDateBirth,
                iq,
                schedule);

        return classInfo;
    }

    public Human(String name, String surname, long birthDate, byte iq, Map<DayOfWeek, String> schedule, Family family) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        this.schedule = schedule;
        this.family = family;
    }

    public Human(String name, String surname, String birthDate, byte iq) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDateLD = LocalDate.parse(birthDate, formatter);

        this.name = name;
        this.surname = surname;
        this.birthDate = birthDateLD.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
        this.iq = iq;
    }

    public Human(String name, String surname, long birthDate) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
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

    public long getYear() {
        return birthDate;
    }

    public void setYear(String birthDate ) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDateLD = LocalDate.parse(birthDate, formatter);

        this.birthDate = birthDateLD.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli();
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

    public String describeAge(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        LocalDate dateBirthLD =
                Instant.ofEpochMilli(birthDate).atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate startDate = LocalDate.parse(dateBirthLD.toString(), formatter);
        LocalDate endDate = LocalDate.parse(LocalDate.now().toString(), formatter);
        Period period = Period.between(startDate, endDate);

        return String.format("Прожил: %d лет, %d мес., %d дней!", period.getYears(), period.getMonths(), period.getDays());
    }

    abstract void greetPet();


}
