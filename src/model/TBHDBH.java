/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author PC
 */
public class TBHDBH extends HDBH{
    private int STT;
    private int soLuong;
    private int donGia  ;
    private int soTien;
    private String maHH;
    private String tenHH;
    private int usd;

 

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getDonGia() {
        return donGia;
    }

    public void setDonGia(int donGia) {
        this.donGia = donGia;
    }

    public int getSoTien() {
        return soTien;
    }

    public void setSoTien(int soTien) {
        this.soTien = soTien;
    }

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

    public int getUsd() {
        return usd;
    }

    public void setUsd(int usd) {
        this.usd = usd;
    }

    public TBHDBH(int STT, int soLuong, int donGia, int soTien, String maHH, String tenHH, int usd, String maHDBH, Date ngayChungTu, String tkNo, String tkCo, String nguoiMua, String noiDung, String maKho, String maNH, String maKH, int congTienHang, double thueGTGT, double sum) {
        super(maHDBH, ngayChungTu, tkNo, tkCo, nguoiMua, noiDung, maKho, maNH, maKH, congTienHang, thueGTGT, sum);
        this.STT = STT;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.soTien = soTien;
        this.maHH = maHH;
        this.tenHH = tenHH;
        this.usd = usd;
    }

    public TBHDBH(int STT, int soLuong, int donGia, int soTien, String maHH, String tenHH, int usd, String maHDBH) {
        super(maHDBH);
        this.STT = STT;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.soTien = soTien;
        this.maHH = maHH;
        this.tenHH = tenHH;
        this.usd = usd;
    }

    public TBHDBH(int soLuong, int donGia, int soTien, String maHH, String tenHH, int usd, String maHDBH) {
        super(maHDBH);
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.soTien = soTien;
        this.maHH = maHH;
        this.tenHH = tenHH;
        this.usd = usd;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.STT;
        hash = 97 * hash + this.soLuong;
        hash = 97 * hash + this.donGia;
        hash = 97 * hash + this.soTien;
        hash = 97 * hash + Objects.hashCode(this.maHH);
        hash = 97 * hash + Objects.hashCode(this.tenHH);
        hash = 97 * hash + this.usd;
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
        final TBHDBH other = (TBHDBH) obj;
        if (this.STT != other.STT) {
            return false;
        }
        if (this.soLuong != other.soLuong) {
            return false;
        }
        if (this.donGia != other.donGia) {
            return false;
        }
        if (this.soTien != other.soTien) {
            return false;
        }
        if (this.usd != other.usd) {
            return false;
        }
        if (!Objects.equals(this.maHH, other.maHH)) {
            return false;
        }
        return Objects.equals(this.tenHH, other.tenHH);
    }

    @Override
    public String toString() {
        return "TBHDBH{" + "STT=" + STT + ", soLuong=" + soLuong + ", donGia=" + donGia + ", soTien=" + soTien + ", maHH=" + maHH + ", tenHH=" + tenHH + ", usd=" + usd + '}';
    }
    
    
}
