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
