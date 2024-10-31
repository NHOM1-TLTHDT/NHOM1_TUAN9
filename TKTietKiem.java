package NganHangV2;




import java.text.DecimalFormat;
import java.time.LocalDate;


import java.util.HashMap;


public class TKTietKiem extends TaiKhoan {
     double soDuDu;
     double tong;
    DecimalFormat df = new DecimalFormat("#,###.##");
    public TKTietKiem(ThongTin soTaiKhoan) {
        super(soTaiKhoan);
    }

    @Override
    public void rutTien(double rut) {
        if(this.soDuDu>=rut){
            System.out.println("Rút Tiền Thành Công");
            System.out.println("Số Tiền Còn Lại Trong TKTiết Kiệm: "+df.format(this.soDuDu-rut)+" VNĐ");
            this.soDuDu=soDuDu-rut;
        }else System.out.println("Lỗi");
    }

    public double getSoDu() {
        return soDuDu;
    }

    public TKTietKiem setSoDu(double soDu) {
        this.soDuDu = soDu;
        return this;
    }

    public int thoiHan(HashMap<Long, Double>luuTietKiem, Long soTaiKhoan, double guiTK ) {
        LocalDate toDay = LocalDate.now();

        System.out.println("Ngày Hiện Tại");
        System.out.println(toDay);
        double[] laiXuat = {0.02, 0.02, 0.023, 0.026, 0.028, 0.03, 0.033, 0.038, 0.04, 0.043, 0.044, 0.045, 0.047, 0.05, 0.055, 0.059};
        int [] thang ={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 , 18, 24, 36, 48};
        System.out.println("Chọn Kỳ Hạn Muốn Gửi");
        System.out.println("1. 1 Tháng(2%)\t  2. 2 Tháng(2%)\t3. 3 Tháng(2.3%)\t4. 4 Tháng(2.6%)");
        System.out.println("5. 5 Tháng(2.8%)  6. 6 Tháng(3%)    7. 7 Tháng(3.3%)    8. 8 Tháng(3.8%)");
        System.out.println("9. 9 Tháng(4%)\t    10. 10 Tháng(4.3%)  11. 11 Tháng(4.4%)\t12. 12 Tháng(4.5%)");
        System.out.println("13. 18 Tháng(4.7%)  14. 24 Tháng(5%)    15. 36 Tháng(5.5%)  16. 48 Tháng(5.9%)");
        System.out.print("Lựa Chọn Kỳ Hạn: ");
        int chon = sc.nextInt();
        sc.nextLine();
        double laiXuatThang=laiXuat[chon-1];
        double thangGui=thang[chon-1];
        this.tong=guiTK*laiXuatThang*(thangGui/12);
        System.out.println("Lãi Nhận Được: "+df.format(this.tong)+" VNĐ");
        System.out.println("Xác Nhận Gửi");
        int otp=TaiKhoan.otp();
        System.out.println("Mã Xác Thực: "+otp);
        System.out.print("Nhập Mã    : ");
        int OTP=sc.nextInt();
        if(otp==OTP){
            System.out.println("Gửi Thành Công");
            luuTietKiem.replace(soTaiKhoan,this.soDuDu +guiTK);
            return 1;

        }else {
            System.out.println("Thất Bại");
            return 0;
        }


    }


}
