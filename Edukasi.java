package Edukasi;

class Masyarakat {
    public String idMasyarakat;
    public String nama;

    public Masyarakat(String id, String nama) {
        this.idMasyarakat = id;
        this.nama = nama;
    }
}

class DataEdukasi {
    public String idEdukasi;
    public String judul;
    public String isiPesan;
    public String tanggalKirim;
    public String idAdmin;

    public void infoDasar() {
        System.out.println("ID Edukasi      : " + idEdukasi);
        System.out.println("Judul           : " + judul);
    }
}

class EdukasiLingkungan extends DataEdukasi {
    public String dampak;

    public void kirimEdukasi(Masyarakat m) {
        infoDasar(); 
        System.out.println("Isi Pesan       : " + isiPesan);
        System.out.println("Dampak Positif  : " + dampak);
        System.out.println("Target Penerima : " + m.nama + " (" + m.idMasyarakat + ")");
        System.out.println("Tanggal Kirim   : " + tanggalKirim);
        System.out.println("Admin Pengirim  : " + idAdmin);
    }
}

public class Edukasi {
    public static void main(String[] args) {
        
        Masyarakat warga = new Masyarakat("M009", "Budi Santoso");
        EdukasiLingkungan eduLingkungan = new EdukasiLingkungan();
        
        eduLingkungan.idEdukasi = "EDS08";
        eduLingkungan.judul = "Sampah yang Menggunung";
        eduLingkungan.isiPesan = "Buanglah sampah pada tempatnya ya!";
        eduLingkungan.tanggalKirim = "02-10-2026";
        eduLingkungan.idAdmin = "ADM93";
        eduLingkungan.dampak = "Lingkungan bersih dan bebas banjir";

        eduLingkungan.kirimEdukasi(warga);
    }
}