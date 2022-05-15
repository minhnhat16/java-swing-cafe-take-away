use CafeTakeAway
go
create procedure [dbo].[sp_sua_nhan_vien]
@manv int, @ho nvarchar(50), @ten nvarchar(30), @diachi nvarchar(100),
@sdt nchar(10), @tt_nghi bit, @matkhau varchar(30)
as
set xact_abort on
begin tran
begin try
	update NHAN_VIEN set HO=@ho, TEN=@ten, DIA_CHI=@diachi, SDT=@sdt, TT_NGHI=@tt_nghi
	where MA_NV=@manv

	if @matkhau != ''
	begin
		declare @taikhoan nchar(10)
		select @taikhoan=TEN_TK from NHAN_VIEN where MA_NV=@manv

		update TAI_KHOAN set MAT_KHAU=@matkhau where TEN_TK=@taikhoan
	end	
	commit
end try
begin catch
	rollback
	declare @ErrorMessage varchar(2000)
	SELECT @ErrorMessage = N'Lỗi: ' + ERROR_MESSAGE()
	raiserror(@ErrorMessage, 16, 1)
end catch

GO
create proc [dbo].[sp_sua_quan_ly]
@manv int, @ho nvarchar(50), @ten nvarchar(30), @diachi nvarchar(100),
@sdt nchar(10), @matkhau varchar(30)
as
set xact_abort on
begin tran
begin try
	update NHAN_VIEN set HO=@ho, TEN=@ten, DIA_CHI=@diachi, SDT=@sdt
	where MA_NV=@manv

	if @matkhau != ''
	begin
		declare @taikhoan nchar(10)
		select @taikhoan=TEN_TK from NHAN_VIEN where MA_NV=@manv

		update TAI_KHOAN set MAT_KHAU=@matkhau where TEN_TK=@taikhoan
	end	
	commit
end try
begin catch
	rollback
	declare @ErrorMessage varchar(2000)
	SELECT @ErrorMessage = N'Lỗi: ' + ERROR_MESSAGE()
	raiserror(@ErrorMessage, 16, 1)
end catch

go
create proc [dbo].[sp_them_ca]
@maca nchar(2), @giobd time(0), @giokt time(0)
as
begin
	insert into CA_BAN values(@maca, @giobd, @giokt)
end

GO
CREATE PROC [dbo].[sp_them_hd]
@MA_HD NCHAR(10), @NGAY_TAO DATE, @MA_NV INT, @MA_QUAY INT, @DS_CTHD DS_CTHD READONLY, @RETURN BIT OUTPUT
AS
SET XACT_ABORT ON
BEGIN TRAN
BEGIN TRY
	INSERT INTO HOA_DON VALUES(@MA_HD, @NGAY_TAO, @MA_NV, @MA_QUAY)

	INSERT INTO CT_HD SELECT * FROM @DS_CTHD
	SET @RETURN=1
	COMMIT
END TRY

BEGIN CATCH
	SET @RETURN=0
	ROLLBACK
END CATCH

go
create procedure [dbo].[sp_them_nhan_vien]
@ho nvarchar(50), @ten nvarchar(30), @diachi nvarchar(100),
@sdt nchar(10), @taikhoan char(10), @matkhau varchar(30), @chucvu nchar(2)
as
set xact_abort on
begin tran
begin try
	--insert into NHANVIEN values
	--('test', 'ho', 'ten', 'dia chi', 'sdt', 0, 'cv', 'taikhoan'),
	--('test1', 'ho', 'ten', 'dia chi', 'sdt', 0, 'cv', 'taikhoan');
	insert into TAI_KHOAN values(@taikhoan, @matkhau, @chucvu)

	insert into NHAN_VIEN values(@ho, @ten, @diachi, @sdt, 'false', @taikhoan)
	commit
end try
begin catch
	rollback
	declare @ErrorMessage varchar(2000)
	SELECT @ErrorMessage = N'Lỗi: ' + ERROR_MESSAGE()
	raiserror(@ErrorMessage, 16, 1)
end catch

go
create proc [dbo].[sp_tim_kiem_nhan_vien_theo_ten]
@ten nvarchar(50)
as
begin
	select * from NHAN_VIEN where TEN_TK!='ADMIN' and TT_NGHI='false' and 
	(HO like N'%'+@ten+'%' or TEN like N'%'+@ten+'%')
end

go
create proc [dbo].[sp_xoa_nhan_vien]
@manv int, @value smallint output
as
set xact_abort on
begin tran
begin try
	declare @tk char(10)
	select @tk=ten_tk from nhan_vien where MA_NV=@manv

	delete from NHAN_VIEN where MA_NV=@manv
	delete from TAI_KHOAN where TEN_TK=@tk
	set @value = 1
	commit
end try
	
begin catch
	set @value = 0
	rollback
	raiserror('Xảy Ra Lỗi', 16, 1)
end catch