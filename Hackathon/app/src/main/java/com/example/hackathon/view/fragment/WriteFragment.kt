package com.example.hackathon.view.fragment

import android.util.Log
import androidx.lifecycle.Observer
import com.example.hackathon.adapter.VoteAddAdapter
import com.example.hackathon.R
import com.example.hackathon.base.BaseFragment
import com.example.hackathon.databinding.FragmentWriteBinding
import com.example.hackathon.model.VoteList
import com.example.hackathon.network.RetrofitClient
import com.example.hackathon.view.activity.MainActivity
import com.example.hackathon.viewmodel.WriteViewModel
import com.example.hackathon.widget.extension.startActivity
import com.example.hackathon.widget.extension.toast
import kotlinx.android.synthetic.main.fragment_write.*

class WriteFragment : BaseFragment<FragmentWriteBinding, WriteViewModel>() {

    override val viewModel: WriteViewModel = WriteViewModel()

    override val layoutRes: Int
        get() = R.layout.fragment_write

    var subArrayList = ArrayList<VoteList>()

    private lateinit var voteAddAdapter: VoteAddAdapter

    override fun init() {
        viewModel.retrofit = RetrofitClient.getInstance()
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
                voteAddAdapter.setList(subArrayList)
                voteAddAdapter.notifyDataSetChanged()
                Log.d("data1", "data: $subArrayList")
            })

            uploadBtn.observe(this@WriteFragment, {
                upload()
            })

            arrayList.observe(this@WriteFragment, {
                subArrayList = arrayList.value!!
            })

            status.observe(this@WriteFragment, Observer {
                if(status.value == "200")
                {
                    toast("성공")
                    startActivity(MainActivity::class.java)
                }
                else{
                    toast("실패")
                }
            })

        }
    }

}