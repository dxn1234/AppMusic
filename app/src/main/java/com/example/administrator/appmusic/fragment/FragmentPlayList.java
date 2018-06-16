package com.example.administrator.appmusic.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.appmusic.R;
import com.example.administrator.appmusic.adapter.PlaylistAdapter;
import com.example.administrator.appmusic.model.PlayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class FragmentPlayList extends Fragment {
    PlaylistAdapter playlistAdapter;
    ListView lvplaylist;
    TextView txttitleplaylist, txtxemthemplaylist;
    ArrayList<PlayList> mangPlayList;
    String url = "https://ducnguyenptit1909.000webhostapp.com/Server/PlayListForCurrentDay.php";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_playlist, container, false);
        lvplaylist = view.findViewById(R.id.lv_playlist);
        txttitleplaylist = view.findViewById(R.id.txt_titleplaylist);
        txtxemthemplaylist = view.findViewById(R.id.txt_viewmoreplaylist);
        mangPlayList = new ArrayList<>();
        getData();
        return view;
    }

    private void getData() {
        final RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        mangPlayList.add(new PlayList(jsonObject.getInt("IdPlayList"), jsonObject.getString("Ten"), jsonObject.getString("Hinhnen"), jsonObject.getString("Hinhicon")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(), "Lỗi", Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}
