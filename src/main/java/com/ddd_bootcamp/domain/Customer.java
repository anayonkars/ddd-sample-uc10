package com.ddd_bootcamp.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * Code Problem 10:
 * Customer and Bank Account. ( Not related to e-commerce domain)
 * When Customer’s Address is updated, update all her Bank Accounts addresses as well.
 * ( This is invariant, or business rules or consistency rule given by business)
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
public class Customer {
    private UUID customerId;
    private Address address;
    private List<Account> accounts = new ArrayList<>();

    public Customer(Address address) {
        this.customerId = UUID.randomUUID();
        this.address = address;
    }

    public void addAccount(Account account) {
        accounts.add(account);
        account.updateAddress(this.address);
    }

    //Logical transaction start
    //When Customer’s Address is updated,
    // update her all Bank Accounts address as well.
    public void updateAddress(Address address) {
        this.address = address;
        accounts.forEach(account -> {
            account.updateAddress(address);
        });
    }
    //Logical transaction end


    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", address=" + address +
                ", accounts=" + accounts +
                '}';
    }
}
