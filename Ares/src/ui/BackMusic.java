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
 * �������ָ�ʽת��
 * @author wyj
 *
 */
public class BackMusic {

	private AudioFormat format;
	private byte[] samples;
	
	/**
	 * ���ļ�������
	 * @param filename
	 */
	public BackMusic(String filename) {

		try {
			//����Ƶ������
			AudioInputStream stream=AudioSystem.getAudioInputStream(new File(filename));
			
			format=stream.getFormat();
			
			//ȡ����Ƶ����
			samples=getSamples(stream);
		} catch (UnsupportedAudioFileException ex) {
			ex.printStackTrace();
		}catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
	
	/**
	 * ȡ�������������ֽ�����
	 * @return
	 */
	public byte[] getSamples(){
		return samples;
	}
	
	
	/**
	 * ��AudioInputStreamȡ�������ֽ�����
	 * @param audioStream
	 * @return
	 */
	private byte[] getSamples(AudioInputStream audioStream){
		//ȡ��Ҫ��ȡ���ֽ���
		int length=(int)(audioStream.getFrameLength())*format.getFrameSize();
		
		//��ȡ������
		byte[] samples=new byte[length];
		DataInputStream is=new DataInputStream(audioStream);
		try{
			is.readFully(samples);
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		//��������
		return samples;
	}
	
	
	public void play(InputStream source){
		//�ö̵�100ms������ʵʱ�ı�������
		int bufferSize=format.getFrameSize()*Math.round(format.getSampleRate()/10);
		byte[] buffer=new byte[bufferSize];
		
		//����Ҫ���ŵ�line
		SourceDataLine line;
		try {
			DataLine.Info info=new DataLine.Info(SourceDataLine.class, format);
			line=(SourceDataLine)AudioSystem.getLine(info);
			line.open(format,bufferSize);
		} catch (LineUnavailableException ex) {
			ex.printStackTrace();
			return;
		}
		
		//����line
		line.start();
		
		//�����ݸ��Ƶ�line
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
		
		
		//�ȴ�������������
		line.drain();
		//�ر�line
		line.close();
		
	}
}
