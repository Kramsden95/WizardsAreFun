/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package wizardsarefun;

import Controller.GameManager;
import Controller.Logica;
import Model.Enemy;
import Model.Player;
import Model.Projectile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
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
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.DIMGREY);
        GameManager gameManager = new GameManager(root, scene);
        
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
                logica.getEnemy1DieUP(), logica.getEnemy1DieDOWN(), logica.getEnemy1DieSIDES(), 290, 225, 1, 0.5, gameManager);
        gameManager.addEnemy(enemy1);
        
        DropShadow ds = new DropShadow(5, Color.AQUA);
        enemy1.getSpriteView().setEffect(ds);
                
        root.getChildren().addAll(player1.getSpriteView());    
        
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
                    projectile.getSprite().setEffect(ds);
                    
                                    /*Rectangle projectileBounds = new Rectangle(
                                        projectile.getSprite().getBoundsInParent().getMinX(),
                                        projectile.getSprite().getBoundsInParent().getMinY(),
                                        projectile.getSprite().getBoundsInParent().getWidth(),
                                        projectile.getSprite().getBoundsInParent().getHeight()
                                    );
                                    projectileBounds.setStroke(Color.RED);
                                    projectileBounds.setFill(Color.TRANSPARENT);
                                    root.getChildren().add(projectileBounds);*/
                    
                    gameManager.addProjectile(projectile);
                    break;
            }
        });

                                    /*Rectangle enemyBounds = new Rectangle(
                                        enemy1.getSpriteView().getBoundsInParent().getMinX(),
                                        enemy1.getSpriteView().getBoundsInParent().getMinY(),
                                        enemy1.getSpriteView().getBoundsInParent().getWidth(),
                                        enemy1.getSpriteView().getBoundsInParent().getHeight()
                                    );
                                    enemyBounds.setStroke(Color.BLUE);
                                    enemyBounds.setFill(Color.TRANSPARENT);
                                    root.getChildren().add(enemyBounds);*/

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
                for (int i = 0; i < gameManager.getProjectiles().size(); i++) {
                    Projectile p = gameManager.getProjectiles().get(i);
                    p.move();

                    // Remove if out of bounds
                    if (p.isOutOfBounds(scene)) {
                        gameManager.removeProjectile(p);
                        i--; // Adjust index after removal
                    }
                }
                
                // Move enemies toward player
                for (Enemy enemy : gameManager.getEnemies()) {
                    enemy.moveTowardPlayer(player1, scene); // Chasing behavior
                }
                
                // Damage and Collision handling
                for (Iterator<Projectile> projectileIterator = gameManager.getProjectiles().iterator(); projectileIterator.hasNext(); ) {
                    Projectile projectile = projectileIterator.next();
                    for (Enemy enemy : gameManager.getEnemies()) {
                        // Check if the hitboxes intersect
                        double dx = projectile.getHitbox().getCenterX() - enemy.getHitbox().getCenterX();
                        double dy = projectile.getHitbox().getCenterY() - enemy.getHitbox().getCenterY();
                        double distance = Math.sqrt(dx * dx + dy * dy);

                        if (distance < projectile.getHitbox().getRadius() + enemy.getHitbox().getRadius()) {
                            enemy.takeDamage(1); // Apply damage

                            // Remove projectile safely using the iterator
                            projectileIterator.remove();
                            gameManager.removeProjectile(projectile); // Keep game manager state consistent
                            break; // Exit inner loop after collision
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
