package ir.saatgroup.digikala.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProviders
import ir.saatgroup.digikala.R
import ir.saatgroup.digikala.SliderImageLoaderService
import ir.saatgroup.digikala.adapters.MainSliderAdapter
import ir.saatgroup.digikala.data.pojo.Banner
import ir.saatgroup.digikala.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import ss.com.bannerslider.Slider

class MainActivity : AppCompatActivity() {
    private lateinit var sliderImages: LiveData<List<Banner>>
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var sliderAdapter: MainSliderAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Slider.init(SliderImageLoaderService())
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        sliderImages = viewModel.getSliders()
        val slider = banner_slider
        sliderAdapter = MainSliderAdapter(sliderImages.value!!)
        slider.setAdapter(sliderAdapter)

    }
}
