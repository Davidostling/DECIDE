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
			
			// Distance formula
			// distance = squareroot((x2 - x1)^2 + (y2 - y1)^2)
			double distance = Math.sqrt(Math.pow((secondPointX - firstPointX), 2) + Math.pow((secondPointY - firstPointY), 2));
			
			
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
    private Boolean LIC13() {
        return false;
    }
    private Boolean LIC14() {
        return false;
    }

    
}
