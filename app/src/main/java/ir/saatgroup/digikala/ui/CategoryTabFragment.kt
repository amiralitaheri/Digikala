package ir.saatgroup.digikala.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import ir.saatgroup.digikala.R
import ir.saatgroup.digikala.adapters.RecycleViewAdapterCategoryTab
import ir.saatgroup.digikala.data.pojo.CategoryWithSub
import kotlinx.android.synthetic.main.category_tab_fragment.*

class CategoryTabFragment(private val categoryWithSub: CategoryWithSub) : Fragment() {

    companion object {
        fun newInstance(categoryWithSub: CategoryWithSub) = CategoryTabFragment(categoryWithSub)
    }

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: RecycleViewAdapterCategoryTab

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = RecycleViewAdapterCategoryTab(inflater, categoryWithSub.SubCategory)

        return inflater.inflate(R.layout.category_tab_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerView = recycler
        recyclerView.adapter = adapter
    }

}
