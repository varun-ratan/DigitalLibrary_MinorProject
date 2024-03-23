package com.digitalLibrary.springboot.dtos;

import com.digitalLibrary.springboot.entities.Student;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateStudentRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String contact;

    public Student to()
    {
        return Student.builder()
                .name(name)
                .contact(contact)
                .validity(new Date(System.currentTimeMillis()+31536000000l))
                .build();
    }

}
