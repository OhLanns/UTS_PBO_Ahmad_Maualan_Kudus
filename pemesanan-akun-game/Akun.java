public class Akun {
    private String id;
    private String namaGame;
    private int harga;
    private int stok;

    public Akun(String id, String namaGame, int harga, int stok) {
        this.id = id;
        this.namaGame = namaGame;
        this.harga = harga;
        this.stok = stok;
    }

    public String getId() {
        return id;
    }

    public String getNamaGame() {
        return namaGame;
    }

    public int getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public void kurangiStok() {
        if (stok > 0) stok--;
    }

    @Override
    public String toString() {
        return id + " | " + namaGame + " | Rp" + harga + " | Stok: " + stok;
    }
}
