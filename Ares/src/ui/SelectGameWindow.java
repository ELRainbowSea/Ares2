package ui;

import javax.swing.JFrame;

/**
 * ѡ����Ϸ���棺����or����
 * @author wyj
 *
 */
@SuppressWarnings("serial")
public class SelectGameWindow extends JFrame{

	public SelectGameWindow(){
		Thread selectWindowMusic=new SelectWindowBackMusicPlay();
		selectWindowMusic.start();
		
		JFrame frame=new JFrame("��ʼ��Ϸ�е�ѡ�����");
		//ȡ������߿�
		frame.setUndecorated(true);
		int w=getToolkit().getScreenSize().width;
		int h=getToolkit().getScreenSize().height;
		frame.setBounds((w-1000)/2, (h-700)/2, 1000, 700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}

