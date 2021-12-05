package com.ozady.carston.adapters.TabsAdapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class CarViewTabAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var fragments: ArrayList<Fragment> = ArrayList()
    var strings: ArrayList<String> = ArrayList()

    override fun getItem(i: Int): Fragment {
        return fragments[i]
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return strings[position]
    }

    fun addFragment(fragment: Fragment, string: String) {
        fragments.add(fragment)
        strings.add(string)
    }

}