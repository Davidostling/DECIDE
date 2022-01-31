package com.example;
import com.example.DECIDE.LCM;

public class PUM {
    CMV cmv;
    LCM[][] lcm;
    Boolean[][] pum;
    
    public PUM(CMV cmv, LCM[][] lcm){
        this.cmv = cmv;
        this.lcm = lcm;
        pum = new Boolean[15][15];
        setPUM();
    }
    public void setPUM(){

    }
}

