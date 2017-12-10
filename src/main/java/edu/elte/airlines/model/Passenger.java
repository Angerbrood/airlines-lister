package edu.elte.airlines.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="PASSENGER")
public class Passenger implements EntityInterface<Integer>, Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


    @Column(name="FIRST_NAME", nullable=false)
    private String firstName;

    @Column(name="LAST_NAME", nullable=false)
    private String lastName;

    @Column(name="AGE", nullable=false)
    private Integer age;

    @Column(name="ADDRESS", nullable=false)
    private String address;

    @Column(name="DATE_OF_BIRTH", nullable=false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfBirth;

    @Column(name="ACCOUNT_NUMBER", nullable=false)
    private String accountNumber;

    @Column(name="BALANCE", nullable=false)
    private long balance;

    @Column(name="EMAIL", nullable=false)
    private String email;

    public Passenger() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static Passenger copyPassenger(Passenger other) {
        Passenger result = new Passenger();
        result.setId(other.getId());
        result.setLastName(other.getLastName());
        result.setFirstName(other.getFirstName());
        result.setDateOfBirth(other.getDateOfBirth());
        result.setBalance(other.getBalance());
        result.setEmail(other.getEmail());
        result.setAccountNumber(other.getAccountNumber());
        result.setAge(other.getAge());
        result.setAddress(other.getAddress());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passenger passenger = (Passenger) o;

        if (balance != passenger.balance) return false;
        if (id != null ? !id.equals(passenger.id) : passenger.id != null) return false;
        if (firstName != null ? !firstName.equals(passenger.firstName) : passenger.firstName != null) return false;
        if (lastName != null ? !lastName.equals(passenger.lastName) : passenger.lastName != null) return false;
        if (age != null ? !age.equals(passenger.age) : passenger.age != null) return false;
        if (address != null ? !address.equals(passenger.address) : passenger.address != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(passenger.dateOfBirth) : passenger.dateOfBirth != null)
            return false;
        if (accountNumber != null ? !accountNumber.equals(passenger.accountNumber) : passenger.accountNumber != null)
            return false;
        return email != null ? email.equals(passenger.email) : passenger.email == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (accountNumber != null ? accountNumber.hashCode() : 0);
        result = 31 * result + (int) (balance ^ (balance >>> 32));
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
