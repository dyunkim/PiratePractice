package com.david.piratepractice;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.david.piratepractice.Scenes.Hud;

/**
 * Created by David on 12/17/2015.
 */
public class WorldScreen implements Screen, GestureDetector.GestureListener {

    private OrthographicCamera camera;
    private PiratePractice game;
    private Sprite map;
    private Hud hud;
    private Stage stage;
    private Table table;

    public WorldScreen(PiratePractice game) {
        this.game = game;
        hud = new Hud(game);

        stage = new Stage(new FitViewport(game.V_WIDTH, game.V_HEIGHT-Hud.hudHeight, new OrthographicCamera()));
        table = new Table();
        table.setDebug(true);
        table.setFillParent(true);
        table.top();
        table.setBackground(game.skin.getDrawable("world_map"));

        stage.addActor(table);
    }
    @Override
    public void dispose() {
        hud.dispose();
        stage.dispose();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, .4745f, .749f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        game.batch.setProjectionMatrix(hud.stage.getCamera().combined);

        stage.draw();
        hud.stage.draw();

    }
    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {

        return true;
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
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }



    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

}
