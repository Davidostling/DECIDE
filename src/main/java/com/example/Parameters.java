package com.example;

import java.util.List;


public class Parameters {
    int NUMPOINTS;
    List<Coordinate> POINTS;
    int DIST;
    int LENGTH1;
    int LENGTH2;
    int RADIUS1;
    int RADIUS2;
    int AREA1;
    int AREA2;
    double EPSILON;
    int QUADS;
    int N_PTS;
    int K_PTS;
    int A_PTS;
    int B_PTS;
    int C_PTS;
    int D_PTS;
    int E_PTS;
    int F_PTS;
    int G_PTS;
    int Q_PTS;

    public Parameters(int NUMPOINTS,
    List<Coordinate> POINTS){
        this.NUMPOINTS = NUMPOINTS;
        this.POINTS = POINTS;
    }
    public int getAREA1() {
        return AREA1;
    }
    public int getAREA2() {
        return AREA2;
    }
    public int getA_PTS() {
        return A_PTS;
    }
    public int getB_PTS() {
        return B_PTS;
    }
    public int getC_PTS() {
        return C_PTS;
    }
    public int getDIST() {
        return DIST;
    }
    public int getD_PTS() {
        return D_PTS;
    }
    public double getEPSILON() {
        return EPSILON;
    }
    public int getE_PTS() {
        return E_PTS;
    }
    public int getF_PTS() {
        return F_PTS;
    }
    public int getG_PTS() {
        return G_PTS;
    }
    public int getK_PTS() {
        return K_PTS;
    }
    public int getLENGTH1() {
        return LENGTH1;
    }
    public int getLENGTH2() {
        return LENGTH2;
    }
    public int getNUMPOINTS() {
        return NUMPOINTS;
    }
    public int getN_PTS() {
        return N_PTS;
    }
    public List<Coordinate> getPOINTS() {
        return POINTS;
    }
    public int getQUADS() {
        return QUADS;
    }
    public int getQ_PTS() {
        return Q_PTS;
    }
    public int getRADIUS1() {
        return RADIUS1;
    }
    public int getRADIUS2() {
        return RADIUS2;
    }
    public void setAREA1(int aREA1) {
        AREA1 = aREA1;
    }
    public void setAREA2(int aREA2) {
        AREA2 = aREA2;
    }
    public void setA_PTS(int a_PTS) {
        A_PTS = a_PTS;
    }
    public void setB_PTS(int b_PTS) {
        B_PTS = b_PTS;
    }
    public void setC_PTS(int c_PTS) {
        C_PTS = c_PTS;
    }
    public void setDIST(int dIST) {
        DIST = dIST;
    }
    public void setD_PTS(int d_PTS) {
        D_PTS = d_PTS;
    }
    public void setEPSILON(double ePSILON) {
        EPSILON = ePSILON;
    }
    public void setE_PTS(int e_PTS) {
        E_PTS = e_PTS;
    }
    public void setF_PTS(int f_PTS) {
        F_PTS = f_PTS;
    }
    public void setG_PTS(int g_PTS) {
        G_PTS = g_PTS;
    }
    public void setK_PTS(int k_PTS) {
        K_PTS = k_PTS;
    }
    public void setLENGTH1(int lENGTH1) {
        LENGTH1 = lENGTH1;
    }
    public void setLENGTH2(int lENGTH2) {
        LENGTH2 = lENGTH2;
    }
    public void setNUMPOINTS(int nUMPOINTS) {
        NUMPOINTS = nUMPOINTS;
    }
    public void setN_PTS(int n_PTS) {
        N_PTS = n_PTS;
    }
    public void setPOINTS(List<Coordinate> pOINTS) {
        POINTS = pOINTS;
    }
    public void setQUADS(int qUADS) {
        QUADS = qUADS;
    }
    public void setQ_PTS(int q_PTS) {
        Q_PTS = q_PTS;
    }
    public void setRADIUS1(int rADIUS1) {
        RADIUS1 = rADIUS1;
    }
    public void setRADIUS2(int rADIUS2) {
        RADIUS2 = rADIUS2;
    }


}
