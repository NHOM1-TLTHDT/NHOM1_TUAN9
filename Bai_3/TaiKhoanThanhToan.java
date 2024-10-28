package Bai_3;

import java.util.Scanner;

public abstract class TaiKhoanThanhToan extends TaiKhoan {
    public double phiDichVuHangThang;
    private double debt; // Biến để theo dõi nợ

    public TaiKhoanThanhToan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, double phiDichVuHangThang) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
        this.phiDichVuHangThang = phiDichVuHangThang;
        this.debt = 0; // Khởi tạo nợ bằng 0
    }

    public TaiKhoanThanhToan() {
        super();
        this.debt = 0; // Khởi tạo nợ bằng 0
    }

    @Override
    public void guiTien(double gui) {
        generateAndSendOtp(); // Gửi mã OTP trước khi gửi tiền
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã OTP: ");
        String inputOtp = scanner.nextLine();

        if (verifyOtp(inputOtp)) {
            if (gui >= 10000) {
                // Nếu có nợ, trừ nợ trước
                if (debt > 0) {
                    if (gui >= debt) {
                        gui -= debt; // Trừ nợ
                        this.soDu += gui; // Cộng số tiền còn lại vào số dư
                        System.out.println("Giao dịch gửi tiền thành công. Đã trừ nợ: " + debt + " VNĐ.");
                        debt = 0; // Đặt nợ về 0
                    } else {
                        debt -= gui; // Giảm nợ nếu số tiền gửi không đủ
                        System.out.println("Giao dịch gửi tiền thành công. Đã trừ nợ: " + gui + " VNĐ. Bạn vẫn còn nợ: - " + debt + " VNĐ.");
                        return; // Kết thúc nếu chỉ trừ nợ
                    }
                } else {
                    this.soDu += gui; // Nếu không có nợ, cộng trực tiếp vào số dư
                    System.out.println("Giao dịch gửi tiền thành công. Số dư hiện tại: " + getSoDu() + " VNĐ");
                }
            } else {
                System.out.println("Giao dịch không thành công. Số tiền gửi phải lớn hơn 10.000 VNĐ.");
            }
        } else {
            System.out.println("Mã OTP không hợp lệ! Giao dịch không thành công.");
        }
    }

    @Override
    public void rutTien(double rut) {
        generateAndSendOtp(); // Gửi mã OTP trước khi rút tiền
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã OTP: ");
        String inputOtp = scanner.nextLine();

        if (verifyOtp(inputOtp)) {
            if (rut > 0) {
                // Kiểm tra xem số nợ có vượt quá 10 triệu hay không
                if (debt + rut > 10000000) {
                    System.out.println("Không thể rút tiền. Tổng số nợ không được vượt quá 10 triệu VNĐ.");
                    return; // Kết thúc nếu điều kiện không thỏa mãn
                }

                this.soDu -= rut; // Trừ tiền từ số dư
                if (this.soDu < 0) {
                    debt += Math.abs(this.soDu); // Cộng dồn nợ
                    System.out.println("Giao dịch rút tiền thành công. Bạn đang nợ: - " + debt + " VNĐ");
                    this.soDu = 0; // Đặt số dư về 0
                } else {
                    System.out.println("Giao dịch rút tiền thành công. Số dư hiện tại: " + getSoDu() + " VNĐ");
                }
            } else {
                System.out.println("Số tiền rút không hợp lệ.");
            }

            // Hiển thị số dư sau khi đã trừ nợ
            double soDuThucTe = this.soDu - debt; // Tính toán số dư thực tế
            System.out.println("Số dư sau khi đã trừ nợ: " + soDuThucTe + " VNĐ");
        } else {
            System.out.println("Mã OTP không hợp lệ! Giao dịch không thành công.");
        }
    }

    public void nhapPhiDichVuHangThang() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập phí dịch vụ hàng tháng: ");
        this.phiDichVuHangThang = scanner.nextDouble();
    }

    public void truPhiDichVu() {
        if (this.soDu >= phiDichVuHangThang) {
            this.soDu -= phiDichVuHangThang;
            System.out.println("Đã trừ phí dịch vụ hàng tháng: " + phiDichVuHangThang + " VNĐ");
            System.out.println("Số dư hiện tại: " + getSoDu() + " VNĐ");
        } else {
            System.out.println("Số tiền trong tài khoản không đủ để trừ phí dịch vụ.");
        }
    }

    public double getDebt() {
        return debt; // Phương thức để lấy số nợ
    }
}
