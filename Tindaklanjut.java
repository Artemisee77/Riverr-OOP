public class Tindaklanjut extends Admin {
    private int idTindakLanjut;
    public static int jumlahtindaklanjut = 0;
    private String detailTindakLanjut;
    private String bukti;

    public void melakukan(String detailTindakLanjut, String bukti) {
        jumlahtindaklanjut++;
        idTindakLanjut = jumlahtindaklanjut;
        this.detailTindakLanjut = detailTindakLanjut;
        this.bukti = bukti;


    }

    @Override
    public void tampilkan(){
        System.out.println("\n idTindakLanjut : " + idTindakLanjut);
        System.out.println("detailTindakLanjut : " + detailTindakLanjut);
        System.out.println("bukti : " + bukti);
    }
}
 