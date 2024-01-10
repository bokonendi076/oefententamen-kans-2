package GUI;

import javafx.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GeneratorGUI extends Application {
    TextField passLength = new TextField();
    RadioButton radioButton = new RadioButton("Special characters");
    RadioButton capitalsButton = new RadioButton("Capitals");
    TextField yourPassword = new TextField();
    Label passStrength = new Label("Strength: ");
    Button generatePass = new Button("Generate");


    @Override
    public void start(Stage stage) {
        stage.setTitle("Password Generator");

        // button styling
        passLength.setText("Input desired length");
        generatePass.setStyle("-fx-background-color: lightblue;");

        VBox vbox1 = new VBox(new Label(), passLength, radioButton, capitalsButton);
        VBox vbox2 = new VBox(new Label(), yourPassword, passStrength, generatePass);

        // set vbox padding
        vbox1.setPadding(new Insets(0, 30, 0, 30));
        vbox1.setMargin(passLength, new Insets(0, 0, 10, 0));
        vbox2.setMargin(yourPassword, new Insets(0, 0, 10, 0));
        vbox2.setMargin(passStrength, new Insets(0, 0, 10, 0));

        // Create an HBox and add the VBoxes to it
        HBox hbox = new HBox(vbox1, vbox2);

        // Create a Scene with the HBox as the root node
        Scene scene = new Scene(hbox, 400, 200);




        generatePass.setOnAction(event -> {
            // Perform the desired action when the button is clicked
            System.out.println("Generate button clicked!");
            passStrength.setText("Strength: " + passwordStrength().toString()); 
            yourPassword.setText(generatePassword().toString());
            
        });

        stage.setScene(scene);
        stage.show();
    }

    public String generatePassword() {
        int passLength = Integer.parseInt(this.passLength.getText());
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < passLength; i++) {
            char randomChar = (char) (35 + Math.random() * (122 - 35 + 1));

            password.append(randomChar);
        }

        return password.toString();

    }

    public String passwordStrength() {
        int passLength = Integer.parseInt(this.passLength.getText());
        boolean radioButtonSelected = this.radioButton.isSelected();
        boolean capitalsButtonSelected = this.capitalsButton.isSelected();

        if (passLength < 8 || !radioButtonSelected && !capitalsButtonSelected) {
            return "zwak";

        } else if(passLength >= 8 && radioButtonSelected && !capitalsButtonSelected || passLength >= 8 && capitalsButtonSelected && !radioButtonSelected) {
            return "Matig";

        } else if (passLength >= 8 && radioButtonSelected && capitalsButtonSelected) {
            return "Sterk";
        }

        return "incorrect syntax, try again...";
    }


}
