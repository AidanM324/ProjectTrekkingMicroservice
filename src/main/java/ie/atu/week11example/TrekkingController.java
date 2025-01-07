package ie.atu.week11example;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/trek")
@RestController
public class TrekkingController {
    private final TrekkingService trekkingService;

    public TrekkingController(TrekkingService trekkingService) {
        this.trekkingService = trekkingService;
    }

    @GetMapping("/{mountainId}")
    public ResponseEntity<?> getMountain(@PathVariable String mountainId) {
        if (mountainId.isBlank()) {
            return ResponseEntity.badRequest().body("Mountain is invalid");
        }

        Mountain mountain = trekkingService.getMountainByMountainId(mountainId);

        if (mountainId == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(mountain);
    }

    @GetMapping("/{mountainRange}")
    public ResponseEntity<?> getMountainRange(@PathVariable String mountainRange) {
        if (mountainRange.isBlank()) {
            return ResponseEntity.badRequest().body("Mountain Range is invalid");
        }

        List<Mountain> mountains = trekkingService.getMountainByMountainRange(mountainRange);

        if (mountainRange == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(mountains);
    }

    @GetMapping("/getAllMountains")
    public ResponseEntity<?> getAllCompanies() {

        List<Mountain> companies = trekkingService.getAllCompanies();

        if (companies == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(companies);
    }

    @PostMapping("/addMountain")
    public ResponseEntity<String>create(@Valid @RequestBody Mountain mountain) {
        trekkingService.saveMountain(mountain);
        return new ResponseEntity<>("Mountain added successfully", HttpStatus.OK);
    }

    @PutMapping("/{Id}")
    public ResponseEntity<String>updateMountain(@PathVariable Long Id, @RequestBody Mountain updatedMountain) {
        trekkingService.updateMountain(Id, updatedMountain);
        return new ResponseEntity<>("Mountain changed successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{Id}")
    public ResponseEntity<String>deleteMountain(@PathVariable Long Id) {
        trekkingService.deleteMountain(Id);
        return new ResponseEntity<>("Mountain deleted successfully", HttpStatus.OK);
    }
}
