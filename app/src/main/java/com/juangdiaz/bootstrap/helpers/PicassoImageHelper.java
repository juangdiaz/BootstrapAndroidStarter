package com.juangdiaz.bootstrap.helpers;

import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * @author juandiaz <juan@juangdiaz.com> Android Developer
 *
 */
public class PicassoImageHelper implements ImageHelper {


    private final Picasso picasso;


    public PicassoImageHelper(@NonNull final Picasso picasso) {
        this.picasso = picasso;
    }
    @Override
    public void loadImage(ImageView imageView, String url) {
        picasso.load(url).fit().centerCrop().into(imageView);
    }

    @Override
    public void clearImage(ImageView imageView) {
        picasso.cancelRequest(imageView);
    }
}
