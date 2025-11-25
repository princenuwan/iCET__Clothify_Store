package model.dto;

import model.enums.PaymentMethod;

public class InvoiceDTO {
    private String id;
    private String saleId;
    private String saleItemId;
    private PaymentMethod paymentMethod;
}
