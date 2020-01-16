package ir.saatgroup.digikala.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.saatgroup.digikala.R
import ir.saatgroup.digikala.data.pojo.Category
import kotlinx.android.synthetic.main.category_holder_main_menu.view.*

class RecycleViewAdapterCategoryTab(private val inflater: LayoutInflater, var dataSource: List<Category>) :
    RecyclerView.Adapter<RecycleViewAdapterCategoryTab.ItemHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        return ItemHolder(inflater.inflate(R.layout.category_holder_main_menu,parent, false))
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bindClass(dataSource[position])
    }


    class ItemHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var parentView: View = v
        private var category: Category? = null
        fun bindClass(c: Category) {
            this.category = c
            parentView.title.text = c.Title
            parentView.image.setImageURI(c.ImagePath)
            parentView.setOnClickListener {

            }
        }
    }

}
