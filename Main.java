class Masyarakat {
    private int idMasyarakat;
    private String nama;
    private String email;
    private String alamat;
    private Boolean statusAkun;
    private String password;

    public void setId(int idMasyarakat) {
        this.idMasyarakat = idMasyarakat;
    }

    public int getId() {
        return idMasyarakat;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setStatusAkun(Boolean statusAkun) {
        this.statusAkun = statusAkun;
    }

    public Boolean getStatusAkun() {
        return statusAkun;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void TampilkanProfil(){
        System.out.println("\nId Masyarakat : " + idMasyarakat);
        System.out.println("Nama : " + nama);
        System.out.println("Email : " + email);
        System.out.println("Alamat : " + alamat);
        System.out.println("Status Akun : " + statusAkun);
        System.out.println("Password : " + password);
    }
}

public class Main {
    public static void main(String[] args) {

        Masyarakat masyarakat1 = new Masyarakat();
        Masyarakat masyarakat2 = new Masyarakat();
        Masyarakat masyarakat3 = new Masyarakat();

        masyarakat1.setId(1);
        masyarakat1.setNama("budi");
        masyarakat1.setEmail("budi@budi");
        masyarakat1.setAlamat("Jl. Raya No. 123");
        masyarakat1.setStatusAkun(true);
        masyarakat1.setPassword("password123");

        masyarakat2.setId(2);
        masyarakat2.setNama("bangkit");
        masyarakat2.setEmail("bangkit@");
        masyarakat2.setAlamat("Jl. Raya No. 123");
        masyarakat2.setStatusAkun(true);
        masyarakat2.setPassword("password123");

        masyarakat3.setId(3);
        masyarakat3.setNama("caca");
        masyarakat3.setEmail("caca@caca");
        masyarakat3.setAlamat("Jl. Raya No. 123");
        masyarakat3.setStatusAkun(true);
        masyarakat3.setPassword("password123");

    
        //mengajukan laporan
        ILaporan laporan1 = new laporan();
        ILaporan laporan2 = new LaporanBanding();
        IPenolakLaporan laporan3 = new laporan();


        laporan1.mengajukan("Laporan Pencemaran Air", "air", "selesai", "ringan", masyarakat1.getId());
        laporan2.mengajukan("Laporan Pencemaran Tanah", "tanah", "selesai", "sedang", masyarakat2.getId());
        laporan3.mengajukan("Laporan Pencemaran Air", "air", "ditolak", "ringan", masyarakat3.getId());

        masyarakat1.TampilkanProfil();
        laporan1.tampilLaporan();

        masyarakat2.TampilkanProfil();
        laporan2.tampilLaporan();

        masyarakat3.TampilkanProfil();
        laporan3.tolaklaporan();
        laporan3.tampilLaporan();
    }
}