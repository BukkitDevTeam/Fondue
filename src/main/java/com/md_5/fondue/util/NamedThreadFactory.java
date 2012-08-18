package com.md_5.fondue.util;

import java.util.concurrent.ThreadFactory;

/**
 * Utility class to create a named thread factory that creates a {@link Thread}
 * with a base name, and an integer index.
 */
public class NamedThreadFactory implements ThreadFactory {

    /**
     * Base name to use
     */
    private final String base;
    /**
     * Current number of threads created.
     */
    private int index = 0;

    public NamedThreadFactory(String base) {
        this.base = base;
    }

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, base + "#" + ++index);
    }
}
