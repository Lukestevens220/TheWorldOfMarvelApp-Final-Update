package appexperts.com.theworldofmarvelapp.character;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import appexperts.com.theworldofmarvelapp.R;
import appexperts.com.theworldofmarvelapp.models.Hero;

/**
 * Created by TheAppExperts on 03/11/2016.
 */

public class CharacterAdapter extends RecyclerView.Adapter {

    private Context context;
    ArrayList<Hero.Data.Result> comics;

    public CharacterAdapter(Context context, List<Hero.Data.Result> comicList){
        this.context = context;
        comics = (ArrayList<Hero.Data.Result>) comicList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comic_item, parent, false);
        return new ComicViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        Hero.Data.Result comic = comics.get(position);
        ComicViewHolder holder = (ComicViewHolder) viewHolder;
//        holder.comicId.setText(comic.get());
        holder.id.setText(comic.getId().toString());
        holder.description.setText(comic.getDescription());
        holder.title.setText(comic.getName());
        Picasso.with(context).load(comic.getResourceURI()).into(holder.comicImageView);

    }

    @Override
    public int getItemCount() {
        return comics.size();
    }

    public static class ComicViewHolder extends RecyclerView.ViewHolder{

        public ImageView comicImageView;
//        public TextView comicId;
        public TextView id;
        public TextView description;
        public TextView title;

        public ComicViewHolder(View itemView){
            super(itemView);

            this.comicImageView = (ImageView) itemView.findViewById(R.id.comic_image);
//            this.comicId = (TextView) itemView.findViewById(R.id.id);
            this.id = (TextView) itemView.findViewById(R.id.id);
            this.description = (TextView) itemView.findViewById(R.id.description);
            this.title = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
