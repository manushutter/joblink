package com.example.myjoblinkapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import com.example.myjoblinkapp.databinding.ActivityCustomBinding

class CustomActivity : AppCompatActivity() {

    var empLoyees: Button? = null
    var empLoyers: Button? = null
    private lateinit var binding: ActivityCustomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        empLoyees = findViewById(R.id.mBtnProfile)
        empLoyees!!.setOnClickListener {
            var goToProfile= Intent(applicationContext, EmployerActivity::class.java)
            startActivity(goToProfile)
        }

        empLoyers = findViewById(R.id.mBtnUsers)
        empLoyers!!.setOnClickListener {
            var goToProfile= Intent(applicationContext, EmployersActivity::class.java)
            startActivity(goToProfile)
        }
    }
}