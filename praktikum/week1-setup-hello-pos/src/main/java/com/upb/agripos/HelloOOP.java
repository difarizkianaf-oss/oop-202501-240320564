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