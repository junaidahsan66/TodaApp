package com.aexample.todoapp.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.aexample.todoapp.ui.main.later.LaterFragment
import com.aexample.todoapp.ui.main.today.TodayFragment


class FragmentPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentStatePagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when(position){
            0 -> {
                return TodayFragment()
            }
            1 ->{
                return LaterFragment()
            }

        }
        return TodayFragment()
    }

    override fun getCount(): Int {
        return 2
    }
}