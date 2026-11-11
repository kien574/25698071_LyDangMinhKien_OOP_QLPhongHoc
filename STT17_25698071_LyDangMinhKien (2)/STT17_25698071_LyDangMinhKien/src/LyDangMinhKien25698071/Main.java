
package LyDangMinhKien25698071;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static DanhSachPhongHoc ds = new DanhSachPhongHoc();

    public static void main(String[] args) {
        int chon = -1;

        do {
            System.out.println("\n===== QUAN LY PHONG HOC =====");
            System.out.println("1. Them phong");
            System.out.println("2. Tim phong theo ma");
            System.out.println("3. Hien thi tat ca phong");
            System.out.println("4. Hien thi phong dat chuan");
            System.out.println("5. Sap xep tang theo day nha");
            System.out.println("6. Sap xep giam theo dien tich");
            System.out.println("7. Sap xep tang theo so bong den");
            System.out.println("8. Cap nhat so may tinh");
            System.out.println("9. Xoa phong");
            System.out.println("10. Tong so phong");
            System.out.println("11. Tim phong may tinh co 60 may");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");

            try {
                chon = Integer.parseInt(sc.nextLine());

                switch (chon) {
                    case 1:
                        themPhong();
                        break;
                    case 2:
                        timPhong();
                        break;
                    case 3:
                        ds.inDanhSach(ds.getDanhSach());
                        break;
                    case 4:
                        ds.inDanhSach(ds.getPhongDatChuan());
                        break;
                    case 5:
                        ds.sapXepTheoDayNha();
                        ds.inDanhSach(ds.getDanhSach());
                        break;
                    case 6:
                        ds.sapXepTheoDienTich();
                        ds.inDanhSach(ds.getDanhSach());
                        break;
                    case 7:
                        ds.sapXepTheoSoBongDen();
                        ds.inDanhSach(ds.getDanhSach());
                        break;
                    case 8:
                        capNhatSoMayTinh();
                        break;
                    case 9:
                        xoaPhong();
                        break;
                    case 10:
                        System.out.println(
                            "Tong so phong: " + ds.tongSoPhong()
                        );
                        break;
                    case 11:
                        ds.inDanhSach(ds.getPhongMayTinh60May());
                        break;
                    case 0:
                        System.out.println("Ket thuc chuong trinh.");
                        break;
                    default:
                        System.out.println("Lua chon khong hop le.");
                }
            } catch (Exception e) {
                System.out.println("Loi: " + e.getMessage());
                chon = -1;
            }
        } while (chon != 0);
    }

    static void themPhong() throws Exception {
        System.out.println("1. Phong ly thuyet");
        System.out.println("2. Phong may tinh");
        System.out.println("3. Phong thi nghiem");
        System.out.print("Chon loai phong: ");
        int loai = Integer.parseInt(sc.nextLine());

        System.out.print("Ma phong: ");
        String ma = sc.nextLine();

        System.out.print("Day nha: ");
        String day = sc.nextLine();

        System.out.print("Dien tich: ");
        double dt = Double.parseDouble(sc.nextLine());

        System.out.print("So bong den: ");
        int bong = Integer.parseInt(sc.nextLine());

        PhongHoc p;

        switch (loai) {
            case 1:
                System.out.print("Co may chieu (true/false): ");
                boolean chieu = Boolean.parseBoolean(sc.nextLine());
                p = new PhongLyThuyet(ma, day, dt, bong, chieu);
                break;

            case 2:
                System.out.print("So may tinh: ");
                int may = Integer.parseInt(sc.nextLine());
                p = new PhongMayTinh(ma, day, dt, bong, may);
                break;

            case 3:
                System.out.print("Chuyen nganh: ");
                String cn = sc.nextLine();

                System.out.print("Suc chua: ");
                int scua = Integer.parseInt(sc.nextLine());

                System.out.print("Co bon rua (true/false): ");
                boolean rua = Boolean.parseBoolean(sc.nextLine());

                p = new PhongThiNghiem(
                    ma, day, dt, bong, cn, scua, rua
                );
                break;

            default:
                System.out.println("Loai phong khong hop le.");
                return;
        }

        if (ds.themPhong(p)) {
            System.out.println("Them thanh cong.");
        } else {
            System.out.println("Ma phong da ton tai.");
        }
    }

    static void timPhong() {
        System.out.print("Nhap ma phong: ");
        PhongHoc p = ds.timPhong(sc.nextLine());

        if (p == null) {
            System.out.println("Khong tim thay.");
        } else {
            System.out.println(p);
        }
    }

    static void capNhatSoMayTinh() throws Exception {
        System.out.print("Nhap ma phong may tinh: ");
        String ma = sc.nextLine();

        System.out.print("Nhap so may tinh moi: ");
        int soMay = Integer.parseInt(sc.nextLine());

        if (ds.capNhatSoMayTinh(ma, soMay)) {
            System.out.println("Cap nhat thanh cong.");
        } else {
            System.out.println("Khong tim thay phong may tinh.");
        }
    }

    static void xoaPhong() {
        System.out.print("Nhap ma phong can xoa: ");
        String ma = sc.nextLine();

        PhongHoc p = ds.timPhong(ma);

        if (p == null) {
            System.out.println("Khong tim thay phong.");
            return;
        }

        System.out.println("Thong tin phong:");
        System.out.println(p);
        System.out.print("Ban chac chan muon xoa? (Y/N): ");

        String xn = sc.nextLine();

        if (xn.equalsIgnoreCase("Y")) {
            ds.xoaPhong(ma);
            System.out.println("Da xoa phong.");
        } else {
            System.out.println("Da huy xoa.");
        }
    }
}
