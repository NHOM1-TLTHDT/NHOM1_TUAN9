package Bai_3;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

public abstract class TaiKhoan {
    DecimalFormat df = new DecimalFormat("#,###.##");
    Scanner scanner = new Scanner(System.in);
    protected String soTaiKhoan;
    protected String chuTaiKhoan;
    protected double soDu;
    private String matKhau;
    private String otp;

    public TaiKhoan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) {
        if (soTaiKhoan.length() >= 10) {
            this.soTaiKhoan = soTaiKhoan;
        } else {
            System.out.println("Loi! So Tai Khoan Phai Lon Hon Hoac bang 10");
        }

        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.matKhau = matKhau;
    }

    public TaiKhoan() {}

    public String getSoTaiKhoan() {
        return this.soTaiKhoan;
    }

    public String getChuTaiKhoan() {
        return this.chuTaiKhoan;
    }

    public void setChuTaiKhoa(String chuTaiKhoan) {
        this.chuTaiKhoan = chuTaiKhoan;
    }

    public String getSoDu() {
        return df.format(this.soDu);
    }

    public String getMatKhau() {
        return this.matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        TaiKhoan other = (TaiKhoan) obj;
        return this.matKhau.equals(other.matKhau);
    }

    public void doiMatKhau(String mkm) {
        String mkc;
        do {
            System.out.print("Nhap mat khau cu: ");
            mkc = scanner.nextLine();
            if (this.matKhau.equals(mkc)) {
                System.out.println("Doi Mat Khau Thanh Cong");
                this.matKhau = mkm;
                break;
            } else {
                System.out.println("Doi Mat Khau Khong Thanh Cong!\nVui Long Nhap Lai");
            }
        } while (!this.matKhau.equals(mkc));
    }

    // Make guiTien abstract
    public abstract void guiTien(double gui);

    // Make rutTien abstract
    public abstract void rutTien();

    @Override
    public String toString() {
        return "Ten Tai Khoan Ngan Hang Cap: " + this.chuTaiKhoan + "\nSo Tai Khoan: " + this.soTaiKhoan + "\nSo Du Tai Khoan: " + df.format(this.soDu) + "VNĐ" + "\nMat Khau Ngan Hang Cap: " + this.matKhau;
    }

    public String toStringFULL() {
        return "Ten Tai Khoan Cua Ban: " + this.chuTaiKhoan + "\nSo Tai Khoan: " + this.soTaiKhoan + "\nSo Du Tai Khoan: " + df.format(this.soDu) + "VNĐ" + "\nMat Khau Cua Ban La: " + this.matKhau;
    }

    public abstract void rutTien(double rut);
    public void generateAndSendOtp() {
        Random random = new Random();
        this.otp = String.format("%06d", random.nextInt(1000000)); // Tạo mã OTP 6 chữ số
        System.out.println("Mã OTP của bạn là: " + this.otp); // Trong ứng dụng thực tế, gửi qua SMS hoặc email
    }

    // Phương thức xác thực OTP
    public boolean verifyOtp(String inputOtp) {
        return this.otp.equals(inputOtp);
    }
}
