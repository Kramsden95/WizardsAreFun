/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package wizardsarefun;

import Model.Player;
import Model.Projectile;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author kkrc9
 */
public class WizardsAreFun extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        // Player 1 Object Creation
        Player player1 = new Player("src/Media/wizzard_m_idle_anim_f0.png", 
                100, 3, 50, 50, 2);
        player1.getSpriteView().setX(50);
        player1.getSpriteView().setY(50);
        player1.getSpriteView().setFitHeight(42); //original 28
        player1.getSpriteView().setFitWidth(24); //original 16
        
        List<Projectile> projectiles = new ArrayList<>();
        String[] fireballFrames = {
            "src/Media/Fireball/fireball001.png",
            "src/Media/Fireball/fireball002.png",
            "src/Media/Fireball/fireball003.png",
            "src/Media/Fireball/fireball004.png",
            "src/Media/Fireball/fireball005.png",
            "src/Media/Fireball/fireball006.png",
            "src/Media/Fireball/fireball007.png",
            "src/Media/Fireball/fireball008.png",
            "src/Media/Fireball/fireball009.png",
            "src/Media/Fireball/fireball010.png",
            "src/Media/Fireball/fireball011.png",
            "src/Media/Fireball/fireball012.png",
            "src/Media/Fireball/fireball013.png",
            "src/Media/Fireball/fireball014.png",
            "src/Media/Fireball/fireball015.png",
            "src/Media/Fireball/fireball016.png",
            "src/Media/Fireball/fireball017.png",
            "src/Media/Fireball/fireball018.png",
            "src/Media/Fireball/fireball019.png",
            "src/Media/Fireball/fireball020.png",
            "src/Media/Fireball/fireball021.png",
            "src/Media/Fireball/fireball022.png",
            "src/Media/Fireball/fireball023.png",
            "src/Media/Fireball/fireball024.png",
            "src/Media/Fireball/fireball025.png",
            "src/Media/Fireball/fireball026.png",
            "src/Media/Fireball/fireball027.png",
            "src/Media/Fireball/fireball028.png",
            "src/Media/Fireball/fireball029.png",
            "src/Media/Fireball/fireball030.png",
            "src/Media/Fireball/fireball031.png",
            "src/Media/Fireball/fireball032.png",
            "src/Media/Fireball/fireball033.png",
            "src/Media/Fireball/fireball034.png",
            "src/Media/Fireball/fireball035.png",
            "src/Media/Fireball/fireball036.png",
            "src/Media/Fireball/fireball037.png",
            "src/Media/Fireball/fireball038.png",
            "src/Media/Fireball/fireball039.png",
            "src/Media/Fireball/fireball040.png",
            "src/Media/Fireball/fireball041.png",
            "src/Media/Fireball/fireball042.png",
            "src/Media/Fireball/fireball043.png",
            "src/Media/Fireball/fireball044.png",
            "src/Media/Fireball/fireball045.png",
            "src/Media/Fireball/fireball046.png",
            "src/Media/Fireball/fireball047.png",
            "src/Media/Fireball/fireball048.png",
            "src/Media/Fireball/fireball049.png",
            "src/Media/Fireball/fireball050.png",
            "src/Media/Fireball/fireball051.png",
            "src/Media/Fireball/fireball052.png",
            "src/Media/Fireball/fireball053.png",
            "src/Media/Fireball/fireball054.png",
            "src/Media/Fireball/fireball055.png",
            "src/Media/Fireball/fireball056.png",
            "src/Media/Fireball/fireball057.png",
            "src/Media/Fireball/fireball058.png",
            "src/Media/Fireball/fireball059.png",
            "src/Media/Fireball/fireball060.png",
            };
        
        Group root = new Group();
        root.getChildren().addAll(player1.getSpriteView());    
        
        Scene scene = new Scene(root, 500, 500, Color.BISQUE);
                
        // Player1 movement
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case W: 
                    player1.setVelocityY(-player1.getSpeed()); 
                    player1.setFacingDirection("UP"); 
                    break;
                case S: 
                    player1.setVelocityY(player1.getSpeed()); 
                    player1.setFacingDirection("DOWN"); 
                    break;
                case A: 
                    player1.setVelocityX(-player1.getSpeed()); 
                    player1.setFacingDirection("LEFT"); 
                    break;
                case D: 
                    player1.setVelocityX(player1.getSpeed()); 
                    player1.setFacingDirection("RIGHT"); 
                    break;
                case SPACE:
                    double startX = player1.getSpriteView().getX();
                    double startY = player1.getSpriteView().getY();
                    Projectile projectile = new Projectile(startX, startY, player1.getFacingDirection(), fireballFrames);
                    root.getChildren().add(projectile.getSprite());
                    projectiles.add(projectile);
                    break;
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
                // Update player movement
                player1.updatePosition(scene); 
                
                // Move projectiles
                for (int i = 0; i < projectiles.size(); i++) {
                    Projectile p = projectiles.get(i);
                    p.move();

                    // Remove if out of bounds
                    if (p.isOutOfBounds(scene)) {
                        root.getChildren().remove(p.getSprite());
                        projectiles.remove(i);
                        i--; // Adjust index after removal
                    }
                }
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
