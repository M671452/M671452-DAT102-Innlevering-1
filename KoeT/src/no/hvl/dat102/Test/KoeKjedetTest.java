package no.hvl.dat102.Test;

import no.hvl.dat102.adt.KoeADT;
import no.hvl.dat102.kjedet.KjedetKoe;

public class KoeKjedetTest extends KoeADTTest  {
	@Override
	protected KoeADT<Integer> reset() {
		return new KjedetKoe<Integer>();
	}

}
