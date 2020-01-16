package ir.saatgroup.digikala.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager2.widget.ViewPager2
import com.facebook.drawee.backends.pipeline.Fresco
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import ir.saatgroup.digikala.R
import ir.saatgroup.digikala.adapters.ViewPagerAdapterMainMenu
import ir.saatgroup.digikala.data.pojo.CategoryWithSub
import ir.saatgroup.digikala.viewmodel.MainMenuActivityViewModel
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AppCompatActivity() {
    private lateinit var liveData: LiveData<List<CategoryWithSub>>
    private lateinit var viewPager: ViewPager2
    private lateinit var viewPagerAdapterMain: ViewPagerAdapterMainMenu
    private lateinit var viewModel: MainMenuActivityViewModel
    private lateinit var tabs: TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        setContentView(R.layout.activity_main_menu)
        viewModel = ViewModelProviders.of(this).get(MainMenuActivityViewModel::class.java)
        liveData = viewModel.getMainMenu()
        viewPager = viewPagerMainMenu
        viewPagerAdapterMain = ViewPagerAdapterMainMenu(supportFragmentManager, lifecycle, liveData.value!!)
        val observer = Observer<List<CategoryWithSub>> {
            viewPagerAdapterMain.data = it
            viewPagerAdapterMain.notifyDataSetChanged()
        }
        liveData.observe(this, observer)
        viewPager.adapter = viewPagerAdapterMain
        tabs = slidingTabs
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            tab.text = liveData.value!![position].Category.Title
            viewPager.setCurrentItem(tab.position, true)
        }.attach()
        val b = backButton
        b.setOnClickListener { finish() }

//        this.toolbar(
//            noElevation = true,
//            showBack = true,
//            showTitle = true,
//            title = "دسته بندی محصولات"
//        )
    }
}
