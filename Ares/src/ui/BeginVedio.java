package ui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.media.ControllerAdapter;
import javax.media.EndOfMediaEvent;
import javax.media.Manager;
import javax.media.MediaLocator;
import javax.media.NoPlayerException;
import javax.media.Player;
import javax.media.PrefetchCompleteEvent;
import javax.media.RealizeCompleteEvent;
import javax.swing.JFrame;

/**
 * ��������
 * @author wyj
 *
 */
@SuppressWarnings("serial")
public class BeginVedio extends JFrame{

	// ���������� 
	private Player player;
	// ��Ƶ��ʾ���   
	private Component visualMedia;
	// ��Ƶ���ſ������   
	private Component mediaControl;
	// ������   
	private Container container;
	//ý���ļ�   
	private File mediaFile;
	//ý���ļ�URL��ַ   
	private URL fileURL;
	
	@SuppressWarnings("deprecation")
	public BeginVedio(){
		
		//���ø��๹�캯��   
		super("��Ƶ���ų���");
		
		int w=getToolkit().getScreenSize().width;
		int h=getToolkit().getScreenSize().height;
		setLocation((w-1280)/2, (h-720)/2);
		setUndecorated(true);
		setVisible(true); //���ô���Ϊ����   
		
		//�õ���������   
		container = getContentPane();
		
		mediaFile=new File("graphics/media/Begin.avi");
		try {
			fileURL=mediaFile.toURL();
			startPlayer(fileURL.toString());
		} catch (Exception e) {
			System.err.println(e);
		}
	}
	
	public void startPlayer(String mediaLocation) throws NoPlayerException, IOException {
		MediaLocator mediaLocator = new MediaLocator(mediaLocation); //ý�嶨λ��
		player = Manager.createPlayer(mediaLocator); //�õ�������ʵ��   
		player.addControllerListener(new PlayerEventHandler()); //���Ӳ��ſ�����   
		player.realize(); 
	}
	
	//ȡ��ý�����   
	public void getMediaComponents() {
		visualMedia = player.getVisualComponent(); //ȡ����Ƶ��ʾ���   
		//�������visualMedia�ǿ�����뵽�������ݴ���   
		if (visualMedia != null) {
			container.add(visualMedia, BorderLayout.CENTER);
			pack();
		}
		
		mediaControl = player.getControlPanelComponent(); //ȡ�ò��ſ������  
		//�������visualMedia�ǿ�����뵽�������ݴ���
		if (mediaControl != null)
			container.add(mediaControl, BorderLayout.SOUTH);
	}
	
	
	//�������¼�����   
	private class PlayerEventHandler extends ControllerAdapter {
		
		public void realizeComplete(RealizeCompleteEvent realizeDoneEvent) {
			player.prefetch(); //Ԥȡý������  
		}
		
		//���Ԥȡý�����ݺ󣬿�ʼ����ý��
		public void prefetchComplete(PrefetchCompleteEvent prefetchDoneEvent) {
			getMediaComponents();
			
			//�˷�������ʾ��Ƶ�·��Ľ�����
			//validate();
			
			player.start(); //��ʼ����ý��
		}
		
		//���ý�岥����ϣ���������ý��ʱ�䲢ֹͣý�岥����
		public void endOfMedia(EndOfMediaEvent mediaEndEvent) {
			dispose();
			new StartGameWindow();
		}
	}   
}
