package sk.laa.evidence.source;

import lombok.AllArgsConstructor;
import lombok.Data;

public @AllArgsConstructor
@Data class User {
    private String userName;
    private String userPassword;

    @Override
    public String toString() {
        return String.format("%S,\t  heslo: %s", userName, userPassword);
    }
}
