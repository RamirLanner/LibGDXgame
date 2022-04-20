package ru.pentragon.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Arrays;

public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    MyAnimation shuttle;

    @Override
    public void create() {
        batch = new SpriteBatch();
        shuttle = new MyAnimation("shuttle_sprite.png", 6,6,10, Animation.PlayMode.NORMAL);

    }

    @Override
    public void render() {
        ScreenUtils.clear(1, 0, 0, 1);
        batch.begin();
        shuttle.setTime(Gdx.graphics.getDeltaTime());
        batch.draw(shuttle.getRegion(), Gdx.graphics.getWidth() / 2, (int)Gdx.graphics.getHeight() / 2);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        shuttle.dispose();
    }
}
