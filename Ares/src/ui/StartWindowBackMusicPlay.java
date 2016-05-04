package ui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * 开始游戏界面背景音乐播放
 * @author wyj
 *
 */
public class StartWindowBackMusicPlay extends Thread{

	public void run() {
		while(true){
			//装入声音
			BackMusic sound=new BackMusic("graphics/music/Breath and Life.wav");
			//生成要播放的流
			InputStream stream=new ByteArrayInputStream(sound.getSamples());
			//播放声音
			sound.play(stream);
		}
	}
}
