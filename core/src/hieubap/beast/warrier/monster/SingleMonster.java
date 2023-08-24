package hieubap.beast.warrier.monster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import hieubap.beast.warrier.item.skin.WhiteHat;
import hieubap.beast.warrier.item.skin.WhiteJacket;
import hieubap.beast.warrier.item.skin.WhiteRing;
import hieubap.beast.warrier.item.skin.WhiteSword;
import hieubap.beast.warrier.item.skin.WhiteTrouser;

public class SingleMonster extends Monster {
    @Override
    public void setupWeapon() {
        this.skins.add(new WhiteRing());
        this.skins.add(new WhiteSword());
    }
}
