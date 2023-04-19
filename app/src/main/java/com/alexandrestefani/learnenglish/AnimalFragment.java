package com.alexandrestefani.learnenglish;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnimalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnimalFragment extends Fragment implements View.OnClickListener {

    private ImageView cao, gato, leao, macaco;
    MediaPlayer mediaPlayer;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AnimalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnimalFragment newInstance(String param1, String param2) {
        AnimalFragment fragment = new AnimalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_animal, container, false);

        cao = view.findViewById(R.id.image_cao);
        gato = view.findViewById(R.id.image_gato);
        leao = view.findViewById(R.id.image_leao);
        macaco = view.findViewById(R.id.image_macaco);

        cao.setOnClickListener(this);
        gato.setOnClickListener(this);
        leao.setOnClickListener(this);
        macaco.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image_cao:
                mediaPlayer = mediaPlayer.create(getActivity(),R.raw.dog);
                playsong();
                break;


            case R.id.image_gato:
                mediaPlayer = mediaPlayer.create(getActivity(),R.raw.cat);
                playsong();
                break;

            case R.id.image_macaco:
                mediaPlayer = mediaPlayer.create(getActivity(),R.raw.monkey);
                playsong();
                break;

            case R.id.image_leao:
                mediaPlayer = mediaPlayer.create(getActivity(),R.raw.lion);
                playsong();
                break;
        }


    }

    public void playsong(){
        if( mediaPlayer != null){
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mediaPlayer.release();
                }
            });
        }
    }
}