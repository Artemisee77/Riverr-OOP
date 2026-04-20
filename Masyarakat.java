// ============================================================
// CLASS: Masyarakat
// Tujuan: Menyimpan dan menampilkan data profil pengguna.
// SOLID:
//   S (Single Responsibility) — class ini HANYA mengurus data
//     profil. Sebelumnya, class laporan extends Masyarakat,
//     mencampurkan tanggung jawab profil pengguna dengan
//     logika laporan. Sekarang keduanya benar-benar terpisah.
// ============================================================
public class Masyarakat {
    private int idMasyarakat;
    private String nama;
    private String email;
    private String alamat;
    private Boolean statusAkun;
    private String password;

    public void setId(int idMasyarakat)          { this.idMasyarakat = idMasyarakat; }
    public int getId()                            { return idMasyarakat; }
    public void setNama(String nama)              { this.nama = nama; }
    public String getNama()                       { return nama; }
    public void setEmail(String email)            { this.email = email; }
    public String getEmail()                      { return email; }
    public void setAlamat(String alamat)          { this.alamat = alamat; }
    public String getAlamat()                     { return alamat; }
    public void setStatusAkun(Boolean statusAkun) { this.statusAkun = statusAkun; }
    public Boolean getStatusAkun()                { return statusAkun; }
    public void setPassword(String password)      { this.password = password; }
    public String getPassword()                   { return password; }

    public void tampilkanProfil() {
        System.out.println("\n=== Profil Masyarakat ===");
        System.out.println("Id Masyarakat : " + idMasyarakat);
        System.out.println("Nama          : " + nama);
        System.out.println("Email         : " + email);
        System.out.println("Alamat        : " + alamat);
        System.out.println("Status Akun   : " + statusAkun);
        System.out.println("Password      : " + password);
    }
}
