package ie.atu.week11example;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
public class Mountain {
    public Mountain(Long id, String mountainId, String company, int priceRange, String email, String tripLength, String location, String mountainRange) {
        Id = id;
        this.mountainId = mountainId;
        this.company = company;
        this.priceRange = priceRange;
        this.email = email;
        this.tripLength = tripLength;
        this.location = location;
        this.mountainRange = mountainRange;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getMountainId() {
        return mountainId;
    }

    public void setMountainId(String mountainId) {
        this.mountainId = mountainId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(int priceRange) {
        this.priceRange = priceRange;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTripLength() {
        return tripLength;
    }

    public void setTripLength(String tripLength) {
        this.tripLength = tripLength;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMountainRange() {
        return mountainRange;
    }

    public void setMountainRange(String mountainRange) {
        this.mountainRange = mountainRange;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @NotBlank
    private String mountainId;

    @NotBlank
    private String company;


    private int priceRange;

    @Email
    private String email;

    @NotBlank
    private String tripLength;

    @NotBlank
    private String location;

    @NotBlank
    private String mountainRange;

}
