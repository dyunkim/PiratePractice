package com.david.piratepractice.Scenes;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
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
    public static float hudHeight;
    public static float hudWidth;

    public Label woodLabel;
    public Label goldLabel;
    public Label metalLabel;
    public Label stoneLabel;

    private int wood;
    private int gold;
    private int metal;
    private int stone;

    public Hud(PiratePractice game) {

        wood = 5;
        gold = 5;
        metal = 5;
        stone = 5;


        viewport = new FitViewport(PiratePractice.V_WIDTH, PiratePractice.V_HEIGHT, new OrthographicCamera());
        stage = new Stage(viewport, game.batch);


        Table table = new Table();
//        table.setDebug(true);
        table.bottom();
        table.setFillParent(true);

        TextButton mapButton = new TextButton("World Map", game.skin, "game screen button");
        TextButton shipsButton = new TextButton("Ships", game.skin, "game screen button");
        TextButton territoriesButton = new TextButton("Territories", game.skin, "game screen button");
        TextButton optionsButton = new TextButton("Options", game.skin, "game screen button");

        Table resourceTable = new Table();
        resourceTable.setBackground(game.skin.getDrawable("resource background"));
//        resourceTable.setDebug(true);

        woodLabel = new Label("Wood: " + wood, game.skin, "resource");
        goldLabel = new Label("Gold: " + gold, game.skin, "resource");
        metalLabel = new Label("Metal: " + metal, game.skin, "resource");
        stoneLabel = new Label("Stone: " + stone, game.skin, "resource");

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

        hudHeight = table.getHeight();
        hudWidth = table.getWidth();
    }

    public void dispose() {
        stage.dispose();
        
    }


}
