package packageAsistensi7;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Random;

public class mainPerpus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Buku[] perpus = new Buku[10000];
        int x = 4;
        double jmlhHal = 750;
        double halFiksi = 0;
        double halNonFiksi = 0;
        double ab = 0;
        double abc = 0;
        double abcd = 0;
        Random rand = new Random();
        int Fiksi = 0;
        int nonFiksi = 0;
        
        for (int i = 0; i < perpus.length; i++) {
            int peluang = rand.nextInt(2) + 1;
            if (peluang == 1) {
                perpus[i] = new Fiksi();
            }
            if (peluang == 2) {
                perpus[i] = new nonFiksi();
            }
        }
        
        for (int i = 0; i < 3; i++) {
            int peluang = rand.nextInt(2) + 1;
            if (peluang == 1) {
                perpus[i] = new Buku("Intro", "Sam", "Fiksi", 350);
                Fiksi += 1;
                halFiksi += 200;
            }
            if (peluang == 2) {
                perpus[i] = new Buku("Intro", "Sam", "Non-Fiksi", 350);
                nonFiksi += 1;
                halNonFiksi += 200;
            }
        }
        
        int pil = 1;
        do {
            pembatas();
            header("Perpus.txt");
            System.out.println("");
            pembatas();
            System.out.println("Data buku sementara : ");
                for (int i = 0; i < x; i++) {
                    System.out.println("[" + (i + 1) + "] " + perpus[i].getJudul() + "\t| " + perpus[i].getPengarang());
                }
            pembatas();
            System.out.println("Silahkan pilih : \n[1]. Input buku baru\n" + "[2]. Modifikasi detail buku\n" + "[3]. Hapus buku\n" + "[0]. Keluar");
            pembatas();

            double rata = jmlhHal / x;
            for (int i = 0; i < x; i++) {
                ab = Math.pow((perpus[i].getHalaman() - rata), 2);
            }

            double rataf = halFiksi / Fiksi;
            double ratanf = halNonFiksi / nonFiksi;
            for (int i = 0; i < x; i++) {
                if ("fiksi".equals(perpus[i].getJenis())) {
                    abc = Math.pow((perpus[i].getHalaman() - rataf), 2);
                } else {
                    abcd = Math.pow((perpus[i].getHalaman() - ratanf), 2);
                }
            }
            
            System.out.println("Jumlah buku di dalam perpustakaan: " + x + "\nRata-rata halaman buku dalam perpustakaan: " + rata + "\nStandar deviasi halaman buku dalam perpustakaan: " + Math.sqrt(ab / x));
            pembatas();
            System.out.println("Jumlah Buku Fiksi dalam perpustakaan: " + Fiksi + "\nRata-rata halaman Buku Fiksi dalam perpustakaan: " + rataf + "\nStandar deviasi halaman Buku Fiksi dalam perpustakaan: " + Math.sqrt(abc / Fiksi));
            pembatas();
            System.out.println("Jumlah Buku Non-Fiksi dalam perpustakaan : " + nonFiksi + "\nRata-rata halaman Buku Non Fiksi dalam perpustakaan: " + ratanf + "\nStandar deviasi halaman Buku Non Fiksi dalam perpustakaan: " + Math.sqrt(abcd / nonFiksi));
            pembatas();

            int pilihan = input.nextInt();
            if (pilihan == 1) {
                pembatas();
                header("NewBook.txt");
                System.out.println("");
                pembatas();
                x += 1;

                System.out.print("input judul buku : \n> ");
                String judul = input.next();
                perpus[x - 1].setJudul(judul);
                System.out.print("input pengarang buku : \n> ");
                String pengarang = input.next();
                perpus[x - 1].setPengarang(pengarang);
                System.out.print("input jumlah halaman buku : \n> ");
                int halaman = input.nextInt();
                perpus[x - 1].setHalaman(halaman);

                int peluang = rand.nextInt(2) + 1;
                if (peluang == 1) {
                    perpus[x - 1] = new Buku(judul, pengarang, "fiksi", halaman);
                    Fiksi += 1;
                    halFiksi += halaman;
                }
                if (peluang == 2) {
                    perpus[x - 1] = new Buku(judul, pengarang, "nonfiksi", halaman);
                    nonFiksi += 1;
                    halNonFiksi += halaman;
                }
            } else if (pilihan == 2) {
                pembatas();
                header("ChangeBook.txt");
                System.out.println("");
                pembatas();
                System.out.println("Pilih buku yang akan diubah : ");
                for (int i = 0; i < x; i++) {
                    System.out.println("[" + (i + 1) + "] " + perpus[i].getJudul() + "\t| " + perpus[i].getPengarang());
                }
                int ubahbuku = input.nextInt();
                System.out.print("input judul buku : \n> ");
                String judul = input.next();
                perpus[ubahbuku - 1].setJudul(judul);
                System.out.print("input pengarang buku : \n> ");
                String pengarang = input.next();
                perpus[ubahbuku - 1].setPengarang(pengarang);

                int halamann = perpus[ubahbuku - 1].getHalaman();
                System.out.print("input jumlah halaman buku : \n> ");
                int halaman = input.nextInt();
                perpus[ubahbuku - 1].setHalaman(halaman);
                jmlhHal = jmlhHal - halamann + halaman;
                if (perpus[ubahbuku - 1].getJenis() == "fiksi") {
                    halFiksi = halFiksi - halaman + perpus[ubahbuku].getHalaman();
                } else {
                    halNonFiksi = halNonFiksi - halamann + perpus[ubahbuku].getHalaman();
                }
            } else if (pilihan == 3) {
                pembatas();
                header("DeleteBook.txt");
                System.out.println("");
                pembatas();
                System.out.println("Pilih buku yang akan dihapus : ");
                for (int i = 0; i < x; i++) {
                    System.out.println("[" + (i + 1) + "] " + perpus[i].getJudul() + "\t| " + perpus[i].getPengarang());
                }
                int hapusbuku = input.nextInt();
                for (int i = hapusbuku; i < x; i++) {
                    perpus[i - 1] = perpus[i];
                }

                jmlhHal -= perpus[hapusbuku].getHalaman();
                x -= 1;
                if (perpus[hapusbuku].getJenis() == "fiksi") {
                    Fiksi -= 1;
                    halFiksi -= perpus[hapusbuku].getHalaman();
                } else {
                    nonFiksi -= 1;
                    halNonFiksi -= perpus[hapusbuku].getHalaman();
                }
            } else {
                pil = 0;
            }
        } while (pil != 0);

        String path = "data.txt";
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("PERPUSTAKAAN");
            bw.newLine();
            bw.newLine();
            for (int i = 0; i < x; i++) {
                int a = i + 1;
                bw.write("Buku ke : [" + Integer.toString(a) + "]");
                bw.newLine();
                bw.write("Judul : " + perpus[i].getJudul());
                bw.newLine();
                bw.write("Pengarang : " + perpus[i].getPengarang());
                bw.newLine();
                bw.write("Jumlah Halaman : " + Integer.toString(perpus[i].getHalaman()));
                bw.newLine();
                bw.write("Jenis Buku : " + perpus[i].getJenis());
                bw.newLine();
                bw.newLine();
            }
            bw.close();

        } catch (Exception e) {
        }
    }

    public static void header(String PERPUSTAKAAN) {
        File file = new File(PERPUSTAKAAN);
        String encoding = "utf-8";
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(file), encoding)) {
            int data = isr.read();
            while (data != -1) {
                System.out.print((char) data);
                data = isr.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void pembatas() {
        System.out.println("====================================================================================");
            
            
    }
}

