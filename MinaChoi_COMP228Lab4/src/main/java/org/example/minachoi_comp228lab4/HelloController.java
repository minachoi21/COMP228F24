package org.example.minachoi_comp228lab4;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class HelloController {
    @FXML private TextField nameField, addressField, provinceField, cityField, postalCodeField, phoneField, emailField;
    @FXML private CheckBox studentCouncilCheckBox, volunteerWorkCheckBox;
    @FXML private RadioButton csRadio, businessRadio;
    @FXML private ComboBox<String> courseComboBox;
    @FXML private ListView<String> courseListView;
    @FXML private TextArea resultTextArea;
    @FXML private ToggleGroup majorGroup;

    @FXML
    public void initialize() {
        this.setCMajor();
        courseComboBox.setOnAction(event -> {
            String selectedCourse = courseComboBox.getValue();
            if (selectedCourse != null && !courseListView.getItems().contains(selectedCourse)) {
                courseListView.getItems().add(selectedCourse);
            }
        });
    }
    @FXML
    private void setCMajor() {
        courseListView.getItems().clear();
        courseComboBox.getItems().clear();
        courseComboBox.getItems().addAll("Java", "C#", "Python");
    }
    @FXML
    private void setBMajor() {
        courseListView.getItems().clear();
        courseComboBox.getItems().clear();
        courseComboBox.getItems().addAll("Economics", "Marketing", "Accounting", "Finance");
    }
    @FXML
    private void displayInfo() {
        StringBuilder info = new StringBuilder();

        info.append(nameField.getText()).append(",")
                .append(addressField.getText()).append(",")
                .append(provinceField.getText()).append(",")
                .append(cityField.getText()).append(",")
                .append(postalCodeField.getText()).append(",")
                .append(phoneField.getText()).append(",")
                .append(emailField.getText()).append("\n");

        String major = csRadio.isSelected() ? "Computer Science" : "Business";
        info.append("Major: ").append(major).append("\n");

        info.append("Courses: ").append(String.join(", ", courseListView.getItems())).append("\n");

        info.append("Activities: ");
        if (studentCouncilCheckBox.isSelected()) info.append("Student Council ");
        if (volunteerWorkCheckBox.isSelected()) info.append("Volunteer Work ");

        resultTextArea.setText(info.toString());
    }
}