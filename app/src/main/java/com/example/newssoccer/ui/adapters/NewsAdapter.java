package com.example.newssoccer.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newssoccer.databinding.NewsItemsBinding;
import com.example.newssoccer.domain.News;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<News> news;
    public NewsAdapter(List<News> news)
    {
        this.news = news;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        NewsItemsBinding binding = NewsItemsBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        News news  = this.news.get(position);
        holder.binding.tvTittle.setText(news.getTitle());
        holder.binding.tvDescription.setText(news.getDescription());
    }

    @Override
    public int getItemCount() {
        return this.news.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final NewsItemsBinding binding;

        public ViewHolder(NewsItemsBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }

    }
}
