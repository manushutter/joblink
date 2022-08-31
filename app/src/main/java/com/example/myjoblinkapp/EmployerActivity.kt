package com.example.myjoblinkapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.myjoblinkapp.databinding.ActivityEmployerBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class EmployerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEmployerBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEmployerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mBtnSave.setOnClickListener {

           val name = binding.mEdtNameEmp.text.toString()
            val age = binding.mEdtAge.text.toString()
            val job = binding.mEdtJob.text.toString()
            val profile = binding.mEdtProfile.text.toString()

            database = FirebaseDatabase.getInstance().getReference("Users")
            val Users = Users(name,age,job,profile)
            database.child(name).setValue(Users).addOnSuccessListener {

                binding.mEdtNameEmp.text.clear()
                binding.mEdtAge.text.clear()
                binding.mEdtJob.text.clear()
                binding.mEdtProfile.text.clear()

                Toast.makeText(this,"Successfully Saved",Toast.LENGTH_SHORT).show()

            }.addOnFailureListener {
                Toast.makeText(this,"Saving Failed",Toast.LENGTH_SHORT).show()

            }
        }
    }
}