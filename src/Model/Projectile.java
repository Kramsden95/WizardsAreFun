/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.File;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 *
 * @author kkrc9
 */
public class Projectile {
    private ImageView sprite;
    private String facingDirection;
    private Timeline animationTimeline;
    private double velocityX;
    private double velocityY;
    private double speed = 3;
    private int currentFrameIndex = 0;
    
    private Circle hitbox;
    
    private Player shooter; // Reference to the player who fired the projectile

    public Projectile(double startX, double startY, String facingDirection, String[] animationPaths, Player shooter) {
        sprite = new ImageView(new Image(new File(animationPaths[0]).toURI().toString()));
        sprite.setX(startX);
        sprite.setY(startY);
        sprite.setFitWidth(50); 
        sprite.setFitHeight(50);
        this.shooter = shooter;
        
        // Create a hitbox
        hitbox = new Circle(startX + sprite.getFitWidth() / 2, startY + sprite.getFitHeight() / 2, 10);
        
        // Load animation frames
        Image[] animationFrames = new Image[animationPaths.length];
        for (int i = 0; i < animationPaths.length; i++) {
            animationFrames[i] = new Image(new File(animationPaths[i]).toURI().toString());
        }

        // Set velocity based on direction
        switch (facingDirection) {
            case "UP": velocityX = 0; velocityY = -speed; sprite.setRotate(270); break;
            case "DOWN": velocityX = 0; velocityY = speed; sprite.setRotate(90); break;
            case "LEFT": velocityX = -speed; velocityY = 0; sprite.setRotate(180); break;
            case "RIGHT": velocityX = speed; velocityY = 0; sprite.setRotate(0); break;
        }

        // Set up animation timeline for the projectile
        animationTimeline = new Timeline(
            new KeyFrame(Duration.millis(20), event -> {
                currentFrameIndex = (int) ((currentFrameIndex + 1) % animationFrames.length);
                sprite.setImage(animationFrames[currentFrameIndex]);
            })
        );
        animationTimeline.setCycleCount(Timeline.INDEFINITE);
        animationTimeline.play();
    }

    public ImageView getSprite() {
        return sprite;
    }
    
    public Circle getHitbox() {
        return hitbox;
    }
    
    public Player getShooter() {
        return shooter;
    }

    /**
     * Moves the projectile based on its velocity.
     */
    public void move() {
        sprite.setX(sprite.getX() + velocityX);
        sprite.setY(sprite.getY() + velocityY);
        
        // Update the hitbox position to match the sprite
        hitbox.setCenterX(sprite.getX() + sprite.getFitWidth() / 2);
        hitbox.setCenterY(sprite.getY() + sprite.getFitHeight() / 2);
    }

    /**
     * Checks if the projectile is out of bounds of the given scene.
     */
    public boolean isOutOfBounds(Scene scene) {
        return sprite.getX() < 0 || sprite.getX() > scene.getWidth() ||
               sprite.getY() < 0 || sprite.getY() > scene.getHeight();
    }
}