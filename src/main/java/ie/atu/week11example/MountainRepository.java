package ie.atu.week11example;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MountainRepository extends JpaRepository<Mountain, Long> {

    Mountain findByMountainId(String mountainId);

    List<Mountain> findByMountainRange(String mountainRange);

    //List<Mountain> findAll(String mountainRange);

    Optional<Mountain> findById(Long Id);
}
