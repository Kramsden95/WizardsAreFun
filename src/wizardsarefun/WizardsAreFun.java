/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package wizardsarefun;

import Controller.Logica;
import Model.Enemy;
import Model.Player;
import Model.Projectile;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author kkrc9
 */
public class WizardsAreFun extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        
        List<Projectile> projectiles = new ArrayList<>();
        List<Enemy> enemies = new ArrayList<>();
        
        Logica logica = new Logica();
        
        // Player 1 Object Creation
        Player player1 = new Player(logica.getCharacterAIdleUP(), logica.getCharacterAIdleDOWN(), 
                logica.getCharacterAIdleLEFT(), logica.getCharacterAIdleRIGHT(), logica.getCharacterAWalkUP(), 
                logica.getCharacterAWalkDOWN(), logica.getCharacterAWalkLEFT(), logica.getCharacterAWalkRIGHT(),
                100, 3, 225, 225, 2);
        player1.getSpriteView().setX(player1.getX());
        player1.getSpriteView().setY(player1.getY());
        player1.getSpriteView().setFitHeight(48); //original 28
        player1.getSpriteView().setFitWidth(48); //original 16
        
        // Target Dummy Creation
        Enemy enemy1 = new Enemy(logica.getEnemy1WalkUP(), logica.getEnemy1WalkDOWN(), logica.getEnemy1WalkSIDES(),
                logica.getEnemy1DieUP(), logica.getEnemy1DieDOWN(), logica.getEnemy1DieSIDES(), 290, 225, 1, 0.5);
        enemies.add(enemy1);
        
        Group root = new Group();
        root.getChildren().addAll(player1.getSpriteView(), enemy1.getSpriteView());    
        
        Scene scene = new Scene(root, 500, 500, Color.DIMGREY);
                
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
                    Projectile projectile = new Projectile(startX, startY, player1.getFacingDirection(), logica.getFireballFrames());
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
                
                // Move enemies toward player
                for (Enemy enemy : enemies) {
                    enemy.moveTowardPlayer(player1, scene); // Chasing behavior
                }
                
                // Damage and Collision handling
                for (Projectile projectile : projectiles) {
                    for (Enemy enemy : enemies) {
                        if (projectile.getSprite().getBoundsInParent().intersects(enemy.getSpriteView().getBoundsInParent())) {
                            enemy.takeDamage(1); // Apply damage
                            root.getChildren().remove(projectile.getSprite()); // Remove projectile
                            projectiles.remove(projectile);
                            break;
                        }
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
