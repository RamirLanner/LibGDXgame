package ru.pentragon.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyAnimation {
    private Animation<TextureRegion> animation;
    private float time;
    private Texture texture;
    private int fps,columns,lines;
    private Animation.PlayMode playMode;
    private String path;

    public MyAnimation(String path, int columns, int lines, int fps, Animation.PlayMode playMode) {
        this.fps = fps;
        this.playMode = playMode;
        this.path = path;
        this.columns = columns;
        this.lines = lines;
        this.create();
    }

    private void create(){
        texture = new Texture(path);
        TextureRegion[][] tmpRegion = new
                TextureRegion(texture).
                split(texture.getWidth() / columns, texture.getHeight() / lines);
        TextureRegion[] regions = new TextureRegion[tmpRegion.length * tmpRegion[0].length];
        int cnt = 0;
        for (TextureRegion[] textureRegions : tmpRegion) {
            for (int j = 0; j < tmpRegion[0].length; j++) {
                regions[cnt++] = textureRegions[j];
            }
        }
        time = 0;
        animation = new Animation<>(1.0f / fps, regions);
        animation.setPlayMode(playMode);
    }

    public TextureRegion getRegion() {return animation.getKeyFrame(time);}
    public void setTime(float dTime){time+=dTime;}
    public boolean isFinished(){return animation.isAnimationFinished(time);}
    public void resetTime(){time=0;}
    public void dispose(){texture.dispose();}
}
