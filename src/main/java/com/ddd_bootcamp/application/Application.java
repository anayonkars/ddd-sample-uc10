package com.ddd_bootcamp.application;

import com.ddd_bootcamp.domain.Account;
import com.ddd_bootcamp.domain.Address;
import com.ddd_bootcamp.domain.Customer;

/**
 *
 * Code Problem 10:
 * Customer and Bank Account. ( Not related to e-commerce domain)
 * When Customer’s Address is updated, update all her Bank Accounts addresses as well. ( This is invariant, or business rules or consistency rule given by business)
 * --
 * Note –
 * Customer is Entity.  Account is Entity.
 *  Customer has List of bank accounts.
 *  Customer has Address.  Account has Address
 *  Address has one attribute called city.
 *  Address is Value Object
 *  --  customer.updateAddress(new Address(“Mumbai”))
 */

/**
 *
 * Database transactions -  ACID
 *
 * ACID =>  Entity says I will take care of  AC ( Atomic and Consistent).
 * then
 * Entity -> upgrades to -> Aggregate
 *
 * Aggregate and Aggregate root are Customer
 *
 * Aggregate root - Entity which is at top
 *
 *
 */



public class Application {
    public static void main(String[] args) {
        Address address = new Address("Pune");
        Customer customer = new Customer(address);

        Account account = new Account();
        customer.addAccount(account);

        System.out.println("---------------------------------------------------------");
        System.out.println("Before Address Change = " + customer);
        System.out.println("---------------------------------------------------------");

        Address newAddress = new Address("Mumbai");
        //start database transaction
        customer.updateAddress(newAddress);
        //end database transaction

        System.out.println("---------------------------------------------------------");
        System.out.println("After Address Change = " + customer);
        System.out.println("---------------------------------------------------------");
    }
}
