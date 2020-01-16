package ir.saatgroup.digikala.adapters

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import ir.saatgroup.digikala.data.pojo.CategoryWithSub
import ir.saatgroup.digikala.ui.CategoryTabFragment

class ViewPagerAdapterMainMenu(fm: FragmentManager, lc: Lifecycle, var data: List<CategoryWithSub>) :
    FragmentStateAdapter(fm, lc) {
    private val tabs: MutableList<CategoryTabFragment> = mutableListOf()

    init {
        for (cws in data) {
            Log.i("wwww",cws.toString())
            tabs.add(CategoryTabFragment.newInstance(cws))
        }
    }


    override fun getItemCount(): Int {
        return tabs.size
    }

    override fun createFragment(position: Int): Fragment {
        return tabs[position]
    }
}
