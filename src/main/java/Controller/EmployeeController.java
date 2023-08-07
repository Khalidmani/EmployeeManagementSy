package Controller;

import Exception2.ResourceNotFoundException;
import Model.Employee;
import Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping ("api/v2/")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping("/Employee")

    public List<Employee> viewEmployee(){
        return employeeRepository.findAll();
    }

    @PostMapping("/Employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);

    }

    @GetMapping("/Employee/{id}")
    public ResponseEntity<Employee> getEmployeeByID(@PathVariable int id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid Id: " + id));
        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String,Boolean>> deleteEmployee(@PathVariable int id)
    {
        Employee employee = employeeRepository.findById(id)

                .orElseThrow(() -> new ResourceNotFoundException("Invalid Id: "+id));

        employeeRepository.delete(employee);

        Map<String,Boolean> response = new HashMap<>();
        response.put("course was Deleted : ",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee)
    {

        Employee employee1 = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Invalid Id: "+id));

        employee1.setEmployee_Name(employee1.getEmployee_Name());
        employee1.setAddress(employee1.getAddress());
        employee1.setId(employee1.getId());

        // saving the new values

        return ResponseEntity.ok(employeeRepository.save(employee1));
    }

}

