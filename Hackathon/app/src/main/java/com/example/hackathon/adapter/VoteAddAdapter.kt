package com.example.hackathon.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathon.R
import com.example.hackathon.adapter.MainAdapter
import com.example.hackathon.model.SubJectData
import com.example.hackathon.model.VoteList
import com.example.hackathon.widget.MyApplication
import kotlinx.android.synthetic.main.votelist.view.*

class VoteAddAdapter : RecyclerView.Adapter<VoteAddAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.votelist, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return VoteList().voteList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(VoteList().voteList[position])
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val inputContent: EditText = itemView.findViewById<EditText>(R.id.input_content)
        fun bind(voteList: String) {
            inputContent.setText(voteList)
        }
    }
}