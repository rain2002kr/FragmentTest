package com.example.fragmenttest

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.sub_main_view.view.*

class MainViewModel (val imageId : Int, val subject:String, val subject2:String )

class MainViewHolder (override val containerView: View) : RecyclerView.ViewHolder(containerView),LayoutContainer


class MainViewAdapter (val context: Context, val list:List<MainViewModel>) : RecyclerView.Adapter<MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.sub_main_view,parent,false)

        return MainViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        /*    // 닉네임없음 프로필없음 배경없음 번호없음
            holder?.friend_Name.text = "하이"*/

        Log.d("리사이클러뷰 가 불러짐","ㅇㅇㅇㅇ")

        holder.containerView.imageView.setImageResource(list[position].imageId)
        holder.containerView.textView.text=list[position].subject
        holder.containerView.textView2.text=list[position].subject2


    }

}

/*
class mViewH(view: View) : RecyclerView.ViewHolder(view!!) {
    var friend_Profile = view.textView
    var friend_Name = view.textView2

}
 */