/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.GameManager;
import Controller.SoundController;
import java.io.File;
import java.util.Map;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

/**
 *
 * @author Kane
 */
public class Enemy {
    private ImageView spriteView;
    private int health;
    private double speed = 0.5;
    private double velocityX, velocityY;
    private double x, y;

    private String state = "WALKING";
    private String facingDirection = "DOWN";
    private int currentFrameIndex = 0;
    
    private Timeline movementTimeline;
    private Timeline deathTimeline;
    private Map<String, Image[]> walkingAnimation;
    private Map<String, Image[]> deathAnimation;
    
    private GameManager gameManager;
    private SoundController soundController;
    
    private Circle hitbox;
    
    public Enemy(String[] upWalkFrames, String[] downWalkFrames, String[] rightWalkFrames, 
            String[] upDieFrames, String[] downDieFrames, String[] rightDieFrames, 
            double x, double y, int health, double speed, GameManager gameManager) {
        this.spriteView = new ImageView(new Image(new File(downWalkFrames[0]).toURI().toString()));
        this.spriteView.setX(x);
        this.spriteView.setY(y);
        this.spriteView.setFitWidth(48); // Adjust size as needed
        this.spriteView.setFitHeight(48);
        this.health = health;
        this.speed = speed;
        this.gameManager = gameManager;
        this.soundController = new SoundController();
        this.x = x;
        this.y = y;
        
        // Create a hitbox (e.g., radius 20)
        hitbox = new Circle(x + spriteView.getFitWidth() / 2, y + spriteView.getFitHeight() / 2, 8);
        
        // Initialize walking animation frames for each direction
        walkingAnimation = Map.of(
            "UP", new Image[] {
                new Image(new File(upWalkFrames[0]).toURI().toString()),
                new Image(new File(upWalkFrames[1]).toURI().toString()),
                new Image(new File(upWalkFrames[2]).toURI().toString()),
                new Image(new File(upWalkFrames[3]).toURI().toString())
            },
            "DOWN", new Image[] {
                new Image(new File(downWalkFrames[0]).toURI().toString()),
                new Image(new File(downWalkFrames[1]).toURI().toString()),
                new Image(new File(downWalkFrames[2]).toURI().toString()),
                new Image(new File(downWalkFrames[3]).toURI().toString())
            },
            "LEFT", new Image[] {
                new Image(new File(rightWalkFrames[0]).toURI().toString()),
                new Image(new File(rightWalkFrames[1]).toURI().toString()),
                new Image(new File(rightWalkFrames[2]).toURI().toString()),
                new Image(new File(rightWalkFrames[3]).toURI().toString())
            },
            "RIGHT", new Image[] {
                new Image(new File(rightWalkFrames[0]).toURI().toString()),
                new Image(new File(rightWalkFrames[1]).toURI().toString()),
                new Image(new File(rightWalkFrames[2]).toURI().toString()),
                new Image(new File(rightWalkFrames[3]).toURI().toString())
            }
        );
        
        // Initialize death animation frames for each direction
        deathAnimation = Map.of(
            "UP", new Image[] {
                new Image(new File(upDieFrames[0]).toURI().toString()),
                new Image(new File(upDieFrames[1]).toURI().toString()),
                new Image(new File(upDieFrames[2]).toURI().toString()),
            },
            "DOWN", new Image[] {
                new Image(new File(downDieFrames[0]).toURI().toString()),
                new Image(new File(downDieFrames[1]).toURI().toString()),
                new Image(new File(downDieFrames[2]).toURI().toString()),
            },
            "LEFT", new Image[] {
                new Image(new File(rightDieFrames[0]).toURI().toString()),
                new Image(new File(rightDieFrames[1]).toURI().toString()),
                new Image(new File(rightDieFrames[2]).toURI().toString()),
            },
            "RIGHT", new Image[] {
                new Image(new File(rightDieFrames[0]).toURI().toString()),
                new Image(new File(rightDieFrames[1]).toURI().toString()),
                new Image(new File(rightDieFrames[2]).toURI().toString()),
            }
        );

        startAnimation();
    }

    public ImageView getSpriteView() {
        return spriteView;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }
    
    public Circle getHitbox() {
        return hitbox;
    }
    
    public String getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(String facingDirection) {
        this.facingDirection = facingDirection;
    }
    
    public void update(double playerX, double playerY) {
        // Normal enemy behavior (e.g., chasing the player)
        double directionX = playerX - x;
        double directionY = playerY - y;
        double magnitude = Math.sqrt(directionX * directionX + directionY * directionY);

        // Normalize direction vector and move towards the player
        directionX /= magnitude;
        directionY /= magnitude;

        if (magnitude != 0) {
            x += (directionX / magnitude) * speed;
            y += (directionY / magnitude) * speed;
        }

        // Update the position of the sprite and hitbox
        spriteView.setX(x);
        spriteView.setY(y);
        hitbox.setCenterX(x + spriteView.getFitWidth() / 2);
        hitbox.setCenterY(y + spriteView.getFitHeight() / 2);
    }
    
    public void resetPosition(double newX, double newY) {
        // Reset the enemy's position and re-enable it
        this.x = newX;
        this.y = newY;
        this.spriteView.setX(x);
        this.spriteView.setY(y);
        this.hitbox.setCenterX(x + spriteView.getFitWidth() / 2);
        this.hitbox.setCenterY(y + spriteView.getFitHeight() / 2);
        spriteView.setVisible(true);
    }

    /**
     * Reduces the enemy's health by a given amount, and handles death if health reaches zero.
     */
    public void takeDamage(int damage, Player shooter) {
        this.health -= damage;
        if (this.health <= 0) {
            shooter.addPoints(10);
            die();
        }
    }

    /**
     * Initiates the death process for the enemy, including stopping movement and playing the death animation.
     */
    private void die() {
        movementTimeline.stop();
        velocityX = 0;
        velocityY = 0;
        
        // Remove the hitbox
        if (hitbox != null) {
            hitbox.setVisible(false); // Hide the hitbox
            hitbox = null; // Remove the hitbox reference
        }
        
        soundController.playSound("src/Media/Music/zombieHit.mp3");
        startDeathAnimation();
    }
    
    /**
     * Starts the walking animation of the enemy.
     */
    private void startAnimation() {
        movementTimeline = new Timeline(
            new KeyFrame(Duration.millis(150), event -> {
                Image[] frames = walkingAnimation.get(facingDirection);
                
                currentFrameIndex = (int) ((currentFrameIndex + 1) % frames.length);
                spriteView.setImage(frames[currentFrameIndex]);
            })
        );
        movementTimeline.setCycleCount(Timeline.INDEFINITE);
        movementTimeline.play();
    }
    
    /**
     * Starts the death animation of the enemy.
     */
    private void startDeathAnimation() {
        deathTimeline = new Timeline(
            new KeyFrame(Duration.millis(150), event -> {
                Image[] frames = deathAnimation.get(facingDirection);
                
                currentFrameIndex = (int) ((currentFrameIndex + 1) % frames.length);
                spriteView.setImage(frames[currentFrameIndex]);
            })
        );
        deathTimeline.setCycleCount(deathAnimation.get(facingDirection).length);
        deathTimeline.setOnFinished(event -> {
            gameManager.removeEnemy(this);
        });
        deathTimeline.play();
    }

    /**
     * Handles movement toward the player, updating the enemy's position and direction.
     */
    public void moveTowardPlayer(Player player, Scene scene) {
        double deltaX = player.getSpriteView().getX() - spriteView.getX();
        double deltaY = player.getSpriteView().getY() - spriteView.getY();
        double magnitude = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        // Normalize velocity to maintain consistent speed
        velocityX = (deltaX / magnitude) * speed;
        velocityY = (deltaY / magnitude) * speed;
        
        // Determine the facing direction based on movement
        if (Math.abs(deltaX) > Math.abs(deltaY)) {
            if (deltaX > 0) {
                facingDirection = "RIGHT";
                spriteView.setScaleX(1); // Reset to normal for right-facing
            } else {
                facingDirection = "LEFT";
                spriteView.setScaleX(-1); // Flip horizontally for left-facing
            }
        } else {
            facingDirection = deltaY > 0 ? "DOWN" : "UP";
            spriteView.setScaleX(1); // Ensure no flipping for vertical directions
        }

        // Update position
        double newX = spriteView.getX() + velocityX;
        double newY = spriteView.getY() + velocityY;
        
        // Set the new position directly
        spriteView.setX(newX);
        spriteView.setY(newY);
        
        // Update the hitbox position to match the sprite
        hitbox.setCenterX(spriteView.getX() + spriteView.getFitWidth() / 2);
        hitbox.setCenterY(spriteView.getY() + spriteView.getFitHeight() / 2);
    }
}
