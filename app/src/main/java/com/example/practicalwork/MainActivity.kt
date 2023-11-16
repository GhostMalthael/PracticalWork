package com.example.practicalwork
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.view.animation.AnimationUtils
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var backPressedTime: Long = 0
    private var backToast: Toast? = null

    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast?.cancel()
            super.onBackPressed()
            return
        } else {
            backToast = Toast.makeText(baseContext, "Нажмите ещё раз, чтобы выйти", Toast.LENGTH_SHORT)
            backToast?.show()
        }
        backPressedTime = System.currentTimeMillis()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val start: Button = findViewById(R.id.button)
        val anim_button = AnimationUtils.loadAnimation(this, R.anim.button_animation);
        start.setOnClickListener {
            try {
                start.startAnimation(anim_button)
                val intent = Intent(this, MainActivity2::class.java)
                startActivity(intent)
                finish()
            } catch (e: Exception) {

            }
        }
    }
}
