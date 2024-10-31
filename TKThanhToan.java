package  NganHangV2;

import java.util.HashMap;

public class TKThanhToan extends TaiKhoan {


    public TKThanhToan(ThongTin soTaiKhoan){
        super(soTaiKhoan);
    }

    public static double kiemTra(HashMap<Long, Double> luuTK, long soTaiKhoan, double tienCK) {
        if (luuTK.containsKey(soTaiKhoan)) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void ChuyenKhoan(HashMap<Long, Double> luuTK, long soTaiKhoan, double tienCK) {
        if ((kiemTra(luuTK, soTaiKhoan, tienCK)) == 1) {
            luuTK.replace(soTaiKhoan, luuTK.get(soTaiKhoan) + tienCK); // Thêm tiền vào tài khoản
        }
    }

    public static void in(HashMap<Long, Double> luuTK, long soTaiKhoan, double tienCK) {
        if ((TKThanhToan.kiemTra(luuTK, soTaiKhoan, tienCK)) == 1) {
            System.out.print("Chuyển khoản thành công, số dư của bạn là: ");
        } else System.out.println("Số tài khoản không tồn tại.");
    }


   @Override
    public void rutTien(double rut) {
        if ((soDu-rut>=-10000000) && rut >= 10000) {
            System.out.println("Rút Tiền Thành Công");
            System.out.println("Số Dư Còn Lại Là: " + df.format(this.soDu -= rut) + "VNĐ\n");
        } else {
            System.out.println("Rút Tiền Không Thành Công");
            System.out.println("Rút Âm Tối Đa -10.000.000 VNĐ");
        }
    }
}
