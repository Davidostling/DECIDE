package com.example;
import com.example.DECIDE.LCM;

public class PUM {
    Boolean[] cmv;
    LCM[][] lcm;
    Boolean[][] pum;
    
    public PUM(Boolean[] cmv, LCM[][] lcm){
        this.cmv = cmv;
        this.lcm = lcm;
        pum = new Boolean[15][15];
        setPUM();
    }
    /**
     * PUM is the preliminary unlocking matrix
     * The entries in the LCM represent the logical connectors to be used between pairs of LICs to determine the
     * corresponding entry in the PUM, i.e. LCM[i,j] represents the boolean operator to be applied to CMV[i] and
     * CMV[j]. PUM[i,j] is set according to the result of this operation. If LCM[i,j] is NOTUSED, then PUM[i,j]
     * should be set to true. If LCM[i,j] is ANDD, PUM[i,j] should be set to true only if (CMV[i] AND CMV[j]) is true.
     * If LCM[i,j] is ORR, PUM[i,j] should be set to true if (CMV[i] OR CMV[j]) is true.
     * 
     */
    public void setPUM(){
        for (int i = 0; i < lcm.length; i++) {
            for (int j = 0; j < lcm.length; j++) {
                if(i == j)
                    continue;
                pum[i][j] = false;
                if(lcm[i][j] == LCM.NOTUSED){
                    pum[i][j] = true;
                    continue;
                }
                if(lcm[i][j] == LCM.ANDD){
                    if(cmv[i] && cmv[j]){
                        pum[i][j] = true;
                        continue;
                    }
                }
                if(lcm[i][j] == LCM.ORR){
                    if(cmv[i] || cmv[j]){
                        pum[i][j] = true;
                        continue;
                    }
                }
            }
        }
    }
    public Boolean[][] getPUMMatrix(){
        return pum;
    }
}

