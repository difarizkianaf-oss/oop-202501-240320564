package main.java.com.upb.agripos;

public class MainCartMap {
    public static void main(String[] args) {
        System.out.println("Hello, I am Difa Rizkiana Fauziyah - 240320564 (Week-7 Koleksi Keranjang)");

        Product p1 = new Product("P01", "Beras", 50000);
        Product p2 = new Product("P02", "Pupuk", 30000);
        Product p3 = new Product("P03", "Pestisida", 20000);

        ShoppingCartMap cartMap = new ShoppingCartMap();
        cartMap.addProduct(p1);
        cartMap.addProduct(p1);
        cartMap.addProduct(p2);
        cartMap.addProduct(p3);
        cartMap.printCart();

        System.out.println("\n=== Setelah Menghapus Product ===");
        cartMap.removeProduct(p1);
        cartMap.printCart();
    }    
}
