package dev.nidhi.fakestoreapis.dtos.userDTO;

import dev.nidhi.fakestoreapis.models.Name;
import lombok.Data;

@Data
public class NameDTO {
    private String firstname;
    private String lastname;

    public static NameDTO from(Name name) {
        NameDTO nameDTO = new NameDTO();
        nameDTO.setFirstname(name.getFirstname());
        nameDTO.setLastname(name.getLastname());
        return nameDTO;
    }

    public static Name toName(NameDTO name) {
        Name nameDTO = new Name();
        nameDTO.setFirstname(name.getFirstname());
        nameDTO.setLastname(name.getLastname());
        return nameDTO;
    }
}
