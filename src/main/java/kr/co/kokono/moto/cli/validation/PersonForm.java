package kr.co.kokono.moto.cli.validation;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter @Setter
@AllArgsConstructor
public class PersonForm {

    @NotNull
    @Size(max = 64)
    private String name;

    @Min(0)
    private int age;
}
