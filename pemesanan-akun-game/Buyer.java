import java.util.ArrayList;

public class Buyer {
    private String nama;
    private ArrayList<Akun> daftarBelanja = new ArrayList<>();
    private int total = 0;

    public Buyer(String nama) {
        this.nama = nama;
    }

    public void tambahAkun(Akun akun) {
        daftarBelanja.add(akun);
        total += akun.getHarga();
    }

    public void tampilkanBelanja() {
        System.out.println("\n=== Daftar Belanja " + nama + " ===");
        for (Akun akun : daftarBelanja) {
            System.out.println(akun);
        }
        System.out.println("Total Bayar: Rp" + total);
    }

    public int getTotal() {
        return total;
    }
}
