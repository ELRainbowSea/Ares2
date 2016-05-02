package ui;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * 背景音乐格式转换
 * @author wyj
 *
 */
public class BackMusic {

	private AudioFormat format;
	private byte[] samples;
	
	/**
	 * 从文件打开声音
	 * @param filename
	 */
	public BackMusic(String filename) {

		try {
			//打开声频输入流
			AudioInputStream stream=AudioSystem.getAudioInputStream(new File(filename));
			
			format=stream.getFormat();
			
			//取得声频样本
			samples=getSamples(stream);
		} catch (UnsupportedAudioFileException ex) {
			ex.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * 取得声音样本的字节数组
	 * @return
	 */
	public byte[] getSamples(){
		return samples;
	}
	
	
	/**
	 * 从AudioInputStream取得样本字节数组
	 * @param audioStream
	 * @return
	 */
	private byte[] getSamples(AudioInputStream audioStream){
		//取得要读取的字节数
		int length=(int)(audioStream.getFrameLength())*format.getFrameSize();
		
		//读取整个流
		byte[] samples=new byte[length];
		DataInputStream is=new DataInputStream(audioStream);
		try{
			is.readFully(samples);
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		//返回样本
		return samples;
	}
	
	
	public void play(InputStream source){
		//用短的100ms缓冲区实时改变声音流
		int bufferSize=format.getFrameSize()*Math.round(format.getSampleRate()/10);
		byte[] buffer=new byte[bufferSize];
		
		//生成要播放的line
		SourceDataLine line;
		try {
			DataLine.Info info=new DataLine.Info(SourceDataLine.class, format);
			line=(SourceDataLine)AudioSystem.getLine(info);
			line.open(format,bufferSize);
		} catch (LineUnavailableException ex) {
			ex.printStackTrace();
			return;
		}
		
		//启动line
		line.start();
		
		//将数据复制到line
		try {
			int numBytesRead=0;
			while (numBytesRead!=-1) {
				numBytesRead=source.read(buffer, 0, buffer.length);
				if (numBytesRead!=-1) {
					line.write(buffer, 0, numBytesRead);
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
		
		//等待播放所有数据
		line.drain();
		//关闭line
		line.close();
		
	}
}
