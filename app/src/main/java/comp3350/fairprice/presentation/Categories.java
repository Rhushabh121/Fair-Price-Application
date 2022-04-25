package comp3350.fairprice.presentation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

import comp3350.fairprice.R;
import comp3350.fairprice.objects.Post;

public class Categories extends AppCompatActivity {
    private ArrayList<Post> postList;
    private String selectedFilter = "all";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
    }

    private void filterList (String status){

        Intent categoryIntent = new Intent(this, MainActivity.class);
        categoryIntent.putExtra("class", "Categories");
        categoryIntent.putExtra("status", status);
        startActivity(categoryIntent);

    }



    //all the buttons go to the same database for now
    public void buttonVehiclesExpandAll(View v) {
        filterList("vehicles");

    }

    public void buttonElectronicsExpandAll(View v) {
        filterList("electronics");
    }

    public void buttonVideoGamesExpandAll(View v) {
        filterList("video games");
    }

    public void buttonClothingExpandAll(View v) {
        filterList("clothing");
    }

    public void buttonBooksExpandAll(View v) {
        filterList("books");
    }

    public void buttonFurnituresExpandAll(View v) {
        filterList("furnitures");
    }

    public void buttonMiscExpandAll(View v) {
        filterList("miscellaneous");
    }


}