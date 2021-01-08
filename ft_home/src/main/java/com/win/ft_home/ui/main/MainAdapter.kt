package com.win.ft_home.ui.main

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MainAdapter(private val sfm: FragmentManager, private val fragments: List<Fragment>) : FragmentStatePagerAdapter(sfm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Fragment {
        val fragment = super.instantiateItem(container, position) as Fragment
        sfm.beginTransaction().show(fragment).commit()
        return fragment
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
        sfm.beginTransaction().hide(fragments[position]).commit()
    }
}