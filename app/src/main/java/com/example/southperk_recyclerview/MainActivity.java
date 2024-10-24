package com.example.southperk_recyclerview;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import androidx.appcompat.widget.SearchView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private CharacterAdapter characterAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize the character list with at least 10 characters
        List<Character> characterList = new ArrayList<>();
        characterList.add(new Character("Eric Cartman", "The loud, rude, and often selfish boy.", R.drawable.eric_cartman));
        characterList.add(new Character("Stan Marsh", "The moral and often confused protagonist.", R.drawable.stan_marsh));
        characterList.add(new Character("Kyle Broflovski", "The intelligent and kind-hearted boy, always opposing Cartman.", R.drawable.kyle_broflovski));
        characterList.add(new Character("Kenny McCormick", "The quiet boy who often dies in mysterious ways.", R.drawable.kenny_mccormick));
        characterList.add(new Character("Butters Stotch", "The naive and gullible kid who gets into strange situations.", R.drawable.butters_stotch));
        characterList.add(new Character("Randy Marsh", "Stan's overzealous father with a wild imagination.", R.drawable.randy_marsh));
        characterList.add(new Character("Mr. Garrison", "The eccentric and controversial teacher.", R.drawable.mr_garrison));
        characterList.add(new Character("Wendy Testaburger", "Stan's on-and-off girlfriend and an advocate for social justice.", R.drawable.wendy_testaburger));
        characterList.add(new Character("Chef", "The school chef, known for his wise and humorous advice.", R.drawable.chef));
        characterList.add(new Character("Mr. Mackey", "The school counselor known for his 'm'kay' catchphrase.", R.drawable.mr_mackey));


        // Set up the adapter
        characterAdapter = new CharacterAdapter(characterList);
        recyclerView.setAdapter(characterAdapter);

        // Initialize the SearchView and set up search filtering
        SearchView searchView = findViewById(R.id.searchView);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                characterAdapter.filter(query); // Apply filter on submit
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                characterAdapter.filter(newText); // Apply filter as text changes
                return false;
            }
        });
    }
}