package ir.saatgroup.digikala.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.saatgroup.digikala.R
import ir.saatgroup.digikala.data.pojo.IncredibleProduct
import ir.saatgroup.digikala.utils.convertToPrice
import kotlinx.android.synthetic.main.incredible_product_holder_linar.view.*

class IncredibleProductRowRecycleAdapter(
    private val inflater: LayoutInflater,
    var dataSource: List<IncredibleProduct>
) : RecyclerView.Adapter<IncredibleProductRowRecycleAdapter.ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(inflater.inflate(R.layout.incredible_product_holder_linar, parent, false))
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bindClass(dataSource[position])
    }


    class ItemHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var parentView: View = v
        private var incredibleProduct: IncredibleProduct? = null
        fun bindClass(p: IncredibleProduct) {
            this.incredibleProduct = p
            parentView.title.text = p.Title
            parentView.image.setImageURI(p.ImagePaths.Size180)
            parentView.topPrice.text = p.Price.convertToPrice()
            parentView.lowPrice.text = (p.Price - p.Discount).convertToPrice()
            parentView.setOnClickListener {
                //todo add link
            }
        }
    }
}