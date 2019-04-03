package com.map.nbio.mapserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "stock")
@AllArgsConstructor
@NoArgsConstructor
public class Stock {

    @Id
    private String id;
    private String itemCode;
    private Integer stock;
}
