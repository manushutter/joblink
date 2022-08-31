package com.example.myjoblinkapp

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.myjoblinkapp.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class RegisterActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityRegisterBinding

    private lateinit var firebaseAuth: FirebaseAuth

    private lateinit var progressDialog: ProgressDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("please wait")
        progressDialog.setCanceledOnTouchOutside(false)

        binding.mBtnRegister.setOnClickListener {
            validateData()
        }

    }
    private var email=""
    private var password=""
    private var userType=""
    private fun validateData() {
        email=binding.mEdtName.text.toString().trim()
        password=binding.mEdtPassword.text.toString().trim()

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this, "invalid email..", Toast.LENGTH_SHORT).show()
        }else if (password.isEmpty()){
            Toast.makeText(this, "enter password..", Toast.LENGTH_SHORT).show()
        }else{
            loginUser()
        }
    }

    private fun loginUser() {
        progressDialog.setMessage("logging in...")
        progressDialog.show()

        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnSuccessListener {
                checkUser()
            }
            .addOnFailureListener { e->
                progressDialog.dismiss()
                Toast.makeText(this, "login failed due to ${e.message}", Toast.LENGTH_SHORT).show()
            }
    }

    private fun checkUser() {
        progressDialog.setMessage("checking user...")
        startActivity(Intent(this@RegisterActivity,CustomActivity::class.java))
        finish()
    }
}