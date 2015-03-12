package think_2;

public interface ThinkGearListener {

	public void attentionEvent(int value);

	public void meditationEvent(int value);
	
	public void poorSignalEvent(int value);
	
	public void blinkEvent(int value);

	/**
	 * 
	 * 
	 * @param int[ delta, theta, lowAlpha, highAlpha, lowBeta, highBeta, lowGamma, highGamma ] 
	 */
	public void eegEvent(int delta, int theta, int lowAlpha, int highAlpha, int lowBeta, int highBeta, int lowGamma, int highGamma	);

	public void rawEvent(int[] values);
		
}

