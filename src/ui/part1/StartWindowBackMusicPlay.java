package ui.part1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * ��ʼ��Ϸ���汳�����ֲ���
 * @author wyj
 *
 */
public class StartWindowBackMusicPlay extends Thread{

	public void run() {
		while(true){
			//װ������
			BackMusic sound=new BackMusic("Ares/graphics/music/Breath and Life.wav");
			//����Ҫ���ŵ���
			InputStream stream=new ByteArrayInputStream(sound.getSamples());
			//��������
			sound.play(stream);
		}
	}
}