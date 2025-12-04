package universityenrollmentsystem;

import org.junit.Test;
import static org.junit.Assert.*;

public class WestminsterEnrollmentManagerTest {
        @Test
        public void testAddPersonToListWithinLimit(){
            WestminsterEnrollmentManager manager = new WestminsterEnrollmentManager(2);
            Student student = new Student("Delaksan","Sritharan");
            student.setID("S001");
            student.setCourseTitle("Computing");
            student.setModulesEnrolled(3);

            manager.addPersonToList(student);
            assertEquals(1,manager.personList.size());
            assertTrue(manager.personList.contains(student));
        }

        @Test
        public void testAddPersonToListOverLimit(){
            WestminsterEnrollmentManager manager = new WestminsterEnrollmentManager(2);

            Student s1 = new Student("A","B");
            Student s2 = new Student("C","D");

            manager.addPersonToList(s1);
            manager.addPersonToList(s2);

            Student s3 = new Student("E","F");
            manager.addPersonToList(s3);

            assertEquals(2,manager.personList.size());
            assertTrue(manager.personList.contains(3));
        }
}