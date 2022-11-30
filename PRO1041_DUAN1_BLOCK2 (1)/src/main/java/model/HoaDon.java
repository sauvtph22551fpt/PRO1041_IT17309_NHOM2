/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Date;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author Hoang
 */
@Entity
@Table(name = "HOADON")
public class HoaDon {
    @Id 
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Idkh")
    private KhachHang khachHang;
    
    @JoinColumn(name = "Idnv")
    private String idnv;
    
    @JoinColumn(name = "Mahd")
    private String maHd;
    
    @JoinColumn(name = "Ngaytao")
    private Date ngayTao;

    public HoaDon() {
    }

    public HoaDon(String id, KhachHang khachHang, String idnv, String maHd, Date ngayTao) {
        this.id = id;
        this.khachHang = khachHang;
        this.idnv = idnv;
        this.maHd = maHd;
        this.ngayTao = ngayTao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public KhachHang getKhachHang() {
        return khachHang;
    }

    public void setKhachHang(KhachHang khachHang) {
        this.khachHang = khachHang;
    }

    public String getIdnv() {
        return idnv;
    }

    public void setIdnv(String idnv) {
        this.idnv = idnv;
    }

    public String getMaHd() {
        return maHd;
    }

    public void setMaHd(String maHd) {
        this.maHd = maHd;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "id=" + id + ", idnv=" + idnv + ", maHd=" + maHd + ", ngayTao=" + ngayTao + '}';
    }
    
    
    
}
