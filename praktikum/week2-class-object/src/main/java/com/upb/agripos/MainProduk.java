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