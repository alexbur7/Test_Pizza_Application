package com.example.testpizzaapplication.presentation.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.testpizzaapplication.domain.usecase.AllBeersUseCase
import com.example.testpizzaapplication.domain.usecase.StrongBeersUseCase
import com.example.testpizzaapplication.presentation.menu.entity.BeerEntity
import com.example.testpizzaapplication.presentation.util.ErrorHandler
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    private val allBeersUseCase: AllBeersUseCase,
    private val strongBeersUseCase: StrongBeersUseCase,
    private val errorHandler: ErrorHandler
) : ViewModel() {

    val beersData: LiveData<List<BeerEntity>>
        get() = _beersData
    private val _beersData = MutableLiveData<List<BeerEntity>>()
    private val compositeDisposable = CompositeDisposable()

    init {
        getAllBeers()
    }

    fun getAllBeers() {
        compositeDisposable.add(allBeersUseCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { beers ->
                    _beersData.value = beers
                },
                {
                    errorHandler.createErrorToast(it)
                }
            )
        )
    }

    fun getStrongBeers(fortress: Float = 6f) {
        compositeDisposable.add(
            strongBeersUseCase(fortress)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { beers ->
                        _beersData.value = beers
                    },
                    {
                        errorHandler.createErrorToast(it)
                    }
                )
        )
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
