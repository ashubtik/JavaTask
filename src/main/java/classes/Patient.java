package classes;

public class Patient {
    private int id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String diagnosis;
    private String address;
    private String phoneNumber;
    private int medNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getMedNumber() {
        return medNumber;
    }

    public void setMedNumber(int medNumber) {
        this.medNumber = medNumber;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", medNumber=" + medNumber +
                '}';
    }

    public static class Builder {
        private final Patient newPatient;

        public Builder() {
            newPatient = new Patient();
        }

        public Builder withID(int id) {
            newPatient.id = id;
            return this;
        }

        public Builder withFirstName(String firstName) {
            newPatient.firstName = firstName;
            return this;
        }

        public Builder withLastname(String lastname) {
            newPatient.lastName = lastname;
            return this;
        }

        public Builder withMiddleName(String middleName) {
            newPatient.middleName = middleName;
            return this;
        }

        public Builder withDiagnosis(String diagnosis) {
            newPatient.diagnosis = diagnosis;
            return this;
        }

        public Builder withAddress(String address) {
            newPatient.address = address;
            return this;
        }

        public Builder withPhoneNumber(String phoneNumber) {
            newPatient.phoneNumber = phoneNumber;
            return this;
        }

        public Builder withMedNumber(int medNumber) {
            newPatient.medNumber = medNumber;
            return this;
        }

        public Patient build() {
            return newPatient;
        }
    }
}
