package com.example.hackathon.view.activity

import androidx.annotation.ContentView
import androidx.lifecycle.Observer
import com.example.hackathon.R
import com.example.hackathon.base.BaseActivity
import com.example.hackathon.databinding.ActivityContentBinding
import com.example.hackathon.network.RetrofitClient
import com.example.hackathon.viewmodel.ContentViewModel
import com.example.hackathon.viewmodel.SurveyViewModel
import com.example.hackathon.widget.extension.startActivity
import com.example.hackathon.widget.extension.toast
import kotlinx.android.synthetic.main.activity_content.*

class ContentActivity : BaseActivity<ActivityContentBinding, ContentViewModel>() {

    override val viewModel: ContentViewModel = ContentViewModel()

    override val layoutRes: Int
        get() = R.layout.activity_content

    override fun init() {
        viewModel.retrofit = RetrofitClient.getInstance()
        val pk = intent.getIntExtra("pk", 0)
        viewModel.getDetail(pk)
    }

    override fun observerViewModel() {
        with(viewModel){
            status.observe(this@ContentActivity, Observer {
                if(status.value != "200")
                {
                    startActivity(MainActivity::class.java)
                    toast("에러")
                }
            })

            btn.observe(this@ContentActivity, Observer {
                if(checkBox1.isChecked){
                    item1Cnt.value = ((item1Cnt.value?.toInt())?.plus(1)).toString()
                }
                if(checkBox2.isChecked){
                    item2Cnt.value = ((item2Cnt.value?.toInt())?.plus(1)).toString()
                }
                if(checkBox3.isChecked){
                    item3Cnt.value = ((item3Cnt.value?.toInt())?.plus(1)).toString()
                }
                if(checkBox4.isChecked){
                    item4Cnt.value = ((item4Cnt.value?.toInt())?.plus(1)).toString()
                }
                if(checkBox5.isChecked){
                    item5Cnt.value = ((item5Cnt.value?.toInt())?.plus(1)).toString()
                }

                sendResult()
            })

            resultStatus.observe(this@ContentActivity, Observer {
                if(resultStatus.value == "200")
                {
                    startActivity(MainActivity::class.java)
                    toast("성공")
                }
                else{
                    startActivity(MainActivity::class.java)
                    toast("실패")
                }
            })
        }
    }

}