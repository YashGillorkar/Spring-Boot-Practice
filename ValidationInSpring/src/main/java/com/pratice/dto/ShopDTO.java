package com.pratice.dto;

import jakarta.validation.constraints.*;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShopDTO {

    @NotEmpty(message = "Product Name cannot be null")
    @Size(min = 2, message = "Name must have at least 2 characters")
    private String productName;

    @NotNull(message = "Price cannot be null")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotEmpty(message = "Remark cannot be null")
    @Size(min = 2, message = "Remark must have at least 2 characters")
    private String remark;
}
