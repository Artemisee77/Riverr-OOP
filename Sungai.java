public class Sungai {
    // Single Responsibility: Class ini hanya urusan data sungai umum
    // Encapsulation: Mengubah public ke private agar data aman
    private int idSungai;
    private String nama;
    private String wilayah;

    // Constructor untuk inisialisasi data lebih cepat
    public Sungai(int id, String nama, String wilayah) {
        this.idSungai = id;
        this.nama = nama;
        this.wilayah = wilayah;
    }

    // Getter dan Setter (Pintu akses resmi)
    public int getIdSungai() { return idSungai; }
    public void setIdSungai(int id) { this.idSungai = id; }

    public String getNama() { return nama; }
    public void setNama(String n) { this.nama = n; }

    public String getWilayah() { return wilayah; }
    public void setWilayah(String w) { this.wilayah = w; }

    public void tampilkanInfo() {
        System.out.println("ID Sungai: " + idSungai);
        System.out.println("Nama: " + nama);
        System.out.println("Wilayah: " + wilayah);
    }
}