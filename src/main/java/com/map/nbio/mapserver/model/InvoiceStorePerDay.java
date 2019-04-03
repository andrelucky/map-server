package com.map.nbio.mapserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "invoice_store_per_day")
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceStorePerDay {

    @Id
    private String id;
    private Integer date;
    private String storeCode;
    private String storeName;
    private double totalPrice;
    private Integer totalInvoice;
}
