package sensor;

import utils.Sensor;
import de.ksquared.system.mouse.GlobalMouseListener;
import de.ksquared.system.mouse.MouseAdapter;
import de.ksquared.system.mouse.MouseEvent;

public class ClickHandler implements Sensor{
	Thread t;
	private boolean safetyFlag;
	private GlobalMouseListener gml;
	private MouseAdapter ma;
	public ClickHandler(){
		safetyFlag=true;
	}
	public void start(){
		if(safetyFlag){
			t = new Thread(){
		  			public void run(){
		  				gml=new GlobalMouseListener();
		  				ma=new MouseAdapter() {
		  					@Override public void mousePressed(MouseEvent event){ 
		  						System.out.println(event); 
		  					}
		  					//@Override public void mouseReleased(MouseEvent event)  { System.out.println(event); }
		  					//@Override public void mouseMoved(MouseEvent event) {System.out.println(event);}
		  				};
		  				gml.addMouseListener(ma);
					}
			};
		t.start();
		safetyFlag=false;
		}
	}
	
	public void stop(){
		if(!safetyFlag){
			gml.removeMouseListener(ma);
			t.interrupt();
			safetyFlag=true;
		}
	}
	}
