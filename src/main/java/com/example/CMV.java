package com.example;

public class CMV {
    Parameters param;
    Boolean[] cmv;

    public CMV(Parameters param){
        this.param = param;
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
