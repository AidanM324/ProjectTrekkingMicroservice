package ie.atu.week11example;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/person")
@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getPerson(@PathVariable String employeeId) {
        if (employeeId.length() > 5 || employeeId.isBlank()) {
            return ResponseEntity.badRequest().body("EmployeeId is invalid");
        }

        Mountain mountain = personService.getPersonByEmployeeId(employeeId);

        if (mountain == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(mountain);
    }

    @PostMapping("/createPerson")
    public ResponseEntity<String>create(@Valid @RequestBody Mountain mountain) {
        personService.savePerson(mountain);
        return new ResponseEntity<>("Person created successfully", HttpStatus.OK);
    }
}
