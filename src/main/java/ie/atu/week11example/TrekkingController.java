package ie.atu.week11example;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/trek")
@RestController
public class TrekkingController {
    private final TrekkingService trekkingService;

    public TrekkingController(TrekkingService trekkingService) {
        this.trekkingService = trekkingService;
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<?> getPerson(@PathVariable String employeeId) {
        if (employeeId.length() > 5 || employeeId.isBlank()) {
            return ResponseEntity.badRequest().body("EmployeeId is invalid");
        }

        Mountain mountain = trekkingService.getPersonByEmployeeId(employeeId);

        if (mountain == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(mountain);
    }

    @PostMapping("/addMountain")
    public ResponseEntity<String>create(@Valid @RequestBody Mountain mountain) {
        trekkingService.savePerson(mountain);
        return new ResponseEntity<>("Mountain added successfully", HttpStatus.OK);
    }
}
