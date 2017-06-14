package io.github.trulyfree.musicgen.mechanics;

import lombok.NonNull;

public interface Chord {

	public ScalarIndex getScalarIndex();

	public default boolean expects(@NonNull Note note) {
		ScalarIndex noteIndex = note.getScalarIndex();
		return this.getScalarIndex().equals(noteIndex) || ScalarIndex.isInterval(noteIndex, this.getScalarIndex(), 3)
				|| ScalarIndex.isInterval(noteIndex, this.getScalarIndex(), 5);
	}

}
