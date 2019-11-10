package packageAsistensi7;

public class Perpustakaan {
    
}

class Buku extends Perpustakaan {
    private String judul, pengarang, jenis;
    private int halaman;
    
    public Buku() {
        this.judul = "TIDAK ADA";
        this.pengarang = "TIDAK ADA";
        this.halaman = 0;
        this.jenis = "TIDAK ADA";
    }

    public Buku(String judul, String pengarang, String jenis, int halaman) {
        this.judul = judul;
        this.pengarang = pengarang;
        this.jenis = jenis;
        this.halaman = halaman;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getHalaman() {
        return halaman;
    }

    public void setHalaman(int halaman) {
        this.halaman = halaman;
    }    
    
    public void print() {
        System.out.println("Judul = " + judul + "\nPengarang = " + pengarang+ "\nHalaman = " + halaman + "\nJenis = " + jenis);
    }
    
    public String printInfo() {
        return "Judul = " + judul + "\n | Pengarang = " + pengarang+ "\n | Halaman = " + halaman + "\n | Jenis = " + jenis;
    }
    
    public String gap() {
        return "                                                                   "
                + "";
    }
}

class Fiksi extends Buku {
    private String jenisBuku;
    
    public Fiksi() {
        super();
        jenisBuku = "Fiksi";
    }

    public Fiksi(String jenisBuku, String judul, String pengarang, String jenis, int halaman) {
        super(judul, pengarang, jenis, halaman);
        this.jenisBuku = jenisBuku;
    }

    public String getJenisBuku() {
        return jenisBuku;
    }

    public void setJenisBuku(String jenisBuku) {
        this.jenisBuku = jenisBuku;
    }
}

class nonFiksi extends Buku {
    private String jenisBuku;

    public nonFiksi() {
        super();
        jenisBuku = "Non Fiksi";
    }

    public nonFiksi(String jenisBuku, String judul, String pengarang, String jenis, int halaman) {
        super(judul, pengarang, jenis, halaman);
        this.jenisBuku = jenisBuku;
    }

    public String getJenisBuku() {
        return jenisBuku;
    }

    public void setJenisBuku(String jenisBuku) {
        this.jenisBuku = jenisBuku;
    }
}