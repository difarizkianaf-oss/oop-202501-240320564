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
```java
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
```java
package util;

public class CreditBy {
    public static void print(String nama, String nim) {
        System.out.println("\ncredit by: " + nama + " - " + nim);
    }
}
```

3. MainProduk.java
```java
//MainProduk.java

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
1. Cara Kerja Kode
   
   Program ini terdiri dari tiga kode program yang saling mendukung, yaitu ```Produk```, ```CreditBy```, dan ```MainProduk```. Di mana Produk disimpan dalam package ```model``` dan berfungsi sebagai representasi data barang yang memiliki atribut kode, nama, harga, dan stok. Atribut tersbut bersifat private untuk menjaga keamanan data dari objek luar dan menggunakan getter dan setter untuk mengaksesnya. Class ini juga digunakan untuk memperbarui stok setiap produk.
   Adapun kode CreditBy yang disimpan dalam package ```util```  digunakan untuk menampung fungsi pendukung dalam program, yang mana dalam hal ini adalah untuk mencetak informasi berupa nama dan nim dari mahasiswa. Metode ini bersifat static sehingga dapat dipanggil tanpa perlu membuat objek terlebih dahulu.
   Selanjutnya kode MainProduk berperan sebagai kode utama dari program ini dengan mengimpor kelas dari package lain yakni ```model.Produk``` dan ```util.CreditBy```. Import bertujuan agar program MainProduk dapat mengakses class lain tanpa harus menulis atau membuat ulang kodenya. Pada kode ini dibuatlah beberapa objek produk beserta pembaruannya yang kemudian ditampilkan menggunakan metode getter dan ditutup dengan menampilkan identitas mahasiswa tadi.
   
2. Perbedaan dengan Praktikum Sebelumnya
   
   Praktikum kali ini berbeda dengan praktikum sebelumnya yang membahas tiga paradigma pemrograman. Jika praktikum minggu lalu masih membahas perbandingan teori atau konsep antar paradigma, di praktikum kali ini sudah mulai berfokus pada penerapan program OOP yang lebih terstruktur dengan menggunakan class, objek, dan beberapa metode.
   
3. Kendala yang Dihadapi

   Kendala utama yang muncul adalah adanya kesalahan atau error terjadi dalam mengatur package dan bagaimana mengimpor class dari package lain. Selain itu, adanya kesalahan dalam proses running juga cukup menjadi kendala. Setelah dilalukan penelusuran, akhirnya program bisa dijalankan dan berhasil menampilkan output.
---

## Kesimpulan
Dengan menggunakan class dan object, program menjadi lebih terstruktur serta mudah dikembangkan untuk kebutuhan yang lebih kompleks. Praktikum ini menunjukkan bahwa penerapan enkapsulasi mampu membuat program lebih rapi dan terorganisir. Selain itu, proses pengelolaan data seperti perubahan stok produk pun menjadi lebih efisien dan mudah diatur.

---

## Quiz
1. Mengapa atribut sebaiknya dideklarasikan sebagai private dalam class?  
   **Jawaban:** Atribut sebaiknya dideklarasikan sebagai private agar data dalam kelas terlindungi dari akses dan perubahan langsung oleh objek luar. Dengan cara ini, prinsip enkapitulasi dapat diterapkan di mana data hanya dapat diakses melalui metode getter dan setter. Hal tersebut membantu menjaga keamanan dan konsistensi data dalam program.   

2. Apa fungsi getter dan setter dalam enkapsulasi?  
   **Jawaban:** Fungsi dari getter dan setter yaitu untuk memberikan akses yang aman terhadap atribut yang bersifat private. Getter digunakan untuk mengambil nilai atribut, sedangkan setter digunakan untuk mengubah nilainya dengan kontrol dan validasi tertentu. Sehingga keduanya menjaga integritas serta konsistensi data dalam penerapan prinsip enkapitulasi.

3. Bagaimana cara class ```Produk``` mendukung pengembangan aplikasi POS yang lebih kompleks?  
   **Jawaban:** Class produk membantu mendefinisikan data barang dalam sistem aplikasi POS, di mana class produk menyimpan informasi mengenai kode, nama, harga, hingga stok dari produk. Dengan menerapakan class, setiap produk dapat dibuat, dikelola, dan dimanipulasi secara lebih terstruktur. Hal ini juga mendukung kemudahan dalam pengembangan aplikasi kedepannya, seperti pengelolaan transaksi hingga pembaruan stok.
