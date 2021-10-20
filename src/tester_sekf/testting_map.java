package tester_sekf;

//import java.util.ArrayList;
import java.util.*;

import de.fhpotsdam.unfolding.UnfoldingMap;
import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.geo.Location;
import de.fhpotsdam.unfolding.marker.Marker;
import de.fhpotsdam.unfolding.marker.SimplePointMarker;
import de.fhpotsdam.unfolding.providers.Google;
import de.fhpotsdam.unfolding.utils.MapUtils;
//import de.fhpotsdam.unfolding.*;

import processing.core.PApplet;

public class testting_map extends PApplet {
	
     private UnfoldingMap map; // the map of type UnfoldinMap is created
     
     public void setup()
     {
    	 size (950, 600, OPENGL);    //set up ofcanvas
    	 map = new UnfoldingMap (this, 200, 50, 700, 500, new Google.GoogleMapProvider()); // constructor call on map object to set up map
    	// map.zoomLevel(2); //calling zoomlevel() method on object map to set default zoom level
    	 int zoomLevel = 7;
    	 MapUtils.createDefaultEventDispatcher(this, map); //this makes map interactive on mouse clicks
    	 
    	 Location valLoc = new Location (-38.14f, -73.03f);  // new object of data type location 
    	                                                     // is created and constructed by passing coordinates in lon and lat
    	 Location alaskaLoc = new Location (60.59f, -147.84f);
    	 Location sumatraLoc = new Location (-0.13f, 96.14f);
    	 Location japanLoc = new Location (38.31f, 140.62f);
    	 Location kamchtakaLoc = new Location (56.13f, 159.52f);
    	 
    	 Feature valEq = new PointFeature(valLoc);
    	 Feature sumatraEq = new PointFeature(sumatraLoc);
    	 Feature japanEq = new PointFeature(japanLoc);
    	 Feature alaskaEq = new PointFeature(alaskaLoc);
    	 Feature kamchtakaEq = new PointFeature(kamchtakaLoc);
    	
    	 List<PointFeature> bigEqs = new ArrayList<PointFeature>();
    	 bigEqs.add((PointFeature) valEq);
    	 bigEqs.add((PointFeature) alaskaEq);
    	 bigEqs.add((PointFeature) sumatraEq);
    	 bigEqs.add((PointFeature) japanEq);
    	 bigEqs.add((PointFeature) kamchtakaEq);
    	 

    	 
    	 
    	/* valEq.addProperty("title", "chile");
    	 valEq.addProperty("magnitude", "9.5");
    	 valEq.addProperty("date", "May 22, 1960"); */
    	 
    	 List<Marker> markers = new ArrayList<Marker>();
    	 
    	 for (PointFeature eq : bigEqs)
    	 {
    		 markers.add(new SimplePointMarker(eq.getLocation(), eq.getProperties()));
    	 }

    	// Marker valMk = new SimplePointMarker(valLoc, valEq.getProperties());         //create variable val in the object of type simplepointmarker
    	 //map.addMarker(valMk);	
    	 map.zoomAndPanTo(zoomLevel, new Location(38.31f, 140.62f));
    	 
     }
     
     public void draw()
     {
    	 background(10); //background color
    	 map.draw();    //refreshes all things associated with map object
    	 
     }
     
     
	

}
