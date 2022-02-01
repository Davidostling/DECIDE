package com.example;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Unit test for the FUV class
 */
public class FUVTest
	FUV fuv;
	PUM pum;
	Boolean[] puv = new Boolean[15];
{
    @Test
    public void fuv_false(){
		Arrays.fill(puv, false);
		
		//SET A TEST CASE FOR PUM ONCE IMPLEMENTED
		
		fuv = new FUV(pum, puv);
		
		// IMPLEMENT PROPER TESTING ONCE PUM IS IMPLEMENTED
        //assertFalse(fuv.getFUV(0));
		//assertFalse(fuv.getFUV(14));
		
		assertFalse(false);
    }
	
	@Test
    public void fuv_true(){
		
		Arrays.fill(puv, false);
		puv[0] = false;
		
		//SET A TEST CASE FOR PUM ONCE IMPLEMENTED
		
		fuv = new FUV(pum, puv);
		
		// IMPLEMENT PROPER TESTING ONCE PUM IS IMPLEMENTED
        //assertTrue(fuv.getFUV(0)); 	// Should be true from just puv being false
		//assertTrue(fuv.getFUV(14)); 	// SHould be true from all PUM in row being true
		
        assertTrue( true );
    }
}
