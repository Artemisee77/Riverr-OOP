public class ConsoleDisplay implements IDisplay {
    @Override
    public void cetakAdmin(Admin admin) {
        System.out.println("\n=== DATA ADMIN ===");
        System.out.println("ID Admin   : " + admin.getid());
        System.out.println("Nama       : " + admin.getNama());
        System.out.println("Status     : " + admin.getStatusAkun());
    }

    @Override
    public void cetakTindakLanjut(Tindaklanjut tl) {
        System.out.println("\n=== DATA TINDAK LANJUT ===");
        System.out.println("ID Tindak  : " + tl.getIdTindakLanjut());
        System.out.println("Detail     : " + tl.getDetailTindakLanjut());
        System.out.println("Bukti      : " + tl.getBukti());
        // Mengambil nama admin dari objek admin yang tersimpan di Tindaklanjut
        if (tl.getAdminEksekutor() != null) {
            System.out.println("Oleh Admin : " + tl.getAdminEksekutor().getNama());
        }
    }
}