package mru.test.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import mru.test.model.*;
import mru.tsc.model.Animal;
class AnimalTest {

	Animal animal;
	@BeforeEach
	void initialize() {
		animal = new Animal("1111111111", "StarFish", "Hasbro", 12.99, 5, 6, "plastic", 'L');
	}
	
	@Test
	void testGetSize() {
		char size = animal.getSize();
		assertEquals('L', size);
	}
	
	@Test
	void testSetSize() {
		char size = animal.getSize();
		assertEquals('L', size);
		animal.setSize('M');
		char size2 = animal.getSize();
		assertEquals('M', size2);
	}
	
	@Test
	void testSetGetMaterial() {
		String mat = animal.getMaterial();
		assertEquals("plastic", mat);
		animal.setMaterial("wood");
		String mat2 = animal.getMaterial();
		assertEquals("wood", mat2);
	}
	
	@Test
	void testTypeOf() {
		String type = animal.typeOf();
		assertEquals("Animal", type);
	}
	
	@Test
	void testStringToFormat() { 
		String formatted = animal.stringToFormat();
		assertNotEquals("Animal", formatted);
		System.out.println(formatted);
		assertEquals("1111111111;StarFish;Hasbro;12.99;5;6;plastic;L", formatted);
	}
	
	@Test
	void testToString() { //Work IN progress
		String string = animal.toString();
		assertNotEquals("1111111111;StarFish;Hasbro;12.99;5;6;plastic;L", string);
		System.out.println(string);
		assertEquals("???????????", string);
	}


}
