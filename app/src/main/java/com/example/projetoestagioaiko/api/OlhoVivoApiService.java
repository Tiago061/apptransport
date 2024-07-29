package com.example.projetoestagioaiko.api;


import com.example.projetoestagioaiko.models.LinhaOnibus;
import com.example.projetoestagioaiko.models.PontosDeParadaResponse;
import com.example.projetoestagioaiko.models.PrevisaoChegada;
import com.example.projetoestagioaiko.models.Veiculo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OlhoVivoApiService {
    @GET("Posicao")
    Call<List<Veiculo>> obterPosicoesVeiculos();

    @GET("Linhas")
    Call<List<LinhaOnibus>> obterLinhas();

    @GET("pontos-de-parada")
    Call<PontosDeParadaResponse> obterPontosDeParada();

    @GET("Previsao")
    Call<List<PrevisaoChegada>> obterPrevisaoChegada(@Query("paradaId") String paradaId);



}
