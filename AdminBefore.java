// ============================================================
// VERSI BEFORE — Sengaja dibuat bisa crash untuk keperluan
// Bug Hunting & Simulasi Error (Tahap 1 & 2 Praktikum)
// ============================================================
public class AdminBefore {
    public static void main(String[] args) {

        Admin admin1 = new Admin();
        admin1.setIdAdmin("A001");
        admin1.setNama("Aisyah");
        admin1.setUsername("aisyah_admin");
        admin1.setPassword("12345");
        admin1.setStatusAkun("Aktif");

        Admin admin2 = new Admin();
        admin2.setIdAdmin("A002");
        admin2.setNama("Dilla");
        admin2.setUsername("dilla_admin");
        admin2.setPassword("67890");
        admin2.setStatusAkun("Tidak Aktif");

        Tindaklanjut tl1 = new Tindaklanjut();
        Tindaklanjut tl2 = new Tindaklanjut();

        // ============================================================
        // BUG 1: melakukan() dipanggil dengan detail = null
        // Tidak ada validasi → data null masuk ke sistem tanpa peringatan
        // ============================================================
        tl1.melakukan(null, "foto", admin1); // <-- detail null, tidak dicegah!

        // ============================================================
        // BUG 2: getDetailTindakLanjut() dipanggil sebelum melakukan()
        // Semua field masih null → output tidak valid
        // ============================================================
        System.out.println("Detail: " + tl2.getDetailTindakLanjut()); // <-- null!
        System.out.println("Bukti: " + tl2.getBukti()); // <-- null!
        System.out.println("Admin: " + tl2.getAdminEksekutor()); // <-- null!

        System.out.println("\n=== Tindak Lanjut 1 ===");
        System.out.println("Detail: " + tl1.getDetailTindakLanjut());
        System.out.println("Bukti: " + tl1.getBukti());
        System.out.println("Admin: " + tl1.getAdminEksekutor().getid());
    }
}