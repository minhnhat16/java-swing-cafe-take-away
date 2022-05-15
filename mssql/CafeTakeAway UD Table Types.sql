use CafeTakeAway
go
--thêm chi tiết hóa đơn
create type DS_CTHD as table(
	MA_HD NCHAR(10),
	MA_TD INT,
	SO_LUONG_LY INT,
	GIA_TIEN MONEY,
	primary key(MA_HD asc, MA_TD asc)
)