package sensor;

import java.awt.AWTException;
import java.awt.Robot;

import com.theeyetribe.client.GazeManager;
import com.theeyetribe.client.IGazeListener;
import com.theeyetribe.client.GazeManager.ApiVersion;
import com.theeyetribe.client.GazeManager.ClientMode;
import com.theeyetribe.client.data.GazeData;

import utils.*;

public class GazeHandler extends CommonAction{
	public static double averX=0;
	public static double averY=0;
	public static double recievedSample=0;
	
	public GazeHandler(){
		
		
		final GazeManager gm = GazeManager.getInstance();        
		boolean success = gm.activate(ApiVersion.VERSION_1_0, ClientMode.PUSH);
	    final GazeListener gazeListener = new GazeListener();
	    gm.addGazeListener(gazeListener);
	    /*gm.addGazeListener(new GazeListener()
	    {
		    @Override
		    public void onGazeUpdate(GazeData gazeData)
		    {
		    	System.out.println(gazeData.smoothedCoordinates.x+" "+gazeData.smoothedCoordinates.y);
		    	if(gazeData.smoothedCoordinates.x!=0 && gazeData.smoothedCoordinates.y!=0){

		    	}
		    }
	    }
	    );*/
	}
	
    private static class GazeListener implements IGazeListener
    {
        @Override
        public void onGazeUpdate(GazeData gazeData)
        {
            System.out.println(gazeData.smoothedCoordinates.x+" "+gazeData.smoothedCoordinates.y);
			averX+=gazeData.smoothedCoordinates.x;
			averY+=gazeData.smoothedCoordinates.y;
			recievedSample++;
        }
    }

	@Override
	public void doAction() throws Exception {
		averX=averX/recievedSample;
		averY=averY/recievedSample;
		System. out.println(recievedSample+" "+averX+" "+averY);
		Robot robot;
		try {
			robot = new Robot();
			if((int)averX!=0 && (int)averY!=0){
				robot.mouseMove((int)averX, (int)averY);
			}
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		averX=0;
		averY=0;
		recievedSample=0;
	}
    
}

