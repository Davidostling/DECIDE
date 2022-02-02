package com.example;
import java.util.List;

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
        return false;
    }
    private Boolean LIC10() {
        return false;
    }
    private Boolean LIC11() {
        return false;
    }
    private Boolean LIC12() {
        return false;
    }
    private Boolean LIC13() {
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
