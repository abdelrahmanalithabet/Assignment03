package com.mycompany.assignment03;

import java.util.ArrayList;

public class Customer {
    private String customerId;
    private String name;
    private ArrayList<Cart> carts;
    private ArrayList<Bill> bills;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.carts = new ArrayList<>();
        this.bills = new ArrayList<>();
    }

    public String getCustomerId() { return customerId; }
    public String getName() { return name; }
    public ArrayList<Cart> getCarts() { return carts; }
    public ArrayList<Bill> getBills() { return bills; }

    public void addCart(Cart cart) {
        carts.add(cart);
    }

    public Bill checkout(Cart cart, String billId) {
        if (cart.isEmpty()) {
            System.out.println("Cart is empty for " + name + ". Purchase canceled — no bill generated.\n");
            return null;
        }
        Bill bill = new Bill(billId, cart);
        bills.add(bill);
        bill.printBill(name);
        return bill;
    }
}