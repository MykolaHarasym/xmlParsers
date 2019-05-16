package letscode.xmlParser.service;

import letscode.xmlParser.entity.Employee;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DaoUserServiceRepository implements DaoUserService {

    private static Map<Long, Employee> user = new HashMap<>();

    public Employee getUser(Long id) {
      return user.get(id);
    }

    public Long saveUser(Employee employee) {
        // autogenarate id
         user.put(counter, employee);
        counter++;
        return counter;
    }
}
