package com.example.customwheaterapp.observer

class Observable<T> {

    private var observers = emptyList<T>()

    fun addObserver(observer: (T)) {
        observers = observers + observer
    }

    fun clearObservers() {
        observers = emptyList()
    }

    fun callObservers(newValue: T) {
        observers.forEach { it(newValue) }
    }
}

private operator fun <T> T.invoke(newValue: T) {
    TODO("Not yet implemented")
}
