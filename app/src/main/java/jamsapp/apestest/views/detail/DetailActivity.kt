package jamsapp.apestest.views.detail

import android.os.Bundle
import android.text.Html
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

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            descriptionDetail.text = Html.fromHtml("<b>Resumen</b>: ".plus(intent.getStringExtra("description") ?: "No disponible"), Html.FROM_HTML_MODE_LEGACY)
            budgetDetail.text = Html.fromHtml("<b>Presupuesto</b>: ".plus(intent.getStringExtra("budget") ?: "No disponible"), Html.FROM_HTML_MODE_LEGACY)
            runtimeDetail.text = Html.fromHtml("<b>Duración</b>: ".plus(intent.getStringExtra("runtime").plus(" min")), Html.FROM_HTML_MODE_LEGACY)
            studiosDetail.text = Html.fromHtml("<b>Estudios</b>: ".plus(intent.getStringExtra("studios") ?: "No disponible"), Html.FROM_HTML_MODE_LEGACY)
            writersDetail.text = Html.fromHtml("<b>Libreto</b>: ".plus(intent.getStringExtra("writers") ?: "No disponible"), Html.FROM_HTML_MODE_LEGACY)
        } else {
            descriptionDetail.text = Html.fromHtml("<b>Resumen</b>: ".plus(intent.getStringExtra("description")))
            budgetDetail.text = Html.fromHtml("<b>Presupuesto</b>: ".plus(intent.getStringExtra("budget") ?: "No disponible"))
            runtimeDetail.text = Html.fromHtml("<b>Duración</b>: ".plus(intent.getStringExtra("runtime").plus(" min")))
            studiosDetail.text = Html.fromHtml("<b>Estudios</b>: ".plus(intent.getStringExtra("studios") ?: "No disponible"))
            writersDetail.text = Html.fromHtml("<b>Libreto</b>: ".plus(intent.getStringExtra("writers") ?: "No disponible"))
        }
    }
}
