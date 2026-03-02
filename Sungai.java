public class Sungai {
    
    public int idSungai;
    public String nama;
    public String wilayah;
    
    public void setIdSungai(int id) {
        idSungai = id;
    }
    
    public void setNama(String n) {
        nama = n;
    }

    public void setWilayah(String w) {
        wilayah = w;
    }
    
    public void tampilkanInfo() {
        System.out.println("ID Sungai: " + idSungai);
        System.out.println("Nama: " + nama);
        System.out.println("Wilayah: " + wilayah);
        System.out.println("---");
    }
}