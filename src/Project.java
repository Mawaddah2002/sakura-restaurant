/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.File;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.media.MediaView;
import javafx.application.Application;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Spinner;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javax.swing.Timer;
import java.awt.event.*;
import javafx.animation.AnimationTimer;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javafx.scene.media.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import javafx.application.Application;
import static javafx.application.Application.launch;
import java.io.IOException;
import java.util.Optional;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Spinner;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

public class Project extends Application {

    Label forImage;
    ImageView a2 = new ImageView(new Image(getClass().getResourceAsStream("img2.jpg")));

    invoicenum invNum = new invoicenum();
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query queryS = session.createQuery("SELECT MAX(invoceNumber) FROM invoicenum");
    Integer currentinvoceNumber = (Integer) queryS.uniqueResult();
    int BillNumber = currentinvoceNumber + 1;
    static double fTotal = 0;

    private TextField discountField;
    private Label resultLabel;

    public static void cartStyle(Button b) {	//this is a method to style the cart button
        Image imageForCartButton = new Image("https://cdn-icons-png.flaticon.com/512/3523/3523865.png");
        ImageView imageViewForCartButton = new ImageView(imageForCartButton);

        imageViewForCartButton.setFitHeight(30);
        imageViewForCartButton.setFitWidth(30);
        b.setContentDisplay(ContentDisplay.RIGHT);
        b.setGraphic(imageViewForCartButton);

    }

    public Button addCartCreate() {	//this is a method to style the cart button
        Button b = new Button("ADD TO CART");
        Image imageForCartButton = new Image("https://cdn-icons-png.flaticon.com/512/3523/3523865.png");
        ImageView imageViewForCartButton = new ImageView(imageForCartButton);

        imageViewForCartButton.setFitHeight(15);
        imageViewForCartButton.setFitWidth(15);
        b.setContentDisplay(ContentDisplay.LEFT);
        b.setGraphic(imageViewForCartButton);
        return b;

    }

    public static void sliderRestrictionHeat(Slider s) {
        s.setMin(0);
        s.setMax(3);
        s.setValue(1);
        s.setMinorTickCount(0);
        s.setMajorTickUnit(1);
        s.setShowTickMarks(true);
        s.setShowTickLabels(true);
        s.setSnapToTicks(true);

        s.setLabelFormatter(new StringConverter<Double>() {
            public String toString(Double n) {
                if (n < 0.5) {
                    return "Mild";
                }
                if (n < 1.5) {
                    return "Medium";
                }
                if (n < 2.5) {
                    return "Hot";
                }

                return "Hell";
            }

            @Override
            public Double fromString(String s) {
                switch (s) {
                    case "Mild":
                        return 0d;
                    case "Medium":
                        return 1d;
                    case "Hot":
                        return 2d;
                    case "Hell":
                        return 3d;

                    default:
                        return 0d;
                }
            }
        });
    }

    public static String getHeatDegree(Slider s) {
        int name = (int) s.getValue();
        if (name == 0) {
            return "Mild";
        } else if (name == 1) {
            return "Medium";
        } else if (name == 2) {
            return "Hot";
        } else {
            return "Hell";
        }
    }

    @Override
    public void start(Stage stage) throws Exception {

        Label txTotal1 = new Label();
        txTotal1.setText("Total:" + fTotal);
        txTotal1.setStyle("-fx-font-family: Courier New;-fx-font-weight: bold;-fx-font-size: 16;");
        txTotal1.setPadding(new Insets(10, 0, 0, 10));

        Label txTotal2 = new Label();
        txTotal2.setText("Total:" + fTotal);
        txTotal2.setStyle("-fx-font-family: Courier New;-fx-font-weight: bold;-fx-font-size: 16;");
        txTotal2.setPadding(new Insets(10, 0, 0, 10));

        Label txTotal3 = new Label();
        txTotal3.setText("Total:" + fTotal);
        txTotal3.setStyle("-fx-font-family: Courier New;-fx-font-weight: bold;-fx-font-size: 16;");
        txTotal3.setPadding(new Insets(10, 0, 0, 10));

        Label txTotal4 = new Label();
        txTotal4.setText("Total:" + fTotal);
        txTotal4.setStyle("-fx-font-family: Courier New;-fx-font-weight: bold;-fx-font-size: 16;");
        txTotal4.setPadding(new Insets(10, 0, 0, 10));

        /* 
	 * THE MAIN COMPONENT FOR ALL SCENES:
         */
        Button b = new Button("READY TO ORDER!");

        Button mainCourseB1 = new Button("");//buttons for appetizer
        Button mainCourseB2 = new Button("");
        Button mainCourseB3 = new Button("");
        Button mainCourseB4 = new Button("");
        Button homePageB1 = new Button("");

        Button sidesB1 = new Button("");//buttons for sides
        Button sidesB2 = new Button("");
        Button sidesB3 = new Button("");
        Button sidesB4 = new Button("");
        Button homePageB2 = new Button("");

        Button dessertB1 = new Button("");//buttons for dessert
        Button dessertB2 = new Button("");
        Button dessertB3 = new Button("");
        Button dessertB4 = new Button("");
        Button homePageB3 = new Button("");

        Button drinksB1 = new Button("");//buttons for drinks
        Button drinksB2 = new Button("");
        Button drinksB3 = new Button("");
        Button drinksB4 = new Button("");
        Button homePageB4 = new Button("");

        Button cart1 = new Button("CART");
        Button cart2 = new Button("CART");
        Button cart3 = new Button("CART");
        Button cart4 = new Button("CART");
        cartStyle(cart1);
        cartStyle(cart2);
        cartStyle(cart3);
        cartStyle(cart4);

        Button back = new Button("BACK");
        back.setId("backBtn");

        Button delete = new Button("DELETE");
        delete.setId("delBtn");

        Button btnExportInvoice = new Button("Export to Invoice");
        btnExportInvoice.setId("exportBtn");

        Button complete = new Button("Done!");
        complete.setId("compbtn");
        Image image = new Image("https://m.media-amazon.com/images/I/418wK+6vaQL.png");
        ImageView imageview = new ImageView(image);
        imageview.setFitHeight(15);
        imageview.setFitWidth(15);
        complete.setContentDisplay(ContentDisplay.LEFT);
        complete.setGraphic(imageview);

        /*
	 *  the buttons below used to set adding action 
	 * */
        Button addToCartDish1 = addCartCreate();
        Button addToCartDish2 = addCartCreate();
        Button addToCartDish3 = addCartCreate();
        Button addToCartDish4 = addCartCreate();

        Button addToCartSide1 = addCartCreate();
        Button addToCartSide2 = addCartCreate();
        Button addToCartSide3 = addCartCreate();
        Button addToCartSide4 = addCartCreate();

        Button addToCartDessert1 = addCartCreate();
        Button addToCartDessert2 = addCartCreate();
        Button addToCartDessert3 = addCartCreate();
        Button addToCartDessert4 = addCartCreate();

        Button addToCartDrinks1 = addCartCreate();
        Button addToCartDrinks2 = addCartCreate();
        Button addToCartDrinks3 = addCartCreate();
        Button addToCartDrinks4 = addCartCreate();

        /*
       * THE STARTING SCENE "READY TO ORDER!"
         */
        forImage = new Label("", a2);
        forImage.setAlignment(Pos.TOP_CENTER);
        forImage.setStyle("-fx-background-color:white;");
        b.setAlignment(Pos.BOTTOM_CENTER);
        AnimationTimer timer = new MyAnimation();
        timer.start();

        /* 
            Scene voise  
         */
        String path = "C:\\Users\\epad\\Music\\ResVoice.mp3";
        Media media = new Media(new File(path).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);

        BorderPane pane1 = new BorderPane();
        HBox readyBox = new HBox();
        readyBox.getChildren().addAll(forImage);
        pane1.setBottom(b);
        pane1.setCenter(readyBox);

        Scene scene = new Scene(pane1, 950, 650);
        scene.getStylesheets().add(Project.class.getResource("homePage.css").toExternalForm());
        //DB Retrieve Order Name and Price
        Query query = session.createQuery("SELECT i.orderName FROM invoice i WHERE i.orderName = :orderName");
        Query queryP = session.createQuery("SELECT i.price FROM invoice i WHERE i.orderName = :orderName");

        /*
	 * THIS IS THE MAIN COURSE SCENE #FIRST SCENE
         */
        HBox boxForTop1 = new HBox();
        boxForTop1.getChildren().addAll(homePageB1, mainCourseB1, mainCourseB2, mainCourseB3, mainCourseB4);

        HBox hbForDish1 = new HBox(50);
        hbForDish1.setPadding(new Insets(15, 15, 15, 15));

        Image imageForDish1 = new Image("/project/D1.jpg");
        ImageView iVForDish1 = new ImageView(imageForDish1);
        iVForDish1.setFitWidth(180);
        iVForDish1.setFitHeight(180);
        iVForDish1.setPreserveRatio(true);

        query.setParameter("orderName", "Pad Thai");
        String dishName1 = (String) query.uniqueResult();
        queryP.setParameter("orderName", "Pad Thai");
        Integer dishPrice1 = (Integer) queryP.uniqueResult();

        Text textForDish1 = new Text(dishName1);
        textForDish1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        Label forDescrepDish1 = new Label("Rice Noodles, eggs, Bean Sprouts, \nTamarind Sauce, Fish Sauce, garlic, \nshallots, peanuts, lime, chives, \nprotein.");

        Label lblAmountDish = new Label("Amount:");
        Label lblPrice1 = new Label("Price: " + String.valueOf(dishPrice1));
        Spinner<Integer> spinnerForDish1 = new Spinner(1, 5, 1);
        //Spinner<Integer> spinnerForPrice = new Spinner(0, 36, 0);
        spinnerForDish1.getValueFactory().wrapAroundProperty().set(true);

        GridPane grPane1 = new GridPane();
        grPane1.setVgap(2);
        grPane1.add(textForDish1, 0, 0);
        grPane1.add(forDescrepDish1, 0, 3);
        grPane1.add(lblAmountDish, 0, 9);
        grPane1.add(spinnerForDish1, 0, 11);
        grPane1.add(lblPrice1, 0, 14);
        //grPane1.add(spinnerForPrice, 0, 12);

        VBox VbForDish1 = new VBox();
        VbForDish1.getChildren().add(grPane1);

        VBox forChooseDish1 = new VBox();

        Label lblCombo1 = new Label("Choose:");
        String[] options1 = new String[]{"Chicken Pad Thai", "Shrimp Pad Thai", "Pad Thai with Lime and Cilantro", "Vegetarian Pad Thai",
            "Tofu Pad Thai", "Beef Pad Thai", "Pad Thai with Peanut Sauce", "Pad Thai with Extra Spicy Sauce", "Pad Thai with Egg and Bean Sprouts",
            "Pad Thai with Cashew Nuts"};
        ComboBox<String> cbo1 = new ComboBox<>();
        cbo1.setEditable(false);
        cbo1.setPrefWidth(400);
        cbo1.setValue("Shrimp Pad Thai");
        cbo1.getItems().addAll(options1);
        cbo1.setVisibleRowCount(6);

        Slider heatSlider1 = new Slider(0, 3, 0);
        sliderRestrictionHeat(heatSlider1);

        forChooseDish1.setAlignment(Pos.TOP_LEFT);
        forChooseDish1.setSpacing(10); // Set spacing between elements
        forChooseDish1.getChildren().addAll(lblCombo1, cbo1, new Label("Heat Level:"), heatSlider1, addToCartDish1);

        hbForDish1.getChildren().addAll(iVForDish1, VbForDish1, forChooseDish1);
        hbForDish1.setPrefSize(30, 150);
        hbForDish1.setStyle("-fx-border-color:white;");

        HBox hbForDish2 = new HBox(50);
        hbForDish2.setPadding(new Insets(15, 15, 15, 15));

        Image imageForDish2 = new Image("/project/D2.jpg");
        ImageView iVForDish2 = new ImageView(imageForDish2);
        iVForDish2.setFitWidth(180);
        iVForDish2.setFitHeight(180);
        iVForDish2.setPreserveRatio(true);

        query.setParameter("orderName", "General Tso's Chicken");
        String dishName2 = (String) query.uniqueResult();
        queryP.setParameter("orderName", "General Tso's Chicken");
        Integer dishPrice2 = (Integer) queryP.uniqueResult();

        Text textForDish2 = new Text(dishName2);
        textForDish2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        Label forDescrepDish2 = new Label("Chicken, cornstarch, Vegetable Oil, \ngarlic, ginger, Soy Sauce, Rice Vinegar, \nHoisin Sauce, sugar, Chicken Broth, \nRed Chili Peppers, Green Onions.");

        Label lblAmountDish2 = new Label("Amount:");
        Label lblPrice2 = new Label("Price: " + String.valueOf(dishPrice2));
        Spinner<Integer> spinnerForDish2 = new Spinner(1, 5, 1);
        spinnerForDish2.getValueFactory().wrapAroundProperty().set(true);

        GridPane grPane2 = new GridPane();
        grPane2.setVgap(2);
        grPane2.add(textForDish2, 0, 0);
        grPane2.add(forDescrepDish2, 0, 3);
        grPane2.add(lblAmountDish2, 0, 9);
        grPane2.add(spinnerForDish2, 0, 11);
        grPane2.add(lblPrice2, 0, 14);

        VBox VbForDish2 = new VBox();
        VbForDish2.getChildren().add(grPane2);

        Label lblCombo2 = new Label("Choose:");
        String[] options2 = new String[]{"Mild Sauce", "Spicy Sauce", "Extra Spicy Sauce", "Sweet and Sour Sauce",
            "Teriyaki Sauce", "Garlic Sauce", "Honey Sesame Sauce", "Szechuan Sauce", "Orange Sauce", "General Tso's Sauce"};
        ComboBox<String> cbo2 = new ComboBox<>();
        cbo2.setEditable(false);
        cbo2.setPrefWidth(400);
        cbo2.setValue("General Tso's Sauce");
        cbo2.getItems().addAll(options2);
        cbo2.setVisibleRowCount(6);

        Slider heatSlider2 = new Slider(0, 3, 0);
        sliderRestrictionHeat(heatSlider2);

        VBox forChooseDish2 = new VBox();
        forChooseDish2.setAlignment(Pos.TOP_LEFT);
        forChooseDish2.setSpacing(10); // Set spacing between elements
        forChooseDish2.getChildren().addAll(lblCombo2, cbo2, new Label("Heat Level:"), heatSlider2, addToCartDish2);

        hbForDish2.getChildren().addAll(iVForDish2, VbForDish2, forChooseDish2);
        hbForDish2.setPrefSize(30, 150);
        hbForDish2.setStyle("-fx-border-color:white;");

        HBox hbForDish3 = new HBox(50);
        hbForDish3.setPadding(new Insets(15, 15, 15, 15));

        Image imageForDish3 = new Image("/project/D3.jpg");
        ImageView iVForDish3 = new ImageView(imageForDish3);
        iVForDish3.setFitWidth(180);
        iVForDish3.setFitHeight(180);
        iVForDish3.setPreserveRatio(true);

        query.setParameter("orderName", "Sushi");
        String dishName3 = (String) query.uniqueResult();
        queryP.setParameter("orderName", "Sushi");
        Integer dishPrice3 = (Integer) queryP.uniqueResult();

        Text textForDish3 = new Text(dishName3);
        textForDish3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        Label forDescrepDish3 = new Label("Sushi Rice, Nori (Seaweed), \nfish, seafood, vegetables, \ncondiments and sauces.");

        Label lblAmountDish3 = new Label("Amount:");
        Label lblPrice3 = new Label("Price: " + String.valueOf(dishPrice3));
        Spinner<Integer> spinnerForDish3 = new Spinner(1, 5, 1);
        spinnerForDish3.getValueFactory().wrapAroundProperty().set(true);

        GridPane grPane3 = new GridPane();
        grPane3.setVgap(2);
        grPane3.add(textForDish3, 0, 0);
        grPane3.add(forDescrepDish3, 0, 3);
        grPane3.add(lblAmountDish3, 0, 9);
        grPane3.add(spinnerForDish3, 0, 11);
        grPane3.add(lblPrice3, 0, 14);

        VBox VbForDish3 = new VBox();
        VbForDish3.getChildren().add(grPane3);

        Label lblCombo3 = new Label("Choose:");
        String[] options3 = new String[]{"California Roll", "Spicy Tuna Roll", "Salmon Avocado Roll", "Shrimp Tempura Roll",
            "Rainbow Roll", "Eel Cucumber Roll", "Philadelphia Roll", "Crunchy Roll", "Vegetable Roll", "Dragon Roll"};
        ComboBox<String> cbo3 = new ComboBox<>();
        cbo3.setEditable(false);
        cbo3.setPrefWidth(400);
        cbo3.setValue("Shrimp Tempura Roll");
        cbo3.getItems().addAll(options3);
        cbo3.setVisibleRowCount(6);

        Slider heatSlider3 = new Slider(0, 3, 0);
        sliderRestrictionHeat(heatSlider3);

        VBox forChooseDish3 = new VBox();
        forChooseDish3.setAlignment(Pos.TOP_LEFT);
        forChooseDish3.setSpacing(10); // Set spacing between elements
        forChooseDish3.getChildren().addAll(lblCombo3, cbo3, new Label("Heat Level:"), heatSlider3, addToCartDish3);

        hbForDish3.getChildren().addAll(iVForDish3, VbForDish3, forChooseDish3);
        hbForDish3.setPrefSize(30, 150);
        hbForDish3.setStyle("-fx-border-color:white;");

        HBox hbForDish4 = new HBox(50);
        hbForDish4.setPadding(new Insets(15, 15, 15, 15));

        Image imageForDish4 = new Image("/project/D4.jpg");
        ImageView iVForDish4 = new ImageView(imageForDish4);
        iVForDish4.setFitWidth(180);
        iVForDish4.setFitHeight(180);
        iVForDish4.setPreserveRatio(true);

        query.setParameter("orderName", "Pho");
        String dishName4 = (String) query.uniqueResult();
        queryP.setParameter("orderName", "Pho");
        Integer dishPrice4 = (Integer) queryP.uniqueResult();

        Text textForDish4 = new Text(dishName4);
        textForDish4.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        Label forDescrepDish4 = new Label("Beef or Chicken, broth, Rice Noodles, \nBean Sprouts, Thai Basil, lime, \nChili Peppers, Hoisin Sauce and Sriracha, \nscallions, cilantro.");

        Label lblAmountDish4 = new Label("Amount:");
        Label lblPrice4 = new Label("Price: " + String.valueOf(dishPrice4));
        Spinner<Integer> spinnerForDish4 = new Spinner(1, 5, 1);
        spinnerForDish4.getValueFactory().wrapAroundProperty().set(true);

        GridPane grPane4 = new GridPane();
        grPane4.setVgap(2);
        grPane4.add(textForDish4, 0, 0);
        grPane4.add(forDescrepDish4, 0, 3);
        grPane4.add(lblAmountDish4, 0, 9);
        grPane4.add(spinnerForDish4, 0, 11);
        grPane4.add(lblPrice4, 0, 14);

        VBox VbForDish4 = new VBox();
        VbForDish4.getChildren().add(grPane4);

        Label lblCombo4 = new Label("Choose:");
        String[] options4 = new String[]{"Beef Pho", "Chicken Pho", "Vegetarian Pho", "Seafood Pho",
            "Tofu Pho", "Shrimp Pho", "Combination Pho", "Pork Pho", "Mushroom Pho", "Spicy Pho"};
        ComboBox<String> cbo4 = new ComboBox<>();
        cbo4.setEditable(false);
        cbo4.setPrefWidth(400);
        cbo4.setValue("Beef Pho");
        cbo4.getItems().addAll(options4);
        cbo4.setVisibleRowCount(6);

        Slider heatSlider4 = new Slider(0, 3, 0);
        sliderRestrictionHeat(heatSlider4);

        VBox forChooseDish4 = new VBox();
        forChooseDish4.setAlignment(Pos.TOP_LEFT);
        forChooseDish4.setSpacing(10); // Set spacing between elements
        forChooseDish4.getChildren().addAll(lblCombo4, cbo4, new Label("Heat Level:"), heatSlider4, addToCartDish4);

        hbForDish4.getChildren().addAll(iVForDish4, VbForDish4, forChooseDish4);
        hbForDish4.setPrefSize(30, 150);
        hbForDish4.setStyle("-fx-border-color:white;");

        VBox v = new VBox();
        v.getChildren().addAll(hbForDish1, hbForDish2, hbForDish3, hbForDish4);
        ScrollPane scrol1 = new ScrollPane(v);
        scrol1.setFitToWidth(true);

        BorderPane mainPane1 = new BorderPane();
        mainPane1.setPrefSize(750, 650);
        mainPane1.setTop(boxForTop1);
        HBox h1 = new HBox(500);
        h1.getChildren().addAll(cart1, txTotal1);
        mainPane1.setBottom(h1);
        mainPane1.setCenter(scrol1);
        
        Scene sceneMainCourse = new Scene(mainPane1, 950, 650);
        sceneMainCourse.getStylesheets().add(Project.class.getResource("Hbox.css").toExternalForm());

        spinnerForDish1.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
        spinnerForDish2.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
        spinnerForDish3.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
        spinnerForDish4.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);

        /*
	 * THIS IS THE SIDES SCENE #SECOND SCENE
         */
        HBox hbForSide1 = new HBox(50);
        hbForSide1.setPadding(new Insets(15, 15, 15, 15));//this is the first sides

        Image imageForSide1 = new Image("/project/S1.jpg");
        ImageView iVForSide1 = new ImageView(imageForSide1);
        iVForSide1.setFitWidth(180);
        iVForSide1.setFitHeight(180);
        iVForSide1.setPreserveRatio(true);

        query.setParameter("orderName", "Raw Salad");
        String sideName1 = (String) query.uniqueResult();
        queryP.setParameter("orderName", "Raw Salad");
        Integer sidePrice1 = (Integer) queryP.uniqueResult();

        Text textForside1 = new Text(sideName1);
        textForside1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        VBox VbForSide1 = new VBox();
        Label forDescrepSide1 = new Label("mixed leaves. edamame beans. baby plum tomatoes.\nseaweed. pickled mooli, carrot + red onion. \nfried shallots. wagamama dressing.\n\n");
        Label lblAmount = new Label("Amount:");
        Label lblPrice5 = new Label("Price: " + String.valueOf(sidePrice1));
        Spinner<Integer> spinnerForSide1 = new Spinner(1, 5, 1);

        GridPane gPane1 = new GridPane();
        gPane1.add(textForside1, 0, 0);
        gPane1.add(forDescrepSide1, 0, 3);
        gPane1.add(lblAmount, 0, 9);
        gPane1.add(spinnerForSide1, 0, 10);
        gPane1.add(lblPrice5, 0, 11);
        //gPane1.add(addToCartSide1, 0, 15);

        VbForSide1.getChildren().add(gPane1);

        ChoiceBox cBForSide1 = new ChoiceBox();
        cBForSide1.getItems().add("without baby plum tomatoes");
        cBForSide1.getItems().add("without pickled mooli");
        cBForSide1.getItems().add("Extra SAKURA dressing");
        cBForSide1.setValue("Extra SAKURA dressing");
        Label lblChoose = new Label("Choose:", cBForSide1);
        lblChoose.setContentDisplay(ContentDisplay.BOTTOM);

        VBox forChoose = new VBox(70);
        forChoose.getChildren().addAll(lblChoose, addToCartSide1);

        hbForSide1.getChildren().addAll(iVForSide1, VbForSide1, forChoose);
        hbForSide1.setPrefSize(30, 150);
        hbForSide1.setStyle("-fx-border-color:white;");

        HBox hbForSide2 = new HBox(50);		//this is the second sides
        hbForSide2.setPadding(new Insets(15, 15, 15, 15));

        Image imageForSide2 = new Image("/project/S2.jpg");
        ImageView iVForSide2 = new ImageView(imageForSide2);
        iVForSide2.setFitWidth(180);
        iVForSide2.setFitHeight(180);
        iVForSide2.setPreserveRatio(true);

        query.setParameter("orderName", "Lollipop Prawn Kushiyaki");
        String sideName2 = (String) query.uniqueResult();
        queryP.setParameter("orderName", "Lollipop Prawn Kushiyaki");
        Integer sidePrice2 = (Integer) queryP.uniqueResult();

        Text textForside2 = new Text(sideName2);
        textForside2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        VBox VbForSide2 = new VBox();
        Label forDescrepSide2 = new Label("\nskewered grilled shrimps. lemongrass\n + chilli marinade. caramelised lime.\n ");
        Label lblAmount2 = new Label("Amount:");
        Label lblPrice6 = new Label("Price: " + String.valueOf(sidePrice2));
        Spinner<Integer> spinnerForSide2 = new Spinner(1, 5, 1);

        GridPane gPane2 = new GridPane();
        gPane2.add(textForside2, 0, 0);
        gPane2.add(forDescrepSide2, 0, 3);
        gPane2.add(lblAmount2, 0, 9);
        gPane2.add(spinnerForSide2, 0, 10);
        gPane2.add(lblPrice6, 0, 11);
        //gPane2.add(addToCartSide2, 0, 15);

        VbForSide2.getChildren().add(gPane2);

        ChoiceBox cBForSide2 = new ChoiceBox();
        cBForSide2.getItems().add("without hot pepper");
        cBForSide2.getItems().add("without caramelized lemon");
        cBForSide2.setValue("without caramelized lemon");

        Label lblChoose2 = new Label("Choose:", cBForSide2);
        lblChoose2.setContentDisplay(ContentDisplay.BOTTOM);

        VBox forChoose2 = new VBox(70);
        forChoose2.getChildren().addAll(lblChoose2, addToCartSide2);

        hbForSide2.getChildren().addAll(iVForSide2, VbForSide2, forChoose2);
        hbForSide2.setPrefSize(30, 150);
        hbForSide2.setStyle("-fx-border-color:white;");

        HBox hbForSide3 = new HBox(50);
        hbForSide3.setPadding(new Insets(15, 15, 15, 15));

        Image imageForSide3 = new Image("/project/S3.jpg");
        ImageView iVForSide3 = new ImageView(imageForSide3);
        iVForSide3.setFitWidth(180);
        iVForSide3.setFitHeight(180);
        iVForSide3.setPreserveRatio(true);

        query.setParameter("orderName", "Chilli Squid");
        String sideName3 = (String) query.uniqueResult();
        queryP.setParameter("orderName", "Chilli Squid");
        Integer sidePrice3 = (Integer) queryP.uniqueResult();

        Text textForside3 = new Text(sideName3);
        textForside3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        VBox VbForSide3 = new VBox();
        Label forDescrepSide3 = new Label("crispy fried squid. shichimi spice.\n chilli + coriander dipping sauce.\n\n");
        Label lblAmount3 = new Label("Amount:");
        Label lblPrice7 = new Label("Price: " + String.valueOf(sidePrice3));
        Spinner<Integer> spinnerForSide3 = new Spinner(1, 5, 1);

        GridPane gPane3 = new GridPane();
        gPane3.add(textForside3, 0, 1);
        gPane3.add(forDescrepSide3, 0, 3);
        gPane3.add(lblAmount3, 0, 9);
        gPane3.add(spinnerForSide3, 0, 10);
        gPane3.add(lblPrice7, 0, 11);
        //gPane3.add(addToCartSide3, 0, 15);

        VbForSide3.getChildren().add(gPane3);

        ChoiceBox cBForSide3 = new ChoiceBox();
        cBForSide3.getItems().add("with coriander chili sause");
        cBForSide3.getItems().add("without pepper ");
        cBForSide3.setValue("with coriander chili sause");

        Label lblChoose3 = new Label("Choose:", cBForSide3);
        lblChoose3.setContentDisplay(ContentDisplay.BOTTOM);

        VBox forChoose3 = new VBox(70);
        forChoose3.getChildren().addAll(lblChoose3, addToCartSide3);

        hbForSide3.getChildren().addAll(iVForSide3, VbForSide3, forChoose3);
        hbForSide3.setPrefSize(30, 150);
        hbForSide3.setStyle("-fx-border-color:white;");

        HBox hbForSide4 = new HBox(50);
        hbForSide4.setPadding(new Insets(15, 15, 15, 15));

        Image imageForSide4 = new Image("/project/S4.jpg");
        ImageView iVForSide4 = new ImageView(imageForSide4);
        iVForSide4.setFitWidth(180);
        iVForSide4.setFitHeight(180);
        iVForSide4.setPreserveRatio(true);

        query.setParameter("orderName", "Suribachi Chicken Wings");
        String sideName4 = (String) query.uniqueResult();
        queryP.setParameter("orderName", "Suribachi Chicken Wings");
        Integer sidePrice4 = (Integer) queryP.uniqueResult();

        Text textForside4 = new Text(sideName4);
        textForside4.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        VBox VbForSide4 = new VBox();
        Label forDescrepSide4 = new Label("eight pieces of chicken wings in a spiced yakitori sauce,\n garnished with spring onions and sesame seeds.\n\n");
        Label lblAmount4 = new Label("Amount:");
        Label lblPrice8 = new Label("Price: " + String.valueOf(sidePrice4));
        Spinner<Integer> spinnerForSide4 = new Spinner(1, 5, 1);

        GridPane gPane4 = new GridPane();
        gPane4.add(textForside4, 0, 0);
        gPane4.add(forDescrepSide4, 0, 3);
        gPane4.add(lblAmount4, 0, 9);
        gPane4.add(spinnerForSide4, 0, 10);
        gPane4.add(lblPrice8, 0, 11);
        //gPane4.add(addToCartSide4, 0, 15);

        VbForSide4.getChildren().add(gPane4);

        ChoiceBox cBForSide4 = new ChoiceBox();
        cBForSide4.getItems().add("without green onions");
        cBForSide4.getItems().add("without pepper ");
        cBForSide4.setValue("without green onions");

        Label lblChoose4 = new Label("Choose:", cBForSide4);
        lblChoose4.setContentDisplay(ContentDisplay.BOTTOM);

        VBox forChoose4 = new VBox(70);
        forChoose4.getChildren().addAll(lblChoose4, addToCartSide4);

        hbForSide4.getChildren().addAll(iVForSide4, VbForSide4, forChoose4);
        hbForSide4.setPrefSize(30, 150);
        hbForSide4.setStyle("-fx-border-color:white;");

        VBox vv = new VBox();
        vv.getChildren().addAll(hbForSide1, hbForSide2, hbForSide3, hbForSide4);
        ScrollPane scrol2 = new ScrollPane(vv);
        scrol2.setFitToWidth(true);
        HBox boxForTop2 = new HBox();

        boxForTop2.getChildren().addAll(homePageB2, sidesB1, sidesB2, sidesB3, sidesB4);

        BorderPane mainPane2 = new BorderPane();
        mainPane2.setPrefSize(750, 650);
        mainPane2.setTop(boxForTop2);
        mainPane2.setCenter(scrol2);
        HBox h2 = new HBox(500);
        h2.getChildren().addAll(cart2, txTotal2);
        mainPane2.setBottom(h2);
   
        spinnerForSide1.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
        spinnerForSide2.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
        spinnerForSide3.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
        spinnerForSide4.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);

        Scene sceneSIDES = new Scene(mainPane2, 950, 650);
        sceneSIDES.getStylesheets().add(Project.class.getResource("Hbox.css").toExternalForm());

        /*
	 * THIS IS THE DESSERTS SCENE #THERD SCENE
         */
        // Start of First dessert 
        HBox boxForTop3 = new HBox();

        boxForTop3.getChildren().addAll(homePageB3, dessertB1, dessertB2, dessertB3, dessertB4);

        HBox firstDessertH = new HBox(50);
        firstDessertH.setPadding(new Insets(15, 15, 15, 15));
        VBox vvv = new VBox();
        firstDessertH.setPrefSize(30, 150);
        firstDessertH.setStyle("-fx-border-color: white;");

        javafx.scene.image.Image image1 = new javafx.scene.image.Image("/project/DS1.jpg");
        ImageView imageView = new ImageView(image1);
        imageView.setFitHeight(180);
        imageView.setFitWidth(180);
        imageView.setPreserveRatio(true);

        query.setParameter("orderName", "Japanese Cheese Cake");
        String dessertName1 = (String) query.uniqueResult();
        queryP.setParameter("orderName", "Japanese Cheese Cake");
        Integer dessertPrice1 = (Integer) queryP.uniqueResult();

        Text text = new Text(dessertName1);

        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        VBox vd = new VBox();

        Label lblA3 = new Label("Amount:");
        Spinner<Integer> spinner = new Spinner<>(1, 5, 1);
        Label lblP3 = new Label("Price: " + String.valueOf(dessertPrice1));
        Text cakeDescription = new Text("cake made with cream cheese, butter, sugar, and eggs.\n Has a fluffy texture");

        GridPane gp1 = new GridPane();
        gp1.setVgap(2);
        gp1.add(text, 0, 0);
        gp1.add(cakeDescription, 0, 3);
        gp1.add(lblA3, 0, 9);
        gp1.add(spinner, 0, 14);
        gp1.add(lblP3, 0, 15);

        vd.getChildren().addAll(gp1);

        VBox vd1 = new VBox(3);
        Label d1Label = new Label("Toppings");

        CheckBox firstCheckBox = new CheckBox("Strawberry");
        firstCheckBox.setIndeterminate(false);
        CheckBox secondCheckBox = new CheckBox("Chocolate");
        secondCheckBox.setIndeterminate(false);
        CheckBox thirdCheckBox = new CheckBox("Banana");
        thirdCheckBox.setIndeterminate(false);

        Label serveLbl = new Label("Serving option");
        RadioButton rb1 = new RadioButton("Warm");
        rb1.setUserData("Warm");
        RadioButton rb2 = new RadioButton("Cold");
        rb2.setUserData("Cold");
        ToggleGroup group = new ToggleGroup();

        rb1.setToggleGroup(group);
        rb1.setSelected(true);
        rb2.setToggleGroup(group);

        vd1.getChildren().addAll(d1Label, firstCheckBox, secondCheckBox, thirdCheckBox, serveLbl, rb1, rb2, addToCartDessert1);

        firstDessertH.getChildren().addAll(imageView, vd, vd1);
        // End of First dessert

        HBox secondDessertH = new HBox(50);// Start of Second dessert 
        secondDessertH.setPadding(new Insets(15, 15, 15, 15));
        secondDessertH.setPrefSize(30, 150);
        secondDessertH.setStyle("-fx-border-color: white;");

        javafx.scene.image.Image image2 = new javafx.scene.image.Image("/project/DS2.jpg");
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitHeight(180);
        imageView2.setFitWidth(180);
        imageView2.setPreserveRatio(true);

        query.setParameter("orderName", "Mochi");
        String dessertName2 = (String) query.uniqueResult();
        queryP.setParameter("orderName", "Mochi");
        Integer dessertPrice2 = (Integer) queryP.uniqueResult();

        Text text2 = new Text(dessertName2);

        text2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        VBox vd2 = new VBox();

        Label amountLbl = new Label("Amount:");
        Spinner<Integer> spinner2 = new Spinner<>(1, 5, 1);
        Label priceLbl = new Label("Price: " + String.valueOf(dessertPrice2));
        Text mochiDescription = new Text("Japanese dessert made of sweet glutinous rice flour \n or mochigome filled with ice cream");

        GridPane gp2 = new GridPane();
        gp2.setVgap(2);
        gp2.add(text2, 0, 0);
        gp2.add(mochiDescription, 0, 3);
        gp2.add(amountLbl, 0, 9);
        gp2.add(spinner2, 0, 14);
        gp2.add(priceLbl, 0, 15);
        vd2.getChildren().addAll(gp2);

        Label fillingLbl = new Label("Filling");
        ChoiceBox choiceBox = new ChoiceBox();

        choiceBox.getItems().add("Mango Ice Cream ");
        choiceBox.getItems().add("Strawberry Ice Cream  ");
        choiceBox.getItems().add("Vanilla Ice Cream ");
        choiceBox.getItems().add("Matcha Ice Cream ");
        choiceBox.setValue("Mango Ice Cream ");
        
        VBox vd3 = new VBox();
        vd3.getChildren().addAll(fillingLbl, choiceBox, addToCartDessert2);
        secondDessertH.getChildren().addAll(imageView2, vd2, vd3);
        // end of Second dessert      

        // Start of third dessert 
        HBox thirdDessertH = new HBox(50);
        thirdDessertH.setPadding(new Insets(15, 15, 15, 15));
        thirdDessertH.setPrefSize(30, 150);
        thirdDessertH.setStyle("-fx-border-color: white;");

        javafx.scene.image.Image image3 = new javafx.scene.image.Image("/project/DS3.jpg");
        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitHeight(180);
        imageView3.setFitWidth(180);
        imageView3.setPreserveRatio(true);

        query.setParameter("orderName", "Jelly Coffee");
        String dessertName3 = (String) query.uniqueResult();
        queryP.setParameter("orderName", "Jelly Coffee");
        Integer dessertPrice3 = (Integer) queryP.uniqueResult();

        Text text3 = new Text(dessertName3);

        text3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        VBox vd4 = new VBox();

        Label lblA4 = new Label("Amount:");
        Spinner<Integer> spinner3 = new Spinner<>(1, 5, 1);
        Label lblP4 = new Label("Price: " + String.valueOf(dessertPrice3));
        Text jellyDescription = new Text(" Jelly dessert flavored with coffee and sugar");

        GridPane gp3 = new GridPane();
        gp3.setVgap(2);
        gp3.add(text3, 0, 0);
        gp3.add(jellyDescription, 0, 3);
        gp3.add(lblA4, 0, 9);
        gp3.add(spinner3, 0, 14);
        gp3.add(lblP4, 0, 15);

        Label serveLb2 = new Label("Add whipped cream");
        RadioButton rb3 = new RadioButton(" Yes");
        rb3.setUserData("with whipped cream");
        RadioButton rb4 = new RadioButton("No");
        rb4.setUserData("without whipped cream");
        ToggleGroup group2 = new ToggleGroup();

        rb3.setToggleGroup(group2);
        rb3.setSelected(true);
        rb4.setToggleGroup(group2);
        vd4.getChildren().addAll(gp3);

        VBox vd5 = new VBox();

        HBox hboxAddCart = new HBox();
        hboxAddCart.setPadding(new Insets(30, 0, 0, 0));
        hboxAddCart.getChildren().add(addToCartDessert3);
        vd5.getChildren().addAll(serveLb2, rb3, rb4, hboxAddCart);
        thirdDessertH.getChildren().addAll(imageView3, vd4, vd5);
        // end of third dessert

        // Start of fourth dessert 
        HBox forthDessertH = new HBox(50);
        forthDessertH.setPadding(new Insets(15, 15, 15, 15));
        forthDessertH.setPrefSize(30, 150);
        forthDessertH.setStyle("-fx-border-color: white;");

        javafx.scene.image.Image image4 = new javafx.scene.image.Image("/project/DS4.jpg");
        ImageView imageView4 = new ImageView(image4);
        imageView4.setFitHeight(180);
        imageView4.setFitWidth(180);
        imageView4.setPreserveRatio(false);

        query.setParameter("orderName", "Pancake");
        String dessertName4 = (String) query.uniqueResult();
        queryP.setParameter("orderName", "Pancake");
        Integer dessertPrice4 = (Integer) queryP.uniqueResult();

        Text text4 = new Text(dessertName4);

        text4.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));
        VBox vd6 = new VBox();

        Label lblA5 = new Label("Amount:");
        Spinner<Integer> spinner4 = new Spinner<>(1, 5, 1);
        Label lblP5 = new Label("Price: " + String.valueOf(dessertPrice4));
        Text pancakeDescription = new Text("Our signature pancakes are made with a secret blend of buttermilk\n and fresh ingredients, resulting in a light and airy texture ");

        GridPane gp4 = new GridPane();
        gp4.setVgap(2);
        gp4.add(text4, 0, 0);
        gp4.add(pancakeDescription, 0, 3);
        gp4.add(lblA5, 0, 9);
        gp4.add(spinner4, 0, 14);
        gp4.add(lblP5, 0, 15);
        vd6.getChildren().addAll(gp4);

        VBox vd7 = new VBox();

        Label typesLbl = new Label("Choose a type of Pancake");
        ChoiceBox choiceBox2 = new ChoiceBox();

        choiceBox2.getItems().add("Regular Pancake ");
        choiceBox2.getItems().add("Fluffy Pancake  ");
        choiceBox2.getItems().add("Chocolate-stuffed Pancake ");
        choiceBox2.setValue("Regular Pancake ");

        Label toppingsLbl = new Label("Toppings");

        CheckBox fouthCheckBox = new CheckBox("Strawberry");
        firstCheckBox.setIndeterminate(false);
        CheckBox fifthCheckBox = new CheckBox("Chocolate");
        secondCheckBox.setIndeterminate(false);
        CheckBox sixthCheckBox = new CheckBox("Banana");
        thirdCheckBox.setIndeterminate(false);
        CheckBox seventhCheckBox = new CheckBox("Syrup");
        thirdCheckBox.setIndeterminate(false);

        vd7.getChildren().addAll(typesLbl, choiceBox2, toppingsLbl, fouthCheckBox, fifthCheckBox, sixthCheckBox, seventhCheckBox, addToCartDessert4);
        forthDessertH.getChildren().addAll(imageView4, vd6, vd7);
        // End of Fourth Dessert 

        vvv.getChildren().addAll(firstDessertH, secondDessertH, thirdDessertH, forthDessertH);

        ScrollPane scrol3 = new ScrollPane(vvv);
        scrol3.setFitToWidth(true);

        BorderPane mainPane3 = new BorderPane();
        mainPane3.setPrefSize(750, 650);
        mainPane3.setTop(boxForTop3);
        mainPane3.setCenter(scrol3);
        HBox h3 = new HBox(500);
        h3.getChildren().addAll(cart3, txTotal3);
        mainPane3.setBottom(h3);
   
        spinner.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
        spinner2.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
        spinner3.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
        spinner4.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);

        Scene sceneDESSERTS = new Scene(mainPane3, 950, 650);
        sceneDESSERTS.getStylesheets().add(Project.class.getResource("Hbox.css").toExternalForm());

        /*
	 * THIS IS THE DRINKS SCENE #FORTH SCENE
         */
        HBox boxForTop4 = new HBox();

        boxForTop4.getChildren().addAll(homePageB4, drinksB1, drinksB2, drinksB3, drinksB4);

        HBox hbForDrink1 = new HBox(50);
        hbForDrink1.setPadding(new Insets(15, 15, 15, 15));

        Image imageForDrink1 = new Image("/project/KoreanFlavouredMilk.jpg");
        ImageView ivForDrink1 = new ImageView(imageForDrink1);
        ivForDrink1.setFitWidth(200);
        ivForDrink1.setFitHeight(200);
        ivForDrink1.setPreserveRatio(true);

        query.setParameter("orderName", "Korean Flavoured Milk");
        String drinkName1 = (String) query.uniqueResult();
        queryP.setParameter("orderName", "Korean Flavoured Milk");
        Integer drinkPrice1 = (Integer) queryP.uniqueResult();

        Text textForDrink1 = new Text(drinkName1);
        textForDrink1.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        VBox vbForDrink1 = new VBox();
        Label forDescrepDrink1 = new Label("\nconsists of 80 percent milk\nand just a hint of flavour.\n\n");
        Label lblAmountDrink1 = new Label("Amount:");
        Label lblPriceDrink1 = new Label("Price: " + String.valueOf(drinkPrice1));
        Spinner<Integer> spinForAmountDrink1 = new Spinner<>(1, 5, 0);

        GridPane gpForDrink1 = new GridPane();
        gpForDrink1.add(textForDrink1, 0, 0);
        gpForDrink1.add(forDescrepDrink1, 0, 3);
        gpForDrink1.add(lblAmountDrink1, 0, 9);
        gpForDrink1.add(spinForAmountDrink1, 0, 14);
        gpForDrink1.add(lblPriceDrink1, 0, 15);

        vbForDrink1.getChildren().add(gpForDrink1);
        Label lblChooseDrink1 = new Label("Choose Favourite Flavour:");
        ListView<String> lvForDrink1 = new ListView<>();
        lvForDrink1.setPrefSize(100, 100);
        lvForDrink1.getItems().add("Banana");
        lvForDrink1.getItems().add("Strawberry");
        lvForDrink1.getItems().add("Banana Light");
        lvForDrink1.getItems().add("Melon");
        lvForDrink1.getSelectionModel().select(0);

        VBox forChooseDrink1 = new VBox(10);
        forChooseDrink1.getChildren().addAll(lblChooseDrink1, lvForDrink1, addToCartDrinks1);

        hbForDrink1.getChildren().addAll(ivForDrink1, vbForDrink1, forChooseDrink1);
        hbForDrink1.setPrefSize(30, 150);
        hbForDrink1.setStyle("-fx-border-color:white;");

        HBox hbForDrink2 = new HBox(50);
        hbForDrink2.setPadding(new Insets(15, 15, 15, 15));

        Image imageForDrink2 = new Image("/project/ThaiBubbleTea.jpg");
        ImageView ivForDrink2 = new ImageView(imageForDrink2);
        ivForDrink2.setFitWidth(200);
        ivForDrink2.setFitHeight(200);
        ivForDrink2.setPreserveRatio(true);

        query.setParameter("orderName", "Thai Bubble Tea");
        String drinkName2 = (String) query.uniqueResult();
        queryP.setParameter("orderName", "Thai Bubble Tea");
        Integer drinkPrice2 = (Integer) queryP.uniqueResult();

        Text textForDrink2 = new Text(drinkName2);
        textForDrink2.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        VBox vbForDrink2 = new VBox();
        Label forDescrepDrink2 = new Label("\nconsists of black tea, condensed milk,\nevaporated milk and boba.\n\n");
        Label lblAmountDrink2 = new Label("Amount:");
        Label lblPriceDrink2 = new Label("Price: " + String.valueOf(drinkPrice2));
        Spinner<Integer> spinForAmountDrink2 = new Spinner<>(1, 5, 0);

        GridPane gpForDrink2 = new GridPane();
        gpForDrink2.add(textForDrink2, 0, 0);
        gpForDrink2.add(forDescrepDrink2, 0, 3);
        gpForDrink2.add(lblAmountDrink2, 0, 9);
        gpForDrink2.add(spinForAmountDrink2, 0, 14);
        gpForDrink2.add(lblPriceDrink2, 0, 15);

        vbForDrink2.getChildren().add(gpForDrink2);
        Label lblChooseDrink2 = new Label("Choose Milk Type:");
        ComboBox<String> cbForDrink2 = new ComboBox<>();
        cbForDrink2.setEditable(false);
        cbForDrink2.getItems().add("Whole Milk");
        cbForDrink2.getItems().add("Skim Milk");
        cbForDrink2.getItems().add("Almond Milk");
        cbForDrink2.getItems().add("Coconut Milk");
        cbForDrink2.setValue("Whole Milk");

        Label lblNoteDrink2 = new Label("Note:");
        TextField tfForDrink2 = new TextField();

        Label lblMsgForDrink2 = new Label();
        lblMsgForDrink2.setStyle("-fx-text-fill: red;");
        VBox forChooseDrink2 = new VBox(10);
        forChooseDrink2.getChildren().addAll(lblChooseDrink2, cbForDrink2, lblNoteDrink2, tfForDrink2, lblMsgForDrink2, addToCartDrinks2);

        hbForDrink2.getChildren().addAll(ivForDrink2, vbForDrink2, forChooseDrink2);
        hbForDrink2.setPrefSize(30, 150);
        hbForDrink2.setStyle("-fx-border-color:white;");

        HBox hbForDrink3 = new HBox(50);
        hbForDrink3.setPadding(new Insets(15, 15, 15, 15));

        Image imageForDrink3 = new Image("/project/JapaneseMatchaLatte.jpg");
        ImageView ivForDrink3 = new ImageView(imageForDrink3);
        ivForDrink3.setFitWidth(200);
        ivForDrink3.setFitHeight(200);
        ivForDrink3.setPreserveRatio(true);

        query.setParameter("orderName", "Japanese Matcha Latte");
        String drinkName3 = (String) query.uniqueResult();
        queryP.setParameter("orderName", "Japanese Matcha Latte");
        Integer drinkPrice3 = (Integer) queryP.uniqueResult();

        Text textForDrink3 = new Text(drinkName3);
        textForDrink3.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        VBox vbForDrink3 = new VBox();
        Label forDescrepDrink3 = new Label("\nconsists of green tea powder and milk,\nto create a smooth, creamy and caffeinated.\n\n");
        Label lblAmountDrink3 = new Label("Amount:");
        Label lblPriceDrink3 = new Label("Price: " + String.valueOf(drinkPrice3));
        Spinner<Integer> spinForAmountDrink3 = new Spinner<>(1, 5, 0);

        GridPane gpForDrink3 = new GridPane();
        gpForDrink3.add(textForDrink3, 0, 0);
        gpForDrink3.add(forDescrepDrink3, 0, 3);
        gpForDrink3.add(lblAmountDrink3, 0, 9);
        gpForDrink3.add(spinForAmountDrink3, 0, 14);
        gpForDrink3.add(lblPriceDrink3, 0, 15);
        vbForDrink3.getChildren().add(gpForDrink3);

        Label lblChooseDrink3 = new Label("Choose Drink Type:");
        RadioButton rbForColdDrink3 = new RadioButton("Cold");
        rbForColdDrink3.setUserData("Cold");
        RadioButton rbForHotDrink3 = new RadioButton("Hot");
        rbForHotDrink3.setUserData("Hot");
        rbForHotDrink3.setSelected(true);

        Label lblNoteDrink3 = new Label("Note:");
        TextField tfForDrink3 = new TextField();

        Label lblMsgForDrink3 = new Label();
        lblMsgForDrink3.setStyle("-fx-text-fill: red;");

        VBox forChooseDrink3 = new VBox(5);
        forChooseDrink3.getChildren().addAll(lblChooseDrink3, rbForColdDrink3, rbForHotDrink3, lblNoteDrink3, tfForDrink3, lblMsgForDrink3, addToCartDrinks3);
        ToggleGroup tgForDrink3 = new ToggleGroup();
        rbForColdDrink3.setToggleGroup(tgForDrink3);
        rbForHotDrink3.setToggleGroup(tgForDrink3);

        hbForDrink3.getChildren().addAll(ivForDrink3, vbForDrink3, forChooseDrink3);
        hbForDrink3.setPrefSize(30, 150);
        hbForDrink3.setStyle("-fx-border-color:white;");

        HBox hbForDrink4 = new HBox(50);
        hbForDrink4.setPadding(new Insets(15, 15, 15, 15));

        Image imageForDrink4 = new Image("/project/KoreanMaximCoffee.jpg");
        ImageView ivForDrink4 = new ImageView(imageForDrink4);
        ivForDrink4.setFitWidth(180);
        ivForDrink4.setFitHeight(180);
        ivForDrink4.setPreserveRatio(true);

        query.setParameter("orderName", "Korean Maxim Coffee");
        String drinkName4 = (String) query.uniqueResult();
        queryP.setParameter("orderName", "Korean Maxim Coffee");
        Integer drinkPrice4 = (Integer) queryP.uniqueResult();

        Text textForDrink4 = new Text(drinkName4);
        textForDrink4.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 15));

        VBox vbForDrink4 = new VBox();
        Label forDescrepDrink4 = new Label("\ninstant coffee flavoured\nby Mocha Gold Mild.\n\n");
        Label lblAmountDrink4 = new Label("Amount:");
        Label lblPriceDrink4 = new Label("Price: " + String.valueOf(drinkPrice4));
        Spinner<Integer> spinForAmountDrink4 = new Spinner<>(1, 5, 0);
        GridPane gpForDrink4 = new GridPane();
        gpForDrink4.add(textForDrink4, 0, 0);
        gpForDrink4.add(forDescrepDrink4, 0, 3);
        gpForDrink4.add(lblAmountDrink4, 0, 9);
        gpForDrink4.add(spinForAmountDrink4, 0, 14);
        gpForDrink4.add(lblPriceDrink4, 0, 15);
        vbForDrink4.getChildren().add(gpForDrink4);

        Label lblChooseDrink4 = new Label("Do you want Coffee:");
        RadioButton rbForDIDrink4 = new RadioButton("Dine In");
        rbForDIDrink4.setUserData("Dine In");
        RadioButton rbForTKDrink4 = new RadioButton("Take Away");
        rbForTKDrink4.setUserData("Take Away");
        rbForDIDrink4.setSelected(true);

        Label lblDeterDrink4 = new Label("Determine Sugar Packets:");
        Slider sdForDrink4 = new Slider();
        sdForDrink4.setMin(0);
        sdForDrink4.setMax(2);
        sdForDrink4.setValue(1);
        sdForDrink4.setMajorTickUnit(1);
        sdForDrink4.setMinorTickCount(0);
        sdForDrink4.setShowTickMarks(true);
        sdForDrink4.setShowTickLabels(true);
        sdForDrink4.setSnapToTicks(true);

        sdForDrink4.setLabelFormatter(new StringConverter<Double>() {
            public String toString(Double n) {
                if (n < 0.5) {
                    return "No";
                }
                if (n < 1.5) {
                    return "One";
                }

                return "Two";
            }

            @Override
            public Double fromString(String s) {
                switch (s) {
                    case "No":
                        return 0d;
                    case "One":
                        return 1d;
                    case "Two":
                        return 2d;
                    default:
                        return 1d;
                }
            }
        });

        VBox forChooseDrink4 = new VBox(10);
        forChooseDrink4.getChildren().addAll(lblChooseDrink4, rbForDIDrink4, rbForTKDrink4, lblDeterDrink4, sdForDrink4, addToCartDrinks4);
        ToggleGroup tgForDrink4 = new ToggleGroup();
        rbForDIDrink4.setToggleGroup(tgForDrink4);
        rbForTKDrink4.setToggleGroup(tgForDrink4);

        hbForDrink4.getChildren().addAll(ivForDrink4, vbForDrink4, forChooseDrink4);
        hbForDrink4.setPrefSize(30, 150);
        hbForDrink4.setStyle("-fx-border-color:white;");

        VBox vvvv = new VBox();
        vvvv.getChildren().addAll(hbForDrink1, hbForDrink2, hbForDrink3, hbForDrink4);
        ScrollPane scrol4 = new ScrollPane(vvvv);
        scrol4.setFitToWidth(true);

        BorderPane mainPane4 = new BorderPane();
        mainPane4.setPrefSize(750, 650);
        mainPane4.setTop(boxForTop4);
        mainPane4.setCenter(scrol4);
        HBox h4 = new HBox(500);
        h4.getChildren().addAll(cart4, txTotal4);
        mainPane4.setBottom(h4);
        
        spinForAmountDrink1.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
        spinForAmountDrink2.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
        spinForAmountDrink3.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);
        spinForAmountDrink4.getStyleClass().add(Spinner.STYLE_CLASS_SPLIT_ARROWS_HORIZONTAL);

        Scene sceneDRINKS = new Scene(mainPane4, 950, 650);
        sceneDRINKS.getStylesheets().add(Project.class.getResource("Hbox.css").toExternalForm());

        mainCourseB1.setId("appetizerButton");
        mainCourseB2.setId("sidesButton");
        mainCourseB3.setId("dessertButton");
        mainCourseB4.setId("drinkButton");
        homePageB1.setId("HomeButton");

        sidesB1.setId("appetizerButton");
        sidesB2.setId("sidesButton");
        sidesB3.setId("dessertButton");
        sidesB4.setId("drinkButton");
        homePageB2.setId("HomeButton");

        dessertB1.setId("appetizerButton");
        dessertB2.setId("sidesButton");
        dessertB3.setId("dessertButton");
        dessertB4.setId("drinkButton");
        homePageB3.setId("HomeButton");

        drinksB1.setId("appetizerButton");
        drinksB2.setId("sidesButton");
        drinksB3.setId("dessertButton");
        drinksB4.setId("drinkButton");
        homePageB4.setId("HomeButton");

        String css = this.getClass().getResource("ProjectStyling.css").toExternalForm();

        sceneMainCourse.getStylesheets().add(css);
        sceneSIDES.getStylesheets().add(css);
        sceneDESSERTS.getStylesheets().add(css);
        sceneDRINKS.getStylesheets().add(css);


        /*
	 * FINAL SCENE #CART SCENE"
         */
        ObservableList<tableData> data = FXCollections.observableArrayList();
        TableView<tableData> cartTable = new TableView<tableData>(data);

        Label cartLabeBill = new Label("ORDER NUMBER: " + BillNumber);
        Label cartLabel = new Label("YOUR ORDER: ");
        cartLabel.setMinWidth(50);
        cartLabel.setMinHeight(50);

        cartTable.setEditable(false);

        TableColumn<tableData, String> nameCol = new TableColumn<>("name");//the name in the table
        nameCol.setCellValueFactory(
                new PropertyValueFactory<tableData, String>("dishName"));//the datafield from tableData
        nameCol.setPrefWidth(75);

        TableColumn<tableData, Integer> quantityCol = new TableColumn<>("q");//the name in the table
        quantityCol.setCellValueFactory(
                new PropertyValueFactory<tableData, Integer>("Quantity"));//the datafield from tableData
        quantityCol.setPrefWidth(25);

        TableColumn<tableData, String> orderCol = new TableColumn<>("Order");
        orderCol.setCellValueFactory(
                new PropertyValueFactory<tableData, String>("Order"));
        orderCol.setPrefWidth(450);

        TableColumn<tableData, Double> totalCol = new TableColumn<>("total Price (SR)");
        totalCol.setCellValueFactory(
                new PropertyValueFactory<tableData, Double>("Price"));
        totalCol.setPrefWidth(100);

        cartTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        cartTable.getColumns().add(nameCol);
        cartTable.getColumns().add(quantityCol);
        cartTable.getColumns().add(orderCol);
        cartTable.getColumns().add(totalCol);

        VBox vCart = new VBox(10);

        HBox hButton = new HBox(150);
        hButton.getChildren().addAll(back, delete, complete);
        hButton.setAlignment(Pos.CENTER);

        HBox hButton1 = new HBox();
        hButton1.getChildren().add(btnExportInvoice);
        hButton1.setAlignment(Pos.CENTER);

        ScrollPane scrollpane = new ScrollPane(cartTable);
        scrollpane.setFitToWidth(true);
        scrollpane.setFitToHeight(true);

        Label programerL = new Label("Are you a Programmer helped in SAKURA?");

        TextField proField = new TextField();
        proField.setId("proFiled");

        HBox proHB = new HBox(10);
        Label programerL1 = new Label("Write your ID:");

        Label totalLabel = new Label("TOTAL :");
        TextField tx = new TextField("" + fTotal);
        tx.setEditable(false);
        VBox vTOTAL = new VBox();
        vTOTAL.getChildren().add(totalLabel);
        vTOTAL.setPadding(new Insets(0, 0, 0, 100));

        proHB.getChildren().addAll(programerL1, proField, vTOTAL, tx);

        vCart.setPadding(new Insets(50, 20, 10, 10));
        vCart.getChildren().addAll(cartLabeBill, cartLabel, scrollpane, programerL, proHB, hButton, hButton1);

        BorderPane cartMainPane = new BorderPane();
        cartMainPane.setCenter(vCart);

        Scene cartScene = new Scene(cartMainPane, 950, 650);
        cartScene.getStylesheets().add(Project.class.getResource("cssInvoice.css").toExternalForm());

        //BUTTON SWITCING ACTION BETWEEN SCENES
        String audioFilePath = "C:\\Users\\epad\\Music\\Mouse_Click_2-fesliyanstudios.com.mp3";
        Media sound = new Media(new File(audioFilePath).toURI().toString());
        MediaPlayer mediaPlayer2 = new MediaPlayer(sound);

        String audioFilePath2 = "C:\\Users\\epad\\Music\\Mouse_Click_2-fesliyanstudios.com.mp3";
        Media sound2 = new Media(new File(audioFilePath2).toURI().toString());
        MediaPlayer mediaPlayer3 = new MediaPlayer(sound2);

        String audioFilePath3 = "C:\\Users\\epad\\Music\\Mouse_Click_2-fesliyanstudios.com.mp3";
        Media sound3 = new Media(new File(audioFilePath3).toURI().toString());
        MediaPlayer mediaPlayer4 = new MediaPlayer(sound3);

        String audioFilePath4 = "C:\\Users\\epad\\Music\\Mouse_Click_2-fesliyanstudios.com.mp3";
        Media sound4 = new Media(new File(audioFilePath4).toURI().toString());
        MediaPlayer mediaPlayer5 = new MediaPlayer(sound4);

        String audioFilePath5 = "C:\\Users\\epad\\Music\\Mouse_Click_2-fesliyanstudios.com.mp3";
        Media sound5 = new Media(new File(audioFilePath5).toURI().toString());
        MediaPlayer mediaPlayer6 = new MediaPlayer(sound5);

        String audioFilePath6 = "C:\\Users\\epad\\Music\\Mouse_Click_2-fesliyanstudios.com.mp3";
        Media sound6 = new Media(new File(audioFilePath6).toURI().toString());
        MediaPlayer mediaPlayer7 = new MediaPlayer(sound6);

        b.setOnMouseReleased(e -> mediaPlayer2.setAutoPlay(true));
        b.setOnAction(e -> stage.setScene(sceneMainCourse));
        mainCourseB1.setOnMouseReleased(e -> mediaPlayer3.setAutoPlay(true));
        mainCourseB1.setOnAction(e -> stage.setScene(sceneMainCourse));//FIRST SCENE
        mainCourseB2.setOnMouseReleased(e -> mediaPlayer4.setAutoPlay(true));
        mainCourseB2.setOnAction(e -> stage.setScene(sceneSIDES));
        mainCourseB3.setOnMouseReleased(e -> mediaPlayer5.setAutoPlay(true));
        mainCourseB3.setOnAction(e -> stage.setScene(sceneDESSERTS));
        mainCourseB4.setOnMouseReleased(e -> mediaPlayer6.setAutoPlay(true));
        mainCourseB4.setOnAction(e -> stage.setScene(sceneDRINKS));
        homePageB1.setOnMouseReleased(e -> mediaPlayer7.setAutoPlay(true));
        homePageB1.setOnAction(e -> stage.setScene(scene));

        sidesB1.setOnMouseReleased(e -> mediaPlayer3.setAutoPlay(true));
        sidesB1.setOnAction(e -> stage.setScene(sceneMainCourse));//SECOND SCENE
        sidesB2.setOnMouseReleased(e -> mediaPlayer4.setAutoPlay(true));
        sidesB2.setOnAction(e -> stage.setScene(sceneSIDES));
        sidesB3.setOnMouseReleased(e -> mediaPlayer5.setAutoPlay(true));
        sidesB3.setOnAction(e -> stage.setScene(sceneDESSERTS));
        sidesB4.setOnMouseReleased(e -> mediaPlayer6.setAutoPlay(true));
        sidesB4.setOnAction(e -> stage.setScene(sceneDRINKS));
        homePageB2.setOnMouseReleased(e -> mediaPlayer7.setAutoPlay(true));
        homePageB2.setOnAction(e -> stage.setScene(scene));

        dessertB1.setOnMouseReleased(e -> mediaPlayer3.setAutoPlay(true));
        dessertB1.setOnAction(e -> stage.setScene(sceneMainCourse));//THERD SCENE
        dessertB2.setOnMouseReleased(e -> mediaPlayer4.setAutoPlay(true));
        dessertB2.setOnAction(e -> stage.setScene(sceneSIDES));
        dessertB3.setOnMouseReleased(e -> mediaPlayer5.setAutoPlay(true));
        dessertB3.setOnAction(e -> stage.setScene(sceneDESSERTS));
        dessertB4.setOnMouseReleased(e -> mediaPlayer6.setAutoPlay(true));
        dessertB4.setOnAction(e -> stage.setScene(sceneDRINKS));
        homePageB3.setOnMouseReleased(e -> mediaPlayer7.setAutoPlay(true));
        homePageB3.setOnAction(e -> stage.setScene(scene));
        
        drinksB1.setOnMouseReleased(e -> mediaPlayer3.setAutoPlay(true));
        drinksB1.setOnAction(e -> stage.setScene(sceneMainCourse));//FORTH SCENE
        drinksB2.setOnMouseReleased(e -> mediaPlayer4.setAutoPlay(true));
        drinksB2.setOnAction(e -> stage.setScene(sceneSIDES));
        drinksB3.setOnMouseReleased(e -> mediaPlayer5.setAutoPlay(true));
        drinksB3.setOnAction(e -> stage.setScene(sceneDESSERTS));
        drinksB4.setOnMouseReleased(e -> mediaPlayer6.setAutoPlay(true));
        drinksB4.setOnAction(e -> stage.setScene(sceneDRINKS));
        homePageB4.setOnMouseReleased(e -> mediaPlayer7.setAutoPlay(true));
        homePageB4.setOnAction(e -> stage.setScene(scene));

        //CART SWITCHIN SCENE
        String audioFilePath7 = "C:\\Users\\epad\\Music\\Mouse_Click_2-fesliyanstudios.com.mp3";
        Media sound7 = new Media(new File(audioFilePath7).toURI().toString());
        MediaPlayer mediaPlayer8 = new MediaPlayer(sound7);

        cart1.setOnMouseReleased(e -> mediaPlayer8.setAutoPlay(true));
        cart1.setOnAction(e -> stage.setScene(cartScene));
        cart2.setOnMouseReleased(e -> mediaPlayer8.setAutoPlay(true));
        cart2.setOnAction(e -> stage.setScene(cartScene));
        cart3.setOnMouseReleased(e -> mediaPlayer8.setAutoPlay(true));
        cart3.setOnAction(e -> stage.setScene(cartScene));
        cart4.setOnMouseReleased(e -> mediaPlayer8.setAutoPlay(true));
        cart4.setOnAction(e -> stage.setScene(cartScene));

        String audioFilePath8 = "C:\\Users\\epad\\Music\\Mouse_Click_2-fesliyanstudios.com.mp3";
        Media sound8 = new Media(new File(audioFilePath8).toURI().toString());
        MediaPlayer mediaPlayer9 = new MediaPlayer(sound8);
        
        back.setOnMouseReleased(e -> mediaPlayer9.setAutoPlay(true));
        back.setOnAction(e -> stage.setScene(sceneMainCourse));
        
        delete.setOnMouseClicked(e -> {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setHeaderText("Deleting Item!");
            alert.setContentText("you want to delete:\n" + cartTable.getSelectionModel().getSelectedItem() + "?");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                int selectedIndex = cartTable.getSelectionModel().getSelectedIndex();
                double totalDeleteIt = totalCol.getCellObservableValue(selectedIndex).getValue();
                fTotal = fTotal - totalDeleteIt;
                tx.setText(fTotal + "");
                cartTable.getItems().remove(selectedIndex);

            }
        });

        homePageB1.setOnMouseMoved(e
                -> {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setContentText("All Items Will be Deleted");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                cartTable.getItems().removeAll(data);
                stage.setScene(scene);
            }

        });

        homePageB2.setOnMouseMoved(e
                -> {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setContentText("All Items Will be Deleted");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                cartTable.getItems().removeAll(data);
                stage.setScene(scene);
            }

        });

        homePageB3.setOnMouseMoved(e
                -> {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setContentText("All Items Will be Deleted");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                cartTable.getItems().removeAll(data);
                stage.setScene(scene);
            }

        });

        homePageB4.setOnMouseMoved(e
                -> {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setContentText("All Items Will be Deleted");

            Optional<ButtonType> result = alert.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                cartTable.getItems().removeAll(data);
                stage.setScene(scene);
            }

        });

        mainPane1.setPadding(new Insets(5, 10, 5, 7));
        mainPane2.setPadding(new Insets(5, 10, 5, 7));
        mainPane3.setPadding(new Insets(5, 10, 5, 7));
        mainPane4.setPadding(new Insets(5, 10, 5, 7));
        cartMainPane.setPadding(new Insets(5, 20, 5, 20));

        //Add cart action
        //addToCartDish1  addToCartSide1   addToCartDessert1  addToCartDrinks1
        addToCartDish1.setOnAction(e -> {
            int quantity = spinnerForDish1.getValue();

            String name = dishName1;  //the name from database 
            int price = dishPrice1;//here the price from database too
            double totalPrice = quantity * price;

            String order = " " + cbo1.getValue() + " " + getHeatDegree(heatSlider1);
            data.add(new tableData(name, quantity, order, totalPrice));
            fTotal += totalPrice;
            tx.setText(fTotal + "");
        });

        addToCartDish2.setOnAction(e -> {
            int quantity = spinnerForDish2.getValue();

            String name = dishName2;  //the name from database 
            int price = dishPrice2;//here the price from database too
            double totalPrice = quantity * price;

            String order = " " + cbo2.getValue() + " " + getHeatDegree(heatSlider2);
            data.add(new tableData(name, quantity, order, totalPrice));
            fTotal += totalPrice;
            tx.setText(fTotal + "");

        });

        addToCartDish3.setOnAction(e -> {
            int quantity = spinnerForDish3.getValue();

            String name = dishName3;  //the name from database 
            int price = dishPrice3;//here the price from database too
            double totalPrice = quantity * price;

            String order = " " + cbo3.getValue() + " " + getHeatDegree(heatSlider3);
            data.add(new tableData(name, quantity, order, totalPrice));
            fTotal += totalPrice;
            tx.setText(fTotal + "");

        });

        addToCartDish4.setOnAction(e -> {
            int quantity = spinnerForDish4.getValue();

            String name = dishName4;  //the name from database 
            int price = dishPrice4;//here the price from database too
            double totalPrice = quantity * price;

            String order = " " + cbo4.getValue() + " " + getHeatDegree(heatSlider4);
            data.add(new tableData(name, quantity, order, totalPrice));
            fTotal += totalPrice;
            tx.setText(fTotal + "");
        });

        addToCartSide1.setOnAction(e -> {
            int quantity = spinnerForSide1.getValue();

            String name = sideName1;  //the name from database 
            int price = sidePrice1;      //here the price from database too
            double totalPrice = quantity * price;

            String order = " " + cBForSide1.getValue();

            data.add(new tableData(name, quantity, order, totalPrice));
            fTotal += totalPrice;
            tx.setText(fTotal + "");
        });

        addToCartSide2.setOnAction(e -> {
            int quantity = spinnerForSide2.getValue();
            
            String name = sideName2;  //the name from database 
            int price = sidePrice2;      //here the price from database too
            double totalPrice = quantity * price;

            String order = " " + cBForSide2.getValue();

            data.add(new tableData(name, quantity, order, totalPrice));
            fTotal += totalPrice;
            tx.setText(fTotal + "");
        });

        addToCartSide3.setOnAction(e -> {
            int quantity = spinnerForSide3.getValue();

            String name = sideName3;  //the name from database 
            int price = sidePrice3;      //here the price from database too
            double totalPrice = quantity * price;

            String order = " " + cBForSide3.getValue();

            data.add(new tableData(name, quantity, order, totalPrice));
            fTotal += totalPrice;
            tx.setText(fTotal + "");
        });

        addToCartSide4.setOnAction(e -> {
            int quantity = spinnerForSide4.getValue();

            String name = sideName4;  //the name from database 
            int price = sidePrice4;      //here the price from database too
            double totalPrice = quantity * price;

            String order = " " + cBForSide4.getValue();

            data.add(new tableData(name, quantity, order, totalPrice));
            fTotal += totalPrice;
            tx.setText(fTotal + "");
        });

        addToCartDessert1.setOnAction(e -> {
            int quantity = spinner.getValue();

            String nameDessert1 = dessertName1;  //the name from database 
            int price = dessertPrice1;//here the price from database too

            String order = " ";
            if (firstCheckBox.isSelected()) {
                order += firstCheckBox.getText() + ", ";
                price += 2;
            }

            if (secondCheckBox.isSelected()) {
                order += secondCheckBox.getText() + ", ";
                price += 3;
            }

            if (thirdCheckBox.isSelected()) {
                order += thirdCheckBox.getText() + ", ";
                price += 3;
            }

            double totalPrice = quantity * price;
            order += group.getSelectedToggle().getUserData().toString();
            data.add(new tableData(nameDessert1, quantity, order, totalPrice));
            fTotal += totalPrice;
            tx.setText(fTotal + "");

        });

        addToCartDessert2.setOnAction(e -> {
            int quantity = spinner2.getValue();

            String nameDessert2 = dessertName2;  //the name from database 
            int price = dessertPrice2;//here the price from database too
            double totalPriceDessert2 = quantity * price;

            String orderDessert2 = "filling option " + choiceBox.getValue();
            data.add(new tableData(nameDessert2, quantity, orderDessert2, totalPriceDessert2));
            fTotal += totalPriceDessert2;
            tx.setText(fTotal + "");

        });

        addToCartDessert3.setOnAction(e -> {
            int quantity = spinner3.getValue();

            String nameDessert3 = dessertName3;  //the name from database 
            int price = dessertPrice3;//here the price from database too
            double totalPriceDessert3 = quantity * price;

            String orderDessert3 = " Whipped cream " + group2.getSelectedToggle().getUserData().toString();
            data.add(new tableData(nameDessert3, quantity, orderDessert3, totalPriceDessert3));

            fTotal += totalPriceDessert3;
            tx.setText(fTotal + "");
        });

        addToCartDessert4.setOnAction(e -> {
            int quantity = spinner4.getValue();

            Transaction transactionDS4 = session.beginTransaction();
            transactionDS4.commit();

            String nameDessert4 = dessertName4;  //the name from database 
            int price = dessertPrice4;//here the price from database too

            String order = " ";

            if (fouthCheckBox.isSelected()) {
                order += fouthCheckBox.getText() + ", ";
                price += 2;
            }

            if (fifthCheckBox.isSelected()) {
                order += fifthCheckBox.getText() + ", ";
                price += 3;
            }

            if (sixthCheckBox.isSelected()) {
                order += sixthCheckBox.getText() + ", ";
                price += 3;
            }
            if (seventhCheckBox.isSelected()) {
                order += seventhCheckBox.getText() + ", ";
                price += 4;
            }
            double totalPriceDessert4 = quantity * price;

            String orderDessert4 = order + " pancake type " + choiceBox2.getValue();
            data.add(new tableData(nameDessert4, quantity, orderDessert4, totalPriceDessert4));
            fTotal += totalPriceDessert4;
            tx.setText(fTotal + "");

        });

        addToCartDrinks1.setOnAction(e -> {
            int quantity = spinForAmountDrink1.getValue();

            String nameDrink1 = drinkName1;  //the name from database 
            int priceDrink1 = drinkPrice1;  //here the price from database too
            double totalPriceDrink1 = quantity * priceDrink1;

            String orderDrink1 = " favourite flavour: " + lvForDrink1.getSelectionModel().getSelectedItem();

            data.add(new tableData(nameDrink1, quantity, orderDrink1, totalPriceDrink1));
            fTotal += totalPriceDrink1;
            tx.setText(fTotal + "");
        });

        addToCartDrinks2.setOnAction(e -> {
            int quantity = spinForAmountDrink2.getValue();

            String nameDrink2 = drinkName2;  //the name from database 
            int priceDrink2 = drinkPrice2;  //here the price from database too
            double totalPriceDrink2 = quantity * priceDrink2;

            String strNtForDrink2 = tfForDrink2.getText();
            lblMsgForDrink2.setText(null);

            if (strNtForDrink2.matches("^[0-9]+$")) {
                lblMsgForDrink2.setText("Please enter a correct note.");
            } else if (strNtForDrink2.isEmpty()) {
                tfForDrink2.setText("nothing");
                String orderDrink2 = nameDrink2 + " milk type: " + cbForDrink2.getValue() + " special order: " + tfForDrink2.getText();

                data.add(new tableData(nameDrink2, quantity, orderDrink2, totalPriceDrink2));
            } else {
                String orderDrink2 = " milk type: " + cbForDrink2.getValue() + " special order: " + tfForDrink2.getText();

                data.add(new tableData(nameDrink2, quantity, orderDrink2, totalPriceDrink2));

            }
            fTotal += totalPriceDrink2;
            tx.setText(fTotal + "");
        });

        addToCartDrinks3.setOnAction(e -> {
            int quantity = spinForAmountDrink3.getValue();

            String nameDrink3 = drinkName3;  //the name from database 
            int priceDrink3 = drinkPrice3;  //here the price from database too
            double totalPriceDrink3 = quantity * priceDrink3;

            String strNtForDrink3 = tfForDrink3.getText();
            lblMsgForDrink3.setText(null);

            if (strNtForDrink3.matches("^[0-9]+$")) {
                lblMsgForDrink3.setText("Please enter a correct note.");
            } else if (strNtForDrink3.isEmpty()) {
                tfForDrink3.setText("nothing");
                String orderDrink3 = nameDrink3 + " drink type: " + tgForDrink3.getSelectedToggle().getUserData().toString() + " special order: " + tfForDrink3.getText();

                data.add(new tableData(nameDrink3, quantity, orderDrink3, totalPriceDrink3));
            } else {
                String orderDrink3 = " drink type: " + tgForDrink3.getSelectedToggle().getUserData().toString() + " special order: " + tfForDrink3.getText();

                data.add(new tableData(nameDrink3, quantity, orderDrink3, totalPriceDrink3));
            }
            fTotal += totalPriceDrink3;
            tx.setText(fTotal + "");
        });

        addToCartDrinks4.setOnAction(e -> {
            int quantity = spinForAmountDrink4.getValue();

            String nameDrink4 = drinkName4;  //the name from database 
            int priceDrink4 = drinkPrice4;  //here the price from database too
            double totalPriceDrink4 = quantity * priceDrink4;

            String strSugerLevel = " ";
            if (sdForDrink4.getValue() == 0) {
                strSugerLevel = "no sugar packet";

            } else if (sdForDrink4.getValue() == 1) {
                strSugerLevel = "1 sugar packet";

            } else if (sdForDrink4.getValue() == 2) {
                strSugerLevel = "2 Sugar packets";
            }

            String orderDrink4 = " want coffee: " + tgForDrink4.getSelectedToggle().getUserData().toString() + " sugar packet: " + strSugerLevel;

            data.add(new tableData(nameDrink4, quantity, orderDrink4, totalPriceDrink4));
            fTotal += totalPriceDrink4;
            tx.setText(fTotal + "");
        });

        complete.setOnAction(e -> {
            List<invoice> lstInvoice = new ArrayList<>();
            Session session1 = HibernateUtil.getSessionFactory().openSession();
            Query query2 = session1.createQuery("from invoice");
            lstInvoice = query2.list();
            session1.close();

            List<String> allColName = new ArrayList<>();
            for (tableData item : cartTable.getItems()) {
                allColName.add(nameCol.getCellObservableValue(item).getValue());
            }

            List<Integer> allColQuantity = new ArrayList<>();
            for (tableData item : cartTable.getItems()) {
                allColQuantity.add(quantityCol.getCellObservableValue(item).getValue());
            }

            for (int j = 0; j < lstInvoice.size(); j++) {
                Session session3 = HibernateUtil.getSessionFactory().openSession();
                Transaction t = session3.beginTransaction();
                invoice i = (invoice) session3.get(invoice.class, lstInvoice.get(j).getOrderName());
                Integer currentQuantity = lstInvoice.get(j).getQuantity();
                for (int z = 0; z < allColName.size(); z++) {
                    if (allColName.get(z).equals(i.getOrderName())) {
                        currentQuantity = currentQuantity - allColQuantity.get(z);
                    }
                }
                i.setQuantity(currentQuantity);
                session3.update(i);
                t.commit();
                session3.close();
            }

            invoicenum invInsert = new invoicenum();
            invInsert.setInvoceNumber(BillNumber);
            invInsert.setTotalPrice(fTotal);

            Session sInsert = HibernateUtil.getSessionFactory().openSession();
            Transaction tInsert = sInsert.beginTransaction();
            sInsert.save(invInsert);
            tInsert.commit();
            sInsert.close();

            stage.setScene(scene);
        });

        proField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                Query queryD = session.createQuery("SELECT d.DiscountAmount FROM discount d WHERE d.StudentID = :StudentID");
                queryD.setParameter("StudentID", proField.getText().toString());
                Double currentDiscountAmount = (Double) queryD.uniqueResult();
                fTotal = fTotal - (currentDiscountAmount * fTotal);
                tx.setText("" + fTotal);

                Transaction transactionD = session.beginTransaction();
                transactionD.commit();
            }
        });

        btnExportInvoice.setOnAction(e -> {
            try {
                File flInvoice = new File("Invoice.txt");
                FileWriter fWInvoice = new FileWriter(flInvoice);
                BufferedWriter bwInvoice = new BufferedWriter(fWInvoice);
                if (data.size() != 0) {
                    int intSize = data.size();
                    for (int i = 0; i < intSize; i++) {
                        String strLineWriter = data.get(i).toString();
                        bwInvoice.write(strLineWriter);
                        bwInvoice.newLine();
                    }
                    bwInvoice.close();
                    fWInvoice.close();
                    System.out.println("Data successfully exported to Invoice.");

                    try {
                        FileReader frInvoice = new FileReader(flInvoice);
                        BufferedReader brInvoice = new BufferedReader(frInvoice);
                        String strLineReader;
                        while ((strLineReader = brInvoice.readLine()) != null) {
                            System.out.println(strLineReader);
                        }
                        brInvoice.close();
                        frInvoice.close();
                    } catch (IOException io) {
                        io.printStackTrace();
                    }
                } else {
                    System.out.println("Error: No data.");
                }
            } catch (IOException io) {
                io.printStackTrace();
            }
        });
        
        tx.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    if (oldValue != newValue) {
                        txTotal1.setText("Total: " + fTotal);
                        txTotal2.setText("Total: " + fTotal);
                        txTotal3.setText("Total: " + fTotal);
                        txTotal4.setText("Total: " + fTotal);
                    }
                } catch (Exception e) {

                }

            }
        });

        stage.setTitle("SAKURA");
        stage.setScene(scene);
        stage.show();
    }
    
    double opacity = 1;

    private class MyAnimation extends AnimationTimer {

        @Override
        public void handle(long now) {

            doHandle();
        }

        private void doHandle() {
            opacity -= 0.01;
            forImage.opacityProperty().set(opacity);

            if (opacity <= -1) {
                stop();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
