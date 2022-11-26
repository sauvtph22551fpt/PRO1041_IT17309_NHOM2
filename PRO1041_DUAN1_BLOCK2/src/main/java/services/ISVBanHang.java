/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import model.ChiTietSanPham;
import model.DeGiay;
import model.KieuDang;
import model.MauSac;
import model.SanPham;
import model.sizeGiay;

/**
 *
 * @author Hoang
 */
public interface ISVBanHang {

    public List<ChiTietSanPham> getAll();

    public List<sizeGiay> getListSizeGiay();

    public List<SanPham> getListSanPham();

    public List<DeGiay> getListDeGiay();

    public List<MauSac> getListMauSac();

    public List<KieuDang> getListKieudang();

    public ChiTietSanPham getMaSp(String maSp);

    public List<ChiTietSanPham> searchByMa(String maSp);
}
