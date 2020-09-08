package com.example.hackathon.view.fragment

import android.graphics.Color
import com.example.hackathon.R
import com.example.hackathon.base.BaseFragment
import com.example.hackathon.databinding.FragmentSurveyBinding
import com.example.hackathon.viewmodel.SurveyViewModel
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import kotlinx.android.synthetic.main.fragment_survey.*

class SurveyFragment : BaseFragment<FragmentSurveyBinding, SurveyViewModel>() {

    override val viewModel: SurveyViewModel = SurveyViewModel()

    override val layoutRes: Int
        get() = R.layout.fragment_survey

    override fun init() {
        val entries  = ArrayList<BarEntry>()
        val color = mutableListOf<Int>(
            0xFF6083FF.toInt()
        )

        entries.add(BarEntry(1f, 1f))
        entries.add(BarEntry(1.2f, 2f))
        entries.add(BarEntry(1.4f, 3f))
        entries.add(BarEntry(1.6f, 4f))
        entries.add(BarEntry(1.8f, 5f))


        val dataSet = BarDataSet(entries, "")

        val data = BarData(dataSet)
        data.setValueTextSize(11f)
        data.setValueTextColor(Color.WHITE)
        data.barWidth = 0.1f
        dataSet.setDrawValues(false)
        bar_chart.setVisibleXRangeMaximum(100f)
        bar_chart.data = data

        dataSet.colors = color
//        data.barWidth = 100f

        bar_chart.highlightValues(null)
        bar_chart.invalidate()

        bar_chart.axisLeft.axisMinimum = 0f
        bar_chart.axisRight.axisMinimum = 0f

        bar_chart.axisLeft.setDrawLabels(false)
        bar_chart.axisRight.setDrawLabels(false)
        bar_chart.xAxis.setDrawLabels(false)
        bar_chart.xAxis.isEnabled = false
        bar_chart.axisLeft.isEnabled = false
        bar_chart.axisRight.isEnabled = false

        bar_chart.setTouchEnabled(false)
        bar_chart.description.isEnabled = false
    }

    override fun observerViewModel() {
    }

}