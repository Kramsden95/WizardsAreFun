/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.File;
import java.util.Map;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 *
 * @author Kane
 */
public class Enemy {
    private ImageView spriteView;
    private int health;
    private double speed;
    private double velocityX;
    private double velocityY;

    private String state = "WALKING";
    private String facingDirection = "DOWN";
    private int currentFrameIndex = 0;
    
    private Timeline movementTimeline;
    private Timeline deathTimeline;
    private Map<String, Image[]> walkingAnimation;
    private Map<String, Image[]> deathAnimation;

    public Enemy(String[] upWalkFrames, String[] downWalkFrames, String[] rightWalkFrames, 
            String[] upDieFrames, String[] downDieFrames, String[] rightDieFrames, 
            double startX, double startY, int health, double speed) {
        this.spriteView = new ImageView(new Image(new File(downWalkFrames[0]).toURI().toString()));
        this.spriteView.setX(startX);
        this.spriteView.setY(startY);
        this.spriteView.setFitWidth(48); // Adjust size as needed
        this.spriteView.setFitHeight(48);
        this.health = health;
        this.speed = speed;
        
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

    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            die();
        }
    }

    private void die() {
        // Handle enemy death (e.g., remove from game, play animation)
        movementTimeline.stop();
        velocityX = 0;
        velocityY = 0;
        startDeathAnimation();
        
    }

    public void moveTowardPlayer(Player player, Scene scene) {
        double deltaX = player.getSpriteView().getX() - spriteView.getX();
        double deltaY = player.getSpriteView().getY() - spriteView.getY();
        double magnitude = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        // Normalize velocity to maintain consistent speed
        velocityX = (deltaX / magnitude) * speed;
        velocityY = (deltaY / magnitude) * speed;
        
        // Determine facing direction
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

        // Boundary checks
        if (newX >= 0 && newX <= scene.getWidth() - spriteView.getFitWidth()) {
            spriteView.setX(newX);
        }
        if (newY >= 0 && newY <= scene.getHeight() - spriteView.getFitHeight()) {
            spriteView.setY(newY);
        }
    }
/*
    private void initializeMovement() {
        // Example of random movement logic (can replace with other behaviors)
        Random random = new Random();
        movementTimeline = new Timeline(
            new KeyFrame(Duration.seconds(1), event -> {
                velocityX = (random.nextDouble() - 0.5) * 2 * speed;
                velocityY = (random.nextDouble() - 0.5) * 2 * speed;
            })
        );
        movementTimeline.setCycleCount(Timeline.INDEFINITE);
        movementTimeline.play();
    }*/
    
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
    
    private void startDeathAnimation() {
        deathTimeline = new Timeline(
            new KeyFrame(Duration.millis(150), event -> {
                Image[] frames = deathAnimation.get(facingDirection);
                
                currentFrameIndex = (int) ((currentFrameIndex + 1) % frames.length);
                spriteView.setImage(frames[currentFrameIndex]);
            })
        );
        deathTimeline.setCycleCount(deathAnimation.get(facingDirection).length);
        /*deathTimeline.setOnFinished(event -> {
            enemies.remove(this);
            gamePane.getChildren().remove(spriteView);
        });*/
        deathTimeline.play();
    }

    public void updatePosition(Scene scene) {
        double newX = spriteView.getX() + velocityX;
        double newY = spriteView.getY() + velocityY;

        // Boundary checks
        if (newX >= 0 && newX <= scene.getWidth() - spriteView.getFitWidth()) {
            spriteView.setX(newX);
        }
        if (newY >= 0 && newY <= scene.getHeight() - spriteView.getFitHeight()) {
            spriteView.setY(newY);
        }
    }
    
    public String getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(String facingDirection) {
        this.facingDirection = facingDirection;
    }
}
