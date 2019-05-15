package collectionTest;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;


public class EmployeeMapTest {

    Employee employee1 = new Employee(1, "John1", "Miller1", "Epam1");
    Employee employee2 = new Employee(2, "John2", "Miller2", "Epam2");
    Employee employee3 = new Employee(3, "John3", "Miller3", "Epam3");
    Employee employee4 = new Employee(3, "John3", "Miller3", "Epam3");


    private Map<Integer, Employee> employees;

    @Before
    public void createMyHashSet() {
        employees = new HashMap<>();
        employees.put(employee1.getId(), employee1);
        employees.put(employee2.getId(), employee2);
    }

    @Test
    public void testIsEmptyForNewMap() {
        assertFalse(employees.isEmpty());
    }


    @Test
    public void testSizeForMap() {
        assertEquals(2, employees.size());
    }

    @Test
    public void testSizeAddNewElementWithExistKey() {
        employees.put(employee3.getId(), employee3);
        assertEquals(3, employees.size());
        employees.put(employee4.getId(), employee4);
        assertEquals(3, employees.size());
    }

    @Test
    public void testGetReturnsCorrectValue() {
        assertEquals(employee1, employees.get(1));
        assertEquals(employee2, employees.get(2));
    }

    @Test
    public void testRemoveDoesNotEffectNewMap() {
        employees.remove(1);

        assertEquals(1, employees.size());
    }

    @Test
    public void testRemoveDeletesElement() {
        employees.put(3, employee3);
        employees.remove(3);
        assertFalse(employees.containsKey(3));

    }


}
