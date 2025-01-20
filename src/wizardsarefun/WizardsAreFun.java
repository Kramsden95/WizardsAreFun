/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package wizardsarefun;

import Model.Player;
import java.io.File;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.skin.TextInputControlSkin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author kkrc9
 */
public class WizardsAreFun extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        // Player 1 Object Creation
        Player player1 = new Player(new ImageView(new Image(new File("src/Media/wizzard_m_idle_anim_f0.png").toURI().toString())), 
                100, 3, 50, 50, 2);
        player1.getSpriteView().setX(50);
        player1.getSpriteView().setY(50);
        player1.getSpriteView().setFitHeight(42); //original 28
        player1.getSpriteView().setFitWidth(24); //original 16
        
        Group root = new Group();
        root.getChildren().addAll(player1.getSpriteView());    
        
        Scene scene = new Scene(root, 500, 500, Color.BISQUE);
                
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W: player1.setVelocityY(-player1.getSpeed()); break;
                case S: player1.setVelocityY(player1.getSpeed()); break;
                case A: player1.setVelocityX(-player1.getSpeed()); break;
                case D: player1.setVelocityX(player1.getSpeed()); break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case W: case S: player1.setVelocityY(0); break;
                case A: case D: player1.setVelocityX(0); break;
            }
        }); 
        
        AnimationTimer gameLoop = new AnimationTimer() {
            @Override
            public void handle(long now) {
                player1.updatePosition(scene); // Update player movement
            }
        };
        gameLoop.start();
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
