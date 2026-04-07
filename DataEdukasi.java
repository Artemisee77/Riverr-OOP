
// ============================================================
// DataEdukasi.java — Abstract class (parent semua edukasi)
// Prinsip SOLID: SRP + OCP
// Encapsulation: field PROTECTED agar diakses kelas turunan saja
//               tidak bisa diakses langsung dari luar
// ============================================================
public abstract class DataEdukasi {

    protected String idEdukasi;
    protected String judul;
    protected String isiPesan;
    protected String tanggalKirim;
    protected String idAdmin;

    // --- Getter ---
    public String getIdEdukasi()    { return idEdukasi; }
    public String getJudul()        { return judul; }
    public String getIsiPesan()     { return isiPesan; }
    public String getTanggalKirim() { return tanggalKirim; }
    public String getIdAdmin()      { return idAdmin; }

    // --- Setter ---
    public void setIdEdukasi(String idEdukasi)       { this.idEdukasi = idEdukasi; }
    public void setJudul(String judul)               { this.judul = judul; }
    public void setIsiPesan(String isiPesan)         { this.isiPesan = isiPesan; }
    public void setTanggalKirim(String tanggalKirim) { this.tanggalKirim = tanggalKirim; }
    public void setIdAdmin(String idAdmin)           { this.idAdmin = idAdmin; }

    // Method info dasar — bisa dipakai ulang oleh kelas turunan
    public void infoDasar() {
        System.out.println("ID Edukasi      : " + idEdukasi);
        System.out.println("Judul           : " + judul);
    }

    // Abstract method — kelas turunan WAJIB override (OCP)
    public abstract void tampilInfo();
}