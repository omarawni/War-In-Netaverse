package cwk4.src.cwk4.test;
import cwk4.src.cwk4.SpaceWars;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import cwk4.src.cwk4.WIN;
public class T5ExtraSpaceWarsTests {
    WIN game;

    public T5ExtraSpaceWarsTests() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        game = new SpaceWars("James", "battles.txt");
    }

    @After
    public void tearDown() {
    }
    private boolean containsText2(String text, String s1, String s2) {
        boolean result = false;
        result = text.contains(s1) && text.contains(s2);
        return result;
    }

    /*
    TESTS:
    -Saving a game.
    -Checking if forces actually get destroyed after losing a battle.
     */



    @Test
    public void SavingGame() {
        String result = "";
        //make some changes to GAME:
        game.activateForce("SS2");
        //Then save the GAME:
        game.saveGame("CurrentSave.txt");
        try {
            FileInputStream f = new FileInputStream("CurrentSave.txt");
            ObjectInputStream o = new ObjectInputStream(f);
            String Currenttostring = o.readObject().toString();
            result = Currenttostring;
            f.close();
            o.close();
        } catch (Exception e){
            try {
                throw new IOException();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        boolean actual = containsText2(result, "SS2", " active");
        assertTrue(actual);
    }



    @Test
    public void ForceActuallydestroyedafterLosingBattle() {
        game.activateForce("IW1");
        game.doBattle(2);
        String result = game.getDestroyedForces();
        boolean actual = containsText2(result, "IW1", " destroyed");
        assertTrue(actual);
    }







}
