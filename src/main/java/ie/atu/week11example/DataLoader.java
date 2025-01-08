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
        Mountain testData5 = new Mountain(5L, "Mont Blanc", "Explore Share", 3400, "info@exploreshare.com", "5 days", "France", "Alps");
        Mountain testData6 = new Mountain(6L, "Ben Nevis", "Maximum Adventure", 100, "mail@maximumadventure.com", "1 days", "Scotland", "Western HighLands");
        Mountain testData7 = new Mountain(7L, "Kilimanjaro", "TourCompass", 2800, "info@tourcampass.co.uk", "10 days", "Tanzania", "Rift Mountains");
        Mountain testData8 = new Mountain(8L, "Snowden", "Maximum Adventure", 100, "mail@maximumadventure.com", "1 days", "Wales", "Snowdonia");
        Mountain testData9 = new Mountain(9L, "Matterhorn", "Alpine Ascents", 7250, "Climb@AlpineAscents.com", "3 days", "Switzerland", "French Alps");
        Mountain testData10 = new Mountain(10L, "Mont Blanc", "MuchBetterAdventures", 3285, "muchbetteradventures@gmail.com", "8 days", "France", "Alps");
        mountainRepository.save(testData);
        mountainRepository.save(testData2);
        mountainRepository.save(testData3);
        mountainRepository.save(testData4);
        mountainRepository.save(testData5);
        mountainRepository.save(testData6);
        mountainRepository.save(testData7);
        mountainRepository.save(testData8);
        mountainRepository.save(testData9);
        mountainRepository.save(testData10);
    }

}