package cloud.stream;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
@EnableBinding(EmployeeRegistrationSource.class)
public class EmployeeRegistrationController {

    EmployeeRegistrationSource employeeRegistrationSource;

    public EmployeeRegistrationController(EmployeeRegistrationSource employeeRegistrationSource) {
        this.employeeRegistrationSource = employeeRegistrationSource;
    }

    @RequestMapping("register")
    @ResponseBody
    public String orderFood(@RequestBody Employee employee) {
        employeeRegistrationSource.employeeRegistration().send(MessageBuilder.withPayload(employee).build());
        System.out.println(employee.toString());
        return "Employee Registered";
    }

    @RequestMapping("register1")
    @ResponseBody
    public String orderFood1(@RequestBody Employee employee) {
        employeeRegistrationSource.employeeRegistration1().send(MessageBuilder.withPayload(employee).build());
        System.out.println(employee.toString());
        return "Employee Registered1";
    }

    @StreamListener(target = EmployeeRegistrationSource.processorChannel)
    public void processRegisterEmployees1(Employee employee) {
        System.out.println("Employees Registered by Client " + employee.getEmpName());
    }
}

