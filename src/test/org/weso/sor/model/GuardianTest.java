package org.weso.sor.model;

import junit.framework.TestCase;

public class GuardianTest extends TestCase {

	public void testTrun(){
		Guardian g = new Guardian();
		
		String test1 = "";
		String test2 = null;
		String test3 = "sdf";
		String test4 = "123456789A123456789B123456789C123456789D12345678xxx";
		
		assertEquals(""   ,g.truncate(test1, 48));
		assertEquals(null   ,g.truncate(test2, 48));
		assertEquals("sdf"   ,g.truncate(test3, 48));
		assertEquals("123456789A123456789B123456789C123456789D12345678"   ,g.truncate(test4, 48));
	}

}
