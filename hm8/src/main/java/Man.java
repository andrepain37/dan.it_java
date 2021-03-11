final public class Man extends Human {

    public Man(String name, String surname, int year) {
        super(name, surname, year);
    }

    public void greetPet(){
        System.out.printf("Здрав будь, %s\n", this.getFamily().getPet().getNickname());
    }

    public void repairCar(){
        System.out.println("Починка машины...");
    }
}
