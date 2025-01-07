package ie.atu.week11example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Mountain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @NotBlank
    private String mountain;

    @NotBlank
    private String company;

    @NotBlank
    private int priceRange;

    @Email
    private String email;

    @NotBlank
    private String title;

    @NotBlank
    private String employeeId;

    @NotBlank
    private String position;

    @NotBlank
    private String department;

}
