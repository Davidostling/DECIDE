package com.example;

public class FUV {
    PUM pum;
    Boolean[] puv;
    Boolean[] fuv;

    public FUV(PUM pum, Boolean[] puv){
        this.pum = pum;
        this.puv = puv;
        fuv = new Boolean[15];
        setFUV();
    }
    public void setFUV(){

    }
    public Boolean[] getFUVVector(){
        return fuv;
    }
}
