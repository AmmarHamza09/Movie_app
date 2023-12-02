package com.example.finalproject;

import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.example.finalproject.databinding.ActivityLoginBinding;


public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    private Handler handler;
    private Runnable runnable;
    private Animation fadeIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ImageView gifImageView = findViewById(R.id.image);
        Glide.with(this)
                .load(R.raw.loginani)
                .into(gifImageView);

        // Initialize animations
        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);

        // Handler and Runnable for delayed execution
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                // Let's set fade in animation on other layouts
                binding.cardView.setAnimation(fadeIn);
                binding.cardView2.setAnimation(fadeIn);
                binding.cardView3.setAnimation(fadeIn);
                binding.cardView4.setAnimation(fadeIn);
                binding.textView.setAnimation(fadeIn);
                binding.textView3.setAnimation(fadeIn);
                binding.regLayout.setAnimation(fadeIn);
            }
        };

        // Delayed execution after 1000 milliseconds (1 second)
        handler.postDelayed(runnable, 1000);
    }
}
