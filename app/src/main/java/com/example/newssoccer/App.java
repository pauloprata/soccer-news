package com.example.newssoccer;

import android.app.Application;
/**
 * FIXME Centralizamos uma instância do contexto em nosso {@link App} (mesmo sendo um "anti-pattern") para extrairmos o máximo dos nossos
 * ViewModels e camada de acesso à dados. Entretanto, apesar das nossas camadas ficarem mais coesas, o ideal seria usar uma solução de
 * injeção de dependências (como o Dagger ou o Hilt).
 */
public class App extends Application {

    private static App instance;

    public static App getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
