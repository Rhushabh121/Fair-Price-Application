package comp3350.fairprice.presentation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;

import android.text.TextUtils;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import comp3350.fairprice.R;

public class payment extends AppCompatActivity {
    AlertDialog.Builder alertBuilder;
    TextInputLayout name;
    TextInputLayout cardNum;
    TextInputLayout exp;
    TextInputLayout CVV;
    TextInputLayout postal;
    int id;
    boolean isRepost;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
//Get all the data from the post
        Intent thisIntent = getIntent();
isRepost=false;
        if (thisIntent != null) {
            String className = thisIntent.getStringExtra("class");
//This is if the intent is from the myListing class
            if (className != null && className.equals("Repost")) {
               Button buy = findViewById(R.id.btnBuyNow);
               username=thisIntent.getStringExtra("username");
                buy.setText("REPOST");
                isRepost=true;
            }
        }


        String price = thisIntent.getStringExtra("price");
        id = thisIntent.getIntExtra("id",0);
        TextView amount = findViewById(R.id.Amount);
        amount.setText(price);
        name = findViewById(R.id.cardNameLayout);
        exp = findViewById(R.id.ExpLayout);
        cardNum = findViewById(R.id.cardNumberLayout);
        CVV = findViewById(R.id.CvvLayout);
        postal = findViewById(R.id.postalLayout);
    }

    public void clickBuyNow(View v) {

        boolean valid = true;
        Intent buyIntent = new Intent(this, MainActivity.class);

        String nameData = name.getEditText().getText().toString().trim();
        String expData = exp.getEditText().getText().toString().trim();
        String cardNumData = cardNum.getEditText().getText().toString().trim();
        String CVVData = CVV.getEditText().getText().toString().trim();
        String postalData = postal.getEditText().getText().toString().trim();

//Make sure each data field is filled with the right information
        if (nameData.length() < 3) {
            Toast.makeText(payment.this, "Name is too short!", Toast.LENGTH_LONG).show();
            valid = false;
        } else if (cardNumData.length() < 16) {
            Toast.makeText(payment.this, "Card Number too short!", Toast.LENGTH_LONG).show();
            valid = false;
        } else if (expData.length() < 4 ) {
            Toast.makeText(payment.this, "Expiration Date is too short!", Toast.LENGTH_LONG).show();
            valid = false;
        } else if (CVVData.length() < 3) {
            Toast.makeText(payment.this, "Security Code (CVV) is too short!", Toast.LENGTH_LONG).show();
            valid = false;
        } else if (postalData.length() < 6) {
            Toast.makeText(payment.this, "Postal Code is too short!", Toast.LENGTH_LONG).show();
            valid = false;
        }

// If the data fields are correct, build an alert
        if (valid) {
            alertBuilder = new AlertDialog.Builder(payment.this);
            alertBuilder.setTitle("Confirm before purchase");
            alertBuilder.setMessage(
                    "Name: " + nameData + "\n" +
                            "Card number: " + expData + "\n" +
                            "Card expiry date: " + cardNumData + "\n" +
                            "Card CVV: " + CVVData + "\n" +
                            "Postal code: " + postalData);

            alertBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                    if(!isRepost){
                        Toast.makeText(payment.this, "Thank you for purchase", Toast.LENGTH_LONG).show();

                        buyIntent.putExtra("class", "Bought");
                        buyIntent.putExtra("id", id);
                        startActivity(buyIntent);
                    }else{
                        Toast.makeText(payment.this, "Item has been Reposted!", Toast.LENGTH_LONG).show();

                        buyIntent.putExtra("class", "Repost");
                        buyIntent.putExtra("id", id);
                        buyIntent.putExtra("username", username);
                        startActivity(buyIntent);
                    }

                }
            });
            alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            AlertDialog alertDialog = alertBuilder.create();
            alertDialog.show();

        }


    }


}