// ============================================================
// INTERFACE: IMengajukanLaporan
// Tujuan: Kontrak untuk mengajukan laporan.
// SOLID:
//   I (Interface Segregation) — interface kecil, fokus satu hal.
//   D (Dependency Inversion) — class tingkat tinggi bergantung
//     pada abstraksi ini, bukan implementasi konkret.
// ============================================================
//polymorphism:
// IMengajukanLaporan polymorphism method mengajukan untuk di reuse.

public interface IMengajukanLaporan {
    void mengajukan(
        String deskripsi,
        JenisPencemaran jenis,
        StatusLaporan status,
        TingkatPencemaran tingkat,
        int idMasyarakat
    );
}
