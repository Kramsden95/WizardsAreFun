/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Enemy;
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
    private Scene scene;
    private Group group;

    public GameManager(Group group) {
        this.enemies = new ArrayList<>();
        this.group = group;
    }

    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
        group.getChildren().remove(enemy.getSpriteView());
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public Group getGroup() {
        return group;
    }
}
