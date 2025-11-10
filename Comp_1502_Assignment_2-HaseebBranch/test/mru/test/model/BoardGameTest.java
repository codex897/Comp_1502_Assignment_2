package mru.test.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import mru.test.model.*;
import mru.tsc.model.BoardGame;

class BoardGameTest {

	BoardGame bg;
	@BeforeEach
	void initialize() {
		bg = new BoardGame("1111111111", "StarFish", "Hasbro", 12.99, 5, 6, 1, 4, "Blake Griffin");
	}
	@Test
	void testGetSetDesigner() {
		String designer = bg.getDesigners();
		assertEquals("Blake Griffin", designer);
		
		bg.setDesigners("Billy Jeans");
		String designer2 = bg.getDesigners();
		assertEquals("Billy Jeans", designer2);
	}
	
	@Test
	void testTypeOf() {
		String type = bg.typeOf();
		assertNotEquals("Animal", type);
		assertEquals("BoardGames", type);
	}
	
	@Test
	void testGetSetMinPlayers() {
		int min = bg.getMinPlayers();
		assertEquals(1, min);
		
		bg.setMinPlayers(2);
		int min2 = bg.getMinPlayers();
		assertEquals(2, min2);
	}
	
	@Test
	void testGetSetMaxPlayers() {
		int max = bg.getMaxPlayers();
		assertEquals(4, max);
		
		bg.setMaxPlayers(10);
		int max2 = bg.getMaxPlayers();
		assertEquals(10, max2);
	}
	
	@Test
	void testStringToFormat() { 
		String formatted = bg.stringToFormat();
		assertNotEquals("BoardGames", formatted);
		System.out.println(formatted);
		assertEquals("1111111111;StarFish;Hasbro;12.99;5;6;1-4;Blake Griffin", formatted);
	}
	
	@Test
	void testToString() { //Work IN progress
		String string = bg.toString();
		assertNotEquals("1111111111;StarFish;Hasbro;12.99;5;6;plastic;L", string);
		System.out.println(string);
		assertEquals("???????????", string);
	}

}
