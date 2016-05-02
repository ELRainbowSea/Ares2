package ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * ��ʼ��Ϸ����
 * �ĸ���ť����ʼ��Ϸ���������������ǡ��˳���Ϸ
 * �ĸ���ť���ü����¼�
 * @author wyj
 *
 */
@SuppressWarnings("serial")
public class StartGameWindow extends JFrame{
	
	
	public StartGameWindow(){
		
		Thread startWindowMusic=new StartWindowBackMusicPlay();
		startWindowMusic.start();
		
		
		JFrame frame=new JFrame("��ʼ��Ϸ����");
		//ȡ������߿�
		frame.setUndecorated(true);
		
		
		//����ͼƬ����
		ImageIcon backPic=new ImageIcon("graphics/bg01.jpg");
		JLabel backPicLabel=new JLabel(backPic);
		frame.getLayeredPane().add(backPicLabel,new Integer(Integer.MIN_VALUE));
		backPicLabel.setBounds(0, 0, backPic.getIconWidth(), backPic.getIconHeight());
		Container cp=frame.getContentPane();
		cp.setLayout(null);
		
		//��ť����
		ImageIcon startPic=new ImageIcon("graphics/start.png");
		ImageIcon helpPic=new ImageIcon("graphics/help.png");
		ImageIcon aboutPic=new ImageIcon("graphics/about.png");
		ImageIcon exitPic=new ImageIcon("graphics/exit.png");
		JButton startjb=new JButton(startPic);
		JButton helpjb=new JButton(helpPic);
		JButton aboutjb=new JButton(aboutPic);
		JButton exitjb=new JButton(exitPic);
		startjb.setBounds((backPic.getIconWidth()-startPic.getIconWidth())/2, 90, startPic.getIconWidth(), startPic.getIconHeight()-50);
		helpjb.setBounds((backPic.getIconWidth()-helpPic.getIconWidth())/2, 160, helpPic.getIconWidth(), helpPic.getIconHeight()-50);
		aboutjb.setBounds((backPic.getIconWidth()-aboutPic.getIconWidth())/2, 230, aboutPic.getIconWidth(), aboutPic.getIconHeight()-50);
		exitjb.setBounds((backPic.getIconWidth()-exitPic.getIconWidth())/2, 300, exitPic.getIconWidth(), exitPic.getIconHeight()-50);
		//���ð�ť����͸��
		startjb.setContentAreaFilled(false);
		helpjb.setContentAreaFilled(false);
		aboutjb.setContentAreaFilled(false);
		exitjb.setContentAreaFilled(false);
		//���ð�ť�ޱ߿�
		startjb.setBorderPainted(false);
		helpjb.setBorderPainted(false);
		aboutjb.setBorderPainted(false);
		exitjb.setBorderPainted(false);
		cp.add(startjb);
		cp.add(aboutjb);
		cp.add(helpjb);
		cp.add(exitjb);
		//����͸�����������ɼ�
		((JPanel)cp).setOpaque(false);
		int w=getToolkit().getScreenSize().width;
		int h=getToolkit().getScreenSize().height;
		frame.setBounds((w-backPic.getIconWidth())/2, (h-backPic.getIconHeight())/2, backPic.getIconWidth(), backPic.getIconHeight());
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		
		//��ʼ��ť�����¼�
		startjb.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				startWindowMusic.stop();
				new SelectGameWindow();
			}
		});
		new MoveRemoveEvent(startjb);
		
		
		//������ť�����¼�
		helpjb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				new HelpWindow(StartGameWindow.this);
			}
		});
		new MoveRemoveEvent(helpjb);
		
		
		//�������ǰ�ť�����¼�
		aboutjb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				new AboutWindow(StartGameWindow.this);
			}
		});
		new MoveRemoveEvent(aboutjb);
		
		
		//�˳���Ϸ��ť�����¼�
		exitjb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) { 
				new ExitGameWindow();
			}
		});
		new MoveRemoveEvent(exitjb);
		
	}
}
