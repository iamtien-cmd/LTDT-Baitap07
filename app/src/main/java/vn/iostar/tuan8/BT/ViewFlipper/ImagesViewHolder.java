package vn.iostar.tuan8.BT.ViewFlipper;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NonNls;

import vn.iostar.tuan8.R;

public class ImagesViewHolder extends RecyclerView.ViewHolder {
    private ImageView imageView;
    public ImagesViewHolder(@NonNull View itemView){
        super(itemView);
        imageView = itemView.findViewById(R.id.imgView);
    }
}
