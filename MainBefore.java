import java.util.Scanner;

// ============================================================
// VERSI BEFORE — Sengaja dibuat bisa crash untuk keperluan
// Bug Hunting & Simulasi Error (Tahap 1 & 2 Praktikum)
// ============================================================
public class MainBefore {
    public static void main(String[] args) {

        // --- Setup Data Masyarakat ---
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

        IMengajukanLaporan laporan1 = LaporanFactory.buatLaporan();
        IMengajukanLaporan laporan2 = LaporanFactory.buatLaporanBanding();
        LaporanDitolak     laporan3 = LaporanFactory.buatLaporanDitolak();

        // ============================================================
        // BUG 1: Input ID dari user, langsung parseInt tanpa validasi
        // Jika user ketik "abc" → NumberFormatException → CRASH
        // ============================================================
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan ID Masyarakat (angka): ");
        String inputId = scanner.nextLine();
        int idInput = Integer.parseInt(inputId); // <-- CRASH di sini jika bukan angka
        scanner.close();

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
        // BUG 2: Cast langsung ke ITampilLaporan tanpa cek instanceof
        // Jika objek tidak implement ITampilLaporan → ClassCastException → CRASH
        // ============================================================
        masyarakat1.tampilkanProfil();
        ((ITampilLaporan) laporan1).tampilLaporan(); // <-- CRASH jika tidak implement

        masyarakat2.tampilkanProfil();
        ((ITampilLaporan) laporan2).tampilLaporan(); // <-- CRASH jika tidak implement

        masyarakat3.tampilkanProfil();
        laporan3.tolakLaporan("Data tidak lengkap");
        laporan3.tampilLaporan();
    }
}