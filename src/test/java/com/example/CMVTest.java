package com.example;

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
