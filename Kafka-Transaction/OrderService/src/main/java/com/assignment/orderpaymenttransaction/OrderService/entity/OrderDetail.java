package com.assignment.orderpaymenttransaction.OrderService.entity;


//@Entity
/**
 * This class is just a stub, will not be saving to database with this application
 */
public class OrderDetail {
    /**
     * @Id
     * @GeneratedValue(strategy = IDENTITY)
     */
    private int order_number;
    /**
     * Potentially an Item object with name, image, ASIN, Model_Number,Brand, Weight, Dimention,...,
     * For now it is a String.
     */
    private String order_items;

    private float total_amount;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "order_number=" + order_number +
                ", order_items='" + order_items + '\'' +
                ", total_amount=" + total_amount +
                '}';
    }

    public OrderDetail() {
    }

    public OrderDetail(int order_number, String order_items, float total_amount) {
        this.order_number = order_number;
        this.order_items = order_items;
        this.total_amount = total_amount;
    }

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public String getOrder_items() {
        return order_items;
    }

    public void setOrder_items(String order_items) {
        this.order_items = order_items;
    }

    public float getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(float total_amount) {
        this.total_amount = total_amount;
    }
}
