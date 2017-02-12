package rithack.definitelynotstreetracing;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

import android.Manifest;
import android.content.pm.PackageManager;
import android.icu.text.DateFormat;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

import java.util.Date;

public class APIActivity extends FragmentActivity
        implements GoogleApiClient.ConnectionCallbacks, OnConnectionFailedListener, LocationListener {


    private GoogleApiClient mGoogleApiClient;
    private Location mCurrentLocation;
    private LocationRequest mLocationRequest;
    public boolean mRequestingLocationUpdates = true;
    public String lastUpdateTime;

    public APIActivity() {
        Bundle temp = new Bundle();
        temp.putString("message", "this is a test");
        onCreate(temp);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Create a GoogleApiClient instance
        Log.d("tacos","i hate myself");
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();

        // Now make a location request and set it up to handle high accuracy pinging
        Log.d("fun","i hate myself");
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(1600);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        onStart();
    }

    protected void onStart() {
        super.onStart();
        mGoogleApiClient.connect();
    }

    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    @Override
    public void onConnected(Bundle connectionHint) {
        if (mRequestingLocationUpdates) {
            startLocationUpdates();
        }
    }

    @Override
    public void onConnectionSuspended(int i) {
        System.out.println("connection has been suspended");
    }

    protected void startLocationUpdates() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(
                mGoogleApiClient, mLocationRequest, (LocationListener) this);
    }

    @Override
    public void onLocationChanged(Location location) {
        mCurrentLocation = location;
        //lastUpdateTime = DateFormat.getTimeInstance().format(new Date());
        Log.d("STATE",mCurrentLocation.toString());
    }

    public Location getLocation(){
        return mCurrentLocation;
    }
    @Override
    public void onConnectionFailed(ConnectionResult result) {
        // Was not able to make it work 

        // ...
        System.out.println("Things have broken");
        System.exit(-1);
    }

}