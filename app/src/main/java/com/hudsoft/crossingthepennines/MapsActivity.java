package com.hudsoft.crossingthepennines;

import android.support.v7.app.*;
import android.os.Bundle;

import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.*;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.view.*;
import android.widget.*;

public class MapsActivity extends ActionBarActivity{

    //Maps API V2 Sample code from https://developers.google.com/maps/documentation/android/

    //Map usage variables
    public GoogleMap mMap;
    public boolean isMyLocationVisible;
    public Polyline polyRoad;
    public Polyline polyCrowFlies;
    public GoogleMap.OnInfoWindowClickListener infoWindowListener;

    //Android uses a different constructor system, using onCreate instead of the name of the class
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        isMyLocationVisible = true;

        if(mMap == null) {
                loadMap();
        }else{
            //Map Loaded Successfully
        }
        addMapDetails();
    }


    //Displays the menu when the icon in the top right is clicked/pressed
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        return true;
    }

    public void loadMap()
    {
        mMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.myMap)).getMap();
    }

    //These are the actions taken by pressing the display and menu buttons
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.normal:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case R.id.hybrid:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
            case R.id.terrain:
                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
                break;
            case R.id.satellite:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.showMyLocation:
                displayMyLocation();
                break;
            case R.id.road:
                toggleRoadRouteDisplay();
                break;
            case R.id.crowFlies:
                toggleCrowFliesRouteDisplay();
                break;
            case R.id.action_about:
                openAbout();
                break;
        }
        return true;
    }

    //This method flips the boolean value of isMyLocationVisible and toggles the users location marker on the map.
    public void displayMyLocation()
    {
        isMyLocationVisible = !isMyLocationVisible;
        mMap.setMyLocationEnabled(isMyLocationVisible);
    }

    public void openWebsiteInBrowser(View view)
    {
        String url = "http://crossingthepennines.co.uk/";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    public void openFaceBook(View view)
    {
        String url = "https://www.facebook.com/groups/crossingthepenninesheritagetrail/";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    public void openTwitter(View view)
    {
        String url = "https://twitter.com/storiesinstone";
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    public void toggleRoadRouteDisplay()
    {
        if (polyRoad.isVisible() == true)
        {
            polyRoad.setVisible(false);
        }else
        {
            polyRoad.setVisible(true);
        }
    }

    public void toggleCrowFliesRouteDisplay()
    {
        if (polyCrowFlies.isVisible() == true)
        {
            polyCrowFlies.setVisible(false);
        }else
        {
            polyCrowFlies.setVisible(true);
        }
    }

    public void addMapDetails()
    {
        if (mMap != null){
            //Map variables using degrees as the coordinates
            LatLng slaithwaite = new LatLng(53.621882,-1.882589693);
            LatLng marsden = new LatLng(53.600170, -1.929046);

            //Focuses camera on Slaithwaite on launch
            mMap.setMyLocationEnabled(true);
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(slaithwaite, 13));

            //Creates map marker at Slaithwaite
            mMap.addMarker(new MarkerOptions()
                    .title("Slaithwaite")
                    .snippet("It has a railway station")
                    .position(slaithwaite));

            //Creates map marker at Marsden
            mMap.addMarker(new MarkerOptions()
                    .title("Marsden")
                    .snippet("It is 7 miles west of Huddersfield")
                    .position(marsden)
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.newmarker)));     //newmarker used in place of default

            //Creates a line between Marsden and Slaithwaite, using the coordinates of several points on the road
            polyRoad = mMap.addPolyline(new PolylineOptions()
                            .add(marsden)
                            .add(new LatLng(53.60000424560, -1.926208958029))
                            .add(new LatLng(53.60023344594481, -1.92538283765316))
                            .add(new LatLng(53.60063454354268, -1.92438505589962))
                            .add(new LatLng(53.600952872258745, -1.9236340373754501))
                            .add(new LatLng(53.601239366052134, -1.9230010360479355))
                            .add(new LatLng(53.60150675850613, -1.922464594244957))
                            .add(new LatLng(53.60170411851738, -1.9222178310155869))
                            .add(new LatLng(53.60252418723585, -1.9213347136974335))
                            .add(new LatLng(53.60286796676579, -1.9209055602550507))
                            .add(new LatLng(53.603377264629906, -1.9204120337963104))
                            .add(new LatLng(53.603708304948405, -1.920025795698166))
                            .add(new LatLng(53.60423032479431, -1.919746845960617))
                            .add(new LatLng(53.6046886783637, -1.9193391501903534))
                            .add(new LatLng(53.60501970840362, -1.9190387427806854))
                            .add(new LatLng(53.60536346762195, -1.9187597930431366))
                            .add(new LatLng(53.60573268736956, -1.9184593856334686))
                            .add(new LatLng(53.606076440784705, -1.9181375205516815))
                            .add(new LatLng(53.60644565429927, -1.9177298247814178))
                            .add(new LatLng(53.60667481968479, -1.917300671339035))
                            .add(new LatLng(53.606954909022825, -1.9168071448802948))
                            .add(new LatLng(53.6072349965032, -1.9161848723888397))
                            .add(new LatLng(53.60757873769031, -1.9153694808483124))
                            .add(new LatLng(53.6077951658912, -1.9147472083568573))
                            .add(new LatLng(53.60806251684331, -1.9140176475048065))
                            .add(new LatLng(53.60825348077284, -1.91318079829216))
                            .add(new LatLng(53.60830440434153, -1.9122795760631561))
                            .add(new LatLng(53.60835532784881, -1.9117645919322968))
                            .add(new LatLng(53.608482636348356, -1.9112281501293182))
                            .add(new LatLng(53.6087499829482, -1.9108204543590546))
                            .add(new LatLng(53.60904278918694, -1.91043421626091))
                            .add(new LatLng(53.609411976768044, -1.9096188247203827))
                            .add(new LatLng(53.609666587012356, -1.9089536368846893))
                            .add(new LatLng(53.609933926116675, -1.9081811606884003))
                            .add(new LatLng(53.610328566463, -1.9070439040660858))
                            .add(new LatLng(53.610672282469245, -1.9060997664928436))
                            .add(new LatLng(53.610977805459335, -1.9053058326244354))
                            .add(new LatLng(53.61138516600737, -1.904340237379074))
                            .add(new LatLng(53.61190709096621, -1.903095692396164))
                            .add(new LatLng(53.61242900947364, -1.9020013511180878))
                            .add(new LatLng(53.612989109963436, -1.900799721479416))
                            .add(new LatLng(53.61351101509612, -1.8999414145946503))
                            .add(new LatLng(53.61403291377747, -1.898997277021408))
                            .add(new LatLng(53.61460572197735, -1.8981175124645233))
                            .add(new LatLng(53.61498758979315, -1.8976883590221405))
                            .add(new LatLng(53.615356725398605, -1.8971090018749237))
                            .add(new LatLng(53.615636757153226, -1.8966369330883026))
                            .add(new LatLng(53.61604407275331, -1.8956713378429413))
                            .add(new LatLng(53.61641319912146, -1.8945984542369843))
                            .add(new LatLng(53.61683323554551, -1.8936114013195038))
                            .add(new LatLng(53.617719037296496, -1.8916191905736923))
                            .add(new LatLng(53.61799268940049, -1.890954002737999))
                            .add(new LatLng(53.61843816577537, -1.88967727124691))
                            .add(new LatLng(53.61870544934382, -1.8888940662145615))
                            .add(new LatLng(53.61896636738537, -1.8881752341985703))
                            .add(new LatLng(53.619469107356984, -1.8867268413305283))
                            .add(new LatLng(53.619666383431614, -1.8861045688390732))
                            .add(new LatLng(53.61987002228354, -1.8853750079870224))
                            .add(new LatLng(53.62020093332265, -1.884387955069542))
                            .add(new LatLng(53.620366387869375, -1.8836476653814316))
                            .add(new LatLng(53.620519114567664, -1.8828537315130234))
                            .add(new LatLng(53.62071002216346, -1.8821027129888535))
                            .add(new LatLng(53.62080547563755, -1.8820919841527939))
                            .add(new LatLng(53.62084365696675, -1.882016882300377))
                            .add(new LatLng(53.62089456535196, -1.8817593902349472))
                            .add(new LatLng(53.620945473675775, -1.8815018981695175))
                            .add(new LatLng(53.62098365487834, -1.881265863776207))
                            .add(new LatLng(53.62102819957102, -1.8809547275304794))
                            .add(new LatLng(53.62109819827882, -1.8806328624486923))
                            .add(new LatLng(53.621174560373106, -1.880589947104454))
                            .add(new LatLng(53.62134637458016, -1.8806865066289902))
                            .add(new LatLng(53.621530914986515, -1.8808259814977646))
                            .add(new LatLng(53.621702727743035, -1.8809225410223007))
                            .add(new LatLng(53.62191272016231, -1.8810512870550156))
                            .add(new LatLng(53.622135438253274, -1.8812014907598495))
                            .add(new LatLng(53.62226906854374, -1.881265863776207))
                            .add(new LatLng(53.62272086305925, -1.8814589828252792))
                            .add(new LatLng(53.622930850413155, -1.88143752515316))
                            .add(new LatLng(53.62312811030914, -1.8813195079565048))
                            .add(new LatLng(53.623249011080006, -1.88119076192379))
                            .add(new LatLng(53.62335082198684, -1.8810834735631943))
                            .add(new LatLng(53.62347172211973, -1.8809547275304794))
                            .add(new LatLng(53.62356716934846, -1.8808474391698837))
                            .add(new LatLng(53.62368170573798, -1.8807079643011093))
                            .add(new LatLng(53.62375170004525, -1.8806221336126328))
                            .color(Color.BLUE)
                            .visible(false)
                            .width(5)
            );

            //direct route between slaithwaite and marsden
            polyCrowFlies = mMap.addPolyline(new PolylineOptions()
                            .add(slaithwaite)
                            .add(marsden)
                            .color(Color.RED)
                            .visible(false)
                            .width(5)
            );

            //Bus stop info window onClick event
            mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                @Override
                public void onInfoWindowClick(Marker marker) {
                    Toast.makeText(getApplicationContext(), "Info Window at "+marker.getTitle()+" pressed", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), InfoActivity.class);
                    String title = marker.getTitle();
                    intent.putExtra("location", title);
                    startActivity(intent);
                }
            });

        }else{
            //Map hasn't loaded
        }

    }

    public void openAbout() {
        Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
        startActivity(intent);
    }

}