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

    public Logica() {
    }

    public String[] getFireballFrames() {
        return fireballFrames;
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
    
    
}
