/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsitory.impl;

import Ultility.HibernateUtils;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
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
import org.hibernate.Session;
import org.hibernate.Transaction;
import responsitory.IRPBanHang;

/**
 *
 * @author Hoang
 */
public class BanHangIMP implements IRPBanHang {

//    public List<ChiTietSanPham> getall(){
//        try (Session s = HibernateUtils.getSesionFactory().openSession()){
//            List<ChiTietSanPham> list = new ArrayList<>();
//            TypedQuery<ChiTietSanPham> qr = s.createQuery("from ChiTietSanPham");
//            list = qr.getResultList();
//            s.close();
//            return list;
//        } catch (Exception e) {
//            return null;
//        }
//    }
    @Override
    public List<ChiTietSanPham> getChiTietSanPham() {
        try (Session s = HibernateUtils.getSesionFactory().openSession()) {
            List<ChiTietSanPham> list = new ArrayList<>();
            TypedQuery<ChiTietSanPham> qr = s.createQuery("from ChiTietSanPham");
            list = qr.getResultList();
            s.close();
            return list;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<sizeGiay> getListSizeGiay() {
        try (Session s = HibernateUtils.getSesionFactory().openSession()) {
            List<sizeGiay> listSG = new ArrayList<>();
            TypedQuery<sizeGiay> sg = s.createQuery("from sizeGiay");
            listSG = sg.getResultList();
            s.clear();
            return listSG;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<SanPham> getListSanPham() {
        try (Session s = HibernateUtils.getSesionFactory().openSession()) {
            List<SanPham> listSP = new ArrayList<>();
            TypedQuery<SanPham> sp = s.createQuery("from SanPham");
            listSP = sp.getResultList();
            s.clear();;
            return listSP;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<DeGiay> getListDeGiay() {
        try (Session s = HibernateUtils.getSesionFactory().openSession()) {
            List<DeGiay> listDG = new ArrayList<>();
            TypedQuery dg = s.createQuery("from DeGiay");
            listDG = dg.getResultList();
            s.clear();
            return listDG;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<MauSac> getListMauSac() {
        try (Session s = HibernateUtils.getSesionFactory().openSession()) {
            List<MauSac> listMS = new ArrayList<>();
            TypedQuery ms = s.createQuery("from MauSac");
            listMS = ms.getResultList();
            s.clear();
            return listMS;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<KieuDang> getListKieudang() {
        try (Session s = HibernateUtils.getSesionFactory().openSession()) {
            List<KieuDang> listKD = new ArrayList<>();
            TypedQuery kd = s.createQuery("from KieuDang");
            listKD = kd.getResultList();
            s.clear();
            return listKD;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<KhachHang> getListKhachHang() {
        try (Session s = HibernateUtils.getSesionFactory().openSession()) {
            List<KhachHang> listKH = new ArrayList<>();
            TypedQuery query = s.createQuery("from KhachHang");
            listKH = query.getResultList();
            s.clear();
            return listKH;
        } catch (Exception x) {
            return null;
        }
    }

    @Override
    public List<HoaDonChiTiet> getListHoaDonChiTiet() {
        try (Session s = HibernateUtils.getSesionFactory().openSession()) {
            List<HoaDonChiTiet> listHDCT = new ArrayList<>();
            TypedQuery query = s.createQuery("from HoaDonChiTiet");
            listHDCT = query.getResultList();
            s.close();
            return listHDCT;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<HoaDon> getListHoaDon() {
        try(Session s = HibernateUtils.getSesionFactory().openSession()){
            List<HoaDon> listHD = new ArrayList<>();
            TypedQuery query = s.createQuery("from HoaDon");
            listHD = query.getResultList();
            s.close();
            return listHD;
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public boolean themKh(KhachHang kh) {
        try (Session s = HibernateUtils.getSesionFactory().openSession()) {
            Transaction trans = s.beginTransaction();
            try {
                s.saveOrUpdate(kh);
                trans.commit();
                s.close();
                return true;
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        BanHangIMP ct = new BanHangIMP();
        sizeGiay sg = new sizeGiay();
        SanPham sp = new SanPham();
        DeGiay dg = new DeGiay();
        MauSac ms = new MauSac();
        KieuDang kd = new KieuDang();
        KhachHang kh = new KhachHang();
        HoaDonChiTiet hdct = new HoaDonChiTiet();
        HoaDon hd = new HoaDon();
//        for (DeGiay s : ct.getListDeGiay()) {
//            System.out.println(s.toString());
//        }
        for (sizeGiay s : ct.getListSizeGiay()) {
            System.out.println(s.toString());
        }
//        for (KieuDang s : ct.getListKieudang()) {
//            System.out.println(s.toString());
//        }
    }

}
