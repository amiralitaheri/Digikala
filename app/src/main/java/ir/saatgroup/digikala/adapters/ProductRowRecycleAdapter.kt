package ir.saatgroup.digikala.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import ir.saatgroup.digikala.R
import ir.saatgroup.digikala.data.pojo.Product
import kotlinx.android.synthetic.main.product_holder_linar.view.*

class ProductRowRecycleAdapter(private val inflater: LayoutInflater, var dataSource: List<Product>) :
    RecyclerView.Adapter<ProductRowRecycleAdapter.ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(inflater.inflate(R.layout.product_holder_linar, parent, false))
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bindClass(dataSource[position])
    }


    class ItemHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var parentView: View = v
        private var product: Product? = null
        fun bindClass(p: Product) {
            this.product = p
            parentView.title.text = p.FaTitle
            parentView.image.setImageURI(p.ImagePath)

            if (p.MinPriceList != 0) {
                parentView.topPrice.isVisible = true
                parentView.topPrice.text = convertPrice(p.MinPriceList)
            } else {
                parentView.topPrice.isVisible = false
            }

            parentView.lowPrice.text = convertPrice(p.MinPrice)

            parentView.setOnClickListener {
                //todo add link
            }
        }

        private fun convertPrice(price: Int): String {
            var out = ""
            var count = 0
            while (price > 0) {
                if (count % 3 == 0) {
                    out = ",$out"
                }
                count++
                when (price % 10) {
                    0 -> out = "\u06f0" + out
                    1 -> out = "\u06f1" + out
                    2 -> out = "\u06f2" + out
                    3 -> out = "\u06f3" + out
                    4 -> out = "\u06f4" + out
                    5 -> out = "\u06f5" + out
                    6 -> out = "\u06f6" + out
                    7 -> out = "\u06f7" + out
                    8 -> out = "\u06f8" + out
                    9 -> out = "\u06f9" + out
                }

            }

            return " تومان$out"
        }
    }
}