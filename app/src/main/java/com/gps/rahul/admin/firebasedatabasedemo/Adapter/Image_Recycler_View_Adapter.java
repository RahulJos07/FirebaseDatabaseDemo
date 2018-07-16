package com.gps.rahul.admin.firebasedatabasedemo.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.gps.rahul.admin.firebasedatabasedemo.Model.FileUploadModel;
import com.gps.rahul.admin.firebasedatabasedemo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Image_Recycler_View_Adapter extends RecyclerView.Adapter<Image_Recycler_View_Adapter.ImageViewHolder> {
    private Context mcontext;
    private List<FileUploadModel> mfileUploadModels;

    public Image_Recycler_View_Adapter(Context context, List<FileUploadModel> fileUploadModels)
    {
            mcontext=context;
            mfileUploadModels=fileUploadModels;
    }
    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(mcontext).inflate(R.layout.custom_image_layout_list,parent,false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {
        FileUploadModel fileUploadModel=mfileUploadModels.get(position);
        holder.text_view_name.setText(fileUploadModel.getImageName());
        Picasso.with(mcontext)
                .load(fileUploadModel.getImage())
                .fit()
                .centerInside()
                .into(holder.image_view_upload);
    }

    @Override
    public int getItemCount() {
        return mfileUploadModels.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder
        {
            public TextView text_view_name;
            public ImageView image_view_upload;

            public ImageViewHolder(View itemView) {
                super(itemView);
                text_view_name=itemView.findViewById(R.id.text_view_name);
                image_view_upload=itemView.findViewById(R.id.image_view_upload);
            }
        }
}
