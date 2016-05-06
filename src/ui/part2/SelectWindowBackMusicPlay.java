package ui.part2;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import ui.part1.BackMusic;

/**
 * 选择游戏界面背景音乐播放
 * @author wyj
 *
 */
public class SelectWindowBackMusicPlay extends Thread{

	public void run() {
		while(true){
			//装入声音
			BackMusic sound=new BackMusic("Ares/graphics/music/Nostalgia.wav");
			//生成要播放的流
			InputStream stream=new ByteArrayInputStream(sound.getSamples());
			//播放声音
			sound.play(stream);
		}
	}
}
