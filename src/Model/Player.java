/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.io.File;
import java.util.Map;
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
public class Player {
    private ImageView spriteView;
    private int health;
    private int lives;
    private double x, y;
    private double speed;

    private String playerName;
    private boolean dead = false;
    private double velocityX, velocityY;    
    private String facingDirection = "DOWN"; 
    private String state = "IDLE";
    private int currentFrameIndex = 0;
    
    private Timeline animationTimeline;
    private Map<String, Image[]> idleAnimations;
    private Map<String, Image[]> walkingAnimations;
    
    public Player(String[] upIdleFrames, String[] downIdleFrames, String[] leftIdleFrames, String[] rightIdleFrames,
            String[] upWalkFrames, String[] downWalkFrames, String[] leftWalkFrames, String[] rightWalkFrames,
            int health, int lives, double x, double y, double speed) {
        this.spriteView = new ImageView(new Image(new File(downIdleFrames[0]).toURI().toString()));
        this.health = health;
        this.lives = lives;
        this.x = x;
        this.y = y;
        this.speed = speed;
        
        // Load animation frames
        idleAnimations = Map.of(
            "UP", new Image[] {
                new Image(new File(upIdleFrames[0]).toURI().toString()),
                new Image(new File(upIdleFrames[1]).toURI().toString()),
                new Image(new File(upIdleFrames[2]).toURI().toString()),
                new Image(new File(upIdleFrames[3]).toURI().toString())
            },
            "DOWN", new Image[] {
                new Image(new File(downIdleFrames[0]).toURI().toString()),
                new Image(new File(downIdleFrames[1]).toURI().toString()),
                new Image(new File(downIdleFrames[2]).toURI().toString()),
                new Image(new File(downIdleFrames[3]).toURI().toString())
            },
            "LEFT", new Image[] {
                new Image(new File(leftIdleFrames[0]).toURI().toString()),
                new Image(new File(leftIdleFrames[1]).toURI().toString()),
                new Image(new File(leftIdleFrames[2]).toURI().toString()),
                new Image(new File(leftIdleFrames[3]).toURI().toString())
            },
            "RIGHT", new Image[] {
                new Image(new File(rightIdleFrames[0]).toURI().toString()),
                new Image(new File(rightIdleFrames[1]).toURI().toString()),
                new Image(new File(rightIdleFrames[2]).toURI().toString()),
                new Image(new File(rightIdleFrames[3]).toURI().toString())
            }
        );
        
        walkingAnimations = Map.of(
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
                new Image(new File(leftWalkFrames[0]).toURI().toString()),
                new Image(new File(leftWalkFrames[1]).toURI().toString()),
                new Image(new File(leftWalkFrames[2]).toURI().toString()),
                new Image(new File(leftWalkFrames[3]).toURI().toString())
            },
            "RIGHT", new Image[] {
                new Image(new File(rightWalkFrames[0]).toURI().toString()),
                new Image(new File(rightWalkFrames[1]).toURI().toString()),
                new Image(new File(rightWalkFrames[2]).toURI().toString()),
                new Image(new File(rightWalkFrames[3]).toURI().toString())
            }
        );
        
        startAnimation();
    }

    public ImageView getSpriteView() {
        return spriteView;
    }

    public void setSpriteView(ImageView spriteView) {
        this.spriteView = spriteView;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
        updateState();
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
        updateState();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    /*public void move(String direction, Scene scene) {
        switch (direction) {
            case "UP":
                if (this.spriteView.getY() > 0) this.spriteView.setY(this.spriteView.getY() - this.speed);
                break;
            case "DOWN":
                if (this.spriteView.getY() < scene.getHeight() - this.spriteView.getFitHeight()) this.spriteView.setY(this.spriteView.getY() + this.speed);
                break;
            case "LEFT":
                if (this.spriteView.getX() > 0) this.spriteView.setX(this.spriteView.getX() - this.speed);
                break;
            case "RIGHT":
                if (this.spriteView.getX() < scene.getWidth() - this.spriteView.getFitWidth()) this.spriteView.setX(this.spriteView.getX() + this.speed);
                break;
        }
    }*/
    
    public void updatePosition(Scene scene) {
        // Update X position and check boundaries
        double newX = this.spriteView.getX() + velocityX;
        if (newX >= 0 && newX <= scene.getWidth() - this.spriteView.getFitWidth()) {
            this.spriteView.setX(newX);
        }

        // Update Y position and check boundaries
        double newY = this.spriteView.getY() + velocityY;
        if (newY >= 0 && newY <= scene.getHeight() - this.spriteView.getFitHeight()) {
            this.spriteView.setY(newY);
        }
    }
    
    private void updateState() {
        // Determine if the player is moving
        if (velocityX == 0 && velocityY == 0) {
            state = "IDLE";
        } else {
            state = "WALKING";
        }
    }
    
    private void startAnimation() {
        animationTimeline = new Timeline(
            new KeyFrame(Duration.millis(150), event -> {
                Image[] frames = state.equals("IDLE") ?
                    idleAnimations.get(facingDirection) :
                    walkingAnimations.get(facingDirection);

                currentFrameIndex = (int) ((currentFrameIndex + 1) % frames.length);
                spriteView.setImage(frames[currentFrameIndex]);
            })
        );
        animationTimeline.setCycleCount(Timeline.INDEFINITE);
        animationTimeline.play();
    }
    
    public String getFacingDirection() {
        return facingDirection;
    }

    public void setFacingDirection(String facingDirection) {
        this.facingDirection = facingDirection;
        updateState();
    }
    
    public void shoot(){
        
    }
    
    public void takeDamage(){
        
    }
}
