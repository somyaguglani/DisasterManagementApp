package somya.com.nasa;


import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class todo extends Fragment {


    public todo() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_todo, container, false);
        final CardView cyclone=view.findViewById(R.id.main_floodcv);
        CardView earthquake=view.findViewById(R.id.main_earthquakecv);
        final CardView tornado=view.findViewById(R.id.main_tornadocv);
        CardView volcano=view.findViewById(R.id.main_volcanocv);
        final Intent[] i = new Intent[1];

        cyclone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(getActivity(),cyclone.class));
                i[0] =new Intent(getActivity(),FloodActivity.class);
                startActivity(i[0]);
            }
        });
        earthquake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(getActivity(),earthquake.class));
                i[0] =new Intent(getActivity(),FloodActivity.class);
                startActivity(i[0]);

            }
        });
        tornado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // startActivity(new Intent(getActivity(),tornado.class));
                i[0] =new Intent(getActivity(),FloodActivity.class);
                startActivity(i[0]);

            }
        });
        volcano.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(new Intent(getActivity(),volkano.class));
                i[0] =new Intent(getActivity(),FloodActivity.class);
                startActivity(i[0]);

            }
        });


        return view;
    }

}
