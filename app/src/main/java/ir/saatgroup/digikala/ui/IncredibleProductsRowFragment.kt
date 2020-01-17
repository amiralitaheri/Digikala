package ir.saatgroup.digikala.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ir.saatgroup.digikala.R
import ir.saatgroup.digikala.adapters.IncredibleProductRowRecycleAdapter
import ir.saatgroup.digikala.data.pojo.IncredibleProduct
import kotlinx.android.synthetic.main.incredible_products_row_fragment.*

class IncredibleProductsRowFragment : Fragment() {

    companion object {
        fun newInstance() = IncredibleProductsRowFragment()
    }

    private lateinit var recycleAdapter: IncredibleProductRowRecycleAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        recycleAdapter = IncredibleProductRowRecycleAdapter(inflater, listOf())
        return inflater.inflate(R.layout.incredible_products_row_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val recycler = productListRowRecycler
        recycler.adapter = recycleAdapter
    }

    fun setData(
        products: List<IncredibleProduct>
    ) {
        recycleAdapter.dataSource = products
        recycleAdapter.notifyDataSetChanged()
    }

}
