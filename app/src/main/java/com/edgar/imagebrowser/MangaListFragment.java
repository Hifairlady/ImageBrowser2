package com.edgar.imagebrowser;


import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MangaListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MangaListFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView recyclerView;
    private SwipeRefreshLayout swipeRefreshLayout;
    private MangaListAdapter adapter;
    private ArrayList<MangaListItem> listItems;

    private Handler mHandler;



    public MangaListFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MangaListFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MangaListFragment newInstance(String param1, String param2) {
        MangaListFragment fragment = new MangaListFragment();
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
        return inflater.inflate(R.layout.fragment_manga_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rv_main);
        swipeRefreshLayout = view.findViewById(R.id.srl_main);

        adapter = new MangaListAdapter(getContext(), listItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setColorSchemeColors(0xFF000000);
                swipeRefreshLayout.setRefreshing(true);
            }
        });

        mHandler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 1:
                        break;

                    default:
                        break;
                }
            }
        };

        GetMangasThread mThread = new GetMangasThread(mHandler);
        mThread.run();

    }

    private class GetMangasThread extends Thread {

        private Handler handler;

        public GetMangasThread(Handler handler) {
            this.handler = handler;
        }

        @Override
        public void run() {
            super.run();

            for (int i = 0; i < 10; i++) {
                Message message = Message.obtain();
                message.what = i;
                handler.sendMessage(message);
            }

        }
    }
}
