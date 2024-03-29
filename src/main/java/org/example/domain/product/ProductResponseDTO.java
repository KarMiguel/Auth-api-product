package org.example.domain.product;

public record ProductResponseDTO(String id, String name, Double price) {
    public ProductResponseDTO(Product product){
        this(product.getId(), product.getName(), product.getPrice());
    }
}
