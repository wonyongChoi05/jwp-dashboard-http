package org.apache.coyote.http11.auth;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class SessionRepository {

    private static final Map<String, Session> SESSIONS = new ConcurrentHashMap<>();

    public static void create(Session session) {
        SESSIONS.put(session.getId(), session);
    }

    public Optional<Session> getSession(String id) {
        if (id == null) {
            return Optional.ofNullable(null);
        }
        return Optional.ofNullable(SESSIONS.get(id));
    }

}
