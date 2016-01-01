package com.david.piratepractice;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;


/**
 * Created by David on 12/17/2015.
 */
public class MainMenuScreen implements Screen{

    Skin skin;
    Stage stage;
    SpriteBatch batch;
    PiratePractice game;

    public MainMenuScreen(PiratePractice game) {
        this.game = game;
        skinCreate();
        create();
    }

    public void create () {
        batch = new SpriteBatch();
        stage = new Stage(new FitViewport(576, 1024));
        Gdx.input.setInputProcessor(stage);

        Table table = new Table();
        table.setDebug(true);
        table.setFillParent(true);
        table.top();
        stage.addActor(table);

        Image menuImage = new Image(skin, "title");
        table.add(menuImage).padTop(115).padBottom(96);

        table.row();

        Table buttonTable = new Table(skin);
        buttonTable.setBackground("button box");
        buttonTable.setDebug(true);
        table.add(buttonTable);

        TextButton playButton = new TextButton("PLAY", skin, "Button");
        playButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Play");
                return false;
            }
        });
        TextButton newButton = new TextButton("NEW GAME", skin, "Button");
        newButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("New Game");
                return false;
            }
        });
        TextButton settingsButton = new TextButton("SETTINGS", skin, "Button");
        settingsButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Settings");
                return false;
            }
        });
        TextButton exitButton = new TextButton("EXIT", skin, "Button");
        exitButton.addListener(new InputListener() {
            @Override
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                System.out.println("Exit");
                return false;
            }
        });

        buttonTable.top();
        buttonTable.add(playButton).padTop(64);
        buttonTable.row();
        buttonTable.add(newButton).padTop(64);
        buttonTable.row();
        buttonTable.add(settingsButton).padTop(64);
        buttonTable.row();
        buttonTable.add(exitButton).padTop(64).padBottom(64);

    }

    public void show() {}
    @Override
    public void render (float delta) {
        Gdx.gl.glClearColor(0, .4745f, .749f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize (int width, int height) {
        stage.getViewport().update(width, height, true);
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
    public void dispose () {
        stage.dispose();
        skin.dispose();
    }

    private void skinCreate() {
        skin = new Skin(Gdx.files.internal("skins/MenuSkin/uiskin.json"));
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("skins/MenuSkin/tomshandwritten.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 35;
        BitmapFont menuFont = generator.generateFont(parameter); // font size 12 pixels
        skin.add("font", menuFont);
        skin.get("Button", TextButton.TextButtonStyle.class).font = menuFont;

        generator.dispose();
    }

}
