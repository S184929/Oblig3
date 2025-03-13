package uke_11;

import java.util.*;

public class Oppgave_4 {
	public static void main(String args[]) {
		
		HashSet<Integer> hSet = new HashSet<>();
		Integer[] tab = new Integer[100000];
		
		int tall = 376;
		
		for(int i = 0; i < 100000;) {
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
		
		
	}

}
