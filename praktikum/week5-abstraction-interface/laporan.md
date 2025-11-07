# Laporan Praktikum Minggu 5
Topik: Abstraction (Abstract Class & Interface)

## Identitas
- Nama  : Difa Rizkiana Fauziyah
- NIM   : 240320564
- Kelas : 3DSRA

---

## Tujuan
- Mampu menjelaskan perbedaan abstract class dan interface.
- Mampu mendesain abstract class dengan method abstract sesuai kebutuhan kasus.
- Mampu membuat interface dan mengimplementasikannya pada class.
- Mampu menerapkan multiple inheritance melalui interface pada rancangan kelas.
- Mampu mendokumentasikan kode (komentar kelas/method, README singkat pada folder minggu).

---

## Dasar Teori
Abstraksi adalah proses menyederhanakan kompleksitas dengan menampilkan elemen penting dan menyembunyikan detail implementasi.
   - Abstract class: tidak dapat diinstansiasi, dapat memiliki method abstrak (tanpa badan) dan non-abstrak. Dapat menyimpan state (field).
   - Interface: kumpulan kontrak (method tanpa implementasi konkret). Sejak Java 8 mendukung default method. Mendukung multiple inheritance (class dapat mengimplementasikan banyak interface).
   - Gunakan abstract class bila ada shared state dan perilaku dasar; gunakan interface untuk mendefinisikan kemampuan/kontrak lintas hierarki.

Dalam konteks Agri-POS, Pembayaran dapat dimodelkan sebagai abstract class dengan method abstrak ```prosesPembayaran()``` dan ```biaya()```. Implementasi konkritnya: ```Cash``` dan ```EWallet```. Kemudian, interface seperti ```Validatable``` (mis. verifikasi OTP) dan ```Receiptable``` (mencetak bukti) dapat diimplemtasikan oleh jenis pembayaran yang relevan.

---

## Langkah Praktikum
1. Abstract Class – Pembayaran
   - Buat `Pembayaran` (abstract) dengan field `invoiceNo`, `total` dan method:
     - `double biaya()` (abstrak) → biaya tambahan (fee).
     - `boolean prosesPembayaran()` (abstrak) → mengembalikan status berhasil/gagal.
     - `double totalBayar()` (konkrit) → `return total + biaya();`.

2. Subclass Konkret
   - `Cash` → biaya = 0, proses = selalu berhasil jika `tunai >= totalBayar()`.
   - `EWallet` → biaya = 1.5% dari `total`; proses = membutuhkan validasi.
   - `TransferBank` → biaya = 3500; proses = membutuhkan validasi.

3. Interface
   - `Validatable` → `boolean validasi();` (contoh: OTP).
   - `Receiptable` → `String cetakStruk();`

4. Multiple Inheritance via Interface
   - `Cash` setidaknya mengimplementasikan `Receiptable`.
   - `EWallet` mengimplementasikan **dua interface**: `Validatable`, `Receiptable`.
   - `TransferBank` mengimplementasikan **dua interface**: `Validatable`, `Receiptable`.

5. Main Class
    - Buat `MainAbstraction.java` untuk mendemonstrasikan pemakaian `Pembayaran` (polimorfik).
    - Tampilkan hasil proses dan struk. Di akhir, panggil `CreditBy.print("[NIM]", "[Nama]")`.

6. Commit dan Push
   - Commit dengan pesan: `week5-abstraction-interface`.


---

## Kode Program
1. Pembayaran.java (Abstraction)
```java
package com.upb.agripos.model.pembayaran;

public abstract class Pembayaran {
    protected String invoiceNo;
    protected double total;

    public Pembayaran(String invoiceNo, double total) {
        this.invoiceNo = invoiceNo;
        this.total = total;
    }

    public abstract double biaya();               // fee/biaya tambahan
    public abstract boolean prosesPembayaran();   // proses spesifik tiap metode

    public double totalBayar() {
        return total + biaya();
    }

    public String getInvoiceNo() { return invoiceNo; }
    public double getTotal() { return total; }
}
```

2. Validatable.java (Interface)
```java
//validatable.java
package com.upb.agripos.model.kontrak;

public interface Validatable {
    boolean validasi();
}
```

3. Receiptable.java (Interface)
```java
//Receiptable.java
package com.upb.agripos.model.kontrak;

public interface Receiptable {
    String cetakStruk();
}
```

4. Cash.java (Extends Pembayaran, Implements Receiptable)
```java
package com.upb.agripos.model.pembayaran;

import com.upb.agripos.model.kontrak.Receiptable;

public class Cash extends Pembayaran implements Receiptable {
    private double tunai;

    public Cash(String invoiceNo, double total, double tunai) {
        super(invoiceNo, total);
        this.tunai = tunai;
    }

    @Override
    public double biaya() {
        return 0.0;
    }

    @Override
    public boolean prosesPembayaran() {
        return tunai >= totalBayar(); // sederhana: cukup uang tunai
    }

    @Override
    public String cetakStruk() {
        return "    STRUCK PEMBAYARAN CASH   \n" +
                "------------------------------\n" +
                String.format(
                    "INVOICE    : %s %n" +
                    "TOTAL      : Rp %.2f %n" +
                    "BAYAR CASH : Rp %.2f %n" +
                    "KEMBALI    : Rp %.2f %n",
                        invoiceNo, totalBayar(), tunai, Math.max(0, tunai - totalBayar()));
    }
}
```

5. EWallet.java (Extends Pembayaran, Implements Validatable & Receiptable)
```java
package com.upb.agripos.model.pembayaran;

import com.upb.agripos.model.kontrak.Receiptable;
import com.upb.agripos.model.kontrak.Validatable;

public class EWallet extends Pembayaran implements Validatable, Receiptable {
    private String akun;
    private String otp; // sederhana untuk simulasi

    public EWallet(String invoiceNo, double total, String akun, String otp) {
        super(invoiceNo, total);
        this.akun = akun;
        this.otp = otp;
    }

    @Override
    public double biaya() {
        return total * 0.015; // 1.5% fee
    }

    @Override
    public boolean validasi() {
        return otp != null && otp.length() == 6; // contoh validasi sederhana
    }

    @Override
    public boolean prosesPembayaran() {
        return validasi(); // jika validasi lolos, anggap berhasil
    }

    @Override
    public String cetakStruk() {
        return "  STRUCK PEMBAYARAN E-WALLET  \n" +
                "------------------------------\n" +
                String.format(
                    "INVOICE    : %s %n" + 
                    "TOTAL+FEE  : Rp %.2f %n" +
                    "E-WALLET   : %s %n" + 
                    "STATUS     : %s %n",
                        invoiceNo, totalBayar(), akun, prosesPembayaran() ? "BERHASIL" : "GAGAL");
    }
}
```

6. TransferBank.java (Extends Pembayaran, Implements Validatable & Receiptable)
```java
//latihan mandiri
package com.upb.agripos.model.pembayaran;

import com.upb.agripos.model.kontrak.Validatable;
import com.upb.agripos.model.kontrak.Receiptable;

public class TransferBank extends Pembayaran implements Validatable, Receiptable {
    private String namaBank;
    private String kodeTransfer; //untuk validasi

    public TransferBank (String invoiceNo, double total, String namaBank, String kodeTransfer) {
        super(invoiceNo, total);
        this.namaBank = namaBank;
        this.kodeTransfer = kodeTransfer;
    }

    @Override
    public double biaya() {
        return 3500.0; //biaya tetap 3.500
    }
    
    @Override
    public boolean validasi() {
        return kodeTransfer != null && kodeTransfer.length() == 8; //contoh validasi sederhana
    }

    @Override
    public boolean prosesPembayaran() {
        return validasi(); //jika validasi berhasil
    }

    @Override
    public String cetakStruk() {
        return "  STRUCK PEMBAYARAN TRANSFER  \n" +
                "------------------------------\n" +
                String.format(
                    "INVOICE    : %s %n" + 
                    "TOTAL+FEE  : Rp %.2f %n" +
                    "BANK       : %s %n" + 
                    "STATUS     : %s %n",
                        invoiceNo, totalBayar(), namaBank, prosesPembayaran() ? "BERHASIL" : "GAGAL");
    }
}
```

7. MainAbstraction.java
```java
package com.upb.agripos;

import com.upb.agripos.model.kontrak.*;
import com.upb.agripos.model.pembayaran.*;
import com.upb.agripos.util.CreditBy;

public class MainAbstraction {
    public static void main(String[] args) {
        Pembayaran cash = new Cash("INV-001", 245000, 300000);
        Pembayaran ew = new EWallet("INV-002", 127000, "difa@ewallet", "123456");
        Pembayaran tf = new TransferBank("INV-003", 412000, "Bank DF", "12345678");

        System.out.println("===== INVOICE PEMBAYARAN =====");
        System.out.println("------------------------------");

        System.out.println(((Receiptable) cash).cetakStruk());
        System.out.println("------------------------------");
        System.out.println(((Receiptable) ew).cetakStruk());
        System.out.println("------------------------------");
        System.out.println(((Receiptable) tf).cetakStruk());

    CreditBy.print("Difa Rizkiana Fauziyah", "240320564");
    }
}
```

8. CreditBy.java
```java
package com.upb.agripos.util;

public class CreditBy {
    public static void print(String nama, String nim) {
        System.out.println("\nCredit by: " + nama + " - " + nim);
    }
}
```

---

## Hasil Eksekusi
![Output Week5-Abstraction-Interface](https://github.com/difarizkianaf-oss/oop-202501-240320564/blob/677dd8ab4e63d6a2a5c1199fecd5c60cdfbfde6d/praktikum/week5-abstraction-interface/screenshots/Output%20Week5-MainAbstraction.png)
---

## Analisis
1. Cara Kerja Kode
    
    Program ini merupakan penerapan dari konsep Abstraction dalam OOP dengan menggunakan class ```Pembayaran```sebagai class abstract utama. Class ini berperan sebagai kerangka dasar untuk berbagai metode pembayaran yang digunakan dalam sistem Agri-POS. Di dalamnya terdapat atribut ```invoince``` dan ```total``` yang menjadi identitas umum setiap traksaksi. Selain itu, class ini juga memiliki dua metode abstract yaitu ```biaya()``` dan ```prosesPembayaran()```, yang nantinya akan diimplementasikan oleh setiap subclass. Terdapat pula metode ```totalBayar()``` yang digunakan untuk menghitung total akhir pembayaran apabila terdapat biaya tambahan.

    Dari class abstract Pembayaran kemudian diturunkan menjadi subclass ```Cash```, ```EWallet```, dan ```TransferBank```, di mana masing-masing mewakili jenis transaksi yang berbeda dan disertai dengan validasi sederhana. Ketiga class tersebut mengimplementasikan interface ```Receiptable``` untuk mencetak struck pembayaran dengan format yang telah disesuaikan. Terdapat pula penggunaan interface ```Validatable``` untuk memastikan setiap metode pembayaran memiliki mekanisme validasi sebelum transaksi diproses.

    Penerapan lebih lanjut dapat dilihat pada class ```MainAbstraction``` yang berperan sebagai pusat eksekusi program. Di dalamnya dibuat ojek dari ketiga jenis pembayarann dan dilakukan proses pencetakan struck untuk masing-masing transaksi. Meskipun ketiganya memiliki perbedaan dalam perhitungan biaya dan validasi, semua objek tetap diperlakukan sebagai tipe class pembayaran. Hal ini menunjukkan konsep abstraction yang memisahkan antara struktur umum dan detail implementasi. Kemudian program ditutup dengan menampilkan credit dari mahasiswa.

- Perbedaan dengan Praktikum Sebelumnya

    Perbedaannya adalah pada praktikum sebelumnya kita masih mempelajari dan menerapkan konsep overloading dan overriding, sedangkan kali praktikum ini lebih menekankan pada penerapan konsep abstraction dan interface.

- Kendala yang Dihadapi
    
    Kendala yang dihadapi adalah bagaimana menjaga konsistensi penerapan method abstract dan interface, serta penyesuaian agar format pencetakan struk dari semua jenis pembayaran tetap seragam.
    
---

## Kesimpulan
Secara keseluruhan, program ini berhasil menerapkan prinsip abstraction dan interface dengan baik. Melalui pemisahan antara class abstract, subclass, dan interface, sistem mampu menangani berbagai jenis transaksi dengan struktur yang fleksibel dan mudah dikembangkan untuk keberlanjutan sistem di masa mendatang. Dengan demikian, implementasi ini menunjukkan bagaimana prinsip tersebut dapat diterapkan secara nyata dalam konteks sistem pembayaran digital di aplikasi Agri-POS.

---

## Quiz
1. Jelaskan perbedaan konsep dan penggunaan abstract class dan interface!  
   **Jawaban:** Abstraction digunakan sebagai blueprint yang dapat berisi atribut, konstruktor, dan metode abstrak maupun konkret, cocok untuk class yang memiliki kesamaan struktur dasar. Sedangkan interface hanya berisi deklarasi method tanpa implementasi untuk menentukan perilaku yang harus dimiliki oleh kelas apapun yang mengimplementasikannya.

2. Mengapa multiple inheritance lebih aman dilakukan dengan interface pada Java? 
   **Jawaban:** Multiple inheritnce lebih aman dilakukan dengan interface karena interface hanya berisi deklarasi method tanpa implementasi, sehingga tidak menimbulkan konflik antar class seperti yang terjadi pada pewarisan berganda di class.

3. Pada Contoh Agri-POS, bagian mana yang paling tepat menjadi abstract class dan mana yang menjadi interface? Jelaskan alasannya! 
   **Jawaban:** Class Pembayaran merupakan bagian yang tepat untuk dijadikan class abstraction, karena class ini menjadi dasar bagi berbagai jenis method pembayaran sperti cash, ewallet, dan transfer. Sedangkan bagian yang tepat untuk interface adalah Receiptable dan validatable, karena keduanya hanya mendefinisikan perilaku tanpa implementsi.
