import java.time.LocalDate;

// ============================================================
// CLASS: LaporanBanding
// Tujuan: Laporan banding — jenis laporan yang berbeda
//         dari laporan biasa.
// SOLID:
//   S (Single Responsibility) — hanya mengurus data laporan
//     banding. Tidak mengurus profil pengguna.
//
//   O (Open/Closed) — pakai enum, tidak ada if-else String.
//
//   I (Interface Segregation) — implement interface yang
//     sesuai kebutuhannya saja.
//
//   D (Dependency Inversion) — bergantung pada interface
//     (IMengajukanLaporan, ITampilLaporan), bukan class konkret.
// ============================================================
public class LaporanBanding implements IMengajukanLaporan, ITampilLaporan {

    private int idLaporanBanding;
    private LocalDate tanggalLaporan;
    private String deskripsi;
    private int idMasyarakat;
    private JenisPencemaran jenisPencemaran;
    private StatusLaporan statusLaporan;
    private TingkatPencemaran tingkatPencemaran;

    // O — enum sebagai parameter, bukan String + if-else
    @Override
    public void mengajukan(
            String deskripsi,
            JenisPencemaran jenis,
            StatusLaporan status,
            TingkatPencemaran tingkat,
            int idMasyarakat) {

        this.idLaporanBanding = 1; // bisa dibuat auto-increment serupa Laporan
        this.idMasyarakat     = idMasyarakat;
        this.tanggalLaporan   = LocalDate.now();
        this.deskripsi        = deskripsi;
        this.jenisPencemaran  = jenis;
        this.statusLaporan    = status;
        this.tingkatPencemaran = tingkat;
    }

    @Override
    public void tampilLaporan() {
        System.out.println("\n=== Detail Laporan Banding ===");
        System.out.println("Id Laporan Banding : " + idLaporanBanding);
        System.out.println("Id Masyarakat      : " + idMasyarakat);
        System.out.println("Tanggal Laporan    : " + tanggalLaporan);
        System.out.println("Deskripsi          : " + deskripsi);
        System.out.println("Jenis Pencemaran   : " + jenisPencemaran);
        System.out.println("Status Laporan     : " + statusLaporan);
        System.out.println("Tingkat Pencemaran : " + tingkatPencemaran);
    }
}
