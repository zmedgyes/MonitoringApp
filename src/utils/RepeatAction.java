package utils;

public class RepeatAction implements Sensor{
	private Thread t;
	private CommonAction c;
	private int cycle;
	private boolean safetyFlag;
	
	public RepeatAction(CommonAction action, int repeatMilis){
		c=action;
		cycle=repeatMilis;
		safetyFlag=true;
	}
	
	public void start(){
		if(safetyFlag){
			t = new Thread(){
	  			public void run(){
					try {
						while(true){
							c.doAction();
							sleep(cycle);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}	
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
	
	public void setCycle(int newCycle){
		cycle=newCycle;
	}
	
	public void setAction(CommonAction com){
		c=com;
	}
	
}
