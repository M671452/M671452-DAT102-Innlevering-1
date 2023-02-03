package no.hvl.dat102.Test;

import no.hvl.dat102.adt.*;
import no.hvl.dat102.tabell.TabellSirkulaerKoe;


public class KoeTabellTest extends KoeADTTest {

		@Override
		protected KoeADT<Integer> reset() {
			return new TabellSirkulaerKoe<Integer>();
		}

	}