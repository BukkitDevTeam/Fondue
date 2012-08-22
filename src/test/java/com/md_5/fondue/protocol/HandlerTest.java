package com.md_5.fondue.protocol;

import java.lang.reflect.Method;
import static org.junit.Assert.*;
import org.junit.Test;

public class HandlerTest {

    /**
     * Method to test each handler type defines everything it requires
     */
    @Test
    public void doTest() throws NoSuchMethodException {
        check(new ServerHandler());
    }

    private void check(PacketHandler handler) throws NoSuchMethodException {
        checkImplements(handler);
        checkExcludes(handler);
    }

    /**
     * Checks that the specified handler DOES implement the required methods
     */
    public void checkImplements(PacketHandler handler) throws NoSuchMethodException {
        for (Method m : PacketHandler.class.getDeclaredMethods()) {
            if (m.isAnnotationPresent(handler.getType())) {
                getOther(m, handler.getClass());
            }
        }
    }

    /**
     * Checks that the specified handler DOES NOT implement methods from other
     * handler types
     */
    public void checkExcludes(PacketHandler handler) throws NoSuchMethodException {
        for (Method m : handler.getClass().getDeclaredMethods()) {
            Method parent = getOther(m, PacketHandler.class);
            if (parent.getAnnotations().length > 0) {
                assertTrue(m + " includes type not suitable for " + handler.getType().getSimpleName(), parent.isAnnotationPresent(handler.getType()));
            }
        }
    }

    private Method getOther(Method method, Class other) throws NoSuchMethodException {
        return other.getDeclaredMethod(method.getName(), method.getParameterTypes());
    }
}
