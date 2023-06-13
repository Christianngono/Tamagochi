package com.ynov;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Random;

public class TamagotchiGUI extends Application {
    private Tamagotchis tamagotchis;

    public TamagotchiGUI() {
        // Créer ou charger le Tamagotchis ici
        tamagotchis = new Tamagotchis();
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Tamagotchis");

        // Créer les éléments graphiques pour le Tamagotchis
        ImageView tamagotchiImage = new ImageView(new Image(getClass().getResourceAsStream("imgbin-tamagotchi.png")));
        Label happinessLabel = new Label("Happiness: " + tamagotchis.getHappinessLevel());
        Label hungerLabel = new Label("Hunger: " + tamagotchis.getHungerLevel());
        Button playButton = new Button("Play");
        Button feedButton = new Button("Feed");
        Button cleanButton = new Button("Clean");

        // Créer un conteneur pour les éléments graphiques
        StackPane root = new StackPane();
        root.setPadding(new Insets(10));
        VBox rootVBox = new VBox(10);
        rootVBox.getChildren().addAll(tamagotchiImage, happinessLabel, hungerLabel, playButton, feedButton, cleanButton);

        Scene scene = new Scene(rootVBox, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Créer une animation pour faire apparaître des objets à l'écran
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(2), event -> createObject(rootVBox))
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        // Définir les actions des boutons
        playButton.setOnAction(e -> {
            tamagotchis.play();
            happinessLabel.setText("Happiness: " + tamagotchis.getHappinessLevel());
        });

        feedButton.setOnAction(e -> {
            tamagotchis.feed();
            hungerLabel.setText("Hunger: " + tamagotchis.getHungerLevel());
        });

        cleanButton.setOnAction(e -> {
            tamagotchis.clean();
        });
    }

    private void createObject(VBox rootVBox) {
        Random random = new Random();
        double width = rootVBox.getWidth();
        double height = rootVBox.getHeight();
        int x = random.nextInt((int) width);
        int y = random.nextInt((int) height);

        Button objectButton = new Button();
        objectButton.setTranslateX(x);
        objectButton.setTranslateY(y);
        objectButton.setOnAction(e -> {
            rootVBox.getChildren().remove(objectButton);
        
        });

        rootVBox.getChildren().add(objectButton);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
