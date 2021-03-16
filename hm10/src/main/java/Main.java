import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {


    public static void main(String[] args) throws ParseException {
        FamilyController f = new FamilyController();
        Man m1 = new Man("c1", "c1", 123);
        Woman w1 = new Woman("c1", "c1", 123);
        Man m2 = new Man("c2", "c2", 2332);
        Family f1 = new Family(m1, w1);
        Family f2 = new Family(w1, m2);
        f.saveFamily(f1);
        f.saveFamily(f2);

        f.deleteFamily(0);
        f.deleteFamily(f2);

        f.saveFamily(f1);
        f.createNewFamily(w1, m2);

        f.bornChild(f.getAllFamilies().get(1), "John", "Elizabeth");

        Woman c1 = new Woman("Andre", "Owens", 1999);
        f.adoptChild(f.getAllFamilies().get(1), c1);
        f.deleteAllChildrenOlderThen(18);
        f.count();
        Set<String> habbits = new HashSet<String>();
        Pet p1 = new DomesticCat("bob", 2, (byte) 50, habbits);
        f.addPet(1, p1);
        f.getPets(1);


        f.displayAllFamilies();
        System.out.println(f.getFamilyByIndex(0));



        System.out.println(f.getFamiliesBiggerThan(3));
        System.out.println(f.getFamiliesLessThan(3));
        System.out.println(f.countFamiliesWithMemberNumber(1));
        System.out.println(f.countFamiliesWithMemberNumber(3));
    }

}
