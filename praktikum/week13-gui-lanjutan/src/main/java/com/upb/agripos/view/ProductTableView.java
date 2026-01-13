package com.upb.agripos.view;

import com.upb.agripos.model.Product;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.control.cell.PropertyValueFactory;

public class ProductTableView extends VBox {

    public TextField txtCode = new TextField();
    public TextField txtName = new TextField();
    public TextField txtPrice = new TextField();
    public TextField txtStock = new TextField();

    public Button btnAdd = new Button("Tambah Produk");
    public Button btnDelete = new Button("Hapus Produk");

    public TableView<Product> table = new TableView<>();

    public ProductTableView() {

        TableColumn<Product, String> colCode = new TableColumn<>("Kode");
        colCode.setCellValueFactory(new PropertyValueFactory<>("code"));

        TableColumn<Product, String> colName = new TableColumn<>("Nama");
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Product, Double> colPrice = new TableColumn<>("Harga");
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        TableColumn<Product, Integer> colStock = new TableColumn<>("Stok");
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        table.getColumns().addAll(colCode, colName, colPrice, colStock);

        txtCode.setPromptText("Kode");
        txtName.setPromptText("Nama");
        txtPrice.setPromptText("Harga");
        txtStock.setPromptText("Stok");

        setSpacing(8);
        getChildren().addAll(
                txtCode, txtName, txtPrice, txtStock,
                btnAdd, btnDelete,
                table
        );
    }
}
