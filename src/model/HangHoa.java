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
public class HangHoa {
    private String maHH;
    private String tenHH;
    private String dvt;

    public String getMaHH() {
        return maHH;
    }

    public void setMaHH(String maHH) {
        this.maHH = maHH;
    }

    public String getTenHH() {
        return tenHH;
    }

    public void setTenHH(String tenHH) {
        this.tenHH = tenHH;
    }

    public String getDvt() {
        return dvt;
    }

    public void setDvt(String dvt) {
        this.dvt = dvt;
    }

    public HangHoa() {
    }

    public HangHoa(String maHH, String tenHH, String dvt) {
        this.maHH = maHH;
        this.tenHH = tenHH;
        this.dvt = dvt;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.maHH);
        hash = 89 * hash + Objects.hashCode(this.tenHH);
        hash = 89 * hash + Objects.hashCode(this.dvt);
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
        final HangHoa other = (HangHoa) obj;
        if (!Objects.equals(this.maHH, other.maHH)) {
            return false;
        }
        if (!Objects.equals(this.tenHH, other.tenHH)) {
            return false;
        }
        return Objects.equals(this.dvt, other.dvt);
    }

    @Override
    public String toString() {
        return "HangHoa{" + "maHH=" + maHH + ", tenHH=" + tenHH + ", dvt=" + dvt + '}';
    }
    
    
}
