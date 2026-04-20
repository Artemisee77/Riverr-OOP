// ============================================================
// CLASS: LaporanFactory
// Tujuan: Satu-satunya tempat yang "tahu" cara membuat objek
//         laporan konkret.
// SOLID:
//   D (Dependency Inversion) — Main dan class lain tidak perlu
//     menulis "new Laporan()" atau "new LaporanBanding()" secara
//     langsung. Mereka cukup minta lewat Factory ini.
//     Jika implementasi berubah (misal Laporan diganti dengan
//     LaporanV2), cukup ubah Factory — Main tidak perlu disentuh.
//
//   S (Single Responsibility) — tanggung jawab Factory hanya
//     satu: membuat objek laporan.
// ============================================================
public class LaporanFactory {

    //  D — kembalikan tipe interface, bukan class konkret
    public static IMengajukanLaporan buatLaporan() {
        return new Laporan();
    }

    public static IMengajukanLaporan buatLaporanBanding() {
        return new LaporanBanding();
    }

    public static LaporanDitolak buatLaporanDitolak() {
        return new LaporanDitolak();
    }
}
