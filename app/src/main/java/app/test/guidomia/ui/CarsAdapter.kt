package app.test.guidomia.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import app.test.guidomia.R
import app.test.guidomia.data.Car
import app.test.guidomia.databinding.ItemCarBinding

class CarsAdapter(private var dataset: Array<Car>) : RecyclerView.Adapter<CarsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataset[position])
    }

    override fun getItemCount() = dataset.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateData(array: Array<Car>) {
        dataset = array
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemCarBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(car: Car) {
            binding.apply {
                car.image?.let {
                    ivImage.setImageResource(it)
                }
                tvName.text = binding.root.context.getString(R.string.car_name, car.make, car.model)
                tvPrice.text = tvPrice.context.getString(R.string.car_price, car.price)
                rbRating.progress = car.rating
            }
        }
    }
}
