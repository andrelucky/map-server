package com.map.nbio.mapserver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "invoice")
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {

    @Id
    private String id;
    private String number;
    private Integer date;
    private String storeCode;
    private String storeName;
    private double totalPrice;
    private Date createdDate;
    private List<InvoiceDetail> invoiceDetails;
}
