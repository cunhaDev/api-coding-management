package sistema.api.desenvolvimento.api.gerencimento.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import java.lang.String;

@Getter
@AllArgsConstructor

public enum PhoneType {

    COMMERCIAL ("Commercial"),
    HOME ("Home"),
    MOBILE ("Mobile");

    private final String description;
}
