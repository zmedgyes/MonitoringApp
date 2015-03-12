package bpv.neurosky.connector;

public interface ThinkGearListener {

	public void attentionEvent(int valor);

	public void meditationEvent(int valor);
	
	public void poorSignalEvent(int valor);
	
	public void blinkEvent(int valor);

	/**
	 * Recebe valores do EEG:
	 * 
	 * @param int[ delta, theta, lowAlpha, highAlpha, lowBeta, highBeta, lowGamma, highGamma ] 
	 */
	public void eegEvent(int delta, int theta, int lowAlpha, int highAlpha, int lowBeta, int highBeta, int lowGamma, int highGamma	);

	public void rawEvent(int[] valores);
		
}
