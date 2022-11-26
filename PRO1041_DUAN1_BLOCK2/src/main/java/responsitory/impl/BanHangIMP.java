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
import model.KieuDang;
import model.MauSac;
import model.SanPham;
import model.sizeGiay;
import org.hibernate.Session;
import responsitory.IRPBanHang;

/**
 *
 * @author Hoang
 */
public class BanHangIMP implements IRPBanHang{
    
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
    public List<ChiTietSanPham> getAll() {
        try (Session s = HibernateUtils.getSesionFactory().openSession()){
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
        try(Session s = HibernateUtils.getSesionFactory().openSession()){
            List<sizeGiay> listSG = new ArrayList<>();
            TypedQuery<sizeGiay>  sg = s.createQuery("from sizeGiay");
            listSG = sg.getResultList();
            s.clear();
            return listSG;
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public List<SanPham> getListSanPham() {
        try(Session s = HibernateUtils.getSesionFactory().openSession()){
            List<SanPham> listSP = new ArrayList<>();
            TypedQuery<SanPham> sp = s.createQuery("from SanPham");
            listSP = sp.getResultList();
            s.clear();;
            return listSP;
        }catch(Exception e){
            return null;
        }
    }
    
   
    @Override
    public List<DeGiay> getListDeGiay() {
        try(Session s = HibernateUtils.getSesionFactory().openSession()){
            List<DeGiay> listDG = new ArrayList<>();
            TypedQuery dg = s.createQuery("from DeGiay");
            listDG = dg.getResultList();
            s.clear();
            return listDG;
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public List<MauSac> getListMauSac() {
        try(Session s = HibernateUtils.getSesionFactory().openSession()){
            List<MauSac> listMS = new ArrayList<>();
            TypedQuery ms = s.createQuery("from MauSac");
            listMS = ms.getResultList();
            s.clear();
            return listMS;
        }catch(Exception e){
            return null;
        }
    }

    @Override
    public List<KieuDang> getListKieudang() {
        try(Session s = HibernateUtils.getSesionFactory().openSession()){
            List<KieuDang> listKD = new ArrayList<>();
            TypedQuery kd = s.createQuery("from KieuDang");
            listKD = kd.getResultList();
            s.clear();
            return listKD;
        }catch(Exception e){
            return null;
        }
    }
     public static void main(String[] args) {
        BanHangIMP ct = new BanHangIMP();
        sizeGiay sg = new sizeGiay();
        SanPham sp = new SanPham();
        DeGiay dg = new DeGiay();
        MauSac ms = new MauSac();
        KieuDang kd = new KieuDang();
//        for (DeGiay s : ct.getListDeGiay()) {
//            System.out.println(s.toString());
//        }
        for (MauSac s : ct.getListMauSac()) {
            System.out.println(s.toString());
        }
//        for (KieuDang s : ct.getListKieudang()) {
//            System.out.println(s.toString());
//        }
    }
}
