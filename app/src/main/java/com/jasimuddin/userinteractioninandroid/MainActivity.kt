package com.jasimuddin.userinteractioninandroid

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    lateinit var toast:Button
    lateinit var snackBar:Button
    lateinit var layout:ConstraintLayout
    lateinit var dialogMessage:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toast=findViewById(R.id.buttonToast)
        snackBar=findViewById(R.id.buttonSnackBar)
        layout=findViewById(R.id.constraintLayout)
        dialogMessage=findViewById(R.id.buttonDialog)

        toast.setOnClickListener {

            Toast.makeText(applicationContext,"This is a toast message",Toast.LENGTH_LONG).show()

        }

        snackBar.setOnClickListener {

            Snackbar.make(layout,"This is a Snack Bar Message",Snackbar.LENGTH_INDEFINITE)
                .setAction("Close",View.OnClickListener {

            }).show()

        }

        dialogMessage.setOnClickListener {

            showAlertDialog()

        }

    }

    fun showAlertDialog(){

        val alertDialog=AlertDialog.Builder(this@MainActivity)
        alertDialog.setTitle("Change")
            .setMessage("Do you change the message")
            .setIcon(R.drawable.warning)
            .setCancelable(false)
            .setNegativeButton("No", DialogInterface.OnClickListener { dialogInterface, which ->
                dialogInterface.cancel()
            })
            .setPositiveButton("Yes", DialogInterface.OnClickListener { dialogInterface, which ->
                dialogMessage.text="Dialog Message Change"
            })
        alertDialog.create().show()

    }
}