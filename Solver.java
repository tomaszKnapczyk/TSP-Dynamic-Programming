package projekt1PEA;

public class Solver {
	Graf graf;
	int niesk = 99999; // nieskonczonsoc
	int n;
	int liczbaKombinacji;
	Droga[][] kombinacje;
	int [] trasa;
	
	public Solver(Graf graf) {
		this.graf=graf;
		n = graf.liczbaWierzcholkow;
		liczbaKombinacji=(int)Math.pow(2, n);
		kombinacje = new Droga[liczbaKombinacji][n];
		trasa=new int[graf.liczbaWierzcholkow-1];
	}
	
	public void rozwiaz() {
		kombinacje[1][0]=new Droga();
		kombinacje[1][0].setKoszt(0);
		
		for (int kombinacja = 2; kombinacja <liczbaKombinacji; kombinacja++) {
			for (int i = 0; i < n; i++) {
				kombinacje[kombinacja][i] = new Droga();
				kombinacje[kombinacja][i].setKoszt(niesk);
				kombinacje[kombinacja][i].setPktKoncowy(i);
				if ((kombinacja & (1 << i)) != 0) {
					int tempMaska = kombinacja - (int)Math.pow(2, i);
					for (int j = 0; j < n; j++) 
						if ((tempMaska & (1 << j)) != 0) {
							if(kombinacje[tempMaska][j].getKoszt() + graf.getMacierzKosztow(j,i) < kombinacje[kombinacja][i].getKoszt()) {
								kombinacje[kombinacja][i].setKoszt(kombinacje[tempMaska][j].getKoszt() + graf.getMacierzKosztow(j,i));
								kombinacje[kombinacja][i].setOptPodDroga(kombinacje[tempMaska][j]);
							}
						}
				}
				
			}
		}
		
		Droga optDroga=null;
		int minKoszt = niesk;
		for (int i = 0; i < n; ++i) {
			if(kombinacje[(1 << n) - 1][i].getKoszt() + graf.getMacierzKosztow(i,0) < minKoszt) {
				minKoszt = kombinacje[(1 << n) - 1][i].getKoszt() + graf.getMacierzKosztow(i,0);
				optDroga=kombinacje[(1 << n) - 1][i];
			}
		}
		
		System.out.println("Koszt najkrotszej drogi: " + minKoszt);
		
		
		Droga tempDroga=optDroga;
		for (int i=0; i<graf.liczbaWierzcholkow-1; i++) {
			trasa[i]=tempDroga.getPktKoncowy();
			tempDroga=tempDroga.getOptPodDroga();
		}
		
		System.out.print("Najkrotsza Droga: 0-");
		for (int i=trasa.length-1; i>=0; i--) {
			System.out.print(trasa[i]+"-");
		}
		System.out.println("0");
		
		
	}
	

}
