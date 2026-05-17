// ============================================================
// CLASS: Main
// SOLID:
//   D (Dependency Inversion) — Main bergantung pada interface
//     (IMengajukanLaporan, ITampilLaporan, ITolakLaporan) dan
//     Factory, bukan class konkret secara langsung.
//     Jika implementasi berubah, Main tidak perlu diubah.
// ============================================================
// public class Main {
//     public static void main(String[] args) {

//         // --- Setup Data Masyarakat ---
//         // S: Masyarakat hanya mengurus profil pengguna
//         Masyarakat masyarakat1 = new Masyarakat();
//         masyarakat1.setId(1);
//         masyarakat1.setNama("Budi");
//         masyarakat1.setEmail("budi@budi.com");
//         masyarakat1.setAlamat("Jl. Raya No. 123");
//         masyarakat1.setStatusAkun(true);
//         masyarakat1.setPassword("password123");

//         Masyarakat masyarakat2 = new Masyarakat();
//         masyarakat2.setId(2);
//         masyarakat2.setNama("Bangkit");
//         masyarakat2.setEmail("bangkit@mail.com");
//         masyarakat2.setAlamat("Jl. Raya No. 456");
//         masyarakat2.setStatusAkun(true);
//         masyarakat2.setPassword("password123");

//         Masyarakat masyarakat3 = new Masyarakat();
//         masyarakat3.setId(3);
//         masyarakat3.setNama("Caca");
//         masyarakat3.setEmail("caca@caca.com");
//         masyarakat3.setAlamat("Jl. Raya No. 789");
//         masyarakat3.setStatusAkun(true);
//         masyarakat3.setPassword("password123");

//         // D — Main bergantung pada LaporanFactory, bukan "new Laporan()" langsung
//         // D — tipe variabel adalah interface, bukan class konkret
//         IMengajukanLaporan laporan1 = LaporanFactory.buatLaporan();
//         IMengajukanLaporan laporan2 = LaporanFactory.buatLaporanBanding();
//         LaporanDitolak     laporan3 = LaporanFactory.buatLaporanDitolak();

//         // O — Gunakan enum, bukan String. Tidak ada risiko typo atau bug "=="
//         laporan1.mengajukan(
//             "Laporan Pencemaran Air",
//             JenisPencemaran.AIR,
//             StatusLaporan.SELESAI,
//             TingkatPencemaran.RINGAN,
//             masyarakat1.getId()
//         );

//         laporan2.mengajukan(
//             "Laporan Pencemaran Tanah",
//             JenisPencemaran.TANAH,
//             StatusLaporan.SELESAI,
//             TingkatPencemaran.SEDANG,
//             masyarakat2.getId()
//         );

//         laporan3.mengajukan(
//             "Laporan Pencemaran Air",
//             JenisPencemaran.AIR,
//             StatusLaporan.BELUM,
//             TingkatPencemaran.RINGAN,
//             masyarakat3.getId()
//         );

//         // --- Tampil Laporan 1 ---
//         masyarakat1.tampilkanProfil();
//         ((ITampilLaporan) laporan1).tampilLaporan(); //  D — cast ke interface

//         // --- Tampil Laporan 2 ---
//         masyarakat2.tampilkanProfil();
//         ((ITampilLaporan) laporan2).tampilLaporan();

//         // --- Tolak dan tampil Laporan 3 ---
//         masyarakat3.tampilkanProfil();
//         laporan3.tolakLaporan("Data tidak lengkap");  // I — method tolak hanya ada di ITolakLaporan
//         laporan3.tampilLaporan();                      // L — LaporanDitolak tetap bisa tampilLaporan
//     }
// }
// public class Main {
//     public static void main(String[] args) {

//         // Menggunakan Factory untuk membuat objek laporan sesuai kode asli Anda
//         IMengajukanLaporan laporan1 = LaporanFactory.buatLaporan();
//         IMengajukanLaporan laporan2 = LaporanFactory.buatLaporanBanding();

//         // === TAHAP 3: IMPLEMENTASI EXCEPTION HANDLING ===
//         try {
//             // 1. Pengujian Kasus Normal (Lolos Validasi)
//             System.out.println("--- Mencoba Mengajukan Laporan Normal ---");
//             laporan1.mengajukan(
//                 "Laporan Pencemaran Air di Sungai Madiun",
//                 JenisPencemaran.AIR,
//                 StatusLaporan.SELESAI,
//                 TingkatPencemaran.RINGAN,
//                 1 // ID Masyarakat langsung dimasukkan angka 1 (Valid)
//             );
//             System.out.println("Laporan 1 berhasil diajukan.");

//             // 2. TAHAP 1: SIMULASI ERROR DATA EKSTREM (Memicu Exception)
//             System.out.println("\n--- Melakukan Pengujian Ekstrem (Deskripsi Kosong) ---");
//             laporan2.mengajukan(
//                 "", // Data ekstrem sengaja dikosongkan untuk memicu error validasi
//                 JenisPencemaran.TANAH,
//                 StatusLaporan.BELUM,
//                 TingkatPencemaran.SEDANG,
//                 2 // ID Masyarakat 2
//             );

//         } catch (ValidasiLaporanException e) {
//             // Menampilkan User-Friendly Error Message agar aplikasi tidak crash
//             System.out.println("\n[ERROR SISTEM]: " + e.getMessage());
//         } finally {
//             // Blok finally yang selalu dieksekusi (Persyaratan Tahap 3)
//             System.out.println("\n[FINALLY]: Sesi pemeriksaan keamanan form pengajuan selesai.");
//         }

//         // Tampilkan data laporan yang sukses masuk saja
//         System.out.println("\n=== Log Data Laporan di Sistem ===");
//         ((ITampilLaporan) laporan1).tampilLaporan();
//     }
// }

// public class Main {
//     public static void main(String[] args) {

//         // --- Setup Data Masyarakat Asli Anda ---
//         Masyarakat masyarakat1 = new Masyarakat();
//         masyarakat1.setId(1);
//         masyarakat1.setNama("Budi");
//         masyarakat1.setEmail("budi@budi.com");
//         masyarakat1.setAlamat("Jl. Raya No. 123");
//         masyarakat1.setStatusAkun(true);
//         masyarakat1.setPassword("password123");

//         Masyarakat masyarakat2 = new Masyarakat();
//         masyarakat2.setId(-99);
//         masyarakat2.setNama("Budi");
//         masyarakat2.setEmail("budi@budi.com");
//         masyarakat2.setAlamat("Jl. Raya No. 123");
//         masyarakat2.setStatusAkun(true);
//         masyarakat2.setPassword("password123");

//         IMengajukanLaporan laporan1 = LaporanFactory.buatLaporan();
//         IMengajukanLaporan laporan2 = LaporanFactory.buatLaporanBanding();

//         // === TAHAP 3: IMPLEMENTASI EXCEPTION HANDLING ===
//         try {
//             // 1. Kasus Normal (Sukses lolos validasi)
//             laporan1.mengajukan(
//                 "Laporan Pencemaran Air di Sungai Madiun",
//                 JenisPencemaran.AIR,
//                 StatusLaporan.SELESAI,
//                 TingkatPencemaran.RINGAN,
//                 masyarakat1.getId()
//             );

//             // 2. Simulasi Data Ekstrem Kosong (Sengaja diganti "" untuk memicu error)
//             System.out.println("--- Validasi jika user tidak mengisi deskripsi ---");
//             laporan2.mengajukan(
//                 "", // <--- Ini akan memicu ValidasiLaporanException!
//                 JenisPencemaran.TANAH,
//                 StatusLaporan.BELUM,
//                 TingkatPencemaran.SEDANG,
//                 masyarakat2.getId()
//             );

//         } catch (ValidasiLaporanException e) {
//             // MENAMPILKAN PESAN ERROR YANG RAMAH PENGGUNA (User-Friendly Message)
//             System.out.println("\n[SISTEM MENOLAK]: " + e.getMessage());
//         } finally {
//             // Blok yang selalu dieksekusi baik ada error maupun tidak
//             System.out.println("[FINALLY]: Sesi pengecekan validasi form selesai.");
//         }

//         System.out.println("\n--- Cetak Log Data Sukses ---");
//         ((ITampilLaporan) laporan1).tampilLaporan();
//     }
// }

public class Main {
    public static void main(String[] args) {

        // --- Setup Data Objek Masyarakat (Menggunakan Main yang Lama) ---
        Masyarakat masyarakat1 = new Masyarakat();
        masyarakat1.setId(1);
        masyarakat1.setNama("Budi");
        masyarakat1.setEmail("budi@budi.com");
        masyarakat1.setAlamat("Jl. Raya No. 123");
        masyarakat1.setStatusAkun(true);
        masyarakat1.setPassword("password123");

        IMengajukanLaporan laporan1 = LaporanFactory.buatLaporan();
        IMengajukanLaporan laporan2 = LaporanFactory.buatLaporanBanding();

        // === TAHAP 3: EXCEPTION HANDLING ===
        try {

            laporan1.mengajukan(
                    "Laporan Pencemaran Air di Sungai Madiun",
                    JenisPencemaran.AIR,
                    StatusLaporan.SELESAI,
                    TingkatPencemaran.RINGAN,
                    masyarakat1.getId());

            System.out.println("--- Melakukan Pengujian Ekstrem (Deskripsi Kosong) ---");
            laporan2.mengajukan(
                    "", // Memicu ValidasiLaporanException
                    JenisPencemaran.TANAH,
                    StatusLaporan.BELUM,
                    TingkatPencemaran.SEDANG,
                    masyarakat1.getId());

        } catch (ValidasiLaporanException e) {
            System.out.println("\n[ERROR SISTEM]: " + e.getMessage());
        } finally {
            System.out.println("\n[FINALLY]: Sesi pemeriksaan selesai.");
        }

        System.out.println("\n=== Log Data Laporan di Sistem ===");
        ((ITampilLaporan) laporan1).tampilLaporan();
    }
}