package NganHangV2;

public class ThongTin {

    protected long soTaiKhoan;

    public ThongTin(long soTaiKhoan){
        this.soTaiKhoan=soTaiKhoan;
    }
    public long getSoTaiKhoan() {
        return soTaiKhoan;
    }
    @Override
    public String toString(){
        return String.valueOf(this.soTaiKhoan);
    }

}
