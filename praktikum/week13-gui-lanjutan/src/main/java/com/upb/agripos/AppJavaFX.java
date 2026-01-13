package com.upb.agripos;

import java.sql.Connection;
import java.sql.DriverManager;

import com.upb.agripos.controller.ProductController;
import com.upb.agripos.dao.ProductDAOImpl;
import com.upb.agripos.service.ProductService;
import com.upb.agripos.view.ProductTableView;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppJavaFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/agripos",
                "postgres",
                "postgres"
        );

        ProductService service = new ProductService(new ProductDAOImpl(conn));
        ProductTableView view = new ProductTableView();
        new ProductController(service, view);

        stage.setScene(new Scene(view, 600, 500));
        stage.setTitle("Agri-POS TableView - Difa Rizkiana Fauziyah (240320564)");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
