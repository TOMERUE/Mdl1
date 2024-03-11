public class mhs_mdl2 {
    private String nama;
    private String nim;
    private String jurusan;

    public mhs_mdl2(String nim, String nama, String jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
    }

    public void tampildatamahasiswa() {
        System.out.println("NIM: " + nim);
        System.out.println("Nama: " + nama);
        System.out.println("Jurusan: " + jurusan);

    }

    public static void tampiluniversitas() {
        System.out.println("Universitas Muhammadiyah Malang");
    }
}
