package hieubap.beast.warrier.monster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import hieubap.beast.warrier.common.BaseAttribute;
import hieubap.beast.warrier.group.MonsterSlot;
import hieubap.beast.warrier.item.skin.BaseSkin;
import hieubap.beast.warrier.utils.Constants;

public abstract class Monster {
    public BaseAttribute attribute = new BaseAttribute();
    public List<BaseSkin> skins = new ArrayList<>();
    public Texture texture;

    public int positionX = 0;
    public int positionY = 0;
    public int sizeX = 0;
    public int sizeY = 0;

    public MonsterSlot monsterSlot;

    public Monster() {
        attribute.attack = Constants.MONSTER_ATK;
        attribute.health = Constants.MONSTER_HP;
        attribute.defend = Constants.MONSTER_DEF;

        texture = new Texture(Gdx.files.internal("monster1.png"));
        setupWeapon();
        for (BaseSkin skin : this.skins){
            attribute.attack += skin.attack;
            attribute.health += skin.health;
            attribute.defend += skin.defend;
            attribute.mana += skin.mana;
            attribute.speed += skin.speed;
            attribute.percentAttack += skin.percentAttack;
            attribute.percentDefend += skin.percentDefend;
            attribute.percentHealth += skin.percentHealth;
        }

        attribute.attack += attribute.attack * attribute.percentAttack;
        attribute.defend += attribute.defend * attribute.percentDefend;
        attribute.health += attribute.health * attribute.percentHealth;
    }

    public void setBound(int posX,int posY,int sizeX,int sizeY){
        this.positionX = posX;
        this.positionY = posY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
    }

    public abstract void setupWeapon();
    public void skill(){};

    public void attack(float delta, List<MonsterSlot> list, Set<Integer> posSet){
        if(false&&this.attribute.mana >= 100){
            skill();
        }else{
            int[] targetPriority = getTargetPriority(monsterSlot.position);
            for(int i = 0;i<9;i++){
                if(posSet.contains(targetPriority[i])){
                    for (MonsterSlot slot : list){
                        if(slot.position == targetPriority[i]){
                            slot.monster.attribute.health -= attribute.attack;
                            break;
                        }
                    }
                    break;
                }
            }

            this.attribute.mana += 30;
        }
    }

    public void update(float delta){

    }

    public void draw(SpriteBatch batch){
        batch.draw(texture,
                positionX,positionY,
                sizeX,sizeY);
    }

    private int[] getTargetPriority(int position){
        if(position < 3){
            return new int[]{0,1,2,3,4,5,6,7,8};
        }
        if(position < 6){
            return new int[]{3,4,5,6,7,8,0,1,2};
        }
        return new int[]{6,7,8,3,4,5,0,1,2};
    }

}
