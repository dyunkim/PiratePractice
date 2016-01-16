package com.david.piratepractice;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created by David on 12/16/2015.
 */
public class PiratePractice extends Game {
    public int SCREEN_WIDTH;
    public int SCREEN_HEIGHT;
    public static int V_WIDTH = 576;
    public static int V_HEIGHT = 1024;
    public SpriteBatch batch;
    public BitmapFont font;
    public Skin skin;
    public final String gameName = "Pirate Practice";

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        SCREEN_WIDTH = Gdx.graphics.getWidth();
        SCREEN_HEIGHT = Gdx.graphics.getHeight();
        skin = new Skin(Gdx.files.internal("skins/GlobalSkin/uiskin.json"));
        this.setScreen(new MainMenuScreen(this));       //TODO: UPDATE WHEN DONE TESTING
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
        skin.dispose();
    }


}
