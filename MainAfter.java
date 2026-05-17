import java.util.Scanner;

public class MainAfter {
    public static void main(String[] args) {

        Masyarakat masyarakat1 = new Masyarakat();
        masyarakat1.setId(1);
        masyarakat1.setNama("Budi");
        masyarakat1.setEmail("budi@budi.com");
        masyarakat1.setAlamat("Jl. Raya No. 123");
        masyarakat1.setStatusAkun(true);
        masyarakat1.setPassword("password123");

        Masyarakat masyarakat2 = new Masyarakat();
        masyarakat2.setId(2);
        masyarakat2.setNama("Bangkit");
        masyarakat2.setEmail("bangkit@mail.com");
        masyarakat2.setAlamat("Jl. Raya No. 456");
        masyarakat2.setStatusAkun(true);
        masyarakat2.setPassword("password123");

        Masyarakat masyarakat3 = new Masyarakat();
        masyarakat3.setId(3);
        masyarakat3.setNama("Caca");
        masyarakat3.setEmail("caca@caca.com");
        masyarakat3.setAlamat("Jl. Raya No. 789");
        masyarakat3.setStatusAkun(true);
        masyarakat3.setPassword("password123");

        IMengajukanLaporan laporan1 = LaporanFactory.buatLaporan();
        IMengajukanLaporan laporan2 = LaporanFactory.buatLaporanBanding();
        LaporanDitolak laporan3 = LaporanFactory.buatLaporanDitolak();

        // ============================================================
        // FIX BUG 1: try-catch NumberFormatException
        // ============================================================
        Scanner scanner = new Scanner(System.in);
        int idInput = masyarakat1.getId(); // default fallback

        try {
            System.out.print("Masukkan ID Masyarakat (angka): ");
            String inputId = scanner.nextLine();
            idInput = Integer.parseInt(inputId); // dicoba parse
            System.out.println("[INFO] ID valid: " + idInput);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] Input harus berupa angka! Menggunakan ID default: " + idInput);
        } finally {
            System.out.println("[LOG] Proses input ID selesai.");
        }

        scanner.close();

        laporan1.mengajukan(
            "Laporan Pencemaran Air",
            JenisPencemaran.AIR,
            StatusLaporan.SELESAI,
            TingkatPencemaran.RINGAN,
            idInput
        );

        laporan2.mengajukan(
            "Laporan Pencemaran Tanah",
            JenisPencemaran.TANAH,
            StatusLaporan.SELESAI,
            TingkatPencemaran.SEDANG,
            masyarakat2.getId()
        );

        laporan3.mengajukan(
            "Laporan Pencemaran Air",
            JenisPencemaran.AIR,
            StatusLaporan.BELUM,
            TingkatPencemaran.RINGAN,
            masyarakat3.getId()
        );

        // ============================================================
        // FIX BUG 2: try-catch ClassCastException + instanceof check
        // ============================================================
        masyarakat1.tampilkanProfil();
        try {
            if (laporan1 instanceof ITampilLaporan) {
                ((ITampilLaporan) laporan1).tampilLaporan();
            } else {
                throw new ClassCastException("Objek tidak mengimplementasikan ITampilLaporan");
            }
        } catch (ClassCastException e) {
            System.out.println("[ERROR] Gagal menampilkan laporan: " + e.getMessage());
        } finally {
            System.out.println("[LOG] Proses tampil laporan 1 selesai.");
        }

        masyarakat2.tampilkanProfil();
        try {
            if (laporan2 instanceof ITampilLaporan) {
                ((ITampilLaporan) laporan2).tampilLaporan();
            } else {
                throw new ClassCastException("Objek tidak mengimplementasikan ITampilLaporan");
            }
        } catch (ClassCastException e) {
            System.out.println("[ERROR] Gagal menampilkan laporan: " + e.getMessage());
        } finally {
            System.out.println("[LOG] Proses tampil laporan 2 selesai.");
        }

        masyarakat3.tampilkanProfil();
        laporan3.tolakLaporan("Data tidak lengkap");
        laporan3.tampilLaporan();
    }
}