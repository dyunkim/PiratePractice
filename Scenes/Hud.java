package com.david.piratepractice.Scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.david.piratepractice.PiratePractice;

/**
 * Created by David on 1/6/2016.
 */
public class Hud {
    public Stage stage;
    public Viewport viewport;
    private Skin skin;

    public Label woodLabel;
    public Label goldLabel;
    public Label metalLabel;
    public Label stoneLabel;

    private int wood;
    private int gold;
    private int metal;
    private int stone;

    public Hud(SpriteBatch batch) {

        wood = 5;
        gold = 5;
        metal = 5;
        stone = 5;

        viewport = new FitViewport(PiratePractice.V_WIDTH, PiratePractice.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, batch);
        skin = new Skin(Gdx.files.internal("skins/GameSkin/uiskin.json"));


        Table table = new Table();
//        table.setDebug(true);
        table.bottom();
        table.setFillParent(true);

        TextButton mapButton = new TextButton("World Map", skin, "game button");
        TextButton shipsButton = new TextButton("Ships", skin, "game button");
        TextButton territoriesButton = new TextButton("Territories", skin, "game button");
        TextButton optionsButton = new TextButton("Options", skin, "game button");

        Table resourceTable = new Table();
        resourceTable.setBackground(skin.getDrawable("actual resource background"));
//        resourceTable.setDebug(true);

        woodLabel = new Label("Wood: " + wood, skin, "resource");
        goldLabel = new Label("Gold: " + gold, skin, "resource");
        metalLabel = new Label("Metal: " + metal, skin, "resource");
        stoneLabel = new Label("Stone: " + stone, skin, "resource");

        resourceTable.add(goldLabel).expandX().padTop(5);
        resourceTable.add(woodLabel).expandX().padTop(5);
        resourceTable.row();
        resourceTable.add(stoneLabel).expandX().padBottom(5);
        resourceTable.add(metalLabel).expandX().padBottom(5);

        table.add(resourceTable).colspan(2).fillX();
        table.row();
        table.row();

        table.add(mapButton).pad(48, 37, 48, 29);     //pad(top, left, bottom, right)
        table.add(territoriesButton).pad(0, 29, 0, 37);
        table.row();
        table.add(shipsButton).pad(0, 37, 73, 29);
        table.add(optionsButton).pad(0, 29, 0, 37).top();

        stage.addActor(table);
    }

    public void dispose() {
        skin.dispose();
    }


}
