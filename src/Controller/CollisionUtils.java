/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import javafx.scene.shape.Circle;

/**
 *
 * @author kkrc9
 */
public class CollisionUtils {
    public static boolean checkCollision(Circle hitbox1, Circle hitbox2) {
        double dx = hitbox1.getCenterX() - hitbox2.getCenterX();
        double dy = hitbox1.getCenterY() - hitbox2.getCenterY();
        double distanceSquared = dx * dx + dy * dy;
        double radiusSum = hitbox1.getRadius() + hitbox2.getRadius();
        return distanceSquared < radiusSum * radiusSum;
    }
}
