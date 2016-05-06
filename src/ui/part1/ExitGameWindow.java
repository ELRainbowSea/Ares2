package ui.part1;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * 退出游戏窗口
 * 按退出按钮退出游戏
 * 按取消按钮回到开始界面
 * @author wyj
 *
 */

@SuppressWarnings("serial")
public class ExitGameWindow extends JFrame{

	public ExitGameWindow(){
		JFrame frame=new JFrame("退出");
		//取消窗体边框
		frame.setUndecorated(true);
		
		int w=getToolkit().getScreenSize().width;
		int h=getToolkit().getScreenSize().height;
		frame.setBounds((w-400)/2, (h-200)/2, 400, 200);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton exitjb=new JButton("退出");
		JButton canceljb=new JButton("取消");
		JLabel label=new JLabel("是否退出游戏？");
		exitjb.setFont(new Font("黑体", 1, 17));
		canceljb.setFont(new Font("黑体", 1, 17));
		label.setFont(new Font("黑体", 1, 17));
		Container cp=frame.getContentPane();
		cp.setLayout(null);
		
		label.setBounds(150, 45, 300, 40);
		exitjb.setBounds(100, 95, 70, 50);
		canceljb.setBounds(230, 95, 70, 50);
		exitjb.setBorderPainted(false);
		canceljb.setBorderPainted(false);
		exitjb.setContentAreaFilled(false);
		canceljb.setContentAreaFilled(false);
		
		frame.add(label);
		frame.add(exitjb);
		frame.add(canceljb);
		
		
		//退出按钮监听事件
		exitjb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitjb.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				exitjb.setBorderPainted(true);
			}
			public void mouseExited(MouseEvent e){
				exitjb.setBorderPainted(false);
			}
		});
		
		
		//取消退出按钮监听事件
		canceljb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		canceljb.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e){
				canceljb.setBorderPainted(true);
			}
			public void mouseExited(MouseEvent e){
				canceljb.setBorderPainted(false);
			}
		});
	}
}
