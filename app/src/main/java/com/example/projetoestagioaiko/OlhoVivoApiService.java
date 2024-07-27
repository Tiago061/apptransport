package com.example.projetoestagioaiko;

import com.example.projetoestagioaiko.models.Linha;
import com.example.projetoestagioaiko.models.Parada;
import com.example.projetoestagioaiko.models.PosicaoResponse;
import com.example.projetoestagioaiko.models.PrevisaoResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface OlhoVivoApiService {
    @GET("Posicao")
    Call<PosicaoResponse> getPosicoes(@Header("Authorization")String token);


    @GET("Linha")
    Call<List<Linha>> getLinhas(@Header("Authorization") String token);

    @GET("Parada")
    Call<List<Parada>> getParadas(@Header("Authorization") String token);

    @GET("Previsao")
    Call<PrevisaoResponse> getPrevisao(@Header("Authorization") String Token, @Query("codigoParada") int codigoParada);


}
