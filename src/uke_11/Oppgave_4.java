package uke_11;

import java.util.*;

public class Oppgave_4 {
	public static void main(String args[]) {
		
		HashSet<Integer> hSet = new HashSet<>();
		Integer[] tab = new Integer[100000];
		
		int tall = 376;
		
		for(int i = 0; i < 100000; i++) {
			hSet.add(tall);
			tab[i] = tall;
			tall = (tall + 45713) % 1000000;
		}
		
		Arrays.sort(tab);
		
		Random random = new Random();
		
		int[] soketall = new int[10000];
		for(int i = 0; i < 10000; i++) {
			soketall[i] = random.nextInt(1000000);
		}
		
		long startTid = System.currentTimeMillis();
		int funnetiHset = 0;
		for(int tallsok : soketall) {
			if(hSet.contains(tallsok)) {
				funnetiHset++;
			}
		}
		
		long sluttTid = System.currentTimeMillis();
		long tidHset = sluttTid - startTid;
		
		long startTid2 = System.currentTimeMillis();
		int funnetiTab = 0;
		for(int tallsok : soketall) {
			if(Arrays.binarySearch(tab, tallsok) >= 0) {
				funnetiTab++;
			}
		}
		
		long sluttTid2 = System.currentTimeMillis();
		long tidTab = sluttTid2 - startTid2;
		
		System.out.println("Søking i HashSet: " + tidHset + " ms, funnet: " + funnetiHset);
		System.out.println("Søking i Tabell: " + tidTab + " ms, funnet: " + funnetiTab);
		
	}

}
