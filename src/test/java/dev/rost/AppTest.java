package dev.rost;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SuppressWarnings("deprecation")
class FieldAccessibilityTest {


    @Test
    @DisplayName("""
            when: #setAccessable(true) for Field metadata
            then: it applies only for this concrete Field obj; another retrieved Field has accessible==false""")
    void test() throws NoSuchFieldException {
        Field id1 = User.class.getDeclaredField("id");

        assertFalse(id1.isAccessible());
        id1.setAccessible(true);
        assertTrue(id1.isAccessible());

        Field id2 = User.class.getDeclaredField("id");
        assertFalse(id2.isAccessible());
    }


    static class User {
        private int id;
    }
}
