package ie.atu.week11example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final MountainRepository mountainRepository;


    @Autowired
    public DataLoader(MountainRepository mountainRepository) {
        this.mountainRepository = mountainRepository;
    }

    @Override
    public void run(String... args) throws Exception{
        Mountain testData = new Mountain(1L, "Everest", "RMI Expeditions", 74000, "info@rmiguides.com", "74 days", "Nepal", "Himalayas");
        Mountain testData2 = new Mountain(2L, "Toubkal", "Aztat treks", 500, "aztattreks@gmail.com", "5 days", "Morocco", "Atlas Mountains");
        Mountain testData3 = new Mountain(3L, "Mera", "MuchBetterAdventures", 3800, "muchbetteradventures@gmail.com", "14 days", "Nepal", "Himalayas");
        Mountain testData4 = new Mountain(4L, "Mera", "Trek Central", 4200, "mail@trekcentralpal.com", "19 days", "Nepal", "Himalayas");
        Mountain testData5 = new Mountain(5L, "Mont Blanc", "Explore Share", 3400, "info@exploreshare.com", "5 days", "France", "French Alps");
        mountainRepository.save(testData);
        mountainRepository.save(testData2);
        mountainRepository.save(testData3);
        mountainRepository.save(testData4);
        mountainRepository.save(testData5);
    }

}