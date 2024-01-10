package GGD;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Scheduler {
    private String fileName;

    public Scheduler(String fileName) {
        this.fileName = fileName;
    }

    public void createAppointment(int bsn, LocalDateTime dateTime) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy:HH.mm");
        String formattedDateTime = dateTime.format(formatter);

        String appointment = bsn + "; " + formattedDateTime;

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(appointment);
            writer.newLine();
            System.out.println("Appointment added: " + appointment);
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("An error occurred while adding the appointment: " + e.getMessage());
        }



    }

    
}
