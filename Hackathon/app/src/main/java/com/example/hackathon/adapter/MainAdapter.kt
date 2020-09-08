package com.example.hackathon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathon.R
import com.example.hackathon.model.GetSubJect
import com.example.hackathon.model.SubJectData
import com.example.hackathon.widget.MyApplication

class MainAdapter(val subJectList: ArrayList<SubJectData>) : RecyclerView.Adapter<MainAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return subJectList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.bind(subJectList[position])
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val subjectText = itemView.findViewById<TextView>(R.id.subject)
        fun bind(subject : SubJectData) {
            itemView.setOnClickListener {
                subjectText.text = MyApplication.prefs.getSubJect("subject_1", "안녕")
                subject.pk.add(MyApplication.prefs.getPk("pk", 0))
            }
        }
    }
}