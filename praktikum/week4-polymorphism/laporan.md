# Laporan Praktikum Minggu 1 (sesuaikan minggu ke berapa?)
Topik: Polymorphism (Info Produk)

## Identitas
- Nama  : Difa Rizkiana Fauziyah
- NIM   : 240320564
- Kelas : 3DSRA

---

## Tujuan
- Mampu menjelaskan konsep polymorphism dalam OOP.
- Mampu membedakan method overloading dan overriding.
- Mampu mengimplementasikan polymorphism (overriding, overloading, dynamic binding) dalam program.
- Mampu menganalisis contoh kasus polymorphism pada sistem nyata (Agri-POS).

---

## Dasar Teori
Polymorphism berarti "banyak bentuk" dan memungkinkan objek yang berbeda merespons panggilan method yang sama dengan cara yang berbeda.
1. Overloading : mendefinisikan method dengan nama sama tetapi parameter berbeda.  
2. Overriding : subclass mengganti implementasi method dari superclass. 
3. Dynamic binding : pemanggilan method ditentukan saat runtime, bukan compile time.
Dalam konteks Agri-POS, misalnya:
- Method ```getInfo()``` pada ```Produk``` dioverride oleh ```Benih```, ```Pupuk```, ```AlatPertanian``` untuk menampilkan detail spesifik.
- Method ```tambahStok()``` bisa dibuat overload dengan parameter berbeda (int, double).

---

## Langkah Praktikum
1. Overloading
   - Tambahkan method ```tambahStok(int jumlah)``` dan ```tambahStok(double jumlah)``` pada class ```Produk```.
2. Overriding
   - Tambahkan method ```getInfo()``` pada superclass ```Produk```.
   - Override method ```getInfo()``` pada subclass ```Benih```, ```Pupuk```, dan ```AlatPertanian```.
3. Dynamic Binding
   - Buat array ```Produk[] daftarProduk``` yang berisi objek ```Benih```, ```Pupuk```, dan ```AlatPertanian```.
   - Loop array tersebut dan panggil ```getInfo()```. Perhatikan bagaimana Java memanggil method sesuai jenis objek aktual.
4. Main Class
   - Buat ```MainPolymorphism.java``` untuk mendemonstrasikan overloading, overriding, dan dynamic binding.
5. CreditBy
   - Tetap panggil ```CreditBy.print("<NIM>', "<Nama>")```.
6. Commit dan Push
   - Commit dengan Pesan: ```week4-polymorhism```.

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
1. Apa perbedaan overloading dan overriding?  
   **Jawaban:** …  

2. Bagaimana Java menentukan method mana yang dipanggil dalam dynamic binding?  
   **Jawaban:** …  

3. Berikan contoh kasus polymorphism dalam sistem POS selain produk pertanian!  
   **Jawaban:** …  )
