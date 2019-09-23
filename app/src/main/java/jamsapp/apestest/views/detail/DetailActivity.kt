package jamsapp.apestest.views.detail

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import com.squareup.picasso.Picasso
import jamsapp.apestest.R
import jamsapp.apestest.views.base.BaseActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        loadImage()
        setData()
    }

    private fun loadImage(){
        Picasso.with(supportActionBar?.themedContext)
            .load(intent.getStringExtra("banner"))
            .resize(800, 470)
            .into(image)
    }

    private fun setData(){
        collapsing_toolbar.title = intent.getStringExtra("title")
        collapsing_toolbar.setExpandedTitleColor(resources.getColor(android.R.color.transparent))

        titleDetail.text = intent.getStringExtra("title")
        descriptionDetail.text = "Resumen: ".plus(intent.getStringExtra("description") ?: "No disponible")
        budgetDetail.text = "Presupuesto: ".plus(intent.getStringExtra("budget") ?: "No disponible")
        runtimeDetail.text = "Duración: ".plus(intent.getStringExtra("runtime") ?: "No disponible")
        studiosDetail.text = "Estudios: ".plus(intent.getStringExtra("studios") ?: "No disponible")
        writersDetail.text = "Libreto: ".plus(intent.getStringExtra("writers") ?: "No disponible")
    }
}
