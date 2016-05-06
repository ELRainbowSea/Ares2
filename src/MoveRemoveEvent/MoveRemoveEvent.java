package MoveRemoveEvent;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

/**
 * ����ƶ��¼�
 * ������ʾЧ��
 * �Ƴ�ȡ��Ч��
 * @author wyj
 *
 */
public class MoveRemoveEvent {

	public MoveRemoveEvent(JButton jb){
		jb.addMouseListener(new MouseAdapter() {
			//���������ť����ť��ʾ�߿��ƿ���ť���߿���ʧ
			public void mouseEntered(MouseEvent e){
				jb.setBorderPainted(true);
			}
			public void mouseExited(MouseEvent e){
				jb.setBorderPainted(false);
			}
		});
	}
}
