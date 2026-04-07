
// ============================================================
// EdukasiLingkungan.java — Kelas turunan dari DataEdukasi
// Prinsip SOLID: LSP — bisa menggantikan DataEdukasi di mana saja
// Implements IKirimable — wajib punya kirimEdukasi()
// Encapsulation: field sendiri (dampak) PRIVATE
// ============================================================
public class EdukasiLingkungan extends DataEdukasi implements IKirimable {

    private String dampak;

    // --- Getter & Setter ---
    public String getDampak()            { return dampak; }
    public void setDampak(String dampak) { this.dampak = dampak; }

    // Override abstract method dari DataEdukasi
    @Override
    public void tampilInfo() {
        infoDasar(); // memanggil method dari parent
        System.out.println("Isi Pesan       : " + getIsiPesan());
        System.out.println("Dampak Positif  : " + dampak);
        System.out.println("Tanggal Kirim   : " + getTanggalKirim());
        System.out.println("Admin Pengirim  : " + getIdAdmin());
    }

    // Implementasi dari interface IKirimable
    @Override
    public void kirimEdukasi(Masyarakat penerima) {
        System.out.println("====== PESAN EDUKASI LINGKUNGAN ======");
        tampilInfo();
        System.out.println("Target Penerima : " + penerima.getNama()
                         + " (" + penerima.getIdMasyarakat() + ")");
        System.out.println("======================================");
    }
}