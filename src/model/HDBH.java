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
public class HDBH {
    private String maHDBH;
    private Date ngayChungTu;
    private String tkNo;
    private String tkCo;
    private String nguoiMua;
    private String noiDung;
    private String maKho;
    private String maNH;
    private String maKH;
    private int congTienHang;
    private double thueGTGT;
    private double sum;

    public String getMaHDBH() {
        return maHDBH;
    }

    public void setMaHDBH(String maHDBH) {
        this.maHDBH = maHDBH;
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

    public String getNguoiMua() {
        return nguoiMua;
    }

    public void setNguoiMua(String nguoiMua) {
        this.nguoiMua = nguoiMua;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getMaKho() {
        return maKho;
    }

    public void setMaKho(String maKho) {
        this.maKho = maKho;
    }

    public String getMaNH() {
        return maNH;
    }

    public void setMaNH(String maNH) {
        this.maNH = maNH;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public int getCongTienHang() {
        return congTienHang;
    }

    public void setCongTienHang(int congTienHang) {
        this.congTienHang = congTienHang;
    }

    public double getThueGTGT() {
        return thueGTGT;
    }

    public void setThueGTGT(double thueGTGT) {
        this.thueGTGT = thueGTGT;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    
    
    public HDBH(String maHDBH, Date ngayChungTu, String tkNo, String tkCo, String nguoiMua, String noiDung, String maKho, String maNH, String maKH, int congTienHang, double thueGTGT, double sum) {
        this.maHDBH = maHDBH;
        this.ngayChungTu = ngayChungTu;
        this.tkNo = tkNo;
        this.tkCo = tkCo;
        this.nguoiMua = nguoiMua;
        this.noiDung = noiDung;
        this.maKho = maKho;
        this.maNH = maNH;
        this.maKH = maKH;
        this.congTienHang = congTienHang;
        this.thueGTGT = thueGTGT;
        this.sum = sum;
    }

    public HDBH(String maHDBH) {
        this.maHDBH = maHDBH;
    }
    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + Objects.hashCode(this.maHDBH);
        hash = 13 * hash + Objects.hashCode(this.ngayChungTu);
        hash = 13 * hash + Objects.hashCode(this.tkNo);
        hash = 13 * hash + Objects.hashCode(this.tkCo);
        hash = 13 * hash + Objects.hashCode(this.nguoiMua);
        hash = 13 * hash + Objects.hashCode(this.noiDung);
        hash = 13 * hash + Objects.hashCode(this.maKho);
        hash = 13 * hash + Objects.hashCode(this.maNH);
        hash = 13 * hash + Objects.hashCode(this.maKH);
        hash = 13 * hash + this.congTienHang;
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.thueGTGT) ^ (Double.doubleToLongBits(this.thueGTGT) >>> 32));
        hash = 13 * hash + (int) (Double.doubleToLongBits(this.sum) ^ (Double.doubleToLongBits(this.sum) >>> 32));
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
        final HDBH other = (HDBH) obj;
        if (this.congTienHang != other.congTienHang) {
            return false;
        }
        if (Double.doubleToLongBits(this.thueGTGT) != Double.doubleToLongBits(other.thueGTGT)) {
            return false;
        }
        if (Double.doubleToLongBits(this.sum) != Double.doubleToLongBits(other.sum)) {
            return false;
        }
        if (!Objects.equals(this.maHDBH, other.maHDBH)) {
            return false;
        }
        if (!Objects.equals(this.tkNo, other.tkNo)) {
            return false;
        }
        if (!Objects.equals(this.tkCo, other.tkCo)) {
            return false;
        }
        if (!Objects.equals(this.nguoiMua, other.nguoiMua)) {
            return false;
        }
        if (!Objects.equals(this.noiDung, other.noiDung)) {
            return false;
        }
        if (!Objects.equals(this.maKho, other.maKho)) {
            return false;
        }
        if (!Objects.equals(this.maNH, other.maNH)) {
            return false;
        }
        if (!Objects.equals(this.maKH, other.maKH)) {
            return false;
        }
        return Objects.equals(this.ngayChungTu, other.ngayChungTu);
    }

    @Override
    public String toString() {
        return "HDBH{" + "maHDBH=" + maHDBH + ", ngayChungTu=" + ngayChungTu + ", tkNo=" + tkNo + ", tkCo=" + tkCo + ", nguoiMua=" + nguoiMua + ", noiDung=" + noiDung + ", maKho=" + maKho + ", maNH=" + maNH + ", maKH=" + maKH + ", congTienHang=" + congTienHang + ", thueGTGT=" + thueGTGT + ", sum=" + sum + '}';
    }
    
    
}
