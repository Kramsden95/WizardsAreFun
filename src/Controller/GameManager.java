/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Enemy;
import Model.Player;
import Model.PowerUp;
import Model.Projectile;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Kane
 */
public class GameManager {
    private List<Enemy> enemies;
    private List<Projectile> projectiles;
    private List<PowerUp> powerups;
    
    private Stage primaryStage;
    private Scene scene;
    private Group group;
    private Logica logica;
    
    private Player player1;
    private Player player2;
    private boolean isMultiplayer;
    
    private AnimationTimer gameLoop;
    
    private wizardsarefun.WizardsAreFun mainApp;
    private SoundController soundController;
    
    public GameManager(Group group, Scene scene, Logica logica, wizardsarefun.WizardsAreFun mainApp) {
        this.enemies = new ArrayList<>();
        this.projectiles = new ArrayList<>();
        this.powerups = new ArrayList<>();
        this.group = group;
        this.scene = scene;
        this.logica = logica;
        this.mainApp = mainApp;
        this.soundController = new SoundController();
    }

    // Add an enemy
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
        group.getChildren().add(enemy.getSpriteView());
    }

    // Remove an enemy
    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
        group.getChildren().remove(enemy.getSpriteView());
        
        // Remove the hitbox from the scene graph if it exists
        if (enemy.getHitbox() != null) {
            group.getChildren().remove(enemy.getHitbox());
        }
    }
    
    // Remove all enemies
    public void removeAllEnemies() {
        // Remove all enemies from both the list and the group
        for (Enemy enemy : enemies) {
            group.getChildren().remove(enemy.getSpriteView());
        }
        enemies.clear(); // Clear the list of enemies
    }

    // Add a projectile
    public void addProjectile(Projectile projectile) {
        projectiles.add(projectile);
        group.getChildren().add(projectile.getSprite());
    }

    // Remove a projectile
    public void removeProjectile(Projectile projectile) {
        projectiles.remove(projectile);
        group.getChildren().remove(projectile.getSprite());
    }

    /*
    // Add a Power Up
    public void addPowerUp(PowerUp item) {
        powerups.add(item);
        group.getChildren().add(item.getSpriteView());
    }

    // Remove a Power Up
    public void removePowerUp(PowerUp item) {
        powerups.remove(item);
        group.getChildren().remove(item.getSpriteView());
    }
    */

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void setMultiplayer(boolean isMultiplayer) {
        this.isMultiplayer = isMultiplayer;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
    
    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
    
    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Projectile> getProjectiles() {
        return projectiles;
    }

    public List<PowerUp> getPowerUps() {
        return powerups;
    }

    public AnimationTimer getGameLoop() {
        return gameLoop;
    }

    public void setGameLoop(AnimationTimer gameLoop) {
        this.gameLoop = gameLoop;
    }
    
    public void restartGameLoop() {
        if (gameLoop != null) {
            gameLoop.start();
        }
    }
    
    public void spawnEnemy() {
        Random random = new Random();
        int edge = random.nextInt(4); // 0 = top, 1 = bottom, 2 = left, 3 = right
        double x = 0;
        double y = 0;

        switch (edge) {
            case 0: // Top edge
                x = random.nextDouble() * 1024;
                y = -48;
                break;
            case 1: // Bottom edge
                x = random.nextDouble() * 1024;
                y = 1024 + 48;
                break;
            case 2: // Left edge
                x = -48;
                y = random.nextDouble() * 1024;
                break;
            case 3: // Right edge
                x = 1024 + 48;
                y = random.nextDouble() * 1024;
                break;
        }

        Enemy enemy = new Enemy(logica.getEnemy1WalkUP(), logica.getEnemy1WalkDOWN(), logica.getEnemy1WalkSIDES(),
                logica.getEnemy1DieUP(), logica.getEnemy1DieDOWN(), logica.getEnemy1DieSIDES(), x, y, 1, 0.5, this);
        addEnemy(enemy);
    }
    
    public void triggerGameOver() {
        System.out.println("Game Over! Transitioning to game over screen...");
        
        soundController.playSound("src/Media/Music/gameover.mp3");
        
        if (gameLoop != null) {
            gameLoop.stop();
        }
        removeAllEnemies();
        projectiles.clear();
        
        // Notify the main application to switch to the game over scene
        mainApp.showGameOverScene();
    }
    
    public void updateHeartsDisplay() {
        // Update Player 1 hearts
        HBox player1Hearts = (HBox) group.lookup("#player1Hearts");
        if (player1Hearts != null) {
            player1Hearts.getChildren().clear();
            for (int i = 0; i < player1.getLives(); i++) {
                ImageView heartImageView = new ImageView(new Image(new File(logica.getHeartLifeAnimation()[0]).toURI().toString()));
                heartImageView.setFitWidth(32);
                heartImageView.setFitHeight(32);
                
                // Create a Timeline to animate the heart
                Timeline heartAnimation = new Timeline(
                    new KeyFrame(Duration.millis(150), event -> {
                        int currentFrameIndex = (int) (System.currentTimeMillis() / 150 % logica.getHeartLifeAnimation().length);
                        heartImageView.setImage(new Image(new File(logica.getHeartLifeAnimation()[currentFrameIndex]).toURI().toString()));
                    })
                );
                heartAnimation.setCycleCount(Timeline.INDEFINITE); // Loop indefinitely
                heartAnimation.play(); // Start the animation
                
                player1Hearts.getChildren().add(heartImageView);
            }
        }

        // Update Player 2 hearts (if in multiplayer mode)
        HBox player2Hearts = (HBox) group.lookup("#player2Hearts");
        if (player2Hearts != null) {
            player2Hearts.getChildren().clear();
            for (int i = 0; i < player2.getLives(); i++) {
                ImageView heartImageView = new ImageView(new Image(new File(logica.getHeartLifeAnimation()[0]).toURI().toString()));
                heartImageView.setFitWidth(32);
                heartImageView.setFitHeight(32);

                // Create a Timeline to animate the heart
                Timeline heartAnimation = new Timeline(
                    new KeyFrame(Duration.millis(150), event -> {
                        int currentFrameIndex = (int) (System.currentTimeMillis() / 150 % logica.getHeartLifeAnimation().length);
                        heartImageView.setImage(new Image(new File(logica.getHeartLifeAnimation()[currentFrameIndex]).toURI().toString()));
                    })
                );
                heartAnimation.setCycleCount(Timeline.INDEFINITE); // Loop indefinitely
                heartAnimation.play(); // Start the animation

                player2Hearts.getChildren().add(heartImageView);
            }
        }
    }
}
