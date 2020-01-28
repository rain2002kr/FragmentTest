package com.example.fragmenttest


import android.content.Context
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_sub1.*

class Sub1Fragment : Fragment() {

    private val recycler_view: RecyclerView by lazy {
        view?.findViewById(R.id.recycler_view) as RecyclerView
    }

    private val list by lazy {
        mutableListOf<MainViewModel>(
            MainViewModel(R.drawable.network, "전송 리스트","자동 문자 전송 정보를 저장하는 화면입니다."),
            MainViewModel(R.drawable.log, "전송 내역","자동 전송된 문자 내역을 확인하는 화면입니다."),
            MainViewModel(R.drawable.sms, "문자 보내기","문자를 전송 할수 있는 화면입니다."),
            MainViewModel(R.drawable.info, "정보","버전을 확인 할수 있습니다.")

        )
    }

    private lateinit var mainAdapter : MainViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView = inflater.inflate(R.layout.fragment_sub1, container, false)





        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        recycler_view.setHasFixedSize(true) //lazy 접근
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            recycler_view.layoutManager = LinearLayoutManager(context)
        }
        mainAdapter = MainViewAdapter(requireContext(), list)
        recycler_view.layoutManager = LinearLayoutManager(requireContext())
        recycler_view.adapter = mainAdapter

    }


}
