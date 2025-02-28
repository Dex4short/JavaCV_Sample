package main_package;
import javax.swing.JFrame;

import org.opencv.core.Core;

public class WebcamPanelApp {

    public static void main(String[] args) {
    	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    	System.out.println("load scuccess");
    	
    	Window w = new Window();
    	w.setSize(800, 600);
    	w.setLocationRelativeTo(null);
    	w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	w.setVisible(true);
    	
    }
}
