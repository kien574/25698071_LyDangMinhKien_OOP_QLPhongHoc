package LyDangMinhKien25698071;

public class PhongMayTinh extends PhongHoc{
	private int soMayTinh;

    public PhongMayTinh (String maPhong, String dayNha,
                        double dienTich, int soBongDen,
                        int soMayTinh) throws Exception {
        super(maPhong, dayNha, dienTich, soBongDen);
        setSoMayTinh(soMayTinh);
    }

    
    public int getSoMayTinh() {
		return soMayTinh;
	}


	public void setSoMayTinh(int soMayTinh) throws Exception {
		if(soMayTinh > 0) {
			this.soMayTinh = soMayTinh;
		} else throw new Exception("So may tinh phai duong");
	}


	@Override
	public boolean datChuan() {
	    return datChuanAnhSang()
	        && soMayTinh > 0
	        && dienTich >= 1.5 * soMayTinh;
	}


	@Override
	public String toString() {
		return super.toString() + "PhongMayTinh [soMayTinh=" + soMayTinh + "]";
	}
	
	
}
