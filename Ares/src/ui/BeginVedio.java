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
 * 开场动画
 * @author wyj
 *
 */
@SuppressWarnings("serial")
public class BeginVedio extends JFrame{

	// 播放器对象 
	private Player player;
	// 视频显示组件   
	private Component visualMedia;
	// 视频播放控制组件   
	private Component mediaControl;
	// 主容器   
	private Container container;
	//媒体文件   
	private File mediaFile;
	//媒体文件URL地址   
	private URL fileURL;
	
	@SuppressWarnings("deprecation")
	public BeginVedio(){
		
		//调用父类构造函数   
		super("视频播放程序");
		
		int w=getToolkit().getScreenSize().width;
		int h=getToolkit().getScreenSize().height;
		setLocation((w-1280)/2, (h-720)/2);
		setUndecorated(true);
		setVisible(true); //设置窗口为可视   
		
		//得到窗口容器   
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
		MediaLocator mediaLocator = new MediaLocator(mediaLocation); //媒体定位器
		player = Manager.createPlayer(mediaLocator); //得到播放器实例   
		player.addControllerListener(new PlayerEventHandler()); //增加播放控制器   
		player.realize(); 
	}
	
	//取得媒体组件   
	public void getMediaComponents() {
		visualMedia = player.getVisualComponent(); //取得视频显示组件   
		//如果对象visualMedia非空则加入到窗口内容窗格   
		if (visualMedia != null) {
			container.add(visualMedia, BorderLayout.CENTER);
			pack();
		}
		
		mediaControl = player.getControlPanelComponent(); //取得播放控制组件  
		//如果对象visualMedia非空则加入到窗口内容窗格
		if (mediaControl != null)
			container.add(mediaControl, BorderLayout.SOUTH);
	}
	
	
	//播放器事件处理   
	private class PlayerEventHandler extends ControllerAdapter {
		
		public void realizeComplete(RealizeCompleteEvent realizeDoneEvent) {
			player.prefetch(); //预取媒体数据  
		}
		
		//完成预取媒体数据后，开始播放媒体
		public void prefetchComplete(PrefetchCompleteEvent prefetchDoneEvent) {
			getMediaComponents();
			
			//此方法是显示视频下方的进度条
			//validate();
			
			player.start(); //开始播放媒体
		}
		
		//如果媒体播放完毕，重新设置媒体时间并停止媒体播放器
		public void endOfMedia(EndOfMediaEvent mediaEndEvent) {
			dispose();
			new StartGameWindow();
		}
	}   
}
