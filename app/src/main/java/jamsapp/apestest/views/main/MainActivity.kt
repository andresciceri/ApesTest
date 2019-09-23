package jamsapp.apestest.views.main

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import jamsapp.apestest.R
import jamsapp.apestest.data.models.Results
import jamsapp.apestest.utilities.Animations
import jamsapp.apestest.views.adapters.MoviesAdapter
import jamsapp.apestest.views.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    private lateinit var viewModel: MainViewModel
    private var model: List<Results>? = null
    var animations = Animations()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        loadData()
    }

    private fun setupViewModel(){
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.resultListLiveData.observe(this, Observer {
            model = it
            setUpRecycler()
        })
        viewModel.singleLiveEvent.observe(this, Observer {
            hideProgressDialog()
            when(it){
                is MainViewModel.ViewEvent.ResponseSuccess -> {
                    //Toast.makeText(supportActionBar?.themedContext, "All is correct", Toast.LENGTH_LONG).show()
                }
                is MainViewModel.ViewEvent.ResponseError -> {
                    Toast.makeText(supportActionBar?.themedContext, it.error, Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    private fun loadData(){
        val connMgr = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connMgr.activeNetworkInfo
        if (networkInfo != null && networkInfo.isConnected) {
            showProgressDialog("Cargando lista", "Espera un momento por favor", indeterminate = false, cancelable = false)
            viewModel.getAllMovies()

        } else {
            showSimpleToast("Al parecer no tienes conexión a internet")
        }
    }

    private fun setUpRecycler(){
        val staggeredGridLayoutManager =
            setNumberOfColumns()?.let { StaggeredGridLayoutManager(it, StaggeredGridLayoutManager.VERTICAL) }
        val adapter = MoviesAdapter(model)
        recycler.layoutManager = staggeredGridLayoutManager
        recycler.adapter = adapter
        animations.runRecyclerAnimation(recycler)
    }

    private fun setNumberOfColumns(): Int? {
        val displayMetrics = supportActionBar?.themedContext?.resources?.displayMetrics
        val dpWidth = displayMetrics?.widthPixels?.div(displayMetrics.density)
        var numberOfColumns = (dpWidth?.div(160))?.toInt()
        //numberOfColumns = numberOfColumns?.plus(1)
        return numberOfColumns
    }
}
