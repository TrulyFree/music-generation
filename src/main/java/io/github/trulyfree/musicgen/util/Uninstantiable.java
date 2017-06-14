package io.github.trulyfree.musicgen.util;

public class Uninstantiable {

	protected Uninstantiable() {
		throw new UnsupportedOperationException("Class " + getClass().getName() + " is not instantiable.");
	}

}
