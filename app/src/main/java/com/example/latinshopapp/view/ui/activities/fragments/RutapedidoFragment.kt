package com.example.latinshopapp.view.ui.activities.fragments

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.example.latinshopapp.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions


class RutapedidoFragment : Fragment(),OnMapReadyCallback {

    private lateinit var googleMap:GoogleMap




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val view=inflater.inflate(R.layout.fragment_rutapedido, container, false)

        //map
        val mapFragment=this.childFragmentManager.findFragmentById(R.id.map_view) as SupportMapFragment

        mapFragment.getMapAsync(this)

        return view


    }

    override fun onMapReady(map: GoogleMap) {

        val colombia=LatLng(4.564435,-74.12312)
        map?.let {
            this.googleMap=it
            googleMap.addMarker(MarkerOptions().position(colombia))
        }
        enableLocation()
    }


    private fun isLocationPermissionGrated()=ContextCompat.checkSelfPermission(this.requireContext(),
        Manifest.permission.ACCESS_FINE_LOCATION)==PackageManager.PERMISSION_GRANTED

    @SuppressLint("MissingPermission")
    private fun enableLocation(){
        if(!::googleMap.isInitialized)return
        if (isLocationPermissionGrated()){
            googleMap.isMyLocationEnabled=true
        }else{
            requestLocationPermission()
        }
    }

    companion object{
        const val REQUEST_CODE_LOCATION=0
    }

    //PIDIENDO PERMISOS
    private fun requestLocationPermission() {
        if(ActivityCompat.shouldShowRequestPermissionRationale(
                this.requireActivity(),Manifest.permission.ACCESS_FINE_LOCATION
        )){
            Toast.makeText(context,"requiere activar permisios en ajustes",Toast.LENGTH_SHORT).show()
        }else{
            ActivityCompat.requestPermissions(this.requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_CODE_LOCATION)
        }
    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            REQUEST_CODE_LOCATION -> if(grantResults.isNotEmpty()&&grantResults[0]==PackageManager.PERMISSION_GRANTED){
                googleMap.isMyLocationEnabled=true
            }else{
                Toast.makeText(context,"para Activar la localizacion vaya a los ajustes ya ceptes los permisos",Toast.LENGTH_SHORT).show()
            }
        }
    }
}