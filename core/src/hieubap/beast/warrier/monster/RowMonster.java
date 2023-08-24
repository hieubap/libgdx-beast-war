package hieubap.beast.warrier.monster;

import hieubap.beast.warrier.item.skin.WhiteShoe;
import hieubap.beast.warrier.item.skin.WhiteSword;

public class RowMonster extends Monster {
    @Override
    public void setupWeapon() {
        this.skins.add(new WhiteShoe());
        this.skins.add(new WhiteSword());
    }
}
