package no.hvl.dat102.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.exceptions.EmptyCollectionException;

public abstract class KoeADTTest {


		private KoeADT<Integer> koe;
		
		//Test data
		private Integer e0=1;
		private Integer e1=2;
		private Integer e2=3;
		private Integer e3=4;
		private Integer e4=5;
		
		protected abstract KoeADT<Integer> reset();
		/**
		 * Hent en ny kø for hver test.
		 * 
		 * @return
		 */
		
		@Before
		public void setup() {
			koe = reset();
		}
		
		/* Test på at en ny kø er tom.
		 */
		
		@Test
		public void nyKoeErTom() {
			assertTrue(koe.erTom());
		}
		
		/**
		 * Test på innkoe and utkoe.
		 */
		
		@Test
		public void innKoeOgUtKoe() {
		
		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e2);
		koe.innKoe(e3);
		
		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
			assertEquals(e3, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("utKoe feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test på innkoe og utkoe med duplikate verdier.
	 */
	@Test
	public void innKoeOgUtKoeMedDuplikater() {

		koe.innKoe(e0);
		koe.innKoe(e1);
		koe.innKoe(e1);
		koe.innKoe(e2);

		try {
			assertEquals(e0, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e1, koe.utKoe());
			assertEquals(e2, koe.utKoe());
		} catch (EmptyCollectionException e) {
			fail("utKoe feilet uventet " + e.getMessage());
		}
	}

	/**
	 * Testing på foerste.
	 */
	@Test
	public void innKoeUtKoeInnKoeInnKoeUtKoeFoerste() {
		try {
			koe.innKoe(e0);
			koe.utKoe();
			koe.innKoe(e1);
			koe.innKoe(e2);
			koe.utKoe();
			assertEquals(e2, koe.foerste());

		} catch (EmptyCollectionException e) {
			fail("utKoe eller foerstefeilet uventet " + e.getMessage());
		}
	}

	/**
	 * Test på at en koe med noen elementer ikke er tom.
	 */
	@Test
	public final void erIkkeTom() {
		koe.innKoe(e0);
		koe.innKoe(e1);
		assertFalse(koe.erTom());
	}

	/**
	 * Test på at en koe med null elementer er tom.
	 */
	@Test
	public void innKoeUtKoeErTom() {
		try {
			koe.innKoe(e0);
			koe.utKoe();
			assertTrue(koe.erTom());

		} catch (EmptyCollectionException e) {
			fail("innKoe eller utKoe feilet uventet " + e.getMessage());
		}
	}

		
	/**
	 * Forsøk på utKoe av en tom kø skal gi "underflow excepton" *
	 * 
	 * @throws EmptyCollectionException expected exception
	 */
	
	@Test
	public void utKoeFromEmptyIsUnderflowed() {
		Assertions.assertThrows(EmptyCollectionException.class,()-> {
			koe.utKoe();
		});
	}
		
	}

