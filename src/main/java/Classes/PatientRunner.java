package Classes;

import java.util.Scanner;

public class PatientRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Patient[] patientsList = patientInList();
        System.out.print("Insert diagnosis: ");
        String diagnosis = scanner.next();
        checkDiagnosis(patientsList, diagnosis);
        System.out.println("Insert medNumber: ");
        System.out.print("From ");
        int a = scanner.nextInt();
        System.out.print("To ");
        int b = scanner.nextInt();
        checkMedCard(patientsList, a, b);

        scanner.close();
    }
    static Patient[] patientInList() {
        Patient John = new Patient.Builder()
                .withID(0)
                .withFirstName("John")
                .withLastname("Travolta")
                .withMiddleName("Jr.")
                .withDiagnosis("Headache")
                .withAddress("Boston")
                .withPhoneNumber("47541")
                .withMedNumber(7)
                .build();
        Patient Tony = new Patient.Builder()
                .withID(1)
                .withFirstName("Antony")
                .withLastname("Hopkins")
                .withMiddleName("B.")
                .withDiagnosis("Heartache")
                .withAddress("NewOrleans")
                .withPhoneNumber("76441")
                .withMedNumber(56)
                .build();
        Patient Kolya = new Patient.Builder()
                .withID(3)
                .withFirstName("Nicolas")
                .withLastname("Cage")
                .withMiddleName("D.")
                .withDiagnosis("Flue")
                .withAddress("Seattle")
                .withPhoneNumber("45441")
                .withMedNumber(5693)
                .build();
        Patient Sam = new Patient.Builder()
                .withID(4)
                .withFirstName("Samuel")
                .withLastname("Jackson")
                .withMiddleName("L.")
                .withDiagnosis("Heartache")
                .withAddress("Louisville")
                .withPhoneNumber("45961")
                .withMedNumber(458)
                .build();
        Patient[] array = new Patient[4];
        array[0] = John;
        array[1] = Tony;
        array[2] = Kolya;
        array[3] = Sam;

        return array;
    }

    static void checkDiagnosis(Patient[] patients, String diagnosis) {
        for (Patient patient : patients) {
            if (patient.getDiagnosis().equals(diagnosis)) {
                System.out.println(patient);
            }
        }
        System.out.println();
    }

    static void checkMedCard(Patient[] patients, int from, int to) {
        for (Patient patient : patients) {
            if (patient.getMedNumber() >= from && patient.getMedNumber() <= to) {
                System.out.println(patient);
            }
        }
    }
}
