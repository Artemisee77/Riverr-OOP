import java.time.LocalDate;

// ============================================================
// CLASS: Laporan
// Tujuan: Menyimpan data dan logika laporan pencemaran biasa.
// SOLID:
//   S (Single Responsibility) — class ini HANYA mengurus
//     data laporan. Tidak extend Masyarakat, tidak tolak
//     laporan. Satu class, satu tanggung jawab.
//
//   O (Open/Closed) — menggunakan enum langsung sebagai
//     parameter (JenisPencemaran, StatusLaporan, dll).
//     Tidak ada if-else String. Menambah jenis baru cukup
//     tambah nilai di enum, class ini tidak perlu disentuh.
//
//   L (Liskov Substitution) — class ini tidak lagi extend
//     Masyarakat secara tidak tepat. LaporanDitolak bisa
//     menggantikan Laporan dengan aman (lihat LaporanDitolak).
//
//   D (Dependency Inversion) — bergantung pada interface
//     IMengajukanLaporan & ITampilLaporan, bukan class konkret.
// ============================================================
public class Laporan implements IMengajukanLaporan, ITampilLaporan {

    private int idLaporan;
    public static int maxIdLaporan = 0;

    private LocalDate tanggalLaporan;
    private String deskripsi;
    private int idMasyarakat;
    private JenisPencemaran jenisPencemaran;
    private StatusLaporan statusLaporan;
    private TingkatPencemaran tingkatPencemaran;

    // O — Pakai enum langsung, tidak ada if-else String lagi.
    //        Tidak perlu khawatir bug "==" vs ".equals()" untuk String.
    @Override
    public void mengajukan(
            String deskripsi,
            JenisPencemaran jenis,
            StatusLaporan status,
            TingkatPencemaran tingkat,
            int idMasyarakat) {

        // ✅ VALIDASI DATA TERPUSAT — Tahap 4
        if (deskripsi == null || deskripsi.isBlank()) {
            System.out.println("[VALIDASI] Gagal: Deskripsi tidak boleh kosong.");
            return;
        }
        if (idMasyarakat <= 0) {
            System.out.println("[VALIDASI] Gagal: ID masyarakat tidak valid.");
            return;
        }
        if (jenis == null) {
            System.out.println("[VALIDASI] Gagal: Jenis pencemaran tidak boleh kosong.");
            return;
        }

        maxIdLaporan++;
        this.idLaporan       = maxIdLaporan;
        this.idMasyarakat    = idMasyarakat;
        this.tanggalLaporan  = LocalDate.now();
        this.deskripsi       = deskripsi;
        this.jenisPencemaran = jenis;
        this.statusLaporan   = status;
        this.tingkatPencemaran = tingkat;
        System.out.println("[INFO] Laporan berhasil diajukan.");
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
    protected int getIdLaporan()              { return idLaporan; }
    protected int getIdMasyarakat()           { return idMasyarakat; }
    protected LocalDate getTanggalLaporan()   { return tanggalLaporan; }
    protected String getDeskripsi()           { return deskripsi; }
    protected JenisPencemaran getJenis()      { return jenisPencemaran; }
    protected StatusLaporan getStatus()       { return statusLaporan; }
    protected TingkatPencemaran getTingkat()  { return tingkatPencemaran; }

    // Setter status untuk dipakai subclass
    protected void setStatusLaporan(StatusLaporan status) {
        this.statusLaporan = status;
    }
}
