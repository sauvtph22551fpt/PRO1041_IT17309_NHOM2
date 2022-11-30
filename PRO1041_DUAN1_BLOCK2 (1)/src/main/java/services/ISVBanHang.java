/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import model.ChiTietSanPham;
import model.DeGiay;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.KhachHang;
import model.KieuDang;
import model.MauSac;
import model.SanPham;
import model.sizeGiay;

/**
 *
 * @author Hoang
 */
public interface ISVBanHang {

    public List<ChiTietSanPham> getListChiTietSanPham();

    public List<ChiTietSanPham> searchByMa(String maSp);

    public List<sizeGiay> getListSizeGiay();

    public List<SanPham> getListSanPham();

    public List<DeGiay> getListDeGiay();

    public List<MauSac> getListMauSac();

    public List<KieuDang> getListKieudang();

    public List<HoaDonChiTiet> getListHoaDonChiTiet();

    public List<KhachHang> getListKhachHang();

    public List<HoaDon> getListHoaDon();

    public String checkKhacHang(int sdt);

    public boolean checkTrungSdt(int sdt);

    public boolean themKhachHang(KhachHang kh);

    public ChiTietSanPham getMaSp(String maSp);

    public HoaDonChiTiet getMaHD(String maHD);

    public List<ChiTietSanPham> searchKhoangGia(String khoangGia,String kieu, String size);

    

}
