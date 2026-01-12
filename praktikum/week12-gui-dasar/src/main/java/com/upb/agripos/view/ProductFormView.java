package com.upb.agripos.view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ProductFormView extends VBox {

    public TextField txtCode = new TextField();
    public TextField txtName = new TextField();
    public TextField txtPrice = new TextField();
    public TextField txtStock = new TextField();
    public Button btnAdd = new Button("Tambah Produk");
    public ListView<String> listView = new ListView<>();

    public ProductFormView() {
        Label lblCode = new Label("Kode Produk:");
        Label lblName = new Label("Nama Produk:");
        Label lblPrice = new Label("Harga:");
        Label lblStock = new Label("Stok:");
        Label lblList = new Label("Daftar Produk:");

        setSpacing(10);
        getChildren().addAll(
                lblCode, txtCode,
                lblName, txtName,
                lblPrice, txtPrice,
                lblStock, txtStock,
                btnAdd, listView
        );
    }

    public void clearForm() {
        txtCode.clear();
        txtName.clear();
        txtPrice.clear();
        txtStock.clear();
    }
}
