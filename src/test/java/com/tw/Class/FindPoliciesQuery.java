package com.tw.Class;

import java.time.LocalDate;

/**
 * @author David Tian
 * @desc
 * @since 2020-12-15 21:36
 */
public class FindPoliciesQuery implements Query{

    private String policyNumber;
    private LocalDate policyStartFrom;
    private LocalDate policyStartTo;
    private String carPlateNumber;
    private String policyHolderFirstName;
    private String policyHolderLastName;

}
