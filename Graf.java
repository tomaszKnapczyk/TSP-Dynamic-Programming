package projekt1PEA;

import java.util.ArrayList;
import java.util.BitSet;

public class Graf {

	public int liczbaWierzcholkow;
	public int x=3;
	private int[][] macierzKosztow;
	private TSPInstance instancja;

	public Graf(int liczbaWierzcholkow) {
		this.liczbaWierzcholkow=liczbaWierzcholkow;
		macierzKosztow=new int [liczbaWierzcholkow][liczbaWierzcholkow];
		
	}
	
	public void wstawDoMacierzy(int index1, int index2, int koszt) {
		macierzKosztow[index1][index2]=koszt;
	}  
	
	public int getMacierzKosztow(int index1, int index2) {
		return macierzKosztow[index1][index2];
	}
	
	public Graf(TSPInstance instancja) {
		this.liczbaWierzcholkow = instancja.getDimension()-x;
		this.instancja = instancja;

		macierzKosztow = new int[instancja.getDimension()-x][instancja.getDimension()-x];
		uzupelnijMacierz();
	}

	private void uzupelnijMacierz() {
		for (int i = 0; i < instancja.getDimension()-x; i++) {
			for (int j = 0; j < instancja.getDimension()-x; j++) {
				this.macierzKosztow[i][j] = (int) instancja.getDistanceTable().getDistanceBetween(i, j);
				/*System.out.print(this.macierzKosztow[i][j]+" ");*/
			}
			/*System.out.println();*/
		}
	}

}

