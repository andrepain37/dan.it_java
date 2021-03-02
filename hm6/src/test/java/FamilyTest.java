package test.java;

import main.Family;
import main.Woman;
import main.Man;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {

    @org.junit.jupiter.api.Test
    void testToString() {
        Man h1 = new Man("Pieter", "Parker", 1987);
        Woman m1 = new Woman("Mary", "Jane", 1988);

        Family f1 = new Family(h1, m1);
        String expected = "Family{ mother='Human{ name='Pieter', surname=Parker, year=1987, iq=0, schedule=null}', father=Human{ name='Mary', surname=Jane, year=1988, iq=0, schedule=null}, children=[], pet=null}";
        String real = f1.toString();
        assertEquals(expected, real);
    }

    @Test
    void testDeleteChild() {
        Man h1 = new Man("Pieter", "Parker", 1987);
        Woman m1 = new Woman("Mary", "Jane", 1988);

        Family f1 = new Family(h1, m1);

        Man c1 = new Man("c1", "f1", 2019);
        Woman c2 = new Woman("c2", "f2", 2019);

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
        Man h1 = new Man("Pieter", "Parker", 1987);
        Woman m1 = new Woman("Mary", "Jane", 1988);

        Family f1 = new Family(h1, m1);

        Man c1 = new Man("c1", "f1", 2019);

        f1.addChild(c1);

        String expChildren = "[Human{ name='c1', surname=f1, year=2019, iq=0, schedule=null}]";


        String realChildren = Arrays.toString(f1.getChildren());

        assertEquals(expChildren, realChildren);

    }

    @Test
    void testCountFamily(){

        Man h1 = new Man("Pieter", "Parker", 1987);
        Woman m1 = new Woman("Mary", "Jane", 1988);

        Family f1 = new Family(h1, m1);

        Woman c1 = new Woman("c1", "f1", 2019);


        f1.addChild(c1);

        int expCountFamily = 3;
        int realCountFamily = f1.countFamily();

        assertEquals(expCountFamily, realCountFamily);


    }
}