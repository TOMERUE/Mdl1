import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;
import java.util.Date;

public class codelabm1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Date tanggal = new Date();

        System.out.print("Masukkan nama: ");
        String nama = input.nextLine();

        System.out.print("Masukkan jenis kelamin (P/L): ");
        String jenisKelamin = input.next();

        System.out.print("Masukkan tanggal lahir (yyyy-MM-dd): ");
        String tanggalLahirString = input.next();
        LocalDate tanggalLahir = LocalDate.parse(tanggalLahirString);

        String jenisKelaminLengkap = jenisKelamin.equalsIgnoreCase("P") ? "Perempuan" : "Laki-laki";

        LocalDate sekarang = LocalDate.now();
        Period selisih = Period.between(tanggalLahir, sekarang);

        System.out.println("\nData Diri:");
        System.out.println("Nama: " + nama);
        System.out.println("Jenis Kelamin: " + jenisKelaminLengkap);
        System.out.println("Umur: " + selisih.getYears() + " tahun " + selisih.getMonths() + " bulan");
        System.out.println("Per tanggal : " + tanggal);

        input.close();
    }
}
