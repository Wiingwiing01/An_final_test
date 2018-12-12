package com.example.hp.an_final_test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListViewAdapt extends ArrayAdapter {
    private int resourceId;

    public ListViewAdapt(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Pro pro = (Pro) getItem(position);
        ListLayout listLayout = new ListLayout();
        View view;
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId, null);
            listLayout.titleView = (TextView) view.findViewById(R.id.title);
            listLayout.timeView = (TextView) view.findViewById(R.id.time);
            listLayout.imgView = (ImageView) view.findViewById(R.id.img);
            listLayout.img2View=(ImageView)view.findViewById(R.id.img2);
            listLayout.img3View=(ImageView)view.findViewById(R.id.img3);
            listLayout.img4View=(ImageView)view.findViewById(R.id.img4);
            listLayout.contentView=(TextView)view.findViewById(R.id.content);
            view.setTag(listLayout);
        } else {
            view = convertView;
            listLayout = (ListLayout) view.getTag();
        }
        listLayout.titleView.setText(pro.getTitle());
        listLayout.timeView.setText(pro.getTime());
        listLayout.imgView.setImageResource(pro.getImg());
        listLayout.img2View.setImageResource(pro.getImg2());
        listLayout.img3View.setImageResource(pro.getImg3());
        listLayout.img4View.setImageResource(pro.getImg4());
        listLayout.contentView.setText(pro.getContent());
        return view;
    }

    class ListLayout {
        private TextView titleView;
        private TextView timeView;
        private ImageView imgView;
        private ImageView img2View;
        private ImageView img3View;
        private ImageView img4View;
        private TextView contentView;

    }
}
