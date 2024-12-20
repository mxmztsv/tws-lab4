package ru.mxmztsv.app.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.mxmztsv.model.Category;
import ru.mxmztsv.model.Status;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDto {
    private int id;
    private String firstName;
    private String lastName;
    private Status status;
    private Category category;
    private String createdAt;
}
