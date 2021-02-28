import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {

    @org.junit.jupiter.api.Test
    void testToString() {
        Human h1 = new Human("Pieter", "Parker", 1987);
        Human m1 = new Human("Mary", "Jane", 1988);

        Family f1 = new Family(h1, m1);
        String expected = "Family{ mother='Human{ name='Pieter', surname=Parker, year=1987, iq=0, schedule=null}', father=Human{ name='Mary', surname=Jane, year=1988, iq=0, schedule=null}, children=[], pet=null}";
        String real = f1.toString();
        assertEquals(expected, real);
    }

    @Test
    void testDeleteChild() {
        Human h1 = new Human("Pieter", "Parker", 1987);
        Human m1 = new Human("Mary", "Jane", 1988);

        Family f1 = new Family(h1, m1);

        Human c1 = new Human("c1", "f1", 2019);
        Human c2 = new Human("c2", "f2", 2019);

        f1.addChild(c1);
        f1.addChild(c2);

        Boolean expBool = true;
        String expDelete = "[Human{ name='c2', surname=f2, year=2019, iq=0, schedule=null}]";

        Boolean realBool = f1.deleteChild(0);
        String realDelete = Arrays.toString(f1.getChildren());

        assertEquals(expBool, realBool);
        assertEquals(expDelete, realDelete);

    }

    @Test
    void testAddChild() {
        Human h1 = new Human("Pieter", "Parker", 1987);
        Human m1 = new Human("Mary", "Jane", 1988);

        Family f1 = new Family(h1, m1);

        Human c1 = new Human("c1", "f1", 2019);





        f1.addChild(c1);

        int expCountChildren = 1;
        String expChildren = "[Human{ name='c1', surname=f1, year=2019, iq=0, schedule=null}]";

        int realCountChildren = f1.getChildren().length;
        String realChildren = Arrays.toString(f1.getChildren());

        assertEquals(expCountChildren, realCountChildren);
        assertEquals(expChildren, realChildren);

    }

    @Test
    void testCountFamily(){

        Human h1 = new Human("Pieter", "Parker", 1987);
        Human m1 = new Human("Mary", "Jane", 1988);

        Family f1 = new Family(h1, m1);

        Human c1 = new Human("c1", "f1", 2019);


        f1.addChild(c1);

        int expCountFamily = 3;
        int realCountFamily = f1.countFamily();

        assertEquals(expCountFamily, realCountFamily);


    }
}