public class Admin {
    public String idAdmin;
    public String nama;
    public String username;
    public String password;
    public String statusAkun;

    public void tampilkan(){
        System.out.println("ID Admin   : " + idAdmin);
        System.out.println("Nama       : " + nama);
        System.out.println("Username   : " + username);
        System.out.println("Password   : " + password);
        System.out.println("Status     : " + statusAkun);
    }
}

class TestAdmin {
    public static void main(String[] args) {
        
        Admin Admin1 = new Admin();
        Admin Admin2 = new Admin();

        Admin1.idAdmin = "A001";
        Admin1.nama = "Aisyah";
        Admin1.username = "aisyah_admin";
        Admin1.password = "12345";
        Admin1.statusAkun = "Aktif";

        Admin2.idAdmin = "A002";
        Admin2.nama = "Dilla";
        Admin2.username = "dilla_admin";
        Admin2.password = "67890";
        Admin2.statusAkun = "Tidak Aktif";

        Tindaklanjut TindakLanjut1 = new Tindaklanjut();
        Tindaklanjut TindakLanjut2 = new Tindaklanjut();

        TindakLanjut1.melakukan("Laporan selesai", "foto");
        TindakLanjut2.melakukan("Laporan selesai", "foto sungai");

        Admin1.tampilkan();
        Admin2.tampilkan();

        TindakLanjut1.tampilkan();
        TindakLanjut2.tampilkan();
       
    }
}