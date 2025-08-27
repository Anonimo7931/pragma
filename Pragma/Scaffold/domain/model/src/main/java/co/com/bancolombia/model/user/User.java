package co.com.bancolombia.model.user;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class User {
    private Long id;
    private String name;
    private String lastname;
    private Date birthdate;
    private String address;
    private String phone;
    private String email;
    private BigDecimal salary;
}
