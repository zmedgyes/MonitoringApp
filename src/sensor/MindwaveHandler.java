package sensor;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.net.ConnectException;

import think_2.ThinkGearListener;
import think_2.ThinkGearSocket;
import utils.Sensor;

public class MindwaveHandler implements ThinkGearListener,Sensor {
	public ThinkGearSocket socket;
	
	public MindwaveHandler(){
		socket = new ThinkGearSocket(this);
	}
	
	public void start(){
		try {
			socket.start();
		} catch (ConnectException e) {
			socket.stop();
			e.printStackTrace();
		}
	}
	
	public void stop(){
		socket.stop();
	}

	@Override
	public void attentionEvent(int value) {
		System.out.println("attentionEvent: "+value);
	}

	@Override
	public void meditationEvent(int value) {
		System.out.println("meditationEvent: "+value);
	}

	@Override
	public void poorSignalEvent(int value) {
		System.out.println("poorSignalEvent: "+value);
	}

	@Override
	public void blinkEvent(int value) {
		System.out.println("blinkEvent: "+value);
		if(value>10){
			Robot robot;
			try {
				robot = new Robot();
				robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			} catch (AWTException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public void eegEvent(int delta, int theta, int lowAlpha, int highAlpha, int lowBeta, int highBeta, int lowGamma, int highGamma	){
		System.out.println("eegEvent: "+delta+","+theta+","+lowAlpha+","+highAlpha+","+lowBeta+","+highBeta+","+lowGamma+","+highGamma);
	}

	@Override
	public void rawEvent(int[] values) {
		System.out.println("rawEvent: "+values.length);
	}

}
