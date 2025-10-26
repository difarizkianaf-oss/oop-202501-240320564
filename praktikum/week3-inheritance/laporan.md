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
1. Apa keuntungan menggunakan inheritance dibanding membuat class terpisah tanpa hubungan?  
   **Jawaban:** …  

2. Bagaimana cara subclass memanggil konstruktor superclass?   
   **Jawaban:** …  

3. Berikan contoh kasus di POS pertanian selain Benih, Pupuk, dan Alat pertanian yang bisa dijadikan subclass!
   **Jawaban:** …  )
