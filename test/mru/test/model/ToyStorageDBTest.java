package mru.test.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import mru.tsc.model.*;

class ToyStorageDBTest {

	@BeforeEach
    void setUp() {
		try {
			ToyStorageDB toyStorageDB= new ToyStorageDB("res/toys.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
