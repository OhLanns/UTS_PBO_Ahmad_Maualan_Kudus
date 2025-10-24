import java.util.ArrayList;
import java.util.Scanner;

public class AplikasiKasir {
    private ArrayList<Admin> daftarAdmin = new ArrayList<>();
    private ArrayList<Akun> daftarAkun = new ArrayList<>();
    private ArrayList<String> riwayatPembelian = new ArrayList<>();
    private Admin adminAktif;

    public void inisialisasiData() {
        daftarAdmin.add(new Admin("A1", "Admin Utama", "admin", "123"));
        daftarAkun.add(new Akun("ML01", "Mobile Legends", 10000, 5));
        daftarAkun.add(new Akun("FF01", "Free Fire", 15000, 5));
        daftarAkun.add(new Akun("VL01", "Valorant", 20000, 5));
    }

    public boolean loginAdmin(String username, String password) {
        for (Admin admin : daftarAdmin) {
            if (admin.login(username, password)) {
                adminAktif = admin;
                return true;
            }
        }
        return false;
    }

    public void mengelolaAkun(Scanner scanner) {
        System.out.println("Opsi: 1. Tambah Akun | 2. Lihat Akun");
        int opsi = scanner.nextInt();
        scanner.nextLine();

        if (opsi == 1) {
            System.out.print("ID: ");
            String id = scanner.nextLine();
            System.out.print("Nama Game: ");
            String nama = scanner.nextLine();
            System.out.print("Harga: Rp");
            int harga = scanner.nextInt();
            System.out.print("Stok: ");
            int stok = scanner.nextInt();
            scanner.nextLine();

            daftarAkun.add(new Akun(id, nama, harga, stok));
            System.out.println("Akun baru berhasil ditambahkan!\n");
        } else if (opsi == 2) {
            tampilkanDaftarAkun();
        }
    }

    public void tampilkanDaftarAkun() {
        System.out.println("\n=== DAFTAR AKUN ===");
        for (Akun akun : daftarAkun) {
            System.out.println(akun);
        }
        System.out.println();
    }

    public void tampilkanRiwayat() {
        System.out.println("\n=== RIWAYAT PEMBELIAN ===");
        if (riwayatPembelian.isEmpty()) {
            System.out.println("Belum ada pembelian.");
        } else {
            for (String data : riwayatPembelian) {
                System.out.println(data);
            }
        }
        System.out.println();
    }

    public void mulaiPembelian(Scanner scanner) {
        System.out.print("Nama Pembeli: ");
        String nama = scanner.nextLine();
        Buyer pembeli = new Buyer(nama);

        tampilkanDaftarAkun();

        System.out.print("Jumlah akun yang ingin dibeli: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < jumlah; i++) {
            System.out.print("Masukkan ID akun: ");
            String id = scanner.nextLine().toUpperCase();

            Akun akunDipilih = null;
            for (Akun akun : daftarAkun) {
                if (akun.getId().equalsIgnoreCase(id) && akun.getStok() > 0) {
                    akunDipilih = akun;
                    break;
                }
            }

            if (akunDipilih != null) {
                akunDipilih.kurangiStok();
                pembeli.tambahAkun(akunDipilih);
                riwayatPembelian.add("Pembeli " + nama + " membeli " + akunDipilih.getNamaGame() + " (Rp" + akunDipilih.getHarga() + ")");
            } else {
                System.out.println("Akun tidak ditemukan atau stok habis!");
                i--;
            }
        }

        pembeli.tampilkanBelanja();

        System.out.print("Bayar: Rp");
        int bayar = scanner.nextInt();
        int kembali = bayar - pembeli.getTotal();

        System.out.println("Kembalian: Rp" + kembali);
        System.out.println("Transaksi selesai!\n");
    }
}
