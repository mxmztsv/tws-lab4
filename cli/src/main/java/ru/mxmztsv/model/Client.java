package ru.mxmztsv.model;

import lombok.Builder;
import lombok.Data;
import ru.mxmztsv.app.soap.Category;
import ru.mxmztsv.app.soap.Status;

@Data
@Builder
public class Client {
    private Long id;
    private String firstName;
    private String lastName;
    private Status status;
    private Category category;
    private String createdAt;
}
