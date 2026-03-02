public class TitikPantau extends Sungai {
    
    // Atribut tambahan khusus untuk Titik Pantau
    public String lokasiDetail;
    public String statusKualitas;

    // Method tambahan untuk menampilkan data spesifik
    public void tampilkanDataPantau() {
        System.out.println("Lokasi Detail: " + lokasiDetail);
        System.out.println("Status Kualitas: " + statusKualitas);
        System.out.println("---");
    }
}