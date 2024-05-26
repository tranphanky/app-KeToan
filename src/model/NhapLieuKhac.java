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
public class NhapLieuKhac {
    private String maNLK;
    private Date ngayChungTu;
    private String tkNo;
    private String tkCo;
    private String hoTen;
    private String diaChi;
    private String noiDung;
    private String kemTheo;
    private String nganHang;
    private String thuocChiPhi;
    private String khachHang;
    private String sanPham;
    private String hangHoa;
    private String phanXuong;
    private int congTienHang;
    private double thueGTGT;
    private double congTienThanhToan;

    public String getMaNLK() {
        return maNLK;
    }

    public void setMaNLK(String maNLK) {
        this.maNLK = maNLK;
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

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getKemTheo() {
        return kemTheo;
    }

    public void setKemTheo(String kemTheo) {
        this.kemTheo = kemTheo;
    }

    public String getNganHang() {
        return nganHang;
    }

    public void setNganHang(String nganHang) {
        this.nganHang = nganHang;
    }

    public String getThuocChiPhi() {
        return thuocChiPhi;
    }

    public void setThuocChiPhi(String thuocChiPhi) {
        this.thuocChiPhi = thuocChiPhi;
    }

    public String getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(String khachHang) {
        this.khachHang = khachHang;
    }

    public String getSanPham() {
        return sanPham;
    }

    public void setSanPham(String sanPham) {
        this.sanPham = sanPham;
    }

    public String getHangHoa() {
        return hangHoa;
    }

    public void setHangHoa(String hangHoa) {
        this.hangHoa = hangHoa;
    }

    public String getPhanXuong() {
        return phanXuong;
    }

    public void setPhanXuong(String phanXuong) {
        this.phanXuong = phanXuong;
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

    public double getCongTienThanhToan() {
        return congTienThanhToan;
    }

    public void setCongTienThanhToan(double congTienThanhToan) {
        this.congTienThanhToan = congTienThanhToan;
    }

    public NhapLieuKhac(String maNLK, Date ngayChungTu, String tkNo, String tkCo, String hoTen, String diaChi, String noiDung, String kemTheo, String nganHang, String thuocChiPhi, String khachHang, String sanPham, String hangHoa, String phanXuong, int congTienHang, double thueGTGT, double congTienThanhToan) {
        this.maNLK = maNLK;
        this.ngayChungTu = ngayChungTu;
        this.tkNo = tkNo;
        this.tkCo = tkCo;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.noiDung = noiDung;
        this.kemTheo = kemTheo;
        this.nganHang = nganHang;
        this.thuocChiPhi = thuocChiPhi;
        this.khachHang = khachHang;
        this.sanPham = sanPham;
        this.hangHoa = hangHoa;
        this.phanXuong = phanXuong;
        this.congTienHang = congTienHang;
        this.thueGTGT = thueGTGT;
        this.congTienThanhToan = congTienThanhToan;
    }

    public NhapLieuKhac(String maNLK) {
        this.maNLK = maNLK;
    }
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.maNLK);
        hash = 17 * hash + Objects.hashCode(this.ngayChungTu);
        hash = 17 * hash + Objects.hashCode(this.tkNo);
        hash = 17 * hash + Objects.hashCode(this.tkCo);
        hash = 17 * hash + Objects.hashCode(this.hoTen);
        hash = 17 * hash + Objects.hashCode(this.diaChi);
        hash = 17 * hash + Objects.hashCode(this.noiDung);
        hash = 17 * hash + Objects.hashCode(this.kemTheo);
        hash = 17 * hash + Objects.hashCode(this.nganHang);
        hash = 17 * hash + Objects.hashCode(this.thuocChiPhi);
        hash = 17 * hash + Objects.hashCode(this.khachHang);
        hash = 17 * hash + Objects.hashCode(this.sanPham);
        hash = 17 * hash + Objects.hashCode(this.hangHoa);
        hash = 17 * hash + Objects.hashCode(this.phanXuong);
        hash = 17 * hash + this.congTienHang;
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.thueGTGT) ^ (Double.doubleToLongBits(this.thueGTGT) >>> 32));
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.congTienThanhToan) ^ (Double.doubleToLongBits(this.congTienThanhToan) >>> 32));
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
        final NhapLieuKhac other = (NhapLieuKhac) obj;
        if (this.congTienHang != other.congTienHang) {
            return false;
        }
        if (Double.doubleToLongBits(this.thueGTGT) != Double.doubleToLongBits(other.thueGTGT)) {
            return false;
        }
        if (Double.doubleToLongBits(this.congTienThanhToan) != Double.doubleToLongBits(other.congTienThanhToan)) {
            return false;
        }
        if (!Objects.equals(this.maNLK, other.maNLK)) {
            return false;
        }
        if (!Objects.equals(this.tkNo, other.tkNo)) {
            return false;
        }
        if (!Objects.equals(this.tkCo, other.tkCo)) {
            return false;
        }
        if (!Objects.equals(this.hoTen, other.hoTen)) {
            return false;
        }
        if (!Objects.equals(this.diaChi, other.diaChi)) {
            return false;
        }
        if (!Objects.equals(this.noiDung, other.noiDung)) {
            return false;
        }
        if (!Objects.equals(this.kemTheo, other.kemTheo)) {
            return false;
        }
        if (!Objects.equals(this.nganHang, other.nganHang)) {
            return false;
        }
        if (!Objects.equals(this.thuocChiPhi, other.thuocChiPhi)) {
            return false;
        }
        if (!Objects.equals(this.khachHang, other.khachHang)) {
            return false;
        }
        if (!Objects.equals(this.sanPham, other.sanPham)) {
            return false;
        }
        if (!Objects.equals(this.hangHoa, other.hangHoa)) {
            return false;
        }
        if (!Objects.equals(this.phanXuong, other.phanXuong)) {
            return false;
        }
        return Objects.equals(this.ngayChungTu, other.ngayChungTu);
    }

    @Override
    public String toString() {
        return "NhapLieuKhac{" + "maNLK=" + maNLK + ", ngayChungTu=" + ngayChungTu + ", tkNo=" + tkNo + ", tkCo=" + tkCo + ", hoTen=" + hoTen + ", diaChi=" + diaChi + ", noiDung=" + noiDung + ", kemTheo=" + kemTheo + ", nganHang=" + nganHang + ", thuocChiPhi=" + thuocChiPhi + ", khachHang=" + khachHang + ", sanPham=" + sanPham + ", hangHoa=" + hangHoa + ", phanXuong=" + phanXuong + ", congTienHang=" + congTienHang + ", thueGTGT=" + thueGTGT + ", congTienThanhToan=" + congTienThanhToan + '}';
    }

    
    
}
