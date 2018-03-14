package projekt1PEA;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Scanner;

import projekt1PEA.Graf;
import projekt1PEA.TSPInstance;

public class Projekt1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int wybor;
		Scanner scanner=new Scanner(System.in);
		Scanner scanner2 =new Scanner(System.in);
		Scanner scanner3=new Scanner(System.in);
		Scanner scanner4=new Scanner(System.in);
		long start;
		long stop;
		long roznica;
		double czas;
		Solver solver;
		
		
		
		
		
		
		do {
		System.out.println("1. Graf z pliku");
		System.out.println("2. Graf z macierzy wpisanej przez u¿ytkownika");
		System.out.println("3. Wyjdz");
		wybor=Integer.parseInt(scanner.nextLine());
		switch(wybor) {
			case 1:
				System.out.println("Podaj nazwe pliku: ");
				String nazwaPliku=scanner4.nextLine();
				File file = new File(nazwaPliku);
				System.out.println("Plik z instancj¹ TSP: " + file.getName());
				TSPInstance instancja = new TSPInstance(file);
				Graf graf = new Graf(instancja);
				start = System.currentTimeMillis();	
				solver=new Solver(graf);
				solver.rozwiaz();
				stop = System.currentTimeMillis();
				roznica = stop - start;
				czas = roznica;
				System.out.println("Czas wykonania: " + czas + " ms");
				break;
			case 2: 
				System.out.println("Podaj liczbe wierzcholkow");
				int liczbaWierzcholkow=scanner3.nextInt();
				graf=new Graf(liczbaWierzcholkow);
				int poczatek;
				int koniec;
				int index;
				System.out.println("Pamietaj aby po przekatnej znajdowala sie jakas duza liczba reprezentujaca nieskonczonosc. Np. 9999");
				for(int i=0; i<liczbaWierzcholkow; i++) {
					index=0;//index kolejnego miejsca tablicy macierzy kosztow
					poczatek=0;
					koniec=0;
					System.out.println("Podaj wiersz [" + i + "] macierzy");
					String wiersz=scanner2.nextLine();
						while(koniec<wiersz.length()) {
							while(koniec<wiersz.length()-1 && wiersz.charAt(koniec+1)!=32) {
								koniec++;
							}
							graf.wstawDoMacierzy(i,index,Integer.parseInt(wiersz.substring(poczatek, koniec+1)));
							poczatek=koniec+2;//ominiecie jednej spacji
							koniec=poczatek;
							index++;
							}
					}
				start = System.currentTimeMillis();	
				solver=new Solver(graf);
				solver.rozwiaz();
				stop = System.currentTimeMillis();
				roznica = stop - start;
				czas = roznica / 1000.00;
				System.out.println("Czas wykonania: " + czas + " ms");
		}
	}while(wybor!=3);

}
}
