package com.md_5.fondue.protocol;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import org.junit.Test;
import static org.junit.Assert.*;

public class HandlerTest {

    /**
     * Method to test each handler type defines everything it requires
     */
    @Test
    public void doTest() throws NoSuchMethodException {
        checkImplements(new ServerHandler());
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

    private Method getOther(Method method, Class other) throws NoSuchMethodException {
        return other.getDeclaredMethod(method.getName(), method.getParameterTypes());
    }
}
