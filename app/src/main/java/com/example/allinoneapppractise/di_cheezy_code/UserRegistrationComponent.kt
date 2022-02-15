package kotlin_design_patterns.di

import com.example.allinoneapppractise.di_cheezy_code.DIDemoActivity
import com.example.allinoneapppractise.handler_and_looperbycodinginflow.MainActivity
import dagger.Component

@Component
interface UserRegistrationComponent {
    fun inject(mainActivity: DIDemoActivity)
}