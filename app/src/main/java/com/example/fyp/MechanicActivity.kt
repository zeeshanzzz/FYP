package com.example.fyp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.fyp.ui.login.LoginActivity

class MechanicActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mechanic)
        setSupportActionBar(findViewById(R.id.toolbar))
        val btnCreate = findViewById<Button>(R.id.btnCreate)
        val btnUpdate = findViewById<Button>(R.id.btnUpdate)
        val btnDelete = findViewById<Button>(R.id.btnDelete)
        val btnView = findViewById<Button>(R.id.btnView)
        val btn_Logout = findViewById<Button>(R.id.btn_Logout)
        btnCreate.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent= Intent(this@MechanicActivity,MehanicBusinessActivity2::class.java)
                startActivity(intent)
            }

        })
        btn_Logout.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent= Intent(this@MechanicActivity,LoginActivity::class.java)
                startActivity(intent)
                finish()
            }

        })
        btnDelete.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent= Intent(this@MechanicActivity,MechanicDeleteActivity::class.java)
                startActivity(intent)
            }

        })
        btnUpdate.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent= Intent(this@MechanicActivity,MechanicUpdateActivity2::class.java)
                startActivity(intent)
            }

        })
        btnView.setOnClickListener(object: View.OnClickListener{
            override fun onClick(v: View?) {
                val intent= Intent(this@MechanicActivity,MechanicFeedBackActivity::class.java)
                startActivity(intent)
            }

        })


    }
}