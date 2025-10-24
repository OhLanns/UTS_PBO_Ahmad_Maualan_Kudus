public class Admin {
    private String id;
    private String nama;
    private String username;
    private String password;

    public Admin(String id, String nama, String username, String password) {
        this.id = id;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public boolean login(String user, String pass) {
        return username.equals(user) && password.equals(pass);
    }

    public void tampilkanData() {
        System.out.println(id + " | " + nama + " | " + username);
    }

    public String getNama() {
        return nama;
    }
}
