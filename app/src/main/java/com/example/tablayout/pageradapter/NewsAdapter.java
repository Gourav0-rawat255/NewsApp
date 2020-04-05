package com.example.tablayout.pageradapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.tablayout.R;
import com.example.tablayout.Response;
import com.example.tablayout.model.Article;
import com.example.tablayout.model.Example;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private ArrayList<Article> articleArrayList;
    Context mcontext;


    public NewsAdapter(ArrayList<Article> articleArrayList, Context context) {
        this.articleArrayList = articleArrayList;
        this.mcontext = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mcontext);
        View view = inflater.inflate(R.layout.news,parent,false);

        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
       holder.title.setText(articleArrayList.get(position).getTitle());
       final String title = articleArrayList.get(position).getTitle();
       final String content = articleArrayList.get(position).getContent();
       final String newsurl = articleArrayList.get(position).getUrl();


        final String url= articleArrayList.get(position).getUrlToImage();
        Glide.with(mcontext)
                .load(url)
                .into(holder.image);

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mcontext,Response.class);
                intent.putExtra("newsurl",newsurl);
                mcontext.startActivity(intent);


            }
        });


    }

    @Override
    public int getItemCount() {
        return articleArrayList.size();
    }


    public class NewsViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView title;
        LinearLayout layout;

      public NewsViewHolder(@NonNull View itemView) {
          super(itemView);
          image = itemView.findViewById(R.id.image);
          title = itemView.findViewById(R.id.title);
          layout=itemView.findViewById(R.id.layout);

      }

  }


}