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