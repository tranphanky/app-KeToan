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
public class Kho {
    private String maSoKho;
    private String tenKho;
    private String diaDiem;

    public String getMaSoKho() {
        return maSoKho;
    }

    public void setMaSoKho(String maSoKho) {
        this.maSoKho = maSoKho;
    }

    public String getTenKho() {
        return tenKho;
    }

    public void setTenKho(String tenKho) {
        this.tenKho = tenKho;
    }

    public String getDiaDiem() {
        return diaDiem;
    }

    public void setDiaDiem(String diaDiem) {
        this.diaDiem = diaDiem;
    }

    public Kho(String maSoKho, String tenKho, String diaDiem) {
        this.maSoKho = maSoKho;
        this.tenKho = tenKho;
        this.diaDiem = diaDiem;
    }

    public Kho() {
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.maSoKho);
        hash = 71 * hash + Objects.hashCode(this.tenKho);
        hash = 71 * hash + Objects.hashCode(this.diaDiem);
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
        final Kho other = (Kho) obj;
        if (!Objects.equals(this.maSoKho, other.maSoKho)) {
            return false;
        }
        if (!Objects.equals(this.tenKho, other.tenKho)) {
            return false;
        }
        return Objects.equals(this.diaDiem, other.diaDiem);
    }

    @Override
    public String toString() {
        return "Kho{" + "maSoKho=" + maSoKho + ", tenKho=" + tenKho + ", diaDiem=" + diaDiem + '}';
    }
    
    
}
