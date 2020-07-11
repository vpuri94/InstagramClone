package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.parse.ParseFile;

import org.parceler.Parcels;

public class PostsDetailsActivity extends AppCompatActivity {

    Post post;
    private TextView tvUsername;
    private TextView tvDescription;
    private ImageView ivImage;
    private TextView tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts_details);
        post = (Post) Parcels.unwrap(getIntent().getParcelableExtra(Post.class.getSimpleName()));
        tvUsername = (TextView)findViewById(R.id.tvUsername);
        tvDescription = (TextView) findViewById(R.id.tvDescription);
        ivImage = (ImageView) findViewById(R.id.ivImage);
        tvTime = (TextView) findViewById(R.id.tvTime);
        post = (Post) Parcels.unwrap(getIntent().getParcelableExtra(Post.class.getSimpleName()));
        tvDescription.setText(post.getDescription());
        tvUsername.setText(post.getUser().getUsername());
        ParseFile image = post.getImage();
        if(image != null) {
            Glide.with(getApplicationContext()).load(image.getUrl()).into(ivImage);
        }
        tvTime.setText("Posted " + post.getDate());

    }
}