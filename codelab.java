import java.util.ArrayList;
import java.util.Scanner;

public class codelab {
    public static void main(String[] args) {
        ArrayList<String> mahasiswa = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int i = 1;
        String nama_mahasiswa;
        while (true) {
            try {
                System.out.print("Masukkan nama mahasiswa " + i + "(ketik 'selesai' untuk berhenti): ");
                nama_mahasiswa = scanner.nextLine();

                if ("selesai".equalsIgnoreCase(nama_mahasiswa)) {
                    break;
                }
                if (nama_mahasiswa.isEmpty()) {
                    throw new IllegalArgumentException("Nama tidak boleh kosong");
                }
                i++;
                mahasiswa.add(nama_mahasiswa);

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        for (String data : mahasiswa){
            System.out.println(data);
        }
    }

}
