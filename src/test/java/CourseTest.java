import com.learning.model.Course;
import com.learning.model.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CourseTest {
    @Test
    public void testCourseConstructorAndGetters() {
        Course course = new Course(1, "Introduction to Java", "Telusko", 10, true);

        assertEquals(1, course.getId());
        assertEquals("Introduction to Java", course.getName());
        assertEquals("Telusko", course.getAuthor());
        assertEquals(10, course.getDuration());
        assertTrue(course.isAvailability());
    }


    @Test
    public void testCourseSetters() {
        Course course = new Course();
        course.setId(2);
        course.setName("Metaverse Applications");
        course.setAuthor("Mark");
        course.setDuration(15);
        course.setAvailability(false);

        assertEquals(2, course.getId());
        assertEquals("Metaverse Applications", course.getName());
        assertEquals("Mark", course.getAuthor());
        assertEquals(15, course.getDuration());
        assertFalse(course.isAvailability());
    }
    @Test
    public void testPartialEquality() {
        Course course1 = new Course(1, "Metaverse Applications", "Mark", 10, true);
        Course course2 = new Course(1, "Metaverse Applications", "Mark", 12, true);

        assertFalse(course1.equals(course2));
    }
    @Test
    public void testCourseToString() {
        Course course = new Course(3, "DSA Stack and Queue", "Striver", 20, true);
        String expected = "Course{id=3, name='DSA Stack and Queue', author='Striver', duration=20, availability=true}";
        assertEquals(expected, course.toString());
    }
}


