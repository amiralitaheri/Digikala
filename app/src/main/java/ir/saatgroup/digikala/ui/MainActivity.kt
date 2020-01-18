package ir.saatgroup.digikala.ui

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProviders
import com.facebook.drawee.backends.pipeline.Fresco
import ir.saatgroup.digikala.R
import ir.saatgroup.digikala.adapters.ChipAdapter
import ir.saatgroup.digikala.adapters.MainSliderAdapter
import ir.saatgroup.digikala.data.pojo.Banner
import ir.saatgroup.digikala.data.pojo.CategoryWithSub
import ir.saatgroup.digikala.data.pojo.Product
import ir.saatgroup.digikala.utils.SliderImageLoaderService
import ir.saatgroup.digikala.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import ss.com.bannerslider.Slider
import java.util.*


class MainActivity : AppCompatActivity() {


    private lateinit var viewModel: MainActivityViewModel

    private lateinit var sliderImages: LiveData<List<Banner>>
    private lateinit var sliderAdapter: MainSliderAdapter

    private lateinit var category: LiveData<List<CategoryWithSub>>
    private lateinit var chipAdapter: ChipAdapter


    private lateinit var advBanners: LiveData<List<Banner>>
    private lateinit var mobileBanners: LiveData<List<List<Banner>>>


    private lateinit var topSellers: LiveData<List<Product>>
    private lateinit var topSellersFragment: ProductRowFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        Slider.init(SliderImageLoaderService())
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        //slider
        sliderImages = viewModel.getSliders()
        val slider = banner_slider
        sliderAdapter = MainSliderAdapter(sliderImages.value!!)
        slider.setAdapter(sliderAdapter)

        //category chip
        category = viewModel.getCategory()
        val chipView = chipRecycler
        chipAdapter = ChipAdapter(this.layoutInflater, category.value!!)
        chipView.adapter = chipAdapter

        //special offers
        val c = Calendar.getInstance()
        c.add(Calendar.DAY_OF_MONTH, 1)
        c.set(Calendar.HOUR_OF_DAY, 0)
        c.set(Calendar.MINUTE, 0)
        c.set(Calendar.SECOND, 0)
        c.set(Calendar.MILLISECOND, 0)
        val howMany = c.timeInMillis - System.currentTimeMillis()
        object : CountDownTimer(howMany, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                var remainingTime = millisUntilFinished / 1000
                val sec: String = "%02d".format(remainingTime % 60)
                remainingTime /= 60
                val min: String = "%02d".format(remainingTime % 60)
                remainingTime /= 60
                val hour: String = "%02d".format(remainingTime % 60)
                secondCounter.text = sec
                minuteCounter.text = min
                hourCounter.text = hour
            }

            override fun onFinish() {
            }
        }.start()
        val incredibleProductsRowFragment: IncredibleProductsRowFragment =
            specialOfferFragmentView as IncredibleProductsRowFragment
        incredibleProductsRowFragment.setData(viewModel.getIncredibleOffers().value!!)

        //banners
        advBanners = viewModel.getAdvBanners()
        advBanner1.setImageURI(advBanners.value!![0].PatternImagePath)
        advBanner2.setImageURI(advBanners.value!![1].PatternImagePath)
        mobileBanners = viewModel.getMobileBanners()
        //small
        mobileBanner2.setImageURI(mobileBanners.value!![0][0].PatternImagePath)
        mobileBanner3.setImageURI(mobileBanners.value!![0][1].PatternImagePath)
        mobileBanner5.setImageURI(mobileBanners.value!![0][2].PatternImagePath)
        mobileBanner6.setImageURI(mobileBanners.value!![0][3].PatternImagePath)
        //large
        mobileBanner1.setImageURI(mobileBanners.value!![1][0].PatternImagePath)
        mobileBanner4.setImageURI(mobileBanners.value!![1][1].PatternImagePath)

        //topSellers
        topSellers = viewModel.getTopSellers()
        topSellersFragment = topSellersFragmentView as ProductRowFragment
        topSellersFragment.setData("محصولات پرفروش", topSellers.value!!, true, "", false)

        //newest
        (newestFragmentView as ProductRowFragment).setData(
            "جدیدترین محصولات",
            viewModel.getNewest().value!!,
            true,
            "",
            false
        )

        //cat1
        (cate1FragmentView as ProductRowFragment).setData(
            "موبایل",
            viewModel.getAllTopByCategory("c1"),
            false,
            "",
            false
        )
        //cat2
        (cate2FragmentView as ProductRowFragment).setData(
            "صوتی و تصویری",
            viewModel.getAllTopByCategory("c7"),
            false,
            "",
            false
        )
        //cat3
        (cate3FragmentView as ProductRowFragment).setData(
            "کتاب و مجلات",
            viewModel.getAllTopByCategory("c5917"),
            false,
            "",
            false
        )
        //cat4
        (cate4FragmentView as ProductRowFragment).setData(
            "لبنیات",
            viewModel.getAllTopByCategory("c9208"),
            false,
            "",
            false
        )


        //drawer
        toolbar.menuButton.setOnClickListener {
            drawerLayout.openDrawer(drawer)
        }

        val intent = Intent(this, MainMenuActivity::class.java)
        drawer.menu.getItem(1).setOnMenuItemClickListener {
            drawerLayout.closeDrawer(GravityCompat.END)
            startActivity(intent)
            true
        }


    }
}
