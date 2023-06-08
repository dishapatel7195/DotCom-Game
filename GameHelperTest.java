import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameHelperTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setIn(systemIn);
        System.setOut(systemOut);
    }

    @Test
    public void testGetUserInput() {
        /*
        Testing the getUserInput method by passing a user input and checking
        if it is returned
         */
        final String testString = "A20";
        provideInput(testString);
        GameHelper game = new GameHelper();
        String output = game.getUserInput("A20");
        assertEquals("a20", output);
    }


    @Test
    public void testGridDisplay() {
        /*
        Testing the gridDisplay method to see if proper grid layout is displayed based on
        the given correct guesses and wrong guesses
         */
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ArrayList<String> correctUserGuesses = new ArrayList<>();
        ArrayList<String> wrongUserGuesses = new ArrayList<>();

        correctUserGuesses.add("a2");
        wrongUserGuesses.add("b2");

        GameHelper gameHelper = new GameHelper();

        gameHelper.gridDisplay(correctUserGuesses, wrongUserGuesses);


        assertEquals("" +
                "  + - + - + - + - + - + - + - +\n" +
                "a |   |   | 1 |   |   |   |   |\n" +
                "  + - + - + - + - + - + - + - +\n" +
                "b |   |   | X |   |   |   |   |\n" +
                "  + - + - + - + - + - + - + - +\n" +
                "c |   |   |   |   |   |   |   |\n" +
                "  + - + - + - + - + - + - + - +\n" +
                "d |   |   |   |   |   |   |   |\n" +
                "  + - + - + - + - + - + - + - +\n" +
                "e |   |   |   |   |   |   |   |\n" +
                "  + - + - + - + - + - + - + - +\n" +
                "f |   |   |   |   |   |   |   |\n" +
                "  + - + - + - + - + - + - + - +\n" +
                "g |   |   |   |   |   |   |   |\n" +
                "  + - + - + - + - + - + - + - +\n" +
                "    0   1   2   3   4   5   6\n", outContent.toString());

    }

    @Test
    public void testGridDisplayWithOnlySuccess() {
        /*
        Testing the gridDisplay method to see if proper grid layout is displayed based on
        the given correct guesses and wrong guesses
         */
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ArrayList<String> correctUserGuesses = new ArrayList<>();
        ArrayList<String> wrongUserGuesses = new ArrayList<>();

        correctUserGuesses.add("d3");

        GameHelper gameHelper = new GameHelper();

        gameHelper.gridDisplay(correctUserGuesses, wrongUserGuesses);


        assertEquals("" +
                "  + - + - + - + - + - + - + - +\n" +
                "a |   |   |   |   |   |   |   |\n" +
                "  + - + - + - + - + - + - + - +\n" +
                "b |   |   |   |   |   |   |   |\n" +
                "  + - + - + - + - + - + - + - +\n" +
                "c |   |   |   |   |   |   |   |\n" +
                "  + - + - + - + - + - + - + - +\n" +
                "d |   |   |   | 1 |   |   |   |\n" +
                "  + - + - + - + - + - + - + - +\n" +
                "e |   |   |   |   |   |   |   |\n" +
                "  + - + - + - + - + - + - + - +\n" +
                "f |   |   |   |   |   |   |   |\n" +
                "  + - + - + - + - + - + - + - +\n" +
                "g |   |   |   |   |   |   |   |\n" +
                "  + - + - + - + - + - + - + - +\n" +
                "    0   1   2   3   4   5   6\n", outContent.toString());

    }

    @Test
    public void testGridDisplayWithOnlyFailure() {
        /*
        Testing the gridDisplay method to see if proper grid layout is displayed based on
        the given correct guesses and wrong guesses
         */
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ArrayList<String> correctUserGuesses = new ArrayList<>();
        ArrayList<String> wrongUserGuesses = new ArrayList<>();

        wrongUserGuesses.add("f2");

        GameHelper gameHelper = new GameHelper();

        gameHelper.gridDisplay(correctUserGuesses, wrongUserGuesses);


        assertEquals("" +
                "  + - + - + - + - + - + - + - +\n" +
                "a |   |   |   |   |   |   |   |\n" +
                "  + - + - + - + - + - + - + - +\n" +
                "b |   |   |   |   |   |   |   |\n" +
                "  + - + - + - + - + - + - + - +\n" +
                "c |   |   |   |   |   |   |   |\n" +
                "  + - + - + - + - + - + - + - +\n" +
                "d |   |   |   |   |   |   |   |\n" +
                "  + - + - + - + - + - + - + - +\n" +
                "e |   |   |   |   |   |   |   |\n" +
                "  + - + - + - + - + - + - + - +\n" +
                "f |   |   | X |   |   |   |   |\n" +
                "  + - + - + - + - + - + - + - +\n" +
                "g |   |   |   |   |   |   |   |\n" +
                "  + - + - + - + - + - + - + - +\n" +
                "    0   1   2   3   4   5   6\n", outContent.toString());

    }

}
