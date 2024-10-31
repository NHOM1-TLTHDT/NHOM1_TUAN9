package NganHangV2;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.security.SecureRandom;

public abstract class TaiKhoan {
    static DecimalFormat df = new DecimalFormat("#,###.##");
    static Scanner sc = new Scanner(System.in);

    protected ThongTin thongTin;
    protected int maPin;
    protected double soDu;
    protected String ten, matKhau;

    public TaiKhoan(ThongTin soTaiKhoan) {
        this.thongTin = soTaiKhoan;
    }

    public String getTen() {
        return ten;
    }

    public TaiKhoan setTen(String ten) {
        this.ten = ten;
        return this;
    }

    public int getMaPin() {
        return maPin;
    }

    public TaiKhoan setMaPin(int maPin) {
        this.maPin = maPin;
        return this;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public double getSoDu() {
        return soDu;
    }

    public TaiKhoan setSoDu(double soDu) {
        this.soDu = soDu;
        return this;
    }

    public TaiKhoan setMatKhau(String matKhau) {
        this.matKhau = matKhau;
        return this;
    }

    public double guiTien(double tienMuonGui, double toiThieu) {
        if (tienMuonGui < toiThieu)
            return 0;
        else
            return soDu += tienMuonGui;
    }

    public static long taoSostk() {
        SecureRandom random = new SecureRandom();
        long value = random.nextLong(9000000000L) + 1000000000;
        return value;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || this.getClass() != obj.getClass()) return false;
        TaiKhoan other = (TaiKhoan) obj;
        if (other.matKhau == null) return false;
        return this.matKhau.equals(other.matKhau);
    }

    @Override
    public String toString() {
        return "Tài Khoản: " + this.getTen() + "\nSố Tài Khoản : " + thongTin + "\nTên Tài Khoản: " + this.ten + "\nSố Dư        : " + df.format(this.soDu) + " VNĐ\nMật Khẩu     : " + this.matKhau;
    }

    public static int otp() {
        SecureRandom random = new SecureRandom();
        int value = random.nextInt(900000) + 100000;
        return value;
    }

    public void guiTien(double gui) {
        if (gui > 1000) {
            System.out.print("Giao Dich Thanh Cong\nSo Du Cua Ban La: " + df.format(this.soDu += gui) + " VNĐ\n");
        } else {
            System.out.print("Giao Dich Khong Thanh Cong\nSo Tien Gui Khong Hop Le!(So Tien Gui Phai Lon Hon 1.000 VNĐ)\nSo Du Cua Ban La: " + df.format(this.soDu) + " VNĐ\n");
        }
    }

    public void doiMatKhau() {
        String mkm, mkmm;
        System.out.print("Nhập Mật Khẩu Hiện Tại: ");
        String mk = sc.nextLine();
        if (this.matKhau.equals(mk)) {
            do {
                System.out.print("Nhập Mật Khẩu Mới: ");
                mkm = sc.nextLine();
                System.out.print("Nhập Lại Mật Khẩu Mới: ");
                mkmm = sc.nextLine();
                try {
                    if (mkm.equals(mkmm)) {
                        System.out.println("Đổi Mật Khẩu Thành Công");
                        this.matKhau = mkm;
                        break;
                    } else
                        System.out.println("Đổi Mật Khẩu Không Thành Công!\nVui Lòng Nhập Lại");

                } catch (Exception e) {
                    System.out.println("Lỗi Tạo Mật Khẩu");
                }
            } while (!(this.matKhau.equals(mk)) || !(mkm.equals(mkmm)));
        }

    }
    public abstract void rutTien(double rut);

}


