public class Main {
    public static void main(String[] args) {
        // Membuat objek dengan constructor (lebih ringkas)
        Sungai s1 = new Sungai(1, "Brantas", "Jawa Timur");
        
        // Polymorphism: Objek bertipe Sungai tapi instansinya TitikPantau
        Sungai p1 = new TitikPantau(10, "Brantas", "Jawa Timur", "Jembatan Merah", "Tercemar Ringan");

        System.out.println("=== INFO SUNGAI UMUM ===");
        s1.tampilkanInfo();
        System.out.println();

        System.out.println("=== INFO TITIK PANTAU (PBL) ===");
        // Di sini Polymorphism bekerja: p1 akan menjalankan tampilkanInfo versi TitikPantau
        p1.tampilkanInfo(); 
    }
}