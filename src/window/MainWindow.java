package window;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.ProgressMonitor;

import sensor.*;
import utils.*;

public class MainWindow extends JFrame implements MyProgressListener{
	private static final long serialVersionUID = 1L;
	
	ProgressMonitor pm =new ProgressMonitor(this, "", "", 0, 100);
	private List<Sensor> sensorList = new ArrayList<Sensor>();
	String progressText="";
	
	public MainWindow(){
		super("Screen Button");
		setSize(350,150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pm.setMillisToDecideToPopup(1);
		pm.setMillisToPopup(1);
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		JButton configButton = new JButton("Config");
		JButton stopButton = new JButton("Stop");
		JButton startButton = new JButton("Start");
		
		p1.add(configButton);
		p1.add(startButton);
		p1.add(stopButton);
		
		
		stopButton.setEnabled(false);
		
		GazeHandler gh =new GazeHandler();
		RepeatAction gazeSensor = new RepeatAction(gh, 100);
		//addSensor(gazeSensor);
		
		
		MouseHandler mh = new MouseHandler();
		mh.heatMap.addListener(this);
		mh.heatMap.setInsignificantPercent(10);
		mh.heatMap.setAveraging(500);

		RepeatAction mouseSensor = new RepeatAction(mh, 100);
		addSensor(mouseSensor);
		
		
		ClickHandler ch = new ClickHandler();
		addSensor(ch);
		
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			      startButton.setEnabled(false);
			      configButton.setEnabled(false);
			      stopButton.setEnabled(true);
			      
			      for (Sensor sr : sensorList){
			            sr.start();
			      }
			}
		});
		
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			      startButton.setEnabled(true);
			      configButton.setEnabled(true);
			      stopButton.setEnabled(false);
			      
			      for (Sensor sr : sensorList){
			            sr.stop();
			      }
			}
		});
		
		configButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread t = new Thread(){
					public void run(){
						mh.export();
						pm.close();
						this.interrupt();
					}
				};
				t.start();
			}
		});
		
		add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.SOUTH);
		add(p3,BorderLayout.CENTER);
		setVisible(true);
	}

	@Override
	public void progressUpdate(int percent) {
		// TODO Auto-generated method stub
		pm.setProgress(percent);
		System.out.println(progressText+percent);
	}

	@Override
	public void progressUpdate(String text) {
		progressText=text;
		pm.setNote(text);
	}
	
	public void addSensor(Sensor sensor){
		sensorList.add(sensor);
	}

}
