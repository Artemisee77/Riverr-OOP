import java.time.LocalDate;

public class laporan extends Masyarakat{
        private int idLaporan;
        public static int maxidlaporan = 0;
        private LocalDate tanggalLaporan;
        private String deskripsi;
        private int idMasyarakat;
        private enum enjenispencemaran{
            air,
            tanah
        }
        private enum enstatuslaporan{
            belum,
            sedang,
            selesai
        };
        private enum entingkatPencemaran{
            ringan,
            sedang,
            berat
        };

        private enjenispencemaran jenispencemaran;
        private enstatuslaporan statuslaporan;
        private entingkatPencemaran tingkatPencemaran;

    public void mengajukan(String deskripsi, String jenispencemaran, String statuslaporan, String tingkatPencemaran, int idMasyarakat) {
        
        maxidlaporan++;
        idLaporan = maxidlaporan;

        this.idMasyarakat = idMasyarakat;

        tanggalLaporan = LocalDate.now();
        this.deskripsi = deskripsi;
        if (jenispencemaran == "air") {
            this.jenispencemaran = enjenispencemaran.air;
        }
        else if (jenispencemaran == "tanah") {
            this.jenispencemaran = enjenispencemaran.tanah;
        }

        if (statuslaporan == "belum") {
            this.statuslaporan = enstatuslaporan.belum;
        }

        else if (statuslaporan == "sedang") {
            this.statuslaporan = enstatuslaporan.sedang;
        }

        else if (statuslaporan == "selesai") {
            this.statuslaporan = enstatuslaporan.selesai;
        }

        if (tingkatPencemaran == "ringan") {
            this.tingkatPencemaran = entingkatPencemaran.ringan;
        }

        else if (tingkatPencemaran == "sedang") {
            this.tingkatPencemaran = entingkatPencemaran.sedang;
        }

        else if (tingkatPencemaran == "berat") {
            this.tingkatPencemaran = entingkatPencemaran.berat;
        }
    }

    public void tampilLaporan() {

        System.out.println("\nId Laporan : " + idLaporan);
        System.out.println("Id Masyarakat : " + idMasyarakat);
        System.out.println("Tanggal Laporan : " + tanggalLaporan);
        System.out.println("Deskripsi : " + deskripsi);
        System.out.println("Jenis Pencemaran : " + jenispencemaran);
        System.out.println("Status Laporan : " + statuslaporan);
        System.out.println("Tingkat Pencemaran : " + tingkatPencemaran);
        System.out.println("maxid : " + maxidlaporan);
        
    }

    @Override
    public void TampilkanProfil() {

        System.out.println("DONEE");
        
    }

    
}

