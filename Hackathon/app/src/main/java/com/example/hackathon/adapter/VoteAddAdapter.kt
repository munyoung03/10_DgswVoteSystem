package com.example.hackathon.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.example.hackathon.R
import com.example.hackathon.model.VoteList

class VoteAddAdapter : RecyclerView.Adapter<VoteAddAdapter.Holder>() {

    private var arrayList: ArrayList<VoteList> = ArrayList()

    fun setList(arrayList: ArrayList<VoteList>){
        this.arrayList = arrayList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.votelist, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(arrayList[position])
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private val inputContent: EditText = itemView.findViewById(R.id.input_content)
        fun bind(voteList: VoteList) {
            if(voteList.voteList.size == 0){
                inputContent.hint ="내용"
            }else{
<<<<<<< Updated upstream
                inputContent.hint = voteList.voteList.toString()
=======
                inputContent.hint = voteList.voteList[]
>>>>>>> Stashed changes
            }
        }
    }
}