package com.clrlss.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        createOrderSummary(quantity);
        displayMessage(priceMessage);

    }

    public void increment(View view) {

        quantity++;

        displayQuantity(quantity);

    }

    public void decrement(View view) {

        if (quantity > 0) {
            quantity--;
        }

        displayQuantity(quantity);

    }

    private int calculatePrice(int quantity, int price) {

        return quantity * price;

    }

    private String createOrderSummary(int price){
        String line01 = "Name: Kaptain Kunal";
        String line02 = "Quantity: " + quantity;
        String line03 = "Total: $" + calculatePrice(quantity, 5);
        String line04 = "Thank You!";
        String priceMessage = line01 + "/n" + line02 + "/n" + line03 + "/n" + line04;
        return priceMessage;
    }



    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

}
