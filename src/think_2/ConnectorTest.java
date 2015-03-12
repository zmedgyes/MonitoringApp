package think_2;


import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.net.ConnectException;

public class ConnectorTest implements ThinkGearListener {
	
	public ConnectorTest () {
		this.testConectorSocket();
	}

	private void testConectorSocket() {
		ThinkGearSocket conexao = new ThinkGearSocket(this);
		try {
			conexao.start();
		} catch (ConnectException e) {
			conexao.stop();
			e.printStackTrace();
		}
		while(conexao.isRunning());
		conexao.stop();
	}

	public void testConectorNativ(){
		System.out.println("*** Test Conector NeuroSky Nativ***");
		System.out.println("Driver Version: "+ThinkGearNativ.GetDriverVersion());
		int connectionId = ThinkGearNativ.GetNewConnectionId();
		System.out.println(""+connectionId);
		System.out.println(""+ThinkGearNativ.Connect(connectionId, "COM3", ThinkGearNativ.BAUD_9600, ThinkGearNativ.STREAM_PACKETS));
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