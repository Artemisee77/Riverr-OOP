public class test {
    public static void main(String[] args) {
        
        Sungai sungai1 = new Sungai();
        sungai1.idSungai = 1;
        sungai1.nama = "Sungai Brantas";
        sungai1.wilayah = "Jawa Timur";
        
        System.out.println("Sungai pertama:");
        sungai1.tampilkanInfo();
        
        Sungai sungai2 = new Sungai();
        sungai2.setIdSungai(2);
        sungai2.setNama("Sungai Ciliwung");
        sungai2.setWilayah("Jakarta");
        
        System.out.println("Sungai kedua:");
        sungai2.tampilkanInfo();
        
        sungai1.nama = "Brantas";
        System.out.println("setelah diubah:");
        sungai1.tampilkanInfo();
    }
}