package Bai_3;

public class TaiKhoanTietKiem extends TaiKhoanNganHang {
    public TaiKhoanTietKiem(String soTaiKhoan, String chuTaiKhoan, double soDu, String matKhau) {
        super(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
    }

    @Override
    public void rutTien(double soTien) {
        if (soTien <= soDu) {
            soDu -= soTien;
            System.out.println("Rut Tien Thanh Cong Tu Tai Khoan Tiet Kiem. So Du Con Lai: " + df.format(soDu) + " VNĐ");
        } else {
            System.out.println("Khong Du So Du De Rut Tien Tu Tai Khoan Tiet Kiem!");
        }
    }

    public void guiTienTietKiem(double soTien) {
        guiTien(soTien);
    }
}
