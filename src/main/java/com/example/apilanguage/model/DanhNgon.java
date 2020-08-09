package com.example.apilanguage.model;

public class DanhNgon {
    String theLoai;
    String cauViet;
    String cauNgoaiNgu;
    String tacGia;

    public DanhNgon(String theLoai, String cauViet, String cauNgoaiNgu, String tacGia) {
        this.theLoai = theLoai;
        this.cauViet = cauViet;
        this.cauNgoaiNgu = cauNgoaiNgu;
        this.tacGia = tacGia;
    }

    public String getTheLoai() {
        return theLoai;
    }

    public void setTheLoai(String theLoai) {
        this.theLoai = theLoai;
    }

    public String getCauViet() {
        return cauViet;
    }

    public void setCauViet(String cauViet) {
        this.cauViet = cauViet;
    }

    public String getCauNgoaiNgu() {
        return cauNgoaiNgu;
    }

    public void setCauNgoaiNgu(String cauNgoaiNgu) {
        this.cauNgoaiNgu = cauNgoaiNgu;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    @Override
    public String toString() {
        return "DanhNgon{" +
                "theLoai='" + theLoai + '\'' +
                ", cauViet='" + cauViet + '\'' +
                ", cauNgoaiNgu='" + cauNgoaiNgu + '\'' +
                ", tacGia='" + tacGia + '\'' +
                '}';
    }
}
