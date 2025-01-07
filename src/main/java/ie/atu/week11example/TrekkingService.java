package ie.atu.week11example;

import org.springframework.stereotype.Service;

@Service
public class TrekkingService {
    private MountainRepository mountainRepository;

    public TrekkingService(MountainRepository mountainRepository) {
        this.mountainRepository = mountainRepository;
    }

    // Placeholder method to save a person (add to Db in the next two weeks)
    public void saveMountain(Mountain mountain) {
        mountainRepository.save(mountain);
        System.out.println("Mountain saved: " + mountain);
    }

    // Placeholder method to retrieve a person by employeeId
    public Mountain getMountainByMountainId(String mountainId) {
        // fetch data from a database in future lab
        // For simplicity, we return a dummy person here
        return new Mountain();
    }

}
