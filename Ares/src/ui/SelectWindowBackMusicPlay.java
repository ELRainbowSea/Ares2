package ui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/**
 * ѡ����Ϸ���汳�����ֲ���
 * @author wyj
 *
 */
public class SelectWindowBackMusicPlay extends Thread{

	public void run() {
		while(true){
			//װ������
			BackMusic sound=new BackMusic("music/Nostalgia.wav");
			//����Ҫ���ŵ���
			InputStream stream=new ByteArrayInputStream(sound.getSamples());
			//��������
			sound.play(stream);
		}
	}
}
