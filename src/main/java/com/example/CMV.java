package com.example;

public class CMV {
    Parameters param;
    Boolean[] cmv;

    public CMV(Parameters param){
        this.param = param;
        setCMV();
    }
    public void setCMV(){
        cmv[0] = LIC0();
        cmv[1] = LIC1();

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
    private Boolean LIC7(double[] X, double[] Y, int numpoints, double length1, int k_pts) {
        double x1; 
        double y1; 
        double x2; 
        double y2;
        if(numpoints<3){
            return false;
        }
        if (1 > k_pts || k_pts > (numpoints - 2)){
            return false;
        }
        for(int i=0; i<numpoints-k_pts-1; i++) {
            x1 = X[i];
            y1 = Y[i];
            x2 = X[i + k_pts + 1];
            y2 = Y[i + k_pts + 1];
            double ac = Math.abs(y2 - y1);
            double cb = Math.abs(x2 - x1);
            double length = Math.hypot(ac, cb);
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
    private Boolean LIC12() {
        return false;
    }
    private Boolean LIC13() {
        return false;
    }
    private Boolean LIC14() {
        return false;
    }

    
}
