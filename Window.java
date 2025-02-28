package main_package;
import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Window extends JFrame{
	private static final long serialVersionUID = -8255319694373975038L;

	public Window() {
		setTitle("JavaCV");
		setLayout(new BorderLayout());
		
		CameraPanel cam_panel = new CameraPanel();
		cam_panel.startCamera();
		add(cam_panel, BorderLayout.CENTER);
		
	}
}
