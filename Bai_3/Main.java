package Bai_3;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tạo tài khoản thanh toán
        TaiKhoanThanhToan thanhToan = new TaiKhoanThanhToan("1234567890", "NGUYEN VAN A", 50000, "123456", 0) {
            @Override
            public void rutTien() {

            }
        };

        // Tạo tài khoản tiết kiệm
        TaiKhoanTietKiem tietKiem = new TaiKhoanTietKiem("1234567891", "NGUYEN VAN A", 0, "123456", 0, 0) {
            @Override
            public void rutTien() {

            }

            @Override
            public void rutTien(double rut) {

            }
        };

        DecimalFormat decimalFormat = new DecimalFormat("#,###.##");

        System.out.println("Tài Khoản Ngân Hàng Tạo Cho Bạn Là:");
        System.out.println(thanhToan);
        System.out.println("------");

        // Đổi tên tài khoản và mật khẩu
        System.out.print("Nhập Tên Tài Khoản Của Bạn: ");
        String n = scanner.nextLine();
        thanhToan.setChuTaiKhoa(n);

        System.out.print("Nhập Mật Khẩu Mới Của Bạn: ");
        String m = scanner.nextLine();
        thanhToan.doiMatKhau(m);

        System.out.println("-----");
        System.out.println(thanhToan.toStringFULL());

        int luaChon;
        do {
            System.out.println("-----");
            System.out.println("Bạn Muốn Lựa Chọn Nào:");
            System.out.println("1. Rút Tiền");
            System.out.println("2. Gửi Tiền");
            System.out.println("3. Đổi Mật Khẩu");
            System.out.println("4. Tài Khoản Thanh Toán");
            System.out.println("5. Tài Khoản Tiết Kiệm");
            System.out.println("6. Kiểm Tra Số Dư");
            System.out.println("7. Thoát");
            System.out.print("Lựa Chọn Thứ: ");
            luaChon = scanner.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.println("Chọn loại tài khoản để rút tiền:");
                    System.out.println("1. Tài khoản thanh toán");
                    System.out.println("2. Tài khoản tiết kiệm");
                    int loaiRut = scanner.nextInt();
                    if (loaiRut == 1) {
                        System.out.print("Nhập số tiền cần rút: ");
                        double rut = scanner.nextDouble();
                        thanhToan.rutTien(rut);
                    } else if (loaiRut == 2) {
                        System.out.print("Nhập số tiền cần rút: ");
                        double rut = scanner.nextDouble();
                        tietKiem.rutTien();
                    } else {
                        System.out.println("Lựa chọn không hợp lệ.");
                    }
                    break;

                case 2:
                    System.out.println("Chọn loại tài khoản để gửi tiền:");
                    System.out.println("1. Tài khoản thanh toán");
                    System.out.println("2. Tài khoản tiết kiệm");
                    int loaiGui = scanner.nextInt();
                    if (loaiGui == 1) {
                        System.out.print("Nhập số tiền cần gửi: ");
                        double gui = scanner.nextDouble();
                        thanhToan.guiTien(gui);
                    } else if (loaiGui == 2) {
                        System.out.print("Nhập số tiền cần gửi: ");
                        double gui = scanner.nextDouble();
                        tietKiem.guiTienTietKiem(gui);
                        System.out.println("Số tiền còn lại trong tài khoản tiết kiệm là: " + decimalFormat.format(tietKiem.soDu) + " VNĐ");
                    } else {
                        System.out.println("Lựa chọn không hợp lệ.");
                    }
                    break;

                case 3:
                    scanner.nextLine(); // Đọc bỏ dòng mới sau khi nhập số
                    System.out.print("Nhập Mật Khẩu Mới Của Bạn: ");
                    String dmkm = scanner.nextLine();
                    thanhToan.doiMatKhau(dmkm);
                    System.out.println("Mật Khẩu Mới Của Bạn Là: " + thanhToan.getMatKhau());
                    break;

                case 4:
                    thanhToan.nhapPhiDichVuHangThang();
                    thanhToan.truPhiDichVu();
                    break;

                case 5:

                        tietKiem.nhapLaiSuat();
                        tietKiem.tinhLaiSuat();
                        tietKiem.inLaiSuat();

                    break;

                case 6:
                    System.out.println("Bạn muốn kiểm tra số dư của loại tài khoản nào?");
                    System.out.println("1. Tài khoản thanh toán");
                    System.out.println("2. Tài khoản tiết kiệm");
                    System.out.println("3. Cả hai tài khoản");
                    System.out.print("Lựa chọn của bạn: ");
                    int luaChonSoDu = scanner.nextInt();

                    switch (luaChonSoDu) {
                        case 1:
                            double soDuThucTe = thanhToan.soDu - thanhToan.getDebt(); // Tính số dư thực tế
                            System.out.println("Số dư tài khoản thanh toán: " + decimalFormat.format(soDuThucTe) + " VNĐ");
                            System.out.println("Số nợ hiện tại: - " + decimalFormat.format(thanhToan.getDebt()) + " VNĐ");
                            break;
                        case 2:
                            System.out.println("Số dư tài khoản tiết kiệm: " + decimalFormat.format(tietKiem.soDu) + " VNĐ");
                            break;
                        case 3:
                            System.out.println("Số dư hiện tại của bạn là:");
                            System.out.println("Tài khoản thanh toán: " + decimalFormat.format(thanhToan.soDu) + " VNĐ");
                            System.out.println("Số nợ hiện tại: - " + decimalFormat.format(thanhToan.getDebt()) + " VNĐ");
                            System.out.println("Tài khoản tiết kiệm: " + decimalFormat.format(tietKiem.soDu) + " VNĐ");
                            break;
                        default:
                            System.out.println("Lựa chọn không hợp lệ.");
                            break;
                    }
                    break;


                case 7:
                    System.out.println("Cảm ơn đã sử dụng dịch vụ!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại!");
                    break;
            }
        } while (luaChon != 7);
        scanner.close();
    }
}
