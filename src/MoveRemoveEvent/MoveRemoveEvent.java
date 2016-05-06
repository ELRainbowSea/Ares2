package MoveRemoveEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

/**
 * 鼠标移动事件
 * 移入显示效果
 * 移出取消效果
 * @author wyj
 *
 */
public class MoveRemoveEvent {

	public MoveRemoveEvent(JButton jb){
		jb.addMouseListener(new MouseAdapter() {
			//鼠标移至按钮，按钮显示边框，移开按钮，边框消失
			public void mouseEntered(MouseEvent e){
				jb.setBorderPainted(true);
			}
			public void mouseExited(MouseEvent e){
				jb.setBorderPainted(false);
			}
		});
	}
}
