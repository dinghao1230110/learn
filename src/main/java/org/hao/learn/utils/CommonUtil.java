package org.hao.learn.utils;

import javax.servlet.http.HttpSession;

public class CommonUtil {
    public static <T extends Object> T getSessionAttribute(HttpSession httpSession, String key) {
        Object obj = httpSession.getAttribute(key);
        T      t   = null;
        try {
            t = (T) obj;
        } catch (Exception e) {
            // ignore
        }
        return t;
    }
}
