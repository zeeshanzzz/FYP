package com.example.fyp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.AttributeSet
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
Handler().postDelayed(Runnable {
               val intent:Intent=Intent(this,RegistratinActivity::class.java)
             startActivity(intent)
    finish();

},4000
)


}

}