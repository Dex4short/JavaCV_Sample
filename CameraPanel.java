package main_package;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

public class CameraPanel extends JPanel{
	private static final long serialVersionUID = -225234423297598341L;
	private ImageIcon video_image;

	public CameraPanel() {
		
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.black);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		if(video_image != null) {
			g.drawImage(
				video_image.getImage(),
				(getWidth()/2) - (video_image.getIconWidth()/2),
				(getHeight()/2) - (video_image.getIconHeight()/2),
				this
			);
		}
		else {
			g.setColor(Color.white);
			g.drawString("Loading...", 10, getHeight()-10);
		}
		
	}
	public void startCamera() {
		new Thread() {
			public void run() {
				runCamera();
			}
		}.start();
	}
	public void captureCamera() {
		
	}
	
	private void runCamera() {
		VideoCapture web_cam = new VideoCapture(0);
		Mat matrix = new Mat();
		
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {			
			@Override
			public void run() {
				web_cam.read(matrix);
				
				final MatOfByte buff = new MatOfByte();
				Imgcodecs.imencode(".jpg", matrix, buff);
				
				video_image = new ImageIcon(buff.toArray());
				
				repaint();
			}
		}, 0, 20);
	}
}
