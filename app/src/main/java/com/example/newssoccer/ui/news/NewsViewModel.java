package com.example.newssoccer.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newssoccer.domain.News;

import java.util.ArrayList;
import java.util.List;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<List<News>> news;

    public NewsViewModel() {
        this.news = new MutableLiveData<>();

        List<News> news = new ArrayList<>();
        news.add(new News("Flamengo Vence Palmeiras","Flamengo derrotou nesse sábado os porcos por 4-0"));
        news.add(new News("Flamengo Vence Palmeiras","Flamengo derrotou nesse sábado os porcos por 4-0"));
        news.add(new News("Flamengo Vence Palmeiras","Flamengo derrotou nesse sábado os porcos por 4-0"));

        this.news.setValue(news);
    }

    public LiveData<List<News>> getNews() {
        return this.news;
    }
}