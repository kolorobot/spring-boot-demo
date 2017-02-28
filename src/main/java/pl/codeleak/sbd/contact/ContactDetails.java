package pl.codeleak.sbd.contact;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

// TODO Add validation messages and a ValidationMessages bundle
@Data
public class ContactDetails {

    // @NotBlank(message = "{contact.validation.name-required}")
    private String name;

    // @NotBlank(message = "{contact.validation.email-required}")
    // @Email(message = "{contact.validation.email-valid}")
    private String email;

    // @NotBlank(message = "{contact.validation.message-required}")
    private String message;

}
