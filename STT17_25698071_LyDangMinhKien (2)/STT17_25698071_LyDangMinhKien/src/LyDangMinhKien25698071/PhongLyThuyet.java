package LyDangMinhKien25698071;

class PhongLyThuyet extends PhongHoc {
    private boolean coMayChieu;

    public PhongLyThuyet(String maPhong, String dayNha,
                         double dienTich, int soBongDen,
                         boolean coMayChieu) throws Exception {
        super(maPhong, dayNha, dienTich, soBongDen);
        setCoMayChieu(coMayChieu);
    }

    public boolean isCoMayChieu() {
		return coMayChieu;
	}


	public void setCoMayChieu(boolean coMayChieu) {
		this.coMayChieu = coMayChieu;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + "PhongLyThuyet [coMayChieu=" + coMayChieu + "]";
	}

	@Override
    public boolean datChuan() {
        return datChuanAnhSang() && coMayChieu;
    }
}
