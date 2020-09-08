package com.example.hackathon.view.fragment

import com.example.hackathon.R
import com.example.hackathon.adapter.MainAdapter
import com.example.hackathon.base.BaseFragment
import com.example.hackathon.databinding.FragmentSurveyBinding
import com.example.hackathon.model.SubJectData
import com.example.hackathon.viewmodel.SurveyViewModel
import com.example.hackathon.widget.MyApplication
import kotlinx.android.synthetic.main.fragment_survey.*


class SurveyFragment : BaseFragment<FragmentSurveyBinding, SurveyViewModel>() {

    override val viewModel: SurveyViewModel = SurveyViewModel()

    override val layoutRes: Int
        get() = R.layout.fragment_survey

    override fun init() {

        val i = 0
        val maxCount = MyApplication.prefs.getMaxPk("maxpk", 5)
        val subJectArrayList = ArrayList<String>()
        val pkArrayList = ArrayList<Int>()

        for(i in i..maxCount) {
            subJectArrayList.add(MyApplication.prefs.getSubJect("subJect_${i}", ""))
            pkArrayList.add(MyApplication.prefs.getPk("Pk_${i}", 0))
        }

        val subJectList : ArrayList<SubJectData> = arrayListOf(
            SubJectData(subJectArrayList, pkArrayList)
        )

        val mAdapter = MainAdapter(subJectList)

        mRecyclerView.adapter = mAdapter
    }

    override fun observerViewModel() {
    }

}