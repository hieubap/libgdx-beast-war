package hieubap.beast.warrier.monster;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

import hieubap.beast.warrier.item.skin.WhiteHat;
import hieubap.beast.warrier.item.skin.WhiteJacket;
import hieubap.beast.warrier.item.skin.WhiteTrouser;

public class TankMonster extends Monster{
    @Override
    public void setupWeapon() {
        texture = new Texture(Gdx.files.internal("monster2.png"));
        this.skins.add(new WhiteJacket());
        this.skins.add(new WhiteTrouser());
    }
}
