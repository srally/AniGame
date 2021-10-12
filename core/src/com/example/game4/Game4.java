package com.example.game4;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Game4 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture pc;
	Sprite sprite;
	float x, y, dx, dy, wid, hei;
	
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
	}

	@Override
	public void render () {
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
		batch.draw(img, x, y);
		batch.draw(sprite, 1400, 500);
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
