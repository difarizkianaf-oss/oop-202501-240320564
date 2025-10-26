# Laporan Praktikum Minggu 3
Topik: Inheritance

## Identitas
- Nama  : Difa Rizkiana Fauziyah
- NIM   : 240320564
- Kelas : 3DSRA

---

## Tujuan
- Mampu menjelaskan konsep inheritance (pewarisan class) dalam OOP.
- Mampu membuat superclass dan subclass untuk produk pertanian.
- Mampu mendemonstrasikan hierarki class melalui contoh kode.
- Mampu menggunakan ```super``` untuk memanggil konstruktor dan method parent class.
- Mampu membuat laporan praktikum yang menjelaskan perbedaan penggunaan inheritance dibanding class tunggal.

---

## Dasar Teori
Inheritance adalah mekanisme dalam OOP yang memungkinkan suatu class mewarisi atribut dan method dari class lain.
- Superclass: class induk yang mendefinisikan atribut umum.
- Subclass: class turunan yang mewarisi atribut/method superclass, dan dapat menambahkan atribut/method baru.
- ```Super``` digunakan untuk memanggil konstruktor atau method superclass.
Dalam konteks Agri-POS, kita dapat membuat class ```Produk``` sebagai superclass, kemudian ```Benih```, ```Pupuk```, dan ```AlatPertanian``` sebagai subclass. Hal ini membuat kode lebih reusable dan terstruktur.

---

## Langkah Praktikum
1. Membuat Superclass Produk
   - Gunakan class ```Produk``` dari Bab 2 sebagai superclass.
2. Membuat Subclass
   - ```Benih.java``` > atribut tambahan: varietas.
   - ```Pupuk.java``` > atribut tambahan: jens pupuk (Urea, NPK, dll).
   - ```AlatPertanian.java``` > atribut tambahan: material (baja, kayu, plastik).
3. Membuat Main Class
   - Instansiasi minimal satu objek dari tiap subclass.
   - Tampilkan data produk dengan memanfaatkan inheritance.
4. Menambahkan CreditBy
   - Panggil class ```CreditBy``` untuk menampilkan identitas mahasiswa.
5. Commit dan Push
   - Commit dengan pesan: ```week3-inheritance```

---

## Kode Program

1. Produk.java
```java
//superclass produk

package com.upb.agripos.model;

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
    Produk p1 = new Produk("ALT-501", "Cangkul Baja", 90000, 15);
    System.out.println("Kode: " + p1.kode);
    System.out.println("Nama: " + p1.nama);
    System.out.println("Harga: Rp" + p1.harga);
    System.out.println("Stok: " + p1.stok);
    }
}
```

2. Benih.java
```java
//Subclass benih

package com.upb.agripos.model;

public class Benih extends Produk {
    private String varietas;

    public Benih(String kode, String nama, double harga, int stok, String varietas) {
        super(kode, nama, harga, stok);
        this.varietas = varietas;
    }

    public String getVarietas() { return varietas; }
    public void setVarietas(String varietas) { this.varietas = varietas; }

    //Method tambahan latihan mandiri
    public void deskripsi() {
        System.out.println("Benih varietas " + varietas + " memiliki keunggulan daya tahan tumbuh tinggi");
    }
}
```

3. Pupuk.java
```java
//subclass pupuk

package com.upb.agripos.model;

public class Pupuk extends Produk {
    private String jenis;

    public Pupuk(String kode, String nama, double harga, int stok, String jenis) {
        super(kode, nama, harga, stok);
        this.jenis = jenis;
    }

    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }

    //method tambahan
    public void deskripsi() {
        System.out.println("Pupuk jenis " + jenis + " direkomendasikan untuk tanaman padi dan jagung");
    }
}
```

4. ALatPertanian.java
```java
package com.upb.agripos.model;

public class AlatPertanian extends Produk {
    private String material;

    public AlatPertanian(String kode, String nama, double harga, int stok, String material) {
        super(kode, nama, harga, stok);
        this.material = material;
    }

    public String getMaterial() { return material; }
    public void setMaterial(String material) { this.material = material; }

    //method tambahan
    public void deskripsi() {
        System.out.println("Alat pertanian cangkul berbahan " + material + " ini kuat dan tahan lama ");
    }
}
```

5. CreditBy.java
```java
package com.upb.agripos.util;

public class CreditBy {
    public static void print(String nama, String nim) {
        System.out.println("\nCredit by: " + nama + " - " + nim);
    }
}
```

6. MainInheritance.java
```java
//MainInheritance

package com.upb.agripos;

import com.upb.agripos.model.*;
import com.upb.agripos.util.CreditBy;

public class MainInheritance {
    public static void main(String[] args) {
        Benih b = new Benih("BNH-001", "Benih Padi IR64", 25000, 100, "IR64");
        Pupuk p = new Pupuk("PPK-101", "Pupuk Urea", 350000, 40, "Urea");
        AlatPertanian a = new AlatPertanian("ALT-501", "Cangkul Baja", 90000, 15, "Baja");

        System.out.println("Program Agri-POS");
        System.out.println("----------------------------");
        System.out.println("=== Daftar Produk ===");
        System.out.println("Benih: " + b.getNama() + " Varietas: " + b.getVarietas());
        System.out.println("Pupuk: " + p.getNama() + " Jenis: " + p.getJenis());
        System.out.println("Alat Pertanian: " + a.getNama() + " Material: " + a.getMaterial());
        System.out.println("----------------------------");
        
        System.out.println("=== Deskripsi Produk ===");
        b.deskripsi();
        p.deskripsi();
        a.deskripsi();
        
        CreditBy.print("Difa Rizkiana Fauziyah", "240320564");
    }
}
```

---

## Hasil Eksekusi
![Output Week3-Inheritance](https://github.com/difarizkianaf-oss/oop-202501-240320564/blob/140215c87746c6ce42f05b90c2a9ffba8057f8a5/praktikum/week3-inheritance/screenshots/Output%20Week3-Inheritance.png)

---

## Analisis
1. Cara Kerja Kode

   Program ini merupakan penerapan dari konsep Inheritance (pewarisan) pada OOP di java. Program ini terdiri dari satu superclass berupa ```Produk``` dan tiga subclass yaitu ```Benih```, ```Pupuk```, dan ```AlatPertanian```. Masing-masing subclass mewarisi atribut dan method dari superclass, seperti ```kode```, ```nama```, ```harga```, ```stok```, dan lain-lain. Kemudian ditambahkan atribut khusus, misalnya ```varietas``` pada subclass Benih, atribut ```Jenis``` untuk menunjukkan tipe Pupuk, serta atribut ```material``` pada AlatPertanian, method ```deskripsi()``` juga ditambahkan untuk menampilkan informasi tambahan yang lebih spesifik mengenai produk. Ketika program dijalankan melalui class utama ```MainInheritance```, sistem terlebih dahulu membuat tiga objek dari masing-masing subclass. Setiap objek diinisialisasi dengan pemanggilan konstruktor masing-masing subclass dan meneruskannya ke konstruktor superclass produk dengan menggunakan ```super()``` yang kemudian dilanjutkan dengan memanggil method deskripsi untuk menampilkan detail lengkap. Pada bagian akhir, method ```CreditBy``` digunakan untuk menampilkan identitas dari mahasiswa.

2. Perbedaan dengan Praktikum Sebelumnya
   
   Perbedaan utama antara praktikum minggu ini dan sebelumnya terletak pada penerapan konsep OOP. Pada minggu sebelumnya, praktikum menekankan pembentukan class dan object dengan prinsip enkapsulasi. Sedangkan praktikum kali ini, fokus beralih pada konsep inheritance (pewarisan) melalui pengembangan beberapa subclass yang mewarisi atribut dan metode dari superclass serta menambah atribut khusus di masing-masing subclass.

3. Kendala yang Dihadapi 
   
   Kendala yang dihadapi selama praktikum kali ini masih berkaitan dengan pengaturan struktur package dan proses import antar class. Hal ini mengakibatkan beberapa error muncul pada saat proses running karena perbedaan letak penyimpanan file penulisan package yang tidak sesuai. Sehingga perlu dilakukan penyesuaian ulang dari masing-masing package untuk mengatasi kendala ini.

---

## Kesimpulan
Secara keseluruhan, program ini menunjukkan bahwa inheritance (pewarisan) dapat memudahkan pengelompokkan data produk berdasarkan jenisnya, sekaligus memperluas penggunaan atribut dan method di tiap subclass untuk dikembangkan sesuai kebutuhan masing-masing tanpa mengubah struktur utama di superclass. Hal ini merepresentasikan prinsip OOP yang mendukung keteraturan dan kemudahan pengembangan sistem yang kompleks melalui mekanisme pewarisan data yang efisien dan terstruktur.

---

## Quiz
1. Apa keuntungan menggunakan inheritance dibanding membuat class terpisah tanpa hubungan?  
   **Jawaban:** Keuntungan utama menggunakan inheritance dibandinf membuat class terpisah adalah adanya reusability kode keteraturan struktur program. Dengan Inherintance, atribut dan method cukup didefinisikan sekali pada superclass dan dapat diwariskan pada subclass. Selain itu, inheritance mempermudah proses pengembangan dan pengelolaan program, karena perubahan pada superclass akan langsung berpengaruh pada seluruh subclass yang mewarisinya, sedangkan perubahan atau penambahan dari tiap subclass tidak akan mengganggu struktur utama pada superclass, sehingga hal ini mampu menjaga program agar tetap terstruktur.

2. Bagaimana cara subclass memanggil konstruktor superclass?   
   **Jawaban:** Subclass dapat memanggil konstruktor superclass menggunakan ```super()```. Pemanggilan ini harus dilakukan pada baris pertama di dalam konstruktor subclass. Hal ini dilakukan untuk menginisialisasi atribut yang ada pada superclass sebelum atribut khusus dari subclass dibuat. Sehingga kontruktor superclass akan dieksekusi terlebih dahulu untuk memastikan semua atribut telah diinisiasi dengan benar.

3. Berikan contoh kasus di POS pertanian selain Benih, Pupuk, dan Alat pertanian yang bisa dijadikan subclass!
   **Jawaban:** Contoh kasus lain yang bisa dijadikan subclass dalam sistem Agri-POS salah satunya adalah ```Pestisida``` yang berfungsi untuk mengendalikan hama tanaman. Subclass ini pernah diterapkan pada praktikum minggu kedua, di mana terdapat kode, nama, harga, dan stok, kemudian bisa juga ditambahkan atribut khusus seperti ```Bahan Aktif```. Selain itu, dapat juga ditambahkan produk lain seperti ```Media Tanam``` dan ```Hasil Panen```.
