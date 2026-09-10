package com.mycompany.assignment03;

import java.util.ArrayList;

public class Cart {
    private String cartId;
    private ArrayList<CartItem> items;

    public Cart(String cartId) {
        this.cartId = cartId;
        this.items = new ArrayList<>();
    }

    public String getCartId() { return cartId; }
    public ArrayList<CartItem> getItems() { return items; }

    public void addItem(Item item, int quantity) {
        if (!item.isAvailable(quantity)) {
            System.out.println("Insufficient stock for: " + item.getName());
            return;
        }
        for (CartItem ci : items) {
            if (ci.getItem().getName().equalsIgnoreCase(item.getName())) {
                ci.setQuantity(ci.getQuantity() + quantity);
                System.out.println("Added " + quantity + " more " + item.getName() + " to cart.");
                return;
            }
        }
        items.add(new CartItem(item, quantity));
        System.out.println("Added " + quantity + " x " + item.getName() + " to cart.");
    }

    public void editItemQuantity(Item item, int newQuantity) {
        for (CartItem ci : items) {
            if (ci.getItem().getName().equalsIgnoreCase(item.getName())) {
                if (newQuantity <= 0) {
                    removeItem(item);
                } else {
                    ci.setQuantity(newQuantity);
                    System.out.println("Updated " + item.getName() + " quantity to " + newQuantity + ".");
                }
                return;
            }
        }
        System.out.println("Item " + item.getName() + " not found in cart.");
    }

    public void removeItem(Item item) {
        boolean removed = items.removeIf(ci -> ci.getItem().getName().equalsIgnoreCase(item.getName()));
        if (removed) {
            System.out.println("Removed " + item.getName() + " from cart.");
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (CartItem ci : items) {
            total += ci.getTotalPrice();
        }
        return total;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}