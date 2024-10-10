package com.mayankbisht.olamaps

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ola.mapsdk.interfaces.OlaMapCallback
import com.ola.mapsdk.model.OlaLatLng
import com.ola.mapsdk.model.OlaMarkerOptions
import com.ola.mapsdk.model.OlaPolylineOptions
import com.ola.mapsdk.view.OlaMap
import com.ola.mapsdk.view.OlaMapView

class MainActivity : AppCompatActivity() {
    private lateinit var mapView: OlaMapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var API_KEY = "YOUR_API_KEY"

        mapView = findViewById(R.id.mapView)

        mapView.getMap(apiKey = API_KEY,
            olaMapCallback = object : OlaMapCallback {
                override fun onMapReady(olaMap: OlaMap) {
                    var latLong = "LAT_LONG"
                    val markerOptions1 = OlaMarkerOptions.Builder()
                        .setMarkerId("marker1")
                        .setPosition(latLong)
                        .setIsIconClickable(true)
                        .setIconRotation(0f)
                        .setIsAnimationEnable(true)
                        .setIsInfoWindowDismissOnClick(true)
                        .build()

                    var marker1 = olaMap.addMarker(markerOptions1)
                    olaMap.moveCameraToLatLong(latLong,15.0)

                    val points = arrayListOf("LIST_OF_LAT_LONG")

                    val polylineOptions = OlaPolylineOptions.Builder()
                        .setPolylineId("pid1")
                        .setPoints(points)
                        .build()

                    var polyline1 = olaMap.addPolyline(polylineOptions)
                }

                override fun onMapError(error: String) {
                    Toast.makeText(this@MainActivity, "Oops !! Error " + error, Toast.LENGTH_SHORT)
                        .show()
                }
            }
        )
    }
}