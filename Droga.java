package projekt1PEA;

public class Droga {
	private int koszt;
	private Droga optPodDroga;
	private int pktKoncowy;
	public int getPktKoncowy() {
		return pktKoncowy;
	}
	public void setPktKoncowy(int pktKoncowy) {
		this.pktKoncowy = pktKoncowy;
	}
	public int getKoszt() {
		return koszt;
	}
	public void setKoszt(int maska) {
		this.koszt = maska;
	}
	public Droga getOptPodDroga() {
		return optPodDroga;
	}
	public void setOptPodDroga(Droga optPodDroga) {
		this.optPodDroga = optPodDroga;
	}
}
