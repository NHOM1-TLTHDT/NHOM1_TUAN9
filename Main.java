package Bai_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaiKhoanNganHang taiKhoanChinh = new TaiKhoanChinh("1234567890", "NGUYEN VAN A", 50000, "123456");
        TaiKhoanTietKiem tietKiem = new TaiKhoanTietKiem("1111111111", "NGUYEN VAN A", 0, "abcdef");
        TaiKhoanThanhToan thanhToan = new TaiKhoanThanhToan("0987654321", "NGUYEN VAN A", 0, "ghijkl", 1000);

        int luaChon = 0;
        do {
            System.out.print("Nhap mat khau de tiep tuc: ");
            String matKhauNhap = scanner.nextLine();
            if (!taiKhoanChinh.kiemTraMatKhau(matKhauNhap)) {
                System.out.println("Mat khau khong dung! Vui long nhap lai.");
                continue;
            }

            // Hiển thị menu
            System.out.println("-----");
            System.out.println("Ban Muon Lua Chon Nao:");
            System.out.println("1. Rut Tien ");
            System.out.println("2. Gui Tien ");
            System.out.println("3. Doi Mat Khau ");
            System.out.println("4. Rut Tien Tai Khoan Tiet Kiem");
            System.out.println("5. Gui Tien Tai Khoan Tiet Kiem");
            System.out.println("6. Rut Tien Tai Khoan Thanh Toan");
            System.out.println("7. Gui Tien Tai Khoan Thanh Toan");
            System.out.println("8. Kiem tra so du ");
            System.out.println("9. Thoat");
            System.out.print("Lua chon thu: ");
            luaChon = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng còn lại

            switch (luaChon) {
                case 1:
                    System.out.print("Nhap so tien can rut: ");
                    double rutChinh = scanner.nextDouble();
                    taiKhoanChinh.rutTien(rutChinh);
                    break;
                case 2:
                    System.out.print("Nhap so tien can gui: ");
                    double guiChinh = scanner.nextDouble();
                    taiKhoanChinh.guiTien(guiChinh);
                    break;
                case 3:
                    System.out.print("Nhap Mat Khau Cu: ");
                    String matKhauCu = scanner.nextLine();
                    System.out.print("Nhap Mat Khau Moi: ");
                    String matKhauMoi = scanner.nextLine();
                    taiKhoanChinh.doiMatKhau(matKhauCu, matKhauMoi);
                    break;
                case 4:
                    System.out.print("Nhap so tien can rut tu tai khoan tiet kiem: ");
                    double rutTietKiem = scanner.nextDouble();
                    tietKiem.rutTien(rutTietKiem);
                    break;
                case 5:
                    System.out.print("Nhap so tien can gui vao tai khoan tiet kiem: ");
                    double soTienGuiTietKiem = scanner.nextDouble();
                    tietKiem.guiTienTietKiem(soTienGuiTietKiem);
                    break;
                case 6:
                    System.out.print("Nhap so tien can rut tu tai khoan thanh toan: ");
                    double rutThanhToan = scanner.nextDouble();
                    thanhToan.rutTien(rutThanhToan);
                    break;
                case 7:
                    System.out.print("Nhap so tien can gui vao tai khoan thanh toan: ");
                    double soTienGuiThanhToan = scanner.nextDouble();
                    thanhToan.guiTien(soTienGuiThanhToan);
                    break;
                case 8:
                    System.out.println("So du hien tai cua ban la: " + taiKhoanChinh.getSoDu() + " VNĐ");
                    break;
                case 9:
                    System.out.println("Cam On Da Su Dung Dich Vu");
                    break;
                default:
                    System.out.println("Lua Chon Khong Hop Le. Vui Long Chon Lai!");
                    break;
            }
        } while (luaChon != 9);

        scanner.close();
    }
}
