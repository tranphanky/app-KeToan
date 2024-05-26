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
public class TaiKhoanKeToan {
    private String taiKhoanC1_Ten;
    private Integer taiKhoanC1_SoHieu;
    private String taiKhoanC2_Ten;
    private Integer taiKhoanC2_SoHieu;

    public String getTaiKhoanC1_Ten() {
        return taiKhoanC1_Ten;
    }

    public void setTaiKhoanC1_Ten(String taiKhoanC1_Ten) {
        this.taiKhoanC1_Ten = taiKhoanC1_Ten;
    }

    public Integer getTaiKhoanC1_SoHieu() {
        return taiKhoanC1_SoHieu;
    }

    public void setTaiKhoanC1_SoHieu(Integer taiKhoanC1_SoHieu) {
        this.taiKhoanC1_SoHieu = taiKhoanC1_SoHieu;
    }

    public String getTaiKhoanC2_Ten() {
        return taiKhoanC2_Ten;
    }

    public void setTaiKhoanC2_Ten(String taiKhoanC2_Ten) {
        this.taiKhoanC2_Ten = taiKhoanC2_Ten;
    }

    public Integer getTaiKhoanC2_SoHieu() {
        return taiKhoanC2_SoHieu;
    }

    public void setTaiKhoanC2_SoHieu(Integer taiKhoanC2_SoHieu) {
        this.taiKhoanC2_SoHieu = taiKhoanC2_SoHieu;
    }

    public TaiKhoanKeToan(String taiKhoanC1_Ten, Integer taiKhoanC1_SoHieu, String taiKhoanC2_Ten, Integer taiKhoanC2_SoHieu) {
        this.taiKhoanC1_Ten = taiKhoanC1_Ten;
        this.taiKhoanC1_SoHieu = taiKhoanC1_SoHieu;
        this.taiKhoanC2_Ten = taiKhoanC2_Ten;
        this.taiKhoanC2_SoHieu = taiKhoanC2_SoHieu;
    }

    public TaiKhoanKeToan() {
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.taiKhoanC1_Ten);
        hash = 71 * hash + Objects.hashCode(this.taiKhoanC1_SoHieu);
        hash = 71 * hash + Objects.hashCode(this.taiKhoanC2_Ten);
        hash = 71 * hash + Objects.hashCode(this.taiKhoanC2_SoHieu);
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
        final TaiKhoanKeToan other = (TaiKhoanKeToan) obj;
        if (!Objects.equals(this.taiKhoanC1_Ten, other.taiKhoanC1_Ten)) {
            return false;
        }
        if (!Objects.equals(this.taiKhoanC2_Ten, other.taiKhoanC2_Ten)) {
            return false;
        }
        if (!Objects.equals(this.taiKhoanC1_SoHieu, other.taiKhoanC1_SoHieu)) {
            return false;
        }
        return Objects.equals(this.taiKhoanC2_SoHieu, other.taiKhoanC2_SoHieu);
    }

    @Override
    public String toString() {
        return "TaiKhoanKeToan{" + "taiKhoanC1_Ten=" + taiKhoanC1_Ten + ", taiKhoanC1_SoHieu=" + taiKhoanC1_SoHieu + ", taiKhoanC2_Ten=" + taiKhoanC2_Ten + ", taiKhoanC2_SoHieu=" + taiKhoanC2_SoHieu + '}';
    }

   
    
   
    
    
}
