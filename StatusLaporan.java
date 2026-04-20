// ============================================================
// ENUM: StatusLaporan
// Tujuan: Mendefinisikan status laporan yang valid.
// SOLID: Mendukung O (Open/Closed) — tidak ada if-else String
//        di class lain yang perlu diubah jika status bertambah.
// ============================================================
public enum StatusLaporan {
    BELUM,
    SEDANG,
    SELESAI,
    DITOLAK
}
