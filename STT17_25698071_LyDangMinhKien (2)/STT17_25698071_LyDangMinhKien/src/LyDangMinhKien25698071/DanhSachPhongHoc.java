
package LyDangMinhKien25698071;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DanhSachPhongHoc {
    private ArrayList<PhongHoc> ds;

    public DanhSachPhongHoc() {
        ds = new ArrayList<>();
    }

    public boolean themPhong(PhongHoc p) {
        if (p == null || timPhong(p.getMaPhong()) != null) {
            return false;
        }
        ds.add(p);
        return true;
    }

    public PhongHoc timPhong(String maPhong) {
        for (PhongHoc p : ds) {
            if (p.getMaPhong().equalsIgnoreCase(maPhong)) {
                return p;
            }
        }
        return null;
    }

    public List<PhongHoc> getDanhSach() {
        return new ArrayList<>(ds);
    }

    public List<PhongHoc> getPhongDatChuan() {
        ArrayList<PhongHoc> kq = new ArrayList<>();

        for (PhongHoc p : ds) {
            if (p.datChuan()) {
                kq.add(p);
            }
        }
        return kq;
    }

    public void sapXepTheoDayNha() {
        ds.sort(Comparator.comparing(
            PhongHoc::getDayNha,
            String.CASE_INSENSITIVE_ORDER
        ));
    }

    public void sapXepTheoDienTich() {
        ds.sort(
            Comparator.comparingDouble(PhongHoc::getDienTich)
                      .reversed()
        );
    }

    public void sapXepTheoSoBongDen() {
        ds.sort(Comparator.comparingInt(
            PhongHoc::getSoBongDen
        ));
    }
    
    public boolean capNhatSoMayTinh(
            String maPhong, int soMayTinh) throws Exception {

        PhongHoc p = timPhong(maPhong);

        if (!(p instanceof PhongMayTinh)) {
            return false;
        }

        ((PhongMayTinh) p).setSoMayTinh(soMayTinh);
        return true;
    }

    public boolean xoaPhong(String maPhong) {
        PhongHoc p = timPhong(maPhong);

        if (p == null) {
            return false;
        }

        return ds.remove(p);
    }

    public int tongSoPhong() {
        return ds.size();
    }

    public List<PhongMayTinh> getPhongMayTinh60May() {
        ArrayList<PhongMayTinh> kq = new ArrayList<>();

        for (PhongHoc p : ds) {
            if (p instanceof PhongMayTinh) {
                PhongMayTinh mt = (PhongMayTinh) p;

                if (mt.getSoMayTinh() == 60) {
                    kq.add(mt);
                }
            }
        }
        return kq;
    }

    public void inDanhSach(List<? extends PhongHoc> danhSach) {
        if (danhSach.isEmpty()) {
            System.out.println("Danh sach rong.");
            return;
        }

        for (PhongHoc p : danhSach) {
            System.out.println(p);
            System.out.println(
                "Dat chuan: " +
                (p.datChuan() ? "Co" : "Khong")
            );
        }
    }
}
