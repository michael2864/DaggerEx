package com.example.daggerex

class Computer {
    class Processor {
        override fun toString() = "Processor1"
    }

    class Motherboard {
        override fun toString() = "Motherboard1"
    }

    class RAM {
        override fun toString() = "16gb1"

    }

    data class Computer(
        val processor: Processor,
        val motherboard: Motherboard,
        val ram: RAM

    )
}