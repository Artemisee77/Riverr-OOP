import java.time.LocalDate;

public class Laporan implements IMengajukanLaporan, ITampilLaporan {

    private int idLaporan;
    public static int maxIdLaporan = 0;

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

        maxIdLaporan++;
        this.idLaporan = maxIdLaporan;
        this.idMasyarakat = idMasyarakat;
        this.tanggalLaporan = LocalDate.now();
        this.deskripsi = deskripsi;
        this.jenisPencemaran = jenis;
        this.statusLaporan = status;
        this.tingkatPencemaran = tingkat;
    }

    @Override
    public void tampilLaporan() {
        System.out.println("\n=== Detail Laporan ===");
        System.out.println("Id Laporan         : " + idLaporan);
        System.out.println("Id Masyarakat      : " + idMasyarakat);
        System.out.println("Tanggal Laporan    : " + tanggalLaporan);
        System.out.println("Deskripsi          : " + deskripsi);
        System.out.println("Jenis Pencemaran   : " + jenisPencemaran);
        System.out.println("Status Laporan     : " + statusLaporan);
        System.out.println("Tingkat Pencemaran : " + tingkatPencemaran);
        System.out.println("Total Laporan      : " + maxIdLaporan);
    }

    // Getter untuk subclass
    protected int getIdLaporan() {
        return idLaporan;
    }

    protected int getIdMasyarakat() {
        return idMasyarakat;
    }

    protected LocalDate getTanggalLaporan() {
        return tanggalLaporan;
    }

    protected String getDeskripsi() {
        return deskripsi;
    }

    protected JenisPencemaran getJenis() {
        return jenisPencemaran;
    }

    protected StatusLaporan getStatus() {
        return statusLaporan;
    }

    protected TingkatPencemaran getTingkat() {
        return tingkatPencemaran;
    }

    // Setter status untuk dipakai subclass
    protected void setStatusLaporan(StatusLaporan status) {
        this.statusLaporan = status;
    }
}
