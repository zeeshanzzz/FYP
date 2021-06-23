package com.example.fyp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class RegistratinActivity : AppCompatActivity() {
    private val radioUserGroup: RadioGroup? = null
    private lateinit var radioUserButton: RadioButton
    private lateinit var login:Button;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registratin)
        val username = findViewById<TextInputLayout>(R.id.username)
        val password = findViewById<TextInputLayout>(R.id.password)
         login = findViewById(R.id.loginRegister)
        val loading = findViewById<ProgressBar>(R.id.loading)
        val radioUserGroup = findViewById<RadioGroup>(R.id.radioGroup)
        login.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val selectedId: Int = radioUserGroup.getCheckedRadioButtonId()
                radioUserButton = findViewById<View>(selectedId) as RadioButton
                when (radioUserButton.id) {
                    R.id.radioUser -> {
                    }
                    R.id.radioMechanic -> {
                    }
                    R.id.radioAdmin -> {
                        val intent= Intent(this@RegistratinActivity,AdminActivity::class.java)
                        startActivity(intent)
                    }
                }
            }

        })
    }
}