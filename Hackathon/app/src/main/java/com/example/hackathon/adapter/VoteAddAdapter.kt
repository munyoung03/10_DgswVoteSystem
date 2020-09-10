package com.example.hackathon.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathon.R
import com.example.hackathon.model.ContentData
import com.example.hackathon.model.VoteList
import kotlinx.android.synthetic.main.votelist.view.*
import java.util.stream.Collectors

class VoteAddAdapter : RecyclerView.Adapter<VoteAddAdapter.Holder>() {

    private var arrayList: ArrayList<VoteList> = ArrayList()

    fun setList( list : ArrayList<VoteList>) {
        arrayList = list;
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.votelist, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        val value = arrayList.stream().filter {  it.voteList != "null" }.collect(Collectors.toList()).size;
        Log.d("Log", "Current Size : $value")
        return value
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(arrayList[position])
        ContentData.arrayList.add(position, holder.itemView.input_content.text.toString())
        Log.d("Log",holder.itemView.input_content.text.toString())
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val inputContent: EditText = itemView.findViewById(R.id.input_content)
        fun bind(voteList: VoteList) {
            inputContent.hint = "내용"
            inputContent.addTextChangedListener {
                voteList.voteList = it?.toString()!!;
            }
        }
    }
}