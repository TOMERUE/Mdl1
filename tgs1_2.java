public class tgs1_2 {
        public static void main(String[] args) {
            String adminUsername = "admin";
            String adminPassword = "admin123";
            String studentNIM = "123456789012345";

            loginAdmin(adminUsername, adminPassword);
            loginStudent(studentNIM);
        }

        public static void loginAdmin(String username, String password) {
            if (username.equals("admin") && password.equals("admin123")) {
                System.out.println("Admin login berhasil!");
            } else {
                System.out.println("Admin login gagal. Periksa kembali username dan password.");
            }
        }

        public static void loginStudent(String nim) {
            if (nim.length() == 15) {
                System.out.println("Mahasiswa login berhasil!");
            } else {
                System.out.println("Mahasiswa login gagal. Panjang NIM harus 15 karakter.");
            }
        }
    

}
