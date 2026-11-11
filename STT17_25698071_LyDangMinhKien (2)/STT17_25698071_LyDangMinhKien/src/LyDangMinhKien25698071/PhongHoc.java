package LyDangMinhKien25698071;

public abstract class PhongHoc {
	protected String maPhong;
    protected String dayNha;
    protected double dienTich;
    protected int soBongDen;

    public PhongHoc(String maPhong, String dayNha,
            double dienTich, int soBongDen) throws Exception {
		setMaPhong(maPhong);
		setDayNha(dayNha);
		setDienTich(dienTich);
		setSoBongDen(soBongDen);
	}
    

    public String getMaPhong() {
		return maPhong;
	}



	public String getDayNha() {
		return dayNha;
	}



	public double getDienTich() {
		return dienTich;
	}



	public int getSoBongDen() {
		return soBongDen;
	}


	
	public void setMaPhong(String maPhong) throws Exception {
		if(!maPhong.isEmpty() && !maPhong.isBlank()) {
			this.maPhong = maPhong;
		} else throw new Exception("Ma phong khong duoc trong");
	}


	public void setDayNha(String dayNha) throws Exception {
		if(!dayNha.isBlank() && !dayNha.isEmpty()) {
			this.dayNha = dayNha;
		} else throw new Exception("Day nha khong duoc trong");
	}


	public void setDienTich(double dienTich) throws Exception {
		if(dienTich > 0) {
			this.dienTich = dienTich;
		} else throw new Exception("Dien tich phai duong");
	}


	public void setSoBongDen(int soBongDen) throws Exception {
		if(soBongDen >= 0) {
			this.soBongDen = soBongDen;
		} else throw new Exception("So bong den phai duong");
	}
	
	public boolean datChuanAnhSang() {
        return soBongDen >= dienTich / 10.0;
    }

	
    @Override
	public String toString() {
		return "PhongHoc [maPhong=" + maPhong + ", dayNha=" + dayNha + ", dienTich=" + dienTich + ", soBongDen="
				+ soBongDen + "]";
	}


	public abstract boolean datChuan();
}
