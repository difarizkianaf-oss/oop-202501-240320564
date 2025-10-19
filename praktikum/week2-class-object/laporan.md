# Laporan Praktikum Minggu 2
Topik: Class dan Object

## Identitas
- Nama  : Difa Rizkiana Fauziyah
- NIM   : 240320564
- Kelas : 3DSRA

---

## Tujuan
- Mampu menjelaskan konsep class, object, atribut, dan method dalam OOP.
- Mampu menerapkan access modifier dan enkapitulasi dalam pembuatan class.
- Mampu mengimplementasikan class produk pertanian dengan atribut dan method yang sesuai.
- Mampu mendemonstrasikan instansiasi object serta menampilkan data produk pertanian di console.
- Mampu menyusun laporan praktikum dengan bukti kode, hasil eksekusi, dan analisis sederhana.

---

## Dasar Teori
Class adalah blueprint atau cetak biru dari sebuah objek. Objek merupakan instansiasi dari class yang berisi atribut (data) dan method (perilaku). Dalam OOP, enkapsulasi dilakukan dengan menyembunyikan data menggunakan access modifier (public, private, protected) serta menyediakan akses melalui getter dan setter.
Dalam konteks Agri-POS, produk pertanian seperti benih, pupuk, dan alat pertanian dapat direpresentasikan sebagai objek yang memiliki atribut nama, harga, dan stok. Dengan menggunakan class, setiap produk dapat dibuat, dikelola, dan dimanipulasi secara lebih terstruktur.

---

## Langkah Praktikum
Langkah-langkah dalam prakrikum:
1. Membuat Class Produk
   - Buat file ```produk.java``` pada package ```model```.
   - Tambah atribut: ```kode```, ```nama```, ```harga```, dan ```stok```.
   - Jadikan atribut bersifat private dengan enkapsulasi, dan buat getter serta setter untuk masing-masing atribut.
     
2. Membuat Class CreditBy
   - Buat file ```CreditBy.java``` pada package ```util```.
   - Isi class dengan method statis untuk menampilkan identitas mahasiswa di akhir output: ```credit by <nim> - <nama>```.
     
3. Membuat Objek Produk dan Menampilkan Credit
   - Buat file ```MainProduk.java```.
   - Instansiasi minimal tiga objek produk dan satu produk alat pertanian.
   - Tampilkan informasi produk melalui method getter.
   - Panggil ```CreditBy.Print("<nim>", "<nama>")``` di akhir ```main``` untuk menampilkan identitas.
     
4. Commit dan Push
   - Commit message yang digunakan: ```week2-class-object```.

---

## Kode Program
1. Produk.java 
```
package model;

public class Produk {
    private String kode;
    private String nama;
    private double harga;
    private int stok;

    public Produk(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getKode() { return kode; }
    public void setKode(String kode) { this.kode = kode; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    public void tambahStok(int jumlah) {
        this.stok += jumlah;
    }

    public void kurangiStok(int jumlah) {
        if (this.stok >= jumlah) {
            this.stok -= jumlah;
        } else {
            System.out.println("Stok tidak mencukupi!");
        }
    }public static void main(String[] args) {
    Produk p1 = new Produk("SPE-201", "Sprayer Elektrik", 470000, 100);
    System.out.println("Kode: " + p1.kode);
    System.out.println("Nama: " + p1.nama);
    System.out.println("Harga: Rp" + p1.harga);
    System.out.println("Stok: " + p1.stok);
    }
}
```

2. CreditBy.java
```
package util;

public class CreditBy {
    public static void print(String nama, String nim) {
        System.out.println("\ncredit by: " + nama + " - " + nim);
    }
}
```

3. MainProduk.java
```
// mainproduk.java

import model.Produk;
import util.CreditBy;

public class MainProduk {
    public static void main(String[] args) {
        Produk p1 = new Produk("BNH-001", "Benih Jagung", 68000, 100);
        Produk p2 = new Produk("PST-101", "Pestisida", 20000, 85);
        Produk p3 = new Produk("SPE-201", "Sprayer Elektrik", 470000, 7);

        System.out.println("Kode: " + p1.getKode() + ", Nama: " + p1.getNama() + ", Harga: Rp" + p1.getHarga() + ", Stok: " + p1.getStok());
        System.out.println("Kode: " + p2.getKode() + ", Nama: " + p2.getNama() + ", Harga: Rp" + p2.getHarga() + ", Stok: " + p2.getStok());
        System.out.println("Kode: " + p3.getKode() + ", Nama: " + p3.getNama() + ", Harga: Rp" + p3.getHarga() + ", Stok: " + p3.getStok());

        p1.kurangiStok(40);
        p2.kurangiStok(5);
        p3.tambahStok(10);

        System.out.println("\n=== Setelah Update Stok ===");
        System.out.println("Kode: " + p1.getKode() + ", Nama: " + p1.getNama() + ", Harga: Rp" + p1.getHarga() + ", Stok: " + p1.getStok());
        System.out.println("Kode: " + p2.getKode() + ", Nama: " + p2.getNama() + ", Harga: Rp" + p2.getHarga() + ", Stok: " + p2.getStok());
        System.out.println("Kode: " + p3.getKode() + ", Nama: " + p3.getNama() + ", Harga: Rp" + p3.getHarga() + ", Stok: " + p3.getStok());


        CreditBy.print("Difa Rizkiana Fauziyah", "240320564");
        
    }
}
```
---

## Hasil Eksekusi
https://github.com/difarizkianaf-oss/oop-202501-240320564/tree/b21870fee37fae2da2331d08c063190a17072051/praktikum/week2-class-object/screenshots
---

## Analisis
(
- Jelaskan bagaimana kode berjalan.  
- Apa perbedaan pendekatan minggu ini dibanding minggu sebelumnya.  
- Kendala yang dihadapi dan cara mengatasinya.  
)
---

## Kesimpulan
(Tuliskan kesimpulan dari praktikum minggu ini.  
Contoh: *Dengan menggunakan class dan object, program menjadi lebih terstruktur dan mudah dikembangkan.*)

---

## Quiz
1. Mengapa atribut sebaiknya dideklarasikan sebagai private dalam class?  
   **Jawaban:** …  

2. Apa fungsi getter dan setter dalam enkapsulasi?  
   **Jawaban:** …  

3. Bagaimana cara class ```Produk``` mendukung pengembangan aplikasi POS yang lebih kompleks?  
   **Jawaban:** …  )
