// ============================================================
// INTERFACE: ITampilLaporan
// Tujuan: Kontrak untuk menampilkan laporan.
// SOLID:
//   I (Interface Segregation) — dipisah dari IMengajukanLaporan
//     sehingga class yang hanya perlu tampil tidak dipaksa
//     implement mengajukan, dan sebaliknya.
// ============================================================
// ITampillaporan polymorphism method tampilanlaporan untuk di reuse di clas lain

public interface ITampilLaporan {
    void tampilLaporan();
}
