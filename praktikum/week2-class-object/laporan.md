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
(Tuliskan kode utama yang dibuat, contoh:  

```java
// Contoh
Produk p1 = new Produk("BNH-001", "Benih Padi", 25000, 100);
System.out.println(p1.getNama());
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
1. Mengapa atribut sebaiknya dideklarasikan sebagai private dalam class?  
   **Jawaban:** …  

2. Apa fungsi getter dan setter dalam enkapsulasi?  
   **Jawaban:** …  

3. Bagaimana cara class ```Produk``` mendukung pengembangan aplikasi POS yang lebih kompleks?  
   **Jawaban:** …  )
