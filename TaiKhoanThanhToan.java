package Bai_3;

public class TaiKhoanThanhToan extends TaiKhoanNganHang {
    private double phiDichVu;

    public TaiKhoanThanhToan(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau, double phiDichVu) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
        this.phiDichVu = phiDichVu;
    }

    @Override
    public void rutTien(double soTien) {
        if (soTien <= soDu) {
            soDu -= soTien;
            System.out.println("Rut Tien Thanh Cong Tu Tai Khoan Thanh Toan. So Du Con Lai: " + df.format(soDu) + " VNĐ");
        } else {
            System.out.println("Khong Du So Du De Rut Tien Tu Tai Khoan Thanh Toan!");
        }
    }

    // Thêm phương thức gửi tiền vào tài khoản thanh toán
    @Override
    public void guiTien(double soTien) {
        if (soTien > 0) {
            soDu += soTien;
            System.out.println("Giao Dich Gui Tien Thanh Cong. So Du Moi La: " + df.format(soDu) + " VNĐ");
        } else {
            System.out.println("So Tien Gui Phai Lon Hon 0 VNĐ!");
        }
    }

    public void nhapPhiDichVuHangThang() {
    }

    public void truPhiDichVu() {
        if (soDu >= phiDichVu) {
            soDu -= phiDichVu;
            System.out.println("Phi dich vu da duoc tru. So Du Con Lai: " + df.format(soDu) + " VNĐ");
        } else {
            System.out.println("Khong du so du de tru phi dich vu!");
        }
    }
}

