package io.github.trulyfree.musicgen.mechanics;

public interface InvertedChord extends Chord {

	public Inversion getInversion();
	
	public static enum Inversion {
		ROOT, FIRST, SECOND, THIRD;
	}
	
}
