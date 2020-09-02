package com.example.appcontact

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.appcontact.`class`.Contacts
import com.example.appcontact.databinding.ActivityDetailContactBinding
import kotlinx.android.synthetic.main.activity_detail_contact.*

class DetailContact : AppCompatActivity() {
    private var binding: ActivityDetailContactBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_contact)

        ParceReceivedContact()?.let {
            LoadContacts(it)

        }
    }

    /*
    * Funcion de carga de los datos de la clase Contacts y agregandolos a los elementos de la vista
    * */
    private fun LoadContacts(it: Contacts){
        binding?.ViewName?.text = it.name
        binding?.ViewNumber?.text = it.numberPhone.toString()
        binding?.ViewEmail?.text = it.Email
        binding?.imageView?.setImageDrawable(ContextCompat.getDrawable(this,it.photo))

        //Constantes que almacenan el numero y email de el contacto
        val numero = ViewNumber.text
        val email = ViewEmail.text


        CallPhone(numero.toString())


        SendEmail(email.toString())
    }


    //Funcion de llamada telefonica recibiendo un parametro
    private fun CallPhone(number: String){

        //intent de llamada telefonica
        binding?.btnCall?.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel: $number")
            startActivity(intent)
        }
    }

    //Funcion de correo electronico recibiendo un parametro
    private fun SendEmail(Email: String){
        //intent de Envio de correo electronico
        binding?.btnEmail?.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/html"
            intent.putExtra(Intent.EXTRA_EMAIL, arrayOf("$Email"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Hola Amigo mio")
            intent.putExtra(Intent.EXTRA_TEXT, "Este es el cuerpo del Mensaje")
            startActivity(intent)
        }
    }

    /*
    * funcion que recive los parametros de la clase para poder utilizarlos atraves de la key
    * */
    private fun ParceReceivedContact(): Contacts? = intent.getParcelableExtra(CONTACT_KEY)

    //Asignacion de la constante key
    companion object {
        const val CONTACT_KEY = "contact.key"

    }
}