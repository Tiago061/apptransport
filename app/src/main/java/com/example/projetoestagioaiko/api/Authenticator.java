package com.example.projetoestagioaiko.api;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Authenticator {
    private OlhoVivoApiService apiService;

    public Authenticator(OlhoVivoApiService apiService) {
        this.apiService = apiService;
    }

    public void authenticate(String token, final AuthCallback callback){
        apiService.autenticar(token).enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                   callback.onSucess();
                }
                callback.onFailure(new Exception("Falha na autenticação: "+ response.message()));
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                callback.onFailure(new Exception("Erro na autenticação: ", t));

            }
        });
    }

    public interface AuthCallback {
        void onSucess();
        void onFailure(Exception e);
    }
}
