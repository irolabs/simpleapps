package com.kodeiro.simpleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.ddd.androidutils.DoubleClick
import com.ddd.androidutils.DoubleClickListener
import com.werdpressed.partisan.rundo.RunDo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, DoubleClickListener,
    RunDo.TextLink {

    private lateinit var runDo: RunDo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnReverse.setOnClickListener(this)
        runDo = RunDo.Factory.getInstance(supportFragmentManager)
        val doubleClick = DoubleClick(this)
        btnUnRe.setOnClickListener(doubleClick)
    }

    private fun reverseInput(inputtext: String): String = inputtext.reversed()

    private fun validate(): Boolean {
        if (edtInput.text.toString().isEmpty()) {
            val errMssg = "Input Text Wajib Diisi"
            edtInput.error = errMssg
            return false
        }
        return true
    }


    override fun onClick(v: View?) {
        if (v?.id == R.id.btnReverse) {
            if (validate()) {
                val reverse = reverseInput(edtInput.text.toString())
                tvOutput.text = reverse
            }
        }

    }


    override fun onSingleClickEvent(view: View?) {
        if (validate()) {
            runDo.undo()
            val mssg = "Anda Melakukan Undo"
            Toast.makeText(applicationContext, mssg, Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDoubleClickEvent(view: View?) {
        runDo.redo()
        val mssg = "Anda Melakukan Redo"
        Toast.makeText(applicationContext, mssg, Toast.LENGTH_SHORT).show()
    }

    override fun getEditTextForRunDo(): EditText {
        return edtInput
    }


}