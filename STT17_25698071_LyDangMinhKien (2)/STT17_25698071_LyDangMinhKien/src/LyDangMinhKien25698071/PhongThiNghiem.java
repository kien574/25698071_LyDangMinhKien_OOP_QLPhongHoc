
package LyDangMinhKien25698071;

public class PhongThiNghiem extends PhongHoc {
    private String chuyenNganh;
    private int sucChua;
    private boolean coBonRua;

    public PhongThiNghiem(
            String maPhong, String dayNha,
            double dienTich, int soBongDen,
            String chuyenNganh, int sucChua,
            boolean coBonRua) throws Exception {

        super(maPhong, dayNha, dienTich, soBongDen);
        setChuyenNganh(chuyenNganh);
        setSucChua(sucChua);
        setCoBonRua(coBonRua);
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public void setChuyenNganh(String chuyenNganh)
            throws Exception {
        if (chuyenNganh != null && !chuyenNganh.isBlank()) {
            this.chuyenNganh = chuyenNganh;
        } else {
            throw new Exception("Chuyen nganh khong duoc trong");
        }
    }

    public int getSucChua() {
        return sucChua;
    }

    public void setSucChua(int sucChua) throws Exception {
        if (sucChua > 0) {
            this.sucChua = sucChua;
        } else {
            throw new Exception("Suc chua phai duong");
        }
    }

    public boolean isCoBonRua() {
        return coBonRua;
    }

    public void setCoBonRua(boolean coBonRua) {
        this.coBonRua = coBonRua;
    }

    @Override
    public boolean datChuan() {
        return datChuanAnhSang() && coBonRua;
    }

    @Override
    public String toString() {
        return super.toString()
            + ", PhongThiNghiem [chuyenNganh=" + chuyenNganh
            + ", sucChua=" + sucChua
            + ", coBonRua=" + coBonRua + "]";
    }
}
