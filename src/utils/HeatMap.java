package utils;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.imageio.ImageIO;



//public class HeatMap extends CommonAction{
public class HeatMap{
	private int dimX;
	private int dimY;
	private double [][] data;
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_hh_mm_ss");
	private String path;
	private int averLevel=100;
	private double insignificantPercent=0.01;
	private double progressPercent=0;
	private List<MyProgressListener> listeners = new ArrayList<MyProgressListener>();
	
	public HeatMap(){
		path="C:\\Users\\Zsolt\\Pictures\\";
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		int i;
		int j;
		dimX=d.width;
		dimY=d.height;
		
		data=new double [dimY][dimX];
	
		for(j=0;j<dimY;j++){
			for(i=0;i<dimX;i++){
				data[j][i]=0;
			}	
		}
	}
	
	public void addPoint(int x, int y){
		if(y>0 && x>0 && x<dimX && y<dimY){
			data[y][x]+=1;
		}
	}
	
	public void averageMap(){
		int tmpX;
		int tmpY;
		int x;
		int y;
		double currentValue;
		double averageValue;
		double validPoint;
	
		for(y=0;y<dimY;y++){
			for(x=0;x<dimX;x++){
				currentValue=data[y][x];
				validPoint=0;
				averageValue=0;
				for(tmpY=-1;tmpY<2;tmpY++){
					for(tmpX=-1;tmpX<2;tmpX++){
						if((x+tmpX)>-1 && (y+tmpY)>-1 && (x+tmpX)<dimX && (y+tmpY)<dimY){
							validPoint++;
							averageValue+=data[y+tmpY][x+tmpX];
						}
					}
				}
				
				//mindenképp általános averaging
				data[y][x]=averageValue/validPoint;
			}
		}
	}
	
	public double getMin(){
		int x;
		int y;
		double currentMin=data[0][0];
		for(y=0;y<dimY;y++){
			for(x=0;x<dimX;x++){
				if(data[y][x]<currentMin){
					currentMin=data[y][x];
				}
			}
		}
		return currentMin;
	}
	
	public double getMax(){
		int x;
		int y;
		double currentMax=data[0][0];
		for(y=0;y<dimY;y++){
			for(x=0;x<dimX;x++){
				if(data[y][x]>currentMax){
					currentMax=data[y][x];
				}
			}
		}
		return currentMax;
	}
	
	public void makePercented(){
		int x;
		int y;
		double currentMax=getMax();
		double base=1023;
		double insignificantValue=base/100*insignificantPercent;
		for(y=0;y<dimY;y++){
			for(x=0;x<dimX;x++){
				//átlátszósag:10 és 30 kozott, felette semmi nem latszik a hatterben es aranytalan
				//data[y][x]=data[y][x]/currentMax*10;
				//rgb árnyalat
				data[y][x]=data[y][x]/currentMax*base;
				if(data[y][x]<insignificantValue){data[y][x]=0;}
			}
		}
	}
	
	public void doAction() throws Exception{
		
		Calendar now = Calendar.getInstance();
		Robot robot = new Robot();
	    //BufferedImage img = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
		BufferedImage img = new BufferedImage (dimX, dimY, BufferedImage.TYPE_INT_ARGB);
	    Graphics g = img.createGraphics();
		int x;
		int y;
		int i;
		//500 es 1500 kozott, borzalmasan eszi a processzort
		//a kockaméret növelésével csökkenthetõ a átlagolás
		//100 av ->30*30
		//300av -y20 *20
		setProgressText("Averaging:");
		for(i=0;i<averLevel;i++){
			averageMap();
			progressPercent=(double)i/(double)averLevel*100;
			setProgress((int)progressPercent);
		}
		makePercented();
		setProgressText("Drawing:");
		for(y=0;y<dimY;y++){
			progressPercent=(double)y/(double)dimY*100;
			setProgress((int)progressPercent);
			for(x=0;x<dimX;x++){
				//átlátszóságra opt
				 //g.setColor(new Color(255, 0, 0,(int)(data[y][x])));
				 //árnyalat opt
				if(data[y][x]>0){
					 RateToRGB act = new RateToRGB((int)data[y][x]);
					 g.setColor(new Color(act.red, act.green, act.blue,act.alpha));
					 //a kockaméret növelésével folytonosabb ábra kapható
					 //40-nél már túl kockás
					 //g.fillRect(x, y, 30, 30);
					 g.fillOval(x, y, 20, 20);
				}
			}
		}
		ImageIO.write(img, "PNG", new File(path+"map_"+formatter.format(now.getTime())+".png"));
	}
	
	public void setPath(String newpath){
		path=newpath;
	}
	
	public void setInsignificantPercent(int percent){
		insignificantPercent=percent;
	}
	
	public void setAveraging(int averagingCycles){
		averLevel=averagingCycles;
	}
	
    public void addListener(MyProgressListener toAdd) {
        listeners.add(toAdd);
    }
    
    private void setProgress(int progress){
    	for (MyProgressListener hl : listeners)
            hl.progressUpdate(progress);
    }
    private void setProgressText(String text){
    	for (MyProgressListener hl : listeners)
            hl.progressUpdate(text);
    }
	
}
