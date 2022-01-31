package com.example;

/**
 * Hello world!
 *
 */
public class DECIDE 
{
    enum LAUNCH {
        YES,
        NO
    }
    enum LCM {
        ANDD,
        ORR,
        NOTUSED
    }
    CMV cmv;
    FUV fuv;
    Parameters param;
    PUM pum;
    LAUNCH launch;

    public DECIDE(Parameters param, LCM[][] lcm, Boolean[] puv){
        this.param = param;
        cmv = new CMV(param);
        pum = new PUM(cmv, lcm);
        fuv = new FUV(pum, puv);
        setLAUNCH();
    }
    public void setLAUNCH() {

    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }
}
