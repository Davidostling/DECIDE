package com.example;
import java.util.List;

import java.util.List;
import java.lang.Math;

public class CMV {
    Parameters param;
    Boolean[] cmv;

    public CMV(Parameters param){
        this.param = param;
        cmv = new Boolean[15];
        setCMV();
    }
    public void setCMV(){
        cmv[0]  = LIC0();
        cmv[1]  = LIC1();
        cmv[2]  = LIC2();
        cmv[3]  = LIC3();
        cmv[4]  = LIC4();
        cmv[5]  = LIC5();
        cmv[6]  = LIC6();
        cmv[7]  = LIC7();
        cmv[8]  = LIC8();
        cmv[9]  = LIC9();
        cmv[10] = LIC10();
        cmv[11] = LIC11();
        cmv[12] = LIC12();
        cmv[13] = LIC13();
        cmv[14] = LIC14();
    }
    public Boolean getCMV(int index){
        return cmv[index];
    }

    /**
     * Function for calculating LIC0
     * @return true if there are two points greater than LENGTH1 distance apart otherwise false
     */
    private Boolean LIC0() {
        List<Coordinate> points = param.getPOINTS();
        int numPoints = param.getNUMPOINTS();
        int length = param.getLENGTH1();
        for (int i = 0; i < numPoints-1; i++) {
            if(getDistance(points.get(i).getX(),  points.get(i).getY(),  points.get(i+1).getX(),  points.get(i+1).getY()) > length)
                return true;
        }
        return false;
    }
    private Boolean LIC1() {
        return false;
    }
    /**
     * 
     * @return true if there exists at least one set of three consecutive data points which form an angle such that:
     * angle < (PI−EPSILON)
     * or
     * angle > (PI+EPSILON)
     * else false
     **/
    private Boolean LIC2() {
        List<Coordinate> points = param.getPOINTS();
        int numPoints = param.getNUMPOINTS();
        if(numPoints < 3)
            return false;
        double epsilon = param.getEPSILON();
        for (int i = 0; i < numPoints-2; i++) {
            Coordinate one = points.get(i);
            Coordinate two = points.get(i+1);
            Coordinate three = points.get(i+2);
            //sets vector a and b in relating to the second point
            int xa = one.getX()-two.getX();
            int ya = one.getY()-two.getY();
            int xb = three.getX()-two.getX();
            int yb = three.getY()-two.getY();
            double angle = Math.acos((xa * xb + ya * yb) / Math.sqrt(Math.pow(xa, 2) + Math.pow(ya, 2)) * Math.sqrt(Math.pow(xb, 2) + Math.pow(yb, 2)));
            if(angle < Math.PI-epsilon)
                return true;
            if(angle > Math.PI+epsilon)
                return true;
        }
        return false;
    }

	/*
	 *
	 * @return true if there exists at least one set of three consecutive data points that are the vertices of a triangle with area greater than AREA1
	 */
    private Boolean LIC3() {
		List<Coordinate> points = param.getPOINTS();
		int numPoints = param.getNUMPOINTS();
		if (numPoints < 3)
			return false;
		double area1 = param.getAREA1();
		for (int i = 0; i < numPoints - 2; i++) {
			Coordinate one = points.get(i);
			Coordinate two = points.get(i+1);
			Coordinate three = points.get(i+2);
			double area = (one.getX() * (two.getY() - three.getY()) + two.getX() * (three.getY() - one.getY()) + three.getX() * (one.getY() - two.getY())) / 2.0f;
			if (Math.abs(area) > area1)
				return true;
		}
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
        List<Coordinate> points = param.getPOINTS();
        int k_pts = param.getK_PTS();
        int numpoints = param.getNUMPOINTS();
        int length1 = param.getLENGTH1();
        if(numpoints<3){
            return false;
        }
        for(int i=0; i<numpoints-k_pts-1; i++) {
            int x1 = points.get(i).getX();
            int y1 = points.get(i).getY();
            int x2 = points.get(i + k_pts + 1).getX();
            int y2 = points.get(i + k_pts + 1).getY();
            double length = getDistance(x1,y1,x2,y2);
            if (length > length1) {
                return true;
            }
        }
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
	* Lengths are greater than or equal to 0
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
	* B_PTS respectively consecutive intervening points that cannot be contained or 
	* exists on a circle of a radius of RADIUS1 as well as one of a radius of RADIUS2. 
	* The set of points can either be the same or different
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
	
	/*
	* Checks if there is at least one set of three points seperated by E_PTS respectively 
	* and F_PTS consecutive intervening points that are the vertices of a triangle of an 
	* area greater than AREA1 as well as one of an area less than AREA2. The
	* set of points can either be the same or different
	*
	* Both Must be present for the LIC to return true
	* Returns false if there are less than 5 NUMPOINTS
	* Areas are greater than or equal to 0
	*/
    private Boolean LIC14() {
		// Get all values required to calculating conditions
		List<Coordinate> points = param.getPOINTS();
		int numPoints = param.getNUMPOINTS();
		
		int e_pts = param.getE_PTS();
		int f_pts = param.getF_PTS();
		int area1 = param.getAREA1();
		int area2 = param.getAREA2();
		
		// If the number of points are less than 5 return false
		if(numPoints < 5){
			return false;
		}
		
		// The two conditions
		boolean greater_than_area1 = false;
		boolean lesser_than_area2 = false;
		
		for(int i = 0; i < numPoints && i + e_pts < numPoints && i + f_pts < numPoints; i++){
			Integer firstPointX = points.get(i).getX();
			Integer firstPointY = points.get(i).getY();
			
			Integer secondPointX = points.get(i + e_pts).getX();
			Integer secondPointY = points.get(i + e_pts).getY();
			
			Integer thirdPointX = points.get(i + f_pts).getX();
			Integer thirdPointY = points.get(i + f_pts).getY();
			
			// Area of a triangle based upon three points
			// absolute value((x1(y2 - y3) + x2(y3 - y1) + x3(y1 - y2)) / 2)
			double area = Math.abs((firstPointX * (secondPointY - thirdPointY) + secondPointX * (thirdPointY - firstPointY) + thirdPointX * (firstPointY - secondPointY)) / 2);
			
			if(area > area1 ){
				greater_than_area1 = true;
			}
			if(area < area2){
				lesser_than_area2 = true;
			}
			
			// If both conditions are met return true
			if(greater_than_area1 && lesser_than_area2){
				return true;
			}
		}
		
		// Otherwise return false
        return false;
    }
	private double getDistance(Integer firstPointX, Integer firstPointY, Integer secondPointX, Integer secondPointY){
		// Distance formula
		// distance = squareroot((x2 - x1)^2 + (y2 - y1)^2)
		double distance = Math.sqrt(Math.pow((secondPointX - firstPointX), 2) + Math.pow((secondPointY - firstPointY), 2));

		return distance;
	}

    
}
