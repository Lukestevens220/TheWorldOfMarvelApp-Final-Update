package appexperts.com.theworldofmarvelapp.Comic;

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


/**
 * Created by TheAppExperts on 03/11/2016.
 */

public class ComicAdapter extends RecyclerView.Adapter {

    private Context context;
    ArrayList<Result> characters;

    public ComicAdapter(Context context, List<Result> characterList){
        this.context = context;
        characters = (ArrayList<Result>) characterList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comic_item, parent, false);
        return new CharacterViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        Result character = characters.get(position);
        CharacterViewHolder holder = (CharacterViewHolder) viewHolder;
        holder.id.setText(character.getId().toString());
        holder.description.setText(character.getDescription());
        holder.title.setText(character.getTitle());
        Picasso.with(context).load(character.getResourceURI()).into(holder.characterImageView);

    }

    @Override
    public int getItemCount() {
        return characters.size();
    }

    public static class CharacterViewHolder extends RecyclerView.ViewHolder{

        public ImageView characterImageView;
        //        public TextView comicId;
        public TextView id;
        public TextView description;
        public TextView title;

        public CharacterViewHolder(View itemView){
            super(itemView);

            this.characterImageView = (ImageView) itemView.findViewById(R.id.comic_image);
            this.id = (TextView) itemView.findViewById(R.id.id);
            this.description = (TextView) itemView.findViewById(R.id.description);
            this.title = (TextView) itemView.findViewById(R.id.title);

        }
    }
}
