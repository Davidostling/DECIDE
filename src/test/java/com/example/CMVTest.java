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
}
