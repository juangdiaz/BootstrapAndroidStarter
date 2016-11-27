package com.juangdiaz.bootstrap.helpers;

import android.widget.ImageView;

/**
 * @author juandiaz <juan@juangdiaz.com> Android Developer
 */
public interface ImageHelper {


    /**
     * Load an image into the given image view either from the network or the cache, as decided by the image cache implementation
     * @param imageView
     * @param url
     */
    void loadImage(ImageView imageView, String url);


    /**
     * Cancels any pending downloads for the given
     * ImageView.
     * @param imageView
     */
    void clearImage(ImageView imageView);


}
