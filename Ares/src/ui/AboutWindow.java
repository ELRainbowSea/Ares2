package ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;


/**
 * �������� ����
 * ��͸��
 * ʵ������������˳������巵�ؿ�ʼ����
 * @author wyj
 *
 */
@SuppressWarnings("serial")
public class AboutWindow extends JDialog{

	public AboutWindow(StartGameWindow sgw){
		
		super(sgw, true);
		
		setLayout(new GridLayout());
		//ȥ���߿�����
		setUndecorated(true);
		
//		final JLabel label=new JLabel();
//		label.setSize(900, 700);
//		label.setBackground(Color.BLUE);
//		add(label);
//		getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		
		
		//����Ҫ��ʾ����������ͼƬ��ʽ����button��
		ImageIcon image=new ImageIcon("graphics/aboutUs.png");
		JButton button=new JButton(image);
		button.setSize(getWidth(), getHeight());
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		Container cp=getContentPane();
		cp.setLayout(new GridLayout());
		cp.add(button);
		((JPanel)cp).setOpaque(false);
		//����Ϊ��͸����ɫ
		setBackground(Color.DARK_GRAY);
		setOpacity(0.85f);
		
		
		setLocationRelativeTo(null);
		int w=getToolkit().getScreenSize().width;
		int h=getToolkit().getScreenSize().height;
		setBounds((w-650)/2, (h-350)/2, 650, 350);
		setVisible(true);
		
	}
	
}
