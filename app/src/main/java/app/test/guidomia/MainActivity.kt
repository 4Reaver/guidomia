package app.test.guidomia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import app.test.guidomia.databinding.ActivityMainBinding
import app.test.guidomia.ui.CarsAdapter
import app.test.guidomia.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = CarsAdapter(emptyArray())

        ContextCompat.getDrawable(baseContext, R.drawable.items_separator)?.let {
            val decoration = CustomDividerItemDecoration(baseContext, DividerItemDecoration.VERTICAL)

            decoration.setDrawable(it)
            binding.contentMain.rvList.addItemDecoration(decoration)
        }
        binding.contentMain.rvList.layoutManager = LinearLayoutManager(baseContext)
        binding.contentMain.rvList.adapter = adapter

        viewModel.cars.observe(this) {
            it?.let {
                adapter.updateData(it)
            }
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)

        binding.contentMain.nsvContentRoot.scrollTo(0,0)
    }
}
