package enset.ma.digitalbankingbackend.dtos;

import enset.ma.digitalbankingbackend.enums.OperationType;

import java.util.Date;

public class AccountOperationDTO {
    private String id;
    private Date operationDate;
    private double amount;
    private OperationType type;
}
