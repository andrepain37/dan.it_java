import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class FamilyServiceTest {

    private static FamilyService f;
    private static Family family;

    @org.junit.jupiter.api.BeforeEach
     void saveFamily(){
        f = new FamilyService();
        Man m1 = new Man("c1", "c1", 123);
        Woman w1 = new Woman("c1", "c1", 123);
        family = new Family(m1, w1);

        f.saveFamily(family);
    }

    @org.junit.jupiter.api.Test
    void getAllFamilies() {

        List<Family> expected = new ArrayList<Family>();
        expected.add(family);
        List<Family> real = f.getAllFamilies();
        assertEquals(expected, real);
    }

    @org.junit.jupiter.api.Test
    void getFamiliesBiggerThan () {

        Man c1 = new Man("c2", "c2", 1999);
        f.adoptChild(family, c1);

        List<Family> expected = new ArrayList<Family>();
        expected.add(family);

        List<Family> real = f.getFamiliesBiggerThan(2);
        assertEquals(expected, real);
    }

    @org.junit.jupiter.api.Test
    void getFamiliesLessThan () {

        Man c1 = new Man("c2", "c2", 1999);
        f.adoptChild(family, c1);

        List<Family> expected = new ArrayList<Family>();

        List<Family> real = f.getFamiliesLessThan(1);
        assertEquals(expected, real);
    }

    @org.junit.jupiter.api.Test
    void countFamiliesWithMemberNumber() {

        Man c1 = new Man("c2", "c2", 1999);
        f.adoptChild(family, c1);

        int expected = 1;
        int real = f.countFamiliesWithMemberNumber(3);
        assertEquals(expected, real);
    }

    @org.junit.jupiter.api.Test
    void createNewFamily() {

        Man c1 = new Man("c2", "c2", 1999);
        Woman c2 = new Woman("c3", "c3", 2000);
        f.createNewFamily(c1, c2);

        List<Family> expected = new ArrayList<Family>();

        Family newFamily = new Family(c1, c2);
        expected.add(family);
        expected.add(newFamily);
        List<Family> real = f.getAllFamilies();
        assertEquals(expected, real);
    }

    @org.junit.jupiter.api.Test
    void deleteFamilyByIndex() {

        Man c1 = new Man("c2", "c2", 1999);
        Woman c2 = new Woman("c3", "c3", 2000);
        f.createNewFamily(c1, c2);

        List<Family> expected = new ArrayList<Family>();
        expected.add(family);
        f.deleteFamilyByIndex(1);
        List<Family> real = f.getAllFamilies();
        assertEquals(expected, real);
    }

    @org.junit.jupiter.api.Test
    void bornChild() {


        f.bornChild(family, "John", "Liza");

        List<Family> expected = new ArrayList<Family>();
        expected.add(family);

        List<Family> real = f.getAllFamilies();
        assertEquals(expected, real);
    }

    @org.junit.jupiter.api.Test
    void adoptChild() {

        Man c1 = new Man("c2", "c2", 1999);
        f.adoptChild(family, c1);

        List<Family> expected = new ArrayList<Family>();
        expected.add(family);

        List<Family> real = f.getAllFamilies();
        assertEquals(expected, real);
    }

    @org.junit.jupiter.api.Test
    void deleteAllChildrenOlderThen(){

        Man c1 = new Man("c2", "c2", 1997);
        f.adoptChild(family, c1);


        f.deleteAllChildrenOlderThen(18);
        List<Family> expected = new ArrayList<Family>();
        expected.add(family);

        List<Family> real = f.getAllFamilies();
        assertEquals(expected, real);
    }
    @org.junit.jupiter.api.Test
    void count(){

        f.saveFamily(family);
        f.saveFamily(family);

        int expected = 1;
        int real = f.count();
        assertEquals(expected, real);
    }

    @org.junit.jupiter.api.Test
    void getFamilyById(){

        Man m1 = new Man("c6", "c6", 1990);
        Woman w1 = new Woman("c6", "c6", 1990);
        Family f2 = new Family(m1, w1);
        f.saveFamily(f2);

        Family expected = f2;


        Family real = f.getFamilyById(1).get();
        assertEquals(expected, real);
    }

    @org.junit.jupiter.api.Test
    void getPets(){

        Man m1 = new Man("c6", "c6", 1990);
        Woman w1 = new Woman("c6", "c6", 1990);
        Family f2 = new Family(m1, w1);
        f.saveFamily(f2);

        List<Pet> expected = new ArrayList<>();
        expected.add(null);

        List<Pet> real = f.getPets(1);
        assertEquals(expected, real);
    }

    @org.junit.jupiter.api.Test
    void addPet(){

        Man m1 = new Man("c6", "c6", 1990);
        Woman w1 = new Woman("c6", "c6", 1990);
        Family f2 = new Family(m1, w1);
        f.saveFamily(f2);

        Set<String> habbits = new HashSet<String>();
        Pet p1 = new DomesticCat("bob", 2, (byte) 50, habbits);
        f.addPet(1, p1);

        List<Pet> expected = new ArrayList<>();
        expected.add(p1);

        List<Pet> real = f.getPets(1);
        assertEquals(expected, real);
    }


}
