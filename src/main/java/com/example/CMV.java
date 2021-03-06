package com.example;
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
	public Boolean[] getCMVVector(){
		return cmv;
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
    /**
     * 
     * @return True if there exists at least one set of three consecutive data points that cannot all be contained within or on a circle of radius RADIUS1. 
     * otherwise False
     */
    private Boolean LIC1() {
        List<Coordinate> points = param.getPOINTS();
        int numPoints = param.getNUMPOINTS();
        if(numPoints < 3)
            return false;
        int radius = param.getRADIUS1();
        for (int i = 0; i < numPoints-2; i++) {
            Coordinate one = points.get(i);
            Coordinate two = points.get(i+1);
            Coordinate three = points.get(i+2);
            //gets the centroid of the three points
            double centerX = (one.getX()+two.getX()+three.getX())/3;
            double centerY = (one.getY()+two.getY()+three.getY())/3;
            if(getDistanceOneDouble(one.getX(), one.getY(), centerX, centerY) > radius)
                return true;
            if(getDistanceOneDouble(two.getX(), two.getY(), centerX, centerY) > radius)
                return true;
            if(getDistanceOneDouble(three.getX(), three.getY(), centerX, centerY) > radius)
                return true;
        }
        return false;
    }
    /**
     * 
     * @return true if there exists at least one set of three consecutive data points which form an angle such that:
     * angle < (PI???EPSILON)
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

	/*
	 *
	 * @return true when there exists at least one set of Q PTS consecutive data points that lie in more than QUADS quadrants.
	 */
    private Boolean LIC4() {
		List<Coordinate> points = param.getPOINTS();
		int numPoints = param.getNUMPOINTS();
		int q_pts = param.getQ_PTS();
		int quads = param.getQUADS();

		for (int i = 0; i < numPoints - q_pts + 1; i++) {
			int quadrant_1 = 0;
			int quadrant_2 = 0;
			int quadrant_3 = 0;
			int quadrant_4 = 0;
			for (int j = i; j < q_pts; j++) {
				Coordinate cur_point = points.get(j);
				int x = cur_point.getX();
				int y = cur_point.getY();
				if (x > 0) {
					if (y >= 0) {
						quadrant_1 = 1;
					} else if (y < 0) {
						quadrant_4 = 1;
					}
				} else if (x < 0) {
					if (y >= 0) {
						quadrant_2 = 1;
					} else if (y < 0) {
						quadrant_3 = 1;
					}
				} else {
					if (y >= 0) {
						quadrant_1 = 1;
					} else if (y < 0) {
						quadrant_3 = 1;
					}
				}

				if ((quadrant_1 + quadrant_2 + quadrant_3 + quadrant_4) > quads)
					return true;
			}
		}
		return false;
    }

	/*
	 *
	 * @return true There exists at least one set of two consecutive data points, (X[i],Y[i]) and (X[j],Y[j]), such that X[j] - X[i] < 0.
	 */
    private Boolean LIC5() {
		List<Coordinate> points = param.getPOINTS();
		int numPoints = param.getNUMPOINTS();
		if (numPoints < 2)
			return false;

		for (int i = 0; i < numPoints - 1; i++) {
			Coordinate one = points.get(i);
			Coordinate two = points.get(i + 1);
			if (two.getX() - one.getX() < 0) {
				return true;
			}
		}
		return false;
	}

	/*
	* @return true if there exists at least one point in set which is closer than dist to the line from first to last point.
	*/
    private Boolean LIC6() {
		List<Coordinate> points = param.getPOINTS();
		int numpoints = param.getNUMPOINTS();
		int dist = param.getDIST();
		Coordinate firstPoint = points.get(0);
		Coordinate lastPoint = points.get(points.size()-1);
		if(numpoints<3) {
			return false;
		}
		if(firstPoint.getX()== lastPoint.getX() && firstPoint.getY()==lastPoint.getY()){
			for(int i = 1; i < points.size()-1; i++) {
				double distance = getDistance(points.get(i).getX(),points.get(i).getY(), firstPoint.getX(), firstPoint.getY());
				if (distance > dist) {
					return true;
				}
				return false;
			}
		}
		else {
			for (int i = 1; i < points.size() - 1; i++) {
				double distance = Math.abs((lastPoint.getX() - firstPoint.getX()) * (firstPoint.getY() - points.get(i).getY())
						- (firstPoint.getX() - points.get(i).getX()) * (lastPoint.getY() - firstPoint.getY()))
						/ Math.sqrt(Math.pow(lastPoint.getX() - firstPoint.getX(), 2) + Math.pow(lastPoint.getY() - firstPoint.getY(), 2));
				if (distance > dist) {
					return true;
				}
			}
			return false;
		}
		return false;
    }


    /**
     * @return true if there exists a set of two datapoints separated by K_PTS with distance > length1
     */
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

    /**
     * @return true if there exists three datapoints separated by A_PTS and B_PTSs that cannot be contained within a circle of radius1
     * returns false if there are less than 5 NUMPOINTS or datapoints can be contained within circle.
     */
    private Boolean LIC8() {
        List<Coordinate> points = param.getPOINTS();
        int radius1 = param.getRADIUS1();
        int numpoints = param.getNUMPOINTS();
        int a_points = param.getA_PTS();
        int b_points = param.getB_PTS();
        if(numpoints<5){
            return false;
        }
        if(radius1<=0){
            return false;
        }
        for(int i =0; i < points.size()-a_points-b_points-2; i++){
            int Ax = points.get(i).getX();
            int Ay = points.get(i).getY();
            int Bx = points.get(i+a_points+1).getX();
            int By = points.get(i+a_points+1).getY();
            int Cx = points.get(i+a_points+b_points+2).getX();
            int Cy = points.get(i+a_points+b_points+2).getY();
            double AB = getDistance(Ax,Ay,Bx,By);
            double BC = getDistance(Bx,By,Cx,Cy);
            double CA = getDistance(Cx,Cy,Ax,Ay);
            if(AB <= radius1*2 && BC <= radius1*2 && CA <= radius1*2){
                return false;
            }
        }
        return true;
    }

    private Boolean LIC9() {
        List<Coordinate> points = param.getPOINTS();
        int numPoints = param.getNUMPOINTS();
        if(numPoints < 3 || 1 > param.getC_PTS() || 1 > param.getD_PTS() || param.getC_PTS()+param.getD_PTS()>numPoints-3)
            return false;
        double epsilon = param.getEPSILON();
        for (int i = 0; i < numPoints-param.getC_PTS() - param.getD_PTS()-2; i++) {
            Coordinate one = points.get(i);
            Coordinate two = points.get(i+param.getC_PTS()+1);
            Coordinate three = points.get(i+param.getD_PTS()+2);
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

    private Boolean LIC10() {

        // There exists at least one set of three data points separated by exactly C PTS
        // and D PTS consecutive intervening points

        // When NUMPOINTS < 5, the condition is not met. The intervals presented below are the ones that are not included
        if (param.getNUMPOINTS() < 5 || 1 > param.getE_PTS() || 1 > param.getF_PTS() || param.getE_PTS()+param.getF_PTS()>param.getNUMPOINTS()-3){
            return false;
        }
		

        for(int i = 0; i < param.getNUMPOINTS() - param.getE_PTS() - param.getF_PTS()-2; i++){

			int xa = (param.POINTS.get(i).getX());
			int ya = (param.POINTS.get(i).getY());
			int xb = param.POINTS.get(i+param.getE_PTS()+1).getX();
			int yb = param.POINTS.get(i+param.getE_PTS()+1).getY();
			int xc = param.POINTS.get(i+param.getF_PTS()+2).getX();
			int yc = param.POINTS.get(i+param.getF_PTS()+2).getY();

            //We set all x and y values and then calculate the area by viewing all the coords as a 1/2 determinant with all x values as the first column, all the y values as the second column and a third column filled with 1:s, this gives us:
            double foundarea = 0.5*Math.abs((xa*(yb-yc)+xb*(yc-ya)+xc*(ya-yb)));


            //Check if the condition is met
            if (param.getAREA1() < foundarea){
                return true;
            }
        }
        

        return false;
    }

    private Boolean LIC11() {
        /*
         * There exists at least one set of two data points, (X[i],Y[i]) and
         * (X[j],Y[j]), separated by exactly G PTS consecutive intervening points, such
         * that X[j] - X[i] < 0. (where i < j ) The condition is not met when NUMPOINTS
         * < 3.
         * 1 ??? G PTS ??? NUMPOINTS???2
         */
        if (param.getNUMPOINTS() < 3 || 1 > param.getG_PTS() || param.getG_PTS() > param.getNUMPOINTS()-2) {
            return false;
        }

        for (int i = 0; i < param.getNUMPOINTS() - param.getG_PTS() - 1; i++) {
            if ((param.getPOINTS().get(i + param.getG_PTS() + 1).getX()) - (param.getPOINTS().get(i).getX()) < 0) {

                return true;
            }

        }

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
		
		for(int i = 0; i < numPoints && i + k_pts + 1 < numPoints; i++){
			Integer firstPointX = points.get(i).getX();
			Integer firstPointY = points.get(i).getY();
			
			Integer secondPointX = points.get(i + k_pts + 1).getX();
			Integer secondPointY = points.get(i + k_pts + 1).getY();
			
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
		
		for(int i = 0; i < numPoints && i + a_pts + 1 < numPoints && i + b_pts + 1 < numPoints; i++){
			Integer firstPointX = points.get(i).getX();
			Integer firstPointY = points.get(i).getY();
			
			Integer secondPointX = points.get(i + a_pts + 1).getX();
			Integer secondPointY = points.get(i + a_pts + 1).getY();
			
			Integer thirdPointX = points.get(i + b_pts + 1).getX();
			Integer thirdPointY = points.get(i + b_pts + 1).getY();
			
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
		
		for(int i = 0; i < numPoints && i + e_pts + 1< numPoints && i + f_pts + 1 < numPoints; i++){
			Integer firstPointX = points.get(i).getX();
			Integer firstPointY = points.get(i).getY();
			
			Integer secondPointX = points.get(i + e_pts + 1).getX();
			Integer secondPointY = points.get(i + e_pts + 1).getY();
			
			Integer thirdPointX = points.get(i + f_pts + 1).getX();
			Integer thirdPointY = points.get(i + f_pts + 1).getY();
			
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
  
    /*
	* Functions that returns the distance between two points in a 2D plane
    * All integers
	*/
	private double getDistance(Integer firstPointX, Integer firstPointY, Integer secondPointX, Integer secondPointY){
		// Distance formula
		// distance = squareroot((x2 - x1)^2 + (y2 - y1)^2)
		double distance = Math.sqrt(Math.pow((secondPointX - firstPointX), 2) + Math.pow((secondPointY - firstPointY), 2));
		return distance;
	}
    /*
	* Functions that returns the distance between two points in a 2D plane
    * First point is integer and second point is double
	*/
	private double getDistanceOneDouble(Integer firstPointX, Integer firstPointY, double secondPointX, double secondPointY){
		// Distance formula
		// distance = squareroot((x2 - x1)^2 + (y2 - y1)^2)
		double distance = Math.sqrt(Math.pow((secondPointX - firstPointX), 2) + Math.pow((secondPointY - firstPointY), 2));
		return distance;
	}

    
}
