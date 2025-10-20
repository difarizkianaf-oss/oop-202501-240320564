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