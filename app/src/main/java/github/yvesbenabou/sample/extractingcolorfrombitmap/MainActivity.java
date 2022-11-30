package github.yvesbenabou.sample.extractingcolorfrombitmap;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;


import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.transition.Transition;

import java.security.PrivateKey;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    private String RANDOM_IMAGE_URL ="https://image.tmdb.org/t/p/w500/4x3pt6hoLblBeHebUa4OyiVXFiM.jpg" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView = (ImageView) findViewById(R.id.main_image);
        loadRandomImage();
    }
    private void loadRandomImage() {

        Glide.with(this)
                .asBitmap()
                .load(RANDOM_IMAGE_URL)
                .into(new BitmapImageViewTarget(imageView) {
                    @Override
                    public void onResourceReady(Bitmap bitmap, Transition <? super Bitmap> transition) {
                        super.onResourceReady(bitmap, transition);
                        assert imageView != null;
                        imageView.setImageBitmap(bitmap);
                    }
                });
    }
}
