// ============================================================
// VERSI AFTER — Sudah diperbaiki dengan try-catch dan validasi
// ============================================================
public class AdminAfter {
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
        // FIX BUG 1: Validasi input sebelum melakukan()
        // ============================================================
        try {
            String detail = null;
            if (detail == null || detail.isBlank()) {
                throw new IllegalArgumentException("Detail tindak lanjut tidak boleh kosong.");
            }
            tl1.melakukan(detail, "foto", admin1);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] Validasi gagal: " + e.getMessage());
        } finally {
            System.out.println("[LOG] Proses tindak lanjut 1 selesai.");
        }

        // ============================================================
        // FIX BUG 2: Cek state sebelum akses data
        // ============================================================
        try {
            if (tl2.getIdTindakLanjut() == 0) {
                throw new IllegalStateException("Tindak lanjut belum dilakukan, tidak bisa ditampilkan.");
            }
            System.out.println("Detail: " + tl2.getDetailTindakLanjut());
            System.out.println("Bukti: " + tl2.getBukti());
        } catch (IllegalStateException e) {
            System.out.println("[ERROR] " + e.getMessage());
        } finally {
            System.out.println("[LOG] Proses tampil tindak lanjut 2 selesai.");
        }

        System.out.println("\n=== Tindak Lanjut 1 ===");
        System.out.println("Detail: " + tl1.getDetailTindakLanjut());
        System.out.println("Bukti: " + tl1.getBukti());
    }
}