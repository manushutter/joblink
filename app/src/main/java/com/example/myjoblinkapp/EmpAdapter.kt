package com.example.myjoblinkapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EmpAdapter(private val empList : ArrayList<Emps>) : RecyclerView.Adapter<EmpAdapter.MyViewHolder>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.emp_item,
        parent,false)
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = empList[position]
        holder.workName.text = currentitem.name
        holder.workJob.text = currentitem.job
        holder.workProfile.text = currentitem.profile


    }

    override fun getItemCount(): Int {

        return empList.size
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

            val workName : TextView = itemView.findViewById(R.id.mEmpName)
            val workJob : TextView = itemView.findViewById(R.id.mEmpJob)
            val workProfile : TextView = itemView.findViewById(R.id.mEmpProfile)


    }
}










