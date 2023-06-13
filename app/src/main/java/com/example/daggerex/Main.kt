package com.example.daggerex

class Main {
    fun main() {
//create dependency graph
        val appComponent : AppComponent = DaggerAppComponent.create()
        print(appComponent.computer())     //this is point is crucial    we manage by yourself dependency graph store
    }
}