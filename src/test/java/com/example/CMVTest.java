package com.example;
import com.example.CMV;


import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

/**
 * Unit test CMV
 */
public class CMVTest{
	List<Coordinate> points = new ArrayList<Coordinate>();
	Parameters param;
	CMV cmv;

	
    /**
     * 
     */
    @Test
    public void lic12_too_few_points(){
		points.add(new Coordinate(0,0));
		points.add(new Coordinate(1,1));
		
		param = new Parameters(points.size(), points);
		
		param.setK_PTS(2);
		param.setLENGTH1(2);
		param.setLENGTH2(2);
		
		cmv = new CMV(param);
		
        assertFalse(cmv.getCMV(12));
    }

	@Test
    public void lic12_one_true(){
		points.add(new Coordinate(0,0));
		points.add(new Coordinate(1,1));
		points.add(new Coordinate(2,3));
		points.add(new Coordinate(2,3));
		points.add(new Coordinate(3,3));
		
		Parameters param = new Parameters(points.size(), points);
		
		param.setK_PTS(2);
		param.setLENGTH1(2);
		param.setLENGTH2(1);
		
		cmv = new CMV(param);
		
        assertFalse(cmv.getCMV(12));
    }
	
	@Test
    public void lic12_both_true(){
		points.add(new Coordinate(0,0));
		points.add(new Coordinate(1,1));
		points.add(new Coordinate(2,3));
		points.add(new Coordinate(2,3));
		points.add(new Coordinate(3,3));
		
		Parameters param = new Parameters(points.size(), points);
		
		param.setK_PTS(2);
		param.setLENGTH1(2);
		param.setLENGTH2(2);
		
		
		cmv = new CMV(param);
		
        assertTrue(cmv.getCMV(12));
    }
	
	@Test
    public void lic13_too_few_points(){
		points.add(new Coordinate(0,0));
		points.add(new Coordinate(1,1));
		points.add(new Coordinate(2,3));
		points.add(new Coordinate(2,3));
		
		param = new Parameters(points.size(), points);
		
		param.setA_PTS(2);
		param.setB_PTS(2);
		param.setRADIUS1(2);
		param.setRADIUS2(2);
		
		cmv = new CMV(param);
		
        assertFalse(cmv.getCMV(13));
    }
	
	@Test
    public void lic13_one_true(){
		points.add(new Coordinate(0,0));
		points.add(new Coordinate(0,2));
		points.add(new Coordinate(1,1)); 
		points.add(new Coordinate(2,1)); 
		points.add(new Coordinate(2,2));
		points.add(new Coordinate(3,1)); 
		points.add(new Coordinate(3,2));
		points.add(new Coordinate(4,3));
		
		param = new Parameters(points.size(), points);
		
		param.setA_PTS(3);
		param.setB_PTS(5);
		param.setRADIUS1(2);
		param.setRADIUS2(1);
		
		cmv = new CMV(param);
		
        assertFalse(cmv.getCMV(13));
    }
	
	@Test
    public void lic13_both_true(){
		points.add(new Coordinate(0,0));
		points.add(new Coordinate(0,2));
		points.add(new Coordinate(1,1)); 
		points.add(new Coordinate(2,1)); 
		points.add(new Coordinate(2,2));
		points.add(new Coordinate(3,1)); 
		points.add(new Coordinate(3,2));
		points.add(new Coordinate(4,3));
		
		param = new Parameters(points.size(), points);
		
		param.setA_PTS(3);
		param.setB_PTS(5);
		param.setRADIUS1(2);
		param.setRADIUS2(3);
		
		cmv = new CMV(param);
		
        assertTrue(cmv.getCMV(13));
    }
	
	@Test
    public void lic14_too_few_points(){
		points.add(new Coordinate(0,0));
		points.add(new Coordinate(1,1));
		points.add(new Coordinate(2,3));
		points.add(new Coordinate(2,3));
		
		param = new Parameters(points.size(), points);
		
		param.setE_PTS(2);
		param.setF_PTS(2);
		param.setAREA1(2);
		param.setAREA2(2);
		
		cmv = new CMV(param);
		
        assertFalse(cmv.getCMV(14));
    }
	
	@Test
    public void lic14_one_true(){
		points.add(new Coordinate(0,0));
		points.add(new Coordinate(0,2));
		points.add(new Coordinate(1,1)); 
		points.add(new Coordinate(2,1)); 
		points.add(new Coordinate(2,2));
		points.add(new Coordinate(3,1)); 
		points.add(new Coordinate(3,2));
		points.add(new Coordinate(4,3));
		
		param = new Parameters(points.size(), points);
		
		param.setE_PTS(3);
		param.setF_PTS(5);
		param.setAREA1(3);
		param.setAREA2(2);
		
		cmv = new CMV(param);
		
        assertFalse(cmv.getCMV(14));
    }
	
	@Test
    public void lic14_both_true(){
		points.add(new Coordinate(0,0));
		points.add(new Coordinate(0,2));
		points.add(new Coordinate(1,1)); 
		points.add(new Coordinate(2,1)); 
		points.add(new Coordinate(2,2));
		points.add(new Coordinate(3,1)); 
		points.add(new Coordinate(3,2));
		points.add(new Coordinate(4,3));
		
		param = new Parameters(points.size(), points);
		
		param.setE_PTS(3);
		param.setF_PTS(5);
		param.setAREA1(1);
		param.setAREA2(2);
		
		cmv = new CMV(param);
		
        assertTrue(cmv.getCMV(14));
    }

    @Test
    public void lic0_true(){
        points.add(new Coordinate(1, 1));
        points.add(new Coordinate(1, 0));
        points.add(new Coordinate(2, 0));
        points.add(new Coordinate(4, 1));
        Parameters param = new Parameters(points.size(), points);
        param.setLENGTH1(2);
        cmv = new CMV(param);
        assertTrue(cmv.getCMV(0));
    }
    @Test
    public void lic0_false(){
        points.add(new Coordinate(1, 1));
        points.add(new Coordinate(1, 0));
        points.add(new Coordinate(2, 0));
        points.add(new Coordinate(2, 1));
        Parameters param = new Parameters(points.size(), points);
        param.setLENGTH1(2);
        cmv = new CMV(param);
        assertFalse(cmv.getCMV(0));
    }
    @Test
    public void lic1_true(){
        points.add(new Coordinate(1, 1));
        points.add(new Coordinate(10, 10));
        points.add(new Coordinate(20, 20));
        points.add(new Coordinate(30, 30));
        Parameters param = new Parameters(points.size(), points);
        param.setRADIUS1(3);
        cmv = new CMV(param);
        assertTrue(cmv.getCMV(1));
    }
    @Test
    public void lic1_false(){
        points.add(new Coordinate(1, 1));
        points.add(new Coordinate(1, 0));
        points.add(new Coordinate(2, 0));
        points.add(new Coordinate(2, 1));
        Parameters param = new Parameters(points.size(), points);
        param.setRADIUS1(5);
        cmv = new CMV(param);
        assertFalse(cmv.getCMV(1));
    }
    @Test
    public void lic7_true() {
       //length1 = 2
        points.add(new Coordinate(0, 0));
        points.add(new Coordinate(1, 0));
        points.add(new Coordinate(1, 1));
        points.add(new Coordinate(2, 0));
        points.add(new Coordinate(4, 1));
        Parameters param = new Parameters(points.size(), points);
        param.setLENGTH1(2);
        cmv = new CMV(param);
        assertTrue(cmv.getCMV(7));
    }
    @Test
    public void lic7_false() {
        //length1 = 14
        points.add(new Coordinate(0, 0));
        points.add(new Coordinate(1, 1));
        points.add(new Coordinate(2, 0));
        points.add(new Coordinate(4, 1));
        Parameters param = new Parameters(points.size(), points);
        param.setLENGTH1(14);
        cmv = new CMV(param);
        assertFalse(cmv.getCMV(7));
    }

    @Test
    public void lic2_true(){
        points.add(new Coordinate(1, 1));
        points.add(new Coordinate(2, 2));
        points.add(new Coordinate(3, 1));
        Parameters param = new Parameters(points.size(), points);
        param.setEPSILON(0);
        cmv = new CMV(param);
        assertTrue(cmv.getCMV(2));
    }

    @Test
    public void lic2_false(){
        points.add(new Coordinate(1, 1));
        points.add(new Coordinate(2, 2));
        points.add(new Coordinate(3, 1));
        Parameters param = new Parameters(points.size(), points);
        param.setEPSILON(Math.PI/2);
        cmv = new CMV(param);
        assertFalse(cmv.getCMV(2));
        
    }


	@Test
	public void lic3_too_few_points(){
		points.add(new Coordinate(0,0));
		points.add(new Coordinate(1,1));

		Parameters param = new Parameters(points.size(), points);
		param.setAREA1(1);

		cmv = new CMV(param);
		assertFalse(cmv.getCMV(3));
	}

	@Test
	public void lic3_false(){
		points.add(new Coordinate(0,0));
		points.add(new Coordinate(1,1));
		points.add(new Coordinate(2,2));
		points.add(new Coordinate(3,3));

		Parameters param = new Parameters(points.size(), points);
		param.setAREA1(100);

		cmv = new CMV(param);
		assertFalse(cmv.getCMV(3));
	}

	@Test
	public void lic3_true(){
		points.add(new Coordinate(0,0));
		points.add(new Coordinate(10,10));
		points.add(new Coordinate(20,0));
		points.add(new Coordinate(30,30));

		Parameters param = new Parameters(points.size(), points);
		param.setAREA1(1);

		cmv = new CMV(param);
		assertTrue(cmv.getCMV(3));
	}

	@Test
	public void lic4_false_one(){
		points.add(new Coordinate(0,0));
		points.add(new Coordinate(1,1));
		points.add(new Coordinate(2,2));
		points.add(new Coordinate(3,-1));

		Parameters param = new Parameters(points.size(), points);
		param.setQ_PTS(4);
		param.setQUADS(2);

		cmv = new CMV(param);
		assertFalse(cmv.getCMV(4));
	}

	@Test
	public void lic4_true_one(){
		points.add(new Coordinate(0,0));
		points.add(new Coordinate(-1,1));
		points.add(new Coordinate(-1,-1));
		points.add(new Coordinate(1,-1));

		Parameters param = new Parameters(points.size(), points);
		param.setQ_PTS(4);
		param.setQUADS(2);

		cmv = new CMV(param);
		assertTrue(cmv.getCMV(4));
	}

	@Test
	public void lic4_false_two(){
		// Not consecutive data points
		points.add(new Coordinate(1,1));
		points.add(new Coordinate(-1,1));
		points.add(new Coordinate(-1,-1));
		points.add(new Coordinate(1,-1));

		Parameters param = new Parameters(points.size(), points);
		param.setQ_PTS(3);
		param.setQUADS(3);

		cmv = new CMV(param);
		assertFalse(cmv.getCMV(4));
	}

	@Test
	public void lic5_false_not_enough_points(){
		// Not consecutive data points
		points.add(new Coordinate(1,1));

		Parameters param = new Parameters(points.size(), points);

		cmv = new CMV(param);
		assertFalse(cmv.getCMV(5));
	}

	@Test
	public void lic5_false_two(){
		// Not consecutive data points
		points.add(new Coordinate(1,1));
		points.add(new Coordinate(2,1));
		points.add(new Coordinate(3,1));

		Parameters param = new Parameters(points.size(), points);

		cmv = new CMV(param);
		assertFalse(cmv.getCMV(5));
	}

	@Test
	public void lic5_true(){
		// Not consecutive data points
		points.add(new Coordinate(1,1));
		points.add(new Coordinate(0,1));
		points.add(new Coordinate(3,1));

		Parameters param = new Parameters(points.size(), points);

		cmv = new CMV(param);
		assertTrue(cmv.getCMV(5));
	}


	@Test
    public void lic9_true(){
		points.add(new Coordinate(0,0));
		points.add(new Coordinate(0,2));
		points.add(new Coordinate(1,1));
		points.add(new Coordinate(1,1));
		points.add(new Coordinate(3,1));
		
		param = new Parameters(points.size(), points);
		param.setEPSILON(1);
		param.setC_PTS(1);
		param.setD_PTS(1);
		
		cmv = new CMV(param);
		
        assertTrue(cmv.getCMV(9));
    }
    @Test
    public void lic9_false(){
		points.add(new Coordinate(0, 0));
        points.add(new Coordinate(1, 0));
        points.add(new Coordinate(1, 1));
        points.add(new Coordinate(2, 0));
        points.add(new Coordinate(4, 1));

		param = new Parameters(points.size(), points);
		param.setEPSILON(Math.PI);
		param.setC_PTS(1);
		param.setD_PTS(1);
		
		
		cmv = new CMV(param);
		
        assertFalse(cmv.getCMV(9));
    
    }

    @Test
    public void lic10_true(){
		points.add(new Coordinate(0, 0));
        points.add(new Coordinate(1, 0));
        points.add(new Coordinate(1, 8));
        points.add(new Coordinate(2, 0));
        points.add(new Coordinate(4, 1));
		
		param = new Parameters(points.size(), points);
		param.setAREA1(1);
		param.setE_PTS(1);
		param.setF_PTS(1);
		
		cmv = new CMV(param);
		
        assertTrue(cmv.getCMV(10));
    }

    @Test
    public void lic10_false(){
		points.add(new Coordinate(0,0));
		points.add(new Coordinate(0,2));
		points.add(new Coordinate(1,1));
		
		
		param = new Parameters(points.size(), points);
		
		param.setE_PTS(0);
		param.setF_PTS(0);
		
		
		cmv = new CMV(param);
		
        assertFalse(cmv.getCMV(10));
    
    }

    @Test 
    public void lic11_true(){
        points.add(new Coordinate(0, 0));
        points.add(new Coordinate(1, 0));
        points.add(new Coordinate(5, 1));
        points.add(new Coordinate(2, 0));
        points.add(new Coordinate(4, 1));

        Parameters param = new Parameters(points.size(), points);
        param.setG_PTS(1);

        cmv = new CMV(param);
        assertTrue(cmv.getCMV(11));
    }
	
    @Test
    public void lic11_false(){
        points.add(new Coordinate(0,0));
		points.add(new Coordinate(1,1));
		param = new Parameters(points.size(), points);
		
		param.setG_PTS(0);
		

		cmv = new CMV(param);
		assertFalse(cmv.getCMV(6));
	}

}
