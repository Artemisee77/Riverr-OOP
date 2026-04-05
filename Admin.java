public class Admin {
    private  String idAdmin;
    private  String nama;
    private  String username;
    private  String password;
    private  String statusAkun;

    // public void tampilkan(){
    //     System.out.println("\nID Admin   : " + idAdmin);
    //     System.out.println("Nama       : " + nama);
    //     System.out.println("Username   : " + username);
    //     System.out.println("Password   : " + password);
    //     System.out.println("Status     : " + statusAkun);
    // }

    public void setIdAdmin(String idAdmin){
        this.idAdmin = idAdmin;
    }

    public String getid() {
        return idAdmin;
    }

    public void setNama(String nama) {
        this.nama = nama;
    } 

    public String getNama() {
        return nama;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setStatusAkun(String statusAkun) {
        this.statusAkun = statusAkun;
    }

    public String getStatusAkun() {
        return statusAkun;
    }
}

class TestAdmin {
    public static void main(String[] args) {
        
        Admin Admin1 = new Admin();
        Admin1.setIdAdmin("A001");
        Admin1.setNama("dilla");
        Admin1.setUsername("dilladmin");
        Admin1.setPassword("password123");
        Admin1.setStatusAkun("aktif");


        Admin Admin2 = new Admin();
        Admin2.setIdAdmin("A002");
        Admin2.setNama("isaa");
        Admin2.setUsername("isaadmin");
        Admin2.setPassword("password123");
        Admin2.setStatusAkun("aktif");

        Tindaklanjut TindakLanjut1 = new Tindaklanjut();
        Tindaklanjut TindakLanjut2 = new Tindaklanjut();

        // Mengirimkan objek Admin secara langsung (bukan hanya String ID-nya)
        TindakLanjut1.melakukan("Laporan selesai", "foto", Admin1);
        TindakLanjut2.melakukan("Laporan selesai", "foto sungai", Admin2);

        // Admin1.tampilkan();
        // Admin2.tampilkan();
        // TindakLanjut1.tampilkan();
        // TindakLanjut2.tampilkan();

        // 2. Siapkan "Tukang Cetak" (Sesuai Prinsip DIP)
        IDisplay printer = new ConsoleDisplay();
        

        // 3. Panggil fungsi cetak dari sini!
        printer.cetakAdmin(Admin1);
        printer.cetakTindakLanjut(TindakLanjut1);
        printer.cetakAdmin(Admin2);
        printer.cetakTindakLanjut(TindakLanjut2);
    }
}