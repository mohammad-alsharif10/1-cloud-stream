package cloud.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface EmployeeRegistrationSource {

    String processorChannel="processorChannel";

    @Output("employeeRegistrationChannel")
    MessageChannel employeeRegistration();

    @Output("employeeRegistrationChannel1")
    MessageChannel employeeRegistration1();


    @Input(processorChannel)
    MessageChannel processorChannel();

}
