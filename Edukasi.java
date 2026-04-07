

// ============================================================
// Edukasi.java — Main class (entry point)
// Prinsip SOLID: SRP — hanya bertugas menjalankan program
// Semua data diisi lewat SETTER, bukan akses field langsung
// ============================================================
public class Edukasi {
    public static void main(String[] args) {

        // Buat objek Masyarakat lewat constructor
        Masyarakat warga1 = new Masyarakat("M009", "Budi Santoso");
        Masyarakat warga2 = new Masyarakat("M009", "asiyah");

        // Buat objek EdukasiLingkungan
        EdukasiLingkungan eduLingkungan1 = new EdukasiLingkungan();
        EdukasiLingkungan eduLingkungan2 = new EdukasiLingkungan();


        // Isi data menggunakan SETTER
        eduLingkungan1.setIdEdukasi("EDS08");
        eduLingkungan1.setJudul("Sampah yang Menggunung");
        eduLingkungan1.setIsiPesan("Buanglah sampah pada tempatnya ya!");
        eduLingkungan1.setTanggalKirim("02-10-2026");
        eduLingkungan1.setIdAdmin("ADM93");
        eduLingkungan1.setDampak("Lingkungan bersih dan bebas banjir");

        eduLingkungan2.setIdEdukasi("EDS09");
        eduLingkungan2.setJudul("Sampah yang Menggunung");
        eduLingkungan2.setIsiPesan("Buanglah sampah pada tempatnya ya!");
        eduLingkungan2.setTanggalKirim("02-10-2026");
        eduLingkungan2.setIdAdmin("ADM99");
        eduLingkungan2.setDampak("Lingkungan bersih dan bebas banjir");

        // Kirim edukasi ke warga
        eduLingkungan1.kirimEdukasi(warga1);
        eduLingkungan2.kirimEdukasi(warga2);
    }
}