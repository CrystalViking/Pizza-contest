package com.eugenep;

import javafx.application.Application;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.geometry.Point2D;

public class PizzApp extends Application {


    Stage myStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("menu1.fxml"));
        primaryStage.setTitle("Pizza Order");

        /*Font.loadFont(PizzApp.class.getResource("assets/Lato-Regular.ttf").toExternalForm(), 12);

        for (String family : Font.getFamilies())
            if (family.equals("Lato"))
                System.out.println("The font is loaded");*/


        primaryStage.initStyle(StageStyle.UNDECORATED);
        myStage = primaryStage;
        final ObjectProperty<Point2D> mouseCoordinates = new SimpleObjectProperty<>();
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mouseCoordinates.set(new Point2D(mouseEvent.getSceneX(),
                        mouseEvent.getSceneY()));
            }
        });

        root.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                mouseCoordinates.set(null);
            }
        });

        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseCoordinates.get() != null)
                {
                    double x = mouseEvent.getScreenX();
                    double deltaX = x - mouseCoordinates.get().getX();
                    double y = mouseEvent.getSceneY();
                    double deltaY = y - mouseCoordinates.get().getY();
                    myStage.setX(myStage.getX() + deltaX);
                    myStage.setY(myStage.getY() + deltaY);
                    mouseCoordinates.set(new Point2D(x,y));
                }
            }
        });

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
