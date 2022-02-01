package com.example;
import com.example.CMV;


import java.util.List;
import java.util.ArrayList;

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
		
        assertFalse(cmv.getLicResult(12));
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
		
        assertFalse(cmv.getLicResult(12));
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
		
        assertTrue(cmv.getLicResult(12));
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
		
        assertFalse(cmv.getLicResult(13));
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
		
        assertFalse(cmv.getLicResult(13));
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
		
        assertTrue(cmv.getLicResult(13));
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
		
        assertFalse(cmv.getLicResult(14));
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
		
        assertFalse(cmv.getLicResult(14));
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
		
        assertTrue(cmv.getLicResult(14));
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

}
