package hieubap.beast.warrier.group;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.List;

import hieubap.beast.warrier.monster.Monster;
import hieubap.beast.warrier.utils.Constants;

public class MonsterSlot {
    public Monster monster;
    public int position;
    public boolean mine;
    public boolean isDead = false;

    public int startX = 0;
    public int startY = 0;
    public boolean isFocus = false;
    public HealthBar healthBar;
    TableBattle tableBattle;

    public MonsterSlot(TableBattle tableBattle, Monster monster, int position, boolean myMonster) {
        this.tableBattle = tableBattle;
        this.monster = monster;
        this.position = position;
        this.mine = myMonster;
        startX = (int)(myMonster ? Constants.BATTLE_START_X_ME : Constants.BATTLE_START_X_ENEMY);
        startY = (int)(myMonster ? Constants.BATTLE_START_Y_ME : Constants.BATTLE_START_Y_ENEMY);
        healthBar = new HealthBar(0,Constants.SIZE_CELL_TABLE,monster.attribute.health);

        if(mine){
            monster.setBound(startX + (2-position%3)* Constants.SIZE_CELL_TABLE,
                    startY + (position/3)* Constants.SIZE_CELL_TABLE,
                    Constants.SIZE_CELL_TABLE,
                    Constants.SIZE_CELL_TABLE);

            healthBar.update(startX + (2-position%3)* Constants.SIZE_CELL_TABLE,
                    startY + (position/3)* Constants.SIZE_CELL_TABLE);
        }else{
            monster.setBound(startX + (position%3)* Constants.SIZE_CELL_TABLE,
                    startY + (position/3)* Constants.SIZE_CELL_TABLE,
                    Constants.SIZE_CELL_TABLE,
                    Constants.SIZE_CELL_TABLE);

            healthBar.update(startX + (position%3)* Constants.SIZE_CELL_TABLE,
                    startY + (position/3)* Constants.SIZE_CELL_TABLE);
        }

    }

    public void update(float delta){
        if(isDead) return;

        monster.update(delta);
        if(monster.attribute.health <= 0){
            isDead = true;
            if(mine){
                tableBattle.playerSet.remove(position);
                tableBattle.playerTable.remove(this);
            }else{
                tableBattle.enemySet.remove(position);
                tableBattle.enemyTable.remove(this);
            }
        }
    }

    public void draw(SpriteBatch batch){
        monster.draw(batch);
        healthBar.changeLife(monster.attribute.health);
        healthBar.update();
        healthBar.draw(batch);

    }
}
