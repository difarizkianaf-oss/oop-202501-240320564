package com.upb.agripos.controller;

import com.upb.agripos.model.Product;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.view.ProductTableView;

import javafx.collections.FXCollections;

public class ProductController {

    private final ProductService service;
    private final ProductTableView view;

    public ProductController(ProductService service, ProductTableView view) {
        this.service = service;
        this.view = view;
        loadData();
        initEvent();
    }

    private void loadData() {
        try {
            view.table.setItems(
                    FXCollections.observableArrayList(service.getAll())
            );
        } catch (Exception e) {
            e.printStackTrace();
            // Handle error, maybe show alert
        }
    }

    private void initEvent() {

        view.btnAdd.setOnAction(e -> {
            try {
                String code = view.txtCode.getText().trim();
                String name = view.txtName.getText().trim();
                String priceText = view.txtPrice.getText().trim();
                String stockText = view.txtStock.getText().trim();

                if (code.isEmpty() || name.isEmpty() || priceText.isEmpty() || stockText.isEmpty()) {
                    // Show error message
                    return;
                }

                double price = Double.parseDouble(priceText);
                int stock = Integer.parseInt(stockText);

                Product p = new Product(code, name, price, stock);
                service.insert(p);
                loadData();
                // Clear fields
                view.txtCode.clear();
                view.txtName.clear();
                view.txtPrice.clear();
                view.txtStock.clear();
            } catch (NumberFormatException ex) {
                // Handle invalid number
                ex.printStackTrace();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        });

        view.btnDelete.setOnAction(e -> {
            Product selected = view.table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                try {
                    service.delete(selected.getCode());
                    loadData();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
    }
}
