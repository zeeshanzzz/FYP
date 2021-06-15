package com.example.fyp.ui.login

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.fyp.R


class LoginActivity : AppCompatActivity() {
    private val radioUserGroup: RadioGroup? = null
    private lateinit var radioUserButton: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val login = findViewById<Button>(R.id.login)
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
                    }
                }
            }

        })
    }
}


/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */

