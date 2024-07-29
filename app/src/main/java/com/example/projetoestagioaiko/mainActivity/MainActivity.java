package com.example.projetoestagioaiko.mainActivity;

import static java.util.Locale.filter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.projetoestagioaiko.R;
import com.example.projetoestagioaiko.adapters.LinhaOnibusAdapter;
import com.example.projetoestagioaiko.models.LinhaOnibus;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private LinhaOnibusAdapter linhasAdapter;
    private List<LinhaOnibus> linhaList = new ArrayList<>();
    private List<LinhaOnibus> filteredLinhaList = new ArrayList<>();
    private SearchView  searchView;
    private Spinner spinnerFilters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_open_map).setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });


        recyclerView = findViewById(R.id.recycler_view_linhas);
        searchView = findViewById(R.id.searchView);
        spinnerFilters = findViewById(R.id.spinnerFilters);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        linhasAdapter = new LinhaOnibusAdapter(linhaList);
        recyclerView.setAdapter(linhasAdapter);
        filteredLinhaList = new ArrayList<>(linhaList);
        linhasAdapter = new LinhaOnibusAdapter(filteredLinhaList);


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filter(query, spinnerFilters.getSelectedItem().toString());
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText, spinnerFilters.getSelectedItem().toString());
                return true;
            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.filter_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinnerFilters.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                filter(searchView.getQuery().toString(), parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    @SuppressLint("NotifyDataSetChanged")
    private void filter(String query, String filter){
        filteredLinhaList.clear();
        for(LinhaOnibus linha : linhaList){
            if(linha.getNome().toLowerCase().contains(query.toLowerCase()) &&
            (filter.equalsIgnoreCase("Todos") || linha.getNome().startsWith(filter))){
                filteredLinhaList.add(linha);
            }
        }
        linhasAdapter.notifyDataSetChanged();
    }

}