// ============================================================
// VERSI BEFORE — Sengaja dibuat bisa crash untuk keperluan
// Bug Hunting & Simulasi Error (Tahap 1 & 2 Praktikum)
// ============================================================
public class AdminBefore {
    public static void main(String[] args) {

        Admin admin1 = new Admin();
        admin1.idAdmin = "A001";
        admin1.nama = "Aisyah";
        admin1.username = "aisyah_admin";
        admin1.password = "12345";
        admin1.statusAkun = "Aktif";

        Admin admin2 = new Admin();
        admin2.idAdmin = "A002";
        admin2.nama = "Dilla";
        admin2.username = "dilla_admin";
        admin2.password = "67890";
        admin2.statusAkun = "Tidak Aktif";

        Tindaklanjut tl1 = new Tindaklanjut();
        Tindaklanjut tl2 = new Tindaklanjut();

        // ============================================================
        // BUG 1: melakukan() dipanggil dengan detail = null
        // Tidak ada validasi → data null masuk ke sistem tanpa peringatan
        // ============================================================
        tl1.melakukan(null, "foto", admin1.idAdmin); // <-- detail null

        // ============================================================
        // BUG 2: tampilkan() dipanggil sebelum melakukan()
        // Semua field masih null → output tidak valid
        // ============================================================
        tl2.tampilkan(); // <-- dipanggil sebelum melakukan()!

        admin1.tampilkan();
        tl1.tampilkan();
    }
}