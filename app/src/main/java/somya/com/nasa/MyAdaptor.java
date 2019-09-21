package somya.com.nasa;

import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.MyviewHolder> {
    ArrayList<Information>mylist = new ArrayList<>();
    Context ctx;

    public MyAdaptor(ArrayList<Information> mylist,Context ctx) {
        this.mylist = mylist;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View inflated = layoutInflater.inflate(R.layout.items_of_recyclerviews,parent,false);
        return new MyviewHolder(inflated);
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {

        holder.checkBox.setText(mylist.get(position).info);


    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder{

   CheckBox checkBox;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            checkBox = itemView.findViewById(R.id.recyclerView_todo_checkbox);
            checkBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(checkBox.isChecked()){
                        checkBox.setTextColor(ctx.getResources().getColor(R.color.colorChecked));
                        final SheredRef sheredRef=new SheredRef(ctx);
                        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                                //sheredRef.saveData(+"");
                            }
                        });
                    }
                }
            });


            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {

                    new AlertDialog.Builder(ctx)
                            .setTitle("Delete")
                            .setMessage("Are you sure you want to delete this?")
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .setCancelable(false)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    mylist.remove(getAdapterPosition());
                                    notifyDataSetChanged();
                                }
                            })
                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {

                                }
                            })
                            .show();
                    return false;
                }
            });

        }
    }
}
