package ie.atu.week11example;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrekkingService {
    private final MountainRepository mountainRepository;

    public TrekkingService(MountainRepository mountainRepository) {
        this.mountainRepository = mountainRepository;
    }

    public List<Mountain> getAllCompanies() {
        return mountainRepository.findAll();
    }
    // Placeholder method to save a person (add to Db in the next two weeks)
    public void saveMountain(Mountain mountain) {
        mountainRepository.save(mountain);
        System.out.println("Mountain saved: " + mountain);
    }

    // Placeholder method to retrieve a person by employeeId
    public List<Mountain> getMountainByMountainId(String mountainId) {
        // fetch data from a database in future lab
        // For simplicity, we return a dummy person here
        return mountainRepository.findByMountainId(mountainId);
    }

    public List<Mountain> getMountainByMountainRange(String mountainRange) {
        // fetch data from a database in future lab
        // For simplicity, we return a dummy person here
        //return mountainRepository.findByMountainRange(mountainRange);
        return mountainRepository.findByMountainRange(mountainRange);
    }

    public void updateMountain(Long Id, Mountain updatedMountain){
        Optional<Mountain> existingMountainOptional = mountainRepository.findById(Id);

        if(existingMountainOptional.isPresent()){
            Mountain existingMountain = existingMountainOptional.get();

            //update fields with the new data
            existingMountain.setMountainId(updatedMountain.getMountainId());
            existingMountain.setCompany(updatedMountain.getCompany());
            existingMountain.setPriceRange(updatedMountain.getPriceRange());
            existingMountain.setEmail(updatedMountain.getEmail());
            existingMountain.setTripLength(updatedMountain.getTripLength());
            existingMountain.setLocation(updatedMountain.getLocation());
            existingMountain.setMountainRange(updatedMountain.getMountainRange());
            mountainRepository.save(existingMountain);
        }
        else {
            //Handle not found scenario
        }
    }

    public void deleteMountain(Long Id){
        mountainRepository.deleteById(Id);
    }

}
