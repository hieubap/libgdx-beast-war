package hieubap.beast.warrier.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import hieubap.beast.warrier.group.TableBattle;
import hieubap.beast.warrier.monster.Monster;
import hieubap.beast.warrier.monster.SingleMonster;
import hieubap.beast.warrier.monster.TankMonster;

public class PlayScreen implements Screen {
    GlyphLayout layout;

    BitmapFont bitmapFont;
    SpriteBatch batch;
    Monster monster;
    Monster monster2;
    TableBattle tableBattle;

    @Override
    public void show() {
        batch = new SpriteBatch();
        bitmapFont = new BitmapFont(Gdx.files.internal("fonts/font.fnt"));
        bitmapFont.getData().setScale(1.5f);
        monster = new SingleMonster();
        monster2 = new TankMonster();

        String str = "HP: " + monster.attribute.health
                + " DEF: " + monster.attribute.health
                + " ATK: " + monster.attribute.attack
                + " MANA: " + monster.attribute.mana
                + " PER_ATK: " + monster.attribute.percentAttack
                + "% PER_HP: " + monster.attribute.percentHealth
                + "% PER_DEF: " + monster.attribute.percentDefend
                + "\nHP: " + monster2.attribute.health
                + " DEF: " + monster2.attribute.health
                + " ATK: " + monster2.attribute.attack
                + " MANA: " + monster2.attribute.mana
                + " PER_ATK: " + monster2.attribute.percentAttack
                + "% PER_HP: " + monster2.attribute.percentHealth
                + "% PER_DEF: " + monster2.attribute.percentDefend;


        layout = new GlyphLayout();
        layout.setText(bitmapFont,str);

        tableBattle = new TableBattle();
        tableBattle.addMonster(true, new SingleMonster(), 1);
        tableBattle.addMonster(true, new SingleMonster(), 3);

        tableBattle.addMonster(false, new SingleMonster(), 8);
        tableBattle.addMonster(false, new TankMonster(), 4);
        tableBattle.addMonster(false, new TankMonster(), 5);

        tableBattle.addMonster(true, new TankMonster(), 4);
        tableBattle.addMonster(true, new SingleMonster(), 6);
        tableBattle.addMonster(true, new SingleMonster(), 7);

        tableBattle.addMonster(false, new SingleMonster(), 6);
        tableBattle.addMonster(false, new SingleMonster(), 7);
    }

    public void update(float delta){
        tableBattle.update(delta);
    }

    @Override
    public void render(float delta) {
        Gdx.gl20.glClearColor(0, 0, 0, 1);
        Gdx.gl20.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update(delta);


        batch.begin();
        bitmapFont.draw(batch, layout,100,1100);
        tableBattle.draw(batch);
        batch.end();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
