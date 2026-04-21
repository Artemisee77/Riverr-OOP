public class TitikPantau extends Sungai {
    private String lokasiDetail;
    private String statusKualitas;

    public TitikPantau(int id, String nama, String wilayah, String lokasi, String status) {
        // INI PERBAIKANNYA: Kirim 3 data ke class Sungai
        super(id, nama, wilayah); 
        this.lokasiDetail = lokasi;
        this.statusKualitas = status;
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo(); 
        System.out.println("Lokasi Detail: " + lokasiDetail);
        System.out.println("Status Kualitas: " + statusKualitas);
        System.out.println("---");
    }
}