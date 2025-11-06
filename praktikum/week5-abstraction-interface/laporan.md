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

3. Interface
   - `Validatable` → `boolean validasi();` (contoh: OTP).
   - `Receiptable` → `String cetakStruk();`

4. Multiple Inheritance via Interface
   - `EWallet` mengimplementasikan **dua interface**: `Validatable`, `Receiptable`.
   - `Cash` setidaknya mengimplementasikan `Receiptable`.

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
1. Jelaskan perbedaan konsep dan penggunaan abstract class dan interface!  
   **Jawaban:** …  

2. Mengapa multiple inheritance lebih aman dilakukan dengan interface pada Java? 
   **Jawaban:** …  

3. Pada Contoh Agri-POS, bagian mana yang paling tepat menjadi abstract class dan mana yang menjadi interface? Jelaskan alasannya! 
   **Jawaban:** …  )
