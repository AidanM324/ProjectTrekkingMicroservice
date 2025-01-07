package ie.atu.week11example;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // Placeholder method to save a person (add to Db in the next two weeks)
    public void savePerson(Mountain mountain) {
        personRepository.save(mountain);
        System.out.println("Person saved: " + mountain);
    }

    // Placeholder method to retrieve a person by employeeId
    public Mountain getPersonByEmployeeId(String employeeId) {
        // fetch data from a database in future lab
        // For simplicity, we return a dummy person here
        return new Mountain();
    }
}
