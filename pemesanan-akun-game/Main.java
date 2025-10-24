import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AplikasiKasir app = new AplikasiKasir();
        app.inisialisasiData();

        System.out.println("=== LOGIN ADMIN ===");
        System.out.print("Username: ");
        String user = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();

        if (app.loginAdmin(user, pass)) {
            boolean jalan = true;
            while (jalan) {
                System.out.println("===========================");
                System.out.println("     MENU OHLANS STORE     ");
                System.out.println("===========================");
                System.out.println("1. Kelola Akun");
                System.out.println("2. Lihat Riwayat Pembelian");
                System.out.println("3. Mulai Pembelian");
                System.out.println("4. Keluar");
                System.out.println("===========================");
                System.out.print("Pilih menu: ");
                int pilih = scanner.nextInt();
                scanner.nextLine();

                switch (pilih) {
                    case 1 -> app.mengelolaAkun(scanner);
                    case 2 -> app.tampilkanRiwayat();
                    case 3 -> app.mulaiPembelian(scanner);
                    case 4 -> {
                        jalan = false;
                        System.out.println("Program selesai. Terima kasih!");
                    }
                    default -> System.out.println("Pilihan tidak valid!");
                }
            }
        } else {
            System.out.println("Login gagal. Program dihentikan.");
        }

        scanner.close();
    }
}
