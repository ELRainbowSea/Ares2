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
 * 关于我们 界面
 * 半透明
 * 实现鼠标点击即可退出本窗体返回开始窗体
 * @author wyj
 *
 */
@SuppressWarnings("serial")
public class AboutWindow extends JDialog{

	public AboutWindow(StartGameWindow sgw){
		
		super(sgw, true);
		
		setLayout(new GridLayout());
		//去除边框设置
		setUndecorated(true);
		
//		final JLabel label=new JLabel();
//		label.setSize(900, 700);
//		label.setBackground(Color.BLUE);
//		add(label);
//		getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		
		
		//将需要显示的内容做成图片格式放在button上
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
		//背景为半透明灰色
		setBackground(Color.DARK_GRAY);
		setOpacity(0.85f);
		
		
		setLocationRelativeTo(null);
		int w=getToolkit().getScreenSize().width;
		int h=getToolkit().getScreenSize().height;
		setBounds((w-650)/2, (h-350)/2, 650, 350);
		setVisible(true);
		
	}
	
}
