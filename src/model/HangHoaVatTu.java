/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Objects;

/**
 *
 * @author PC
 */
public class HangHoaVatTu {
    private String tenHHVT;
    private String dvt;
    private String maSo;

    public String getTenHHVT() {
        return tenHHVT;
    }

    public void setTenHHVT(String tenHHVT) {
        this.tenHHVT = tenHHVT;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public HangHoaVatTu(String tenHHVT, String dvt, String maSo) {
        this.tenHHVT = tenHHVT;
        this.dvt = dvt;
        this.maSo = maSo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.tenHHVT);
        hash = 97 * hash + Objects.hashCode(this.dvt);
        hash = 97 * hash + Objects.hashCode(this.maSo);
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
        final HangHoaVatTu other = (HangHoaVatTu) obj;
        if (!Objects.equals(this.tenHHVT, other.tenHHVT)) {
            return false;
        }
        if (!Objects.equals(this.dvt, other.dvt)) {
            return false;
        }
        return Objects.equals(this.maSo, other.maSo);
    }

    @Override
    public String toString() {
        return "HangHoaVatTu{" + "tenHHVT=" + tenHHVT + ", dvt=" + dvt + ", maSo=" + maSo + '}';
    }
    
    
    
    
}
