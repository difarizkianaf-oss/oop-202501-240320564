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
   -   Buat folder project dengan nama ```oop-pos-nim```.
   -   Inisialisasi repositori Git.
   -   Buat struktur awal ```src/main/java/com/upb/agripos/```.
   -   Jalankan program Java sederhana untuk menguji apakah semua tools berjalan.
2. Program Sederhana dalam Tiga Paradigma
   - Prosedural: program untuk menghitung total harga produk.
   - OOP: class ```Produk``` dengan atribut ```nama``` dan ```harga```, dengan minimal tiga objek dan hitung total.
   - Fungsional: gunakan ```Stream``` atau ```lambda``` untuk menghitung total harga dari tiga objek.
3. Commit dan Push
   - Commit dengan pesan: ```week1-setup-hello-pos```.

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

2. Paradigma OOP

```java
//HelloOOP.java
class Produk {
   String nama;
   int harga;
   Produk(String nama, int harga) {
      this.nama = nama;
      this.harga = harga;
   }
}

public class HelloOOP {
   public static void main(String[] args) {
      String namaMhs = "Difa Rizkiana Fauziyah";
      String nim = "240320564";
      Produk[] daftar = {
         new Produk("Jagung", 9000),
         new Produk("Pestisida", 20000),
         new Produk("Bibit Cabai", 12000)
      };
      int total = 0;
      System.out.println("Hello World, I am " + namaMhs + "-" + nim);
      System.out.println("Program Agri-POS World");
      System.out.println("Daftar Produk:");
      for (Produk p : daftar) {
         System.out.println("- " + p.nama + ": Rp" + p.harga);
         total += p.harga;
      }
      System.out.println("Total harga semua produk: Rp" + total);
   }
}

```
3. Paradigma Fungsional

```java
// HelloFunctional.java
import java.util.*;
import java.util.stream.*;
public class HelloFunctional {
   public static void main(String[] args) {
      String nama = "Difa Rizkiana Fauziyah";
      String nim = "240320564";
      List<String> produk = Arrays.asList("Jagung", "Pestisida", "Bibit Cabai");
      List<Integer> harga = Arrays.asList(9000, 20000, 12000);
      System.out.println("Hello World, I am " + nama + "-" + nim);
      System.out.println("Program Agri-POS World");
      System.out.println("Daftar Produk:");
      IntStream.range(0, produk.size())
         .forEach(i -> System.out.println("- " + produk.get(i) + ": Rp" + harga.get(i)));
      int total = harga.stream().mapToInt(Integer::intValue).sum();
      System.out.println("Total harga semua produk: Rp" + total);
   }
}

```
---

## Hasil Eksekusi
(Sertakan screenshot hasil eksekusi program.  
![Screenshot hasil](screenshots/hasil.png)
)
---

## Analisis
Dalam praktikum ini, saya menjalankan tiga paradigma pemrograman yang berbeda, yakni prosedural, OOP, dan Fungsional. Hasil analisisnya adalah sebagai berikut:
1. Cara Kerja Kode Pemrograman
   - Prosedural: dalam program ini, data produk dan harga disimpan dalam dua array terpisah (```produk``` dan ```harga```. Program kemudian melakukan perulangan dengan ```for``` untuk menampilkan daftar produk berserta harganya, dan sekaligus menghitung total harga keseluruhan produk. Pendekatan ini fokus pada langkah-langkah prosedural yang berurutan tanpa menggunakan konsep class atau objek.
   - OOP: program ini membuat sebuah class ```Produk``` yang memiliki atribut ```nama``` dan ```harga```. di dalam method ```main```, dibuat beberapa objek ```produk``` yang disimpan dalam array ```daftar```. Program kemudian melakukan iterasi pada array objek tersebut untuk menampilkan detail produk dan menghitung total harga. Dengan pendekatan ini, kode menjadi lebih terstruktur dan mudah dikembangkan.
   - Fungsional: program ini memanfaatkan ```stream``` dan ```lambda``` di java. Di mana data produk dan harga disimpan dalam ```list``` dan untuk menampilkannya digunakan ```IntStream.range()```. Total harga produk dihitung menggunakan operasi stream ```mapToInt()``` dan ```sum()```. Pendekatan ini mengutamakan fungsi tanpa mengubah data aslinya.
2. Kelebihan dan keterbatasan Tiap Pendekatan
   - Prosedural:
     - kelebihan: mudah dipahami untuk program sederhana, alur jelas dan berurutan.
     - kekurangan: sulit dikembangkan untuk program yang kompleks.
   - OOP:
     - kelebihan: kode lebih terstruktur karena data dan fungsinya dikumpulkan dalam objek, serta lebih mudah dikembangkan untuk program besar.
     - kekurangan: membutuhkan pemahaman tambahan mengenai konsep class dan objek.
   - Fungsional:
     - kelebihan: kode lebih ringkas dan mengurangi kemungkinan kesalahan data karena data tidak diubah secara langsung.
     - kekurangan: perlu mempelajari penggunaan stream dan lambda.
       
3. Kendala yang Dihadapi

   Pada paradigma fungsional, terdapat kesulitan dalam memahami penggunaan fitur ```stream``` dan ```lambda``` di Java. Kendala teknis juga muncul ketika menjalankan kode Java yang memiliki deklarasi ```package``` di bagian atas file yang mana menjadikan kode program error. Setelah mencoba beberapa kali, kendala ini terselesaikan dengan cara menghapus baris ```package``` sehingga kode dapat dijalankan tanpa error.

---

## Kesimpulan
Praktikum menggu pertama ini membahas tiga paradigma pemrograman: prosedural, OOP, dan fungsional. Setiap paradigma memiliki karakteristik dan cara kerja yang berbeda-beda dalam pengelolaan data. Paradigma prosedural menggunakan langkah-langkah berurutan, OOP mengelola data dan fungsi dalam objek, dan fungsional memanfaatkan fungsi-fungsi untuk mengolah data. Praktikum ini memperkuat pemahaman konsep dasar tiap paradigma dan bagaimana penerapannya yang disesuaikan dengan kebutuhan. Dengan demikian, praktikum ini menjadi dasar untuk pengembangan kemampuan pemrograman lebih lanjut.

---

## Quiz
1. Apakah OOP selalu lebih baik dari prosedural?  
   **Jawaban:** …  

2. Kapan functional programming lebih cocok digunakan dibanding OOP atau prosedural?  
   **Jawaban:** …  

3. Bagaimana paradigma (prosedural, OOP, fungsional) memengaruhi maintainability dan scalability aplikasi?  
   **Jawaban:** …  )

4. Mengapa OOP lebih cocok untuk mengembangkan aplikasi POS dibanding prosedural?

   **Jawaban**:

6. Bagaimana paradigma fungsional dapat membantu mengurangi kode berulang (boilerplate code)?

   **Jawaban**:
