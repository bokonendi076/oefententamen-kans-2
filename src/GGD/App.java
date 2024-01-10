package GGD;

import java.time.LocalDateTime;

public class App {
    
    public static void main(String[] args) {
        Scheduler newAppointment = new Scheduler("appointments.txt");

        newAppointment.createAppointment(12345678, LocalDateTime.of(2024, 12, 20, 10, 55));
    }
}
