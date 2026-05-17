import java.util.Scanner;

// ============================================================
// CLASS: Main (AFTER — Sudah diperbaiki)
// SOLID:
//   D (Dependency Inversion) — Main bergantung pada interface
//     (IMengajukanLaporan, ITampilLaporan, ITolakLaporan) dan
//     Factory, bukan class konkret secara langsung.
//     Jika implementasi berubah, Main tidak perlu diubah.
//
// [PRAKTIKUM] Ditambahkan: Exception Handling & Validasi Input
// ============================================================
public class Main {
    public static void main(String[] args) {

        // --- Setup Data Masyarakat ---
        // S: Masyarakat hanya mengurus profil pengguna
        Masyarakat masyarakat1 = new Masyarakat();
        masyarakat1.setId(1);
        masyarakat1.setNama("Budi");
        masyarakat1.setEmail("budi@budi.com");
        masyarakat1.setAlamat("Jl. Raya No. 123");
        masyarakat1.setStatusAkun(true);
        masyarakat1.setPassword("password123");

        Masyarakat masyarakat2 = new Masyarakat();
        masyarakat2.setId(2);
        masyarakat2.setNama("Bangkit");
        masyarakat2.setEmail("bangkit@mail.com");
        masyarakat2.setAlamat("Jl. Raya No. 456");
        masyarakat2.setStatusAkun(true);
        masyarakat2.setPassword("password123");

        Masyarakat masyarakat3 = new Masyarakat();
        masyarakat3.setId(3);
        masyarakat3.setNama("Caca");
        masyarakat3.setEmail("caca@caca.com");
        masyarakat3.setAlamat("Jl. Raya No. 789");
        masyarakat3.setStatusAkun(true);
        masyarakat3.setPassword("password123");

        // D — Main bergantung pada LaporanFactory, bukan "new Laporan()" langsung
        // D — tipe variabel adalah interface, bukan class konkret
        IMengajukanLaporan laporan1 = LaporanFactory.buatLaporan();
        IMengajukanLaporan laporan2 = LaporanFactory.buatLaporanBanding();
        LaporanDitolak     laporan3 = LaporanFactory.buatLaporanDitolak();

        // ============================================================
        // [PERBAIKAN 1] Validasi Input + try-catch-finally
        // BEFORE: Integer.parseInt(inputId) langsung tanpa validasi
        // AFTER : Cek regex dulu, tangkap exception secara spesifik
        // ============================================================
        Scanner scanner = new Scanner(System.in);
        int idInput = masyarakat1.getId(); // default fallback

        try {
            System.out.print("Masukkan ID Masyarakat (angka): ");
            String inputId = scanner.nextLine();

            // VALIDASI: pastikan input hanya angka sebelum parseInt
            if (!inputId.matches("\\d+")) {
                throw new NumberFormatException("Input '" + inputId + "' bukan angka valid!");
            }
            idInput = Integer.parseInt(inputId);

            if (idInput <= 0) {
                throw new IllegalArgumentException("ID harus lebih dari 0, nilai: " + idInput);
            }

        } catch (NumberFormatException e) {
            System.out.println("[ERROR] " + e.getMessage());
            System.out.println("[INFO] Menggunakan ID default: " + masyarakat1.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] " + e.getMessage());
            System.out.println("[INFO] Menggunakan ID default: " + masyarakat1.getId());
        } finally {
            // finally: scanner selalu ditutup meski terjadi error
            scanner.close();
            System.out.println("[FINALLY] Input selesai diproses.");
        }

        // O — Gunakan enum, bukan String
        laporan1.mengajukan(
            "Laporan Pencemaran Air",
            JenisPencemaran.AIR,
            StatusLaporan.SELESAI,
            TingkatPencemaran.RINGAN,
            idInput
        );

        laporan2.mengajukan(
            "Laporan Pencemaran Tanah",
            JenisPencemaran.TANAH,
            StatusLaporan.SELESAI,
            TingkatPencemaran.SEDANG,
            masyarakat2.getId()
        );

        laporan3.mengajukan(
            "Laporan Pencemaran Air",
            JenisPencemaran.AIR,
            StatusLaporan.BELUM,
            TingkatPencemaran.RINGAN,
            masyarakat3.getId()
        );

        // ============================================================
        // [PERBAIKAN 2] instanceof check sebelum cast + try-catch-finally
        // BEFORE: cast langsung ((ITampilLaporan) laporan1) tanpa pengecekan
        // AFTER : validasi instanceof dulu, baru cast
        // ============================================================

        // --- Tampil Laporan 1 ---
        masyarakat1.tampilkanProfil();
        try {
            if (!(laporan1 instanceof ITampilLaporan)) {
                throw new ClassCastException("laporan1 tidak mengimplementasi ITampilLaporan!");
            }
            ((ITampilLaporan) laporan1).tampilLaporan(); // D — cast ke interface

        } catch (ClassCastException e) {
            System.out.println("[ERROR] " + e.getMessage());
        } finally {
            System.out.println("[FINALLY] Selesai menampilkan Laporan 1.");
        }

        // --- Tampil Laporan 2 ---
        masyarakat2.tampilkanProfil();
        try {
            if (!(laporan2 instanceof ITampilLaporan)) {
                throw new ClassCastException("laporan2 tidak mengimplementasi ITampilLaporan!");
            }
            ((ITampilLaporan) laporan2).tampilLaporan();

        } catch (ClassCastException e) {
            System.out.println("[ERROR] " + e.getMessage());
        } finally {
            System.out.println("[FINALLY] Selesai menampilkan Laporan 2.");
        }

        // --- Tolak dan tampil Laporan 3 ---
        masyarakat3.tampilkanProfil();
        try {
            String alasan = "Data tidak lengkap";

            // VALIDASI: alasan tidak boleh kosong
            if (alasan == null || alasan.trim().isEmpty()) {
                throw new IllegalArgumentException("Alasan penolakan tidak boleh kosong!");
            }

            laporan3.tolakLaporan(alasan);  // I — method tolak hanya ada di ITolakLaporan
            laporan3.tampilLaporan();        // L — LaporanDitolak tetap bisa tampilLaporan

        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] Validasi gagal: " + e.getMessage());
        } finally {
            System.out.println("[FINALLY] Selesai memproses Laporan 3.");
        }
    }
}