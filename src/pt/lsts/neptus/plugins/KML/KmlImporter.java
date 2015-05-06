/*
 * This class uses KML loading code available from
 * http://labs.micromata.de/projects/jak/download.html
 */
package pt.lsts.neptus.plugins.KML;

import java.io.File;
import java.util.List;

import org.mozilla.javascript.edu.emory.mathcs.backport.java.util.Collections;

import pt.lsts.neptus.mp.ManeuverLocation;
import pt.lsts.neptus.mp.maneuvers.Goto;
import pt.lsts.neptus.types.coord.LocationType;
import pt.lsts.neptus.types.mission.MissionType;
import pt.lsts.neptus.types.mission.plan.PlanType;
import de.micromata.opengis.kml.v_2_2_0.*;

public class KmlImporter {

    public static void main(String[] args) {
        
        MissionType mt = new MissionType();
        mt.setName("Douro Bathymetry");
        mt.setMissionFile(new File("/home/tiago/Desktop/Douro.nmis"));
        mt.save(false);
        Kml kml = Kml.unmarshal(new File("/home/tiago/Desktop/sonar_Douro_Abril2015.kml"));
        
        Document d = (Document)kml.getFeature();
        for (Feature f : d.getFeature()) {
            if (f instanceof Folder) {
                Folder folder = (Folder)f;
                for (Feature j : folder.getFeature()) {
                    if (j instanceof Placemark) {
                        LineString ls =(LineString) ((Placemark) j).getGeometry();
                        List<Coordinate> coords = ls.getCoordinates();
                        PlanType pt = new PlanType(mt);
                        pt.setId(j.getName());
                        pt.setVehicle("lauv-noptilus-1");
                        int count = 0;
                        
                        for (Coordinate coord : coords) {
                            count++;
                            Goto gt = new Goto();
                            gt.setId("pt"+count);                            
                            LocationType loc = new LocationType(coord.getLatitude(), coord.getLongitude());
                            ManeuverLocation mloc = new ManeuverLocation(loc);
                            mloc.setZUnits(ManeuverLocation.Z_UNITS.DEPTH);
                            mloc.setZ(0);
                            gt.setSpeed(1.3);
                            gt.setSpeedUnits("m/s");
                            gt.setManeuverLocation(mloc);
                            pt.getGraph().addManeuverAtEnd(gt);
                        }
                        mt.addPlan(pt);
                        Collections.reverse(coords);
                        pt = new PlanType(mt);
                        pt.setId(j.getName()+"_reversed");
                        pt.setVehicle("lauv-noptilus-1");
                        
                        count = 0;
                        for (Coordinate coord : coords) {
                            count++;
                            Goto gt = new Goto();
                            gt.setId("pt"+count);                            
                            LocationType loc = new LocationType(coord.getLatitude(), coord.getLongitude());
                            ManeuverLocation mloc = new ManeuverLocation(loc);
                            mloc.setZUnits(ManeuverLocation.Z_UNITS.DEPTH);
                            mloc.setZ(0);
                            gt.setSpeed(1.3);
                            gt.setSpeedUnits("m/s");
                            gt.setManeuverLocation(mloc);
                            pt.getGraph().addManeuverAtEnd(gt);
                        }
                        
                        mt.addPlan(pt);
                        mt.save(false);
                    }
                }
            }
            else
                System.out.println(f.getClass());
        }
    }
}
