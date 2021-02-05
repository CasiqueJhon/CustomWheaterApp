package com.example.customwheaterapp.repository.local

import com.example.customwheaterapp.models.LocationData
import com.example.customwheaterapp.utils.RequestCompleteListener

interface LocationProviderInterface {
    fun getUserCurrentLocation(callback:RequestCompleteListener<LocationData>)
}