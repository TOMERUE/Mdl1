import java.util.*;

public class main_mdl2_codelab {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<mhs_mdl2> daftarmahasiswa = new ArrayList<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Data Mahasiswa");
            System.out.println("2. Tampilkan Data Mahasiswa");
            System.out.println("3. Keluar");
            System.out.print("Pilihan Anda: ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    scanner.nextLine(); // Consume newline character
                    System.out.print("Masukkan nama mahasiswa: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan NIM mahasiswa: ");
                    String nim = scanner.nextLine();
                    while (nim.length() != 15) {
                        System.out.println("NIM Harus 15 Digit!!!");
                        System.out.print("Masukkan NIM mahasiswa: ");
                        nim = scanner.nextLine();
                    }
                    System.out.print("Masukkan jurusan mahasiswa: ");
                    String jurusan = scanner.nextLine();
                    mhs_mdl2 mahasiswa1 = new mhs_mdl2(nama, nim, jurusan);
                    daftarmahasiswa.add(mahasiswa1);
                    System.out.println("Data mahasiswa berhasil ditambahkan.");
                    break;
                case 2:
                    mhs_mdl2.tampiluniversitas();
                    System.out.println("Data Mahasiswa:");
                    for (mhs_mdl2 mhs : daftarmahasiswa) {
                        mhs.tampildatamahasiswa();
                    }
                    break;
                case 3:
                    System.out.println("Adios / Selamat tinggal");
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih 1, 2, atau 3.");
            }
        }
    }
}
