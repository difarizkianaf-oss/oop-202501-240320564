package main.java.com.upb.agripos;

public class MainCart {
    public static void main(String[] args) {
        System.out.println("Hello, I am Difa Rizkiana Fauziyah - 240320564 (Week-7 Koleksi Keranjang)");

        Product p1 = new Product("P01", "Beras", 50000);
        Product p2 = new Product("P02", "Pupuk", 30000);
        Product p3 = new Product("P03", "Pestisida", 20000);

        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p3);
        cart.printCart();

        System.out.println("\n=== Setelah Menghapus Product ===");
        cart.removeProduct(p1);
        cart.printCart();
    }
}