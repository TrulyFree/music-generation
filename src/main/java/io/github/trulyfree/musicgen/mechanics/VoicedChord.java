package io.github.trulyfree.musicgen.mechanics;

import lombok.NonNull;

public interface VoicedChord extends InvertedChord {

	public Note getBass();

	public boolean setBass(@NonNull Note note);

	public Note getTenor();

	public boolean setTenor(@NonNull Note note);

	public Note getAlto();

	public boolean setAlto(@NonNull Note note);

	public Note getSoprano();

	public boolean setSoprano(@NonNull Note note);

	public Note[] getNotes();

	public boolean setNotes(@NonNull Note[] notes);

}
