class Masyarakat {
    int idMasyarakat;
    String nama;
    String email;
    String alamat;
    Boolean statusAkun;
    String password;

    public void TampilkanProfil(){
        System.out.println("\nId Masyarakat : " + idMasyarakat);
        System.out.println("Nama : " + nama);
        System.out.println("Email : " + email);
        System.out.println("Alamat : " + alamat);
        System.out.println("Status Akun : " + statusAkun);
        System.out.println("Password : " + password);
    }
}

public class TestMasyarakat {
    public static void main(String[] args) {

        Masyarakat masyarakat1 = new Masyarakat();
        Masyarakat masyarakat2 = new Masyarakat();

        masyarakat1.idMasyarakat = 1;
        masyarakat1.nama = "Budi";
        masyarakat1.email = "9x6u1@example.com";
        masyarakat1.alamat = "Jl. Raya No. 123";
        masyarakat1.statusAkun = true;
        masyarakat1.password = "password123";

        masyarakat2.idMasyarakat = 2;
        masyarakat2.nama = "Andi";
        masyarakat2.email = "9x6u1@example.com";
        masyarakat2.alamat = "Jl. Raya No. 123";
        masyarakat2.statusAkun = true;
        masyarakat2.password = "password123";

    
        //mengajukan laporan
        laporan laporan1 = new laporan();
        laporan laporan2 = new laporan();

        laporan1.mengajukan("Laporan Pencemaran Air", "air", "belum", "ringan", masyarakat1.idMasyarakat);
        laporan2.mengajukan("Laporan Pencemaran Tanah", "tanah", "sedang", "sedang", masyarakat2.idMasyarakat);

        masyarakat1.TampilkanProfil();
        laporan1.tampilLaporan();

        masyarakat2.TampilkanProfil();
        laporan2.tampilLaporan();

        laporan2.TampilkanProfil();

        // // User
        // User user1 = new User();
        // user1.membuatLaporan("Laporan Pencemaran Air", "air", "belum", "ringan");
        // user1.membuatLaporan("Laporan Pencemaran Tanah", "tanah", "sedang", "sedang");
    }
}