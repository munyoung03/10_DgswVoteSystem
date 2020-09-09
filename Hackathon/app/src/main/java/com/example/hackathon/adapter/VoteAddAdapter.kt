package com.example.hackathon.Adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathon.R
import com.example.hackathon.model.ContentData
import com.example.hackathon.model.VoteList
import kotlinx.android.synthetic.main.votelist.view.*

class VoteAddAdapter : RecyclerView.Adapter<VoteAddAdapter.Holder>() {

    private var arrayList: ArrayList<VoteList> = ArrayList()

    fun setList(arrayList: ArrayList<VoteList>){
        this.arrayList = arrayList

        Log.d("data1", "data: ${this.arrayList}")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.votelist, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return if (arrayList.size == 0){
            0
        }else{
            Log.d("data3", "data: ${arrayList[0].voteList.size}")
            arrayList[0].voteList.size
        }

    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(arrayList[0])
        ContentData.arrayList.add(position, holder.itemView.input_content.text.toString())
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val inputContent: EditText = itemView.findViewById(R.id.input_content)
        fun bind(voteList: VoteList) {
            inputContent.hint = voteList.voteList[0]
        }
    }
}