package com.mycompany.assignment03;

public class Bill {
    private String billId;
    private Cart cart;
    private double totalAmount;

    public Bill(String billId, Cart cart) {
        this.billId = billId;
        this.cart = cart;
        this.totalAmount = cart.calculateTotal();
    }

    public String getBillId() { return billId; }
    public Cart getCart() { return cart; }
    public double getTotalAmount() { return totalAmount; }

    public void printBill(String customerName) {
        System.out.println("========================================");
        System.out.println("          JAVA CENTRAL INVOICE          ");
        System.out.println("Bill ID: " + billId);
        System.out.println("Customer: " + customerName);
        System.out.println("----------------------------------------");
        System.out.printf("%-15s %-10s %-8s %-10s%n", "Item", "Price", "Qty", "Subtotal");
        System.out.println("----------------------------------------");
        for (CartItem ci : cart.getItems()) {
            ci.getItem().reduceStock(ci.getQuantity());
            System.out.printf("%-15s $%-9.2f %-8d $%-10.2f%n",
                    ci.getItem().getName(),
                    ci.getItem().getPrice(),
                    ci.getQuantity(),
                    ci.getTotalPrice());
        }
        System.out.println("----------------------------------------");
        System.out.printf("TOTAL AMOUNT TO PAY: $%.2f%n", totalAmount);
        System.out.println("========================================\n");
    }
}