package com.example.appcontact

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.appcontact.DetailContact.Companion.CONTACT_KEY
import com.example.appcontact.`class`.Contacts
import com.example.appcontact.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null


    private val contact1 = Contacts("William", 65987632, "williamG@hotmail.com", R.drawable.contact)
    private val contact2 = Contacts("Alberto", 78631547, " Alber234@gmail.com", R.drawable.contact)
    private val contact3 = Contacts("Daniel", 60356978, "Dan13l@hotmail.com", R.drawable.contact)
    private val contact4 = Contacts("Mateo", 69624555, "M4t30mm@gmail.com", R.drawable.contact)
    private val contact5 = Contacts("Marcos", 70236958, "MMarcosss@hotmail.com", R.drawable.contact)
    private val contact6 = Contacts("Gael", 73145684, "Ga3lll@hotmail.com", R.drawable.contact)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        loadContactsData()

    }


    private fun loadContactsData(){

        binding?.NameContact1?.text = contact1.name
        binding?.NameContact2?.text = contact2.name
        binding?.NameContact3?.text = contact3.name
        binding?.NameContact4?.text = contact4.name
        binding?.NameContact5?.text = contact5.name
        binding?.NameContact6?.text = contact6.name


        setClickContact()

    }

    private fun setClickContact(){
        binding?.person1?.setOnClickListener {
            launchContactIntent(contact1)

        }
        binding?.person2?.setOnClickListener {
            launchContactIntent(contact2)

        }
        binding?.person3?.setOnClickListener {
            launchContactIntent(contact3)

        }
        binding?.person4?.setOnClickListener {
            launchContactIntent(contact4)

        }
        binding?.person5?.setOnClickListener {
            launchContactIntent(contact5)

        }
        binding?.person6?.setOnClickListener {
            launchContactIntent(contact6)

        }
    }

    private fun launchContactIntent(contactos: Contacts){
        val intent = Intent(this, DetailContact::class.java)
        intent.putExtra(CONTACT_KEY, contactos)
        startActivity(intent)
    }
}