package sensor;

import utils.Sensor;
import de.ksquared.system.mouse.GlobalMouseListener;
import de.ksquared.system.mouse.MouseAdapter;
import de.ksquared.system.mouse.MouseEvent;

public class ClickHandler implements Sensor{
	Thread t;
	private boolean safetyFlag;
	public ClickHandler(){
		safetyFlag=true;
	}
	public void start(){
		if(safetyFlag){
			t = new Thread(){
		  			public void run(){
		  				new GlobalMouseListener().addMouseListener(new MouseAdapter() {
		  					@Override public void mousePressed(MouseEvent event){ 
		  						System.out.println(event); 
		  					}
		  					//@Override public void mouseReleased(MouseEvent event)  { System.out.println(event); }
		  					//@Override public void mouseMoved(MouseEvent event) {System.out.println(event);}
		  				});
					}
			};
		t.start();
		safetyFlag=false;
		}
	}
	
	public void stop(){
		if(!safetyFlag){
			t.interrupt();
			safetyFlag=true;
		}
	}
	}
