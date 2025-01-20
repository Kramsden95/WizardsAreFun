/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import javafx.scene.Scene;
import javafx.scene.control.skin.TextInputControlSkin;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 *
 * @author Kane
 */
public class Player {
    private String playerName;
    private ImageView spriteView;
    private int health;
    private int lives;
    private double x, y;
    private double velocityX, velocityY;
    private double speed;
    private boolean dead = false;

    public Player(ImageView spriteView, int health, int lives, double x, double y, double speed) {
        this.spriteView = spriteView;
        this.health = health;
        this.lives = lives;
        this.x = x;
        this.y = y;
        this.speed = speed;
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
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void move(String direction, Scene scene) {
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
    }
    
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
    
    public void shoot(){
        
    }
    
    public void takeDamage(){
        
    }
}
