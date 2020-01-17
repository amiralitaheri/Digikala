package ir.saatgroup.digikala.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import ir.saatgroup.digikala.R
import ir.saatgroup.digikala.data.pojo.Product
import ir.saatgroup.digikala.utils.convertToPrice
import kotlinx.android.synthetic.main.product_holder_linar.view.*

class ProductRowRecycleAdapter(
    private val inflater: LayoutInflater,
    var dataSource: List<Product>,
    var topPrice: Boolean
) :
    RecyclerView.Adapter<ProductRowRecycleAdapter.ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(inflater.inflate(R.layout.product_holder_linar, parent, false))
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bindClass(dataSource[position], topPrice)
    }


    class ItemHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var parentView: View = v
        private var product: Product? = null
        fun bindClass(p: Product, top: Boolean) {
            this.product = p
            parentView.title.text = p.FaTitle
            parentView.image.setImageURI(p.ImagePath)
            if (p.MinPriceList == 0 || !top) {
                parentView.topPrice.isVisible = false
            } else {
                parentView.topPrice.text = p.MinPriceList.convertToPrice()
                parentView.topPrice.isVisible = true
            }

            parentView.lowPrice.text = p.MinPrice.convertToPrice()
            parentView.setOnClickListener {
                //todo add link
            }
        }
    }
}