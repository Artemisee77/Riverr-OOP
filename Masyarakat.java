
// ============================================================
// Masyarakat.java — Class data penerima edukasi
// Prinsip SOLID: SRP — hanya menyimpan data warga
// Encapsulation: field PRIVATE, akses lewat getter & setter
// ============================================================
public class Masyarakat {

    private String idMasyarakat;
    private String nama;

    // Constructor
    public Masyarakat(String id, String nama) {
        this.idMasyarakat = id;
        this.nama = nama;
    }

    // --- Getter ---
    public String getIdMasyarakat() { return idMasyarakat; }
    public String getNama()         { return nama; }

    // --- Setter ---
    public void setIdMasyarakat(String idMasyarakat) { this.idMasyarakat = idMasyarakat; }
    public void setNama(String nama)                 { this.nama = nama; }
}