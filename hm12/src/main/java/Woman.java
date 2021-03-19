final public class Woman extends Human {

    public Woman(String name, String surname, long year) {
        super(name, surname, year);
    }

    public Woman(String name, String surname, String year, byte iq) {
        super(name, surname, year, iq);
    }

    public void greetPet() {
        System.out.printf("Привет, %s\n", this.getFamily().getPet().getNickname());
    }

    public void makeup() {
        System.out.println("Крашусь...");
    }

}
