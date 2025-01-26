/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author kkrc9
 */
public class Logica {
    String[] fireballFrames = {
        "src/Media/Fireball/fireball001.png",
        "src/Media/Fireball/fireball002.png",
        "src/Media/Fireball/fireball003.png",
        "src/Media/Fireball/fireball004.png",
        "src/Media/Fireball/fireball005.png",
        "src/Media/Fireball/fireball006.png",
        "src/Media/Fireball/fireball007.png",
        "src/Media/Fireball/fireball008.png",
        "src/Media/Fireball/fireball009.png",
        "src/Media/Fireball/fireball010.png",
        "src/Media/Fireball/fireball011.png",
        "src/Media/Fireball/fireball012.png",
        "src/Media/Fireball/fireball013.png",
        "src/Media/Fireball/fireball014.png",
        "src/Media/Fireball/fireball015.png",
        "src/Media/Fireball/fireball016.png",
        "src/Media/Fireball/fireball017.png",
        "src/Media/Fireball/fireball018.png",
        "src/Media/Fireball/fireball019.png",
        "src/Media/Fireball/fireball020.png",
        "src/Media/Fireball/fireball021.png",
        "src/Media/Fireball/fireball022.png",
        "src/Media/Fireball/fireball023.png",
        "src/Media/Fireball/fireball024.png",
        "src/Media/Fireball/fireball025.png",
        "src/Media/Fireball/fireball026.png",
        "src/Media/Fireball/fireball027.png",
        "src/Media/Fireball/fireball028.png",
        "src/Media/Fireball/fireball029.png",
        "src/Media/Fireball/fireball030.png",
        "src/Media/Fireball/fireball031.png",
        "src/Media/Fireball/fireball032.png",
        "src/Media/Fireball/fireball033.png",
        "src/Media/Fireball/fireball034.png",
        "src/Media/Fireball/fireball035.png",
        "src/Media/Fireball/fireball036.png",
        "src/Media/Fireball/fireball037.png",
        "src/Media/Fireball/fireball038.png",
        "src/Media/Fireball/fireball039.png",
        "src/Media/Fireball/fireball040.png",
        "src/Media/Fireball/fireball041.png",
        "src/Media/Fireball/fireball042.png",
        "src/Media/Fireball/fireball043.png",
        "src/Media/Fireball/fireball044.png",
        "src/Media/Fireball/fireball045.png",
        "src/Media/Fireball/fireball046.png",
        "src/Media/Fireball/fireball047.png",
        "src/Media/Fireball/fireball048.png",
        "src/Media/Fireball/fireball049.png",
        "src/Media/Fireball/fireball050.png",
        "src/Media/Fireball/fireball051.png",
        "src/Media/Fireball/fireball052.png",
        "src/Media/Fireball/fireball053.png",
        "src/Media/Fireball/fireball054.png",
        "src/Media/Fireball/fireball055.png",
        "src/Media/Fireball/fireball056.png",
        "src/Media/Fireball/fireball057.png",
        "src/Media/Fireball/fireball058.png",
        "src/Media/Fireball/fireball059.png",
        "src/Media/Fireball/fireball060.png",
    };
    
    // Character Select frames
    private String[] CharacterASelection = {
        "src/Media/CharacterSelectSprite/CharacterA_Select_0.png",
        "src/Media/CharacterSelectSprite/CharacterA_Select_1.png",
        "src/Media/CharacterSelectSprite/CharacterA_Select_2.png",
        "src/Media/CharacterSelectSprite/CharacterA_Select_3.png"
    };
    
    private String[] CharacterBSelection = {
        "src/Media/CharacterSelectSprite/CharacterB_Select_0.png",
        "src/Media/CharacterSelectSprite/CharacterB_Select_1.png",
        "src/Media/CharacterSelectSprite/CharacterB_Select_2.png",
        "src/Media/CharacterSelectSprite/CharacterB_Select_3.png"
    };
    
    private String[] CharacterCSelection = {
        "src/Media/CharacterSelectSprite/CharacterC_Select_0.png",
        "src/Media/CharacterSelectSprite/CharacterC_Select_1.png",
        "src/Media/CharacterSelectSprite/CharacterC_Select_2.png",
        "src/Media/CharacterSelectSprite/CharacterC_Select_3.png"
    };
    
    private String[] CharacterDSelection = {
        "src/Media/CharacterSelectSprite/CharacterD_Select_0.png",
        "src/Media/CharacterSelectSprite/CharacterD_Select_1.png",
        "src/Media/CharacterSelectSprite/CharacterD_Select_2.png",
        "src/Media/CharacterSelectSprite/CharacterD_Select_3.png"
    };
    
    private String[] CharacterESelection = {
        "src/Media/CharacterSelectSprite/CharacterE_Select_0.png",
        "src/Media/CharacterSelectSprite/CharacterE_Select_1.png",
        "src/Media/CharacterSelectSprite/CharacterE_Select_2.png",
        "src/Media/CharacterSelectSprite/CharacterE_Select_3.png"
    };
    
    private String[] CharacterFSelection = {
        "src/Media/CharacterSelectSprite/CharacterF_Select_0.png",
        "src/Media/CharacterSelectSprite/CharacterF_Select_1.png",
        "src/Media/CharacterSelectSprite/CharacterF_Select_2.png",
        "src/Media/CharacterSelectSprite/CharacterF_Select_3.png"
    };
    
    // Character A sprite frames
    private String[] CharacterAIdleUP = {
        "src/Media/CharacterA/CharacterA_idle_UP_00.png",
        "src/Media/CharacterA/CharacterA_idle_UP_01.png",
        "src/Media/CharacterA/CharacterA_idle_UP_02.png",
        "src/Media/CharacterA/CharacterA_idle_UP_03.png"
    };
    
    private String[] CharacterAIdleDOWN = {
        "src/Media/CharacterA/CharacterA_idle_DOWN_00.png",
        "src/Media/CharacterA/CharacterA_idle_DOWN_01.png",
        "src/Media/CharacterA/CharacterA_idle_DOWN_02.png",
        "src/Media/CharacterA/CharacterA_idle_DOWN_03.png"
    };
    
    private String[] CharacterAIdleLEFT = {
        "src/Media/CharacterA/CharacterA_idle_LEFT_00.png",
        "src/Media/CharacterA/CharacterA_idle_LEFT_01.png",
        "src/Media/CharacterA/CharacterA_idle_LEFT_02.png",
        "src/Media/CharacterA/CharacterA_idle_LEFT_03.png"
    };
    
    private String[] CharacterAIdleRIGHT = {
        "src/Media/CharacterA/CharacterA_idle_RIGHT_00.png",
        "src/Media/CharacterA/CharacterA_idle_RIGHT_01.png",
        "src/Media/CharacterA/CharacterA_idle_RIGHT_02.png",
        "src/Media/CharacterA/CharacterA_idle_RIGHT_03.png"
    };
    
    private String[] CharacterAWalkUP = {
        "src/Media/CharacterA/CharacterA_Walk_UP_00.png",
        "src/Media/CharacterA/CharacterA_Walk_UP_01.png",
        "src/Media/CharacterA/CharacterA_Walk_UP_02.png",
        "src/Media/CharacterA/CharacterA_Walk_UP_03.png"
    };
    
    private String[] CharacterAWalkDOWN = {
        "src/Media/CharacterA/CharacterA_Walk_DOWN_00.png",
        "src/Media/CharacterA/CharacterA_Walk_DOWN_01.png",
        "src/Media/CharacterA/CharacterA_Walk_DOWN_02.png",
        "src/Media/CharacterA/CharacterA_Walk_DOWN_03.png"
    };
    
    private String[] CharacterAWalkLEFT = {
        "src/Media/CharacterA/CharacterA_Walk_LEFT_00.png",
        "src/Media/CharacterA/CharacterA_Walk_LEFT_01.png",
        "src/Media/CharacterA/CharacterA_Walk_LEFT_02.png",
        "src/Media/CharacterA/CharacterA_Walk_LEFT_03.png"
    };
    
    private String[] CharacterAWalkRIGHT = {
        "src/Media/CharacterA/CharacterA_Walk_RIGHT_00.png",
        "src/Media/CharacterA/CharacterA_Walk_RIGHT_01.png",
        "src/Media/CharacterA/CharacterA_Walk_RIGHT_02.png",
        "src/Media/CharacterA/CharacterA_Walk_RIGHT_03.png"
    };
    
    // Character B sprite frames
    private String[] CharacterBIdleUP = {
        "src/Media/CharacterB/CharacterB_idle_UP_00.png",
        "src/Media/CharacterA/CharacterB_idle_UP_01.png",
        "src/Media/CharacterA/CharacterB_idle_UP_02.png",
        "src/Media/CharacterA/CharacterB_idle_UP_03.png"
    };
    
    private String[] CharacterBIdleDOWN = {
        "src/Media/CharacterB/CharacterB_idle_DOWN_00.png",
        "src/Media/CharacterB/CharacterB_idle_DOWN_01.png",
        "src/Media/CharacterB/CharacterB_idle_DOWN_02.png",
        "src/Media/CharacterB/CharacterB_idle_DOWN_03.png"
    };
    
    private String[] CharacterBIdleLEFT = {
        "src/Media/CharacterB/CharacterB_idle_LEFT_00.png",
        "src/Media/CharacterB/CharacterB_idle_LEFT_01.png",
        "src/Media/CharacterB/CharacterB_idle_LEFT_02.png",
        "src/Media/CharacterB/CharacterB_idle_LEFT_03.png"
    };
    
    private String[] CharacterBIdleRIGHT = {
        "src/Media/CharacterB/CharacterB_idle_RIGHT_00.png",
        "src/Media/CharacterB/CharacterB_idle_RIGHT_01.png",
        "src/Media/CharacterB/CharacterB_idle_RIGHT_02.png",
        "src/Media/CharacterB/CharacterB_idle_RIGHT_03.png"
    };
    
    private String[] CharacterBWalkUP = {
        "src/Media/CharacterB/CharacterB_Walk_UP_00.png",
        "src/Media/CharacterB/CharacterB_Walk_UP_01.png",
        "src/Media/CharacterB/CharacterB_Walk_UP_02.png",
        "src/Media/CharacterB/CharacterB_Walk_UP_03.png"
    };
    
    private String[] CharacterBWalkDOWN = {
        "src/Media/CharacterB/CharacterB_Walk_DOWN_00.png",
        "src/Media/CharacterB/CharacterB_Walk_DOWN_01.png",
        "src/Media/CharacterB/CharacterB_Walk_DOWN_02.png",
        "src/Media/CharacterB/CharacterB_Walk_DOWN_03.png"
    };
    
    private String[] CharacterBWalkLEFT = {
        "src/Media/CharacterB/CharacterB_Walk_LEFT_00.png",
        "src/Media/CharacterB/CharacterB_Walk_LEFT_01.png",
        "src/Media/CharacterB/CharacterB_Walk_LEFT_02.png",
        "src/Media/CharacterB/CharacterB_Walk_LEFT_03.png"
    };
    
    private String[] CharacterBWalkRIGHT = {
        "src/Media/CharacterB/CharacterB_Walk_RIGHT_00.png",
        "src/Media/CharacterB/CharacterB_Walk_RIGHT_01.png",
        "src/Media/CharacterB/CharacterB_Walk_RIGHT_02.png",
        "src/Media/CharacterB/CharacterB_Walk_RIGHT_03.png"
    };
    
    // Character C sprite frames
    private String[] CharacterCIdleUP = {
        "src/Media/CharacterC/CharacterC_idle_UP_00.png",
        "src/Media/CharacterC/CharacterC_idle_UP_01.png",
        "src/Media/CharacterC/CharacterC_idle_UP_02.png",
        "src/Media/CharacterC/CharacterC_idle_UP_03.png"
    };
    
    private String[] CharacterCIdleDOWN = {
        "src/Media/CharacterC/CharacterC_idle_DOWN_00.png",
        "src/Media/CharacterC/CharacterC_idle_DOWN_01.png",
        "src/Media/CharacterC/CharacterC_idle_DOWN_02.png",
        "src/Media/CharacterC/CharacterC_idle_DOWN_03.png"
    };
    
    private String[] CharacterCIdleLEFT = {
        "src/Media/CharacterC/CharacterC_idle_LEFT_00.png",
        "src/Media/CharacterC/CharacterC_idle_LEFT_01.png",
        "src/Media/CharacterC/CharacterC_idle_LEFT_02.png",
        "src/Media/CharacterC/CharacterC_idle_LEFT_03.png"
    };
    
    private String[] CharacterCIdleRIGHT = {
        "src/Media/CharacterC/CharacterC_idle_RIGHT_00.png",
        "src/Media/CharacterC/CharacterC_idle_RIGHT_01.png",
        "src/Media/CharacterC/CharacterC_idle_RIGHT_02.png",
        "src/Media/CharacterC/CharacterC_idle_RIGHT_03.png"
    };
    
    private String[] CharacterCWalkUP = {
        "src/Media/CharacterC/CharacterC_Walk_UP_00.png",
        "src/Media/CharacterC/CharacterC_Walk_UP_01.png",
        "src/Media/CharacterC/CharacterC_Walk_UP_02.png",
        "src/Media/CharacterC/CharacterC_Walk_UP_03.png"
    };
    
    private String[] CharacterCWalkDOWN = {
        "src/Media/CharacterC/CharacterC_Walk_DOWN_00.png",
        "src/Media/CharacterC/CharacterC_Walk_DOWN_01.png",
        "src/Media/CharacterC/CharacterC_Walk_DOWN_02.png",
        "src/Media/CharacterC/CharacterC_Walk_DOWN_03.png"
    };
    
    private String[] CharacterCWalkLEFT = {
        "src/Media/CharacterC/CharacterC_Walk_LEFT_00.png",
        "src/Media/CharacterC/CharacterC_Walk_LEFT_01.png",
        "src/Media/CharacterC/CharacterC_Walk_LEFT_02.png",
        "src/Media/CharacterC/CharacterC_Walk_LEFT_03.png"
    };
    
    private String[] CharacterCWalkRIGHT = {
        "src/Media/CharacterC/CharacterC_Walk_RIGHT_00.png",
        "src/Media/CharacterC/CharacterC_Walk_RIGHT_01.png",
        "src/Media/CharacterC/CharacterC_Walk_RIGHT_02.png",
        "src/Media/CharacterC/CharacterC_Walk_RIGHT_03.png"
    };
    
    // Character D sprite frames
    private String[] CharacterDIdleUP = {
        "src/Media/CharacterD/CharacterD_idle_UP_00.png",
        "src/Media/CharacterD/CharacterD_idle_UP_01.png",
        "src/Media/CharacterD/CharacterD_idle_UP_02.png",
        "src/Media/CharacterD/CharacterD_idle_UP_03.png"
    };
    
    private String[] CharacterDIdleDOWN = {
        "src/Media/CharacterD/CharacterD_idle_DOWN_00.png",
        "src/Media/CharacterD/CharacterD_idle_DOWN_01.png",
        "src/Media/CharacterD/CharacterD_idle_DOWN_02.png",
        "src/Media/CharacterD/CharacterD_idle_DOWN_03.png"
    };
    
    private String[] CharacterDIdleLEFT = {
        "src/Media/CharacterD/CharacterD_idle_LEFT_00.png",
        "src/Media/CharacterD/CharacterD_idle_LEFT_01.png",
        "src/Media/CharacterD/CharacterD_idle_LEFT_02.png",
        "src/Media/CharacterD/CharacterD_idle_LEFT_03.png"
    };
    
    private String[] CharacterDIdleRIGHT = {
        "src/Media/CharacterD/CharacterD_idle_RIGHT_00.png",
        "src/Media/CharacterD/CharacterD_idle_RIGHT_01.png",
        "src/Media/CharacterD/CharacterD_idle_RIGHT_02.png",
        "src/Media/CharacterD/CharacterD_idle_RIGHT_03.png"
    };
    
    private String[] CharacterDWalkUP = {
        "src/Media/CharacterD/CharacterD_Walk_UP_00.png",
        "src/Media/CharacterD/CharacterD_Walk_UP_01.png",
        "src/Media/CharacterD/CharacterD_Walk_UP_02.png",
        "src/Media/CharacterD/CharacterD_Walk_UP_03.png"
    };
    
    private String[] CharacterDWalkDOWN = {
        "src/Media/CharacterD/CharacterD_Walk_DOWN_00.png",
        "src/Media/CharacterD/CharacterD_Walk_DOWN_01.png",
        "src/Media/CharacterD/CharacterD_Walk_DOWN_02.png",
        "src/Media/CharacterD/CharacterD_Walk_DOWN_03.png"
    };
    
    private String[] CharacterDWalkLEFT = {
        "src/Media/CharacterD/CharacterD_Walk_LEFT_00.png",
        "src/Media/CharacterD/CharacterD_Walk_LEFT_01.png",
        "src/Media/CharacterD/CharacterD_Walk_LEFT_02.png",
        "src/Media/CharacterD/CharacterD_Walk_LEFT_03.png"
    };
    
    private String[] CharacterDWalkRIGHT = {
        "src/Media/CharacterD/CharacterD_Walk_RIGHT_00.png",
        "src/Media/CharacterD/CharacterD_Walk_RIGHT_01.png",
        "src/Media/CharacterD/CharacterD_Walk_RIGHT_02.png",
        "src/Media/CharacterD/CharacterD_Walk_RIGHT_03.png"
    };
    
    // Character E sprite frames
    private String[] CharacterEIdleUP = {
        "src/Media/CharacterE/CharacterE_idle_UP_00.png",
        "src/Media/CharacterE/CharacterE_idle_UP_01.png",
        "src/Media/CharacterE/CharacterE_idle_UP_02.png",
        "src/Media/CharacterE/CharacterE_idle_UP_03.png"
    };
    
    private String[] CharacterEIdleDOWN = {
        "src/Media/CharacterE/CharacterE_idle_DOWN_00.png",
        "src/Media/CharacterE/CharacterE_idle_DOWN_01.png",
        "src/Media/CharacterE/CharacterE_idle_DOWN_02.png",
        "src/Media/CharacterE/CharacterE_idle_DOWN_03.png"
    };
    
    private String[] CharacterEIdleLEFT = {
        "src/Media/CharacterE/CharacterE_idle_LEFT_00.png",
        "src/Media/CharacterE/CharacterE_idle_LEFT_01.png",
        "src/Media/CharacterE/CharacterE_idle_LEFT_02.png",
        "src/Media/CharacterE/CharacterE_idle_LEFT_03.png"
    };
    
    private String[] CharacterEIdleRIGHT = {
        "src/Media/CharacterE/CharacterE_idle_RIGHT_00.png",
        "src/Media/CharacterE/CharacterE_idle_RIGHT_01.png",
        "src/Media/CharacterE/CharacterE_idle_RIGHT_02.png",
        "src/Media/CharacterE/CharacterE_idle_RIGHT_03.png"
    };
    
    private String[] CharacterEWalkUP = {
        "src/Media/CharacterE/CharacterE_Walk_UP_00.png",
        "src/Media/CharacterE/CharacterE_Walk_UP_01.png",
        "src/Media/CharacterE/CharacterE_Walk_UP_02.png",
        "src/Media/CharacterE/CharacterE_Walk_UP_03.png"
    };
    
    private String[] CharacterEWalkDOWN = {
        "src/Media/CharacterE/CharacterE_Walk_DOWN_00.png",
        "src/Media/CharacterE/CharacterE_Walk_DOWN_01.png",
        "src/Media/CharacterE/CharacterE_Walk_DOWN_02.png",
        "src/Media/CharacterE/CharacterE_Walk_DOWN_03.png"
    };
    
    private String[] CharacterEWalkLEFT = {
        "src/Media/CharacterE/CharacterE_Walk_LEFT_00.png",
        "src/Media/CharacterE/CharacterE_Walk_LEFT_01.png",
        "src/Media/CharacterE/CharacterE_Walk_LEFT_02.png",
        "src/Media/CharacterE/CharacterE_Walk_LEFT_03.png"
    };
    
    private String[] CharacterEWalkRIGHT = {
        "src/Media/CharacterE/CharacterE_Walk_RIGHT_00.png",
        "src/Media/CharacterE/CharacterE_Walk_RIGHT_01.png",
        "src/Media/CharacterE/CharacterE_Walk_RIGHT_02.png",
        "src/Media/CharacterE/CharacterE_Walk_RIGHT_03.png"
    };
    
    // Character F sprite frames
    private String[] CharacterFIdleUP = {
        "src/Media/CharacterF/CharacterF_idle_UP_00.png",
        "src/Media/CharacterF/CharacterF_idle_UP_01.png",
        "src/Media/CharacterF/CharacterF_idle_UP_02.png",
        "src/Media/CharacterF/CharacterF_idle_UP_03.png"
    };
    
    private String[] CharacterFIdleDOWN = {
        "src/Media/CharacterF/CharacterF_idle_DOWN_00.png",
        "src/Media/CharacterF/CharacterF_idle_DOWN_01.png",
        "src/Media/CharacterF/CharacterF_idle_DOWN_02.png",
        "src/Media/CharacterF/CharacterF_idle_DOWN_03.png"
    };
    
    private String[] CharacterFIdleLEFT = {
        "src/Media/CharacterF/CharacterF_idle_LEFT_00.png",
        "src/Media/CharacterF/CharacterF_idle_LEFT_01.png",
        "src/Media/CharacterF/CharacterF_idle_LEFT_02.png",
        "src/Media/CharacterF/CharacterF_idle_LEFT_03.png"
    };
    
    private String[] CharacterFIdleRIGHT = {
        "src/Media/CharacterF/CharacterF_idle_RIGHT_00.png",
        "src/Media/CharacterF/CharacterF_idle_RIGHT_01.png",
        "src/Media/CharacterF/CharacterF_idle_RIGHT_02.png",
        "src/Media/CharacterF/CharacterF_idle_RIGHT_03.png"
    };
    
    private String[] CharacterFWalkUP = {
        "src/Media/CharacterF/CharacterF_Walk_UP_00.png",
        "src/Media/CharacterF/CharacterF_Walk_UP_01.png",
        "src/Media/CharacterF/CharacterF_Walk_UP_02.png",
        "src/Media/CharacterF/CharacterF_Walk_UP_03.png"
    };
    
    private String[] CharacterFWalkDOWN = {
        "src/Media/CharacterF/CharacterF_Walk_DOWN_00.png",
        "src/Media/CharacterF/CharacterF_Walk_DOWN_01.png",
        "src/Media/CharacterF/CharacterF_Walk_DOWN_02.png",
        "src/Media/CharacterF/CharacterF_Walk_DOWN_03.png"
    };
    
    private String[] CharacterFWalkLEFT = {
        "src/Media/CharacterF/CharacterF_Walk_LEFT_00.png",
        "src/Media/CharacterF/CharacterF_Walk_LEFT_01.png",
        "src/Media/CharacterF/CharacterF_Walk_LEFT_02.png",
        "src/Media/CharacterF/CharacterF_Walk_LEFT_03.png"
    };
    
    private String[] CharacterFWalkRIGHT = {
        "src/Media/CharacterF/CharacterF_Walk_RIGHT_00.png",
        "src/Media/CharacterF/CharacterF_Walk_RIGHT_01.png",
        "src/Media/CharacterF/CharacterF_Walk_RIGHT_02.png",
        "src/Media/CharacterF/CharacterF_Walk_RIGHT_03.png"
    };
    
    // Enemy 1 sprite frames
    private String[] Enemy1DieUP = {
        "src/Media/Enemy1/Proto1_die_UP_00.png",
        "src/Media/Enemy1/Proto1_die_UP_01.png",
        "src/Media/Enemy1/Proto1_die_UP_02.png"
    };
    
    private String[] Enemy1DieDOWN = {
        "src/Media/Enemy1/Proto1_die_DOWN_00.png",
        "src/Media/Enemy1/Proto1_die_DOWN_01.png",
        "src/Media/Enemy1/Proto1_die_DOWN_02.png"
    };
    
    private String[] Enemy1DieSIDES = {
        "src/Media/Enemy1/Proto1_die_RIGHT_00.png",
        "src/Media/Enemy1/Proto1_die_RIGHT_01.png",
        "src/Media/Enemy1/Proto1_die_RIGHT_02.png"
    };
    
    private String[] Enemy1HitUP = {
        "src/Media/Enemy1/Proto1_hit_UP_00.png",
        "src/Media/Enemy1/Proto1_hit_UP_01.png",
        "src/Media/Enemy1/Proto1_hit_UP_02.png"
    };
    
    private String[] Enemy1HitDOWN = {
        "src/Media/Enemy1/Proto1_hit_DOWN_00.png",
        "src/Media/Enemy1/Proto1_hit_DOWN_01.png",
        "src/Media/Enemy1/Proto1_hit_DOWN_02.png"
    };
    
    private String[] Enemy1HitSIDES = {
        "src/Media/Enemy1/Proto1_hit_RIGHT_00.png",
        "src/Media/Enemy1/Proto1_hit_RIGHT_01.png",
        "src/Media/Enemy1/Proto1_hit_RIGHT_02.png"
    };
    
    private String[] Enemy1WalkUP = {
        "src/Media/Enemy1/Proto1_walk_UP_00.png",
        "src/Media/Enemy1/Proto1_walk_UP_01.png",
        "src/Media/Enemy1/Proto1_walk_UP_02.png",
        "src/Media/Enemy1/Proto1_walk_UP_03.png"
    };
    
    private String[] Enemy1WalkDOWN = {
        "src/Media/Enemy1/Proto1_walk_DOWN_00.png",
        "src/Media/Enemy1/Proto1_walk_DOWN_01.png",
        "src/Media/Enemy1/Proto1_walk_DOWN_02.png",
        "src/Media/Enemy1/Proto1_walk_DOWN_03.png"
    };
    
    private String[] Enemy1WalkSIDES = {
        "src/Media/Enemy1/Proto1_walk_RIGHT_00.png",
        "src/Media/Enemy1/Proto1_walk_RIGHT_01.png",
        "src/Media/Enemy1/Proto1_walk_RIGHT_02.png",
        "src/Media/Enemy1/Proto1_walk_RIGHT_03.png"
    };
    
    // Player 1 sprite death frames
    private String[] Player1DeathAnimation = {
        "src/Media/Explosion/Explosion_0.png",
        "src/Media/Explosion/Explosion_1.png",
        "src/Media/Explosion/Explosion_2.png",
        "src/Media/Explosion/Explosion_3.png",
        "src/Media/Explosion/Explosion_4.png",
        "src/Media/Explosion/Explosion_5.png",
        "src/Media/Explosion/Explosion_6.png",
        "src/Media/P1Ghost/Ghost_00.png",
        "src/Media/P1Ghost/Ghost_01.png",
        "src/Media/P1Ghost/Ghost_02.png",
        "src/Media/P1Ghost/Ghost_03.png",
        "src/Media/P1Ghost/Ghost_04.png",
        "src/Media/P1Ghost/Ghost_05.png",
        "src/Media/P1Ghost/Ghost_06.png",
        "src/Media/P1Ghost/Ghost_07.png",
        "src/Media/P1Ghost/Ghost_08.png",
        "src/Media/P1Ghost/Ghost_09.png",
        "src/Media/P1Ghost/Ghost_10.png",
        "src/Media/P1Ghost/Ghost_11.png",
        "src/Media/P1Ghost/Ghost_12.png"
    };
    
    // Player 2 sprite death frames
    private String[] Player2DeathAnimation = {
        "src/Media/Explosion/Explosion_0.png",
        "src/Media/Explosion/Explosion_1.png",
        "src/Media/Explosion/Explosion_2.png",
        "src/Media/Explosion/Explosion_3.png",
        "src/Media/Explosion/Explosion_4.png",
        "src/Media/Explosion/Explosion_5.png",
        "src/Media/Explosion/Explosion_6.png",
        "src/Media/P1Ghost/Ghost_13.png",
        "src/Media/P1Ghost/Ghost_14.png",
        "src/Media/P1Ghost/Ghost_15.png",
        "src/Media/P1Ghost/Ghost_16.png",
        "src/Media/P1Ghost/Ghost_17.png",
        "src/Media/P1Ghost/Ghost_18.png",
        "src/Media/P1Ghost/Ghost_19.png",
        "src/Media/P1Ghost/Ghost_20.png",
        "src/Media/P1Ghost/Ghost_21.png",
        "src/Media/P1Ghost/Ghost_22.png",
        "src/Media/P1Ghost/Ghost_23.png",
        "src/Media/P1Ghost/Ghost_24.png",
        "src/Media/P1Ghost/Ghost_25.png"
    };
    
    private String[] heartLifeAnimation = {
        "src/Media/HealthHearts/Heart_00.png",
        "src/Media/HealthHearts/Heart_01.png",
        "src/Media/HealthHearts/Heart_02.png",
        "src/Media/HealthHearts/Heart_03.png",
        "src/Media/HealthHearts/Heart_04.png",
        "src/Media/HealthHearts/Heart_05.png",
        "src/Media/HealthHearts/Heart_06.png",
        "src/Media/HealthHearts/Heart_07.png",
        "src/Media/HealthHearts/Heart_08.png",
        "src/Media/HealthHearts/Heart_09.png"
    };

    public Logica() {
    }
    
    // All Getters
    public String[] getFireballFrames() {
        return fireballFrames;
    }

    public String[] getCharacterASelection() {
        return CharacterASelection;
    }

    public String[] getCharacterBSelection() {
        return CharacterBSelection;
    }

    public String[] getCharacterCSelection() {
        return CharacterCSelection;
    }

    public String[] getCharacterDSelection() {
        return CharacterDSelection;
    }

    public String[] getCharacterESelection() {
        return CharacterESelection;
    }

    public String[] getCharacterFSelection() {
        return CharacterFSelection;
    }

    public String[] getCharacterAIdleUP() {
        return CharacterAIdleUP;
    }

    public String[] getCharacterAIdleDOWN() {
        return CharacterAIdleDOWN;
    }

    public String[] getCharacterAIdleLEFT() {
        return CharacterAIdleLEFT;
    }

    public String[] getCharacterAIdleRIGHT() {
        return CharacterAIdleRIGHT;
    }

    public String[] getCharacterAWalkUP() {
        return CharacterAWalkUP;
    }

    public String[] getCharacterAWalkDOWN() {
        return CharacterAWalkDOWN;
    }

    public String[] getCharacterAWalkLEFT() {
        return CharacterAWalkLEFT;
    }

    public String[] getCharacterAWalkRIGHT() {
        return CharacterAWalkRIGHT;
    }

    public String[] getCharacterBIdleUP() {
        return CharacterBIdleUP;
    }

    public String[] getCharacterBIdleDOWN() {
        return CharacterBIdleDOWN;
    }

    public String[] getCharacterBIdleLEFT() {
        return CharacterBIdleLEFT;
    }

    public String[] getCharacterBIdleRIGHT() {
        return CharacterBIdleRIGHT;
    }

    public String[] getCharacterBWalkUP() {
        return CharacterBWalkUP;
    }

    public String[] getCharacterBWalkDOWN() {
        return CharacterBWalkDOWN;
    }

    public String[] getCharacterBWalkLEFT() {
        return CharacterBWalkLEFT;
    }

    public String[] getCharacterBWalkRIGHT() {
        return CharacterBWalkRIGHT;
    }

    public String[] getCharacterCIdleUP() {
        return CharacterCIdleUP;
    }

    public String[] getCharacterCIdleDOWN() {
        return CharacterCIdleDOWN;
    }

    public String[] getCharacterCIdleLEFT() {
        return CharacterCIdleLEFT;
    }

    public String[] getCharacterCIdleRIGHT() {
        return CharacterCIdleRIGHT;
    }

    public String[] getCharacterCWalkUP() {
        return CharacterCWalkUP;
    }

    public String[] getCharacterCWalkDOWN() {
        return CharacterCWalkDOWN;
    }

    public String[] getCharacterCWalkLEFT() {
        return CharacterCWalkLEFT;
    }

    public String[] getCharacterCWalkRIGHT() {
        return CharacterCWalkRIGHT;
    }

    public String[] getCharacterDIdleUP() {
        return CharacterDIdleUP;
    }

    public String[] getCharacterDIdleDOWN() {
        return CharacterDIdleDOWN;
    }

    public String[] getCharacterDIdleLEFT() {
        return CharacterDIdleLEFT;
    }

    public String[] getCharacterDIdleRIGHT() {
        return CharacterDIdleRIGHT;
    }

    public String[] getCharacterDWalkUP() {
        return CharacterDWalkUP;
    }

    public String[] getCharacterDWalkDOWN() {
        return CharacterDWalkDOWN;
    }

    public String[] getCharacterDWalkLEFT() {
        return CharacterDWalkLEFT;
    }

    public String[] getCharacterDWalkRIGHT() {
        return CharacterDWalkRIGHT;
    }

    public String[] getCharacterEIdleUP() {
        return CharacterEIdleUP;
    }

    public String[] getCharacterEIdleDOWN() {
        return CharacterEIdleDOWN;
    }

    public String[] getCharacterEIdleLEFT() {
        return CharacterEIdleLEFT;
    }

    public String[] getCharacterEIdleRIGHT() {
        return CharacterEIdleRIGHT;
    }

    public String[] getCharacterEWalkUP() {
        return CharacterEWalkUP;
    }

    public String[] getCharacterEWalkDOWN() {
        return CharacterEWalkDOWN;
    }

    public String[] getCharacterEWalkLEFT() {
        return CharacterEWalkLEFT;
    }

    public String[] getCharacterEWalkRIGHT() {
        return CharacterEWalkRIGHT;
    }

    public String[] getCharacterFIdleUP() {
        return CharacterFIdleUP;
    }

    public String[] getCharacterFIdleDOWN() {
        return CharacterFIdleDOWN;
    }

    public String[] getCharacterFIdleLEFT() {
        return CharacterFIdleLEFT;
    }

    public String[] getCharacterFIdleRIGHT() {
        return CharacterFIdleRIGHT;
    }

    public String[] getCharacterFWalkUP() {
        return CharacterFWalkUP;
    }

    public String[] getCharacterFWalkDOWN() {
        return CharacterFWalkDOWN;
    }

    public String[] getCharacterFWalkLEFT() {
        return CharacterFWalkLEFT;
    }

    public String[] getCharacterFWalkRIGHT() {
        return CharacterFWalkRIGHT;
    }

    public String[] getEnemy1DieUP() {
        return Enemy1DieUP;
    }

    public String[] getEnemy1DieDOWN() {
        return Enemy1DieDOWN;
    }

    public String[] getEnemy1DieSIDES() {
        return Enemy1DieSIDES;
    }

    public String[] getEnemy1HitUP() {
        return Enemy1HitUP;
    }

    public String[] getEnemy1HitDOWN() {
        return Enemy1HitDOWN;
    }

    public String[] getEnemy1HitSIDES() {
        return Enemy1HitSIDES;
    }

    public String[] getEnemy1WalkUP() {
        return Enemy1WalkUP;
    }

    public String[] getEnemy1WalkDOWN() {
        return Enemy1WalkDOWN;
    }

    public String[] getEnemy1WalkSIDES() {
        return Enemy1WalkSIDES;
    }

    public String[] getPlayer1DeathAnimation() {
        return Player1DeathAnimation;
    }

    public String[] getPlayer2DeathAnimation() {
        return Player2DeathAnimation;
    }

    public String[] getHeartLifeAnimation() {
        return heartLifeAnimation;
    }
}
