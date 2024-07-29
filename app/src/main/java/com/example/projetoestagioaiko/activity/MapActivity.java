package com.example.projetoestagioaiko.activity;


import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projetoestagioaiko.api.Authenticator;
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

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MapActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;
    private OlhoVivoApiService olhoVivoApiService;
    private Authenticator authenticator;
    private static final String TAG = "MapActivity";
    private static final String API_TOKEN = "4c6e18095766ca8f4bfa18a83e538cd5451d4265f3331cd9bc75f190236d3a7b";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.activity_map));

        olhoVivoApiService = RetrofitClient.getClient("https://api.olhovivo.sptrans.com.br/").create(OlhoVivoApiService.class);
        authenticator = new Authenticator(olhoVivoApiService );

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        if(mapFragment != null){
            mapFragment.getMapAsync(this);
        }else {
            Log.e(TAG, "Erro ao carregar o fragmento do mapa");
        }


    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        this.googleMap = googleMap;
        carregarPontosDeParada();
    }
    private void autenticarECarregarPontos() {
        authenticator.authenticate(API_TOKEN, new Authenticator.AuthCallback() {
            @Override
            public void onSucess() {
                Log.d(TAG, "Autenticação bem-sucedida");
                autenticarECarregarPontos();
            }

            @Override
            public void onFailure(Exception e) {
                Log.e(TAG, "Falha na autenticação", e);

            }
        });
    }
    private void carregarPontosDeParada() {
        olhoVivoApiService.obterPontosDeParada().enqueue(new Callback<PontosDeParadaResponse>() {
            @Override
            public void onResponse(Call<PontosDeParadaResponse> call, Response<PontosDeParadaResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    Log.d(TAG,"Resposta recebida: " + response.body().getPontos().size() + " pontos de parada.");
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
                }else {
                    Log.e(TAG,"Resposta falhou: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<PontosDeParadaResponse> call, Throwable t) {
                Log.e(TAG,"Erro na chamada da API: ", t);

            }
        });
    }
}


