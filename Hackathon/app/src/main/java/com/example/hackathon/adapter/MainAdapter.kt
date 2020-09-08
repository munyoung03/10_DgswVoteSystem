package com.example.hackathon.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathon.R

class MainAdapter : RecyclerView.Adapter<MainAdapter.Holder>() {

    lateinit var memoList : ArrayList<memo>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return memoList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.bind(memoList[position])
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(Memo : memo) {
            itemView.setOnClickListener {

            }
        }
    }
}