/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Enemy;
import Model.PowerUp;
import Model.Projectile;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.Group;
import javafx.scene.Scene;

/**
 *
 * @author Kane
 */
public class GameManager {
    private List<Enemy> enemies;
    private List<Projectile> projectiles;
    private List<PowerUp> powerups;
    
    private Scene scene;
    private Group group;

    public GameManager(Group group, Scene scene) {
        this.enemies = new ArrayList<>();
        this.projectiles = new ArrayList<>();
        this.powerups = new ArrayList<>();
        this.group = group;
        this.scene = scene;
    }

    // Add an enemy
    public void addEnemy(Enemy enemy) {
        enemies.add(enemy);
                        group.getChildren().addAll(enemy.getHitbox());
        group.getChildren().add(enemy.getSpriteView());
    }

    // Remove an enemy
    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
                        group.getChildren().remove(enemy.getHitbox());
        group.getChildren().remove(enemy.getSpriteView());
    }

    // Add a projectile
    public void addProjectile(Projectile projectile) {
        projectiles.add(projectile);
                        group.getChildren().addAll(projectile.getHitbox());
        group.getChildren().add(projectile.getSprite());
    }

    // Remove a projectile
    public void removeProjectile(Projectile projectile) {
        projectiles.remove(projectile);
                        group.getChildren().remove(projectile.getHitbox());
        group.getChildren().remove(projectile.getSprite());
    }

    /*
    // Add a Power Up (optional)
    public void addPowerUp(PowerUp item) {
        powerups.add(item);
        group.getChildren().add(item.getSpriteView());
    }

    // Remove a Power Up (optional)
    public void removePowerUp(PowerUp item) {
        powerups.remove(item);
        group.getChildren().remove(item.getSpriteView());
    }
    */
    
    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Projectile> getProjectiles() {
        return projectiles;
    }

    public List<PowerUp> getPowerUps() {
        return powerups;
    }
}
