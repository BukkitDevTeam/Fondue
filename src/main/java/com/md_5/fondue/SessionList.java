package com.md_5.fondue;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * A list of all the sessions which provides a convenient {@link #update} method
 * to update every session in one operation.
 */
public final class SessionList {

    /**
     * A list of the sessions.
     */
    private final ConcurrentLinkedQueue<Session> sessions = new ConcurrentLinkedQueue<Session>();

    /**
     * Updates all the sessions.
     */
    public void update() {
        for (Session session : sessions) {
            session.update();
        }
    }

    /**
     * Adds a new session.
     *
     * @param session The session to add.
     */
    public void add(Session session) {
        sessions.add(session);
    }

    /**
     * Removes a session.
     *
     * @param session The session to remove.
     */
    public void remove(Session session) {
        sessions.remove(session);
    }
}
