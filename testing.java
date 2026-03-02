public class testing {
    public static void main(String[] args) {
        
        // Membuat objek dari class turunan
        TitikPantau pantau1 = new TitikPantau();
        
        // Menggunakan method yang DIWARISKAN dari class Sungai
        pantau1.setIdSungai(10);
        pantau1.setNama("Sungai Brantas");
        pantau1.setWilayah("Jawa Timur");
        
        // Mengisi atribut spesifik dari class TitikPantau
        pantau1.lokasiDetail = "Jembatan Merah";
        pantau1.statusKualitas = "Tercemar Ringan";
        
        System.out.println("=== DATA TITIK PANTAU ===");
        // Memanggil method dari class induk (Sungai)
        pantau1.tampilkanInfo(); 
        // Memanggil method dari class anak (TitikPantau)
        pantau1.tampilkanDataPantau(); 
    }
}