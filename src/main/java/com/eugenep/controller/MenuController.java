package com.eugenep.controller;

import com.eugenep.PizzApp;
import com.eugenep.controller.MessageBox;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXCheckBox;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import com.eugenep.model.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class MenuController {


    PizzaDeck thickDeck;
    PizzaDeck thinDeck;
    Pizza actualPizza;
    ToggleGroup crustToggle;
    Customer customer;
    int howManyPizzas;
    List<JFXCheckBox> checkList;
    OrderPrice myOrderPrice;
    Discount discount;
    int pizzaAddCounter;

    List<Delivery> deliveries;






    @FXML
    private AnchorPane rootAnchorPane;

    @FXML
    private AnchorPane mainMenuPane;

    @FXML
    private JFXButton menuButton;

    @FXML
    private JFXButton cartButton;

    @FXML
    private ImageView cartImageView;

    @FXML
    private Label instructionLabel;

    @FXML
    private Pane menuPane;

    @FXML
    private JFXListView<String> pizzaMenuList;

    @FXML
    private JFXRadioButton radioThin;

    @FXML
    private JFXRadioButton radioThick;

    @FXML
    private Label priceLabel;

    @FXML
    private JFXButton addPizzaButton;

    @FXML
    private VBox topperVBox;

    @FXML
    private Label topperLabel;





    @FXML
    private Pane orderPane;

    @FXML
    private Label myOrderLabel;

    @FXML
    private JFXListView<String> myOrderListView;

    @FXML
    private VBox orderControlsVbox;

    @FXML
    private JFXButton removePizzaButton;

    @FXML
    private JFXButton goToFinalScreenButton;

    @FXML
    private JFXButton goBackButton;

    @FXML
    private Pane finalPane;

    @FXML
    private AnchorPane finalAPane;

    @FXML
    private Label finalPriceLabel;

    @FXML
    private Label finalPriceDescriptionLabel;

    @FXML
    private ChoiceBox<String> deliveryChoiceBox;

    @FXML
    private JFXCheckBox studentDiscountCheck;

    @FXML
    private JFXButton finishAndPayButton;

    @FXML
    private JFXButton closeButton;

    @FXML
    void initialize(){

        rootAnchorPane.setPrefSize(900, 550);
        rootAnchorPane.setMaxSize(900,550);


        thinDeck = new PizzaDeck();
        thickDeck = new PizzaDeck();
        actualPizza = new Pizza();
        crustToggle = new ToggleGroup();
        customer = new Customer();
        howManyPizzas = 1;
        checkList = new ArrayList<JFXCheckBox>();
        myOrderPrice = new OrderPrice();
        topperVBox.setSpacing(5);
        deliveries = new ArrayList<Delivery>();
        discount = new Discount(DiscountType.NO_DISCOUNT);
        pizzaAddCounter = 0;


        Font.loadFont(PizzApp.class.getResource("assets/Lato-Regular.ttf").toExternalForm(), 12);











        Delivery delivery = new Delivery();

        //preparing stage
        orderPane.setVisible(false);
        finalPane.setVisible(false);
        menuPane.setVisible(true);

        closeButton.setOnAction(e -> closeButton_Click());

        //first pane actions
        thinDeck.MakeThinList();
        thickDeck.MakeThickList();
        menuButton.setFont(new Font("Lato", 24));
        cartButton.setFont(new Font("Lato", 24));

        topperLabel.setFont(new Font("Lato", 15));
        radioThin.setFont(new Font("Lato", 15));
        radioThick.setFont(new Font("Lato", 15));
        priceLabel.setFont(new Font("Lato", 47));
        addPizzaButton.setFont(new Font("Lato", 22));
        instructionLabel.setFont(new Font("Lato", 15));
        instructionLabel.setWrapText(true);
        instructionLabel.setText("Wybierz pizze z listy");


        menuButton.setOnAction(e -> menuButton_Click());
        cartButton.setOnAction(e -> cartButton_Click());

        radioThin.setOnAction(e -> radioThin_Click());
        radioThick.setOnAction(e -> radioThick_Click());

        addPizzaButton.setOnAction(e -> addPizzaButton_Click());




        //second pane actions
        removePizzaButton.setOnAction(e -> removePizzaButton_Click());
        goToFinalScreenButton.setOnAction(e -> goToFinalScreenButton_Click());
        myOrderLabel.setFont(new Font("Lato", 15));
        removePizzaButton.setFont(new Font("Lato", 15));
        goToFinalScreenButton.setFont(new Font("Lato", 15));

        //final pane actions
        goBackButton.setOnAction(e -> goBackButton_Click());
        deliveries = delivery.getDeliveryPlacesList();
        finishAndPayButton.setOnAction(e -> finishAndPayButton_Click());
        goBackButton.setFont(new Font("Lato", 20));
        //deliveryChoiceBox.setStyle("fx-font: 999999px \"Lato\";");
        studentDiscountCheck.setFont(new Font("Lato", 20));
        finalPriceDescriptionLabel.setFont(new Font("Lato", 20));
        finishAndPayButton.setFont(new Font("Lato", 80));



        for (int i = 0; i < deliveries.size(); i++)
        {
            deliveryChoiceBox.getItems().add(deliveries.get(i).giveDeliveryPlaceName() + " " + deliveries.get(i).getDeliveryPrice() + "0 zl");
        }
        deliveryChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) {
                myOrderPrice.setPrice(customer.getOrderPrice(), discount.getMyDiscountType(),deliveries.get((int)newValue).getDeliveryPlace());
                finalPriceLabelRefresh();
            }
        });
        deliveryChoiceBox.getSelectionModel().selectLast();



        studentDiscountCheck.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if(newValue)
                {
                    discount.setMyDiscountType(DiscountType.STUDENT);
                }
                else
                {
                    discount.setMyDiscountType(DiscountType.NO_DISCOUNT);
                }
                finalPriceLabelRefresh();
            }
        });




        topperVBox.setVisible(false);


        addPizzaButton.setVisible(false);


        radioThin.setToggleGroup(crustToggle);
        radioThick.setToggleGroup(crustToggle);
        radioThin.setSelected(true);

        priceLabel.setText("0.00 zł");


        ArrayList<Topper> topperMenu = new ArrayList<Topper>();


        topperMenu = thinDeck.giveTopperMenu();
        for(int i = 0; i < topperMenu.size(); i++)
        {

            JFXCheckBox tempCheck = new JFXCheckBox(topperMenu.get(i).giveTopperName() +
                    " +" + topperMenu.get(i).giveTopperPrice() + "0zł");
            tempCheck.setFont(new Font("Lato", 15));
            tempCheck.setStyle("-jfx-checked-color: #f9aa33; -jfx-unchecked-color: #232f34;");
            Topper tempTopper;
            tempTopper = topperMenu.get(i);
            tempCheck.selectedProperty().addListener(new ChangeListener<Boolean>() {
                @Override
                public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                    if(newValue)
                    {
                        actualPizza.addTopper(tempTopper.getMyTopperName());
                        setPriceLabel();
                        topperLabel.setText(actualPizza.giveMyToppers());
                        instructionLabel.setText("Dodaj pizze do koszyka");
                    }
                    if(oldValue)
                    {
                        actualPizza.removeTopper(tempTopper.getMyTopperName());
                        setPriceLabel();
                        topperLabel.setText(actualPizza.giveMyToppers());
                    }
                }
            });
            topperVBox.getChildren().add(tempCheck);
            checkList.add(tempCheck);
        }



        topperLabel.setWrapText(true);




        pizzaMenuList.setOnMouseClicked(new ListViewHandler(){
            @Override
            public void handle(javafx.scene.input.MouseEvent event){
                if(pizzaMenuList.getSelectionModel().isEmpty())
                {
                    pizzaMenuList.getSelectionModel().selectLast();
                }
                topperLabel.setText(thinDeck.getPizzaFromDeck(pizzaMenuList.getSelectionModel().getSelectedIndex()).giveMyToppers());
                if(radioThin.isSelected())
                {
                    actualPizza.init(thinDeck.getPizzaFromDeck(pizzaMenuList.getSelectionModel().getSelectedIndex()));
                    setPriceLabel();
                }
                if(radioThick.isSelected())
                {
                    actualPizza.init(thickDeck.getPizzaFromDeck(pizzaMenuList.getSelectionModel().getSelectedIndex()));
                    setPriceLabel();
                }


                topperVBox.setVisible(true);
                for(int i = 0; i < checkList.size(); i++)
                {
                    checkList.get(i).setSelected(false);
                }

                addPizzaButton.setVisible(true);
                instructionLabel.setText("Wybierz dodatek, albo dodaj pizze do koszyka");
            }
        });

        for(int i = 0; i < thinDeck.GetPizzaList().size(); i++)
        {
            pizzaMenuList.getItems().add(thinDeck.getPizzaname(i) + " " +thinDeck.getPizzaFromDeck(i).giveMyPrice() + "0 zł");
        }


    }





    private void menuButton_Click()
    {
        orderPane.setVisible(false);
        menuPane.setVisible(true);

    }

    private void cartButton_Click()
    {
        menuPane.setVisible(false);
        orderPane.setVisible(true);
        pizzaAddCounter = 0;
        Image cartImage = new Image("file:src/main/resources/com/eugenep/assets/baseline_local_grocery_store_black_48dp.png");
        cartImageView.setImage(cartImage);

        myOrderListView.getItems().clear();
        for(int i = 0; i < customer.getMyCart().size(); i++)
        {
            myOrderListView.getItems().add(customer.getPizzaFromCart(i).giveMyName() + " (" +
                    customer.getPizzaFromCart(i).getCrust().giveCrustName() + ") " +
                    "[ " + customer.getPizzaFromCart(i).giveMyToppers() + "] " +
                            customer.getPizzaFromCart(i).giveMyPrice().toString() + "0 zł");
        }




    }

    private void radioThin_Click()
    {
        int indexBuff = -1;
        if(!actualPizza.isEmpty()) {
            actualPizza.setThinCrust();
            setPriceLabel();
            if(!pizzaMenuList.getSelectionModel().isEmpty())
            {
                indexBuff = pizzaMenuList.getSelectionModel().getSelectedIndex();
            }
        }
        pizzaMenuList.getItems().clear();
        for(int i = 0; i < thinDeck.GetPizzaList().size(); i++)
        {
            pizzaMenuList.getItems().add(thinDeck.getPizzaname(i) + " " +thinDeck.getPizzaFromDeck(i).giveMyPrice() + "0zł");
        }
        pizzaMenuList.getSelectionModel().select(indexBuff);
    }

    private void radioThick_Click()
    {
        int indexBuff = -1;
        if(!actualPizza.isEmpty()) {
            actualPizza.setThickCrust();
            setPriceLabel();
            if(!pizzaMenuList.getSelectionModel().isEmpty())
            {
                indexBuff = pizzaMenuList.getSelectionModel().getSelectedIndex();
            }
        }
        pizzaMenuList.getItems().clear();
        for(int i = 0; i < thinDeck.GetPizzaList().size(); i++)
        {
            pizzaMenuList.getItems().add(thickDeck.getPizzaname(i) + " " +thickDeck.getPizzaFromDeck(i).giveMyPrice() + "0zł");
        }
        pizzaMenuList.getSelectionModel().select(indexBuff);
    }

    private void addPizzaButton_Click(){
        customer.AddToCart(actualPizza);
        pizzaAddCounter++;
        Image cartImage;
        instructionLabel.setVisible(false);


        if(pizzaAddCounter <= 9) {


            cartImage = new Image("file:src/main/resources/com/eugenep/assets/baseline_local_grocery_store_black_red_dot_" +
                    pizzaAddCounter + "_48dp.png");

            cartImageView.setImage(cartImage);


        }
        if(pizzaAddCounter > 9)
        {
            cartImage = new Image("file:src/main/resources/com/eugenep/assets/baseline_local_grocery_store_black_red_dot_9_plus_48dp.png");
            cartImageView.setImage(cartImage);
        }
    }




    private void removePizzaButton_Click()
    {
        if(!myOrderListView.getSelectionModel().isEmpty()) {

            customer.RemoveFromCart(myOrderListView.getSelectionModel().getSelectedIndex());

            myOrderListView.getItems().clear();
            myOrderListView.getSelectionModel().clearSelection();
            for (int i = 0; i < customer.getMyCart().size(); i++) {
                myOrderListView.getItems().add(customer.getPizzaFromCart(i).giveMyName() + " (" +
                        customer.getPizzaFromCart(i).getCrust().giveCrustName() + ") " +
                        "[ " + customer.getPizzaFromCart(i).giveMyToppers() + "] " +
                        customer.getPizzaFromCart(i).giveMyPrice().toString() + "0 zł");
            }
        }
    }

    private void goToFinalScreenButton_Click(){
        mainMenuPane.setVisible(false);
        menuPane.setVisible(false);
        orderPane.setVisible(false);
        finalPane.setVisible(true);
        deliveryChoiceBox.getSelectionModel().selectLast();
        finalPriceLabelRefresh();
    }

    private void goBackButton_Click(){
        mainMenuPane.setVisible(true);
        menuPane.setVisible(false);
        orderPane.setVisible(true);
        finalPane.setVisible(false);
    }

    private void finalPriceLabelRefresh()
    {
        BigDecimal tempFinal;
        myOrderPrice.setPrice(customer.getOrderPrice(),discount.getMyDiscountType(),deliveries.get(deliveryChoiceBox.getSelectionModel().getSelectedIndex()).getDeliveryPlace());
        tempFinal = myOrderPrice.getFullOrderPrice();
        DecimalFormatSymbols decimalFormatSymbols  = DecimalFormatSymbols.getInstance(new Locale("pl", "PL"));
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormatSymbols.setGroupingSeparator(' ');
        finalPriceLabel.setText(new DecimalFormat("#,##0.00zł", decimalFormatSymbols).format(tempFinal));
    }

    private void setPriceLabel()
    {
        DecimalFormatSymbols decimalFormatSymbols  = DecimalFormatSymbols.getInstance(new Locale("pl", "PL"));
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormatSymbols.setGroupingSeparator(' ');
        priceLabel.setText(new DecimalFormat("#,##0.00zł", decimalFormatSymbols).format(actualPizza.giveMyPrice()));
    }


    private void finishAndPayButton_Click()
    {
        MessageBox.show("Thank you for ordering our pizza!", "Thank you!");
    }

    private void closeButton_Click()
    {
        Stage stage = (Stage)closeButton.getScene().getWindow();
        stage.close();
    }

}
