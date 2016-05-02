package ui;

import javax.swing.JFrame;

/**
 * 选择游戏界面：联机or剧情
 * @author wyj
 *
 */
@SuppressWarnings("serial")
public class SelectGameWindow extends JFrame{

	public SelectGameWindow(){
		Thread selectWindowMusic=new SelectWindowBackMusicPlay();
		selectWindowMusic.start();
		
		JFrame frame=new JFrame("开始游戏中的选择界面");
		//取消窗体边框
		frame.setUndecorated(true);
		int w=getToolkit().getScreenSize().width;
		int h=getToolkit().getScreenSize().height;
		frame.setBounds((w-1000)/2, (h-700)/2, 1000, 700);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}

