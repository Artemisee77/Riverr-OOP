// ============================================================
// CLASS: Main
// SOLID:
//   D (Dependency Inversion) — Main bergantung pada interface
//     (IMengajukanLaporan, ITampilLaporan, ITolakLaporan) dan
//     Factory, bukan class konkret secara langsung.
//     Jika implementasi berubah, Main tidak perlu diubah.
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

        // O — Gunakan enum, bukan String. Tidak ada risiko typo atau bug "=="
        laporan1.mengajukan(
            "Laporan Pencemaran Air",
            JenisPencemaran.AIR,
            StatusLaporan.SELESAI,
            TingkatPencemaran.RINGAN,
            masyarakat1.getId()
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

        // --- Tampil Laporan 1 ---
        masyarakat1.tampilkanProfil();
        ((ITampilLaporan) laporan1).tampilLaporan(); //  D — cast ke interface

        // --- Tampil Laporan 2 ---
        masyarakat2.tampilkanProfil();
        ((ITampilLaporan) laporan2).tampilLaporan();

        // --- Tolak dan tampil Laporan 3 ---
        masyarakat3.tampilkanProfil();
        laporan3.tolakLaporan("Data tidak lengkap");  // I — method tolak hanya ada di ITolakLaporan
        laporan3.tampilLaporan();                      // L — LaporanDitolak tetap bisa tampilLaporan
    }
}
