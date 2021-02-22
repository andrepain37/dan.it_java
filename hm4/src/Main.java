public class Main {



    public static void main(String[] args) {
        Human m1 = new Human("Elizabeth", "Smith", 1998);
        Human f1 = new Human("John", "Smith", 1997);



        Family fm1 = new Family(m1, f1);

        String[][] childSchedule = new String[1][2];
        childSchedule[0][0] = "Каждый день";
        childSchedule[0][1] = "просить кушать";

        String[] catHabits = new String[1];
        catHabits[0] = "Царапает стену";

        Human ср1 = new Human("John", "Smith", 2020, (byte) 60, childSchedule, fm1);
        Pet pt1 = new Pet("Cat", "Spider-man", 2, (byte) 60, catHabits);

        fm1.addChild(ср1);
        fm1.setPet(pt1);

        ср1.describePet();
        ср1.greetPet();

        pt1.eat();
        pt1.foul();
        pt1.respond();









        System.out.println( m1.toString());
        System.out.println( f1.toString());
        System.out.println( ср1.toString());
        System.out.println( fm1.toString());



        Human m2 = new Human();
        Human f2 = new Human();



        Family fm2 = new Family(m2, f2);

        System.out.println( m2.toString());
        System.out.println( f2.toString());
        System.out.println( fm2.toString());




    }
}
