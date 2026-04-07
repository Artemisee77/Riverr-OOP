
// ============================================================
// IKirimable.java — Interface
// Prinsip SOLID: OCP + LSP
// Kontrak bahwa setiap kelas edukasi WAJIB bisa kirimEdukasi()
// ============================================================
public interface IKirimable {
    void kirimEdukasi(Masyarakat penerima);
}