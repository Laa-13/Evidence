package sk.laa.evidence.source;

import lombok.AllArgsConstructor;
import lombok.Data;

public @AllArgsConstructor
@Data class User {
    private String userName;
    private String userPassword;

    @Override
    public String toString() {
        String tableForm = "Username: %-10s ; Password: %-12s";
        return String.format(tableForm, userName, userPassword);
    }

}
