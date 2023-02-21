package sk.laa.evidence.source;

import lombok.AllArgsConstructor;
import lombok.Data;
import sk.laa.evidence.enumeration.Gender;

public @AllArgsConstructor
@Data class Client {
    private final String name;
    private final String surname;
    private final Gender gender;
    private final Integer age;
    private final String email;
    private final Integer tel;

    @Override
    public String toString() {
        String tableForm = "%-10S %-12S ; pohlavie: %-5s ; vek: %-3d ; email: %-17s ; tel: %-15d";
        return String.format(tableForm, name, surname, gender, age, email, tel);
    }
}
