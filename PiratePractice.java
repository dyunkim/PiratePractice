package com.david.piratepractice;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by David on 12/16/2015.
 */
public class PiratePractice extends Game {
    public int SCREEN_WIDTH;
    public int SCREEN_HEIGHT;
    public SpriteBatch batch;
    public BitmapFont font;
    public final String gameName = "Pirate Practice";

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        SCREEN_WIDTH = Gdx.graphics.getWidth();
        SCREEN_HEIGHT = Gdx.graphics.getHeight();
        this.setScreen(new MainMenuScreen(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }

}
