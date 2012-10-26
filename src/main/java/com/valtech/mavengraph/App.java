package com.valtech.mavengraph;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.maven.model.Dependency;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        MavenXpp3Reader reader = new MavenXpp3Reader();
        
        FileInputStream in = null;
		try {
			in = new FileInputStream(new File("pom.xml"));
			Model model =reader.read(in);
			System.out.println(String.format("ArtifactId: %s, GroupId: %s, Version: %s, SCM: %s",
					model.getArtifactId(),
					model.getGroupId(),
					model.getVersion(),
					model.getScm() != null ? model.getScm().getConnection() : "None"));
			
			System.out.println("Dependencies: ");
			for (Dependency dep : model.getDependencies()) {
				System.out.println(String.format("ArtifactId: %s, GroupId: %s, Version: %s",
						dep.getArtifactId(), dep.getGroupId(), dep.getVersion()));
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (XmlPullParserException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(in != null) {
				in.close();
			}
		}
		
    }
}
