package com.example.myjoblinkapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class EmployersActivity : AppCompatActivity() {

    private lateinit var dbref : DatabaseReference
    private lateinit var userRecyclerView: RecyclerView
    private lateinit var userArrayList: ArrayList<Emps>


    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employers)

        userRecyclerView = findViewById(R.id.mEmpRecyclerlist)
        userRecyclerView.layoutManager = LinearLayoutManager(this)
        userRecyclerView.setHasFixedSize(true)

        userArrayList = arrayListOf<Emps>()
        getUserData()

    }

    private fun getUserData() {

        dbref = FirebaseDatabase.getInstance().getReference("Users")

        dbref.addValueEventListener(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {

                    for (userSnapshot in snapshot.children){

                    val user = userSnapshot.getValue(Emps::class.java)
                        userArrayList.add(user!!)

                    }

                    userRecyclerView.adapter = EmpAdapter(userArrayList)

                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }
}
