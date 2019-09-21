package somya.com.nasa;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainFragment extends Fragment {
ArrayList<Information> gained = new ArrayList<>();
FloatingActionButton floatingActionButton;
    public static MainFragment newInstance(ArrayList<Information>mylist) {
        
        Bundle args = new Bundle();
        args.putParcelableArrayList("KEY", mylist);
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView;
        recyclerView = view.findViewById(R.id.fragment_recyclerView);
        floatingActionButton = view.findViewById(R.id.fragment_floatingbtn);
        gained = getArguments().getParcelableArrayList("KEY");
        final MyAdaptor myAdaptor =new MyAdaptor(gained,getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(myAdaptor);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater lay = LayoutInflater.from(getContext());
               View Myview=  lay.inflate(R.layout.popup_on_clicking_floatingbtn,null);
                AlertDialog.Builder Mydialogue = new AlertDialog.Builder(getActivity());
                Mydialogue.setView(Myview);
                final AlertDialog alertDialog = Mydialogue.create();
                final EditText additemet = Myview.findViewById(R.id.popup_onclickFB_et);
                Button additembtn = Myview.findViewById(R.id.popup_onclickFB_btn);
                additembtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String addinfo = additemet.getText().toString();
                        gained.add(new Information(addinfo));
                        myAdaptor.notifyDataSetChanged();
                        alertDialog.dismiss();

                    }
                });
                alertDialog.show();

            }
        });
    }
}
