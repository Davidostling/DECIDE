package com.example;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Unit test for the FUV class
 */
public class FUVTest{
	FUV fuv;
	Boolean[][] pum = new Boolean[15][15];
	Boolean[] puv = new Boolean[15];
	
    @Test
    public void pum_row_incorrect(){
		
		Arrays.fill(puv, false);
		puv[0] = true;
		Arrays.fill(pum[0], false); 
		
		fuv = new FUV(pum, puv);
		
        assertFalse(fuv.getFUV(0));
    }
	
	@Test
    public void puv_correct(){
		
		Arrays.fill(puv, false);
		
		fuv = new FUV(pum, puv);
		
        assertTrue(fuv.getFUV(0)); 
    }
	
	@Test
    public void pum_row_correct(){
		
		Arrays.fill(puv, false);
		puv[0] = true;
		Arrays.fill(pum[0], true); 
		
		fuv = new FUV(pum, puv);
		
        assertTrue(fuv.getFUV(0)); 
    }
}
