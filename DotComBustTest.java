import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DotComBustTest {

	@Test
	void testSetUpGame() {
		fail("Not yet implemented");
	}

	@Test
	void testStartPlaying() {
		fail("Not yet implemented");
	}

	@Test
	void testCheckUserGuess() {
		fail("Not yet implemented");
	}

	@Test
	void testMain() {
		fail("Not yet implemented");
	}
	
	@Test
	void testFinishGame() {
		DotComBust test = new DotComBust();
		
		final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
	
		test.finishGame();
		
		String finalString = new String(outContent.toString());
		
		String testString = new String("All Dot Coms are dead! Your stock is now worthless.\nIt only took you 0 guesses.\nYou got out before your options sank.\n");
	
		assertEquals(finalString, testString);
		
	}
}​​​​​​
;
