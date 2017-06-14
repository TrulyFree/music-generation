package io.github.trulyfree.musicgen.mechanics;

import java.util.Iterator;

public interface VoicedChordIterator extends Iterator<VoicedChord> {
	
	public boolean useCadence(Cadence cadence);
	
	public Cadence[] possibleCadences();

}
