package com.example;

import java.util.List;
import java.lang.Math;

public class CMV {
    Parameters param;
    Boolean[] cmv = new Boolean[15];

    public CMV(Parameters param){
        this.param = param;
        this.setCMV();
    }
    public void setCMV(){
        cmv[0] = LIC0();
        cmv[1] = LIC1();
		cmv[2] = LIC2();
        cmv[3] = LIC3();
		cmv[4] = LIC4();
        cmv[5] = LIC5();
		cmv[6] = LIC6();
        cmv[7] = LIC7();
		cmv[8] = LIC8();
        cmv[9] = LIC9();
		cmv[10] = LIC10();
        cmv[11] = LIC11();
		cmv[12] = LIC12();
        cmv[13] = LIC13();
		cmv[14] = LIC14();

    }
	
	public boolean getLicResult(int i){
		return cmv[i];
	}

    private Boolean LIC0() {
        return false;
    }
    private Boolean LIC1() {
        return false;
    }
    private Boolean LIC2() {
        return false;
    }
    private Boolean LIC3() {
        return false;
    }
    private Boolean LIC4() {
        return false;
    }
    private Boolean LIC5() {
        return false;
    }
    private Boolean LIC6() {
        return false;
    }
    private Boolean LIC7() {
        return false;
    }
    private Boolean LIC8() {
        return false;
    }
    private Boolean LIC9() {
        return false;
    }
    private Boolean LIC10() {
        return false;
    }
    private Boolean LIC11() {
        return false;
    }
	
	/*
	* Checks if there exists at least one set two points seperated by K_PTS 
	* consecutive intervening points that are at a distance greater than LENGTH1 
	* as well as lesser than LENGTH2. The set of points can be the same
	* 
	* Both Must be present for the LIC to return true
	* Returns false if there are less than 3 NUMPOINTS
	* Length are greater than or equal to 0
	*/
    private Boolean LIC12() {
		// Get all values required to calculating conditions
		List<Coordinate> points = param.getPOINTS();
		int numPoints = param.getNUMPOINTS();
		
		int k_pts = param.getK_PTS();
		int length1 = param.getLENGTH1();
		int length2 = param.getLENGTH2();
		
		// If the number of points are less than 3 return false
		if(numPoints < 3){
			return false;
		}
		
		// The two conditions
		boolean greater_than_length1 = false;
		boolean lesser_than_length2 = false;
		
		for(int i = 0; i < numPoints && i + k_pts < numPoints; i++){
			Integer firstPointX = points.get(i).getX();
			Integer firstPointY = points.get(i).getY();
			
			Integer secondPointX = points.get(i + k_pts).getX();
			Integer secondPointY = points.get(i + k_pts).getY();
			
			double distance = getDistance(firstPointX, firstPointY, secondPointX, secondPointY);
			
			if(distance > length1 ){
				greater_than_length1 = true;
			}
			if(distance < length2){
				lesser_than_length2 = true;
			}
			
			// If both conditions are met return true
			if(greater_than_length1 && lesser_than_length2){
				return true;
			}
		}
		
		// Otherwise return false
        return false;
    }
	
	/*
	* Checks if there is at least one set of three points seperated by A_PTS and
	* B_PTS consecutive intervening points that cannot be contained or exists on 
	* a circle of a radius of RADIUS1 as well as one of a radius of RADIUS2. The
	* set of points can either be the same or different
	*
	* Both Must be present for the LIC to return true
	* Returns false if there are less than 5 NUMPOINTS
	* radius are greater than or equal to 0
	*/
    private Boolean LIC13() {
        // Get all values required to calculating conditions
		List<Coordinate> points = param.getPOINTS();
		int numPoints = param.getNUMPOINTS();
		
		int a_pts = param.getA_PTS();
		int b_pts = param.getB_PTS();
		int radius1 = param.getRADIUS1();
		int radius2 = param.getRADIUS2();	
		
		// If the number of points are less than 5 return false
		if(numPoints < 5){
			return false;
		}
		
		// The two conditions
		boolean fits_radius1 = false;
		boolean fits_radius2 = false;
		
		for(int i = 0; i < numPoints && i + a_pts < numPoints && i + b_pts < numPoints; i++){
			Integer firstPointX = points.get(i).getX();
			Integer firstPointY = points.get(i).getY();
			
			Integer secondPointX = points.get(i + a_pts).getX();
			Integer secondPointY = points.get(i + a_pts).getY();
			
			Integer thirdPointX = points.get(i + b_pts).getX();
			Integer thirdPointY = points.get(i + b_pts).getY();
			
			double distanceFirstToSecond = getDistance(firstPointX, firstPointY, secondPointX, secondPointY);
			double distanceSecondToThird = getDistance(secondPointX, secondPointY, thirdPointX, thirdPointY);
			double distanceFirstToThird = getDistance(firstPointX, firstPointY, thirdPointX, thirdPointY);
			
			// Checks that the destance between the points are less or equal to the radius
			// Assumes that one of the points are the middle of the circle
			
			// First point middle
			if(distanceFirstToSecond <= radius1 && distanceFirstToThird <= radius1){
				fits_radius1 = true;
			}
			// second point middle
			if(distanceFirstToSecond <= radius1 && distanceSecondToThird <= radius1){
				fits_radius1 = true;
			}
			// third point middle
			if(distanceFirstToThird <= radius1 && distanceSecondToThird <= radius1){
				fits_radius1 = true;
			}
			
			
			// First point middle
			if(distanceFirstToSecond <= radius2 && distanceFirstToThird <= radius2){
				fits_radius2 = true;
			}
			// second point middle
			if(distanceFirstToSecond <= radius2 && distanceSecondToThird <= radius2){
				fits_radius2 = true;
			}
			// third point middle
			if(distanceFirstToThird <= radius2 && distanceSecondToThird <= radius2){
				fits_radius2 = true;
			}

			
			
			// If both conditions are met return true
			if(fits_radius1 && fits_radius2){
				return true;
			}
		}
		
		// Otherwise return false
        return false;
    }
	
    private Boolean LIC14() {
        return false;
    }
	
	
	/*
	* Functions that returns the distance between two points in a 2D plane
	*/
	private double getDistance(Integer firstPointX, Integer firstPointY, Integer secondPointX, Integer secondPointY){
		// Distance formula
		// distance = squareroot((x2 - x1)^2 + (y2 - y1)^2)
		double distance = Math.sqrt(Math.pow((secondPointX - firstPointX), 2) + Math.pow((secondPointY - firstPointY), 2));
		
		return distance;
	}

    
}
