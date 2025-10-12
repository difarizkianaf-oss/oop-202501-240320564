# Laporan Praktikum Minggu 1
Topik: Pengenalan Paradigma Prosedural, OOP, dan Fungsional

## Identitas
- Nama  : Difa Rizkiana Fauziyah
- NIM   : 240320564
- Kelas : 3DSRA

---

## Tujuan 
- Mampu mendefinisikan paradigma prosedural, OOP, dan fungsional.
- Mampu membandingkan kelebihan dan keterbatasan dari masing-masing paradigma.
- Mampu memberikan contoh program sederhana untuk tiap paradigma.
- Aktif berpartisipasi dalam diskusi kelas dengan bertanya, menjawab, dan memberikan opini.

---

## Dasar Teori
Paradigma pemrograman merupakan cara pandang atau pendekatan dalam menyusun program agar lebih terstruktur.  
1. Prosedural: pendekatan pemrograman yang membangun program dengan rangkaian perintah atau fungsi/prosedur yang dijalankan secara berurutan.
2. OOP (Object-Oriented Programming): pendekatan pemrograman yang membangun program berdasarkan konsep objek, yang mana memiliki data (atribut) dan perilaku (method).
3. Fungsional: pendekatan pemrograman yang memandang program sebagai kumpulan fungsi matematika, menekankan pada ekspresi dan transformasi data.

Dalam konteks Agri-POS, paradigma OOP membantu memodelkan entitas  nyata seperti Produk, Transaksi, dan Pembayaran sebagai Objek. Dengan demikian, sistem lebih mudah dikembangkan dan dipelihara.

---

## Langkah Praktikum
Langkah-langkah dalam prakrikum:
1. Setup Project
   -   Install JDK (Java Development Kit), IDE (seperti IntelliJ IDEA, VS Code, atau NetBeans), Git, PostgreSQL, dan JavaFX di komputer.
   -   Buat folder project dengan nama oop-pos-nim.
   -   Inisialisasi repositori Git.
   -   Buat struktur awal src/main/java/com/upb/agripos/.
   -   Jalankan program Java sederhana untuk menguji apakah semua tools berjalan.
2. Program Sederhana dalam Tiga Paradigma
   - Prosedural: program untuk menghitung total harga produk.
   - OOP: class Produk dengan atribut nama dan harga, dengan minimal tiga objek dan hitung total.
   - Fungsional: gunakan Stream atau lambda untuk menghitung total harga dari tiga objek.
3. Commit dan Push
   - Commit dengan pesan: week1-setup-hello-pos.

---

## Kode Program
1. Paradigma Prosedural  

```java
//HelloProsedural.java
public class HelloProsedural {
   public static void main(String[] args) {
      String nama = "Difa Rizkiana Fauziyah";
      String nim = "240320564";
      String[] produk = {"Jagung", "Pestisida", "Bibit Cabai"};
      int[] harga = {9000, 20000, 12000};
      int total = 0;
      System.out.println("Hello World, I am " + nama + "-" + nim);
      System.out.println("Program Agri-POS World");
      System.out.println("Daftar Produk:");
      for (int i = 0; i < produk.length; i++) {
         System.out.println("- " + produk[i] + ": Rp" + harga[i]);
         total += harga[i];
      }
      System.out.println("Total harga semua produk: Rp" + total);
   }
}
```
)
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/hasil.png)
)
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
(1. [Tuliskan kembali pertanyaan 1 dari panduan]  
   **Jawaban:** …  

2. [Tuliskan kembali pertanyaan 2 dari panduan]  
   **Jawaban:** …  

3. [Tuliskan kembali pertanyaan 3 dari panduan]  
   **Jawaban:** …  )
