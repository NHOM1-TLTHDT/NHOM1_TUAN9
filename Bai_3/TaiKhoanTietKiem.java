package Bai_3;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public abstract class TaiKhoanTietKiem extends TaiKhoan {
    private double laiSuat;
    private int kyHan;
    private double tienLai;
    private String otp; // Biến để lưu mã OTP

    public TaiKhoanTietKiem(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, double laiSuat, int kyHan) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
        this.laiSuat = laiSuat;
        this.kyHan = kyHan;
    }

    public TaiKhoanTietKiem() {
        super();
    }

    @Override
    public void guiTien(double soTienGui) {
        generateAndSendOtp(); // Gửi mã OTP trước khi gửi tiền
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mã OTP: ");
        String inputOtp = scanner.nextLine();

        if (verifyOtp(inputOtp)) {
            if (soTienGui > 0) {
                this.soDu += soTienGui;
                System.out.println("Giao dịch gửi tiền thành công. Số dư mới là: " + new DecimalFormat("#,###.##").format(this.soDu) + " VNĐ");
            } else {
                System.out.println("Số tiền gửi không hợp lệ. Vui lòng nhập lại.");
            }
        } else {
            System.out.println("Mã OTP không hợp lệ! Giao dịch không thành công.");
        }
    }

    @Override
    public abstract void rutTien(); // Biến thành phương thức trừu tượng

    public void nhapLaiSuat() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập lãi suất (%): ");
        this.laiSuat = scanner.nextDouble();
        System.out.print("Nhập kỳ hạn (tháng): ");
        this.kyHan = scanner.nextInt();
    }

    public void tinhLaiSuat() {
        this.tienLai = this.soDu * (this.laiSuat / 100) * (this.kyHan / 12.0);
    }

    public void inLaiSuat() {
        DecimalFormat df = new DecimalFormat("#,###.##");
        System.out.println("Tiền lãi suất của bạn là: " + df.format(this.tienLai) + " VNĐ");
    }

    public void guiTienTietKiem(double soTienGui) {
        guiTien(soTienGui); // Gọi phương thức guiTien đã được định nghĩa
    }

    // Phương thức để sinh và gửi mã OTP
    public void generateAndSendOtp() {
        Random random = new Random();
        this.otp = String.format("%06d", random.nextInt(1000000)); // Tạo mã OTP 6 chữ số
        System.out.println("Mã OTP của bạn là: " + this.otp); // Trong thực tế, gửi qua SMS hoặc email
    }

    // Phương thức để xác thực mã OTP
    public boolean verifyOtp(String inputOtp) {
        return this.otp.equals(inputOtp);
    }
}
