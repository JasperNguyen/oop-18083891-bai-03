import java.util.Random;

import core.Input;
import entities.NguoiKhieuVu;

public class Test extends Input{
    public Test(){
        this._random = new Random();
        this._quanLyVuTruong = new QuanLyVuTruong();
    }

    public void runTest(){
        while(true){
            switch(this.getOption()){
                // Random danh sach
                case 0 -> {
                    randomDanhSachNguoiThamGia(
                        super.nextInteger("Nhap so nguoi tham gia: ")
                    );
                    break;
                }

                // In danh sach nhung nguoi tham gia
                case 1 ->{
                    this._quanLyVuTruong.inDanhSachNguoiDaThamGia();
                    break;
                }

                // Chia cap khieu vu
                case 2 -> {
                    this._quanLyVuTruong.chiaCapKhieuVu();
                    break;
                }

                // Them nguoi vao vu truong tu ban phim
                case 3 ->{
                    this._quanLyVuTruong.add();
                    break;
                }

                // Thoat
                case 4 -> {
                    return;
                }

            }
            super.nextString("=>>>> Nhan enter de tiep tuc !");
            System.out.println("");
        }
    }


    private Integer getOption(){
        for(Integer i = 0; i < this._OPTION.length; i++){
            System.out.println(String.format("[%s]: %s", i, this._OPTION[i]));
        }

        Integer tmp;
        while (true) {
            tmp = super.nextInteger("=> Lua chon: ");
            if(tmp>= 0 && tmp < this._OPTION.length){
                return tmp;
            }
        }
    }


    private void randomDanhSachNguoiThamGia(Integer soNguoiThamGia){
        for(int i= 0; i < soNguoiThamGia; i++){
            NguoiKhieuVu nguoiKhieuVu = new NguoiKhieuVu();
            if(this._random.nextInt(10)%2 == 0){
                nguoiKhieuVu.setTen(this.randomNameForBoy());
                nguoiKhieuVu.setGioTinh(NguoiKhieuVu.NAM);
            }
            else{
                nguoiKhieuVu.setTen(this.randomNameForGirl());
                nguoiKhieuVu.setGioTinh(NguoiKhieuVu.NU);
            }
            this._quanLyVuTruong.add(nguoiKhieuVu);
        }
    }


    private String randomNameForGirl(){
        String lastName = this._LAST_NAME[this._random.nextInt(this._LAST_NAME.length)];
        String firstName = this._FIRST_NAME_FOR_GIRL[this._random.nextInt(this._FIRST_NAME_FOR_GIRL.length)];
        return lastName + " " + firstName;
    }

    private String randomNameForBoy(){
        String lastName = this._LAST_NAME[this._random.nextInt(this._LAST_NAME.length)];
        String firstName = this._FIRST_NAME_FOR_BOY[this._random.nextInt(this._FIRST_NAME_FOR_BOY.length)];
        return lastName + " " + firstName;
    }

    private QuanLyVuTruong _quanLyVuTruong;
    private final Random _random;

    private final String[] _LAST_NAME = {
        "Nguyen", "Tran", "Le", "Ly", "Ngo",
        "Pham", "Phan", "Dang"
    };

    
    private final String[] _FIRST_NAME_FOR_GIRL = {
        "Minh Anh", "Nguyet Anh", "Kim Chi", "My Duyen", "My Dung", "Anh Duong",
        "Tuyet Nhung", "Nha Phuong", "Cat Tien", "Anh Thu",
    };
    private final String[] _FIRST_NAME_FOR_BOY = { "Hoang Son", "Son Dang",
        "Van Vinh", "Hai Minh", "The Vy", "Khac Tu", "Tuan Tu", "Ba Thong", "Huu Thanh",
    };

    private final String[] _OPTION = {
        "Random danh sach",
        "In danh sach nhung nguoi tham gia",
        "Chia cap khieu vu",
        "Them nguoi vao vu truong tu ban phim",
        "Thoat"
    };
}
