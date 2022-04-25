package comp3350.fairprice.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import comp3350.fairprice.R;

public class Report extends AppCompatActivity {
// This class mainly shows the policy of app for reporting , not actually a report

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
    }

    // This function will guide to the report page
    public void continues(View v){
        Intent i = new Intent(this, reportPage.class);
        startActivity(i);
    }
}