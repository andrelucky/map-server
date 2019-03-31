package com.map.nbio.mapserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDetail {

//    @Id
//    private long id;
    private String itemCode;
    private String itemName;
    private Double price;
    private Integer quantity;
    private Double totalPrice;

}
