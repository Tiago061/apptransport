package com.example.projetoestagioaiko.mainActivity;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetoestagioaiko.api.OlhoVivoApiService;
import com.example.projetoestagioaiko.R;
import com.example.projetoestagioaiko.api.RetrofitClient;
import com.example.projetoestagioaiko.models.PontoDeParada;
import com.example.projetoestagioaiko.models.PontosDeParadaResponse;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap googleMap;
    private OlhoVivoApiService olhoVivoApiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.activity_map));

        olhoVivoApiService = RetrofitClient.getClient("https://api.olhovivo.sptrans.com.br/").create(OlhoVivoApiService.class);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if(mapFragment != null){
            mapFragment.getMapAsync(this);
        }


    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        this.googleMap = googleMap;
        carregarPontosDeParada();
    }
    private void carregarPontosDeParada() {
        olhoVivoApiService.obterPontosDeParada().enqueue(new Callback<PontosDeParadaResponse>() {
            @Override
            public void onResponse(Call<PontosDeParadaResponse> call, Response<PontosDeParadaResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    for (PontoDeParada ponto : response.body().getPontos()) {
                        LatLng latLng = new LatLng(ponto.getLatitude(), ponto.getLongitude());
                        googleMap.addMarker(new MarkerOptions()
                                .position(latLng)
                                .title(ponto.getNome()));

                    }
                    if (!response.body().getPontos().isEmpty()) {
                        LatLng centro = new LatLng(response.body().getPontos().get(0).getLatitude(), response.body().getPontos().get(0).getLongitude());
                        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centro, 12));
                    }
                }
            }

            @Override
            public void onFailure(Call<PontosDeParadaResponse> call, Throwable t) {

            }
        });
    }
}


