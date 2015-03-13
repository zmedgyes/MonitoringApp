package window;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTabbedPane;
import javax.swing.ProgressMonitor;

import sensor.*;
import utils.*;

public class MainWindow extends JFrame implements MyProgressListener,ItemListener{
	private static final long serialVersionUID = 1L;
	
	ProgressMonitor pm =new ProgressMonitor(this, "", "", 0, 100);
	private List<Sensor> sensorList = new ArrayList<Sensor>();
	String progressText="";
	
	JTabbedPane cards;
	
	public MainWindow(){
		super("Screen Button");
		setSize(350,150);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		pm.setMillisToDecideToPopup(1);
		pm.setMillisToPopup(1);
		
		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		
		JPanel defaultPanel= new JPanel();
		JPanel configPanel = new JPanel();
		cards = new JTabbedPane();
		
		
		JButton configButton = new JButton("Config");
		JButton stopButton = new JButton("Stop");
		JButton startButton = new JButton("Start");
		
		JCheckBox eegCB = new JCheckBox("EEG");
		JCheckBox etCB = new JCheckBox("EyeTribe");
		JCheckBox clickCB = new JCheckBox("Click");
		JCheckBox mouseCB = new JCheckBox("Movement");

		
		/*p1.add(configButton);
		p1.add(startButton);
		p1.add(stopButton);*/
		
		configPanel.add(configButton);
		configPanel.add(eegCB);
		configPanel.add(etCB);
		configPanel.add(clickCB);
		configPanel.add(mouseCB);
		
		int etIndex=0;
		
		defaultPanel.add(startButton);
		defaultPanel.add(stopButton);
		
		stopButton.setEnabled(false);
		

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
						mh.heatMap.clearTable();
						pm.close();
						this.interrupt();
					}
				};
				t.start();
			}
		});
		
		etCB.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				RepeatAction gazeSensor=null;
				if(etCB.isSelected()){
					GazeHandler gh =new GazeHandler();
					gazeSensor = new RepeatAction(gh, 100);
					addSensor(gazeSensor);
					//etIndex=sensorList.indexOf(gazeSensor);
				}
				else{
					System.out.println("etremoved");
					sensorList.remove(etIndex);
				}
				
			}
			
		});
		
		
		
		cards.addTab("Default",defaultPanel);
		cards.addTab("Config",configPanel);

		
		add(cards,BorderLayout.CENTER);
		/*add(p1,BorderLayout.NORTH);
		add(p2,BorderLayout.SOUTH);
		add(p3,BorderLayout.CENTER);*/
		setVisible(true);
	}
	
	public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
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
	public void removeSensor(Sensor sensor){
		if(sensorList.contains(sensor)){
			sensorList.remove(sensor);
		}
	}

}
