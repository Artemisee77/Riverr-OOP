public class LaporanFactory {

    // D — kembalikan tipe interface, bukan class konkret
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
