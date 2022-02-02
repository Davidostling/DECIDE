package com.example;

public class FUV {
    Boolean[][] pum;
    Boolean[] puv;
    Boolean[] fuv;

	/*
	* The Final Unlocking Vector (FUV) is generated from the Preliminary 
	* Unlocking Matrix. The input PUV indicates whether the corresponding LIC 
	* is to be considered as a factor in signaling interceptor launch. FUV[i] 
	* should be set to true if PUV[i] is false (indicating that the associated 
	* LIC should not hold back launch) or if all elements in PUM row i are true.
	*/
    public FUV(Boolean[][] pum, Boolean[] puv){
        this.pum = pum;
        this.puv = puv;
        fuv = new Boolean[15];
        setFUV();
    }
    public void setFUV(){
		
		for(int i = 0; i < 15; i++){
			
			// If puv[i] is false
			if(puv[i] == false){
				fuv[i] = true;
				return;
			}
			
			// If as much as one element in the i:th row of PUM is false
			// Set fuv[i] as false and return
			for(int j = 0; j < 15; j++){
				
				if(pum[i][j] == false){
					fuv[i] = false;
					return;
				}
			}
			
			// Otherwise set current position to true
			// All elements in the i:th row of PUM is true
			fuv[i] = true;
		}
    }
	
	/*
	* Returns the value of the FUV for the specified index
	*/
	public boolean getFUV(int index){
		return fuv[index];
	}

    public Boolean[] getFUVVector(){
        return fuv;
    }

}
