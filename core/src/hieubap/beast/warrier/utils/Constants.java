package hieubap.beast.warrier.utils;

import com.badlogic.gdx.Gdx;

public class Constants {
    public static final int WIDTH_SCREEN = Gdx.graphics.getWidth();
    public static final int HEIGHT_SCREEN = Gdx.graphics.getHeight();

    // battle
    public static final float BATTLE_START_X_ME = WIDTH_SCREEN*0.1f;
    public static final float BATTLE_START_Y_ME = HEIGHT_SCREEN*0.2f;
    public static final float BATTLE_START_X_ENEMY = WIDTH_SCREEN*0.6f;
    public static final float BATTLE_START_Y_ENEMY = HEIGHT_SCREEN*0.2f;

    public static final int SIZE_CELL_TABLE = (int)(HEIGHT_SCREEN*0.2f);

    // monster
    public static final int MONSTER_ATK = 20;
    public static final int MONSTER_DEF = 10;
    public static final int MONSTER_HP = 100;


    public static final int WHITE_HAT_HP = 30;
    public static final float WHITE_HAT_PER_DEF = 0.1f;
    public static final int WHITE_JACKET_HP = 100;
    public static final int WHITE_JACKET_DEF = 20;
    public static final float WHITE_RING_PER_ATK = 0.05f;
    public static final int WHITE_RING_MANA = 10;
    public static final int WHITE_SHOE_DEF = 20;
    public static final int WHITE_SHOE_SPD = 3;
    public static final int WHITE_SHOE_HP = 50;
    public static final int WHITE_SWORD_ATK = 20;
    public static final int WHITE_TROUSER_DEF = 10;
    public static final float WHITE_TROUSER_PER_HP = 0.05f;


}
