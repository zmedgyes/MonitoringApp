package utils;

public class RateToRGB {
	public int red;
	public int green;
	public int blue;
	public int alpha;
	RateToRGB(int rate){
		/*if(rate<100){alpha=0;}
		else{alpha=10*rate/1023;}*/
		alpha=10*rate/1023;
		if(rate<0){
			blue=255;
			red=0;
			green=0;
		}
		else if(rate>=0 && rate<=255){
			blue=255;
			green=rate;
			red=0;
		}
		else if(rate>=256 && rate<=511){
			green=255;
			blue=255-(rate-256);
			red=0;
		}
		else if(rate>=512 && rate<=767){
			green=255;
			red=rate-512;
			blue=0;
		}
		else if(rate>=768 && rate<=1023){
			red=255;
			blue=0;
			green=255-(rate-768);
		}
		else{
			red=255;
			blue=0;
			red=0;
		}
	}
}