public interface IMengajukanLaporan {
    void mengajukan(
            String deskripsi,
            JenisPencemaran jenis,
            StatusLaporan status,
            TingkatPencemaran tingkat,
            int idMasyarakat) throws ValidasiLaporanException;
}
