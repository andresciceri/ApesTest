package jamsapp.apestest.views.base

import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import android.view.Gravity
import android.app.Dialog
import android.app.ProgressDialog
import android.view.LayoutInflater
import android.text.Html
import android.view.View
import android.view.Window
import com.google.android.material.snackbar.Snackbar
import android.os.Build
import androidx.appcompat.app.AlertDialog
import android.content.DialogInterface
import jamsapp.apestest.R
import kotlinx.android.synthetic.main.layout_decision.*
import kotlinx.android.synthetic.main.layout_compound_toast.*
import kotlinx.android.synthetic.main.layout_simple_toast.*

open class BaseActivity: AppCompatActivity() {

    lateinit var progressDialog: ProgressDialog

    fun showProgressDialog(title: String?, message: String, indeterminate: Boolean, cancelable: Boolean){
        progressDialog = ProgressDialog.show(this@BaseActivity, title, message, indeterminate, cancelable)
    }

    fun hideProgressDialog() {
        if(progressDialog.isShowing)
            progressDialog.dismiss()
    }

    fun showAlertDialogList(title: String, resArray: Array<String>, dialogListener: DialogInterface.OnClickListener){

        var alertDialog: AlertDialog.Builder = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AlertDialog.Builder(this@BaseActivity, R.style.AlertDialogTheme)
        } else {
            AlertDialog.Builder(this@BaseActivity)
        }
        alertDialog.setTitle(title).setItems(resArray, dialogListener)
        alertDialog.create().show()
    }

    fun showDialog(content: String, textNegativeButton: String, textPositiveButton: String){

        val dialog = Dialog(this@BaseActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.layout_decision)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N)
            dialog_tv.text = Html.fromHtml(content, Html.FROM_HTML_MODE_LEGACY)
        else
            dialog_tv.text = Html.fromHtml(content)

        textNegDialog.text = textNegativeButton
        textPosDialog.text = textPositiveButton
        textPosDialog.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }

    fun showCompoundToast(content: String, imgResource: Int){

        val inflater = LayoutInflater.from(this@BaseActivity)
        val layout = inflater.inflate(R.layout.layout_compound_toast, null)
        imageCompound.setImageResource(imgResource)
        tvCompound.text = content

        val mToast = Toast(this@BaseActivity)
        mToast.setGravity(Gravity.CENTER, 0, 0)
        mToast.duration = Toast.LENGTH_LONG
        mToast.view = layout
        mToast.show()
    }

    fun showSimpleToast(content: String) {

        val inflater = LayoutInflater.from(this@BaseActivity)
        val layout = inflater.inflate(R.layout.layout_simple_toast, null)
        tvSimple.text = content

        val mToast = Toast(this@BaseActivity)
        mToast.setGravity(Gravity.CENTER, 0, 0)
        mToast.duration = Toast.LENGTH_LONG
        mToast.view = layout
        mToast.show()
    }

    fun showSnackBar(view: View, message: String, length: Int) {
        Snackbar
            .make(view, message, length)
            .show()
    }
}