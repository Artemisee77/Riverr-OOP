// ============================================================
// CLASS: LaporanDitolak
// Tujuan: Laporan yang ditolak — extend Laporan dan tambah
//         kemampuan menolak.
// SOLID:
//   S (Single Responsibility) — class ini HANYA menambah
//     logika penolakan. Data laporan diurus oleh Laporan.
//
//   L (Liskov Substitution) — LaporanDitolak adalah Laporan
//     yang diperluas. Di mana pun Laporan dipakai, LaporanDitolak
//     bisa menggantikannya tanpa merusak program. Semua method
//     Laporan tetap berjalan normal.
//
//   I (Interface Segregation) — implement ITolakLaporan secara
//     terpisah. Tidak dipaksa lewat "IPenolakLaporan extends ILaporan"
//     seperti sebelumnya.
// ============================================================
public class LaporanDitolak extends Laporan implements ITolakLaporan {

    private String alasanPenolakan;

    //  L — Semua method Laporan tetap bisa dipakai.
    //        Hanya method baru yang ditambahkan di sini.
    @Override
    public void tolakLaporan() {
        this.setStatusLaporan(StatusLaporan.DITOLAK);
        System.out.println("Laporan #" + getIdLaporan() + " telah ditolak.");
    }

    public void tolakLaporan(String alasan) {
        this.alasanPenolakan = alasan;
        this.setStatusLaporan(StatusLaporan.DITOLAK);
        System.out.println("Laporan #" + getIdLaporan() + " ditolak. Alasan: " + alasan);
    }

    @Override
    public void tampilLaporan() {
        super.tampilLaporan(); // ✅ L — panggil method parent, lalu tambah
        if (alasanPenolakan != null) {
            System.out.println("Alasan Penolakan   : " + alasanPenolakan);
        }
    }
}
