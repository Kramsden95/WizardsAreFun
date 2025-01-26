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
import javafx.animation.PauseTransition;
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
public class Player {
    private ImageView spriteView;
    private int health;
    private int lives;
    private double x, y;
    private double speed;
    private int points;
    
    private double initialX; // Initial spawn X position
    private double initialY; // Initial spawn Y position

    private String playerName;
    private boolean isDead = false;
    private double velocityX, velocityY;    
    private String facingDirection = "DOWN"; 
    private String state = "IDLE";
    private int currentFrameIndex = 0;
    
    private Timeline animationTimeline;
    private Map<String, Image[]> idleAnimations;
    private Map<String, Image[]> walkingAnimations;
    
    private Circle hitbox;
    
    private long lastDamageTime = 0; // Tracks the last time damage was taken
    private final long DAMAGE_COOLDOWN = 1000; // Cooldown in milliseconds
    
    private Image[] dieAnimationFrames; // Frames for death animation
    private String[] deathFrames;
    private Timeline dieAnimationTimeline; // Timeline for playing death animation
    
    private boolean inputEnabled = true; // Default to true
    
    private GameManager gameManager;
    private SoundController soundController;

    public Player(String[] upIdleFrames, String[] downIdleFrames, String[] leftIdleFrames, String[] rightIdleFrames,
            String[] upWalkFrames, String[] downWalkFrames, String[] leftWalkFrames, String[] rightWalkFrames,
            String[] deathFrames, double x, double y, GameManager gameManager) {
        this.spriteView = new ImageView(new Image(new File(downIdleFrames[0]).toURI().toString()));
        this.health = 100;
        this.lives = 3;
        this.x = x;
        this.y = y;
        this.speed = 2;
        this.gameManager = gameManager;
        this.points = 0;
        this.deathFrames = deathFrames;
        soundController = new SoundController();
        
        // Store the initial spawn position
        this.initialX = x;
        this.initialY = y;
        
        // Create a hitbox (e.g., radius 20)
        hitbox = new Circle(x + spriteView.getFitWidth() / 2, (y + spriteView.getFitHeight() / 2) + 4, 12);
        
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
        
        dieAnimationFrames = new Image[] {
            new Image(new File(deathFrames[0]).toURI().toString()),
            new Image(new File(deathFrames[1]).toURI().toString()),
            new Image(new File(deathFrames[2]).toURI().toString()),
            new Image(new File(deathFrames[3]).toURI().toString()),
            new Image(new File(deathFrames[4]).toURI().toString()),
            new Image(new File(deathFrames[5]).toURI().toString()),
            new Image(new File(deathFrames[6]).toURI().toString()),
            new Image(new File(deathFrames[7]).toURI().toString()),
            new Image(new File(deathFrames[8]).toURI().toString()),
            new Image(new File(deathFrames[9]).toURI().toString()),
            new Image(new File(deathFrames[10]).toURI().toString()),
            new Image(new File(deathFrames[11]).toURI().toString()),
            new Image(new File(deathFrames[12]).toURI().toString()),
            new Image(new File(deathFrames[13]).toURI().toString()),
            new Image(new File(deathFrames[14]).toURI().toString()),
            new Image(new File(deathFrames[15]).toURI().toString()),
            new Image(new File(deathFrames[16]).toURI().toString()),
            new Image(new File(deathFrames[17]).toURI().toString()),
            new Image(new File(deathFrames[18]).toURI().toString()),
            new Image(new File(deathFrames[19]).toURI().toString())
        };
        
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
        return isDead;
    }

    public void setDead(boolean dead) {
        this.isDead = dead;
    }

    public double getVelocityX() {
        return velocityX;
    }

    public void setVelocityX(double velocityX) {
        this.velocityX = velocityX;
        state = (velocityX == 0 && velocityY == 0) ? "IDLE" : "WALKING";
    }

    public double getVelocityY() {
        return velocityY;
    }

    public void setVelocityY(double velocityY) {
        this.velocityY = velocityY;
        state = (velocityX == 0 && velocityY == 0) ? "IDLE" : "WALKING";
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
    public Circle getHitbox() {
        return hitbox;
    }

    public boolean isInputEnabled() {
        return inputEnabled;
    }
    
    public int getPoints() {
        return points;
    }

    public void addPoints(int amount) {
        this.points += amount;
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
        
        // Update the hitbox position to match the sprite
        hitbox.setCenterX(spriteView.getX() + spriteView.getFitWidth() / 2);
        hitbox.setCenterY(spriteView.getY() + spriteView.getFitHeight() / 2 + 4);
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
        state = (velocityX == 0 && velocityY == 0) ? "IDLE" : "WALKING";
    }
    
    public void takeDamage(int damage) {
        if (isDead) return; // Don't take damage if player is dead

        long currentTime = System.currentTimeMillis(); // Get the current time

        // Check if enough time has passed since the last damage
        if (currentTime - lastDamageTime >= DAMAGE_COOLDOWN) {
            if (health > 0) {
                this.health -= damage;
                soundController.playSound("src/Media/Music/grunt.mp3");
                System.out.println("Player took damage! Current health: " + health);
            }

            if (health <= 0) {
                playDieAnimation();
                setDead(true);
                if (lives > 0) {
                    lives--; // Deduct a life
                    gameManager.updateHeartsDisplay();
                    System.out.println("Player lost a life! Remaining lives: " + lives);
                } else {
                    System.out.println("Player is dead and out of lives!");
                    // Notify GameManager to check for game over
                    gameManager.triggerGameOver();
                }
            }
            // Update the last damage time
            lastDamageTime = currentTime;
        }
    }
    
    public void setDeathAnimation(String[] deathFrames) {
        dieAnimationFrames = new Image[] {
            new Image(new File(deathFrames[0]).toURI().toString()),
            new Image(new File(deathFrames[1]).toURI().toString()),
            new Image(new File(deathFrames[2]).toURI().toString()),
            new Image(new File(deathFrames[3]).toURI().toString()),
            new Image(new File(deathFrames[4]).toURI().toString()),
            new Image(new File(deathFrames[5]).toURI().toString()),
            new Image(new File(deathFrames[6]).toURI().toString()),
            new Image(new File(deathFrames[7]).toURI().toString()),
            new Image(new File(deathFrames[8]).toURI().toString()),
            new Image(new File(deathFrames[9]).toURI().toString()),
            new Image(new File(deathFrames[10]).toURI().toString()),
            new Image(new File(deathFrames[11]).toURI().toString()),
            new Image(new File(deathFrames[12]).toURI().toString()),
            new Image(new File(deathFrames[13]).toURI().toString()),
            new Image(new File(deathFrames[14]).toURI().toString()),
            new Image(new File(deathFrames[15]).toURI().toString()),
            new Image(new File(deathFrames[16]).toURI().toString()),
            new Image(new File(deathFrames[17]).toURI().toString()),
            new Image(new File(deathFrames[18]).toURI().toString()),
            new Image(new File(deathFrames[19]).toURI().toString())
        };
    }
    
    private void playDieAnimation() {
        // Disable player input during death
        inputEnabled = false;
        
        // Stop any existing movement or animation
        velocityX = 0;
        velocityY = 0;
        
        soundController.playSound("src/Media/Music/hit.mp3");
        
        // Hide the player's hitbox
        hitbox.setVisible(false);
        
        // Create and play the death animation timeline
        dieAnimationTimeline = new Timeline(
            new KeyFrame(Duration.millis(100), event -> {
                animationTimeline.stop();
                // Update the sprite image to the next death frame
                if (currentFrameIndex < dieAnimationFrames.length) {
                    spriteView.setImage(dieAnimationFrames[currentFrameIndex]);
                    currentFrameIndex++;
                }
            })
        );

        // Set the timeline to run through all 20 frames
        dieAnimationTimeline.setCycleCount(dieAnimationFrames.length);
        dieAnimationTimeline.setOnFinished(event -> {
            System.out.println("Player death animation complete");
            waitBeforeRespawn(); // Respawn if lives remain
        });
        dieAnimationTimeline.play();
    }

    private void waitBeforeRespawn() {
        // Delay for 1.5 seconds before respawning
        PauseTransition pause = new PauseTransition(Duration.seconds(1.5));
        pause.setOnFinished(event -> {
            if (lives > 0) {
                respawn(); // Respawn if the player still has lives
            } else {
                // Player is out of lives, so they don't respawn
                System.out.println("Player is out of lives and will not respawn.");
                // Notify GameManager to check for game over
                gameManager.triggerGameOver();
            }
        });
        pause.play();
    }

    // Respawn method to reset the player's health and position
    private void respawn() {
        if (lives > 0) {
            // Reset health and position
            health = 100;
            x = initialX;
            y = initialY;

            // Reset sprite and hitbox positions
            spriteView.setX(x);
            spriteView.setY(y);
            hitbox.setVisible(true);
            hitbox.setCenterX(x + spriteView.getFitWidth() / 2);
            hitbox.setCenterY(y + spriteView.getFitHeight() / 2 + 4);
            animationTimeline.play();

            // Reset sprite visibility and state
            spriteView.setVisible(true);
            setFacingDirection("DOWN");
            state = (velocityX == 0 && velocityY == 0) ? "IDLE" : "WALKING";
            currentFrameIndex = 0;
            // Re-enable input
            inputEnabled = true;

            System.out.println("Player respawned with full health!");

            // Reset dead state
            isDead = false;

            // Restart the game loop
            gameManager.restartGameLoop();
        } else {
            System.out.println("Player is out of lives and will be removed from the game.");
            spriteView.setVisible(false); // Hide the player's sprite
            hitbox.setVisible(false); // Hide the player's hitbox
            inputEnabled = false; // Disable input for this player
            isDead = true; // Mark the player as dead
            
            System.out.println("Player is out of lives and cannot respawn.");
        }
    }
}
