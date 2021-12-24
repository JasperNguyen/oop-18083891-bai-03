package entities;

public class NguoiKhieuVu {

    public static final String NAM = "nam";
    public static final String NU = "nu";

    public NguoiKhieuVu(String _ten, String _gioTinh) {
        this._ten = _ten;
        this._gioTinh = _gioTinh;
    }

    public NguoiKhieuVu() {
        this._ten = "";
        this._gioTinh = "";
    }
    
    @Override
    public String toString() {        
        return String.format("Ten: %s, GioiTinh: %s", this._ten, this._gioTinh);
    }
    
    private String _ten, _gioTinh;

    public String getTen() {
        return _ten;
    }

    public void setTen(String _ten) {
        this._ten = _ten;
    }

    public String getGioTinh() {
        return _gioTinh;
    }

    public void setGioTinh(String _gioTinh) {
        this._gioTinh = _gioTinh;
    }

    
}
