package com.example;
import com.example.DECIDE.LAUNCH;
import com.example.DECIDE.LCM;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Test that LAUNCH returns YES when given a Boolean array with only true
     */
    @Test
    public void LAUNCH_YES()
    {
        Boolean[] fuv = new Boolean[15];
        Arrays.fill(fuv, true);
        LAUNCH launch = DECIDE.getLAUNCH(fuv);
        assertSame(LAUNCH.YES, launch);
    }
    /**
     * Test that LAUNCH returns NO when given a Boolean array with only true
     */
    @Test
    public void LAUNCH_NO()
    {
        Boolean[] fuv = new Boolean[15];
        Arrays.fill(fuv, true);
        fuv[5] = false;
        LAUNCH launch = DECIDE.getLAUNCH(fuv);
        assertSame(LAUNCH.NO, launch);
    }
}
