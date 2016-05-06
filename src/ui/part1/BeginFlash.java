package ui.part1;


import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


@SuppressWarnings("serial")
public class BeginFlash extends JFrame{

	public BeginFlash(){
		
		
		
		ImageIcon image=new ImageIcon("d:/media/begin.avi");
		JLabel label=new aLabel(image.getImage());
		
//		JLabel label=new JLabel(image);
		
//		getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
//		Container cp=getContentPane();
//		
//		((JPanel)cp).setOpaque(false);
		
		add(label);
		
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 500);
		
		
		
		int w=getToolkit().getScreenSize().width;
		int h=getToolkit().getScreenSize().height;
		
		setSize(600, 500);
		setLocation((w-600)/2, (h-500)/2);
		label.setSize(600, 500);
		
	}
	
	private class aLabel extends JLabel{
		
		private Image image;
		
		public aLabel(Image image){
			this.image=image;
		}
		
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			int w=600;
			int h=500;
			
			g.drawImage(image, 0, 0, w, h, null);
		}
	}
}
