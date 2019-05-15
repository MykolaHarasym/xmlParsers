package collectionTest;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static junit.framework.TestCase.assertTrue;
import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class EmployeeTest {

    Employee employee1 = new Employee(1, "John1", "Miller1", "Epam1");
    Employee employee2 = new Employee(2, "John2", "Miller2", "Epam2");
    Employee employee3 = new Employee(3, "John3", "Miller3", "Epam3");
    Employee employee4 = new Employee(3, "John3", "Miller3", "Epam3");


    private Set<Employee> employees;

    @Before
    public void createMyHashSet() {
        employees = new HashSet<>();
        employees.add(employee1);
        employees.add(employee2);
    }

    @Test
    public void canAddElementOnlyIfNotExisting() {
        assertTrue(employees.add(employee3));

        // when it's already there i won't be able to insert it
        assertFalse(employees.add(employee3));
    }

    @Test
    public void canNotAddElementIfExist() {
        assertTrue(employees.add(employee3));
        assertFalse(employees.add(employee4));
    }

    @Test
    public void isAbleToClearSet() {
        assertEquals(2, employees.size());
        employees.clear();
        assertEquals(0, employees.size());
    }

    @Test
    public void checkIfItContainsElement() {

        assertTrue(employees.contains(employee1));
        assertTrue(employees.contains(employee2));
        assertFalse(employees.contains(employee3));
        assertFalse(employees.contains(null));
    }

    @Test
    public void checkIfItEmpty() {

        assertFalse(employees.isEmpty());
        employees.clear();
        assertTrue(employees.isEmpty());
    }

    @Test
    public void canProvideAnIterator() {
        Iterator<Employee> stringIterator = employees.iterator();
        assertNotNull(stringIterator);
    }

    @Test
    public void canRemoveObjectFromSet() {

        int setSize = employees.size();
        assertTrue(employees.contains(employee1));
        employees.remove(employee1);
        assertFalse(employees.contains(employee1));
        assertEquals(setSize - 1, employees.size());
    }

}
