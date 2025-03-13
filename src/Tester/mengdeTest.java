package Tester;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uke_10.JavaSetToMengde;
import uke_10.LenketMengde;
import uke_10.MengdeADT;
import uke_10.TabellMengde;

public class mengdeTest {
	private MengdeADT<Integer> tabellMengde;
	private MengdeADT<Integer> lenketMengde;
	private MengdeADT<Integer> javaSetMengde;

	@BeforeEach
	public void setUp() {
		tabellMengde = new TabellMengde<>();
		lenketMengde = new LenketMengde<>();
		javaSetMengde = new JavaSetToMengde<>();

		tabellMengde.leggTil(1);
		tabellMengde.leggTil(2);
		tabellMengde.leggTil(3);

		lenketMengde.leggTil(1);
		lenketMengde.leggTil(2);
		lenketMengde.leggTil(3);

		javaSetMengde.leggTil(1);
		javaSetMengde.leggTil(2);
		javaSetMengde.leggTil(3);

	}

	// er mengden tom?
	@Test
	public void erTom() {
		MengdeADT<Integer> tomMengde = new TabellMengde<>();
		assertTrue(tomMengde.erTom());
		assertFalse(tabellMengde.erTom());

	}

	// inneholder element?
	@Test
	public void testInneholder() {

		assertTrue(tabellMengde.inneholder(1));
		assertFalse(tabellMengde.inneholder(9));

	}

	@Test
	public void testErDelmengdeAv() {
		MengdeADT<Integer> delmengde = new TabellMengde<>();
		delmengde.leggTil(1);
		delmengde.leggTil(2);

		assertTrue(delmengde.erDelmengdeAv(tabellMengde));
		assertFalse(tabellMengde.erDelmengdeAv(delmengde));

	}

	@Test
	public void testErLik() {
		MengdeADT<Integer> likMengde = new TabellMengde<>();
		likMengde.leggTil(1);
		likMengde.leggTil(2);
		likMengde.leggTil(3);

		assertTrue(tabellMengde.erLik(likMengde));

		likMengde.fjern(3);

		assertFalse(tabellMengde.erLik(likMengde));

	} // disjunkt: ikke noe til felles

	@Test
	public void testErDisjunkt() {
		MengdeADT<Integer> annenMengde = new TabellMengde<>();
		annenMengde.leggTil(4);
		annenMengde.leggTil(5);

		assertTrue(tabellMengde.erDisjunkt(annenMengde));

		annenMengde.leggTil(2);

		assertFalse(tabellMengde.erDisjunkt(annenMengde));

	}

	@Test
	public void TestUnion() {
		MengdeADT<Integer> annenMengde = new TabellMengde<>();
		annenMengde.leggTil(4);
		annenMengde.leggTil(5);

		MengdeADT<Integer> union = tabellMengde.union(annenMengde);

		assertTrue(union.inneholder(1));
		assertTrue(union.inneholder(5));

		assertFalse(union.inneholder(6));

	}

	@Test
	public void TestSnitt() {
		MengdeADT<Integer> annenMengde = new TabellMengde<>();
		annenMengde.leggTil(2);
		annenMengde.leggTil(3);
		annenMengde.leggTil(4);

		MengdeADT<Integer> snitt = tabellMengde.snitt(annenMengde);
		assertTrue(snitt.inneholder(2));
		assertTrue(snitt.inneholder(3));

		assertEquals(2, snitt.antallElementer());

		assertFalse(snitt.inneholder(4));

	}

	@Test
	public void testMinus() {
		MengdeADT<Integer> annenMengde = new TabellMengde<>();
		annenMengde.leggTil(2);

		MengdeADT<Integer> differanse = tabellMengde.minus(annenMengde);

		assertTrue(differanse.inneholder(1));
		assertTrue(differanse.inneholder(3));

		assertFalse(differanse.inneholder(2));

	}

	@Test
	public void testLeggTil() {
		tabellMengde.leggTil(4);
		assertTrue(tabellMengde.inneholder(4));

	}

	@Test
	public void testFjern() {
		assertEquals(Integer.valueOf(2), tabellMengde.fjern(2));
		assertFalse(tabellMengde.inneholder(2));

		assertNull(tabellMengde.fjern(5));
	}

	@Test
	public void testLeggTilAlleFra() {

		MengdeADT<Integer> annenMengde = new TabellMengde<>();

		annenMengde.leggTil(3);
		annenMengde.leggTil(4);
		annenMengde.leggTil(5);

		tabellMengde.leggTilAlleFra(annenMengde);

		assertTrue(tabellMengde.inneholder(3));
		assertTrue(tabellMengde.inneholder(4));
		assertTrue(tabellMengde.inneholder(5));

		assertEquals(5, tabellMengde.antallElementer());

		assertFalse(tabellMengde.inneholder(6));
		assertFalse(tabellMengde.inneholder(7));
	}

	@Test
	public void testTilTabell() {
		Integer[] resultat = (Integer[]) lenketMengde.tilTabell();
		
		assertEquals(3, resultat.length, "Tabellen skal ha riktig antall elementer");
		
		Integer[] forventet = { 3, 2, 1 }; // Matcher rekkefølgen i listen
		
		assertArrayEquals(forventet, resultat, "Tabellen skal ha korrekt innhold og rekkefølge");
	}
}
