package NganHangV2;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;


import static NganHangV2.TaiKhoan.taoSostk;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static HashMap<Long, Double> luuTK = new HashMap<>();
    static HashMap<Long, String> luuTen = new HashMap<>();
    static HashMap<Long, Double> luuTietKiem = new HashMap<>();
    static ThongTin tka = new ThongTin(taoSostk());
    static TKThanhToan tkA = new TKThanhToan(tka);
    static TKTietKiem tkaA = new TKTietKiem(tka);
    static ThongTin tkb = new ThongTin(taoSostk());
    static TKThanhToan tkB = new TKThanhToan(tkb);
    static TKTietKiem tkbB = new TKTietKiem(tkb);
    static DecimalFormat df = new DecimalFormat("#,###.##");
    static int c, ch, n, t, count = 0, e, dem = 0, l;
    static String chuTaiKhoan, matKhau, matKhauMoi;

    public static void main(String[] args) {
        luuTietKiem.put(tka.getSoTaiKhoan(), tkaA.soDuDu);
        luuTietKiem.put(tkb.getSoTaiKhoan(), tkbB.soDuDu);
        do {
            System.out.println("Chào Mừng Bạn Đến Với Ngân Hàng");
            System.out.println("0. Thoát 1");
            System.out.println("1. Mở Tài Khoản Ngân Hàng");
            System.out.print("Lựa Chọn Của Bạn: ");
            c = sc.nextInt();
            sc.nextLine();
        }while(c!=1 && c!=0);
        switch (c) {
            case 0:
                System.out.println("Cảm Ơn Bạn Đã Đến Với Chương Trình");
                System.exit(0);
            case 1:
                System.out.println("----------");
                System.out.println("Tạo Tài Khoản Mới");
                System.out.println("Số Tài Khoản Của Bạn : " + tka);
                System.out.print("Nhập Tên Của Bạn     : ");
                chuTaiKhoan = sc.nextLine();
                tkA.setTen(chuTaiKhoan);
                do {
                    System.out.print("Nhập Mật Khẩu Mới    : ");
                    matKhau = sc.nextLine();
                    System.out.print("Nhập Lại Mật Khẩu Mới: ");
                    matKhauMoi = sc.nextLine();
                    if (matKhau.equals(matKhauMoi)) {
                        System.out.println("---");
                        System.out.println("Tạo Tài Khoản Thành Công");
                        System.out.println("Mời Đăng Nhập Lại");
                        tkA.setMatKhau(matKhau);
                        luuTK.put(tka.getSoTaiKhoan(), tkA.soDu);
                        luuTen.put(tka.getSoTaiKhoan(), tkA.getTen());
                    } else System.out.println("Mật Khẩu Không Đúng. Nhập Lại");
                } while (!(matKhau.equals(matKhauMoi)));
                break;
            default:
                System.out.println("Lựa Chọn Không Đúng");
        }
        do {
            System.out.println("----------");
            System.out.println("0. Thoát 2");
            System.out.println("1. Mở Tài Khoản Ngân Hàng");
            System.out.println("2. Đăng Nhập Tài Khoản: " + tkA.getTen());
            System.out.print("Lựa Chọn Của Bạn: ");
            ch = sc.nextInt();
            sc.nextLine();
            System.out.println("----------");
            switch (ch) {
                case 0:
                    System.out.println("Cảm Ơn Đã Sử Dụng Nhé!");
                    System.exit(0);
                case 1:
                    System.out.println("Tạo Tài Khoản Mới");
                    System.out.println("Số Tài Khoản Của Bạn : " + tkb);
                    System.out.print("Nhập Tên Của Bạn     : ");
                    chuTaiKhoan = sc.nextLine();
                    tkB.setTen(chuTaiKhoan);
                    do {
                        System.out.print("Nhập Mật Khẩu Mới    : ");
                        matKhau = sc.nextLine();
                        System.out.print("Nhập Lại Mật Khẩu Mới: ");
                        matKhauMoi = sc.nextLine();
                        if (matKhau.equals(matKhauMoi)) {
                            System.out.println("---");
                            System.out.println("Tạo Tài Khoản Thành Công");
                            System.out.println("Mời Đăng Nhập Lại");
                            tkB.setMatKhau(matKhau);
                            luuTK.put(tkb.getSoTaiKhoan(), tkB.soDu);
                            luuTen.put(tkb.getSoTaiKhoan(), tkB.getTen());
                        } else System.out.println("Mật Khẩu Không Đúng. Nhập Lại");
                    } while (!(matKhau.equals(matKhauMoi)));
                    break;
                case 2:
                    case2();
                    break;
            }
        } while (ch > 1 || ch < 0);
        do {
            System.out.println("-----------");
            System.out.println("0. Thoát 3");
            System.out.println("1. Đăng Nhập Tài Khoản: " + tkB.getTen());
            System.out.println("2. Đăng Nhập Tài Khoản: " + tkA.getTen());
            System.out.print("Lựa Chọn: ");
            ch = sc.nextInt();
            sc.nextLine();
            switch (ch) {
                case 0:
                    System.out.println("Cảm Ơn Bạn Đã Sử Dụng");
                    System.exit(0);
                case 1:
                    System.out.println("----------");
                    System.out.println("Chào Mừng " + tkB.getTen());
                    do {
                        System.out.print("Nhập Mật Khẩu   : ");
                        matKhauMoi = sc.nextLine();
                        if (!tkB.matKhau.equals(matKhauMoi)) {
                            System.out.println("Mật khẩu không đúng");
                        }
                    } while (!(tkB.matKhau.equals(matKhauMoi)));
                    int oTP, otp;
                    do {
                        oTP = TaiKhoan.otp();
                        System.out.println("Mã Xác Thực     : " + oTP);
                        System.out.print("Nhập Mã Xác Thực: ");
                        otp = sc.nextInt();
                        if (otp == oTP) {
                            System.out.println("---");
                            System.out.println("Đăng Nhập Thành Công");
                            System.out.println("-----------");
                            System.out.println(tkB.toString());
                        } else System.out.println("Nhập Sai Mã Otp. Nhập Lại");
                    } while (otp != oTP);
                    do {
                        System.out.println("-----------");
                        System.out.println("Mời Lựa Chọn Chức Năng:");
                        System.out.println("0. Trở Lại 4");
                        System.out.println("1. Gửi Tiền");
                        System.out.println("2. Rút Tiền");
                        System.out.println("3. Chuyển Khoản");
                        if (dem == 0) {
                            System.out.println("4. Mở Sổ Tiết Kiệm ");
                        }
                        if (dem == 2) {
                            System.out.println("4. Kiểm Tra Sổ Tiết Kiệm ");
                        }
                        System.out.println("5. Đổi Mật Khẩu");
                        System.out.print("Lựa chọn: ");
                        t = sc.nextInt();
                        switch (t) {
                            case 0:
                                break;
                            case 1:
                                System.out.println("----------");
                                System.out.print("Nhập Số Tiền Muốn Gửi: ");
                                double gui = sc.nextDouble();
                                tkB.guiTien(gui);
                                System.out.println("----------");
                                System.out.println(tkB.toString());
                                luuTK.replace(tkb.getSoTaiKhoan(), tkB.soDu + gui);
                                break;
                            case 2:
                                System.out.println("----------");
                                System.out.print("Nhập Số Tiền Cần Rút: ");
                                double rut = sc.nextDouble();
                                tkB.rutTien(rut);
                                luuTK.replace(tkb.getSoTaiKhoan(), tkB.soDu - rut);
                                break;
                            case 3:
                                sc.nextLine();
                                long stK;
                                double chuyenTien;
                                do {
                                    System.out.print("Nhập số Tài Khoản Muốn chuyển: ");
                                    stK = sc.nextLong();
                                    if (!(luuTK.containsKey(stK))) {
                                        System.out.println("Số Tài Khoản Không Tồn Tại Tề");
                                    } else if (stK == tkb.soTaiKhoan) {
                                        System.out.println("Trùng số tài khoản với chính mình!");
                                    }
                                } while (!(luuTK.containsKey(stK)) || (stK == tkb.getSoTaiKhoan()));

                                do {
                                    System.out.print("Nhập số tiền muốn chuyển      : ");
                                    chuyenTien = sc.nextDouble();
                                    if (tkB.soDu < chuyenTien) {
                                        System.out.println("Không đủ tiền ấy ơi");
                                    } else if (chuyenTien < 2000) {
                                        System.out.println("Tiền ít quá không cho chuyển ấy ơi( phải >2000VNĐ)");
                                    }
                                } while (tkB.soDu < chuyenTien || chuyenTien < 2000);
                                System.out.println("Xác Nhận");
                                System.out.println("Số tài khoản: " + stK + ": " + luuTen.get(stK) + "\nMuốn chuyển : " + df.format(chuyenTien) + "VNĐ");
                                oTP = TaiKhoan.otp();
                                System.out.println("Mã OTP       : " + oTP);
                                System.out.print("Nhập mã OTP : ");
                                int OTP = sc.nextInt();
                                if (OTP == oTP) {
                                    TKThanhToan.ChuyenKhoan(luuTK, stK, chuyenTien);
                                    TKThanhToan.in(luuTK, stK, chuyenTien);
                                    tkB.soDu = tkB.soDu - chuyenTien;
                                    System.out.println(df.format(tkB.soDu) + " VNĐ");
                                    tkA.soDu = luuTK.get(tkA.thongTin.getSoTaiKhoan());
                                } else
                                    System.out.println("Mã OTP không chính xác. Giao dịch thất bại!");
                                break;
                            case 4:
                                if (dem == 0) {
                                    double tien;
                                    do {
                                        System.out.println("Nhập Số Tiền Muốn Gửi Tiết Kiệm");
                                        tien = sc.nextDouble();
                                        if (tien > luuTK.get(tkb.getSoTaiKhoan())) {
                                            System.out.println("Không Đủ Tiền. Nhập Lại(0. Để Thoát)");
                                        }
                                        if (tien == 0)
                                            return;
                                    } while (tien > luuTK.get(tkb.getSoTaiKhoan()));

                                    if (tkbB.thoiHan(luuTietKiem, tkb.getSoTaiKhoan(), tien) == 1) {
                                        dem++;
                                    }
                                    luuTietKiem.replace(tkb.getSoTaiKhoan(), tkbB.soDuDu + tien);
                                    tkbB.soDuDu = tkbB.soDuDu + tien;
                                    luuTK.replace(tkb.getSoTaiKhoan(), tkB.soDu - tien);
                                    tkB.setSoDu(luuTK.get(tkb.getSoTaiKhoan()));
                                }
                                if (dem == 2) {
                                    System.out.println("----------");
                                    System.out.println("Sổ Tiết Kiệm ");
                                    System.out.println("Tài Khoản: " + tkb.getSoTaiKhoan());
                                    System.out.println("Tên Tài Khoản: " + tkB.getTen());
                                    System.out.println("Số Tiền Đã Gửi : " + df.format(luuTietKiem.get(tkb.getSoTaiKhoan())) + " VNĐ");
                                    System.out.println("Lãi Cuối Kỳ Hạn:   " + df.format(tkbB.tong) + " VNĐ");
                                    System.out.println("----------");
                                    System.out.println("0. Trở Lại");
                                    System.out.println("1. Rút Tiền Trước Hạn");
                                    System.out.print("Lựa Chọn: ");
                                    l = sc.nextInt();
                                    sc.nextLine();
                                    switch (l) {
                                        case 0:
                                            dem--;
                                            break;
                                        case 1:
                                            System.out.println("Nhập Số Tiền Muốn Rút: ");
                                            double rutt = sc.nextDouble();
                                            tkbB.rutTien(rutt);
                                            luuTietKiem.replace(tkb.getSoTaiKhoan(), tkbB.soDuDu);
                                            luuTK.replace(tkb.getSoTaiKhoan(), tkB.soDu + rutt);
                                            tkB.soDu = tkB.soDu + rutt;
                                            if ((luuTietKiem.get(tkb.getSoTaiKhoan())) == 0) {
                                                dem -= 3;
                                            }
                                            dem--;
                                    }
                                }
                                dem++;
                                break;
                            case 5:
                                System.out.println("----------");
                                tkB.doiMatKhau();
                                break;
                        }
                    } while (t != 0);
                    break;
                case 2:
                    System.out.println("-----------");
                    case2();
                    break;
            }
        } while (ch != 0);
    }
    public static void case2() {
        System.out.println("Chào Mừng " + tkA.getTen());
        do {
            System.out.print("Nhập Mật Khẩu   : ");
            matKhauMoi = sc.nextLine();
            if (!tkA.matKhau.equals(matKhauMoi)) {
                System.out.println("Mật khẩu không đúng");
            }
        } while (!(tkA.matKhau.equals(matKhauMoi)));
        int oTP, otp;
        do {
            oTP = TaiKhoan.otp();
            System.out.println("Mã Xác Thực     : " + oTP);
            System.out.print("Nhập Mã Xác Thực: ");
            otp = sc.nextInt();
            if (otp == oTP) {
                System.out.println("Đăng Nhập Thành Công");
                System.out.println("-----------");
                System.out.println(tkA.toString());
            } else System.out.println("Nhập Sai Mã Otp. Nhập Lại");
        } while (otp != oTP);
        do {
            System.out.println("-----------");
            System.out.println("Mời Lựa Chọn Chức Năng:");
            System.out.println("0. Trở Lại 5");
            System.out.println("1. Gửi Tiền");
            System.out.println("2. Rút Tiền");
            System.out.println("3. Chuyển Khoản");
            if (count == 0) {
                System.out.println("4. Mở Sổ Tiết Kiệm ");
            }
            if (count == 2) {
                System.out.println("4. Kiểm Tra Sổ Tiết Kiệm ");
            }
            System.out.println("5. Đổi Mật Khẩu");
            System.out.print("Lựa chọn: ");
            n = sc.nextInt();
            switch (n) {
                case 0:
                    break;
                case 1:
                    System.out.println("----------");
                    System.out.print("Nhập Số Tiền Muốn Gửi: ");
                    double gui = sc.nextDouble();
                    tkA.guiTien(gui);
                    System.out.println("----------");
                    System.out.println(tkA.toString());
                    luuTK.replace(tka.getSoTaiKhoan(), tkA.soDu + gui);
                    break;
                case 2:
                    System.out.println("----------");
                    System.out.print("Nhập Số Tiền Cần Rút: ");
                    double rut = sc.nextDouble();
                    tkA.rutTien(rut);
                    luuTK.replace(tka.getSoTaiKhoan(), tkA.soDu - rut);
                    break;
                case 3:
                    sc.nextLine();
                    long stK;
                    double chuyenTien;
                    do {
                        System.out.print("Nhập số Tài Khoản Muốn chuyển(0. Để Trở Lại): ");
                        stK = sc.nextLong();
                        if (stK == 0) {
                            return;
                        }
                        if (!(luuTK.containsKey(stK))) {
                            System.out.println("Số Tài Khoản Không Tồn Tại Tề");
                        } else if (stK == tka.soTaiKhoan) {
                            System.out.println("Trùng số tài khoản với chính mình!");
                        }
                    } while (!(luuTK.containsKey(stK)) || (stK == tka.getSoTaiKhoan()));

                    do {
                        System.out.print("\nNhập số tiền muốn chuyển: ");
                        chuyenTien = sc.nextDouble();
                        if (tkA.soDu < chuyenTien) {
                            System.out.println("Không đủ tiền ấy ơi");
                        } else if (chuyenTien < 2000) {
                            System.out.println("Tiền ít quá không cho chuyển ấy ơi( phải >2000VNĐ)");
                        }
                    } while (tkA.soDu < chuyenTien || chuyenTien < 2000);
                    System.out.println("Xác Nhận");
                    System.out.println("Số tài khoản: " + stK + ": " + luuTen.get(stK) + "\nMuốn chuyển: " + df.format(chuyenTien) + "VNĐ");
                    oTP = TaiKhoan.otp();
                    System.out.println("Mã OTP: " + oTP);
                    System.out.print("Nhập mã OTP: ");
                    int OTP = sc.nextInt();
                    if (OTP == oTP) {
                        TKThanhToan.ChuyenKhoan(luuTK, stK, chuyenTien);
                        TKThanhToan.in(luuTK, stK, chuyenTien);
                        tkA.soDu = tkA.soDu - chuyenTien;
                        System.out.println(df.format(tkA.soDu) + "VNĐ");
                        tkB.soDu = luuTK.get(tkB.thongTin.getSoTaiKhoan());
                    } else
                        System.out.println("Mã OTP không chính xác. Giao dịch thất bại!");
                    break;
                case 4:
                    if (count == 0) {
                        double tien;
                        do {
                            System.out.println("----------");
                            System.out.println("Nhập Số Tiền Muốn Gửi Tiết Kiệm");
                            tien = sc.nextDouble();
                            if (tien > luuTK.get(tka.getSoTaiKhoan())) {
                                System.out.println("Không Đủ Tiền. Nhập Lại(0. Để Thoát)");
                            }
                            if (tien == 0)
                                return;
                        } while (tien > luuTK.get(tka.getSoTaiKhoan()));

                        if (tkaA.thoiHan(luuTietKiem, tka.getSoTaiKhoan(), tien) == 1) {
                            count++;
                        }
                        luuTietKiem.replace(tka.getSoTaiKhoan(), tkaA.soDuDu + tien);
                        tkaA.soDuDu = tkaA.soDuDu + tien;
                        luuTK.replace(tka.getSoTaiKhoan(), tkA.soDu - tien);
                        tkA.setSoDu(luuTK.get(tka.getSoTaiKhoan()));
                    }
                    if (count == 2) {
                        System.out.println("----------");
                        System.out.println("Sổ Tiết Kiệm ");
                        System.out.println("Tài Khoản: " + tka.getSoTaiKhoan());
                        System.out.println("Tên Tài Khoản: " + tkA.getTen());
                        System.out.println("Số Tiền Đã Gửi : " + df.format(luuTietKiem.get(tka.getSoTaiKhoan())) + " VNĐ");
                        System.out.println("Lãi Cuối Kỳ Hạn:   " + df.format(tkaA.tong) + " VNĐ");
                        System.out.println("----------");
                        System.out.println("0. Trở Lại");
                        System.out.println("1. Rút Tiền Trước Hạn");
                        System.out.print("Lựa Chọn: ");
                        e = sc.nextInt();
                        sc.nextLine();
                        switch (e) {
                            case 0:
                                count--;
                                break;
                            case 1:
                                System.out.println("Nhập Số Tiền Muốn Rút: ");
                                double rutt = sc.nextDouble();
                                tkaA.rutTien(rutt);
                                luuTietKiem.replace(tka.getSoTaiKhoan(), tkaA.soDuDu);
                                luuTK.replace(tka.getSoTaiKhoan(), tkA.soDu + rutt);
                                tkA.soDu = tkA.soDu + rutt;
                                if ((luuTietKiem.get(tka.getSoTaiKhoan())) == 0) {
                                    count -= 3;
                                }
                                count--;
                        }
                    }
                    count++;
                    break;
                case 5:
                    System.out.println("----------");
                    tkA.doiMatKhau();
                    break;
            }
        } while (n != 0);
    }
}



