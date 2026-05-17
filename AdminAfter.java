// ============================================================
// VERSI AFTER — Sudah diperbaiki dengan try-catch dan validasi
// ============================================================
public class AdminAfter {
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
        // FIX BUG 1: Validasi input sebelum melakukan()
        // ============================================================
        try {
            if (admin1.idAdmin == null || admin1.idAdmin.isBlank()) {
                throw new IllegalArgumentException("ID Admin tidak boleh kosong.");
            }
            if (tl1.getSudahMelakukan()) {
                throw new IllegalStateException("Tindak lanjut sudah pernah dilakukan.");
            }
            tl1.melakukan(null, "foto", admin1.idAdmin);
            if (tl1.getDetailTindakLanjut() == null) {
                throw new IllegalArgumentException("Detail tindak lanjut tidak boleh kosong.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] Validasi gagal: " + e.getMessage());
        } finally {
            System.out.println("[LOG] Proses tindak lanjut 1 selesai.");
        }

        // ============================================================
        // FIX BUG 2: Cek state sebelum tampilkan()
        // ============================================================
        try {
            if (!tl2.getSudahMelakukan()) {
                throw new IllegalStateException("Tindak lanjut belum dilakukan, tidak bisa ditampilkan.");
            }
            tl2.tampilkan();
        } catch (IllegalStateException e) {
            System.out.println("[ERROR] " + e.getMessage());
        } finally {
            System.out.println("[LOG] Proses tampil tindak lanjut 2 selesai.");
        }

        admin1.tampilkan();
        tl1.tampilkan();
    }
}