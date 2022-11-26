CREATE DATABASE DUAN1_S2
GO
USE DUAN1_S2
GO

CREATE TABLE KHACHHANG(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Makh nvarchar(50),
Ten nvarchar(50),
Diachi nvarchar(100),
Sdt nvarchar(50),
)

CREATE TABLE NHANVIEN(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Manv nvarchar(50) ,
Ten nvarchar(50),
Diachi nvarchar(100),
Gioitinh nvarchar(10),
Ngaysinh date ,
email nvarchar(50),
sdt nvarchar(50),
luong int ,
)
alter table NHANVIEN
add Trangthai int ;
select *from NHANVIEN
CREATE TABLE SANPHAM(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Masp nvarchar(50),
Ten nvarchar(50),
Soluong int,
)

CREATE TABLE HOADON(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Idkh UNIQUEIDENTIFIER  foreign key references KHACHHANG(ID),
Idnv UNIQUEIDENTIFIER foreign key references NHANVIEN(ID),
Mahd nvarchar(50),
Ngaytao date ,
)

CREATE TABLE DEGIAY(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Made nvarchar(50),
Chatlieude nvarchar(50),
Docaode int,
)


CREATE TABLE MAUSAC(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Tenmau nvarchar(50),
Mamau nvarchar(50),
)


CREATE TABLE KIEUDANG(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Tenkieu nvarchar(50),
Makieu nvarchar(50),
)

CREATE TABLE SIZE(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Tensize int,
Masize nvarchar(50),
)
CREATE TABLE CHITIETSANPHAM (
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Idsp  UNIQUEIDENTIFIER foreign key references SANPHAM(ID),
Idms UNIQUEIDENTIFIER  foreign key references MAUSAC(ID),
Idkieu UNIQUEIDENTIFIER foreign key references KIEUDANG(ID),
Idsize UNIQUEIDENTIFIER  foreign key references SIZE(ID),
Idde UNIQUEIDENTIFIER  foreign key references DEGIAY(ID),
Mactsp nvarchar(50),
Hinhanh nvarchar(max),
Soluong int ,
Dongia int,
Mota nvarchar(50),
Trangthai int ,
)

CREATE TABLE HOADONCHITIET(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Idhd UNIQUEIDENTIFIER foreign key references HOADON(ID),
Idctsp  UNIQUEIDENTIFIER foreign key references CHITIETSANPHAM(ID),
Soluong int , 
Tongtien int ,
Trangthai int,
)

CREATE TABLE DOIHANG(
Id UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
Idhdct UNIQUEIDENTIFIER foreign key references HOADONCHITIET(ID),
Idnv  UNIQUEIDENTIFIER foreign key references NHANVIEN(ID),
Idkh UNIQUEIDENTIFIER foreign key references KHACHHANG(ID),
Ngaydoitra date,
Soluong int,
Lydo nvarchar(100),
)

CREATE TABLE TAIKHOAN(
Mataikhoan nvarchar(50) PRIMARY KEY,
Tentaikhoan nvarchar(50),
Chucvu nvarchar(50),
Pass nvarchar(50),
)
insert into TAIKHOAN values('TK1','TAIKHOAN1','NHANVIEN','PASS1'),
('TK2','TAIKHOAN2','NHANVIEN','PASS2')

 insert into KHACHHANG (Makh,Ten,Diachi,Sdt)values ('KH01','ANH','HA NOI',0384647364),
 ('KH02','ANH','HA NOI',0384647364);

  insert into NHANVIEN values (newid(),'NV01','ANH','HA NOI','NAM','10-09-1990','ANH98@GMAIL.COM',0384647364,10000000),
 (newid(),'NV02','ANH2','HA NOI','NAM','10-09-1990','ANH98@GMAIL.COM',0384647364,200000);

 INSERT INTO SANPHAM values (NEWID (),'SP01','SAN PHAM 1',30),
(NEWID (),'SP02','SAN PHAM 2',30)

insert into HOADON(idkh,idnv,mahd,ngaytao)
select  kh.Id, nv.Id,'HD2', '2-9-2022' from KHACHHANG kh, NHANVIEN nv  where kh.Makh = 'KH02' AND nv.Manv = 'NV02'

insert into DEGIAY values (NEWID(),'MD01','Cao su',3),
(NEWID(),'MD02','nhua',5)

insert into MAUSAC values (NEWID(),'Mau 1','MM1'),
(NEWID(),'Mau 2','MM2')

insert into KIEUDANG values (NEWID(),'KIEU 1','MK1'),
(NEWID(),'KIEU 2','MK2')

insert into SIZE values (NEWID(),1,'MS1'),
(NEWID(),20,'MS2')

insert into CHITIETSANPHAM(Idsp,idms,idkieu,idsize,idde,Mactsp,hinhanh,soluong,dongia,mota,trangthai)
select sp.id,ms.id,kd.id,sz.id,de.id,'CTSP1','ANH',600,10000,'hang tot',1  from SANPHAM sp,MAUSAC ms,KIEUDANG kd, SIZE sz,DEGIAY de where sp.Masp='SP01' AND ms.Mamau='MM1' AND kd.Makieu= 'MK1'and sz.Masize = 'MS1'AND de.Made = 'MD01'

insert into HOADONCHITIET (idhd,idctsp,soluong,tongtien,trangthai)
select hd.id,ctsp.id,3,300000,1 from HOADON hd,CHITIETSANPHAM ctsp where hd.Mahd='HD2' AND ctsp.Mactsp='CTSP1'

select*from NHANVIEN