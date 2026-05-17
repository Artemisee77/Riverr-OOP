import java.time.LocalDate;

public class LaporanBanding implements IMengajukanLaporan, ITampilLaporan {

    private int idLaporanBanding;
    private LocalDate tanggalLaporan;
    private String deskripsi;
    private int idMasyarakat;
    private JenisPencemaran jenisPencemaran;
    private StatusLaporan statusLaporan;
    private TingkatPencemaran tingkatPencemaran;

    @Override
    public void mengajukan(
            String deskripsi,
            JenisPencemaran jenis,
            StatusLaporan status,
            TingkatPencemaran tingkat,
            int idMasyarakat) throws ValidasiLaporanException {

        if (deskripsi == null || deskripsi.trim().isEmpty()) {
            throw new ValidasiLaporanException("Gagal Mengajukan: Deskripsi laporan tidak boleh kosong!");
        }

        if (idMasyarakat <= 0) {
            throw new ValidasiLaporanException("Gagal Mengajukan: ID Masyarakat tidak valid (harus > 0)!");
        }

        this.idLaporanBanding = 1;
        this.idMasyarakat = idMasyarakat;
        this.tanggalLaporan = LocalDate.now();
        this.deskripsi = deskripsi;
        this.jenisPencemaran = jenis;
        this.statusLaporan = status;
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
