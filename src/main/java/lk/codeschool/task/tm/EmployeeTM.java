package lk.codeschool.task.tm;

import javafx.scene.control.Button;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeTM {
    private String name;
    private String type;
    private String gender;
    private LocalDate birthDay;
    private Button option;
}
