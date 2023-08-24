package hieubap.beast.warrier.group;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import hieubap.beast.warrier.monster.Monster;

public class TableBattle {
    // 3x3
    public List<MonsterSlot> playerTable;
    public List<MonsterSlot> enemyTable;
    public List<MonsterSlot> turns;

    public Set<Integer> playerSet;
    public Set<Integer> enemySet;

    public float counter = 0;
    public int current = 0;

    public TableBattle() {
        playerTable = new ArrayList<>();
        enemyTable = new ArrayList<>();
        turns = new ArrayList<>();

        playerSet = new HashSet<>();
        enemySet = new HashSet<>();
    }

    public void addMonster(boolean isMe, Monster monster, int position){
        MonsterSlot monsterOn = new MonsterSlot(this,monster,position,isMe);
        monster.monsterSlot = monsterOn;

        if(isMe){
            playerTable.add(monsterOn);
            playerSet.add(position);
        }else{
            enemyTable.add(monsterOn);
            enemySet.add(position);
        }
        turns.add(monsterOn);
    }

    public void draw(SpriteBatch batch){
        for(MonsterSlot monsterOn : playerTable){
            monsterOn.draw(batch);
        }

        for(MonsterSlot monsterOn : enemyTable){
            monsterOn.draw(batch);
        }
    }

    public void update(float delta){
        // finish game
        if(enemyTable.size() == 0 || playerTable.size() == 0){
            return;
        }
        counter += delta;
        for (int i = 0; i < turns.size();i++){
            MonsterSlot turn = turns.get(i);
            turn.update(delta);
            if(turn.isDead){
                if(current >= i){
                    current--;
                }
                turns.remove(i);
                i--;
            }
        }

        if(counter > 1){
            counter = 0;
            MonsterSlot currentSlot = turns.get(current);
            if(currentSlot.mine){
                currentSlot.monster.attack(delta, enemyTable, enemySet);
            }else{
                currentSlot.monster.attack(delta, playerTable, playerSet);
            }

            current++;
            if(current >= turns.size()){
                current = 0;
            }
        }
    }



}
