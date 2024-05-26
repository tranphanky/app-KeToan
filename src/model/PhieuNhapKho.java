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

public class PhieuNhapKho {
    private String maPNK;
    private Date ngayChungTu;
    private String tkNo;
    private String tkCo;
    private String tenNguoiGiao;
    private String tomTat;
    private String maKho;
    private String maKH;
    private double thueGTGT;
    private double cong;
    private String kemtheoCTG;
    private String chiuThue;
    private String hinhThuc;
    public String getMaPNK() {
        return maPNK;
    }

    public void setMaPNK(String maPNK) {
        this.maPNK = maPNK;
    }

    public Date getNgayChungTu() {
        return ngayChungTu;
    }

    public void setNgayChungTu(Date ngayChungTu) {
        this.ngayChungTu = ngayChungTu;
    }

    public String getTkNo() {
        return tkNo;
    }

    public void setTkNo(String tkNo) {
        this.tkNo = tkNo;
    }

    public String getTkCo() {
        return tkCo;
    }

    public void setTkCo(String tkCo) {
        this.tkCo = tkCo;
    }

    public String getTenNguoiGiao() {
        return tenNguoiGiao;
    }

    public void setTenNguoiGiao(String tenNguoiGiao) {
        this.tenNguoiGiao = tenNguoiGiao;
    }

    public String getTomTat() {
        return tomTat;
    }

    public void setTomTat(String tomTat) {
        this.tomTat = tomTat;
    }

    public String getMaKho() {
        return maKho;
    }

    public void setMaKho(String maKho) {
        this.maKho = maKho;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public double getThueGTGT() {
        return thueGTGT;
    }

    public void setThueGTGT(double thueGTGT) {
        this.thueGTGT = thueGTGT;
    }

    public double getCong() {
        return cong;
    }

    public void setCong(double cong) {
        this.cong = cong;
    }

    public String getKemtheoCTG() {
        return kemtheoCTG;
    }

    public void setKemtheoCTG(String kemtheoCTG) {
        this.kemtheoCTG = kemtheoCTG;
    }

    public String getChiuThue() {
        return chiuThue;
    }

    public void setChiuThue(String chiuThue) {
        this.chiuThue = chiuThue;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public PhieuNhapKho(String maPNK, Date ngayChungTu, String tkNo, String tkCo, String tenNguoiGiao, String tomTat, String maKho, String maKH, double thueGTGT, double cong, String kemtheoCTG, String chiuThue, String hinhThuc) {
        this.maPNK = maPNK;
        this.ngayChungTu = ngayChungTu;
        this.tkNo = tkNo;
        this.tkCo = tkCo;
        this.tenNguoiGiao = tenNguoiGiao;
        this.tomTat = tomTat;
        this.maKho = maKho;
        this.maKH = maKH;
        this.thueGTGT = thueGTGT;
        this.cong = cong;
        this.kemtheoCTG = kemtheoCTG;
        this.chiuThue = chiuThue;
        this.hinhThuc = hinhThuc;
    }

    public PhieuNhapKho() {
    }

    public PhieuNhapKho(String maPNK) {
        this.maPNK = maPNK;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.maPNK);
        hash = 71 * hash + Objects.hashCode(this.ngayChungTu);
        hash = 71 * hash + Objects.hashCode(this.tkNo);
        hash = 71 * hash + Objects.hashCode(this.tkCo);
        hash = 71 * hash + Objects.hashCode(this.tenNguoiGiao);
        hash = 71 * hash + Objects.hashCode(this.tomTat);
        hash = 71 * hash + Objects.hashCode(this.maKho);
        hash = 71 * hash + Objects.hashCode(this.maKH);
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.thueGTGT) ^ (Double.doubleToLongBits(this.thueGTGT) >>> 32));
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.cong) ^ (Double.doubleToLongBits(this.cong) >>> 32));
        hash = 71 * hash + Objects.hashCode(this.kemtheoCTG);
        hash = 71 * hash + Objects.hashCode(this.chiuThue);
        hash = 71 * hash + Objects.hashCode(this.hinhThuc);
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
        final PhieuNhapKho other = (PhieuNhapKho) obj;
        if (Double.doubleToLongBits(this.thueGTGT) != Double.doubleToLongBits(other.thueGTGT)) {
            return false;
        }
        if (Double.doubleToLongBits(this.cong) != Double.doubleToLongBits(other.cong)) {
            return false;
        }
        if (!Objects.equals(this.maPNK, other.maPNK)) {
            return false;
        }
        if (!Objects.equals(this.tkNo, other.tkNo)) {
            return false;
        }
        if (!Objects.equals(this.tkCo, other.tkCo)) {
            return false;
        }
        if (!Objects.equals(this.tenNguoiGiao, other.tenNguoiGiao)) {
            return false;
        }
        if (!Objects.equals(this.tomTat, other.tomTat)) {
            return false;
        }
        if (!Objects.equals(this.maKho, other.maKho)) {
            return false;
        }
        if (!Objects.equals(this.maKH, other.maKH)) {
            return false;
        }
        if (!Objects.equals(this.kemtheoCTG, other.kemtheoCTG)) {
            return false;
        }
        if (!Objects.equals(this.chiuThue, other.chiuThue)) {
            return false;
        }
        if (!Objects.equals(this.hinhThuc, other.hinhThuc)) {
            return false;
        }
        return Objects.equals(this.ngayChungTu, other.ngayChungTu);
    }

    @Override
    public String toString() {
        return "PhieuNhapKho{" + "maPNK=" + maPNK + ", ngayChungTu=" + ngayChungTu + ", tkNo=" + tkNo + ", tkCo=" + tkCo + ", tenNguoiGiao=" + tenNguoiGiao + ", tomTat=" + tomTat + ", maKho=" + maKho + ", maKH=" + maKH + ", thueGTGT=" + thueGTGT + ", cong=" + cong + ", kemtheoCTG=" + kemtheoCTG + ", chiuThue=" + chiuThue + ", hinhThuc=" + hinhThuc + '}';
    }
    
    
    
    
    
    
}
