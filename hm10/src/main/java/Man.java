final public class Man extends Human {

    public Man(String name, String surname, long year) {
        super(name, surname, year);
    }

    public Man(String name, String surname, String year, byte iq) {
        super(name, surname, year, iq);
    }

    public void greetPet(){
        System.out.printf("Здрав будь, %s\n", this.getFamily().getPet().getNickname());
    }

    public void repairCar(){
        System.out.println("Починка машины...");
    }
}
