public class Tindaklanjut {
    private int idTindakLanjut;
    public static int jumlahtindaklanjut = 0;
    private String detailTindakLanjut;
    private String bukti;

    private Admin adminEksekutor;
    public void setIdTindakLanjut(int idTindakLanjut) {
        this.idTindakLanjut = idTindakLanjut;
    }

    public int getIdTindakLanjut() {
        return idTindakLanjut;
    }

    public void setadmineksekutor(Admin adminEksekutor) {
        this.adminEksekutor = adminEksekutor;
    }

    public Admin getAdminEksekutor() {
        return adminEksekutor;
    }

    public void setDetailTindakLanjut(String detailTindakLanjut) {
        this.detailTindakLanjut = detailTindakLanjut;
    }

    public String getDetailTindakLanjut() {
        return detailTindakLanjut;
    }

    public void setBukti(String bukti) {
        this.bukti = bukti;
    }

    public String getBukti() {
        return bukti;
    }

    

    
    public void melakukan(String detailTindakLanjut, String bukti, Admin admin) {
        jumlahtindaklanjut++;
        idTindakLanjut = jumlahtindaklanjut;
        this.detailTindakLanjut = detailTindakLanjut;
        this.bukti = bukti;
        this.adminEksekutor = admin;


    }

  
    // public void tampilkan(){
    //     System.out.println("\nidTindakLanjut     : " + idTindakLanjut);
    //     System.out.println("detailTindakLanjut : " + detailTindakLanjut);
    //     System.out.println("bukti              : " + bukti);
        
    //     // Mengambil ID Admin melalui objek yang sudah disimpan
    //     if (adminEksekutor != null) {
    //         System.out.println("idAdmin (Eksekutor): " + adminEksekutor.getid());
    //     }
    // }
}
 
