package ir.saatgroup.digikala.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import ir.saatgroup.digikala.R
import ir.saatgroup.digikala.adapters.ProductRowRecycleAdapter
import ir.saatgroup.digikala.data.pojo.Product
import kotlinx.android.synthetic.main.product_row_fragment.*

class ProductRowFragment : Fragment() {

    companion object {
        fun newInstance() = ProductRowFragment()
    }

    private lateinit var recycleAdapter: ProductRowRecycleAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        recycleAdapter = ProductRowRecycleAdapter(inflater, listOf(), false)
        return inflater.inflate(R.layout.product_row_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val recycler = productListRowRecycler
        recycler.adapter = recycleAdapter
    }

    fun setData(
        titleString: String,
        products: List<Product>,
        moreButtonActive: Boolean,
        link: String,
        topPrice: Boolean
    ) {
        recycleAdapter.dataSource = products
        recycleAdapter.topPrice = topPrice
        recycleAdapter.notifyDataSetChanged()
        title.text = titleString
        moreButton.isVisible = moreButtonActive
        //todo add link
    }

}
