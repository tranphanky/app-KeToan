/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package model;

import java.util.Objects;

/**
 *
 * @author PC
 */
public class KhachHang {

    private String maKH;
    private String tenKH;
    private String diaChi;
    private String maSoThue;

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public KhachHang() {
    }

    public KhachHang(String maKH, String tenKH, String diaChi, String maSoThue) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.diaChi = diaChi;
        this.maSoThue = maSoThue;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.maKH);
        hash = 79 * hash + Objects.hashCode(this.tenKH);
        hash = 79 * hash + Objects.hashCode(this.diaChi);
        hash = 79 * hash + Objects.hashCode(this.maSoThue);
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
        final KhachHang other = (KhachHang) obj;
        if (!Objects.equals(this.maKH, other.maKH)) {
            return false;
        }
        if (!Objects.equals(this.tenKH, other.tenKH)) {
            return false;
        }
        if (!Objects.equals(this.diaChi, other.diaChi)) {
            return false;
        }
        return Objects.equals(this.maSoThue, other.maSoThue);
    }

    @Override
    public String toString() {
        return "KhachHang{" + "maKH=" + maKH + ", tenKH=" + tenKH + ", diaChi=" + diaChi + ", maSoThue=" + maSoThue + '}';
    }

   
}
