package com.example.projetoestagioaiko;

import static android.widget.ArrayAdapter.createFromResource;
import static java.util.Locale.filter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.projetoestagioaiko.adapters.LinhaAdapter;
import com.example.projetoestagioaiko.models.Linha;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {
    private RecyclerView recyclerView;
    private LinhaAdapter linhaAdapter;
    private List<Linha> linhaList;
    private List<Linha> filteredLinhaList;
    private SearchView  searchView;
    private Spinner spinnerFilters;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.searchView);
        spinnerFilters = findViewById(R.id.spinnerFilters);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        linhaList = new ArrayList<>();
        linhaList.add(new Linha("123", "Linha A"));
        linhaList.add(new Linha("456", "Linha B"));
        linhaList.add(new Linha("123", "Linha A"));

        linhaAdapter = new LinhaAdapter(linhaList);
        recyclerView.setAdapter(linhaAdapter);
        filteredLinhaList = new ArrayList<>(linhaList);
        linhaAdapter = new LinhaAdapter(filteredLinhaList);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        if(mapFragment != null){
            mapFragment.getMapAsync(this);
        }else {
            Log.e("MainActivity", "mapFragment is null");
        }

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

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        LatLng saoPaulo = new LatLng(-23.5505, -46.6333);
        mMap.addMarker((new MarkerOptions().position(saoPaulo).title("Marker in São Paulo")));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(saoPaulo));
    }

    @SuppressLint("NotifyDataSetChanged")
    private void filter(String query, String filter){
        filteredLinhaList.clear();
        for(Linha linha : linhaList){
            if(linha.getNome().toLowerCase().contains(query.toLowerCase()) &&
            (filter.equalsIgnoreCase("Todos") || linha.getNome().startsWith(filter))){
                filteredLinhaList.add(linha);
            }
        }
        linhaAdapter.notifyDataSetChanged();
    }

}