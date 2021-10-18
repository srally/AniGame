package com.example.game4;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class Game4 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img, pc;
	TextureRegion[] frames;
	Sprite sprite;
	Animation<TextureRegion> animation;
	float x, y, dx, dy, wid, hei, et;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("bu.png");
		pc = new Texture("bc.jfif");
		sprite = new Sprite(pc);
		x = 2;
		y = 2;
		dx = 12;
		dy = 13;
		TextureRegion[][] tmp = TextureRegion.split(img,90,90);
		frames = new TextureRegion[4];
		int in = 0;
		for(int i=0; i<2; i++){
			for(int j=0; j<2; j++){
				frames[in++] = tmp[j][i];
			}
		}
		animation = new Animation(1f/4f, frames);
	}

	@Override
	public void render () {
		et += Gdx.graphics.getDeltaTime();
		ScreenUtils.clear(0, 1, 1, 1);
		x+=dx;
		y+=dy;
		if(x>wid||x<0){
			dx = -dx;
		}
		if(y>hei||y<0){
			dy = -dy;
		}
		batch.begin();
		batch.draw(sprite, 1400, 500);
		batch.draw(animation.getKeyFrame(et, true), x, y);
		batch.end();
	}

	@Override
	public void resize(int w, int h){
		wid = w;
		hei = h;
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
