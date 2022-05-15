USE [CafeTakeAway]
GO
INSERT [dbo].[TAI_KHOAN] ([TEN_TK], [MAT_KHAU], [CHUC_VU]) VALUES (N'ADMIN     ', N'admin', N'QL')
INSERT [dbo].[TAI_KHOAN] ([TEN_TK], [MAT_KHAU], [CHUC_VU]) VALUES (N'nguyenvinh', N'1234', N'NV')
INSERT [dbo].[TAI_KHOAN] ([TEN_TK], [MAT_KHAU], [CHUC_VU]) VALUES (N'thanhnam  ', N'1234', N'NV')
INSERT [dbo].[TAI_KHOAN] ([TEN_TK], [MAT_KHAU], [CHUC_VU]) VALUES (N'tranvinh  ', N'1234', N'NV')
SET IDENTITY_INSERT [dbo].[NHAN_VIEN] ON 

INSERT [dbo].[NHAN_VIEN] ([MA_NV], [HO], [TEN], [DIA_CHI], [SDT], [TT_NGHI], [TEN_TK]) VALUES (101, N'NGUYỄN THANH', N'TÙNG', N'ĐỊA CHỈ NÈ', N'073446234 ', 0, N'ADMIN     ')
INSERT [dbo].[NHAN_VIEN] ([MA_NV], [HO], [TEN], [DIA_CHI], [SDT], [TT_NGHI], [TEN_TK]) VALUES (110, N'NGUYỄN', N'TÊN', N'ĐỊA CHỈ', N'0123123123', 0, N'thanhnam  ')
INSERT [dbo].[NHAN_VIEN] ([MA_NV], [HO], [TEN], [DIA_CHI], [SDT], [TT_NGHI], [TEN_TK]) VALUES (121, N'TRẦN', N'VINH', N'', N'0123493478', 0, N'tranvinh  ')
INSERT [dbo].[NHAN_VIEN] ([MA_NV], [HO], [TEN], [DIA_CHI], [SDT], [TT_NGHI], [TEN_TK]) VALUES (122, N'NGUYỄN', N'VINH', N'', N'0393485893', 0, N'nguyenvinh')
SET IDENTITY_INSERT [dbo].[NHAN_VIEN] OFF
INSERT [dbo].[HOA_DON] ([MA_HD], [NGAY_TAO], [MA_NV], [MA_QUAY]) VALUES (N'FDSDFS    ', CAST(N'2022-05-15' AS Date), 101, 9)
INSERT [dbo].[HOA_DON] ([MA_HD], [NGAY_TAO], [MA_NV], [MA_QUAY]) VALUES (N'GH        ', CAST(N'2022-05-03' AS Date), 101, 9)
INSERT [dbo].[HOA_DON] ([MA_HD], [NGAY_TAO], [MA_NV], [MA_QUAY]) VALUES (N'hd1       ', CAST(N'2022-05-03' AS Date), 110, 9)
INSERT [dbo].[HOA_DON] ([MA_HD], [NGAY_TAO], [MA_NV], [MA_QUAY]) VALUES (N'HD12      ', CAST(N'2022-05-03' AS Date), 101, 9)
INSERT [dbo].[HOA_DON] ([MA_HD], [NGAY_TAO], [MA_NV], [MA_QUAY]) VALUES (N'hd2       ', CAST(N'2022-05-03' AS Date), 110, 9)
INSERT [dbo].[HOA_DON] ([MA_HD], [NGAY_TAO], [MA_NV], [MA_QUAY]) VALUES (N'hd3       ', CAST(N'2022-05-03' AS Date), 110, 9)
INSERT [dbo].[HOA_DON] ([MA_HD], [NGAY_TAO], [MA_NV], [MA_QUAY]) VALUES (N'hd4       ', CAST(N'2022-05-03' AS Date), 110, 9)
INSERT [dbo].[HOA_DON] ([MA_HD], [NGAY_TAO], [MA_NV], [MA_QUAY]) VALUES (N'KJ        ', CAST(N'2022-05-03' AS Date), 101, 9)
INSERT [dbo].[HOA_DON] ([MA_HD], [NGAY_TAO], [MA_NV], [MA_QUAY]) VALUES (N'YH        ', CAST(N'2022-05-03' AS Date), 101, 9)
INSERT [dbo].[PHIEU_NHAP] ([MA_PN], [NGAY_NHAP], [MA_NV], [MA_QUAY]) VALUES (N'pn001     ', CAST(N'2022-03-05' AS Date), 101, 1)
INSERT [dbo].[PHIEU_NHAP] ([MA_PN], [NGAY_NHAP], [MA_NV], [MA_QUAY]) VALUES (N'pn1       ', CAST(N'2022-03-05' AS Date), 101, 1)
INSERT [dbo].[CA_BAN] ([MA_CA], [GIO_BD], [GIO_KT]) VALUES (N'CH', CAST(N'13:00:00' AS Time), CAST(N'17:00:00' AS Time))
INSERT [dbo].[CA_BAN] ([MA_CA], [GIO_BD], [GIO_KT]) VALUES (N'SA', CAST(N'07:00:00' AS Time), CAST(N'11:00:00' AS Time))
INSERT [dbo].[CA_BAN] ([MA_CA], [GIO_BD], [GIO_KT]) VALUES (N'TO', CAST(N'19:20:00' AS Time), CAST(N'22:20:00' AS Time))
SET IDENTITY_INSERT [dbo].[CA_NV] ON 

INSERT [dbo].[CA_NV] ([ID], [MA_NV], [MA_CA], [THU], [MA_QUAY]) VALUES (13, 121, N'SA', N'02', 9)
INSERT [dbo].[CA_NV] ([ID], [MA_NV], [MA_CA], [THU], [MA_QUAY]) VALUES (14, 110, N'SA', N'02', 9)
SET IDENTITY_INSERT [dbo].[CA_NV] OFF
SET IDENTITY_INSERT [dbo].[THUC_DON] ON 

INSERT [dbo].[THUC_DON] ([MA_TD], [TEN_DO_UONG], [GIA_TIEN]) VALUES (1, N'CAFE SỬA NÓNG', 20000.0000)
INSERT [dbo].[THUC_DON] ([MA_TD], [TEN_DO_UONG], [GIA_TIEN]) VALUES (2, N'CAFE SỬA ĐÁ', 15000.0000)
SET IDENTITY_INSERT [dbo].[THUC_DON] OFF
INSERT [dbo].[CT_HD] ([MA_HD], [MA_TD], [SO_LUONG_LY], [GIA_TIEN]) VALUES (N'FDSDFS    ', 1, 1, 123123.0000)
INSERT [dbo].[CT_HD] ([MA_HD], [MA_TD], [SO_LUONG_LY], [GIA_TIEN]) VALUES (N'GH        ', 1, 4, 12312.0000)
INSERT [dbo].[CT_HD] ([MA_HD], [MA_TD], [SO_LUONG_LY], [GIA_TIEN]) VALUES (N'hd1       ', 1, 1, 20000.0000)
INSERT [dbo].[CT_HD] ([MA_HD], [MA_TD], [SO_LUONG_LY], [GIA_TIEN]) VALUES (N'HD12      ', 1, 1, 12000.0000)
INSERT [dbo].[CT_HD] ([MA_HD], [MA_TD], [SO_LUONG_LY], [GIA_TIEN]) VALUES (N'HD12      ', 2, 4, 12000.0000)
INSERT [dbo].[CT_HD] ([MA_HD], [MA_TD], [SO_LUONG_LY], [GIA_TIEN]) VALUES (N'hd3       ', 1, 1, 20000.0000)
INSERT [dbo].[CT_HD] ([MA_HD], [MA_TD], [SO_LUONG_LY], [GIA_TIEN]) VALUES (N'hd4       ', 1, 1, 20000.0000)
INSERT [dbo].[CT_HD] ([MA_HD], [MA_TD], [SO_LUONG_LY], [GIA_TIEN]) VALUES (N'KJ        ', 1, 1, 12312.0000)
INSERT [dbo].[CT_HD] ([MA_HD], [MA_TD], [SO_LUONG_LY], [GIA_TIEN]) VALUES (N'YH        ', 1, 1, 123123.0000)
SET IDENTITY_INSERT [dbo].[NGUYEN_LIEU] ON 

INSERT [dbo].[NGUYEN_LIEU] ([MA_NL], [TEN_NGUYEN_LIEU], [DVT]) VALUES (1, N'CAFE HẠT', N'KG')
INSERT [dbo].[NGUYEN_LIEU] ([MA_NL], [TEN_NGUYEN_LIEU], [DVT]) VALUES (2, N'SỮA ông thọ', N'lít')
INSERT [dbo].[NGUYEN_LIEU] ([MA_NL], [TEN_NGUYEN_LIEU], [DVT]) VALUES (3, N'ĐÁ LẠNH', N'KG')
INSERT [dbo].[NGUYEN_LIEU] ([MA_NL], [TEN_NGUYEN_LIEU], [DVT]) VALUES (4, N'CAM', N'QUẢ')
INSERT [dbo].[NGUYEN_LIEU] ([MA_NL], [TEN_NGUYEN_LIEU], [DVT]) VALUES (5, N'LY NHỰA', N'CÁI')
SET IDENTITY_INSERT [dbo].[NGUYEN_LIEU] OFF
INSERT [dbo].[CT_PN] ([MA_PN], [MA_NL], [SO_LUONG_NL], [GIA_TIEN]) VALUES (N'pn001     ', 1, 0, 0.0000)
INSERT [dbo].[CT_PN] ([MA_PN], [MA_NL], [SO_LUONG_NL], [GIA_TIEN]) VALUES (N'pn1       ', 1, 0, 0.0000)
INSERT [dbo].[CT_TD] ([MA_TD], [MA_NL], [SO_LUONG_CAN]) VALUES (1, 1, 0.5)
INSERT [dbo].[CT_TD] ([MA_TD], [MA_NL], [SO_LUONG_CAN]) VALUES (1, 2, 100)
INSERT [dbo].[CT_TD] ([MA_TD], [MA_NL], [SO_LUONG_CAN]) VALUES (2, 2, 3)
INSERT [dbo].[CT_TD] ([MA_TD], [MA_NL], [SO_LUONG_CAN]) VALUES (2, 5, 1)
SET IDENTITY_INSERT [dbo].[QUAY_CAFE] ON 

INSERT [dbo].[QUAY_CAFE] ([MA_QUAY], [DUONG], [KHU_PHO], [PHUONG], [QUAN], [TINH_TP], [GIA_TIEN], [TT_HD]) VALUES (9, N'17', N'2', N'LINH CHIỂU', N'THỦ ĐỨC', N'HCM', 0.0000, 1)
INSERT [dbo].[QUAY_CAFE] ([MA_QUAY], [DUONG], [KHU_PHO], [PHUONG], [QUAN], [TINH_TP], [GIA_TIEN], [TT_HD]) VALUES (10, N'16', N'2', N'LINH TRUNG', N'THỦ ĐỨC', N'HCM', 123.0000, 1)
INSERT [dbo].[QUAY_CAFE] ([MA_QUAY], [DUONG], [KHU_PHO], [PHUONG], [QUAN], [TINH_TP], [GIA_TIEN], [TT_HD]) VALUES (15, N'22', N'2', N'LINH CHIỂU', N'THỦ ĐỨC', N'HCM', 0.0000, 1)
SET IDENTITY_INSERT [dbo].[QUAY_CAFE] OFF
