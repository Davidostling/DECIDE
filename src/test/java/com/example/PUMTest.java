package com.example;

import com.example.DECIDE.LCM;

import static org.junit.Assert.assertSame;

import org.junit.Test;

/**
 * Unit test for the PUM class
 */
public class PUMTest{
	FUV fuv;
	Boolean[][] pum = new Boolean[15][15];
	Boolean[] puv = new Boolean[15];
	
    @Test
    public void pum_example1(){
        Boolean[] cmv = new Boolean[15];
        cmv[0]  = false;
        cmv[1]  = true;
        cmv[2]  = true;
        cmv[3]  = true;
        cmv[4]  = false;
        cmv[5]  = false;
        cmv[6]  = false;
        cmv[7]  = false;
        cmv[8]  = false;
        cmv[9]  = false;
        cmv[10] = false;
        cmv[11] = false;
        cmv[12] = false;
        cmv[13] = false;
        cmv[14] = false;
        LCM[][] lcm = new LCM[15][15];
        lcm[0][0] = LCM.ANDD;
        lcm[0][1] = LCM.ANDD;
        lcm[0][2] = LCM.ORR;
        lcm[0][3] = LCM.ANDD;

        lcm[1][0] = LCM.ANDD;
        lcm[1][1] = LCM.ANDD;
        lcm[1][2] = LCM.ORR;
        lcm[1][3] = LCM.ORR;

        lcm[2][0] = LCM.ORR;
        lcm[2][1] = LCM.ORR;
        lcm[2][2] = LCM.ANDD;
        lcm[2][3] = LCM.ANDD;

        lcm[3][0] = LCM.ANDD;
        lcm[3][1] = LCM.ORR;
        lcm[3][2] = LCM.ANDD;
        lcm[3][3] = LCM.ANDD;

        for (int i = 4; i < lcm.length; i++) {
            for (int j = 0; j < lcm.length; j++) {
                lcm[i][j] = LCM.NOTUSED;
                lcm[j][i] = LCM.NOTUSED;
            }
        }
        PUM pum = new PUM(cmv, lcm);
        Boolean[][] actualPUM = pum.getPUMMatrix();


        Boolean[][] expectedPUM = new Boolean[15][15];
        expectedPUM[0][1] = false;
        expectedPUM[0][2] = true;
        expectedPUM[0][3] = false;

        expectedPUM[1][0] = false;
        expectedPUM[1][2] = true;
        expectedPUM[1][3] = true;

        expectedPUM[2][0] = true;
        expectedPUM[2][1] = true;
        expectedPUM[2][3] = true;
        
        expectedPUM[3][0] = false;
        expectedPUM[3][1] = true;
        expectedPUM[3][2] = true;
        for (int i = 4; i < expectedPUM.length; i++) {
            for (int j = 0; j < expectedPUM.length; j++) {
                if(i == j)
                    continue;
                expectedPUM[i][j] = true;
                expectedPUM[j][i] = true;
            }
        }
        for (int i = 0; i < expectedPUM.length; i++) {
            for (int j = 0; j < expectedPUM.length; j++) {
                if(i == j)
                    continue;
                assertSame(expectedPUM[i][j], actualPUM[i][j]);
            }
        }
    }

}
