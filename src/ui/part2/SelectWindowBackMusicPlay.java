package ui.part2;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import ui.part1.BackMusic;

/**
 * ѡ����Ϸ���汳�����ֲ���
 * @author wyj
 *
 */
public class SelectWindowBackMusicPlay extends Thread{

	public void run() {
		while(true){
			//װ������
			BackMusic sound=new BackMusic("Ares/graphics/music/Nostalgia.wav");
			//����Ҫ���ŵ���
			InputStream stream=new ByteArrayInputStream(sound.getSamples());
			//��������
			sound.play(stream);
		}
	}
}
