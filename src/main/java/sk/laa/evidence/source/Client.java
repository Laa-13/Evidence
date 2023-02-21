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
        return String.format("%S %S,\t\t\t  pohlavie: %s,\t vek: %d,\t email: %s,\t tel: %d", name, surname, gender, age, email, tel);
    }
}
