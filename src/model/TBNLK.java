/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class TBNLK extends NhapLieuKhac{
    private int stt;
    private int soTien;
    private int usd;

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

    public int getUsd() {
        return usd;
    }

    public void setUsd(int usd) {
        this.usd = usd;
    }

    public TBNLK(int soTien, int usd, String maNLK) {
        super(maNLK);
               this.usd = usd;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.stt;
        hash = 61 * hash + this.soTien;
        hash = 61 * hash + this.usd;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TBNLK other = (TBNLK) obj;
        if (this.stt != other.stt) {
            return false;
        }
        if (this.soTien != other.soTien) {
            return false;
        }
        return this.usd == other.usd;
    }

    @Override
    public String toString() {
        return "TBNLK{" + "stt=" + stt + ", soTien=" + soTien + ", usd=" + usd + '}';
    }

    
    
    
    
}
