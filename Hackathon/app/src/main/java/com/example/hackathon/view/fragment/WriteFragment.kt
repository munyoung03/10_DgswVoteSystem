package com.example.hackathon.view.fragment

import android.util.Log
import com.example.hackathon.Adapter.VoteAddAdapter
import com.example.hackathon.R
import com.example.hackathon.base.BaseFragment
import com.example.hackathon.databinding.FragmentWriteBinding
import com.example.hackathon.model.VoteList
import com.example.hackathon.viewmodel.WriteViewModel
import com.example.hackathon.widget.extension.toast
import kotlinx.android.synthetic.main.fragment_survey.*
import kotlinx.android.synthetic.main.fragment_write.*

class WriteFragment : BaseFragment<FragmentWriteBinding, WriteViewModel>() {

    override val viewModel: WriteViewModel = WriteViewModel()

    override val layoutRes: Int
        get() = R.layout.fragment_write

    var subArrayList = ArrayList<VoteList>()

    private lateinit var voteAddAdapter: VoteAddAdapter

    override fun init() {
        voteAddAdapter = VoteAddAdapter()
        recyclerView.adapter = voteAddAdapter
    }

    override fun observerViewModel() {
        with(viewModel){
            checkMax.observe(this@WriteFragment, {
                toast("투표 보기는 5개가 최대입니다.")
            })

            plusBtn.observe(this@WriteFragment, {
                plusView()

                voteAddAdapter.setList(arrayList.value!!)

                voteAddAdapter.notifyDataSetChanged()

                Log.d("data1", "data: $subArrayList")
            })

            arrayList.observe(this@WriteFragment, {
                subArrayList = arrayList.value!!
            })
        }
    }

}