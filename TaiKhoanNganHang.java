package Bai_3;

import java.text.DecimalFormat;
import java.util.Scanner;

public abstract class TaiKhoanNganHang {
    DecimalFormat df = new DecimalFormat("#,###.##");
    Scanner scanner = new Scanner(System.in);
    protected String soTaiKhoan;
    protected String chuTaiKhoan;
    protected double soDu;
    private String matKhau;

    public TaiKhoanNganHang(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) {
        this.soTaiKhoan = soTaiKhoan;
        this.chuTaiKhoan = chuTaiKhoan;
        this.soDu = soDu;
        this.matKhau = matKhau;
    }

    public abstract void rutTien(double soTien);

    public void guiTien(double soTien) {
        if (soTien > 10000) {
            soDu += soTien;
            System.out.println("Giao Dich Thanh Cong! So Du Moi La: " + df.format(soDu) + " VNĐ");
        } else {
            System.out.println("So Tien Gui Phai Lon Hon 10.000 VNĐ!");
        }
    }

    public String getSoDu() {
        return df.format(soDu);
    }

    // Xóa phương thức getter cho matKhau

    public boolean kiemTraMatKhau(String matKhauCu) {  // Phương thức để kiểm tra mật khẩu
        return this.matKhau.equals(matKhauCu);
    }

    public void doiMatKhau(String matKhauCu, String matKhauMoi) {
        if (kiemTraMatKhau(matKhauCu)) {
            this.matKhau = matKhauMoi;
            System.out.println("Doi mat khau thanh cong!");
        } else {
            System.out.println("Mat khau cu khong dung!");
        }
    }
}




