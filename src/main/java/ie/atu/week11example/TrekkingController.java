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

    @GetMapping("/{mountain}")
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

    @PostMapping("/addMountain")
    public ResponseEntity<String>create(@Valid @RequestBody Mountain mountain) {
        trekkingService.saveMountain(mountain);
        return new ResponseEntity<>("Mountain added successfully", HttpStatus.OK);
    }
}
