package somya.com.nasa;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyVideosAdaptor extends RecyclerView.Adapter<MyVideosAdaptor.VideosViewHolder> {

ArrayList<vfvideos> mylist = new ArrayList<>();

    public MyVideosAdaptor(ArrayList<vfvideos> mylist) {
        this.mylist = mylist;
    }

    Context ctx;
    @NonNull
    @Override
    public VideosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
   ctx = parent.getContext();
        LayoutInflater layoutInflater  = LayoutInflater.from(parent.getContext());
        View inflated = layoutInflater.inflate(R.layout.somya_video_recycler_item,parent,false);
        return new VideosViewHolder(inflated);

    }

    @Override
    public void onBindViewHolder(@NonNull VideosViewHolder holder, int position) {
         holder.textView.setText(mylist.get(position).name);
         Picasso.get()
                 .load(mylist.get(position).imageurl)
                 .placeholder(R.mipmap.ic_launcher)
                 .error(R.drawable.ic_action_erroe)
                 .into(holder.imageView);


    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class VideosViewHolder extends RecyclerView.ViewHolder{
ImageView imageView;
TextView textView;
        public VideosViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.vidrv_imgbtn);
            textView = itemView.findViewById(R.id.vidrv_tv);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(mylist.get(getAdapterPosition()).linkurl));
                    ctx.startActivity(intent);
                }
            });
        }
    }
}
