package com.example.newssoccer.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newssoccer.R;
import com.example.newssoccer.databinding.NewsItemsBinding;
import com.example.newssoccer.domain.News;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private final List<News> news;
    private final NewsFavorite favoriteListenner;




    public NewsAdapter(List<News> news, NewsFavorite favoriteListenner)
    {
        this.news = news;
        this.favoriteListenner = favoriteListenner;

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
        Context context = holder.itemView.getContext();
        News news  = this.news.get(position);
        holder.binding.tvTitle.setText(news.title);
        holder.binding.tvDescription.setText(news.description);
        Picasso.get().load(news.image).fit().into(holder.binding.ivThumbnail);
        //Implementação da funcionalidade abrir link
        holder.binding.btOpenLink.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(news.link));
            holder.itemView.getContext().startActivity(intent);
        });
        //Implementação da funcionalidade compartilhar
        holder.binding.ivShare.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, news.title);
            intent.putExtra(Intent.EXTRA_TEXT,news.link);
            holder.itemView.getContext().startActivity(Intent.createChooser(intent, "share"));
        });
         holder.binding.ivFavorite.setOnClickListener(view -> {
             news.favorite = !news.favorite;
             this.favoriteListenner.click(news);
             notifyItemChanged(position);
         });

        int favoriteColor = news.favorite ? R.color.favorite_active : R.color.favorite_inactive;
        holder.binding.ivFavorite.setColorFilter(context.getResources().getColor(favoriteColor));
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
    public interface NewsFavorite{
        void click(News news);
    }
}
