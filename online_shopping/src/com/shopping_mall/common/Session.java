package com.shopping_mall.common;

import javax.servlet.http.HttpSession;

public class Session {

    private static final String PERMISSION = "permission";
    private static final String USERID = "userid";

    private HttpSession httpSession = null;
    private static Session session = null;

    public static Session getInstance() {
        if(session == null)
            session = new Session();
        return session;
    }

    public void createSession(HttpSession httpSession,
                              int permission, int userid) {
        if (session.httpSession == null) {
            httpSession.setAttribute(PERMISSION, permission);
            httpSession.setAttribute(USERID, userid);
            // keep session for 24 hours
            httpSession.setMaxInactiveInterval(24 * 60 * 60);
            session.httpSession = httpSession;
        }
    }

    public void closeSession() {
        if (session.httpSession != null)
            session.httpSession = null;
    }

    public int getPermission() {
        if (session.httpSession == null) {
            return 404;
        }
        return (int) session.httpSession.getAttribute(PERMISSION);
    }

    public int getUserid() {
        return (int) session.httpSession.getAttribute(USERID);
    }
}
