package es.upm.miw.apaw.persistence.jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnyClass implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private Integer number;
    private String name;
}
