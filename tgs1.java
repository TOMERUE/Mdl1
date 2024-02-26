
public class tgs1 {
    private static final String ADMIN_USERNAME = "admin";
    private static final String ADMIN_PASSWORD = "admin123";
    private static final int MAX_NIM_LENGTH = 15;

    public static boolean mahasiswaLogin(String nim) {
        return nim.length() == MAX_NIM_LENGTH;
    }

    public static boolean adminLogin(String username, String password) {
        return username.equals(ADMIN_USERNAME) && password.equals(ADMIN_PASSWORD);
    }

    public static void main(String[] args) {
        // Contoh penggunaan sistem login
        String mahasiswaNIM = "123456789012345";
        if (mahasiswaLogin(mahasiswaNIM)) {
            System.out.println("Login Mahasiswa Berhasil");
        } else {
            System.out.println("Login Mahasiswa Gagal");
        }

        String adminUsername = "admin";
        String adminPassword = "admin123";
        if (adminLogin(adminUsername, adminPassword)) {
            System.out.println("Login Admin Berhasil");
        } else {
            System.out.println("Login Admin Gagal");
        }
    }
}
