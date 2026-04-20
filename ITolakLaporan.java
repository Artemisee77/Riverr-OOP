// ============================================================
// INTERFACE: ITolakLaporan
// Tujuan: Kontrak khusus untuk menolak laporan.
// SOLID:
//   I (Interface Segregation) — sebelumnya IPenolakLaporan
//     extends ILaporan sehingga siapapun yang implement tolak
//     dipaksa juga implement mengajukan & tampil.
//     Sekarang dipisah total — Admin bisa implement interface
//     ini saja tanpa terbebani method yang tidak dia butuhkan.
// ============================================================
// ITolakLaporan polymorphism digunakan di method LaporanDitolak untuk di reuse.

public interface ITolakLaporan {
    void tolakLaporan();
}
