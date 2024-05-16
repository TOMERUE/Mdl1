import java.util.ArrayList;
import java.util.Scanner;

public class codelab5 {
    public static void main(String[] args) {
        ArrayList<String> mahasiswa = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Masukkan nama mahasiswa (ketik 'selesai' untuk berhenti): ");
            String nama_mahasiswa = scanner.nextLine();

            if ("selesai".equalsIgnoreCase(nama_mahasiswa)) {
                break;
            }

            if (nama_mahasiswa.isEmpty()) {
                throw new IllegalArgumentException("Nama tidak boleh kosong");
            }

            mahasiswa.add(nama_mahasiswa);
        }

        try {
            for (int i = 0; i < mahasiswa.size(); i++) {
                String nama_mahasiswa = mahasiswa.get(i);
                if (nama_mahasiswa.isEmpty()) {
                    throw new IllegalArgumentException("Nama tidak boleh kosong");
                }
                System.out.println("Nama mahasiswa ke-" + (i + 1) + ": " + nama_mahasiswa);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
