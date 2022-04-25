package comp3350.fairprice.presentation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import comp3350.fairprice.R;
import comp3350.fairprice.databinding.ActivityMainBinding;

public class reportPage extends AppCompatActivity {
    // Main report page where users will select options for reporting a listing

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_page);
    }

    // After choosing an report option activity
    public void doneReport(View v){
        Intent intent = new Intent(this, MainActivity.class); // will return user to the main page

        AlertDialog.Builder builder = new AlertDialog.Builder(this); // Pop Up window for confirmation
        AlertDialog.Builder builders = new AlertDialog.Builder(this); // Pop Up window for notifying success report

        builder.setCancelable(true);
        builder.setTitle("You want to report this listing for this reason ?");
        builder.setMessage("Confirmation on reporting Listing");

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            // Pressing Cancel will cancel the Pop Up window and still stay in this page .
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Pressing OK will result in Pop Up message notifying success report and lead back to the main page
                builders.setTitle("Report Success");
                builders.setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        startActivity(intent);
                    }
                });
                AlertDialog alert = builders.create();
                alert.show();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}