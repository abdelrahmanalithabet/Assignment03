package com.mycompany.assignment03;

public class Assignment03 {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("      WELCOME TO JAVA CENTRAL STORE     ");
        System.out.println("========================================\n");

        // Inventory
        Item laptop = new Item("Laptop", 1200.00, 10);
        Item phone = new Item("Smartphone", 800.00, 15);
        Item headphones = new Item("Headphones", 150.00, 20);
        Item mouse = new Item("Mouse", 45.00, 30);
        Item keyboard = new Item("Keyboard", 85.00, 25);

        // 1. Customer 1: Add items & Buy items
        System.out.println("--- Scenario 1: Customer 1 (Add & Buy) ---");
        Customer c1 = new Customer("C01", "Alice");
        Cart cart1 = new Cart("CART-01");
        c1.addCart(cart1);
        cart1.addItem(laptop, 1);
        cart1.addItem(mouse, 2);
        c1.checkout(cart1, "BILL-001");

        // 2. Customer 2: Add, Edit, Remove & Buy
        System.out.println("--- Scenario 2: Customer 2 (Add, Edit, Remove & Buy) ---");
        Customer c2 = new Customer("C02", "Bob");
        Cart cart2 = new Cart("CART-02");
        c2.addCart(cart2);
        cart2.addItem(phone, 2);
        cart2.addItem(headphones, 1);
        cart2.editItemQuantity(phone, 1);
        cart2.removeItem(headphones);
        c2.checkout(cart2, "BILL-002");

        // 3. Customer 3: Add, Edit, Remove, Add & Buy
        System.out.println("--- Scenario 3: Customer 3 (Add, Edit, Remove, Add & Buy) ---");
        Customer c3 = new Customer("C03", "Charlie");
        Cart cart3 = new Cart("CART-03");
        c3.addCart(cart3);
        cart3.addItem(keyboard, 3);
        cart3.addItem(headphones, 2);
        cart3.editItemQuantity(keyboard, 1);
        cart3.removeItem(headphones);
        cart3.addItem(mouse, 2);
        c3.checkout(cart3, "BILL-003");

        // 4. Customer 4: Add, Remove & Didn't Buy
        System.out.println("--- Scenario 4: Customer 4 (Add, Remove & Didn't Buy) ---");
        Customer c4 = new Customer("C04", "Diana");
        Cart cart4 = new Cart("CART-04");
        c4.addCart(cart4);
        cart4.addItem(laptop, 1);
        cart4.removeItem(laptop);
        System.out.println("Customer " + c4.getName() + " left without buying.");
        c4.checkout(cart4, "BILL-004");
    }
}