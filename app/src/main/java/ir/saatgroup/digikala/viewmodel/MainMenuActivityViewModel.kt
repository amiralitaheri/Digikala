package ir.saatgroup.digikala.viewmodel


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.saatgroup.digikala.data.apiDaos.CategoryApiDao
import ir.saatgroup.digikala.data.pojo.CategoryWithSub
import ir.saatgroup.digikala.data.repository.CategoryRepository

class MainMenuActivityViewModel : ViewModel() {
    private var catList = MutableLiveData<List<CategoryWithSub>>()

    init {
        catList.value = listOf()
    }

    private val repository = CategoryRepository.getInstance(CategoryApiDao)

    fun getMainMenu(): MutableLiveData<List<CategoryWithSub>> {
        catList.value = repository.getMainMenu()
        Log.i("ffff",catList.value.toString())
        return catList
    }
}