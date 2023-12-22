package com.blogging.blogappapis.payloads;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    @NotNull
    private Integer categoryId;

    @NotNull
    private String categoryTitle;

    @NotNull
    private String categoryDescription;
}
