package app.test.guidomia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

        binding.contentMain.rvList.layoutManager = LinearLayoutManager(baseContext)
        val decoration = CustomDividerItemDecoration(baseContext, DividerItemDecoration.VERTICAL)
        decoration.setDrawable(ContextCompat.getDrawable(baseContext, R.drawable.items_separator)!!)
        binding.contentMain.rvList.addItemDecoration(decoration)

        viewModel.cars.observe(this) {
            it?.let {
                binding.contentMain.rvList.adapter = CarsAdapter(it)
            }
        }

    }
}
