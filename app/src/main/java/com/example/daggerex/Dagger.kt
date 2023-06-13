package com.example.daggerex

import dagger.Component
import dagger.Module
import dagger.Provides

@Component (modules = [AppModule::class])
interface AppComponent {
    fun computer() : Computer.Computer  //can be as function to provide this dependency
    //   val computer : Main.Computer //can be as property
}

@Module
object AppModule {

    @Provides
    fun provideComputer(
        processor: Computer.Processor,
        ram: Computer.RAM,
        motherboard: Computer.Motherboard
    ): Computer.Computer {

        return Computer.Computer(
            processor = Computer.Processor(),
            ram = Computer.RAM(),
            motherboard = Computer.Motherboard()
        )
    }

    @Provides
    fun provideProcessor(): Computer.Processor {
        return Computer.Processor()
    }
    @Provides
    fun provideRam(): Computer.RAM {
        return Computer.RAM()
    }
    @Provides
    fun provideMotherboard(): Computer.Motherboard {
        return Computer.Motherboard()
    }
}