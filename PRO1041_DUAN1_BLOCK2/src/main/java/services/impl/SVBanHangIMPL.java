/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services.impl;

import java.util.ArrayList;
import java.util.List;
import model.ChiTietSanPham;
import model.DeGiay;
import model.KieuDang;
import model.MauSac;
import model.SanPham;
import model.sizeGiay;
import responsitory.impl.BanHangIMP;
import services.ISVBanHang;
import responsitory.IRPBanHang;

public class SVBanHangIMPL implements ISVBanHang {

    private IRPBanHang repoSanPham = new BanHangIMP();

    @Override
    public List<ChiTietSanPham> getAll() {
        return repoSanPham.getAll();
    }

    @Override
    public ChiTietSanPham getMaSp(String maSp) {
        for(ChiTietSanPham ctsp : repoSanPham.getAll()){
            if(ctsp.getSanPham().getMaSp().equalsIgnoreCase(maSp)){
                return ctsp;
            }
        }
        return null;
    }

    @Override
    public List<ChiTietSanPham> searchByMa(String maSp) {
        List<ChiTietSanPham> listSearch = new ArrayList<>();
        for(ChiTietSanPham ctsp : repoSanPham.getAll()){
            if(ctsp.getSanPham().getMaSp().contains(maSp)){
                listSearch.add(ctsp);
            }
        }
        return listSearch;
    }

    @Override
    public List<sizeGiay> getListSizeGiay() {
        return repoSanPham.getListSizeGiay();
    }

    @Override
    public List<SanPham> getListSanPham() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DeGiay> getListDeGiay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<MauSac> getListMauSac() {
        return repoSanPham.getListMauSac();
    }

    @Override
    public List<KieuDang> getListKieudang() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
