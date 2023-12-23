package com.blogging.blogappapis.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

    @NotBlank
    @NotNull
    private Integer categoryId;

    @NotBlank
    @NotNull
    @Size(min = 4, message = "Minimum size of category is 4 ")
    private String categoryTitle;

    @NotBlank
    @NotNull
    @Size(min = 10, message = "Minimum size of category is 10")
    private String categoryDescription;
}
