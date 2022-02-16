package com.anushka.didemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.allinoneapppractise.R
import com.example.allinoneapppractise.didemo.DaggerSmartPhoneComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var smartPhone: SmartPhone
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerSmartPhoneComponent.create().inject(this)

        /*val battery = Battery()
        val memoryCard = MemoryCard()
        val serviceProvider = ServiceProvider()
        val simCard = SIMCard(serviceProvider)*/
        /*val smartPhone = SmartPhone(
            Battery(),
            SIMCard(ServiceProvider()),
            MemoryCard()
        )

        smartPhone.makeACallWithRecording()*/
    }
}
