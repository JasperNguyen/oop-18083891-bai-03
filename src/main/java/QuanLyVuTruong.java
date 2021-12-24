


import core.Input;
import entities.NguoiKhieuVu;

import java.util.LinkedList;
import java.util.Queue;

public class QuanLyVuTruong extends Input{
    public QuanLyVuTruong(){
        this._danhSachThanhVien = new LinkedList<>();
    }

    public String nextEGioiTinh(String mess){
        String tmp;
        while(true){
            tmp = super.nextString(mess);

            if(tmp.equals(NguoiKhieuVu.NAM) || tmp.equals(NguoiKhieuVu.NU)){
                return tmp;
            }
        }
    }

    public Boolean add(NguoiKhieuVu nguoiKhieuVu){
        return this._danhSachThanhVien.add(nguoiKhieuVu);
    }

    public Boolean add(){
        NguoiKhieuVu nguoiKhieuVu = new NguoiKhieuVu();
        nguoiKhieuVu.setTen(super.nextString("Ten: "));
        nguoiKhieuVu.setGioTinh(this.nextEGioiTinh("Gioi tinh (nam, nu): "));
        return this._danhSachThanhVien.add(nguoiKhieuVu);
    }



    public void chiaCapKhieuVu(){
        Queue<NguoiKhieuVu> hangDoiNam = new LinkedList<>();
        Queue<NguoiKhieuVu> hangDoiNu = new LinkedList<>();

        // Phân chia những người đang đợi thành hai nhóm
        for(NguoiKhieuVu nguoiKhieuVu: _danhSachThanhVien){
            switch (nguoiKhieuVu.getGioTinh()) {
                case NguoiKhieuVu.NAM -> {
                    hangDoiNam.add(nguoiKhieuVu);
                    break;
                }
                case NguoiKhieuVu.NU -> {
                    hangDoiNu.add(nguoiKhieuVu);
                }
            }
        }

        // In danh sách các cặp
        System.out.println("- Danh sanh nhung nguoi da co cap");
        Integer count = 0;
        while(true){
            if(hangDoiNam.isEmpty() || hangDoiNu.isEmpty()) break;
            count += 1;

            System.out.println(
                String.format(
                    "    + Cap doi[%s] la anh %s va chi %s",
                    count,
                    hangDoiNam.poll().getTen(),
                    hangDoiNu.poll().getTen())
            );
        }

        System.out.println("- Danh sanh nhung nguoi chua co cap");
        while(!hangDoiNam.isEmpty()){
            System.out.println("    + " + hangDoiNam.poll());
        }

        while(!hangDoiNu.isEmpty()){
            System.out.println("    + " + hangDoiNu.poll());
        }
    }



    public void inDanhSachNguoiDaThamGia(){
        if(this._danhSachThanhVien.isEmpty()){
            System.out.println("[OUT] Khong co nguoi nao trong danh sach");
        }
        for(NguoiKhieuVu nguoiKhieuVu: this._danhSachThanhVien){
            System.out.println(nguoiKhieuVu);
        }
    }

    private final Queue<NguoiKhieuVu> _danhSachThanhVien;
}
