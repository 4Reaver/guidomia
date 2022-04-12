package app.test.guidomia.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import app.test.guidomia.data.Car
import app.test.guidomia.repository.CarsRepo

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val repository = CarsRepo(application.applicationContext)
    private val _cars = MutableLiveData<Array<Car>>()
    val cars: LiveData<Array<Car>> = _cars

    init {
        _cars.postValue(repository.getCars())
    }

}
