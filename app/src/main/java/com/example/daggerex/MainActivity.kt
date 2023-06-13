package com.example.daggerex

import android.app.Application
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import javax.inject.Inject

//add main clas for storage dependency graph for all application

class MainApp : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}

//in order to get this component we create extension for context
val Context.appComponent: AppComponent
    get () = when (this) {
        is MainApp -> appComponent
        else -> this.applicationContext.appComponent
    }

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var computer: Computer   //we will inject INTO this field our component

    //use lateinit only in dagger

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        appComponent.inject(this)

    }
}