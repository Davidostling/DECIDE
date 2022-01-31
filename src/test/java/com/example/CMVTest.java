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
}
