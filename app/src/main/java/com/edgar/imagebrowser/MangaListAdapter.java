package com.edgar.imagebrowser;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;

public class MangaListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private ArrayList<MangaListItem> listItems;

    public MangaListAdapter(Context context, ArrayList<MangaListItem> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.layout_main_list_item, viewGroup, false);
        return new NormalViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MangaListItem listItem = listItems.get(i);
        NormalViewHolder mHolder = (NormalViewHolder) viewHolder;
        mHolder.tvTitle.setText(listItem.getMangaTitle());
        mHolder.tvPage.setText(context.getString(R.string.manga_item_page_num, listItem.getPageNum()));
        GlideApp.with(context)
                .load(new File(listItem.getCoverPath()))
                .into(mHolder.ivCover);

    }

    @Override
    public int getItemCount() {
        return (listItems == null ? 0 : listItems.size());
    }

    protected class NormalViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivCover;
        private TextView tvPage, tvTitle;

        protected NormalViewHolder(@NonNull View itemView) {
            super(itemView);

            ivCover = itemView.findViewById(R.id.iv_manga_cover);
            tvPage = itemView.findViewById(R.id.tv_manga_item_page_num);
            tvTitle = itemView.findViewById(R.id.tv_manga_item_title);

        }
    }

}
