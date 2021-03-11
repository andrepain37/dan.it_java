final public class Woman extends Human {

    public Woman(String name, String surname, int year) {
        super(name, surname, year);
    }

    public void greetPet() {
        System.out.printf("Привет, %s\n", this.getFamily().getPet().getNickname());
    }

    public void makeup() {
        System.out.println("Крашусь...");
    }

}
