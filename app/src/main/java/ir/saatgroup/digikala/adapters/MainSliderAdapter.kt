package ir.saatgroup.digikala.adapters

import ir.saatgroup.digikala.data.pojo.Banner
import ss.com.bannerslider.adapters.SliderAdapter
import ss.com.bannerslider.viewholder.ImageSlideViewHolder

class MainSliderAdapter(var dataSource: List<Banner>) : SliderAdapter() {
    override fun getItemCount(): Int {
        return dataSource.size
    }

    override fun onBindImageSlide(position: Int, imageSlideViewHolder: ImageSlideViewHolder?) {
        return imageSlideViewHolder!!.bindImageSlide(dataSource[position].PatternImagePath)
    }
}