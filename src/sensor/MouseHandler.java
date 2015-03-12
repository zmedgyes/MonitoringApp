package sensor;

import java.awt.Component;
import java.awt.MouseInfo;
import java.awt.Point;

import utils.CommonAction;
import utils.HeatMap;

public class MouseHandler extends CommonAction{
	private Point p;
	public HeatMap heatMap;

	public MouseHandler(){
		heatMap=new HeatMap();
	}
	@Override
	public void doAction() throws Exception {
		p = MouseInfo.getPointerInfo().getLocation();
		System.out.println(p.x+" "+p.y);
		heatMap.addPoint(p.x,p.y);
	}
	public void export(){
		try {
			heatMap.doAction();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
