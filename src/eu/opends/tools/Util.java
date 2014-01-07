/*
*  This file is part of OpenDS (Open Source Driving Simulator).
*  Copyright (C) 2013 Rafael Math
*
*  OpenDS is free software: you can redistribute it and/or modify
*  it under the terms of the GNU General Public License as published by
*  the Free Software Foundation, either version 3 of the License, or
*  (at your option) any later version.
*
*  OpenDS is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
*  GNU General Public License for more details.
*
*  You should have received a copy of the GNU General Public License
*  along with OpenDS. If not, see <http://www.gnu.org/licenses/>.
*/

package eu.opends.tools;

import java.awt.Desktop;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.jme3.material.RenderState.FaceCullMode;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.Spatial;

/**
 * 
 * @author Rafael Math
 */
public class Util 
{
    public static Geometry findGeom(Spatial spatial, String name) 
    {
        if (spatial instanceof Node) 
        {
            Node node = (Node) spatial;
            for (int i = 0; i < node.getQuantity(); i++) 
            {
                Spatial child = node.getChild(i);
                Geometry result = findGeom(child, name);
                if (result != null)
                    return result;
            }
        } else if (spatial instanceof Geometry) 
        {
            if (spatial.getName().startsWith(name))
                return (Geometry) spatial;
        }
        return null;
    }
    
    
    public static Node findNode(Spatial spatial, String name) 
    {
        if (spatial instanceof Node) 
        {
            Node node = (Node) spatial;
            
            if (node.getName().startsWith(name))
            	return (Node) spatial;
            
            for (int i = 0; i < node.getQuantity(); i++) 
            {
                Spatial child = node.getChild(i);
                Node result = findNode(child, name);
                if (result != null)
                    return result;
            }
        }
        return null;
    }
    
    
    public static String printTree(Spatial spatial) 
    {
        if (spatial instanceof Node) 
        {
            Node node = (Node) spatial;
            String resultList = "";
            for (int i = 0; i < node.getQuantity(); i++)
            {
                Spatial child = node.getChild(i);
                String result = printTree(child);
                resultList = resultList + result + "  ";
            }
            return resultList;
            
        } else if (spatial instanceof Geometry) 
        {
        	return spatial.getName();
        }
        return null;
    }


    private static List<Geometry> resultList = new ArrayList<Geometry>();
    
	private static void collectGeometries(Spatial spatial) 
	{
        if (spatial instanceof Node) 
        {
            Node node = (Node) spatial;
            for (int i = 0; i < node.getQuantity(); i++) 
            {
                Spatial child = node.getChild(i);
                collectGeometries(child);
            }
        } 
        else if (spatial instanceof Geometry) 
        {
        	resultList.add((Geometry) spatial);
        }
	}
	
	public static List<Geometry> getAllGeometries(Spatial spatial)
	{
		resultList.clear();
		collectGeometries(spatial);
		return resultList;
	}
	
	
	public static void setFaceCullMode(Spatial spatial, FaceCullMode mode)
	{
		List<Geometry> geometryList = getAllGeometries(spatial);
    	for(Geometry geometry : geometryList)
    		geometry.getMaterial().getAdditionalRenderState().setFaceCullMode(mode);
	}
	
	public static void setWireFrame(Spatial spatial, boolean enable)
	{
		List<Geometry> geometryList = getAllGeometries(spatial);
    	for(Geometry geometry : geometryList)
    		geometry.getMaterial().getAdditionalRenderState().setWireframe(enable);
	}
    
	public static void open(String fileName)
	{  	  
	  	  try {
	   
	  		File file = new File(fileName);
	  		if (file.exists())
	  		{
	  			if (Desktop.isDesktopSupported()) 
	  			{
	  				Desktop.getDesktop().open(file);
	  			} else 
	  			{
	  				System.err.println("Awt Desktop is not supported!");
	  			}
	   
	  		} else {
	  			System.err.println("File does not exist!");
	  		}
	   
	  	  } catch (Exception ex) {
	  		  
	  		ex.printStackTrace();
	  	  }
	}


	public static String getDateTimeString() 
	{
		Calendar cal = Calendar.getInstance();
		DecimalFormat form = new DecimalFormat("00");
		String str = Integer.toString(cal.get(Calendar.YEAR)) + "_"
				+ form.format(cal.get(Calendar.MONTH) + 1) + "_"
				+ form.format(cal.get(Calendar.DAY_OF_MONTH)) + "-"
				+ form.format(cal.get(Calendar.HOUR_OF_DAY)) + "_"
				+ form.format(cal.get(Calendar.MINUTE)) + "_"
				+ form.format(cal.get(Calendar.SECOND));
		return str;
	}


	/**
	 * Makes the given directory if it not yet exists.
	 */
	public static void makeDirectory(String directory) 
	{
		File dir = new File(directory);
		
		if (!dir.exists())
			dir.mkdir();
		else if (!dir.isDirectory())
			System.err.println("'" + directory + "' exists but is not a directory");		
	}
    
}
